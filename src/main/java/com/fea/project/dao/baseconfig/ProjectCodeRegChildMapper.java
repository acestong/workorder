package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeRegChildModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
public interface ProjectCodeRegChildMapper {
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
    int insert(ProjectCodeRegChildModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodeRegChildModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodeRegChildModel model);

    /**
     * 按主键选择
     */
    ProjectCodeRegChildModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodeRegChildModel> selectByModel(ProjectCodeRegChildModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodeRegChildModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodeRegChildModel model);

    ProjectCodeRegChildModel selectByParentCode(@Param("parentProjectCode") String code, @Param("regId") Long regId);
}