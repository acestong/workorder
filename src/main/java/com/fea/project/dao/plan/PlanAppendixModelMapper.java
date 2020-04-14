package com.fea.project.dao.plan;

import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.plan.PlanAppendixModelExample;
import com.fea.project.model.plan.vo.AppendixModelVo;
import com.fea.project.model.plan.vo.BusinessAppendixModelVo;
import com.fea.project.model.plan.vo.PageInfoFromFrontModel;
import com.fea.project.model.plan.vo.UpdateBusinessIdInProjectAppendixModelVo;
import com.fea.project.model.projectdata.AppendixDataFileVo;
import com.fea.project.model.projectdata.IdsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanAppendixModelMapper {
    long countByExample(PlanAppendixModelExample example);
 
    int deleteByExample(PlanAppendixModelExample example);

    int deleteByPrimaryKey(Long planAppendixId);

    int insert(PlanAppendixModel record);
 
    int insertSelective(PlanAppendixModel record); 

    List<PlanAppendixModel> selectByExample(PlanAppendixModelExample example);

    PlanAppendixModel selectByPrimaryKey(@Param("businessAppendixId") Long planAppendixId);
    
    BusinessAppendixModelVo selectByBusinessAppendixId(@Param("businessAppendixId") Long businessAppendixId);

    int updateByExampleSelective(@Param("record") PlanAppendixModel record, @Param("example") PlanAppendixModelExample example);

    int updateByExample(@Param("record") PlanAppendixModel record, @Param("example") PlanAppendixModelExample example);

    int updateByPrimaryKeySelective(PlanAppendixModel record);

    int updateByPrimaryKey(PlanAppendixModel record);
    
    /**
     * 获取当前计划Id下，所有非删除状态下的计划附件集合
     */
    List<PlanAppendixModel> selectByExampleWithDelStatus(Long BusinessId);
    
    /**
     * 获取当前计划中，所有非删除状态下的计划附件集合
     */
    List<AppendixModelVo> selectAllByBusinessIdWithDelStatus(PageInfoFromFrontModel page);

    /**
     * 按计划附件主键获取一个计划附件模型
     */
    PlanAppendixModel selectByPrimaryKeyWithDelStatus(Long planAppendixId);
    
    /**
     * 假删除，仅对数据库做状态的修改
     */
    int updateByPrimaryKeySelectiveWithDelStatus(PlanAppendixModel record);
    
    /**
     * 修改附件表中，businessId的值
     */
    int updateBusinessIdInTProjectAppendix(UpdateBusinessIdInProjectAppendixModelVo<PlanAppendixModel> model);
    /**
     * 获取计划，任务的资料
     * @param ids businessId和createId的集合
     * @return
     */
    List<AppendixDataFileVo> selectAppendixByIdsAndProjectId(@Param("ids") IdsVo ids);
    
    /**
     * 批量修改businessId等信息
     */
    Integer updateByList(@Param("businessId") Long businessId , @Param("list") List<Long> list,@Param("businessName") String businessName,
    		@Param("projectId") Long projectId, @Param("projectStep")Long projectStep);
    
    /**
     * 通过businessId 统一删除
     * @param businessId
     * @return
     */
    Integer deleteByBusinessId(Long businessId);

}