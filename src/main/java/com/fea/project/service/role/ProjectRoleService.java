package com.fea.project.service.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.role.ProjectRoleMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.vo.RolePageLeftRoleVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectRoleService {

    @Autowired
    private ProjectRoleMapper projectRoleMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectRoleUserService projectRoleUserService;

    @Autowired
    private ProjectUserService projectUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleModel model) {
        return model != null && this.projectRoleMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleMapper.insertList(list);
            }
        } else {
            return this.projectRoleMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleModel model) {
        return model != null && this.projectRoleMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleModel selectById(Long id) {
        return id == null ? null : this.projectRoleMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleModel> selectByModel(ProjectRoleModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleMapper.insert(model) == 1;
        }
        return this.projectRoleMapper.updateById(model) == 1;
    }

    public List<RolePageLeftRoleVo> listByParam(ProjectRoleModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        return RolePageLeftRoleVo.createList(this.projectRoleMapper.selectByModel(model));
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleModel insertModel(ProjectRoleModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectRoleMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色添加异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleModel updateModel(ProjectRoleModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectRoleMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleModel deleteModel(ProjectRoleModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目角色id传入异常，无法进行删除");
        }
        //查询当前角色下是否存在有效用户
        List<ProjectUserVo> projectUserModels = this.projectRoleUserService.selectProjectUserByRoleId(model.getId());
        if (!projectUserModels.isEmpty()) {
            throw new SystemParamCheckException("该角色下存在团队成员数据，无法进行删除");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectRoleMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色删除异常");
    }

    public ProjectRoleModel selectOne(ProjectRoleModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目角色id传入异常，无法进行查询");
        }
        return this.projectRoleMapper.selectById(model.getId());
    }

    public Object selectByProjectId(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("项目id传入异常，无法查询项目下的角色");
        }
        return this.projectRoleMapper.selectByModel(new ProjectRoleModel(projectId));
    }

    public List<ProjectRoleModel> selectProjectRoleByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("项目角色id传入异常,无法查询对应的信息");
        }
        return this.projectRoleMapper.selectByIds(roleIds);
    }

    public List<Long> selectUserIdsByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("项目角色id传入异常,无法查询对应的信息");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<ProjectUserModel> projectUserModels = projectUserService.selectProjectUsersByRoleIds(roleIds);
        return projectUserModels.stream().map(ProjectUserModel::getUserId).distinct().collect(Collectors.toList());
    }

    public List<ProjectRoleModel> selectProjectRoleByUserId(Long userId) {
        if (userId == null) {
            throw new SystemParamCheckException("用户id传入异常,无法查询对应的信息");
        }
        return this.projectRoleMapper.selectUserRolesByUserId(userId);
    }

    public ProjectRoleModel selectRoleByProjectIdAndShortName(Long projectId, String shortName) {
        if(projectId == null || StringUtil.isEmpty(shortName)){
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        return this.projectRoleMapper.selectRoleByProjectIdAndShortName(projectId, shortName);
    }
}