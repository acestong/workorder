package com.fea.project.dao.product;

import com.fea.project.model.product.ProjectProductAppendixModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/23.
 */
@Mapper
public interface ProjectProductAppendixMapper {
    //删除--将删除状态修改为1
    int deleteProductAppendix(Long id);
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
    int insert(ProjectProductAppendixModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductAppendixModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductAppendixModel model);
    /**
     * 按主键选择
     */
    ProjectProductAppendixModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductAppendixModel> selectByModel(ProjectProductAppendixModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductAppendixModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductAppendixModel model);
}