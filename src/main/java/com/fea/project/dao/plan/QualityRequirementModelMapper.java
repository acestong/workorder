package com.fea.project.dao.plan;

import com.fea.project.model.plan.QualityRequirementModel;
import com.fea.project.model.plan.QualityRequirementModelExample;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityRequirementModelMapper {
    long countByExample(QualityRequirementModelExample example);

    int deleteByExample(QualityRequirementModelExample example);
 
    int deleteByPrimaryKey(Long planQualityRequirementId);

    int insert(QualityRequirementModel record);

    int insertSelective(QualityRequirementModel record);

    List<QualityRequirementModel> selectByExample(QualityRequirementModelExample example);
 
    QualityRequirementModel selectByPrimaryKey(Long planQualityRequirementId);

    int updateByExampleSelective(@Param("record") QualityRequirementModel record, @Param("example") QualityRequirementModelExample example);

    int updateByExample(@Param("record") QualityRequirementModel record, @Param("example") QualityRequirementModelExample example);

    int updateByPrimaryKeySelective(QualityRequirementModel record);

    int updateByPrimaryKey(QualityRequirementModel record);
    
    /**
     * 获取所有质量要求模型集合
     */
    List<QualityRequirementModel> selectByExampleWithDelStatus(Long planId);
    
    /**
     * 获取本计划中，获取所有的质量要求模型集合
     */
    List<QualityRequirementModel> selectAllByPlanIdWithDelStatus(PageInfoFromFrontModel page);

    /**
     * 通过质量要求id,查询一个质量要求模型
     */
    QualityRequirementModel selectByPrimaryKeyWithDelStatus(Long planQualityRequirementId);
    
    /**
     * 假删除，仅修改数据库中状态，不做删除
     */
    int updateByPrimaryKeySelectiveWithDelStatus(QualityRequirementModel record);
    
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