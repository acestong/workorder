package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectMHourManageModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProjectMHourManageModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectMHourManageModel record);

    int insertSelective(ProjectMHourManageModel record);

    ProjectMHourManageModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectMHourManageModel record);

    int updateByPrimaryKey(ProjectMHourManageModel record);

    List<ProjectMHourManageModel> selectMyhourManageByTime(@Param("selectDate") String selectDate,@Param("userid") Long userid);

    List<ProjectMHourManageModel> selectMyhourManageByWeek(@Param("selectDate")String selectDate,@Param("userid") Long userid);

    List<ProjectMHourManageModel> selectMyhourManageByMonthe(@Param("selectDate")String selectDate,@Param("userid") Long userid);

    List<ProjectMHourManageModel> selectMyhourSumMyhourManage(@Param("selectDate")String selectDate, @Param("userid")Long userid, @Param("sqlType")String sqlType);

    List<ProjectMHourManageModel> selectmyhourManageDesByid(@Param("id")Long id);

    List<ProjectMHourManageModel> selectmyhourManageDesReportByid(@Param("id")Long valueOf);

    List<ProjectMHourManageModel> selectmyhourManageDesOverByid(@Param("id")Long valueOf);

    List<ProjectMHourManageModel> selectmyhourManageDesOverReportByid(@Param("id")Long valueOf);

    List<ProjectMHourManageModel> selectTeamhourManageDesProjectid(@Param("projectId")String projectId,@Param("selectDate") String selectDate, @Param("type")String type);

    List<ProjectMHourManageModel> selectTeamhourManageSum(@Param("projectId")String projectId, @Param("selectDate")String selectDate,@Param("type") String type);
}