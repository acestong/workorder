package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishCommentModel;
import com.fea.project.model.publish.PublishCommentModelExample;
import com.fea.project.model.publish.vo.PublishCommentViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishCommentModelMapper {
    long countByExample(PublishCommentModelExample example);

    int deleteByExample(PublishCommentModelExample example);

    int deleteByPrimaryKey(Long publishCommentId);

    int insert(PublishCommentModel record);

    int insertSelective(PublishCommentModel record);

    List<PublishCommentModel> selectByExample(PublishCommentModelExample example);

    PublishCommentModel selectByPrimaryKey(Long publishCommentId);
    
    //通过业务（动态）id获取所有的评论
    List<PublishCommentViewVo> selectAllByPublishId(Long businessId);
    
    //通过业务（动态）id获取所有的未读评论计数
    Integer selectCountByCurUserId(Long userId);
    //通过业务（动态）id获取所有的未读评论我的计数
    Integer selectCountMeByCurUserId(Long userId);

    int updateByExampleSelective(@Param("record") PublishCommentModel record, @Param("example") PublishCommentModelExample example);

    int updateByExample(@Param("record") PublishCommentModel record, @Param("example") PublishCommentModelExample example);

    int updateByPrimaryKeySelective(PublishCommentModel record);

    int updateByPrimaryKey(PublishCommentModel record);
    
    //更新当前用户所有的评论为已读
    int updateIsReadByCurUserId(Long curUserId);
}