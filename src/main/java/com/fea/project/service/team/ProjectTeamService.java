package com.fea.project.service.team;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.team.ProjectTeamMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.projectdata.ProjectTeamTreeVo;
import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.team.pojo.ProjectTeamPojo;
import com.fea.project.model.team.vo.ProjectTeamVo;
import com.fea.project.model.team.vo.TeamPageLeftTeamVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.NumberUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectTeamService {

    @Autowired
    private ProjectTeamMapper projectTeamMapper;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectTeamUserService projectTeamUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectTeamMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectTeamMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectTeamModel model) {
        return model != null && this.projectTeamMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectTeamModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectTeamModel> list : ListUtil.getSubList(models, 100)) {
                this.projectTeamMapper.insertList(list);
            }
        } else {
            return this.projectTeamMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectTeamModel model) {
        return model != null && this.projectTeamMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectTeamModel selectById(Long id) {
        return id == null ? null : this.projectTeamMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectTeamModel> selectByModel(ProjectTeamModel model) {
        return model == null ? new ArrayList<>(0) : this.projectTeamMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectTeamModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectTeamMapper.insert(model) == 1;
        }
        return this.projectTeamMapper.updateById(model) == 1;
    }

    public Long insertProjectRootTeam(SysUserModel sysUserModel, ProjectModel projectModel) {
        ProjectTeamModel projectTeamModel = new ProjectTeamModel(sysUserModel, projectModel, ActionEnum.INSERT_ACTION);
        if (this.projectTeamMapper.insertSelective(projectTeamModel) >= 0) {
            return projectTeamModel.getId();
        }
        throw new SystemParamCheckException("创建项目时，项目根团队数据创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public Long insertInitTeamsAndReturnUnGroupQueue(ProjectModel projectModel, SysUserModel sysUserModel, Long rootId) {
        List<ProjectTeamModel> teams = ProjectDefaultTeamEnum.initSysTeam();
        Long leadId = projectModel.getLeader();
        Long projectId = projectModel.getId();
        teams.forEach(tmp -> {
            tmp.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            tmp.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            tmp.setLeader(leadId);
            tmp.setRegId(sysUserModel.getRegId());
            tmp.setProjectId(projectId);
            tmp.setParentId(rootId);
        });
        if (this.projectTeamMapper.insertList(teams) >= 0) {
            return teams.stream().filter(tmp -> ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName().equals(tmp.getShortName())).map(ProjectTeamModel::getId).findFirst().get();
        }
        throw new SystemParamCheckException("创建初始项目团队报错");
    }



    public TeamPageLeftTeamVo listByProjectId(ProjectTeamPojo projectTeamModel) {
        if (projectTeamModel == null || projectTeamModel.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id无效");
        }
        List<ProjectTeamModel> notSysTeams = this.projectTeamMapper.selectListByShortNameNullAndProjectId(projectTeamModel.getProjectId());
        List<ProjectUserModel> removeUsers = this.projectUserService.selectByModel(new ProjectUserModel(projectTeamModel.getProjectId(), UserStatusEnum.TYPE_LEAVE.getValue()));
        if (notSysTeams.isEmpty() && removeUsers.isEmpty()) {
            projectTeamModel.setShortName(ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName());
            List<ProjectTeamModel> projectTeamModels = this.projectTeamMapper.selectByModel(projectTeamModel);
            if (projectTeamModels.size() != 1) {
                throw new SystemParamCheckException("项目团队根节点不存在，请刷新后重试");
            }
            ProjectTeamVo projectTeamVo = new ProjectTeamVo(projectTeamModels.get(0));
            List<ProjectUserVo> projectUserModels = this.projectUserService.selectByProjectIdAndUserStatus(projectTeamModel.getProjectId(), UserStatusEnum.getProjectUserStatus());
            projectUserModels.forEach(tmp -> tmp.setParentId(projectTeamVo.getId()));
            projectTeamVo.setProjectUserVos(projectUserModels);
            return TeamPageLeftTeamVo.translateProjectTeamVo(Stream.of(projectTeamVo).collect(Collectors.toList()));
        } else {
            //查询所有的组
            List<ProjectTeamVo> projectTeamVos = this.projectTeamMapper.selectProjectId(projectTeamModel.getProjectId());
            if (Objects.equals(Boolean.TRUE, projectTeamModel.getNoRemoveGroup())) {
                projectTeamVos = projectTeamVos.stream().filter(x -> !Objects.equals(x.getShortName(), ProjectDefaultTeamEnum.TYPE_REMOVE_QUEUE.getShortName()))
                        .collect(Collectors.toList());
            }
            Set<Long> userIds = new HashSet<>();
            projectTeamVos.forEach(tmp -> {
                userIds.add(tmp.getLeader());
                tmp.getProjectUserVos().forEach(tmpUser -> userIds.add(tmpUser.getUserId()));
            });
            Map<Long, SysUserModel> userMap = this.sysUserService.selectByIds(new ArrayList<>(userIds)).stream().collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
            projectTeamVos.forEach(tmp -> {
                SysUserModel tmpModel = userMap.get(tmp.getLeader());
                tmp.setLeadName(tmpModel == null ? null : tmpModel.getRealName());
                tmp.getProjectUserVos().forEach(tmpUser -> {
                    SysUserModel sysUserModel = userMap.get(tmpUser.getUserId());
                    tmpUser.setName(sysUserModel == null ? null : sysUserModel.getRealName());
                    tmpUser.setGender(sysUserModel == null ? null : sysUserModel.getGender());
                });
            });
            return TeamPageLeftTeamVo.translateProjectTeamVo(projectTeamVos);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamModel insertModel(ProjectTeamModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setRegId(sysUserModel.getRegId());
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setIndex(ProjectDefaultTeamEnum.getDefaultIndex());
        model.setCanDelete(EnableStatusEnum.ENABLE.getStatus());
        if (this.projectTeamMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamModel updateModel(ProjectTeamModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectTeamMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamModel deleteModel(ProjectTeamModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目团队删除失败");
        }
        //参数检查
        ProjectTeamModel tmp = this.projectTeamMapper.selectById(model.getId());
        if (tmp == null || EnableStatusEnum.DISABLE.getStatus().equals(tmp.getCanDelete())) {
            throw new SystemParamCheckException("该团队属于系统内置无法进行删除");
        }

        List<ProjectTeamUserModel> projectTeamUserModels = this.projectTeamUserService.selectByModel(new ProjectTeamUserModel(model.getId()));
        if (!projectTeamUserModels.isEmpty()) {
            throw new SystemParamCheckException("该团队下存在人员，请先进行人员退出，再进行团队删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectTeamMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队删除失败");
    }

    public ProjectTeamVo selectTeamByTeamId(ProjectTeamModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目团队查询，传入参数报错");
        }
        ProjectTeamModel projectTeamModel = this.projectTeamMapper.selectById(model.getId());
        SysUserModel sysUserModel = this.sysUserService.selectById(projectTeamModel.getLeader());
        ProjectTeamVo projectTeamVo = new ProjectTeamVo(projectTeamModel);
        projectTeamVo.setLeadName(sysUserModel == null ? null : sysUserModel.getRealName());
        return projectTeamVo;
    }

    public ProjectTeamModel selectUngroupTeamByOrdernaryTeamUserId(Long projectTeamUserPkId) {
        if (projectTeamUserPkId == null) {
            throw new SystemParamCheckException("传入的人员信息异常，数据无法查询");
        }
        return this.projectTeamMapper.selectUngroupTeamByOrdernaryTeamUserId(projectTeamUserPkId
                , ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName());

    }

    public ProjectTeamModel selectRemoveTeamByOrdernaryTeamUserId(Long projectTeamUserPkId) {
        if (projectTeamUserPkId == null) {
            throw new SystemParamCheckException("传入的人员信息异常，数据无法查询");
        }
        return this.projectTeamMapper.selectUngroupTeamByOrdernaryTeamUserId(projectTeamUserPkId
                , ProjectDefaultTeamEnum.TYPE_REMOVE_QUEUE.getShortName());
    }

    public ProjectTeamModel selectTeamByProjectIdAndShortName(Long projectId, String shortName) {
        if (projectId == null || StringUtil.isEmpty(shortName)) {
            throw new SystemParamCheckException("项目id或是团队类型简称，传入异常，无法进行查询");
        }
        return this.projectTeamMapper.selectTeamByProjectIdAndShortName(projectId, shortName);
    }
    /**
     * 获取指定项目id下我所负责的团队及下属团队
     */
    public List<ProjectTeamTreeVo> getLeaderTeamByProjectIdAndLeaderId(Long projectId){
        return projectTeamMapper.getLeaderTeamByProjectIdAndLeaderId(projectId, null);
    }

    /**
     * 获取指定teamid下的userid集合
     */
    public List<Long> getLeaderTeamUserByTeamId(Long teamId){
        List<Long> leaderTeamByProjectIdAndLeaderId =
                projectTeamMapper.getLeaderTeamUserByTeamId(teamId);
        return leaderTeamByProjectIdAndLeaderId;
    }

    /**
     *
     *
     */
    public ProjectTeamModel getTeamByProjectIdAndUserId(Long projectId,Long userId){
        ProjectTeamModel teamModel = projectTeamMapper.getTeamByProjectIdAndUserId(projectId, userId);
        return teamModel;
    }

    public List<ProjectTeamModel> selectStandardTeamModels(Long projectId) {
        if(projectId == null){
            throw new SystemParamCheckException("项目id异常，无法进行查询");
        }
        return this.projectTeamMapper.selectStandardTeamModels(projectId);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Long> exchangeTeamIndex(List<Long> ids) {
        if(ListUtil.isNullOrEmpty(ids) || ids.size() != NumberUtil.SIZE_TWO){
            throw new SystemParamCheckException("传入的队列id异常，无法进行操作");
        }
        List<ProjectTeamModel> projectTeamModels = this.projectTeamMapper.selectByIds(ids);
        if(projectTeamModels.size() != ids.size()){
            throw new SystemParamCheckException("传入的队列id查询异常，请刷新后重试");
        }
        if(!Objects.equals(projectTeamModels.get(0).getProjectId(), projectTeamModels.get(1).getProjectId())){
            throw new SystemParamCheckException("当前队列归属于不同的项目，无法调整顺序");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectTeamModel> actionList = ProjectTeamModel.createExchangeIndexList(projectTeamModels, userModel);
        actionList.forEach(x -> this.projectTeamMapper.updateByIdSelective(x));
        return ids;
    }
}