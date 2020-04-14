package com.fea.project.service.user;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.user.ProjectUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.publish.GenderEnum;
import com.fea.project.enums.team.ProjectDefaultRoleEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.milestone.vo.UserListTeamVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.model.user.vo.UserWithJobVo;
import com.fea.project.service.role.ProjectRoleService;
import com.fea.project.service.role.ProjectRoleUserService;
import com.fea.project.service.team.ProjectTeamService;
import com.fea.project.service.team.ProjectTeamUserService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/09/29.
 */
@Service
public class ProjectUserService {

    @Autowired
    private ProjectUserMapper projectUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectTeamUserService projectTeamUserService;

    @Autowired
    private ProjectRoleUserService projectRoleUserService;

    @Autowired
    private ProjectTeamService projectTeamService;

    @Autowired
    private ProjectRoleService projectRoleService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectUserModel model) {
        return model != null && this.projectUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectUserMapper.insertList(list);
            }
        } else {
            return this.projectUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectUserModel model) {
        return model != null && this.projectUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectUserModel selectById(Long id) {
        return id == null ? null : this.projectUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectUserModel> selectByModel(ProjectUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectUserModel model) {
        return !(model == null || model.getId() == null) && this.projectUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectUserModel model) {
        return !(model == null || model.getId() == null) && this.projectUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectUserModel model) {
        return !(model == null || model.getId() == null) && this.projectUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectUserMapper.insert(model) == 1;
        }
        return this.projectUserMapper.updateById(model) == 1;
    }

    public Boolean deleteByProjectId(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("传入的项目id无效,无法进行人员信息变更");
        }
        return this.projectUserMapper.deleteByProjectId(projectId) >= 0;
    }

    public List<SysUserModel> listByProjectId(ProjectUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("获取项目参与人列表，参数异常");
        }
        List<Long> list = this.projectUserMapper.selectByProjectId(model.getProjectId());
        return this.sysUserService.selectByIds(list);
    }

    public List<ProjectUserVo> selectByProjectIdAndUserStatus(Long projectId, List<Integer> projectUserStatus) {
        if (projectId == null || ListUtil.isNullOrEmpty(projectUserStatus)) {
            throw new SystemParamCheckException("传入的项目id或是项目状态异常，无法进行查询");
        }
        List<ProjectUserVo> projectUserVos = this.projectUserMapper.selectByProjectIdAndUserStatus(projectId, projectUserStatus);
        List<Long> userIds = projectUserVos.stream().map(ProjectUserModel::getUserId).collect(Collectors.toList());
        Map<Long, String> map = this.sysUserService.selectByIds(userIds).stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        projectUserVos.forEach(tmp -> {
            tmp.setName(map.get(tmp.getUserId()));
            tmp.setGender(tmp.getGender());
        });
        return projectUserVos;
    }

    public List<ProjectUserModel> selectProjectUsersByTeamId(Long teamId) {
        if (teamId == null) {
            throw new SystemParamCheckException("传入的团队id异常，无法进行查询");
        }
        return this.projectUserMapper.selectProjectUsersByTeamId(teamId);
    }

    public List<SysUserModel> selectUserListByProjectId(ProjectUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        List<ProjectUserVo> list = this.projectUserMapper.selectProjectUsersByProjectId(model.getProjectId());
        List<Long> userIds = list.stream().map(ProjectUserVo::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }

    public boolean updateUserStatusDelete(List<Long> projectUserIds) {
        if (ListUtil.isNullOrEmpty(projectUserIds)) {
            return true;
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectUserModel projectUserModel = new ProjectUserModel();
        projectUserModel.setStatus(UserStatusEnum.TYPE_DELETE.getValue());
        projectUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectUserMapper.updateByUserIdsAndStatus(projectUserModel, projectUserIds) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("项目用户数据，从项目组删除异常");
    }


    public boolean updateUserToRemoveStatusByProjectTeamUserIds(List<Long> ids, SysUserModel sysUserModel) {
        if (ListUtil.isNullOrEmpty(ids)) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员状态变更");
        }
        ProjectUserModel projectUserModel = new ProjectUserModel();
        projectUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectUserModel.setStatus(UserStatusEnum.TYPE_LEAVE.getValue());
        return this.projectUserMapper.updateByModelAndProjectTeamUserIds(projectUserModel, ids) >= 0;
    }

    public boolean updateUserToStandardStatusByProjectTeamUserIds(List<Long> ids, SysUserModel sysUserModel) {
        if (ListUtil.isNullOrEmpty(ids)) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员状态变更");
        }
        ProjectUserModel projectUserModel = new ProjectUserModel();
        projectUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectUserModel.setStatus(UserStatusEnum.TYPE_NORMAL.getValue());
        return this.projectUserMapper.updateByModelAndProjectTeamUserIds(projectUserModel, ids) >= 0;
    }

    public List<ProjectUserVo> selectProjectUsersByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("团队角色id传入异常，无法进行人员查询");
        }
        return this.projectUserMapper.selectProjectUsersByRoleId(roleId);
    }

    public List<ProjectUserModel> listUnRoleTeamUsers(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        return this.projectUserMapper.listUnRoleTeamUsers(projectId);
    }

    public List<SysUserModel> selectUnGroupUserListByProjectId(ProjectUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        List<Long> userIds = this.projectUserMapper.selectUnGroupUserByProjectId(model.getProjectId()
                , ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName()).stream().map(ProjectUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }
    /**
     * 获取项目下的人员列表及其所属团队
     */
    public List<UserListTeamVo> userListTeamByProjectId(ProjectUserModel model){
        List<UserListTeamVo> userListTeamVos = projectUserMapper.selectUserListTeamByProjectId(model.getProjectId());
        List<Long> collect = userListTeamVos.stream().map(UserListTeamVo::getUserId).collect(Collectors.toList());
        List<SysUserModel> sysUserModels = sysUserService.selectByIds(collect);
        Map<Long, SysUserModel> map = new HashMap<>();
        sysUserModels.forEach(userModel ->{
            map.put(userModel.getUserId(),userModel);
        });
        List<UserListTeamVo> finalList = new ArrayList<>();
        userListTeamVos.forEach(vo ->{
            if (vo.getUserId()!=0L){
                vo.setRealName(map.get(vo.getUserId()).getRealName());
                finalList.add(vo);
            }
        });
        return finalList;
    }


    public List<UserListTeamVo> getUserListTeamVos(List<UserListTeamVo> userListTeamVos) {
        List<Long> userIds = userListTeamVos.stream().map(UserListTeamVo::getUserId).collect(Collectors.toList());
        List<SysUserModel> sysUserModels = sysUserService.selectByIds(userIds);
        Map<Long, SysUserModel> map = new HashMap<>();
        sysUserModels.forEach(userModel ->{
            map.put(userModel.getUserId(),userModel);
        });
        userListTeamVos.forEach(vo ->{
            vo.setRealName(map.get(vo.getUserId()).getRealName());
        });
        return userListTeamVos;
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean insertList(List<ProjectUserModel> list, ProjectModel projectModel) {
        if (projectModel.getId() == null || list == null) {
            throw new SystemParamCheckException("参数传入异常，人员信息添加失败");
        }
        Long projectId = projectModel.getId();
        list.forEach(x -> x.setProjectId(projectId));
        if (this.insertList(list)) {
            return true;
        }
        return false;
    }

    public List<ProjectUserModel> selectByProjectIdAndUserIds(Long projectId, List<Long> userIds) {
        if (projectId == null || userIds == null) {
            throw new SystemParamCheckException("项目信息或是人员信息传入异常，无法获取项目人员信息")
                    .appendAlaramMsg("projectId:" + projectId + " userIds:" + JSON.toJSONString(userIds));
        }
        return this.projectUserMapper.selectByProjectIdAndUserIds(projectId, userIds);
    }


    public Map<Long, String> selectUserByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的项目用户id异常，无法进行查询");
        }
        List<ProjectUserModel> list = this.projectUserMapper.selectByIds(ids);
        Map<Long, Long> map = list.stream().collect(Collectors.toMap(ProjectUserModel::getUserId, ProjectUserModel::getId));
        List<SysUserModel> sysUserModels = this.sysUserService.selectByIds(list.stream().map(ProjectUserModel::getUserId).collect(Collectors.toList()));
        Map<Long, String> finalMap = new HashMap<>();
        sysUserModels.forEach(x -> finalMap.put(map.get(x.getUserId()), x.getRealName()));
        return finalMap;
    }

    public List<Long> selectUserIdsByIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("传入的参数异常,无法进行人员信息查询");
        }
        return this.projectUserMapper.selectByIds(list).stream().map(ProjectUserModel::getUserId).distinct().collect(Collectors.toList());
    }

    public List<ProjectUserModel> selectProjectUsersByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行查询");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.projectUserMapper.selectProjectUsersByRoleIds(roleIds);
    }
    



    @Transactional(rollbackFor = Exception.class)
    public void changeLeader(Long projectId, Long oldLeader, Long newLeader) {
        if(projectId == null){
            throw new SystemParamCheckException("传入的项目id异常");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        if(!Objects.isNull(oldLeader)){
            //移除原始的负责人数据
            List<ProjectUserModel> projectUserModels = this.projectUserMapper.selectByProjectIdAndUserIds(projectId, Stream.of(oldLeader).collect(Collectors.toList()));
            if(projectUserModels.size() > 1){
                throw new SystemParamCheckException("人员信息表中数据异常，存在同一项目，人员信息重复添加");
            }
            if(projectUserModels.size() == 1){
                ProjectUserModel projectUserModel = projectUserModels.get(0);
                projectUserModel.setStatus(UserStatusEnum.TYPE_DELETE.getValue());
                projectUserModel.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
                ProjectTeamUserModel projectTeamUserModel = ProjectTeamUserModel.createProjectTeamUserModel(projectUserModel.getId(), userModel, DeleteStatusEnum.DELETE.getStatus());
                ProjectRoleUserModel projectRoleUserModel = ProjectRoleUserModel.createProjectRoleUserModel(projectUserModel.getId(), userModel, DeleteStatusEnum.DELETE.getStatus());
                this.projectUserMapper.updateByIdSelective(projectUserModel);
                this.projectTeamUserService.updateDeleteByModelAndProjectId(projectTeamUserModel, projectId);
                this.projectRoleUserService.updateDeleteByModelAndProjectId(projectRoleUserModel, projectId);
            }
        }
        //添加新的负责人
        ProjectTeamModel rootTeam = projectTeamService.selectTeamByProjectIdAndShortName(projectId, ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName());
        ProjectRoleModel adminRole = projectRoleService.selectRoleByProjectIdAndShortName(projectId, ProjectDefaultRoleEnum.TYPE_PROJECT_ADMIN.getShortName());
        ProjectUserModel projectUserModel = new ProjectUserModel(newLeader, projectId, userModel);
        if(projectUserMapper.insertSelective(projectUserModel) >= 0){
            ProjectTeamUserModel projectTeamUserModel = new ProjectTeamUserModel(projectUserModel, rootTeam.getId(), userModel);
            ProjectRoleUserModel projectRoleUserModel = new ProjectRoleUserModel(projectUserModel, adminRole.getId(), userModel);
            if(this.projectRoleUserService.insertSelective(projectRoleUserModel)
                    && this.projectTeamUserService.insertSelective(projectTeamUserModel)){
                return;
            }
        }
        throw new SystemParamCheckException("新负责人插入异常");
    }

    public List<Long> selectUserIdsByProjectId(Long projectId) {
        if(projectId == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        return this.projectUserMapper.selectByProjectId(projectId);
    }

    public List<SysUserModel> selectNormalUserListByProjectId(ProjectEstablishUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("获取项目参与人列表，参数异常");
        }
        List<Long> list = this.projectUserMapper.selectNormalUserListByProjectId(model.getProjectId()).stream().map(ProjectUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(list);
    }
}