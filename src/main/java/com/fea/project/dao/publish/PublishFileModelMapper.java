package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishFileModel;
import com.fea.project.model.publish.PublishFileModelExample;
import com.fea.project.model.publish.vo.PublishFileViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishFileModelMapper {
    long countByExample(PublishFileModelExample example);

    int deleteByExample(PublishFileModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublishFileModel record);

    int insertSelective(PublishFileModel record);

    List<PublishFileModel> selectByExample(PublishFileModelExample example);

    PublishFileModel selectByPrimaryKey(Long id);
    
    /*
     * 通过动态Id查找附件信息列表
     */
    List<PublishFileViewVo> selectFileListByPublishId(Long publishId);

    int updateByExampleSelective(@Param("record") PublishFileModel record, @Param("example") PublishFileModelExample example);

    int updateByExample(@Param("record") PublishFileModel record, @Param("example") PublishFileModelExample example);

    int updateByPrimaryKeySelective(PublishFileModel record);

    int updateByPrimaryKey(PublishFileModel record);
}