package com.fea.project.dao.interflow;

import com.fea.project.model.interflow.ProjectInterflowMeetingAppendixModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowMeetingAppendixMapper {
    /**
     * 按主键删除
     */
    int deleteById(Long id);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(ProjectInterflowMeetingAppendixModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowMeetingAppendixModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowMeetingAppendixModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowMeetingAppendixModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowMeetingAppendixModel> selectByModel(ProjectInterflowMeetingAppendixModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowMeetingAppendixModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowMeetingAppendixModel model);

    List<ProjectInterflowMeetingAppendixModel> selectByMeetingId(@Param("meetingId")Long meetingId);
}