package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.CommentModel;
import com.fea.project.workorder.model.CommentModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentModelMapper {
    long countByExample(CommentModelExample example);

    int deleteByExample(CommentModelExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(CommentModel record);

    int insertSelective(CommentModel record);

    List<CommentModel> selectByExample(CommentModelExample example);
    
    List<CommentModel> selectListByWorkorderId(Long workorderId);

    CommentModel selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") CommentModel record, @Param("example") CommentModelExample example);

    int updateByExample(@Param("record") CommentModel record, @Param("example") CommentModelExample example);

    int updateByPrimaryKeySelective(CommentModel record);

    int updateByPrimaryKey(CommentModel record);
}