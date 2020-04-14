package com.fea.project.dao.feebudget;


import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/13.
 */
@Mapper
public interface ProjectFeeDubgetParentMapper {
    /**
     * 查询当前项目下非草稿状态的预算父信息
     */
    ProjectFeeDubgetParentModel selectNotDraft(@Param("projectId") Long projectId,@Param("isDraft") Integer isDraft);
    /**
     * 查询当前项目下草稿+未审核状态的预算父信息
     */
    ProjectFeeDubgetParentModel selectDraft(@Param("projectId") Long projectId,@Param("isDraft") Integer isDraft,@Param("verifyerStatus") Integer verifyerStatus);
    /**
     * 根据id修改草稿状态
     */
    int updateDraftStatusById(@Param("id")Long id,@Param("isDraft") Integer isDraft);
    /**
     * 根据id修改审核状态
     */
    int updateCheckStatusById(@Param("id")Long id,@Param("verifyerStatus") Integer verifyerStatus);

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
    int insert(ProjectFeeDubgetParentModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFeeDubgetParentModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFeeDubgetParentModel model);
    /**
     * 按主键选择
     */
    ProjectFeeDubgetParentModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectFeeDubgetParentModel> selectByModel(ProjectFeeDubgetParentModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFeeDubgetParentModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectFeeDubgetParentModel model);
    /**
     * 获取列表
     */
    List<ProjectFeeDubgetParentModel> selectByModelIds(List<Long> ids);
}