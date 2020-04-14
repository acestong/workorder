package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.DispatchModel;
import com.fea.project.workorder.model.DispatchModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchModelMapper {
    long countByExample(DispatchModelExample example);

    int deleteByExample(DispatchModelExample example);

    int deleteByPrimaryKey(Long dispatchId);

    int insert(DispatchModel record);

    int insertSelective(DispatchModel record);

    List<DispatchModel> selectByExample(DispatchModelExample example);
    
    List<DispatchModel> selectByModel(DispatchModel model);

    DispatchModel selectByPrimaryKey(Long dispatchId);

    int updateByExampleSelective(@Param("record") DispatchModel record, @Param("example") DispatchModelExample example);

    int updateByExample(@Param("record") DispatchModel record, @Param("example") DispatchModelExample example);

    int updateByPrimaryKeySelective(DispatchModel record);

    int updateByPrimaryKey(DispatchModel record);
}