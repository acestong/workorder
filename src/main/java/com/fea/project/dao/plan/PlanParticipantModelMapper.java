package com.fea.project.dao.plan;

import com.fea.project.model.plan.PlanParticipantModel;
import com.fea.project.model.plan.PlanParticipantModelExample;
import com.fea.project.model.plan.vo.IdAndNameModelVo;
import com.fea.project.model.plan.vo.ProjectUserIdAndNameInfoModelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanParticipantModelMapper {
    long countByExample(PlanParticipantModelExample example);

    int deleteByExample(PlanParticipantModelExample example);

    int deleteByPrimaryKey(Long planPanticipantId);
    /**
     * 通过计划id删除
     * @param planPanticipantId
     * @return
     */
    Integer deleteByPlanId(Long planPanticipantId);

    int insert(PlanParticipantModel record);

    int insertSelective(PlanParticipantModel record);
 
    List<PlanParticipantModel> selectByExample(Long planId);

    PlanParticipantModel selectByPrimaryKey(Long planPanticipantId);
    /*
     * 通过计划参与人和计划Id查询一条数据
     */
    PlanParticipantModel selectOneByPlanIdAndPlanPaticipantUserId(PlanParticipantModel planParticipantModel);
    
    /*
     * 通过planId获取 参与人列表
     */
    List<PlanParticipantModel> selectPlanParticipantListByPlanId(Long planId);

    int updateByExampleSelective(@Param("record") PlanParticipantModel record, @Param("example") PlanParticipantModelExample example);

    int updateByExample(@Param("record") PlanParticipantModel record, @Param("example") PlanParticipantModelExample example);

    int updateByPrimaryKeySelective(PlanParticipantModel record);

    int updateByPrimaryKey(PlanParticipantModel record);
    
    int updatePlanId(PlanParticipantModel record);
    
    List<ProjectUserIdAndNameInfoModelVO> selectAllByPlanId(Long planId);
    
    /**
     * 批量添加
     */
    Integer insertByList(@Param("list") List<PlanParticipantModel> list);
    
    /**
     * 获取参与人列表
     * @param planId
     * @return
     */
    List<IdAndNameModelVo> selectInfoListByPlanId(@Param("planId") Long planId);
}