package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishCollectModel;
import com.fea.project.model.publish.PublishCollectModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishCollectModelMapper {
    long countByExample(PublishCollectModelExample example);

    int deleteByExample(PublishCollectModelExample example);

    int deleteByPrimaryKey(Long publishCollectId);

    int insert(PublishCollectModel record);

    int insertSelective(PublishCollectModel record);

    List<PublishCollectModel> selectByExample(PublishCollectModelExample example);

    PublishCollectModel selectByPrimaryKey(Long publishCollectId);
    
    //通过动态id和用户id查收藏id
    PublishCollectModel selectByPublishIdAndUserId(PublishCollectModel record);

    int updateByExampleSelective(@Param("record") PublishCollectModel record, @Param("example") PublishCollectModelExample example);

    int updateByExample(@Param("record") PublishCollectModel record, @Param("example") PublishCollectModelExample example);

    int updateByPrimaryKeySelective(PublishCollectModel record);

    int updateByPrimaryKey(PublishCollectModel record);
}