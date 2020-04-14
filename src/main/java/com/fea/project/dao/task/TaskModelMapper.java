package com.fea.project.dao.task;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.TaskModelExample;
import com.fea.project.model.task.vo.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TaskModelMapper {
    long countByExample(TaskModelExample example);

    int deleteByExample(TaskModelExample example);

    int deleteByPrimaryKey(Long taskId);
 
    int insert(TaskModel record);

    int insertSelective(TaskModel record);

    List<TaskModel> selectByExample(TaskModelExample example);
    //获取起始时间段内的任务列表
    List<TaskModel> selectBetweenStartAndEndTaskList(TaskModel record);

    TaskModel selectByPrimaryKey(Long taskId);
    
    int updateByExampleSelective(@Param("record") TaskModel record, @Param("example") TaskModelExample example);

    int updateByExample(@Param("record") TaskModel record, @Param("example") TaskModelExample example);

    int updateByPrimaryKeySelective(TaskModel record);

    int updateByPrimaryKey(TaskModel record);
    
    List<TaskModel> selectAll();
    
    /*
     * 根据所需条件查询任务列表
     */
    List<TaskAndSonTaskModelVo> selectTaskListByCondition(BasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 获取我的任务草稿
     */
    List<TaskAndSonTaskModelVo> selectMyDraftTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    
    /*
     * 通过项目Id返回所有任务，此时当前计划未创建，查出即所有项目任务的父计划
     */
    List<TaskModel> selectParentTaskModelByProjectId(Long projectId);
    /*
     * 通过任务来源Id返回所有任务，此时当前计划未创建，查出即所有业务任务的父计划
     */
    List<TaskModel> selectParentTaskModelByResourceBusinessIdId(Long projectId);
    
    /*
     * 返回所有任务，此时当前计划未创建，查出即所有常规任务的父计划
     */
    List<TaskModel> selectParentTaskModel();
    
  
    /*
     * 通过项目Id查找项目ID及项目名
     */
    ProjectUserIdAndNameInfoModelVo selectProjectIdAndName(Long projectId);
    
    /*
     * 通过项目Id查找团队ID及项目名
     */
    List<ProjectUserIdAndNameInfoModelVo> selectTeamIdAndName(Long projectId);
    
    /*
     * 通过项目Id及团队Id查找团队成员ID及姓名
     */
    List<ProjectUserIdAndNameInfoModelVo> selectUserIdAndName(ProjectUserIdAndNameInfoModelVo model);
    
    /*
     * 通过projectId查找所有的团队负责人
     */
    List<TeamLeaderAndGroupInfoModelVo> selectGroupLeaderByProjectId(Long projectId);
    
    /*
     * 通过父任务taskId 查询所有的子任务
     */
    List<TaskAndSonTaskModelVo> selectSonTaskModel(TaskAndSonTaskModelVo taskAndSonTaskModelVo);
    
    /*
     * 修改各个模块与任务表的关联关系
     */
    int updateTaskAppendixId(TaskWithAllAppendixModelVo record);
    int updateQualityRequirementId(TaskWithAllAppendixModelVo record);
    int updateDeliverRequirementId(TaskWithAllAppendixModelVo record);
    int updateTaskAssociationId(TaskWithAllAppendixModelVo record);
    int updateTaskReportRequirementId(TaskWithAllAppendixModelVo record);
    
    /*
     * 通过任务Id，获取到 TaskAndSonTaskModelVo 模型（封装带子任务的taskModel模型）

     */
    TaskAndSonTaskModelVo selectByPrimaryKeyWithDelStatus(Long taskId);


    /*
     * 返回所有的任务数
     */
    Integer selectTotalTask();
    /*
     * 返回所有的未开始任务数
     */
    Integer selectUnstartTask();
    /*
     * 返回进行中的项目，在起止时间中，或者进度在0-100之间
     */
    Integer selectProcedingTask();
    /*
     * 已完成的任务
     */
    Integer selectFinishedTask();
    /*
     * 未评论的任务
     */
    Integer selectUncommentedTask();
    /*
     * 已评论的任务
     */
    Integer selectCommentedTask();

    /*
     * 返回当前任务下的子计划中的平均得分
     */
    Double selectChildrenTaskAvgScore(Long parentTaskId);

    /**
     * 获取任务IDS
     * @param projectId 项目id
     * @return
     */
    List<Long> selectTaskIdByProjectId(Long projectId);
    /**
     * 获取计划转任务IDS
     * @param projectId 项目id
     * @return
     */
    List<Long> selectPlanTaskIdByProjectId(Long projectId);
    /*
     * 按照我的任务草稿计数
     */
    Long selectMyDrawfTaskCount(TaskModel taskModel);
    /*
     * 按照我负责的计划计数
     */
    Long selectMyResponsibleTaskCount(TaskModel taskModel);
    /*
     * 按照分配给我的计数
     */
    Long selectDiapatchedTaskToMeCount(TaskModel taskModel);
    /*
     * 按照我分配的任务计数
     */
    Long selectDispatchTaskByMeCount(TaskModel taskModel);
    /*
     * 按照我参与的任务计数
     */
    Long selectParticipatedTaskByMeCount(TaskModel taskModel);
    /*
     * 按照我参与的任务计数
     */
    Long selectAttentionedTaskByMeCount(TaskModel taskModel);

    /*
     * 按照我的被评价任务计数
     */
    Long selectMyCommentedTaskCount(TaskModel taskModel);
    /*
     * 按照我的需评价任务计数
     */
    Long selectCommentTaskByMeCount(TaskModel taskModel);

    /*
     * 根据项目阶段和项目id查所有项目
     */
    List<TaskModelVo> selectTaskByProjectStepAndProjectId(TaskModel taskModel);
    /*
     * 根据项目id查所有任务,关联任务时返回所有任务接口，包含所有任务以及子任务
     */
    List<TaskAndSonTaskModelVo> selectTaskByProjectId(BasePageInfo<TaskAndSonTaskModelVo> page);

    /*
     * 根据所需条件查询任务列表
     */
    List<TaskAndSonTaskModelVo> selectTaskByProjectIdOrTaskTeamIdOrTaskLeaderId(BasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 根据计划转任务的计划id获取对应任务信息
     *
     */
    TaskModel selectByPlanTransferId(Long planTransferId);
    //根据用户id查询其任务id的list
    List<TaskModel> selectTaskIdByUserId(Long taskLeaderId);
    
    /*
     * 获取当前用户的工作状态信息
     */
    WorkStatusVo selectCurWorkStatusByCurUserInfo(Long curUserId);
    
    /*
     * 通过项目id查询所有的任务集合
     */
    List<TaskAndSonTaskModelVo> selectTaskListByProjectId(Long projectId);

    List<TaskAndSonTaskModelVo> selectTaskModelByMilestoneId(Long milestoneId);

    /**
     * 删除里程碑关联关系
     *
     */
    int cancelMilestone(List<Long> ids);
    
    /*
     * 通过Model中的个属性 并列查找所有的TaskModel集合
     */
    List<TaskModel> selectByModel(TaskModel taskModel);
    
    /*
     * 通过parentTaskId 查找所有父任务的taskId和parentTaskId
     */
    List<TaskAndSonTaskModelVo> selectModelByParentTaskId(Long parentTaskId);
    
    /*
     * 获取我的任务草稿，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
     */
    List<TaskAndSonTaskModelVo> selectMyDrawfTaskList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 获取我负责的任务，如果我的任务仅是子任务，则返回当前子任务的父任务带所有子任务的列表
     */
    List<TaskAndSonTaskModelVo> selectMyResponibleTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 分配给我的任务 taskDispatchUserId 被分配人是我
     */
    List<TaskAndSonTaskModelVo> selectDispatchToMeTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 我分配的任务 taskDispatcherId 分配人是我
     */
    List<TaskAndSonTaskModelVo> selectDispatchByMeTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 我参与的任务 任务参与人是我 或者子任务的负责人是我
     */
    List<TaskAndSonTaskModelVo> selectMyParticipantTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 我关注的任务
     */
    List<TaskAndSonTaskModelVo> selectMyAttentionTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 我的评价任务，别人将我的任务设为需评价的任务
     */
    List<TaskAndSonTaskModelVo> selectMyCommentTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    /*
     * 我的评价任务，别人将我的任务设为需评价的任务
     */
    List<TaskAndSonTaskModelVo> selectNeedToCommentTaskTempList(TaskBasePageInfo<TaskAndSonTaskModelVo> page);
    
    /*
     * 传入起始时间，查询当前起始时间端之间是否有其他的工作任务
     */
    Integer selectExistedWorkTaskIdCount(TaskModel taskModel);
    
    String selectTaskName(Long taskId);
    
    Long selectPriority(Long taskId);
    
    BigDecimal selectAvgRateByProjectId(@Param("id") Long id);
    
    /**
     * 删除接口
     * @param taskId
     * @return
     */
    Integer updateToDelete(Long taskId);
}