package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectVersionModel;
import com.fea.project.model.project.vo.ProjectVersionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/14.
 */
public interface ProjectVersionMapper {
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
    int insert(ProjectVersionModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectVersionModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectVersionModel model);
    /**
     * 按主键选择
     */
    ProjectVersionModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectVersionModel> selectByModel(ProjectVersionModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectVersionModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectVersionModel model);

    ProjectVersionModel selectByProjectIdAndRealType(@Param("projectId") Long projectId, @Param("selectFlag") Integer selectFlag);

    int deleteByProjectIdAndSelectTypeAndCreateId(@Param("projectId") Long projectId, @Param("selectFlag") Integer selectFlag, @Param("createId") Long createId);

    List<ProjectVersionModel> selectByIds(@Param("list") List<Long> ids);

    int deleteByBusinessIdAndProjectIdAndSelectType(@Param("businessId") Long businessId, @Param("projectId") Long projectId, @Param("selectFlag") Integer selectFlag);

    List<ProjectVersionVo> selectByProjectIdOrUserId(@Param("projectId") Long projectId, @Param("createId") Long userId);
}