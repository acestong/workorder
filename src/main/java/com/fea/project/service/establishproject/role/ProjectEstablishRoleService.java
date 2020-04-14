package com.fea.project.service.establishproject.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.role.ProjectEstablishRoleMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.vo.EstablishRolePageLeftRoleVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishUserVo;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
import com.fea.project.util.ListUtil;
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
public class ProjectEstablishRoleService {

    @Autowired
    private ProjectEstablishRoleMapper projectEstablishRoleMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectEstablishRoleUserService projectEstablishRoleUserService;

    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishRoleMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishRoleMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishRoleModel model) {
        return model != null && this.projectEstablishRoleMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishRoleModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishRoleModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishRoleMapper.insertList(list);
            }
        } else {
            return this.projectEstablishRoleMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishRoleModel model) {
        return model != null && this.projectEstablishRoleMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishRoleModel selectById(Long id) {
        return id == null ? null : this.projectEstablishRoleMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishRoleModel> selectByModel(ProjectEstablishRoleModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishRoleMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishRoleModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishRoleModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishRoleMapper.insert(model) == 1;
        }
        return this.projectEstablishRoleMapper.updateById(model) == 1;
    }

    public List<EstablishRolePageLeftRoleVo> listByParam(ProjectEstablishRoleModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行查询");
        }
        List<ProjectEstablishRoleModel> projectEstablishRoleModels = this.projectEstablishRoleMapper.selectByModel(model);
        return EstablishRolePageLeftRoleVo.createList(projectEstablishRoleModels);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishRoleModel insertModel(ProjectEstablishRoleModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectEstablishRoleMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色添加异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishRoleModel updateModel(ProjectEstablishRoleModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectEstablishRoleMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishRoleModel deleteModel(ProjectEstablishRoleModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目角色id传入异常，无法进行删除");
        }
        //查询当前角色下是否存在有效用户
        List<ProjectEstablishUserVo> projectUserModels = this.projectEstablishRoleUserService.selectProjectUserByRoleId(model.getId());
        if (!projectUserModels.isEmpty()) {
            throw new SystemParamCheckException("该角色下存在团队成员数据，无法进行删除");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectEstablishRoleMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目角色删除异常");
    }

    public ProjectEstablishRoleModel selectOne(ProjectEstablishRoleModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目角色id传入异常，无法进行查询");
        }
        return this.projectEstablishRoleMapper.selectById(model.getId());
    }

    public Object selectByProjectId(Long projectId) {
        if (projectId == null) {
            throw new SystemParamCheckException("项目id传入异常，无法查询项目下的角色");
        }
        return this.projectEstablishRoleMapper.selectByModel(new ProjectEstablishRoleModel(projectId));
    }

    public List<ProjectEstablishRoleModel> selectProjectRoleByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("项目角色id传入异常,无法查询对应的信息");
        }
        return this.projectEstablishRoleMapper.selectByIds(roleIds);
    }

    public List<Long> selectUserIdsByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("项目角色id传入异常,无法查询对应的信息");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<ProjectEstablishUserModel> projectUserModels = projectEstablishUserService.selectProjectUsersByRoleIds(roleIds);
        return projectUserModels.stream().map(ProjectEstablishUserModel::getUserId).distinct().collect(Collectors.toList());
    }
}