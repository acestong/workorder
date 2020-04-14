package com.fea.project.dao.establishproject.user;

import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/29.
 */
public interface ProjectEstablishUserMapper {
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
    int insert(ProjectEstablishUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishUserModel model);

    /**
     * 按主键选择
     */
    ProjectEstablishUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectEstablishUserModel> selectByModel(ProjectEstablishUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishUserModel model);

    List<Long> selectByProjectId(@Param("projectId") Long projectId);

    int deleteByProjectId(@Param("projectId") Long projectId);

    List<ProjectEstablishUserVo> selectByProjectIdAndUserStatus(@Param("projectId") Long projectId, @Param("list") List<Integer> projectUserStatus);

    List<ProjectEstablishUserVo> selectByTeamId(@Param("teamId") Long teamId);

    List<ProjectEstablishUserModel> selectProjectUsersByTeamId(@Param("teamId") Long teamId);

    List<ProjectEstablishUserVo> selectProjectUsersByProjectId(@Param("projectId") Long projectId);

    int updateByUserIdsAndStatus(@Param("model") ProjectEstablishUserModel projectEstablishUserModel, @Param("list") List<Long> projectUserIds);

    int updateByModelAndProjectTeamUserIds(@Param("model") ProjectEstablishUserModel projectEstablishUserModel, @Param("list") List<Long> ids);

    List<ProjectEstablishUserVo> selectProjectUsersByRoleId(@Param("roleId") Long roleId);

    List<ProjectEstablishUserModel> listUnRoleTeamUsers(@Param("projectId") Long projectId);

    List<ProjectEstablishUserModel> selectUnGroupUserByProjectId(@Param("projectId") Long projectId, @Param("shortName") String shortName);

    List<ProjectEstablishUserModel> selectByProjectIdAndUserIds(@Param("projectId") Long projectId, @Param("list") List<Long> userIds);

    List<ProjectEstablishUserModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectEstablishUserModel> selectProjectUsersByRoleIds(@Param("list") List<Long> roleIds);

    List<ProjectEstablishUserModel> selectNormalUserListByProjectId(@Param("projectId") Long projectId);
}