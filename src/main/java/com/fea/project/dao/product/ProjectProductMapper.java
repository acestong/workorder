package com.fea.project.dao.product;

import com.fea.project.model.product.ProjectProductModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/19.
 */
@Mapper
public interface ProjectProductMapper {
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
    int insert(ProjectProductModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductModel model);
    /**
     * 按主键选择
     */
    ProjectProductModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductModel> selectByModel(ProjectProductModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductModel model);
}