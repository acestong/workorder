package com.fea.project.dao.risk;

import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.risk.ProjectRiskAssessModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Mapper
public interface ProjectRiskAssessMapper {
    /**
     * 新建项目风险评估
     */
    int insertSelective(ProjectRiskAssessModel model);
    /**
     *分页查询项目风险评估列表
     */
    List<ProjectRiskAssessModel> selectByFilterAndParams(PageInfoQueryOrderAndFilterModel<ProjectRiskAssessModel> model);
    /**
     * 项目风险评估详情
     */
    ProjectRiskAssessModel selectById(Long id);
    /**
     * 按主键更新,字段为空时不更新（风险评估内容）
     */
    int updateByIdSelective(ProjectRiskAssessModel model);
    /**
     * 按主键删除项目风险评估
     */
    int deleteProjectRiskAssess(Long id);
    /**
     * 项目风险评估提交审批
     */
    int checkSubmit(ProjectRiskAssessModel model);
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
    int insert(ProjectRiskAssessModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRiskAssessModel> models);
    /**
     * 按模型选择
     */
    List<ProjectRiskAssessModel> selectByModel(ProjectRiskAssessModel model);
    /**
     *
     */
    int updateById(ProjectRiskAssessModel model);
}