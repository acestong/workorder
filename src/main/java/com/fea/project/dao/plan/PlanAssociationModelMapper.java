package com.fea.project.dao.plan;

import com.fea.project.model.plan.PlanAssociationModel;
import com.fea.project.model.plan.PlanAssociationModelExample;
import com.fea.project.model.plan.vo.BusinessAssociationShowModelVo;
import com.fea.project.model.plan.vo.BusinessAssociationShowModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanAssociationModelMapper {
    long countByExample(PlanAssociationModelExample example);

    int deleteByExample(PlanAssociationModelExample example);
 
    int deleteByPrimaryKey(Long planAssociationId);

    int insert(PlanAssociationModel record);

    int insertSelective(PlanAssociationModel record);
 
    List<PlanAssociationModel> selectByExample(PlanAssociationModelExample example);

    PlanAssociationModel selectByPrimaryKey(Long planAssociationId);

    int updateByExampleSelective(@Param("record") PlanAssociationModel record, @Param("example") PlanAssociationModelExample example);

    int updateByExample(@Param("record") PlanAssociationModel record, @Param("example") PlanAssociationModelExample example);

    int updateByPrimaryKeySelective(PlanAssociationModel record);

    int updateByPrimaryKey(PlanAssociationModel record);
    
    /**
     * 获取所有关联计划模型集合
     */
    List<PlanAssociationModel> selectByExampleWithDelStatus(Long planId);
    
    /**
     * 获取当前计划中，所有关联计划模型集合
     */
    List<BusinessAssociationShowModelVo> selectAllByPlanIdWithDelStatus(PageInfoFromFrontModel page);

    /**
     * 按照关联计划主键获取关联计划模型
     */
    PlanAssociationModel selectByPrimaryKeyWithDelStatus(Long planAssociationId);

    /**
     * 假删除，仅修改数据库的状态
     */
    int updateByPrimaryKeySelectiveWithDelStatus(PlanAssociationModel record);
    
    /**
     * 通过planId返回关联计划信息
     */
    List<BusinessAssociationShowModelVo> selectAssociationInfoByPlanId(Long planId);
    
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