package com.fea.project.service.baseconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectBaseSetTaskMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
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
public class ProjectBaseSetTaskService {

    @Autowired
    private ProjectBaseSetTaskMapper projectBaseSetTaskMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBaseSetTaskMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBaseSetTaskMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBaseSetTaskModel model) {
        return model != null && this.projectBaseSetTaskMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBaseSetTaskModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBaseSetTaskModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBaseSetTaskMapper.insertList(list);
            }
        } else {
            return this.projectBaseSetTaskMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBaseSetTaskModel model) {
        return model != null && this.projectBaseSetTaskMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBaseSetTaskModel selectById(Long id) {
        return id == null ? null : this.projectBaseSetTaskMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBaseSetTaskModel> selectByModel(ProjectBaseSetTaskModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBaseSetTaskMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBaseSetTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetTaskMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBaseSetTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetTaskMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBaseSetTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectBaseSetTaskMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBaseSetTaskModel model, SysUserModel sysUserModel) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            model.setRegId(sysUserModel.getRegId());
            model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            return this.projectBaseSetTaskMapper.insertSelective(model) == 1;
        }
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        return this.projectBaseSetTaskMapper.updateByIdSelective(model) == 1;
    }

    public List<ProjectBaseSetTaskModel> selectByRegId(Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id传入异常，无法进行查询");
        }
        return this.projectBaseSetTaskMapper.selectByModel(new ProjectBaseSetTaskModel(regId));
    }


    @Transactional(rollbackFor = Exception.class)
    boolean insertOrUpdateProjectBaseSetTaskModels(List<ProjectBaseSetTaskModel> projectBaseSetTaskModels) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        List<Long> ids = ListUtil.isNullOrEmpty(projectBaseSetTaskModels) ? new ArrayList<>()
                : projectBaseSetTaskModels.stream().map(ProjectBaseSetTaskModel::getId).collect(Collectors.toList());
        if (this.projectBaseSetTaskMapper.deleteByRegIdAndNotInIds(sysUserModel.getRegId(), ids) >= 0
                && this.insertOrUpdateOneByOne(projectBaseSetTaskModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目计划编号设置更新异常");
    }

    private boolean insertOrUpdateOneByOne(List<ProjectBaseSetTaskModel> projectBaseSetTaskModels) {
        if (ListUtil.isNullOrEmpty(projectBaseSetTaskModels)) {
            return true;
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        for (ProjectBaseSetTaskModel model : projectBaseSetTaskModels) {
            this.insertOrUpdate(model, sysUserModel);
        }
        return true;
    }

    ProjectBaseSetTaskModel selectByRegIdAndTypeId(Long regId, Integer typeId) {
        if (regId == null || typeId == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行项目计划编号查询");
        }
        return this.projectBaseSetTaskMapper.selectByRegIdAndTypeId(regId, typeId);
    }
}