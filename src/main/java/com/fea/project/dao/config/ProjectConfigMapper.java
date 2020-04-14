package com.fea.project.dao.config;

import com.fea.project.model.config.ProjectConfigModel;

import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
public interface ProjectConfigMapper {
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
    int insert(ProjectConfigModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectConfigModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectConfigModel model);

    /**
     * 按主键选择
     */
    ProjectConfigModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectConfigModel> selectByModel(ProjectConfigModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectConfigModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectConfigModel model);
}