package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.OptionModel;
import com.fea.project.workorder.model.OptionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionModelMapper {
    long countByExample(OptionModelExample example);

    int deleteByExample(OptionModelExample example);

    int deleteByPrimaryKey(Long optionId);

    int insert(OptionModel record);

    int insertSelective(OptionModel record);

    List<OptionModel> selectByExample(OptionModelExample example);

    OptionModel selectByPrimaryKey(Long optionId);

    int updateByExampleSelective(@Param("record") OptionModel record, @Param("example") OptionModelExample example);

    int updateByExample(@Param("record") OptionModel record, @Param("example") OptionModelExample example);

    int updateByPrimaryKeySelective(OptionModel record);

    int updateByPrimaryKey(OptionModel record);
}