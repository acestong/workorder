package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectExternalContactorMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectExternalContactorModel;
import com.fea.project.model.project.pojo.ProjectExternalContactorPojo;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */
@Service
public class ProjectExternalContactorService {

    @Autowired
    private ProjectExternalContactorMapper projectExternalContactorMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectExternalContactorMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectExternalContactorMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectExternalContactorModel model) {
        return model != null && this.projectExternalContactorMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectExternalContactorModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectExternalContactorModel> list : ListUtil.getSubList(models, 100)) {
                this.projectExternalContactorMapper.insertList(list);
            }
        } else {
            return this.projectExternalContactorMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectExternalContactorModel model) {
        return model != null && this.projectExternalContactorMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectExternalContactorModel selectById(Long id) {
        return id == null ? null : this.projectExternalContactorMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectExternalContactorModel> selectByModel(ProjectExternalContactorModel model) {
        return model == null ? new ArrayList<>(0) : this.projectExternalContactorMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectExternalContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectExternalContactorMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectExternalContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectExternalContactorMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectExternalContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectExternalContactorMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectExternalContactorModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectExternalContactorMapper.insert(model) == 1;
        }
        return this.projectExternalContactorMapper.updateById(model) == 1;
    }

    public BasePageInfo<ProjectExternalContactorModel> listByParam(BasePageInfo<ProjectExternalContactorModel> model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize(), true);
        List<ProjectExternalContactorModel> list = this.projectExternalContactorMapper.selectByFilterAndOrderParams(model);
        return new BasePageInfo<>(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectExternalContactorModel insertModel(ProjectExternalContactorModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectExternalContactorMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目外部联系人添加失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectExternalContactorModel updateModel(ProjectExternalContactorModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectExternalContactorMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目外部联系人更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectExternalContactorPojo deleteModels(ProjectExternalContactorPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("参数传入异常，数据无法删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectExternalContactorMapper.updateModelsByIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目外部联系人删除失败");
    }
}