package com.fea.project.dao.base;

import com.fea.project.model.base.ProjectDictionaryItemModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/25.
 */
public interface ProjectDictionaryItemMapper {
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
    int insert(ProjectDictionaryItemModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectDictionaryItemModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectDictionaryItemModel model);

    /**
     * 按主键选择
     */
    ProjectDictionaryItemModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectDictionaryItemModel> selectByModel(ProjectDictionaryItemModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectDictionaryItemModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectDictionaryItemModel model);

    List<ProjectDictionaryItemModel> selectByShortNameAndRegIdAndDelStatus(
            @Param("shortName") String shortName, @Param("regId") Long regId, @Param("delStatus") Integer delStatus);

    List<ProjectDictionaryItemModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectDictionaryItemModel> selectTreeById(@Param("id") Long id);
}