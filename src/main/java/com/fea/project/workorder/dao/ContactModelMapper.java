package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.ContactModel;
import com.fea.project.workorder.model.ContactModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactModelMapper {
    long countByExample(ContactModelExample example);

    int deleteByExample(ContactModelExample example);

    int deleteByPrimaryKey(Long contactId);

    int insert(ContactModel record);

    int insertSelective(ContactModel record);

    List<ContactModel> selectByExample(ContactModelExample example);

    ContactModel selectByPrimaryKey(Long contactId);
    
    /**
     * 通过workorderId获取联系人列表
     * @param workorderId
     * @return
     */
    ContactModel selectByWorkorderId(@Param("workorderId")Long workorderId);

    int updateByExampleSelective(@Param("record") ContactModel record, @Param("example") ContactModelExample example);

    int updateByExample(@Param("record") ContactModel record, @Param("example") ContactModelExample example);

    int updateByPrimaryKeySelective(ContactModel record);

    int updateByPrimaryKey(ContactModel record);
}