package com.fea.project.service.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.role.ProjectRoleUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.role.pojo.ProjectRoleUserPojo;
import com.fea.project.model.role.vo.ProjectRoleUserVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectRoleUserService {

    @Autowired
    private ProjectRoleUserMapper projectRoleUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectUserService projectUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleUserModel model) {
        return model != null && this.projectRoleUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleUserMapper.insertList(list);
            }
        } else {
            return this.projectRoleUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleUserModel model) {
        return model != null && this.projectRoleUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleUserModel selectById(Long id) {
        return id == null ? null : this.projectRoleUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleUserModel> selectByModel(ProjectRoleUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleUserMapper.insert(model) == 1;
        }
        return this.projectRoleUserMapper.updateById(model) == 1;
    }

    public List<ProjectRoleUserVo> selectProjectUserRolesByUserIds(List<Long> userIds) {
        if (ListUtil.isNullOrEmpty(userIds)) {
            return new ArrayList<>();
        }
        return this.projectRoleUserMapper.selectProjectUserRolesByUserIds(userIds);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserRoleDelete(List<Long> projectUserIds) {
        if (ListUtil.isNullOrEmpty(projectUserIds)) {
            return true;
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectRoleUserModel projectRoleUserModel = new ProjectRoleUserModel();
        projectRoleUserModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        projectRoleUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectRoleUserMapper.updateByUserIdsAndStatus(projectRoleUserModel, projectUserIds) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("用户角色数据，删除异常");
    }

    public List<ProjectUserVo> selectProjectUserByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("传入的角色id无效，无法进行人员查询");
        }
        return this.projectUserService.selectProjectUsersByRoleId(roleId);
    }

    public BasePageInfo<ProjectRoleUserVo> listByParam(BasePageInfo<ProjectRoleUserModel> model) {
        List<ProjectRoleUserVo> list = this.projectRoleUserMapper.selectByFilterAndOrderParams(model);
        List<Long> userIds = list.stream().map(ProjectRoleUserVo::getUserId).collect(Collectors.toList());
        List<SysUserModel> sysUserModels = this.sysUserService.selectBaseInfoByIds(userIds);
        Map<Long, SysUserModel> map = sysUserModels.stream().collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
        list.forEach(tmp -> tmp.setSysUserInfo(map.get(tmp.getUserId())));
        return new BasePageInfo<>(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleUserPojo insertModel(ProjectRoleUserPojo model) {
        if (ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("传入的用户id异常，无法进行新增");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        List<ProjectRoleUserModel> list = model.getUserIds().stream().map(tmp -> new ProjectRoleUserModel(tmp, model)).collect(Collectors.toList());
        if (this.projectRoleUserMapper.insertList(list) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("角色添加成员报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleUserPojo deleteRoleUser(ProjectRoleUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目角色用户删除，参数传入异常");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectRoleUserMapper.updateModelsByIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("删除角色用户失败");
    }

    /**
     * 查询没有给角色的人员
     *
     * @param projectUserModel
     * @return
     */
    public List<SysUserModel> listUnRoleTeamUsers(ProjectUserModel projectUserModel) {
        if (projectUserModel == null || projectUserModel.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行人员查询");
        }
        List<Long> userIds = this.projectUserService.listUnRoleTeamUsers(projectUserModel.getProjectId())
                .stream().map(ProjectUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }

    public ProjectRoleUserModel selectByTeamIdAndUserId(Long teamUserId, Long userId) {
        if (teamUserId == null || userId == null) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员查询");
        }
        return this.projectRoleUserMapper.selectByTeamIdAndUserId(teamUserId, userId);

    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateDeleteByModelAndProjectId(ProjectRoleUserModel projectRoleUserModel, Long projectId) {
        if(projectRoleUserModel == null || projectRoleUserModel.getUserId() == null || projectId == null){
            throw new SystemParamCheckException("传入参数异常，无法进行角色人员关系删除");
        }
        return this.projectRoleUserMapper.updateDeleteByModelAndProjectId(projectRoleUserModel, projectId) >= 0;
    }
}