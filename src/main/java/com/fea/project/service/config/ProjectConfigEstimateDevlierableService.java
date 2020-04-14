package com.fea.project.service.config;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigEstimateDevlierableMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.config.ProjectConfigEstimateDevlierableModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
@Service
public class ProjectConfigEstimateDevlierableService {

    @Autowired
    private ProjectConfigEstimateDevlierableMapper projectConfigEstimateDevlierableMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConfigEstimateDevlierableMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConfigEstimateDevlierableMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConfigEstimateDevlierableModel model) {
        return model != null && this.projectConfigEstimateDevlierableMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigEstimateDevlierableModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConfigEstimateDevlierableModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConfigEstimateDevlierableMapper.insertList(list);
            }
        } else {
            return this.projectConfigEstimateDevlierableMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConfigEstimateDevlierableModel model) {
        return model != null && this.projectConfigEstimateDevlierableMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConfigEstimateDevlierableModel selectById(Long id) {
        return id == null ? null : this.projectConfigEstimateDevlierableMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConfigEstimateDevlierableModel> selectByModel(ProjectConfigEstimateDevlierableModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConfigEstimateDevlierableMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConfigEstimateDevlierableModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateDevlierableMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConfigEstimateDevlierableModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateDevlierableMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConfigEstimateDevlierableModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateDevlierableMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public ProjectConfigEstimateDevlierableModel insertOrUpdate(ProjectConfigEstimateDevlierableModel model) {
        if (model == null) {
            throw new SystemParamCheckException("交付物评价权重设置更新报错");
        }
        if (model.getId() == null) {
            return this.insertModel(model);
        }
        return this.updateModel(model);
    }

    private ProjectConfigEstimateDevlierableModel updateModel(ProjectConfigEstimateDevlierableModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectConfigEstimateDevlierableMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付物权重评价更新报错");
    }

    private ProjectConfigEstimateDevlierableModel insertModel(ProjectConfigEstimateDevlierableModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectConfigEstimateDevlierableMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付物权重评价添加报错");
    }

    public ProjectConfigEstimateDevlierableModel selectByDevlierableId(Long deliverableId) {
        if (deliverableId == null) {
            return null;
        }
        List<ProjectConfigEstimateDevlierableModel> list = this.projectConfigEstimateDevlierableMapper
                .selectByModel(new ProjectConfigEstimateDevlierableModel(deliverableId));
        return list.isEmpty() ? null : list.get(0);
    }
}