package com.fea.project.dao.task;

import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.model.task.CommentSettingModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentSettingModelMapper {
    long countByExample(CommentSettingModelExample example);

    int deleteByExample(CommentSettingModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentSettingModel record);

    int insertSelective(CommentSettingModel record);

    List<CommentSettingModel> selectByExample(CommentSettingModelExample example);

    CommentSettingModel selectByPrimaryKey(Long id);
    //查看业务来源id下的设置
    List<CommentSettingModel> selectByModel(CommentSettingModel model);

    int updateByExampleSelective(@Param("record") CommentSettingModel record, @Param("example") CommentSettingModelExample example);

    int updateByExample(@Param("record") CommentSettingModel record, @Param("example") CommentSettingModelExample example);

    int updateByPrimaryKeySelective(CommentSettingModel record);

    int updateByPrimaryKey(CommentSettingModel record);
}