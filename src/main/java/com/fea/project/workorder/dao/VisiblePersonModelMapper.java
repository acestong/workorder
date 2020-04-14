package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.VisiblePersonModel;
import com.fea.project.workorder.model.VisiblePersonModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisiblePersonModelMapper {
    long countByExample(VisiblePersonModelExample example);

    int deleteByExample(VisiblePersonModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VisiblePersonModel record);

    int insertSelective(VisiblePersonModel record);
    
    int insertByList(@Param("poolId") Long poolId , @Param("list") List<VisiblePersonModel> list);

    List<VisiblePersonModel> selectByExample(VisiblePersonModelExample example);

    VisiblePersonModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VisiblePersonModel record, @Param("example") VisiblePersonModelExample example);

    int updateByExample(@Param("record") VisiblePersonModel record, @Param("example") VisiblePersonModelExample example);

    int updateByPrimaryKeySelective(VisiblePersonModel record);

    int updateByPrimaryKey(VisiblePersonModel record);
}