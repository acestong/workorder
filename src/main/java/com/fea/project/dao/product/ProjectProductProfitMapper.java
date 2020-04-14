package com.fea.project.dao.product;

import com.fea.project.model.product.ProjectProductProfitModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/27.
 */
@Mapper
public interface ProjectProductProfitMapper {
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
    int insert(ProjectProductProfitModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductProfitModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductProfitModel model);
    /**
     * 按主键选择
     */
    ProjectProductProfitModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductProfitModel> selectByModel(ProjectProductProfitModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductProfitModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductProfitModel model);
    /**
     * 上移
     */
    ProjectProductProfitModel moveUp(Integer sort);
    /**
     *  下移
     */
    ProjectProductProfitModel moveDown(Integer sort);
}