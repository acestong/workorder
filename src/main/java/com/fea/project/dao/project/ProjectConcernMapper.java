package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectConcernModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 * 项目关注表 mapper
 */
public interface ProjectConcernMapper {
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
    int insert(ProjectConcernModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConcernModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConcernModel model);

    /**
     * 按主键选择
     */
    ProjectConcernModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConcernModel> selectByModel(ProjectConcernModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConcernModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConcernModel model);

    ProjectConcernModel selectByProjectIdAndUserId(@Param("projectId") Long projectId, @Param("userId") Long userId);
}