package com.fea.project.service.businessflow;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.businessflow.ProjectBusinessFlowListConditionMapper;
import com.fea.project.model.businessflow.ProjectBusinessFlowListConditionModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
@Service
public class ProjectBusinessFlowListConditionService {

    @Autowired
    private ProjectBusinessFlowListConditionMapper projectBusinessFlowListConditionMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBusinessFlowListConditionMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBusinessFlowListConditionMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBusinessFlowListConditionModel model) {
        return model != null && this.projectBusinessFlowListConditionMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBusinessFlowListConditionModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBusinessFlowListConditionModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBusinessFlowListConditionMapper.insertList(list);
            }
        } else {
            return this.projectBusinessFlowListConditionMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBusinessFlowListConditionModel model) {
        return model != null && this.projectBusinessFlowListConditionMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBusinessFlowListConditionModel selectById(Long id) {
        return id == null ? null : this.projectBusinessFlowListConditionMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBusinessFlowListConditionModel> selectByModel(ProjectBusinessFlowListConditionModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBusinessFlowListConditionMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBusinessFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListConditionMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBusinessFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListConditionMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBusinessFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListConditionMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBusinessFlowListConditionModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectBusinessFlowListConditionMapper.insert(model) == 1;
        }
        return this.projectBusinessFlowListConditionMapper.updateById(model) == 1;
    }

    public boolean insertListWithListId(List<ProjectBusinessFlowListConditionModel> projectBusinessFlowListConditionModels, Long businessFlowId) {
        if (projectBusinessFlowListConditionModels == null) {
            throw new SystemParamCheckException("抄送人数据同步异常");
        }
        projectBusinessFlowListConditionModels.forEach(x -> x.setBusinessFlowId(businessFlowId));
        if (this.insertList(projectBusinessFlowListConditionModels)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("抄送人数据同步异常");
    }
}