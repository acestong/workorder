package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishCommentReplyModel;
import com.fea.project.model.publish.PublishCommentReplyModelExample;
import com.fea.project.model.publish.vo.PublishCommentReplyViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishCommentReplyModelMapper {
    long countByExample(PublishCommentReplyModelExample example);

    int deleteByExample(PublishCommentReplyModelExample example);

    int deleteByPrimaryKey(Long publishCommentReplyId);

    int insert(PublishCommentReplyModel record);

    int insertSelective(PublishCommentReplyModel record);

    List<PublishCommentReplyModel> selectByExample(PublishCommentReplyModelExample example);
    
    //通过publishCommentId获取所有回复列表
    List<PublishCommentReplyViewVo> selectAllByPublishCommentReplyId(Long publishCommentId);

    PublishCommentReplyModel selectByPrimaryKey(Long publishCommentReplyId);

    int updateByExampleSelective(@Param("record") PublishCommentReplyModel record, @Param("example") PublishCommentReplyModelExample example);

    int updateByExample(@Param("record") PublishCommentReplyModel record, @Param("example") PublishCommentReplyModelExample example);

    int updateByPrimaryKeySelective(PublishCommentReplyModel record);

    int updateByPrimaryKey(PublishCommentReplyModel record);
}