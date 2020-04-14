package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectConfirmTimeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectConfirmTimeModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectConfirmTimeModel record);

    int insertSelective(ProjectConfirmTimeModel record);

    ProjectConfirmTimeModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectConfirmTimeModel record);

    int updateByPrimaryKey(ProjectConfirmTimeModel record);

    List<ProjectConfirmTimeModel> selectConfirmTimeListByDay(@Param("selectDate") String selectDate,@Param("type") String type);

    List<ProjectConfirmTimeModel> selectConfirmTimeListByWeekOrMon(@Param("selectDate") String selectDate,@Param("type") String type);
}