package com.fea.project.workorder.dao;

import com.fea.project.model.BasePageInfo;
import com.fea.project.workorder.model.WorkorderModel;
import com.fea.project.workorder.model.WorkorderModelExample;
import com.fea.project.workorder.model.vo.WorkorderModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderModelMapper {
    long countByExample(WorkorderModelExample example);

    int deleteByExample(WorkorderModelExample example);

    int deleteByPrimaryKey(Long workorderId);

    int insert(WorkorderModel record);

    int insertSelective(WorkorderModel record);

    List<WorkorderModel> selectByExample(WorkorderModelExample example);

    WorkorderModelVo selectByPrimaryKey(Long workorderId);
    /**
     * 查询当前用户创建的列表,create_id是当前用户
     * @return
     */
    List<WorkorderModelVo> selectListByCreateId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询提交给当前用户列表信息 person_id是当前用户，且workorder_status != 未提交状态,且switch_person 是接收人
     * @return
     */
    List<WorkorderModelVo> selectListByPersonId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询当前用户分配的工单列表信息 dispatch_id是当前用户
     * @return
     */
    List<WorkorderModelVo> selectListByDispatchId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询分配当前用户的工单列表信息 dispatch_id不为空，且Person_id是当前用户
     * @return
     */
    List<WorkorderModelVo> selectListByDispatchIdAndPersonId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询抄送给前用户的工单列表信息 cc_person_id中为当前用户对应的工单列表
     * @return
     */
    List<WorkorderModelVo> selectListByCcPersonId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户关注的工单列表信息 attention_id中为当前用户对应的工单列表
     * @return
     */
    List<WorkorderModelVo> selectListByAttentionId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户已完成的工单列表信息  进度为100% 并且工单创建人或负责人是当前用户的工单列表
     * @return
     */
    List<WorkorderModelVo> selectListByRate(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户已激活的工单列表信息  工单创建人或负责人是当前用户的工单列表 并且workorderStatus 是激活状态的工单列表
     * @return
     */
    List<WorkorderModelVo> selectListByRestart(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户已关闭的工单列表信息  工单创建人或负责人是当前用户的工单列表 并且workorderStatus 是关闭状态的工单列表
     * @return
     */
    List<WorkorderModelVo> selectListByClosed(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户参与工单列表信息  工单下工序的负责人或者参与人是当前用户
     * @return
     */
    List<WorkorderModelVo> selectListParticipantUserId(@Param("page") BasePageInfo<WorkorderModelVo> page);
    /**
     * 查询前用户从工单池领取的工单列表信息  工单创建人或负责人是当前用户的工单列表 并且diapatchPoolId 不为空
     * @return
     */
    List<WorkorderModelVo> selectListByDispatchPoolId(@Param("page") BasePageInfo<WorkorderModelVo> page);

    int updateByExampleSelective(@Param("record") WorkorderModel record, @Param("example") WorkorderModelExample example);

    int updateByExample(@Param("record") WorkorderModel record, @Param("example") WorkorderModelExample example);

    int updateByPrimaryKeySelective(WorkorderModel record);

    int updateByPrimaryKey(WorkorderModel record);
    
    List<WorkorderModel> selectAll(Long orgId);
    
    /**
     * 按照工单池Id返回列表，带联系人
     * @return
     */
    List<WorkorderModelVo> selectListByPoolId(@Param("page") BasePageInfo<WorkorderModelVo> page);
}