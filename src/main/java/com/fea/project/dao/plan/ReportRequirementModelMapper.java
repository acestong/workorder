package com.fea.project.dao.plan;

import com.fea.project.model.plan.ReportRequirementModel;
import com.fea.project.model.plan.ReportRequirementModelExample;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportRequirementModelMapper {
    long countByExample(ReportRequirementModelExample example);

    int deleteByExample(ReportRequirementModelExample example);

    int deleteByPrimaryKey(Long planReportRequirementId);
 
    int insert(ReportRequirementModel record);

    int insertSelective(ReportRequirementModel record);

    List<ReportRequirementModel> selectByExample(ReportRequirementModelExample example);
 
    ReportRequirementModel selectByPrimaryKey(Long planReportRequirementId);

    int updateByExampleSelective(@Param("record") ReportRequirementModel record, @Param("example") ReportRequirementModelExample example);

    int updateByExample(@Param("record") ReportRequirementModel record, @Param("example") ReportRequirementModelExample example);

    int updateByPrimaryKeySelective(ReportRequirementModel record);

    int updateByPrimaryKey(ReportRequirementModel record);
    
    /**
     * 获取所有的非删除状态下的汇报要求模型集合
     */
    List<ReportRequirementModel> selectByExampleWithDelStatus(Long planId);
    
    /**
     * 在本计划中，获取所有非删除状态下的汇报要求模型集合
     */
    List<ReportRequirementModel> selectAllByPlanIdWithDelStatus(PageInfoFromFrontModel page);

    /**
     * 通过汇报要求主键查询汇报要求模型
     */
    ReportRequirementModel selectByPrimaryKeyWithDelStatus(Long id);
    
    /**
     * 假删除，通过修改数据库中的状态，不做真实删除
     */
    int updateByPrimaryKeySelectiveWithDelStatus(ReportRequirementModel record);
    
    /**
     * 修改附件表中，businessId的值
     */
    int updateBusinessIdInTProjectAppendix(UpdateBusinessIdInProjectAppendixModelVo record);
    
    /**
     * 批量修改关联要求的业务id
     */
    Integer updateByList(@Param("businessId") Long businessId , @Param("list") List<Long>list);
    
    /**
     * 通过businessId 统一删除
     * @param businessId
     * @return
     */
    Integer deleteByBusinessId(Long businessId);

}