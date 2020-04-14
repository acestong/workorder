package com.fea.project.service.establishproject.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.role.ProjectEstablishRoleUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishRoleUserPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishRoleUserVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishUserVo;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectEstablishRoleUserService {

    @Autowired
    private ProjectEstablishRoleUserMapper projectEstablishRoleUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishRoleUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishRoleUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishRoleUserModel model) {
        return model != null && this.projectEstablishRoleUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishRoleUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishRoleUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishRoleUserMapper.insertList(list);
            }
        } else {
            return this.projectEstablishRoleUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishRoleUserModel model) {
        return model != null && this.projectEstablishRoleUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishRoleUserModel selectById(Long id) {
        return id == null ? null : this.projectEstablishRoleUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishRoleUserModel> selectByModel(ProjectEstablishRoleUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishRoleUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishRoleUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishRoleUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishRoleUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishRoleUserMapper.insert(model) == 1;
        }
        return this.projectEstablishRoleUserMapper.updateById(model) == 1;
    }

    public List<ProjectEstablishRoleUserVo> selectProjectUserRolesByUserIds(List<Long> userIds) {
        if (ListUtil.isNullOrEmpty(userIds)) {
            return new ArrayList<>();
        }
        return this.projectEstablishRoleUserMapper.selectProjectUserRolesByUserIds(userIds);
    }

    public boolean updateUserRoleDelete(List<Long> projectUserIds) {
        if (ListUtil.isNullOrEmpty(projectUserIds)) {
            return true;
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectEstablishRoleUserModel projectEstablishRoleUserModel = new ProjectEstablishRoleUserModel();
        projectEstablishRoleUserModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        projectEstablishRoleUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectEstablishRoleUserMapper.updateByUserIdsAndStatus(projectEstablishRoleUserModel, projectUserIds) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("用户角色数据，删除异常");
    }

    public List<ProjectEstablishUserVo> selectProjectUserByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("传入的角色id无效，无法进行人员查询");
        }
        return this.projectEstablishUserService.selectProjectUsersByRoleId(roleId);
    }

    public BasePageInfo<ProjectEstablishRoleUserVo> listByParam(BasePageInfo<ProjectEstablishRoleUserModel> model) {
        List<ProjectEstablishRoleUserVo> list = this.projectEstablishRoleUserMapper.selectByFilterAndOrderParams(model);
        List<ProjectEstablishUserModel> projectEstablishUserModels = this.projectEstablishUserService.selectModelsByUserIds(list.stream().map(ProjectEstablishRoleUserModel::getUserId).collect(Collectors.toList()));
        Map<Long, ProjectEstablishUserModel> tmpMap = projectEstablishUserModels.stream().collect(Collectors.toMap(ProjectEstablishUserModel::getId, x -> x));
        list.forEach( x -> {
            if(tmpMap.get(x.getUserId()) != null){
                x.setRealUserId(tmpMap.get(x.getUserId()).getUserId());
            }
        });
        List<Long> userIds = projectEstablishUserModels.stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList());
        List<SysUserModel> sysUserModels = this.sysUserService.selectBaseInfoByIds(userIds);
        Map<Long, SysUserModel> map = sysUserModels.stream().collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
        list.forEach(tmp -> tmp.setSysUserInfo(map.get(tmp.getRealUserId())));
        return new BasePageInfo<>(list);
    }

    public ProjectEstablishRoleUserPojo insertModel(ProjectEstablishRoleUserPojo model) {
        if (ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("传入的用户id异常，无法进行新增");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        List<ProjectEstablishRoleUserModel> list = model.getUserIds().stream().map(tmp -> new ProjectEstablishRoleUserModel(tmp, model)).collect(Collectors.toList());
        if (this.projectEstablishRoleUserMapper.insertList(list) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("角色添加成员报错");
    }

    public ProjectEstablishRoleUserPojo deleteRoleUser(ProjectEstablishRoleUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目角色用户删除，参数传入异常");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectEstablishRoleUserMapper.updateModelsByIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("删除角色用户失败");
    }

    /**
     * 查询没有给角色的人员
     *
     * @param projectEstablishUserModel
     * @return
     */
    public List<SysUserModel> listUnRoleTeamUsers(ProjectEstablishUserModel projectEstablishUserModel) {
        if (projectEstablishUserModel == null || projectEstablishUserModel.getProjectId() == null) {
            throw new SystemParamCheckException("项目id传入异常，无法进行人员查询");
        }
        List<Long> userIds = this.projectEstablishUserService.listUnRoleTeamUsers(projectEstablishUserModel.getProjectId())
                .stream().map(ProjectEstablishUserModel::getUserId).collect(Collectors.toList());
        return this.sysUserService.selectBaseInfoByIds(userIds);
    }

    public ProjectEstablishRoleUserModel selectByTeamIdAndUserId(Long teamUserId, Long userId) {
        if (teamUserId == null || userId == null) {
            throw new SystemParamCheckException("团队用户id传入异常，无法进行人员查询");
        }
        return this.projectEstablishRoleUserMapper.selectByTeamIdAndUserId(teamUserId, userId);

    }
}