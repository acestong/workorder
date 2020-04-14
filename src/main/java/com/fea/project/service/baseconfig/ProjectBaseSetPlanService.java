package com.fea.project.service.baseconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectBaseSetPlanMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/05.
 */
@Service
public class ProjectBaseSetPlanService {

    @Autowired
    private ProjectBaseSetPlanMapper projectBaseSetPlanMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBaseSetPlanMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBaseSetPlanMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBaseSetPlanModel model) {
        return model != null && this.projectBaseSetPlanMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBaseSetPlanModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBaseSetPlanModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBaseSetPlanMapper.insertList(list);
            }
        } else {
            return this.projectBaseSetPlanMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBaseSetPlanModel model) {
        return model != null && this.projectBaseSetPlanMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBaseSetPlanModel selectById(Long id) {
        return id == null ? null : this.projectBaseSetPlanMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBaseSetPlanModel> selectByModel(ProjectBaseSetPlanModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBaseSetPlanMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBaseSetPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetPlanMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBaseSetPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetPlanMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBaseSetPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetPlanMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBaseSetPlanModel model, SysUserModel sysUserModel) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            model.setRegId(sysUserModel.getRegId());
            model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            return this.projectBaseSetPlanMapper.insertSelective(model) == 1;
        }
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        return this.projectBaseSetPlanMapper.updateByIdSelective(model) == 1;
    }

    public List<ProjectBaseSetPlanModel> selectByRegId(Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id传入异常，无法进行查询");
        }
        return this.projectBaseSetPlanMapper.selectByModel(new ProjectBaseSetPlanModel(regId));
    }

    @Transactional(rollbackFor = Exception.class)
    boolean insertOrUpdateProjectBaseSetPlanModels(List<ProjectBaseSetPlanModel> projectBaseSetPlanModels) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        List<Long> ids = ListUtil.isNullOrEmpty(projectBaseSetPlanModels) ? new ArrayList<>()
                : projectBaseSetPlanModels.stream().map(ProjectBaseSetPlanModel::getId).collect(Collectors.toList());
        if (this.projectBaseSetPlanMapper.deleteByRegIdAndNotInIds(sysUserModel.getRegId(), ids) >= 0
                && this.insertOrUpdateOneByOne(projectBaseSetPlanModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目计划编号设置更新异常");
    }

    private boolean insertOrUpdateOneByOne(List<ProjectBaseSetPlanModel> projectBaseSetPlanModels) {
        if (ListUtil.isNullOrEmpty(projectBaseSetPlanModels)) {
            return true;
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        for (ProjectBaseSetPlanModel model : projectBaseSetPlanModels) {
            this.insertOrUpdate(model, sysUserModel);
        }
        return true;
    }

    ProjectBaseSetPlanModel selectByRegIdAndTypeId(Long regId, Integer typeId) {
        if (regId == null || typeId == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行项目计划编号查询");
        }
        return this.projectBaseSetPlanMapper.selectByRegIdAndTypeId(regId, typeId);
    }
}