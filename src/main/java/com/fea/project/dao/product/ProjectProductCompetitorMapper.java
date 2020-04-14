package com.fea.project.dao.product;

import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.product.ProjectProductCompetitorModel;
import com.fea.project.model.risk.ProjectRiskModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/03/23.
 */
@Mapper
public interface ProjectProductCompetitorMapper {
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
    int insert(ProjectProductCompetitorModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectProductCompetitorModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectProductCompetitorModel model);
    /**
     * 按主键选择
     */
    ProjectProductCompetitorModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectProductCompetitorModel> selectByModel(ProjectProductCompetitorModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectProductCompetitorModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectProductCompetitorModel model);
    //分页查询竞争对手分析列表
    List<ProjectProductCompetitorModel> selectByFilterAndParams(PageInfoQueryOrderAndFilterModel<ProjectProductCompetitorModel> model);
    //删除--将删除状态修改为1
    int deleteProductCompetitor(Long id);
}