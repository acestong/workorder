package com.fea.project.dao.user;

import com.fea.project.model.milestone.vo.UserListTeamVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.model.user.vo.ProjectUserVo;
import com.fea.project.model.user.vo.UserWithJobVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/29.
 */
public interface ProjectUserMapper {
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
    int insert(ProjectUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectUserModel model);

    /**
     * 按主键选择
     */
    ProjectUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectUserModel> selectByModel(ProjectUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectUserModel model);

    List<Long> selectByProjectId(@Param("projectId") Long projectId);

    int deleteByProjectId(@Param("projectId") Long projectId);

    List<ProjectUserVo> selectByProjectIdAndUserStatus(@Param("projectId") Long projectId, @Param("list") List<Integer> projectUserStatus);

    List<ProjectUserVo> selectByTeamId(@Param("teamId") Long teamId);

    List<ProjectUserModel> selectProjectUsersByTeamId(@Param("teamId") Long teamId);

    List<ProjectUserVo> selectProjectUsersByProjectId(@Param("projectId") Long projectId);

    int updateByUserIdsAndStatus(@Param("model") ProjectUserModel projectUserModel, @Param("list") List<Long> projectUserIds);

    int updateByModelAndProjectTeamUserIds(@Param("model") ProjectUserModel projectUserModel, @Param("list") List<Long> ids);

    List<ProjectUserVo> selectProjectUsersByRoleId(@Param("roleId") Long roleId);

    List<ProjectUserModel> listUnRoleTeamUsers(@Param("projectId") Long projectId);

    List<ProjectUserModel> selectUnGroupUserByProjectId(@Param("projectId") Long projectId, @Param("shortName") String shortName);

    List<UserListTeamVo> selectUserListTeamByProjectId(@Param("projectId")Long projectId);

    List<ProjectUserModel> selectByProjectIdAndUserIds(@Param("projectId") Long projectId, @Param("list") List<Long> userIds);

    List<ProjectUserModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectUserModel> selectProjectUsersByRoleIds(@Param("list") List<Long> roleIds);
    
    //通过用户Id返回职位Id
    Long selectJobIdByUserId(Long userId);
    //通过jobId返回用户相关列表信息
    List<UserWithJobVo> selectUserInfoByJobId(Long jobId);

    List<ProjectUserModel> selectNormalUserListByProjectId(Long projectId);
}