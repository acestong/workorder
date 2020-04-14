package com.fea.project.dao.risk;

import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Mapper
public interface ProjectRiskAssessPlanMapper {
    /**
     * 按模型选择-根据项目风险id选择
     */
    List<ProjectRiskAssessPlanModel> selectByModel(ProjectRiskAssessPlanModel model);
    /**
     * 删除--将删除状态修改为1
     */
    int deleteProjectRiskAssessPlan(ProjectRiskAssessPlanModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRiskAssessPlanModel model);
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
    int insert(ProjectRiskAssessPlanModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRiskAssessPlanModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRiskAssessPlanModel model);
    /**
     * 按主键选择
     */
    ProjectRiskAssessPlanModel selectById(Long id);
    /**
     * 按主键更新
     */
    int updateById(ProjectRiskAssessPlanModel model);
}