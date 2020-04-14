package com.fea.project.dao.task;

import com.fea.project.model.task.PercentSettingModel;
import com.fea.project.model.task.PercentSettingModelExample;
import com.fea.project.model.task.vo.PercentSettingModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PercentSettingModelMapper {
    long countByExample(PercentSettingModelExample example);

    int deleteByExample(PercentSettingModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PercentSettingModel record);

    int insertSelective(PercentSettingModel record);

    List<PercentSettingModel> selectByExample(PercentSettingModelExample example);

    PercentSettingModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PercentSettingModel record, @Param("example") PercentSettingModelExample example);

    int updateByExample(@Param("record") PercentSettingModel record, @Param("example") PercentSettingModelExample example);

    int updateByPrimaryKeySelective(PercentSettingModel record);

    int updateByPrimaryKey(PercentSettingModel record);
    
    /*
     * 获取resourceBusinessId获取所有的列表
     */
    List<PercentSettingModelVo> selectByResourceBusinessId(Long resourceBusinessId);
}