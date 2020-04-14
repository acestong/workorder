package com.fea.project.dao.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.deliverable.vo.QueryDeliverableParamVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.model.task.TaskDeliverProductModelExample;
import com.fea.project.model.task.vo.TaskDeliverProductModelVo;
import com.fea.project.model.task.vo.UpdateBusinessIdInProjectAppendixModelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TaskDeliverProductModelMapper {
    long countByExample(TaskDeliverProductModelExample example);

    int deleteByExample(TaskDeliverProductModelExample example);
 
    int deleteByPrimaryKey(Long deliverProductId);

    int insert(TaskDeliverProductModel record);

    int insertSelective(TaskDeliverProductModel record);

    List<TaskDeliverProductModel> selectByExample(TaskDeliverProductModelExample example);

    TaskDeliverProductModel selectByPrimaryKey(Long deliverProductId);

    int updateByExampleSelective(@Param("record") TaskDeliverProductModel record, @Param("example") TaskDeliverProductModelExample example);

    int updateByExample(@Param("record") TaskDeliverProductModel record, @Param("example") TaskDeliverProductModelExample example);

    int updateByPrimaryKeySelective(TaskDeliverProductModel record);

    int updateByPrimaryKey(TaskDeliverProductModel record);
    
    List<TaskDeliverProductModel> selectAllWithDelStatus(Long taskId);
    
    List<TaskDeliverProductModel> selectAllWithDelStatusWithPage(BasePageInfo<TaskDeliverProductModel> page);

    TaskDeliverProductModelVo selectByPrimaryKeyWithDelStatus(TaskDeliverProductModel record);
    
    int updateByPrimaryKeySelectiveWithDelStatus(TaskDeliverProductModel record);
    
    /*
     * 修改附件表中，businessId的值
     */
    Long updateBusinessIdInTProjectAppendix(UpdateBusinessIdInProjectAppendixModelVo<TaskDeliverProductModel> record);

    /**
     *  获取任务交付物列表（项目交付物模块用）
     *
     */
    List<ProjectDeliverableVo> selectTaskDeliverableVoByProjectId(@Param("paramVo") QueryDeliverableParamVo model);
    /**
     *  获取任务交付物列表（项目交付物模块用）
     *
     */
    ProjectDeliverableVo selectTaskDeliverableInfoById(@Param("id") Long id);
}