package com.fea.project.dao.product;

import com.fea.project.model.product.ProjectProductSpecificModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/20.
 */
@Mapper
public interface ProjectProductSpecificMapper {
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
    int insert(ProjectProductSpecificModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductSpecificModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductSpecificModel model);
    /**
     * 按主键选择
     */
    ProjectProductSpecificModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductSpecificModel> selectByModel(ProjectProductSpecificModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductSpecificModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductSpecificModel model);
    //删除--将删除状态修改为1
    int deleteProductSpecific(Long id);
}