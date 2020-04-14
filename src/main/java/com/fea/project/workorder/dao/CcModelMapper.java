package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.CcModel;
import com.fea.project.workorder.model.CcModelExample;
import com.fea.project.workorder.model.vo.PersonInfoModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CcModelMapper {
    long countByExample(CcModelExample example);

    int deleteByExample(CcModelExample example);

    int deleteByPrimaryKey(Long ccId);
    
    /**
     * 按工单id （业务id）删除
     */
    int deleteByBusinessId(Long workorderId);

    int insert(CcModel record);

    int insertSelective(CcModel record);
    
    int insertList(List<CcModel> list);

    List<CcModel> selectByExample(CcModelExample example);
    
    List<CcModel> selectByModel(CcModel model);

    CcModel selectByPrimaryKey(Long ccId);

    int updateByExampleSelective(@Param("record") CcModel record, @Param("example") CcModelExample example);

    int updateByExample(@Param("record") CcModel record, @Param("example") CcModelExample example);

    int updateByPrimaryKeySelective(CcModel record);

    int updateByPrimaryKey(CcModel record);
    
    List<PersonInfoModelVo> selectCCPerson(Long workorderId);
}