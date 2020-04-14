package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.AcceptanceContentModel;
import com.fea.project.workorder.model.AcceptanceContentModelExample;
import com.fea.project.workorder.model.vo.AcceptanceContentModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcceptanceContentModelMapper {
    long countByExample(AcceptanceContentModelExample example);

    int deleteByExample(AcceptanceContentModelExample example);

    int deleteByPrimaryKey(Long acceptanceContentId);

    int insert(AcceptanceContentModel record);

    int insertSelective(AcceptanceContentModel record);

    List<AcceptanceContentModel> selectByExample(AcceptanceContentModelExample example);
    /*
     * selectByModel 
     */
    List<AcceptanceContentModel> selectByModel(AcceptanceContentModel model);
    /*
     * 通过验收Id获取验收内容list集合
     */
    List<AcceptanceContentModelVo> selectListByAcceptanceId(Long acceptanceId);

    AcceptanceContentModel selectByPrimaryKey(Long acceptanceContentId);

    int updateByExampleSelective(@Param("record") AcceptanceContentModel record, @Param("example") AcceptanceContentModelExample example);

    int updateByExample(@Param("record") AcceptanceContentModel record, @Param("example") AcceptanceContentModelExample example);

    int updateByPrimaryKeySelective(AcceptanceContentModel record);

    int updateByPrimaryKey(AcceptanceContentModel record);
}