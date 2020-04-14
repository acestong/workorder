package com.fea.project.service.feebudget;

import com.fea.project.api.other.enums.base.DeleteStatusEnum;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.feebudget.ProjectFeeCostMapper;
import com.fea.project.enums.feebudget.UnitEnum;
import com.fea.project.model.feebudget.ProjectFeeCostModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2019/12/16.
 */
@Service
public class ProjectFeeCostService {

    @Autowired
    private ProjectFeeCostMapper projectFeeCostMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectFeeDubgetService projectFeeDubgetService;

    /**
     * 新增物料成本/其他成本
     */
    public boolean insertSelective(ProjectFeeCostModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectFeeCostMapper.insertSelective(model) == 1;
    }

    /**
     * 物料成本列表
     */
    public List<ProjectFeeCostModel> materialCostList(ProjectFeeCostModel model) {
        model.setCostType(1);
        List<ProjectFeeCostModel> projectFeeCostModels = this.projectFeeCostMapper.selectByModel(model);
        projectFeeCostModels.forEach(temp ->{
            if (temp.getType()!=null){
                temp.setFeeTypeString(projectFeeDubgetService.getFeeType(temp.getType()));
            }

        });
        return projectFeeCostModels;
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFeeCostModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectFeeCostMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 其他成本列表
     */
    public List<ProjectFeeCostModel> otherCostlList(ProjectFeeCostModel model) {
        model.setCostType(2);
        List<ProjectFeeCostModel> projectFeeCostModels = this.projectFeeCostMapper.selectByModel(model);
        projectFeeCostModels.forEach(temp ->{
            if (temp.getType()!=null){
                temp.setFeeTypeString(projectFeeDubgetService.getFeeType(temp.getType()));
            }
        });
        return projectFeeCostModels;
    }

    /**
     * 删除
     */

    public boolean deleterojectFeeCost(ProjectFeeCostModel  model){
        return !(model == null || model.getId() == null) && this.projectFeeCostMapper.deleterojectFeeCost(model.getId()) == 1;

    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFeeCostMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFeeCostMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFeeCostModel model) {
        return model != null && this.projectFeeCostMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFeeCostModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFeeCostModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFeeCostMapper.insertList(list);
            }
        } else {
            return this.projectFeeCostMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectFeeCostModel selectById(Long id) {
        return id == null ? null : this.projectFeeCostMapper.selectById(id);
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFeeCostModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeCostMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFeeCostModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeCostMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFeeCostModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFeeCostMapper.insert(model) == 1;
        }
        return this.projectFeeCostMapper.updateById(model) == 1;
    }
}