package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeRegModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 * 项目组织编号 mapper
 */
public interface ProjectCodeRegMapper {
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
    int insert(ProjectCodeRegModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodeRegModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodeRegModel model);

    /**
     * 按主键选择
     */
    ProjectCodeRegModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodeRegModel> selectByModel(ProjectCodeRegModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodeRegModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodeRegModel model);

    ProjectCodeRegModel selectByRegId(@Param("regId") Long regId);

    int updateCloseByRegId(@Param("regId") Long regId);
}