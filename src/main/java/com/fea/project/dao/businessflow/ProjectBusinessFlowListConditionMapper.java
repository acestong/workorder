package com.fea.project.dao.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowListConditionModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
public interface ProjectBusinessFlowListConditionMapper {
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
    int insert(ProjectBusinessFlowListConditionModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBusinessFlowListConditionModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBusinessFlowListConditionModel model);

    /**
     * 按主键选择
     */
    ProjectBusinessFlowListConditionModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBusinessFlowListConditionModel> selectByModel(ProjectBusinessFlowListConditionModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBusinessFlowListConditionModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBusinessFlowListConditionModel model);
}