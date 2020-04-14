package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.CommentWeightModel;
import com.fea.project.workorder.model.CommentWeightModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentWeightModelMapper {
    long countByExample(CommentWeightModelExample example);

    int deleteByExample(CommentWeightModelExample example);

    int deleteByPrimaryKey(Long commentWeightId);

    int insert(CommentWeightModel record);

    int insertSelective(CommentWeightModel record);

    List<CommentWeightModel> selectByExample(CommentWeightModelExample example);

    CommentWeightModel selectByPrimaryKey(Long commentWeightId);
    
    CommentWeightModel selectByOrgId(Long orgId);

    int updateByExampleSelective(@Param("record") CommentWeightModel record, @Param("example") CommentWeightModelExample example);

    int updateByExample(@Param("record") CommentWeightModel record, @Param("example") CommentWeightModelExample example);

    int updateByPrimaryKeySelective(CommentWeightModel record);

    int updateByPrimaryKey(CommentWeightModel record);
}