package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.WorkorderAppendixModel;
import com.fea.project.workorder.model.WorkorderAppendixModelExample;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderAppendixModelMapper {
    long countByExample(WorkorderAppendixModelExample example);

    int deleteByExample(WorkorderAppendixModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkorderAppendixModel record);

    int insertSelective(WorkorderAppendixModel record);

    List<WorkorderAppendixModel> selectByExample(WorkorderAppendixModelExample example);
    
    List<WorkorderAppendixModel> selectByModel(WorkorderAppendixModel model);

    WorkorderAppendixModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkorderAppendixModel record, @Param("example") WorkorderAppendixModelExample example);

    int updateByExample(@Param("record") WorkorderAppendixModel record, @Param("example") WorkorderAppendixModelExample example);

    int updateByPrimaryKeySelective(WorkorderAppendixModel record);

    int updateByPrimaryKey(WorkorderAppendixModel record);
    
    PersonInfoModelVo selectAppendixInfo(Long id);
}