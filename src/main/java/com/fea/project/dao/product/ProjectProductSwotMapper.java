package com.fea.project.dao.product;

import com.fea.project.model.product.ProjectProductSwotModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/20.
 */
@Mapper
public interface ProjectProductSwotMapper {
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
    int insert(ProjectProductSwotModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductSwotModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductSwotModel model);
    /**
     * 按主键选择
     */
    ProjectProductSwotModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductSwotModel> selectByModel(ProjectProductSwotModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductSwotModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductSwotModel model);
}