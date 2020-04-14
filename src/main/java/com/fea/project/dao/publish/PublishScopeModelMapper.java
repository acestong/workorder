package com.fea.project.dao.publish;

import com.fea.project.model.publish.PublishScopeModel;
import com.fea.project.model.publish.PublishScopeModelExample;
import com.fea.project.model.publish.vo.ProjectUserViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishScopeModelMapper {
    long countByExample(PublishScopeModelExample example);

    int deleteByExample(PublishScopeModelExample example);

    int deleteByPrimaryKey(Long publishScopeId);

    int insert(PublishScopeModel record);
    

    int insertSelective(PublishScopeModel record);

    List<PublishScopeModel> selectByExample(PublishScopeModelExample example);

    PublishScopeModel selectByPrimaryKey(Long publishScopeId);
    //通过项目Id获取项目成员列表
    List<ProjectUserViewVo> selectScopeUserListByprojectId(Long projectId);

    int updateByExampleSelective(@Param("record") PublishScopeModel record, @Param("example") PublishScopeModelExample example);

    int updateByExample(@Param("record") PublishScopeModel record, @Param("example") PublishScopeModelExample example);

    int updateByPrimaryKeySelective(PublishScopeModel record);

    int updateByPrimaryKey(PublishScopeModel record);
}