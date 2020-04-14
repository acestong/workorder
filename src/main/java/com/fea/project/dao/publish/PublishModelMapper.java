package com.fea.project.dao.publish;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.publish.PublishModel;
import com.fea.project.model.publish.PublishModelExample;
import com.fea.project.model.publish.vo.EmpInfoVo;
import com.fea.project.model.publish.vo.PublishGetViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishModelMapper {
    long countByExample(PublishModelExample example);

    int deleteByExample(PublishModelExample example);

    int deleteByPrimaryKey(Long publishId);

    int insert(PublishModel record);

    int insertSelective(PublishModel record);

    List<PublishModel> selectByExample(PublishModelExample example);
//  获取我创建的，公开的、部门可见包含我部门的，个人可见包含我的所有的动态集合，按照创建时时间进行降序排序，支持按照发布人进行模糊搜索
    List<PublishModel> selectAllPublishWithMe(BasePageInfo<PublishGetViewVo> page);

    PublishModel selectByPrimaryKey(Long publishId);
    
//  获取当前动态下动态创建人的头像
    String selectUserImage(Long publishId);
//  获取当前动态下动态创建人的头像
    String selectUserImageByUserId(Long userId);

    int updateByExampleSelective(@Param("record") PublishModel record, @Param("example") PublishModelExample example);

    int updateByExample(@Param("record") PublishModel record, @Param("example") PublishModelExample example);

    int updateByPrimaryKeySelective(PublishModel record);

    int updateByPrimaryKey(PublishModel record);
    
    //获取员工信息列表
    EmpInfoVo selectEmpInfoVoByCurUserId(Long userId);
    
}