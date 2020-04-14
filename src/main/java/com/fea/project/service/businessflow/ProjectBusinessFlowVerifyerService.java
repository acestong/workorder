package com.fea.project.service.businessflow;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.businessflow.ProjectBusinessFlowVerifyerMapper;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2019/11/16.
 */
@Service
public class ProjectBusinessFlowVerifyerService {

    @Autowired
    private ProjectBusinessFlowVerifyerMapper projectBusinessFLowVerifyerMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBusinessFLowVerifyerMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBusinessFLowVerifyerMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBusinessFlowVerifyerModel model) {
        return model != null && this.projectBusinessFLowVerifyerMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBusinessFlowVerifyerModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBusinessFlowVerifyerModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBusinessFLowVerifyerMapper.insertList(list);
            }
        } else {
            return this.projectBusinessFLowVerifyerMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBusinessFlowVerifyerModel model) {
        return model != null && this.projectBusinessFLowVerifyerMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBusinessFlowVerifyerModel selectById(Long id) {
        return id == null ? null : this.projectBusinessFLowVerifyerMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBusinessFlowVerifyerModel> selectByModel(ProjectBusinessFlowVerifyerModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBusinessFLowVerifyerMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBusinessFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFLowVerifyerMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBusinessFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFLowVerifyerMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBusinessFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFLowVerifyerMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBusinessFlowVerifyerModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectBusinessFLowVerifyerMapper.insert(model) == 1;
        }
        return this.projectBusinessFLowVerifyerMapper.updateById(model) == 1;
    }

    public boolean insertListWithListId(List<ProjectBusinessFlowVerifyerModel> projectBusinessFlowVerifyerModels, Long businessFlowid) {
        if (projectBusinessFlowVerifyerModels == null) {
            throw new SystemParamCheckException("抄送人数据同步异常");
        }
        projectBusinessFlowVerifyerModels.forEach(x -> x.setBusinessFlowId(businessFlowid));
        if (this.insertList(projectBusinessFlowVerifyerModels)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("抄送人数据同步异常");
    }

    public ProjectBusinessFlowVerifyerModel selectProjectBusinessFlowVerifyer(Long businessFlowId, Long listId, Long businessFlowVerifyParentId) {
        if (businessFlowId == null || listId == null) {
            throw new SystemParamCheckException("绑定的流程id传入异常，无法进行流程移动");
        }
        List<ProjectBusinessFlowVerifyerModel> list = this.projectBusinessFLowVerifyerMapper.selectProjectBusinessFlowVerifyer(businessFlowId, listId, businessFlowVerifyParentId);
        if (list.size() > 1) {
            throw new SystemParamCheckException("审核人类型信息定义异常");
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public ProjectBusinessFlowVerifyerModel selectNextVerifyById(Long id) {
        if (id == null) {
            throw new SystemParamCheckException("传入的流程审核id异常，无法查询下一步的执行人");
        }
        return this.projectBusinessFLowVerifyerMapper.selectNextVerifyById(id);
    }

    public ProjectBusinessFlowVerifyerModel selectBeforeVerifyById(Long id) {
        if (id == null) {
            throw new SystemParamCheckException("传入的流程审核id异常，无法查询下一步的执行人");
        }
        return this.projectBusinessFLowVerifyerMapper.selectBeforeVerifyById(id);
    }

    public List<ProjectBusinessFlowVerifyerModel> selectByProjectBusinessFlowId(Long businessFlowId) {
        if (Objects.isNull(businessFlowId)) {
            throw new SystemParamCheckException("传入的流程信息异常，数据无法查询");
        }
        return this.projectBusinessFLowVerifyerMapper.selectByProjectBusinessFlowId(businessFlowId);
    }
}