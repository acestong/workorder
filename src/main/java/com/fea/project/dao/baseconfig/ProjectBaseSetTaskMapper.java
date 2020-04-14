package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/05.
 */
public interface ProjectBaseSetTaskMapper {
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
    int insert(ProjectBaseSetTaskModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectBaseSetTaskModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectBaseSetTaskModel model);

    /**
     * 按主键选择
     */
    ProjectBaseSetTaskModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectBaseSetTaskModel> selectByModel(ProjectBaseSetTaskModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectBaseSetTaskModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectBaseSetTaskModel model);

    int deleteByRegIdAndNotInIds(@Param("regId") Long regId, @Param("list") List<Long> ids);

    ProjectBaseSetTaskModel selectByRegIdAndTypeId(@Param("regId") Long regId, @Param("typeId") Integer typeId);
}