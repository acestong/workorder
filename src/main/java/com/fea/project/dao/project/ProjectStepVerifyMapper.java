package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectStepVerifyModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/06.
 */
public interface ProjectStepVerifyMapper {
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
    int insert(ProjectStepVerifyModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectStepVerifyModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectStepVerifyModel model);

    /**
     * 按主键选择
     */
    ProjectStepVerifyModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectStepVerifyModel> selectByModel(ProjectStepVerifyModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectStepVerifyModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectStepVerifyModel model);

    List<ProjectStepVerifyModel> selectByStepIds(@Param("list") List<Long> stepIds);

    int deleteByStepIds(@Param("list") List<Long> stepIds);
}