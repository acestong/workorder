package com.fea.project.dao.plan;

import com.fea.project.model.plan.DeliverRequirementModel;
import com.fea.project.model.plan.DeliverRequirementModelExample;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliverRequirementModelMapper {
    long countByExample(DeliverRequirementModelExample example);
 
    int deleteByExample(DeliverRequirementModelExample example);

    int deleteByPrimaryKey(Long planDeliverRequirementId);
    /**
     * 通过businessId 统一删除
     * @param businessId
     * @return
     */
    Integer deleteByBusinessId(Long businessId);

    int insert(DeliverRequirementModel record);

    int insertSelective(DeliverRequirementModel record);

    List<DeliverRequirementModel> selectByExample(DeliverRequirementModelExample example);

    DeliverRequirementModel selectByPrimaryKey(Long planDeliverRequirementId);

    int updateByExampleSelective(@Param("record") DeliverRequirementModel record, @Param("example") DeliverRequirementModelExample example);

    int updateByExample(@Param("record") DeliverRequirementModel record, @Param("example") DeliverRequirementModelExample example);

    int updateByPrimaryKeySelective(DeliverRequirementModel record);

    int updateByPrimaryKey(DeliverRequirementModel record);
    
    /*
     * 查找所有为非删除状态下的集合
     */
    List<DeliverRequirementModel> selectByExampleWithDelStatus(Long planId);

    /*
     * 查找所有当前计划下非删除状态下的集合
     */
    List<DeliverRequirementModel> selectAllByPlanIdWithDelStatus(PageInfoFromFrontModel page);
    
    
    /*
     * 查找非删除状态下的单个交付要求模型
     */
    DeliverRequirementModel selectByPrimaryKeyWithDelStatus(Long planDeliverRequirementId);
    
    /* 
     * 删除非删除状态下的单个交付要求模型
     */
    int updateByPrimaryKeySelectiveWithDelStatus(DeliverRequirementModel record);
    
    /*
     * 修改附件表中，businessId的值
     */
    int updateBusinessIdInTProjectAppendix(UpdateBusinessIdInProjectAppendixModelVo record);
    
    List<DeliverRequirementModel> selectAssociationInfoByPlanId(Long planId);
    
    /*
     * 批量修改交付要求的业务id
     */
    Integer updateByList(@Param("businessId") Long businessId , @Param("list") List<Long>list);
}