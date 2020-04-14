package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.model.project.vo.ProjectViewSelfConfigVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface ProjectViewSelfConfigMapper {
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
    int insert(ProjectViewSelfConfigModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectViewSelfConfigModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectViewSelfConfigModel model);

    /**
     * 按主键选择
     */
    ProjectViewSelfConfigModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectViewSelfConfigModel> selectByModel(ProjectViewSelfConfigModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectViewSelfConfigModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectViewSelfConfigModel model);

    int deleteByViewId(@Param("viewId") Long viewId);

    List<ProjectViewSelfConfigVo> selectByViewId(@Param("viewId") Long viewId);
}