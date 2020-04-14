package com.fea.project.dao.config;

import com.fea.project.model.config.ProjectConfigEstimateDevlierableModel;

import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
public interface ProjectConfigEstimateDevlierableMapper {
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
    int insert(ProjectConfigEstimateDevlierableModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConfigEstimateDevlierableModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConfigEstimateDevlierableModel model);

    /**
     * 按主键选择
     */
    ProjectConfigEstimateDevlierableModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConfigEstimateDevlierableModel> selectByModel(ProjectConfigEstimateDevlierableModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConfigEstimateDevlierableModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConfigEstimateDevlierableModel model);
}