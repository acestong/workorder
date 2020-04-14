package com.fea.project.dao.apply;

import com.fea.project.model.apply.ProjectApplyAdviseModel;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
public interface ProjectApplyAdviseMapper {
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
    int insert(ProjectApplyAdviseModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyAdviseModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyAdviseModel model);

    /**
     * 按主键选择
     */
    ProjectApplyAdviseModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyAdviseModel> selectByModel(ProjectApplyAdviseModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyAdviseModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyAdviseModel model);
}