package com.fea.project.dao.feebudget;

import com.fea.project.model.feebudget.ProjectFeeCostModel;

import java.util.List;

/**
 * Created by Administrator on 2019/12/16.
 */
public interface ProjectFeeCostMapper {
    /**
     * 新增物料成本/其他成本
     */
    int insertSelective(ProjectFeeCostModel model);
    /**
     * 按模型选择
     */
    List<ProjectFeeCostModel> selectByModel(ProjectFeeCostModel model);
    /**
     * 物料成本/其他成本编辑
     */
    int updateByIdSelective(ProjectFeeCostModel model);
    /**
     * 删除
     */
    int deleterojectFeeCost(Long id);
    /**
     * 按主键删除
     */
    int deleteById(Long id);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(ProjectFeeCostModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFeeCostModel> models);
    /**
     * 按主键选择
     */
    ProjectFeeCostModel selectById(Long id);
    /**
     * 按主键更新
     */
    int updateById(ProjectFeeCostModel model);
}