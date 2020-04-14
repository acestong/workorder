package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectOvertimeTypeModel;

import java.util.List;

public interface ProjectOvertimeTypeModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectOvertimeTypeModel record);

    int insertSelective(ProjectOvertimeTypeModel record);

    ProjectOvertimeTypeModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectOvertimeTypeModel record);

    int updateByPrimaryKey(ProjectOvertimeTypeModel record);

    List<ProjectOvertimeTypeModel> selectOvertimeTypeAll();
}