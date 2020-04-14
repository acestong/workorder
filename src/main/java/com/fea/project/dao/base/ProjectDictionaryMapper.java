package com.fea.project.dao.base;

import com.fea.project.model.base.ProjectDictionaryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/25.
 */
public interface ProjectDictionaryMapper {
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
    int insert(ProjectDictionaryModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectDictionaryModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectDictionaryModel model);

    /**
     * 按主键选择
     */
    ProjectDictionaryModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectDictionaryModel> selectByModel(ProjectDictionaryModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectDictionaryModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectDictionaryModel model);

    List<ProjectDictionaryModel> selectByRegId(@Param("regId") Long regId);
}