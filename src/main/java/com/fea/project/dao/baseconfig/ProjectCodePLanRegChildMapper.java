package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodePLanRegChildModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/05.
 */
public interface ProjectCodePLanRegChildMapper {
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
    int insert(ProjectCodePLanRegChildModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodePLanRegChildModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodePLanRegChildModel model);

    /**
     * 按主键选择
     */
    ProjectCodePLanRegChildModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodePLanRegChildModel> selectByModel(ProjectCodePLanRegChildModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodePLanRegChildModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodePLanRegChildModel model);
}