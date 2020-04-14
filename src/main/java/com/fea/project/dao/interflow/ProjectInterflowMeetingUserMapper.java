package com.fea.project.dao.interflow;

import com.fea.project.model.interflow.ProjectInterflowMeetingUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowMeetingUserMapper {
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
    int insert(ProjectInterflowMeetingUserModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowMeetingUserModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowMeetingUserModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowMeetingUserModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowMeetingUserModel> selectByModel(ProjectInterflowMeetingUserModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowMeetingUserModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowMeetingUserModel model);
    /**
     * 获取参与人userIds
     *@Param("meetingId")
     */
    List<Long> selectUsersByMeetingId(@Param("meetingId") Long meetingId);
    /**
     * 获取参与人表主键list
     */
    List<Long> selectIdsByMeetingId(@Param("meetingId") Long meetingId);
    /**
     * 删除该会议下的参与人
     */
    int deleteByMeetingId(@Param("meetingId") Long meetingId);
}