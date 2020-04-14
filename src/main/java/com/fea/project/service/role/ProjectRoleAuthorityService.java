package com.fea.project.service.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.role.ProjectRoleAuthorityMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.model.role.ProjectRoleAuthorityModel;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityConfigPojo;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityPojo;
import com.fea.project.model.role.vo.ProjectRoleAuthorityDetailVo;
import com.fea.project.model.role.vo.ProjectRoleAuthorityVo;
import com.fea.project.model.role.vo.RolePriorityPageLeftVo;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectRoleAuthorityService {

    @Autowired
    private ProjectRoleAuthorityMapper projectRoleAuthorityMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRoleAuthorityConfigService projectRoleAuthorityConfigService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectRoleAuthorityDetailService projectRoleAuthorityDetailService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleAuthorityMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleAuthorityMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleAuthorityModel model) {
        return model != null && this.projectRoleAuthorityMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleAuthorityModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleAuthorityModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleAuthorityMapper.insertList(list);
            }
        } else {
            return this.projectRoleAuthorityMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleAuthorityModel model) {
        return model != null && this.projectRoleAuthorityMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleAuthorityModel selectById(Long id) {
        return id == null ? null : this.projectRoleAuthorityMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleAuthorityModel> selectByModel(ProjectRoleAuthorityModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleAuthorityMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleAuthorityModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleAuthorityModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleAuthorityModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleAuthorityModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleAuthorityMapper.insert(model) == 1;
        }
        return this.projectRoleAuthorityMapper.updateById(model) == 1;
    }

    public List<ProjectRoleAuthorityVo> listRegAuthority(ProjectRoleModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目角色id传入异常");
        }
        ProjectModel projectModel = this.projectService.selectByRoleId(model.getId());
        if (projectModel == null || projectModel.getRegId() == null) {
            throw new SystemParamCheckException("项目参数异常，请检查项目信息以及项目信息所在组织");
        }
        List<ProjectRoleAuthorityVo> list = this.projectRoleAuthorityMapper.selectRegAuthority(projectModel.getRegId());
        List<ProjectRoleAuthorityConfigModel> configModels = this.projectRoleAuthorityConfigService.selectByRoleId(model.getId());
        Set<Long> authorityDetailIds = configModels.stream().map(ProjectRoleAuthorityConfigModel::getAuthorityDetailId).collect(Collectors.toSet());
        list.forEach(tmp -> {
            List<ProjectRoleAuthorityDetailVo> tmpList = tmp.getLabels();
            tmpList.forEach(single -> {
                if (authorityDetailIds.contains(single.getId())) {
                    single.setStatus(EnableStatusEnum.ENABLE.getStatus());
                    return;
                }
                single.setStatus(EnableStatusEnum.DISABLE.getStatus());
            });
        });
        Map<Long, ProjectRoleAuthorityVo> map = list.stream().collect(Collectors.toMap(ProjectRoleAuthorityVo::getId, projectRoleAuthorityVo -> projectRoleAuthorityVo));
        List<ProjectRoleAuthorityVo> finalList = new ArrayList<>();
        list.forEach(projectRoleAuthorityVo -> {
            ProjectRoleAuthorityVo tmp = map.get(projectRoleAuthorityVo.getParentId());
            if (tmp == null) {
                finalList.add(projectRoleAuthorityVo);
                return;
            }
            List<ProjectRoleAuthorityVo> tmpList = tmp.getChildren();
            if (tmpList == null) {
                tmpList = new ArrayList<>();
                tmp.setChildren(tmpList);
                tmpList.add(projectRoleAuthorityVo);
            }
        });

        return finalList;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityConfigPojo updateRoleAuthority(ProjectRoleAuthorityConfigPojo model) {
        if (model == null || model.getRoleId() == null || ListUtil.isNullOrEmpty(model.getAuthorityDetailIds())) {
            throw new SystemParamCheckException("参数无效无法进行插入");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        List<ProjectRoleAuthorityConfigModel> list = ProjectRoleAuthorityConfigModel.createList(model, sysUserModel);
        if (this.projectRoleAuthorityConfigService.deleteByRoleId(model.getRoleId()) && this.projectRoleAuthorityConfigService.insertList(list)) {
            return model;
        }
        throw new SystemParamCheckException("角色权限更新失败");
    }

    public List<ProjectRoleAuthorityModel> listAuthorityTypes() {
        return this.projectRoleAuthorityMapper.selectByModel(new ProjectRoleAuthorityModel());
    }


    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityModel insertModel(ProjectRoleAuthorityModel projectRoleAuthorityModel) {
        SysUserModel model = sysUserService.getCurrentUsr();
        projectRoleAuthorityModel.setUserInfo(model, ActionEnum.INSERT_ACTION);
        if(projectRoleAuthorityMapper.insert(projectRoleAuthorityModel) >= 0){
            return projectRoleAuthorityModel;
        }
        throw new SystemParamCheckException("项目权限类型新增异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityModel updateModel(ProjectRoleAuthorityModel projectRoleAuthorityModel) {
        SysUserModel model = sysUserService.getCurrentUsr();
        projectRoleAuthorityModel.setUserInfo(model, ActionEnum.UPDATE_ACTION);
        if(projectRoleAuthorityMapper.updateByIdSelective(projectRoleAuthorityModel) >= 0){
            return projectRoleAuthorityModel;
        }
        throw new SystemParamCheckException("项目权限类型更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityModel deleteModel(ProjectRoleAuthorityModel projectRoleAuthorityModel) {
        if(Objects.isNull(projectRoleAuthorityModel) || Objects.isNull(projectRoleAuthorityModel.getId())){
            throw new SystemParamCheckException("传入的项目角色权限类型id异常，无法进行删除");
        }
        //验证该类型下面是否存在绑定的项目角色详情
        List<ProjectRoleAuthorityDetailModel> list = this.projectRoleAuthorityDetailService
                .selectByModel(new ProjectRoleAuthorityDetailModel(projectRoleAuthorityModel.getId()));
        if(list.size() > 0){
            throw new SystemParamCheckException("该类型下存在未删除的权限数据，无法进行删除");
        }
        SysUserModel model = sysUserService.getCurrentUsr();
        projectRoleAuthorityModel.setUserInfo(model, ActionEnum.UPDATE_ACTION);
        projectRoleAuthorityModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if(projectRoleAuthorityMapper.updateByIdSelective(projectRoleAuthorityModel) >= 0){
            return projectRoleAuthorityModel;
        }
        throw new SystemParamCheckException("项目权限类型更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityPojo exchangeAuthorityPosition(ProjectRoleAuthorityPojo projectRoleAuthorityPojo) {
        if(Objects.isNull(projectRoleAuthorityPojo)
                || !Objects.equals(NumberUtil.SIZE_TWO, Objects.isNull(projectRoleAuthorityPojo.getIds())?0:projectRoleAuthorityPojo.getIds().size())){
            throw new SystemParamCheckException("传入的参数异常，当前类型无法继续移动");
        }
        List<ProjectRoleAuthorityModel> list = this.projectRoleAuthorityMapper.selectByIds(projectRoleAuthorityPojo.getIds());
        if(!Objects.equals(NumberUtil.SIZE_TWO, list.size())){
            throw new SystemParamCheckException("当前个别数据已经不存在请刷新后重试");
        }
        List<Long> serialIds = list.stream().map(ProjectRoleAuthorityModel::getSerialId).collect(Collectors.toList());
        Collections.reverse(serialIds);
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        list.forEach(x -> {
            x.setSerialId(serialIds.get(list.indexOf(x)));
            x.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
            this.projectRoleAuthorityMapper.updateByIdSelective(x);
        });
        return projectRoleAuthorityPojo;
    }

    public List<RolePriorityPageLeftVo> selectProjectRoleAuthority() {
        return RolePriorityPageLeftVo.translateProjectRolePriority(this.projectRoleAuthorityMapper.selectByModel(new ProjectRoleAuthorityModel()));
    }
}