package com.fea.project.service.role;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.role.ProjectRoleAuthorityDetailMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.project.ProjectActionStatusEnum;
import com.fea.project.enums.project.ProjectRoleAuthorityActionTypeEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.model.role.ProjectRoleAuthorityModel;
import com.fea.project.model.role.pojo.ProjectRoleAuthorityDetailPojo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.NumberUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.SyncFailedException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/18.
 */
@Service
public class ProjectRoleAuthorityDetailService {

    @Autowired
    private ProjectRoleAuthorityDetailMapper projectRoleAuthorityDetailMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectRoleAuthorityConfigService projectRoleAuthorityConfigService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleAuthorityDetailMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleAuthorityDetailMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleAuthorityDetailModel model) {
        return model != null && this.projectRoleAuthorityDetailMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleAuthorityDetailModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleAuthorityDetailModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleAuthorityDetailMapper.insertList(list);
            }
        } else {
            return this.projectRoleAuthorityDetailMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleAuthorityDetailModel model) {
        return model != null && this.projectRoleAuthorityDetailMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleAuthorityDetailModel selectById(Long id) {
        return id == null ? null : this.projectRoleAuthorityDetailMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleAuthorityDetailModel> selectByModel(ProjectRoleAuthorityDetailModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleAuthorityDetailMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleAuthorityDetailModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDetailMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleAuthorityDetailModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDetailMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleAuthorityDetailModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDetailMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleAuthorityDetailModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleAuthorityDetailMapper.insert(model) == 1;
        }
        return this.projectRoleAuthorityDetailMapper.updateById(model) == 1;
    }


    public List<ProjectRoleAuthorityDetailModel> listAuthorityDetailsByTypeId(Long authorityId) {
        if(Objects.isNull(authorityId)){
            throw new SystemParamCheckException("传入的权限类型码异常，无法进行查询");
        }
        return this.projectRoleAuthorityDetailMapper.selectByModel(new ProjectRoleAuthorityDetailModel(authorityId));
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityDetailModel insertModel(ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        projectRoleAuthorityDetailModel.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if(this.projectRoleAuthorityDetailMapper.insertSelective(projectRoleAuthorityDetailModel) >= 0){
            return projectRoleAuthorityDetailModel;
        }
        throw new SystemParamCheckException("项目角色权限新增异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityDetailModel updateModel(ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        projectRoleAuthorityDetailModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if(this.projectRoleAuthorityDetailMapper.updateByIdSelective(projectRoleAuthorityDetailModel) >= 0){
            return projectRoleAuthorityDetailModel;
        }
        throw new SystemParamCheckException("项目角色权限新增异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityDetailModel deleteModel(ProjectRoleAuthorityDetailModel projectRoleAuthorityDetailModel) {
        if(Objects.isNull(projectRoleAuthorityDetailModel) || Objects.isNull(projectRoleAuthorityDetailModel.getId())){
            throw new SystemParamCheckException("传入的角色权限id，异常，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        projectRoleAuthorityDetailModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectRoleAuthorityDetailModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if(this.projectRoleAuthorityDetailMapper.updateByIdSelective(projectRoleAuthorityDetailModel) >= 0){
            return projectRoleAuthorityDetailModel;
        }
        throw new SystemParamCheckException("项目角色权限删除失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectRoleAuthorityDetailPojo exchangeAuthorityPosition(ProjectRoleAuthorityDetailPojo projectRoleAuthorityDetailPojo) {
        if(Objects.isNull(projectRoleAuthorityDetailPojo)
                || !Objects.equals(NumberUtil.SIZE_TWO, Objects.isNull(projectRoleAuthorityDetailPojo.getIds())?0:projectRoleAuthorityDetailPojo.getIds().size())){
            throw new SystemParamCheckException("传入的参数异常，当前类型无法继续移动");
        }
        List<ProjectRoleAuthorityDetailModel> list = this.projectRoleAuthorityDetailMapper.selectByIds(projectRoleAuthorityDetailPojo.getIds());
        if(!Objects.equals(NumberUtil.SIZE_TWO, list.size())){
            throw new SystemParamCheckException("当前个别数据已经不存在请刷新后重试");
        }
        List<Long> serialIds = list.stream().map(ProjectRoleAuthorityDetailModel::getSerialId).collect(Collectors.toList());
        Collections.reverse(serialIds);
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        list.forEach(x -> {
            x.setSerialId(serialIds.get(list.indexOf(x)));
            x.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
            this.projectRoleAuthorityDetailMapper.updateByIdSelective(x);
        });
        return projectRoleAuthorityDetailPojo;
    }



    public Map<String, Integer> selectUserPriorityByProjectId(ProjectModel projectModel, Long userId) {
        if(Objects.isNull(projectModel) || Objects.isNull(projectModel.getId())){
            throw new SystemParamCheckException("传入的项目id异常，无法获取人员项目内权限");
        }
        List<ProjectRoleAuthorityConfigModel> list = this.projectRoleAuthorityConfigService.selectByProjectIdAndUserId(projectModel.getId(), userId);
        List<Long> priorityIds = list.stream().map(ProjectRoleAuthorityConfigModel::getAuthorityDetailId).collect(Collectors.toList());
        List<ProjectRoleAuthorityDetailModel> projectRoleAuthorityDetailModels = this.projectRoleAuthorityDetailMapper.selectByModel(new ProjectRoleAuthorityDetailModel());
        Map<String, Integer> map = new HashMap<>(projectRoleAuthorityDetailModels.size());
        projectRoleAuthorityDetailModels.forEach(x -> {
            Integer status = EnableStatusEnum.DISABLE.getStatus();
            if(priorityIds.contains(x.getId())){
                status = EnableStatusEnum.ENABLE.getStatus();
            }
            map.put(x.getSignatures(), status);
        });
        return map;
    }

    public Map<String, Integer> selectUserPriorityByShowPriority() {
        List<ProjectRoleAuthorityDetailModel> projectRoleAuthorityDetailModels = this.projectRoleAuthorityDetailMapper.selectByModel(new ProjectRoleAuthorityDetailModel());
        Map<String, Integer> map = new HashMap<>();
        projectRoleAuthorityDetailModels.forEach(x -> {
            if(Objects.equals(x.getActionType(), ProjectRoleAuthorityActionTypeEnum.TYPE_QUERY.getValue())){
                map.put(x.getSignatures(), EnableStatusEnum.ENABLE.getStatus());
            }else{
                map.put(x.getSignatures(), EnableStatusEnum.DISABLE.getStatus());
            }
        });
        return map;
    }
}