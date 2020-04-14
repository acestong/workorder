package com.fea.project.service.apply;

import com.fea.project.dao.apply.ProjectApplyAdviseMapper;
import com.fea.project.model.apply.ProjectApplyAdviseModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
@Service
public class ProjectApplyAdviseService {

    @Autowired
    private ProjectApplyAdviseMapper projectApplyAdviseMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyAdviseMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyAdviseMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyAdviseModel model) {
        return model != null && this.projectApplyAdviseMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyAdviseModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectApplyAdviseModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyAdviseMapper.insertList(list);
            }
        } else {
            return this.projectApplyAdviseMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyAdviseModel model) {
        return model != null && this.projectApplyAdviseMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyAdviseModel selectById(Long id) {
        return id == null ? null : this.projectApplyAdviseMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyAdviseModel> selectByModel(ProjectApplyAdviseModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyAdviseMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyAdviseModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyAdviseMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyAdviseModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyAdviseMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyAdviseModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyAdviseMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectApplyAdviseModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyAdviseMapper.insert(model) == 1;
        }
        return this.projectApplyAdviseMapper.updateById(model) == 1;
    }
}