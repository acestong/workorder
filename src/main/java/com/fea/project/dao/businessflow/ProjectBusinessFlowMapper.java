package com.fea.project.dao.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
public interface ProjectBusinessFlowMapper {
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
    int insert(ProjectBusinessFlowModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBusinessFlowModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBusinessFlowModel model);

    /**
     * 按主键选择
     */
    ProjectBusinessFlowModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBusinessFlowModel> selectByModel(ProjectBusinessFlowModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBusinessFlowModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBusinessFlowModel model);
}