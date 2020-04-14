package com.fea.project.dao.team;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.team.pojo.ProjectTeamUserPojo;
import com.fea.project.model.team.vo.ProjectTeamUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectTeamUserMapper {
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
    int insert(ProjectTeamUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectTeamUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectTeamUserModel model);

    /**
     * 按主键选择
     */
    ProjectTeamUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectTeamUserModel> selectByModel(ProjectTeamUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectTeamUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectTeamUserModel model);

    List<ProjectTeamUserVo> selectByTeamId(@Param("teamId") Long teamId);

    List<ProjectTeamUserModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectTeamUserVo> selectAllProjectUserByTeamId(@Param("teamId") Long teamId);

    List<ProjectTeamUserVo> selectByFilterAndOrderParams(BasePageInfo<ProjectTeamUserModel> pageInfo);

    int updateModelsByUserIds(@Param("model") ProjectTeamUserPojo model, @Param("list") List<Long> ids);

    List<ProjectTeamUserModel> selectByUserIds(@Param("list") List<Long> projectUserIds);

    int updateDeleteByModelAndProjectId(@Param("model") ProjectTeamUserModel projectTeamUserModel, @Param("projectId") Long projectId);

    int deleteByProjectIdAndProjectUserIds(@Param("projectId") Long projectId, @Param("list") List<Long> projectUserIds);
}