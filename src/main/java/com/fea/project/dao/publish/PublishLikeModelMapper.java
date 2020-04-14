package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishLikeModel;
import com.fea.project.model.publish.PublishLikeModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishLikeModelMapper {
    long countByExample(PublishLikeModelExample example);

    int deleteByExample(PublishLikeModelExample example);
    
    //通过动态id和用户id删除赞
    int deleteByPublishIdAndUserId(PublishLikeModel record);

    int deleteByPrimaryKey(Long publishLikeId);

    int insert(PublishLikeModel record);

    int insertSelective(PublishLikeModel record);

    List<PublishLikeModel> selectByExample(PublishLikeModelExample example);
    
    List<PublishLikeModel> selectLikeListByPublishId(Long publishId);
    
    //通过用户id获取用户头像
    String selectUserImageByUserId(Long userId);
    
    //获取当前项目下所有的未读赞的集合数
    Integer selectCountByCurUserId(Long userId);

    PublishLikeModel selectByPrimaryKey(Long publishLikeId);

    int updateByExampleSelective(@Param("record") PublishLikeModel record, @Param("example") PublishLikeModelExample example);

    int updateByExample(@Param("record") PublishLikeModel record, @Param("example") PublishLikeModelExample example);

    int updateByPrimaryKeySelective(PublishLikeModel record);

    int updateByPrimaryKey(PublishLikeModel record);
    
    int updateIsReadByCurUserId(Long userId);
}