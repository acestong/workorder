package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishImageModel;
import com.fea.project.model.publish.PublishImageModelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishImageModelMapper {
    long countByExample(PublishImageModelExample example);

    int deleteByExample(PublishImageModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublishImageModel record);

    int insertSelective(PublishImageModel record);

    List<PublishImageModel> selectByExample(PublishImageModelExample example);

    PublishImageModel selectByPrimaryKey(Long id);
    /*
     * 通过动态Id查找图片集合
     */
    List<PublishImageModel> selectListByPublishId(Long publishId);

    int updateByExampleSelective(@Param("record") PublishImageModel record, @Param("example") PublishImageModelExample example);

    int updateByExample(@Param("record") PublishImageModel record, @Param("example") PublishImageModelExample example);

    int updateByPrimaryKeySelective(PublishImageModel record);

    int updateByPrimaryKey(PublishImageModel record);
}