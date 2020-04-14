package com.fea.project.dao.config;

import com.fea.project.model.config.ProjectConfigEstimatePercentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
public interface ProjectConfigEstimatePercentMapper {
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
    int insert(ProjectConfigEstimatePercentModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConfigEstimatePercentModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConfigEstimatePercentModel model);

    /**
     * 按主键选择
     */
    ProjectConfigEstimatePercentModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConfigEstimatePercentModel> selectByModel(ProjectConfigEstimatePercentModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConfigEstimatePercentModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConfigEstimatePercentModel model);

    int deleteByBusinessId(@Param("businessId") Long businessId);
}