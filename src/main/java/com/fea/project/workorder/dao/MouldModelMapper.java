package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.MouldModel;
import com.fea.project.workorder.model.MouldModelExample;
import com.fea.project.workorder.model.vo.MouldModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MouldModelMapper {
    long countByExample(MouldModelExample example);

    int deleteByExample(MouldModelExample example);

    int deleteByPrimaryKey(Long mouldId);

    int insert(MouldModel record);

    int insertSelective(MouldModel record);

    List<MouldModel> selectByExample(MouldModelExample example);

    MouldModelVo selectByPrimaryKey(Long mouldId);
    
    List<MouldModelVo> selectByOrgId(Long orgId);

    int updateByExampleSelective(@Param("record") MouldModel record, @Param("example") MouldModelExample example);

    int updateByExample(@Param("record") MouldModel record, @Param("example") MouldModelExample example);

    int updateByPrimaryKeySelective(MouldModel record);

    int updateByPrimaryKey(MouldModel record);
}