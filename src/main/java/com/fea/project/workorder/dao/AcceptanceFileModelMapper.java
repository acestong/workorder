package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.AcceptanceFileModel;
import com.fea.project.workorder.model.AcceptanceFileModelExample;
import com.fea.project.workorder.model.vo.AcceptanceFileModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcceptanceFileModelMapper {
    long countByExample(AcceptanceFileModelExample example);

    int deleteByExample(AcceptanceFileModelExample example);

    int deleteByPrimaryKey(Long acceptanceFileId);

    int insert(AcceptanceFileModel record);

    int insertSelective(AcceptanceFileModel record);

    List<AcceptanceFileModel> selectByExample(AcceptanceFileModelExample example);
    
    List<AcceptanceFileModel> selectByModel(AcceptanceFileModel model);

    AcceptanceFileModel selectByPrimaryKey(Long acceptanceFileId);
    
    List<AcceptanceFileModelVo> selectByAcceptanceId(Long acceptanceId);

    int updateByExampleSelective(@Param("record") AcceptanceFileModel record, @Param("example") AcceptanceFileModelExample example);

    int updateByExample(@Param("record") AcceptanceFileModel record, @Param("example") AcceptanceFileModelExample example);

    int updateByPrimaryKeySelective(AcceptanceFileModel record);

    int updateByPrimaryKey(AcceptanceFileModel record);
}