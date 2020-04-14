package com.fea.project.dao.interflow;

import com.fea.project.model.interflow.ProjectInterflowMeetingAgendaModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowMeetingAgendaMapper {
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
    int insert(ProjectInterflowMeetingAgendaModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowMeetingAgendaModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowMeetingAgendaModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowMeetingAgendaModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowMeetingAgendaModel> selectByModel(ProjectInterflowMeetingAgendaModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowMeetingAgendaModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowMeetingAgendaModel model);

    List<Long> selectByBusinessId(@Param("meetingId") Long meetingId);
}