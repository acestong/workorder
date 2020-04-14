package com.fea.project.dao.apply;

import com.fea.project.model.apply.ProjectApplyCodeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 */
public interface ProjectApplyCodeMapper {
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
    int insert(ProjectApplyCodeModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyCodeModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyCodeModel model);

    /**
     * 按主键选择
     */
    ProjectApplyCodeModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyCodeModel> selectByModel(ProjectApplyCodeModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyCodeModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyCodeModel model);

    ProjectApplyCodeModel selectDefaultSet(@Param("flowType") int flowType);

    ProjectApplyCodeModel selectByRegIdAndFlowType(@Param("regId") Long regId, @Param("flowType") int flowType);
}