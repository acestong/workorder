package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.AttentionModel;
import com.fea.project.workorder.model.AttentionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionModelMapper {
    long countByExample(AttentionModelExample example);

    int deleteByExample(AttentionModelExample example);

    int deleteByPrimaryKey(Long attentionId);

    int insert(AttentionModel record);

    int insertSelective(AttentionModel record);

    List<AttentionModel> selectByExample(AttentionModelExample example);

    AttentionModel selectByPrimaryKey(Long attentionId);
    
    Long selectByWorkorderId(Long workorderId);

    int updateByExampleSelective(@Param("record") AttentionModel record, @Param("example") AttentionModelExample example);

    int updateByExample(@Param("record") AttentionModel record, @Param("example") AttentionModelExample example);

    int updateByPrimaryKeySelective(AttentionModel record);

    int updateByPrimaryKey(AttentionModel record);
    
    int updateByWorkorderId(AttentionModel record);
}