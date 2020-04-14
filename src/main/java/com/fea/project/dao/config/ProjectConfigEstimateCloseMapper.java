package com.fea.project.dao.config;

import com.fea.project.model.config.ProjectConfigEstimateCloseModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
public interface ProjectConfigEstimateCloseMapper {
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
    int insert(ProjectConfigEstimateCloseModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConfigEstimateCloseModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConfigEstimateCloseModel model);

    /**
     * 按主键选择
     */
    ProjectConfigEstimateCloseModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConfigEstimateCloseModel> selectByModel(ProjectConfigEstimateCloseModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConfigEstimateCloseModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConfigEstimateCloseModel model);

    int deleteByCloseIdAndTypeId(@Param("closeId") Long closeId, @Param("typeId") Integer typeId);

    int deleteByCloseId(@Param("closeId") Long closeId);
}