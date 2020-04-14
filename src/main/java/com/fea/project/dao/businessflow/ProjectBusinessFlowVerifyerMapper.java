package com.fea.project.dao.businessflow;

import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/16.
 */
public interface ProjectBusinessFlowVerifyerMapper {
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
    int insert(ProjectBusinessFlowVerifyerModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBusinessFlowVerifyerModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBusinessFlowVerifyerModel model);

    /**
     * 按主键选择
     */
    ProjectBusinessFlowVerifyerModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBusinessFlowVerifyerModel> selectByModel(ProjectBusinessFlowVerifyerModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBusinessFlowVerifyerModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBusinessFlowVerifyerModel model);

    List<ProjectBusinessFlowVerifyerModel> selectProjectBusinessFlowVerifyer(@Param("businessFlowId") Long businessFlowId, @Param("listId") Long listId, @Param("parentId") Long parentId);

    ProjectBusinessFlowVerifyerModel selectNextVerifyById(@Param("id") Long id);

    ProjectBusinessFlowVerifyerModel selectBeforeVerifyById(@Param("id") Long id);

    List<ProjectBusinessFlowVerifyerModel> selectByProjectBusinessFlowId(@Param("businessFlowId") Long businessFlowId);
}