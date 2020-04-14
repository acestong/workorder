package com.fea.project.service.risk;

import com.fea.project.dao.risk.ProjectRiskAssessPlanMapper;
import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Service
public class ProjectRiskAssessPlanService {

    @Autowired
    private ProjectRiskAssessPlanMapper projectRiskAssessPlanMapper;

    /**
     * 按模型选择
     */
    public List<ProjectRiskAssessPlanModel> selectByModel(ProjectRiskAssessPlanModel model) {
        List<ProjectRiskAssessPlanModel> projectRiskAssessPlanModels = projectRiskAssessPlanMapper.selectByModel(model);
        projectRiskAssessPlanModels.forEach(temp ->{
            temp.setFrequency("每"+temp.getFrequency()+"评估一次");
        });
        return projectRiskAssessPlanModels;
    }

    /**
     * 删除--将删除状态修改为1
     */
    public boolean deleteProjectRiskAssessPlan(ProjectRiskAssessPlanModel model){
        return model != null && this.projectRiskAssessPlanMapper.deleteProjectRiskAssessPlan(model) >= 0;
    }
    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRiskAssessPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAssessPlanMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRiskAssessPlanMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRiskAssessPlanMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRiskAssessPlanModel model) {
        return model != null && this.projectRiskAssessPlanMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRiskAssessPlanModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRiskAssessPlanModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRiskAssessPlanMapper.insertList(list);
            }
        } else {
            return this.projectRiskAssessPlanMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRiskAssessPlanModel model) {
        return model != null && this.projectRiskAssessPlanMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRiskAssessPlanModel selectById(Long id) {
        return id == null ? null : this.projectRiskAssessPlanMapper.selectById(id);
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRiskAssessPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAssessPlanMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRiskAssessPlanModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAssessPlanMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRiskAssessPlanModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRiskAssessPlanMapper.insert(model) == 1;
        }
        return this.projectRiskAssessPlanMapper.updateById(model) == 1;
    }
}