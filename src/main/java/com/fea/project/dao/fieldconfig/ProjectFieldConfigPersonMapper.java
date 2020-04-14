package com.fea.project.dao.fieldconfig;

import com.fea.project.model.fieldconfig.ProjectFieldConfigPersonModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/19.
 */
public interface ProjectFieldConfigPersonMapper {
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
    int insert(ProjectFieldConfigPersonModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFieldConfigPersonModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFieldConfigPersonModel model);
    /**
     * 按主键选择
     */
    ProjectFieldConfigPersonModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectFieldConfigPersonModel> selectByModel(ProjectFieldConfigPersonModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFieldConfigPersonModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectFieldConfigPersonModel model);

    int deleteByTypeIdAndUserId(@Param("typeId") Integer typeId, @Param("userId") Long userId);
}