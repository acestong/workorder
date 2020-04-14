package com.fea.project.dao.project;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectExternalContactorModel;
import com.fea.project.model.project.pojo.ProjectExternalContactorPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */
public interface ProjectExternalContactorMapper {
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
    int insert(ProjectExternalContactorModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectExternalContactorModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectExternalContactorModel model);

    /**
     * 按主键选择
     */
    ProjectExternalContactorModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectExternalContactorModel> selectByModel(ProjectExternalContactorModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectExternalContactorModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectExternalContactorModel model);

    List<ProjectExternalContactorModel> selectByFilterAndOrderParams(BasePageInfo<ProjectExternalContactorModel> model);

    int updateModelsByIds(@Param("model") ProjectExternalContactorPojo model, @Param("list") List<Long> ids);
}