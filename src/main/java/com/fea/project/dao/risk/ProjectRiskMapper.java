package com.fea.project.dao.risk;

import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.risk.ProjectRiskModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Mapper
public interface ProjectRiskMapper {
    /**
     * 新增项目风险
     */
    int insertSelective(ProjectRiskModel model);
    /**
     *分页查询项目风险列表
     */
    List<ProjectRiskModel> selectByFilterAndParams(PageInfoQueryOrderAndFilterModel<ProjectRiskModel> model);
    /**
     * 项目风险详情
     */
    ProjectRiskModel selectById(Long id);
    /**
     * 按主键更新,字段为空时不更新(风险应对措施+风险应急计划）
     */
    int updateByIdSelective(ProjectRiskModel model);
    /**
     * 按模型选择-风险预警
     */
    List<ProjectRiskModel> selectByModel(ProjectRiskModel model);
    /**
     * 按主键删除项目风险
     */
    int deleteProjectRisk(Long id);
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
    int insert(ProjectRiskModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRiskModel> models);
    /**
     * 按主键更新
     */
    int updateById(ProjectRiskModel model);
}