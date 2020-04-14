package com.fea.project.service.establishproject.team;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.team.ProjectEstablishTeamMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamPojo;
import com.fea.project.model.establishproject.vo.EstablishTeamPageLeftTeamVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishProjectVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishUserVo;
import com.fea.project.model.projectdata.ProjectTeamTreeVo;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
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
public class ProjectEstablishTeamService {

    @Autowired
    private ProjectEstablishTeamMapper projectEstablishTeamMapper;

    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectEstablishTeamUserService projectEstablishTeamUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishTeamMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishTeamMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishTeamModel model) {
        return model != null && this.projectEstablishTeamMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishTeamModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishTeamModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishTeamMapper.insertList(list);
            }
        } else {
            return this.projectEstablishTeamMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishTeamModel model) {
        return model != null && this.projectEstablishTeamMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishTeamModel selectById(Long id) {
        return id == null ? null : this.projectEstablishTeamMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishTeamModel> selectByModel(ProjectEstablishTeamModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishTeamMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishTeamModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishTeamModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishTeamMapper.insert(model) == 1;
        }
        return this.projectEstablishTeamMapper.updateById(model) == 1;
    }

    public Long insertProjectRootTeam(SysUserModel sysUserModel, ProjectEstablishProjectVo projectEstablishProjectVo, String projectName) {
        ProjectEstablishTeamModel projectEstablishTeamModel = new ProjectEstablishTeamModel(sysUserModel, projectEstablishProjectVo, ActionEnum.INSERT_ACTION, projectName);
        if (this.projectEstablishTeamMapper.insertSelective(projectEstablishTeamModel) >= 0) {
            return projectEstablishTeamModel.getId();
        }
        throw new SystemParamCheckException("创建项目时，项目根团队数据创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public Long insertInitTeamsAndReturnUnGroupQueue(ProjectEstablishProjectVo projectEstablishProjectVo, SysUserModel sysUserModel, Long rootId) {
        List<ProjectEstablishTeamModel> teams = ProjectDefaultTeamEnum.initEstablishSysTeam();
        Long leadId = projectEstablishProjectVo.getEstablishLeader();
        Long projectId = projectEstablishProjectVo.getProjectId();
        teams.forEach(tmp -> {
            tmp.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            tmp.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            tmp.setLeader(leadId);
            tmp.setRegId(sysUserModel.getRegId());
            tmp.setProjectId(projectId);
            tmp.setParentId(rootId);
        });
        if (this.projectEstablishTeamMapper.insertList(teams) >= 0) {
            return teams.stream().filter(tmp -> ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName().equals(tmp.getShortName())).map(ProjectEstablishTeamModel::getId).findFirst().get();
        }
        throw new SystemParamCheckException("创建初始项目团队报错");
    }



    public EstablishTeamPageLeftTeamVo listByProjectId(ProjectEstablishTeamPojo projectEstablishTeamPojo) {
        if (projectEstablishTeamPojo == null || projectEstablishTeamPojo.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id无效");
        }
        List<ProjectEstablishTeamModel> notSysTeams = this.projectEstablishTeamMapper.selectListByShortNameNullAndProjectId(projectEstablishTeamPojo.getProjectId());
        List<ProjectEstablishUserModel> removeUsers = this.projectEstablishUserService.selectByModel(new ProjectEstablishUserModel(projectEstablishTeamPojo.getProjectId(), UserStatusEnum.TYPE_LEAVE.getValue()));
        if (notSysTeams.isEmpty() && removeUsers.isEmpty()) {
            projectEstablishTeamPojo.setShortName(ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName());
            List<ProjectEstablishTeamModel> projectEstablishTeamModels = this.projectEstablishTeamMapper.selectByModel(projectEstablishTeamPojo);
            if (projectEstablishTeamModels.size() != 1) {
                throw new SystemParamCheckException("项目团队根节点不存在，请刷新后重试");
            }
            ProjectEstablishTeamVo projectEstablishTeamVo = new ProjectEstablishTeamVo(projectEstablishTeamModels.get(0));
            List<ProjectEstablishUserVo> projectEstablishUserVos = this.projectEstablishUserService.selectByProjectIdAndUserStatus(projectEstablishTeamPojo.getProjectId(), UserStatusEnum.getProjectUserStatus());
            projectEstablishUserVos.forEach(tmp -> tmp.setParentId(projectEstablishTeamVo.getId()));
            projectEstablishTeamVo.setProjectUserVos(projectEstablishUserVos);
            return EstablishTeamPageLeftTeamVo.translateProjectTeamVo(Stream.of(projectEstablishTeamVo).collect(Collectors.toList()));
        } else {
            //查询所有的组
            List<ProjectEstablishTeamVo> projectEstablishTeamVos = this.projectEstablishTeamMapper.selectProjectId(projectEstablishTeamPojo.getProjectId());
            if (Objects.equals(Boolean.TRUE, projectEstablishTeamPojo.getNoRemoveGroup())) {
                projectEstablishTeamVos = projectEstablishTeamVos.stream().filter(x -> !Objects.equals(x.getShortName(), ProjectDefaultTeamEnum.TYPE_REMOVE_QUEUE.getShortName()))
                        .collect(Collectors.toList());
            }
            Set<Long> userIds = new HashSet<>();
            projectEstablishTeamVos.forEach(tmp -> {
                userIds.add(tmp.getLeader());
                tmp.getProjectUserVos().forEach(tmpUser -> userIds.add(tmpUser.getUserId()));
            });
            Map<Long, SysUserModel> userMap = this.sysUserService.selectByIds(new ArrayList<>(userIds)).stream().collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
            projectEstablishTeamVos.forEach(tmp -> {
                SysUserModel tmpModel = userMap.get(tmp.getLeader());
                tmp.setLeadName(tmpModel == null ? null : tmpModel.getRealName());
                tmp.getProjectUserVos().forEach(tmpUser -> {
                    SysUserModel sysUserModel = userMap.get(tmpUser.getUserId());
                    tmpUser.setName(sysUserModel == null ? null : sysUserModel.getRealName());
                    tmpUser.setGender(sysUserModel == null ? null : sysUserModel.getGender());
                });
            });
            return EstablishTeamPageLeftTeamVo.translateProjectTeamVo(projectEstablishTeamVos);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamModel insertModel(ProjectEstablishTeamModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setRegId(sysUserModel.getRegId());
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setIndex(ProjectDefaultTeamEnum.getDefaultIndex());
        model.setCanDelete(EnableStatusEnum.ENABLE.getStatus());
        if (this.projectEstablishTeamMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamModel updateModel(ProjectEstablishTeamModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectEstablishTeamMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamModel deleteModel(ProjectEstablishTeamModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目团队删除失败");
        }
        //参数检查
        ProjectEstablishTeamModel tmp = this.projectEstablishTeamMapper.selectById(model.getId());
        if (tmp == null || EnableStatusEnum.DISABLE.getStatus().equals(tmp.getCanDelete())) {
            throw new SystemParamCheckException("该团队属于系统内置无法进行删除");
        }

        List<ProjectEstablishTeamUserModel> projectEstablishTeamUserModels = this.projectEstablishTeamUserService.selectByModel(new ProjectEstablishTeamUserModel(model.getId()));
        if (!projectEstablishTeamUserModels.isEmpty()) {
            throw new SystemParamCheckException("该团队下存在人员，请先进行人员退出，再进行团队删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectEstablishTeamMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目团队删除失败");
    }

    public ProjectEstablishTeamVo selectTeamByTeamId(ProjectEstablishTeamModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目团队查询，传入参数报错");
        }
        ProjectEstablishTeamModel projectEstablishTeamModel = this.projectEstablishTeamMapper.selectById(model.getId());
        SysUserModel sysUserModel = this.sysUserService.selectById(projectEstablishTeamModel.getLeader());
        ProjectEstablishTeamVo projectEstablishTeamVo = new ProjectEstablishTeamVo(projectEstablishTeamModel);
        projectEstablishTeamVo.setLeadName(sysUserModel == null ? null : sysUserModel.getRealName());
        return projectEstablishTeamVo;
    }

    public ProjectEstablishTeamModel selectUngroupTeamByOrdernaryTeamUserId(Long projectTeamUserPkId) {
        if (projectTeamUserPkId == null) {
            throw new SystemParamCheckException("传入的人员信息异常，数据无法查询");
        }
        return this.projectEstablishTeamMapper.selectUngroupTeamByOrdernaryTeamUserId(projectTeamUserPkId
                , ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName());

    }

    public ProjectEstablishTeamModel selectRemoveTeamByOrdernaryTeamUserId(Long projectTeamUserPkId) {
        if (projectTeamUserPkId == null) {
            throw new SystemParamCheckException("传入的人员信息异常，数据无法查询");
        }
        return this.projectEstablishTeamMapper.selectUngroupTeamByOrdernaryTeamUserId(projectTeamUserPkId
                , ProjectDefaultTeamEnum.TYPE_REMOVE_QUEUE.getShortName());
    }

    public ProjectEstablishTeamModel selectUngroupTeamByProjectIdAndShortName(Long projectId, String shortName) {
        if (projectId == null || StringUtil.isEmpty(shortName)) {
            throw new SystemParamCheckException("项目id或是团队类型简称，传入异常，无法进行查询");
        }
        return this.projectEstablishTeamMapper.selectUngroupTeamByProjectIdAndShortName(projectId, shortName);
    }
    /**
     * 获取指定项目id下我所负责的团队及下属团队
     */
    public List<ProjectTeamTreeVo> getLeaderTeamByProjectIdAndLeaderId(Long projectId){
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        return projectEstablishTeamMapper.getLeaderTeamByProjectIdAndLeaderId(projectId, sysUserModel.getUserId());
    }

    /**
     * 获取指定teamid下的userid集合
     */
    public List<Long> getLeaderTeamUserByTeamId(Long teamId){
        return projectEstablishTeamMapper.getLeaderTeamUserByTeamId(teamId);
    }

    /**
     *
     *
     */
    public ProjectEstablishTeamModel getTeamByProjectIdAndUserId(Long projectId,Long userId){
        return projectEstablishTeamMapper.getTeamByProjectIdAndUserId(projectId, userId);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Long> exchangeTeamIndex(List<Long> ids) {
        if(ListUtil.isNullOrEmpty(ids) || ids.size() != NumberUtil.SIZE_TWO){
            throw new SystemParamCheckException("传入的队列id异常，无法进行操作");
        }
        List<ProjectEstablishTeamModel> projectEstablishTeamModels = this.projectEstablishTeamMapper.selectByIds(ids);
        if(projectEstablishTeamModels.size() != ids.size()){
            throw new SystemParamCheckException("传入的队列id查询异常，请刷新后重试");
        }
        if(!Objects.equals(projectEstablishTeamModels.get(0).getProjectId(), projectEstablishTeamModels.get(1).getProjectId())){
            throw new SystemParamCheckException("当前队列归属于不同的项目，无法调整顺序");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectEstablishTeamModel> actionList = ProjectEstablishTeamModel.createExchangeIndexList(projectEstablishTeamModels, userModel);
        actionList.forEach(x -> this.projectEstablishTeamMapper.updateByIdSelective(x));
        return ids;
    }
}