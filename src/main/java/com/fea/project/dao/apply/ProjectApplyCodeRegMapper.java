package com.fea.project.dao.apply;

import com.fea.project.model.apply.ProjectApplyCodeRegModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 * 项目组织编号 mapper
 */
public interface ProjectApplyCodeRegMapper {
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
    int insert(ProjectApplyCodeRegModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyCodeRegModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyCodeRegModel model);

    /**
     * 按主键选择
     */
    ProjectApplyCodeRegModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyCodeRegModel> selectByModel(ProjectApplyCodeRegModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyCodeRegModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyCodeRegModel model);

    ProjectApplyCodeRegModel selectByRegIdAndFlowType(@Param("regId") Long regId, @Param("flowType") Integer flowType);
}