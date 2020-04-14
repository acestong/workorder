package com.fea.project.dao.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowListModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
public interface ProjectBusinessFlowListMapper {
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
    int insert(ProjectBusinessFlowListModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBusinessFlowListModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBusinessFlowListModel model);

    /**
     * 按主键选择
     */
    ProjectBusinessFlowListModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBusinessFlowListModel> selectByModel(ProjectBusinessFlowListModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBusinessFlowListModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBusinessFlowListModel model);
}