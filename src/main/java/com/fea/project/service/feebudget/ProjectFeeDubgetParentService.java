package com.fea.project.service.feebudget;

import java.util.ArrayList;
import java.util.List;

import com.fea.project.dao.feebudget.ProjectFeeDubgetParentMapper;
import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/01/13.
 */
@Service
public class ProjectFeeDubgetParentService {

    @Autowired
    private ProjectFeeDubgetParentMapper projectFeeDubgetParentMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFeeDubgetParentMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFeeDubgetParentMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFeeDubgetParentModel model) {
        return model != null && this.projectFeeDubgetParentMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFeeDubgetParentModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFeeDubgetParentModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFeeDubgetParentMapper.insertList(list);
            }
        } else {
            return this.projectFeeDubgetParentMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFeeDubgetParentModel model) {
        return model != null && this.projectFeeDubgetParentMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFeeDubgetParentModel selectById(Long id) {
        return id == null ? null : this.projectFeeDubgetParentMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFeeDubgetParentModel> selectByModel(ProjectFeeDubgetParentModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFeeDubgetParentMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFeeDubgetParentModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeDubgetParentMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFeeDubgetParentModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeDubgetParentMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFeeDubgetParentModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeDubgetParentMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFeeDubgetParentModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFeeDubgetParentMapper.insert(model) == 1;
        }
        return this.projectFeeDubgetParentMapper.updateById(model) == 1;
    }
}