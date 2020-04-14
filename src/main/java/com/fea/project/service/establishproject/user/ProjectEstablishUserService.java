package com.fea.project.service.establishproject.user;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.user.ProjectEstablishUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.enums.user.UserStatusEnum;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishUserVo;
import com.fea.project.model.milestone.vo.UserListTeamVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/29.
 */
@Service
public class ProjectEstablishUserService {

    @Autowired
    private ProjectEstablishUserMapper projectEstablishUserMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishUserModel model) {
        return model != null && this.projectEstablishUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishUserMapper.insertList(list);
            }
        } else {
            return this.projectEstablishUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishUserModel model) {
        return model != null && this.projectEstablishUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishUserModel selectById(Long id) {
        return id == null ? null : this.projectEstablishUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishUserModel> selectByModel(ProjectEstablishUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishUserMapper.insert(model) == 1;
        }
        return this.projectEstablishUserMapper.updateById(model) == 1;
    }

    public Boolean deleteByProjectId(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("传入的项目id无效,无法进行人员信息变更");
        }
        return this.projectEstablishUserMapper.deleteByProjectId(projectId) >= 0;
    }

    public List<SysUserModel> listByProjectId(ProjectEstablishUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("获取项目参与人列表，参数异常");
        }
        List<Long> list = this.projectEstablishUserMapper.selectByProjectId(model.getProjectId());
        return this.sysUserService.selectByIds(list);
    }

    public List<ProjectEstablishUserVo> selectByProjectIdAndUserStatus(Long projectId, List<Integer> projectUserStatus) {
        if (projectId == null || ListUtil.isNullOrEmpty(projectUserStatus)) {
            throw new SystemParamCheckException("传入的项目id或是项目状态异常，无法进行查询");
        }
        List<ProjectEstablishUserVo> projectUserVos = this.projectEstablishUserMapper.selectByProjectIdAndUserStatus(projectId, projectUserStatus);
        List<Long> userIds = projectUserVos.stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList());
        Map<Long, String> map = this.sysUserService.selectByIds(userIds).stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        projectUserVos.forEach(tmp -> {
            tmp.setName(map.get(tmp.getUserId()));
            tmp.setGender(tmp.getGender());
        });
        return projectUserVos;
    }

    public List<ProjectEstablishUserModel> selectProjectUsersByTeamId(Long teamId) {
        if (teamId == null) {
            throw new SystemParamCheckException("传入的团队id异常，无法进行查询");
        }
        return this.projectEstablishUserMapper.selectProjectUsersByTeamId(teamId);
    }

    public List<SysUserModel> selectUserListByProjectId(ProjectEstablishUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        List<ProjectEstablishUserVo> list = this.projectEstablishUserMapper.selectProjectUsersByProjectId(model.getProjectId());
        List<Long> userIds = list.stream().map(ProjectEstablishUserVo::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }

    public boolean updateUserStatusDelete(List<Long> projectUserIds) {
        if (ListUtil.isNullOrEmpty(projectUserIds)) {
            return true;
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectEstablishUserModel projectEstablishUserModel = new ProjectEstablishUserModel();
        projectEstablishUserModel.setStatus(UserStatusEnum.TYPE_DELETE.getValue());
        projectEstablishUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectEstablishUserMapper.updateByUserIdsAndStatus(projectEstablishUserModel, projectUserIds) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("项目用户数据，从项目组删除异常");
    }


    public boolean updateUserToRemoveStatusByProjectTeamUserIds(List<Long> ids, SysUserModel sysUserModel) {
        if (ListUtil.isNullOrEmpty(ids)) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员状态变更");
        }
        ProjectEstablishUserModel projectEstablishUserModel = new ProjectEstablishUserModel();
        projectEstablishUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectEstablishUserModel.setStatus(UserStatusEnum.TYPE_LEAVE.getValue());
        return this.projectEstablishUserMapper.updateByModelAndProjectTeamUserIds(projectEstablishUserModel, ids) >= 0;
    }

    public boolean updateUserToStandardStatusByProjectTeamUserIds(List<Long> ids, SysUserModel sysUserModel) {
        if (ListUtil.isNullOrEmpty(ids)) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员状态变更");
        }
        ProjectEstablishUserModel projectEstablishUserModel = new ProjectEstablishUserModel();
        projectEstablishUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectEstablishUserModel.setStatus(UserStatusEnum.TYPE_NORMAL.getValue());
        return this.projectEstablishUserMapper.updateByModelAndProjectTeamUserIds(projectEstablishUserModel, ids) >= 0;
    }

    public List<ProjectEstablishUserVo> selectProjectUsersByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("团队角色id传入异常，无法进行人员查询");
        }
        return this.projectEstablishUserMapper.selectProjectUsersByRoleId(roleId);
    }

    public List<ProjectEstablishUserModel> listUnRoleTeamUsers(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        return this.projectEstablishUserMapper.listUnRoleTeamUsers(projectId);
    }

    public List<SysUserModel> selectUnGroupUserListByProjectId(ProjectEstablishUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        List<Long> userIds = this.projectEstablishUserMapper.selectUnGroupUserByProjectId(model.getProjectId()
                , ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName()).stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
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
    public boolean insertList(List<ProjectEstablishUserModel> list, ProjectModel projectModel) {
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

    public List<ProjectEstablishUserModel> selectByProjectIdAndUserIds(Long projectId, List<Long> userIds) {
        if (projectId == null || userIds == null) {
            throw new SystemParamCheckException("项目信息或是人员信息传入异常，无法获取项目人员信息")
                    .appendAlaramMsg("projectId:" + projectId + " userIds:" + JSON.toJSONString(userIds));
        }
        return this.projectEstablishUserMapper.selectByProjectIdAndUserIds(projectId, userIds);
    }


    public Map<Long, String> selectUserByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的项目用户id异常，无法进行查询");
        }
        List<ProjectEstablishUserModel> list = this.projectEstablishUserMapper.selectByIds(ids);
        Map<Long, Long> map = list.stream().collect(Collectors.toMap(ProjectEstablishUserModel::getUserId, ProjectEstablishUserModel::getId));
        List<SysUserModel> sysUserModels = this.sysUserService.selectByIds(list.stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList()));
        Map<Long, String> finalMap = new HashMap<>();
        sysUserModels.forEach(x -> finalMap.put(map.get(x.getUserId()), x.getRealName()));
        return finalMap;
    }

    public List<Long> selectUserIdsByIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("传入的参数异常,无法进行人员信息查询");
        }
        return this.projectEstablishUserMapper.selectByIds(list).stream().map(ProjectEstablishUserModel::getUserId).distinct().collect(Collectors.toList());
    }

    public List<ProjectEstablishUserModel> selectProjectUsersByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行查询");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.projectEstablishUserMapper.selectProjectUsersByRoleIds(roleIds);
    }

    public List<SysUserModel> selectNormalUserListByProjectId(ProjectEstablishUserModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        List<ProjectEstablishUserModel> list = this.projectEstablishUserMapper.selectNormalUserListByProjectId(model.getProjectId());
        List<Long> userIds = list.stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }

    public List<ProjectEstablishUserModel> selectModelsByUserIds(List<Long> ids) {
        if(ListUtil.isNullOrEmpty(ids)){
            return Collections.emptyList();
        }
        return this.projectEstablishUserMapper.selectByIds(ids);
    }
}