package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.ParticipantModel;
import com.fea.project.workorder.model.ParticipantModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParticipantModelMapper {
    long countByExample(ParticipantModelExample example);

    int deleteByExample(ParticipantModelExample example);

    int deleteByPrimaryKey(Long participantId);

    int insert(ParticipantModel record);

    int insertSelective(ParticipantModel record);
    
    /**
     * 按列表插入
     */
    int insertByList(@Param("list")List<ParticipantModel> list,@Param("businessType") Long businessType,@Param("businessId") Long businessId);

    List<ParticipantModel> selectByExample(ParticipantModelExample example);

    ParticipantModel selectByPrimaryKey(Long participantId);

    int updateByExampleSelective(@Param("record") ParticipantModel record, @Param("example") ParticipantModelExample example);

    int updateByExample(@Param("record") ParticipantModel record, @Param("example") ParticipantModelExample example);

    int updateByPrimaryKeySelective(ParticipantModel record);

    int updateByPrimaryKey(ParticipantModel record);
}