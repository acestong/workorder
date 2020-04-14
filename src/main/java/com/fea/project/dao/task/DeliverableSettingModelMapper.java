package com.fea.project.dao.task;

import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.model.task.DeliverableSettingModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliverableSettingModelMapper {
    long countByExample(DeliverableSettingModelExample example);

    int deleteByExample(DeliverableSettingModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeliverableSettingModel record);

    int insertSelective(DeliverableSettingModel record);

    List<DeliverableSettingModel> selectByExample(DeliverableSettingModelExample example);

    DeliverableSettingModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeliverableSettingModel record, @Param("example") DeliverableSettingModelExample example);

    int updateByExample(@Param("record") DeliverableSettingModel record, @Param("example") DeliverableSettingModelExample example);

    int updateByPrimaryKeySelective(DeliverableSettingModel record);

    int updateByPrimaryKey(DeliverableSettingModel record);
    
    List<DeliverableSettingModel> selectByModel(DeliverableSettingModel model);
}