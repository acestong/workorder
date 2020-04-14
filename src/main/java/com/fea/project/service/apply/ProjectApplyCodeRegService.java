package com.fea.project.service.apply;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.apply.ProjectApplyCodeRegMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.baseconfig.ProjectCodePeriodEnum;
import com.fea.project.model.apply.ProjectApplyCodeModel;
import com.fea.project.model.apply.ProjectApplyCodeRegModel;
import com.fea.project.util.ListUtil;
import com.fea.project.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 * 项目组织编号 Service
 */
@Service
public class ProjectApplyCodeRegService {

    @Autowired
    private ProjectApplyCodeRegMapper projectApplyCodeRegMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyCodeRegMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyCodeRegMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyCodeRegModel model) {
        return model != null && this.projectApplyCodeRegMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyCodeRegModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectApplyCodeRegModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyCodeRegMapper.insertList(list);
            }
        } else {
            return this.projectApplyCodeRegMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyCodeRegModel model) {
        return model != null && this.projectApplyCodeRegMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyCodeRegModel selectById(Long id) {
        return id == null ? null : this.projectApplyCodeRegMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyCodeRegModel> selectByModel(ProjectApplyCodeRegModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyCodeRegMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyCodeRegModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeRegMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyCodeRegModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeRegMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyCodeRegModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeRegMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectApplyCodeRegModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyCodeRegMapper.insert(model) == 1;
        }
        return this.projectApplyCodeRegMapper.updateById(model) == 1;
    }

    public ProjectApplyCodeRegModel selectByRegIdAndFlowType(Long regId, Integer flowType) {
        if (flowType == null) {
            throw new SystemParamCheckException("传入的流程类型异常,无法生成对应流程id的流程编号");
        }
        return this.projectApplyCodeRegMapper.selectByRegIdAndFlowType(regId, flowType);
    }

    public ProjectApplyCodeRegModel getProjectApplyCodeConfig(Long regId, Integer flowType, ProjectApplyCodeModel projectApplyCodeModel, Date currentTime) {
        ProjectApplyCodeRegModel projectApplyCodeRegModel = selectByRegIdAndFlowType(regId, flowType);
        //创建新的对象
        if (projectApplyCodeRegModel == null || ProjectCodePeriodEnum.getTargetEnum(projectApplyCodeModel.getCreatePeriod())
                .isNeedRefreshCode(currentTime, projectApplyCodeRegModel.getUpdateTime())) {
            if (projectApplyCodeRegModel != null) {
                projectApplyCodeRegModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
                this.updateByIdSelective(projectApplyCodeRegModel);
            }
            projectApplyCodeRegModel = new ProjectApplyCodeRegModel(regId, flowType, projectApplyCodeModel.getCodeNumber(), currentTime);
            this.insertSelective(projectApplyCodeRegModel);
            return projectApplyCodeRegModel;
        }
        //查询当前周期是否与之前一致，如果一致，进行编号递增
        projectApplyCodeRegModel.setUpdateTime(currentTime);
        projectApplyCodeRegModel.setLastCode(StringUtil.getNextCodeByCurrentStr(projectApplyCodeRegModel.getLastCode()
                , projectApplyCodeModel.getCodeNumber()));
        this.updateByIdSelective(projectApplyCodeRegModel);
        return projectApplyCodeRegModel;
    }
}