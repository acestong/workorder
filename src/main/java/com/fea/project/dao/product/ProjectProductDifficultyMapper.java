package com.fea.project.dao.product;

import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.product.ProjectProductDifficultyModel;
import java.util.List;

/**
 * Created by Administrator on 2020/03/23.
 */
public interface ProjectProductDifficultyMapper {
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
    int insert(ProjectProductDifficultyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductDifficultyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductDifficultyModel model);
    /**
     * 按主键选择
     */
    ProjectProductDifficultyModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductDifficultyModel> selectByModel(ProjectProductDifficultyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductDifficultyModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductDifficultyModel model);
    //分页查询生产及研发难度分析列表
    List<ProjectProductDifficultyModel> selectByFilterAndParams(PageInfoQueryOrderAndFilterModel<ProjectProductDifficultyModel> model);
    //删除--将删除状态修改为1
    int deleteProductDifficulty(Long id);

}