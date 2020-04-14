package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.ProcedureModel;
import com.fea.project.workorder.model.ProcedureModelExample;
import com.fea.project.workorder.model.vo.ProcedureModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcedureModelMapper {
    long countByExample(ProcedureModelExample example);

    int deleteByExample(ProcedureModelExample example);

    int deleteByPrimaryKey(Long procedureId);
    
    /**
     * 通过工单id删除工序
     * @param workorderId
     * @return
     */
    int deleteByWorkorderId(Long workorderId);

    int insert(ProcedureModel record);

    int insertSelective(ProcedureModel record);
    /**
     * 按列表添加工序
     */
    int insertByList(@Param("mouldId") Long mouldId ,@Param("list")List<ProcedureModelVo> list ,@Param("createId") Long createId , @Param("createBy") String createBy);
    /**
     * 按列表添加工序
     */
    Integer insertByListAndWorkorderId(@Param("workorderId") Long workorderId ,@Param("list")List<ProcedureModelVo> list );

    List<ProcedureModel> selectByExample(ProcedureModelExample example);

    ProcedureModelVo selectByPrimaryKey(Long procedureId);
    
    /**
     * 获取当前工单下的所有工序列表
     * @param workorderId
     * @return
     */
    List<ProcedureModelVo> selectListByWorkorderId(Long workorderId);

    int updateByExampleSelective(@Param("record") ProcedureModel record, @Param("example") ProcedureModelExample example);

    int updateByExample(@Param("record") ProcedureModel record, @Param("example") ProcedureModelExample example);
    
    /**
     * 批量修改mouldId
     */
    int updateMouldIdByProcedureIdList(@Param("list") List<Long> list, @Param("mouldId") Long mouldId);

    int updateByPrimaryKeySelective(ProcedureModel record);

    int updateByPrimaryKey(ProcedureModel record);
    
    /**
     * 按照mouldId或者workorderId 将所有大于当前排序的procedureOrderNum进行自增操作
     * @param record
     * @return
     */
    int updateProcedureOrderNum(ProcedureModelVo modelVo);
    
    /**
     * 获取我负责的工序列表
     * @return
     */
    List<ProcedureModelVo> selectListByLeaderId();
    /**
     * 获取我参与的工序列表
     * @return
     */
    List<ProcedureModelVo> selectListByParticipantUserId();
}