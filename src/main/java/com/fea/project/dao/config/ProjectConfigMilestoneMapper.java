package com.fea.project.dao.config;

import com.fea.project.model.config.ProjectConfigMilestoneModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/04.
 */
@Mapper
public interface ProjectConfigMilestoneMapper {
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
    int insert(ProjectConfigMilestoneModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConfigMilestoneModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConfigMilestoneModel model);

    /**
     * 按主键选择
     */
    ProjectConfigMilestoneModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConfigMilestoneModel> selectByModel(ProjectConfigMilestoneModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConfigMilestoneModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConfigMilestoneModel model);

    int deleteByProjectIdAndCantDeleteIds(@Param("projectId") Long projectId, @Param("list") List<Long> cantDeleteIds);
}