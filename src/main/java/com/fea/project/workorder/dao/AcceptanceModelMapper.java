package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.AcceptanceModel;
import com.fea.project.workorder.model.AcceptanceModelExample;
import com.fea.project.workorder.model.vo.AcceptanceModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcceptanceModelMapper {
    long countByExample(AcceptanceModelExample example);

    int deleteByExample(AcceptanceModelExample example);

    int deleteByPrimaryKey(Long acceptanceId);

    int insert(AcceptanceModel record);

    int insertSelective(AcceptanceModel record);

    List<AcceptanceModel> selectByExample(AcceptanceModelExample example);

    AcceptanceModelVo selectByPrimaryKey(Long acceptanceId);
    
    List<AcceptanceModelVo> selectListByWorkorderId(Long workorderId);

    int updateByExampleSelective(@Param("record") AcceptanceModel record, @Param("example") AcceptanceModelExample example);

    int updateByExample(@Param("record") AcceptanceModel record, @Param("example") AcceptanceModelExample example);

    int updateByPrimaryKeySelective(AcceptanceModel record);

    int updateByPrimaryKey(AcceptanceModel record);
}