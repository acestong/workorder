package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/05.
 */
public interface ProjectBaseSetPlanMapper {
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
    int insert(ProjectBaseSetPlanModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBaseSetPlanModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBaseSetPlanModel model);

    /**
     * 按主键选择
     */
    ProjectBaseSetPlanModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBaseSetPlanModel> selectByModel(ProjectBaseSetPlanModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBaseSetPlanModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBaseSetPlanModel model);

    int deleteByRegIdAndNotInIds(@Param("regId") Long regId, @Param("list") List<Long> ids);

    ProjectBaseSetPlanModel selectByRegIdAndTypeId(@Param("regId") Long regId, @Param("typeId") Integer typeId);
}