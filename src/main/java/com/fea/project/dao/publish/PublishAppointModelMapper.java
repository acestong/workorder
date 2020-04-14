package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishAppointModel;
import com.fea.project.model.publish.PublishAppointModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishAppointModelMapper {
    long countByExample(PublishAppointModelExample example);

    int deleteByExample(PublishAppointModelExample example);

    int deleteByPrimaryKey(Long publishAppointId);

    int insert(PublishAppointModel record);

    int insertSelective(PublishAppointModel record);

    List<PublishAppointModel> selectByExample(PublishAppointModelExample example);

    PublishAppointModel selectByPrimaryKey(Long publishAppointId);
    
    /*
     * 获取已读的提醒的动态数量
     */
    Integer selectCountByCurUserId(Long publishAppointId);

    int updateByExampleSelective(@Param("record") PublishAppointModel record, @Param("example") PublishAppointModelExample example);

    int updateByExample(@Param("record") PublishAppointModel record, @Param("example") PublishAppointModelExample example);

    int updateByPrimaryKeySelective(PublishAppointModel record);

    int updateByPrimaryKey(PublishAppointModel record);
    
    //通过当前用户Id将已读状态改为已读
    int updateIsReadByCurUserId(Long publishAppointUserId);
}