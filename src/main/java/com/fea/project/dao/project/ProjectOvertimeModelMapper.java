package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectOvertimeModel;

public interface ProjectOvertimeModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectOvertimeModel record);

    int insertSelective(ProjectOvertimeModel record);

    ProjectOvertimeModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectOvertimeModel record);

    int updateByPrimaryKey(ProjectOvertimeModel record);
}