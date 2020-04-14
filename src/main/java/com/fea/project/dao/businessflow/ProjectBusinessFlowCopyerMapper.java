package com.fea.project.dao.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowCopyerModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
public interface ProjectBusinessFlowCopyerMapper {
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
    int insert(ProjectBusinessFlowCopyerModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBusinessFlowCopyerModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBusinessFlowCopyerModel model);

    /**
     * 按主键选择
     */
    ProjectBusinessFlowCopyerModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBusinessFlowCopyerModel> selectByModel(ProjectBusinessFlowCopyerModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBusinessFlowCopyerModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBusinessFlowCopyerModel model);
}