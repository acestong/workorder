package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.WorkorderRecordModel;
import com.fea.project.workorder.model.WorkorderRecordModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderRecordModelMapper {
    long countByExample(WorkorderRecordModelExample example);

    int deleteByExample(WorkorderRecordModelExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(WorkorderRecordModel record);

    int insertSelective(WorkorderRecordModel record);

    List<WorkorderRecordModel> selectByExample(WorkorderRecordModelExample example);
    
    /**
     * 获取操作记录列表
     * @param workorderId
     * @return
     */
    List<WorkorderRecordModel> selectByWorkorderId(Long workorderId);

    WorkorderRecordModel selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") WorkorderRecordModel record, @Param("example") WorkorderRecordModelExample example);

    int updateByExample(@Param("record") WorkorderRecordModel record, @Param("example") WorkorderRecordModelExample example);

    int updateByPrimaryKeySelective(WorkorderRecordModel record);

    int updateByPrimaryKey(WorkorderRecordModel record);
}