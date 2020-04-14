package com.fea.project.service.businessflow;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.businessflow.ProjectBusinessFlowCopyerMapper;
import com.fea.project.model.businessflow.ProjectBusinessFlowCopyerModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
@Service
public class ProjectBusinessFlowCopyerService {

    @Autowired
    private ProjectBusinessFlowCopyerMapper projectBusinessFlowCopyerMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBusinessFlowCopyerMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBusinessFlowCopyerMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBusinessFlowCopyerModel model) {
        return model != null && this.projectBusinessFlowCopyerMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBusinessFlowCopyerModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBusinessFlowCopyerModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBusinessFlowCopyerMapper.insertList(list);
            }
        } else {
            return this.projectBusinessFlowCopyerMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBusinessFlowCopyerModel model) {
        return model != null && this.projectBusinessFlowCopyerMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBusinessFlowCopyerModel selectById(Long id) {
        return id == null ? null : this.projectBusinessFlowCopyerMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBusinessFlowCopyerModel> selectByModel(ProjectBusinessFlowCopyerModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBusinessFlowCopyerMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBusinessFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowCopyerMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBusinessFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowCopyerMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBusinessFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowCopyerMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBusinessFlowCopyerModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectBusinessFlowCopyerMapper.insert(model) == 1;
        }
        return this.projectBusinessFlowCopyerMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertListWithListId(List<ProjectBusinessFlowCopyerModel> projectBusinessFlowCopyerModels, Long businessFlowId) {
        if (projectBusinessFlowCopyerModels == null) {
            throw new SystemParamCheckException("抄送人数据同步异常");
        }
        projectBusinessFlowCopyerModels.forEach(x -> x.setBusinessFlowId(businessFlowId));
        if (this.insertList(projectBusinessFlowCopyerModels)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("抄送人数据同步异常");
    }
}