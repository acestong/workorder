package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeTaskRegChildModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/05.
 */
public interface ProjectCodeTaskRegChildMapper {
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
    int insert(ProjectCodeTaskRegChildModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodeTaskRegChildModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodeTaskRegChildModel model);

    /**
     * 按主键选择
     */
    ProjectCodeTaskRegChildModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodeTaskRegChildModel> selectByModel(ProjectCodeTaskRegChildModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodeTaskRegChildModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodeTaskRegChildModel model);
}