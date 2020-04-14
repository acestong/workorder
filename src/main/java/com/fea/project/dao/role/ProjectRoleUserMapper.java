package com.fea.project.dao.role;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.role.pojo.ProjectRoleUserPojo;
import com.fea.project.model.role.vo.ProjectRoleUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectRoleUserMapper {
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
    int insert(ProjectRoleUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleUserModel model);

    /**
     * 按主键选择
     */
    ProjectRoleUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleUserModel> selectByModel(ProjectRoleUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleUserModel model);

    List<ProjectRoleUserVo> selectProjectUserRolesByUserIds(@Param("list") List<Long> userIds);

    int updateByUserIdsAndStatus(@Param("model") ProjectRoleUserModel projectRoleUserModel, @Param("list") List<Long> projectUserIds);

    List<ProjectRoleUserVo> selectByFilterAndOrderParams(BasePageInfo<ProjectRoleUserModel> model);

    int updateModelsByIds(@Param("model") ProjectRoleUserPojo model, @Param("list") List<Long> ids);

    ProjectRoleUserModel selectByTeamIdAndUserId(@Param("teamId") Long teamId, @Param("userId") Long userId);

    int updateDeleteByModelAndProjectId(@Param("model") ProjectRoleUserModel projectRoleUserModel, @Param("projectId") Long projectId);
}