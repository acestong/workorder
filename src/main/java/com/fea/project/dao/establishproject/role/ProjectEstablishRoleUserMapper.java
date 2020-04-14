package com.fea.project.dao.establishproject.role;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishRoleUserPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishRoleUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectEstablishRoleUserMapper {
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
    int insert(ProjectEstablishRoleUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishRoleUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishRoleUserModel model);

    /**
     * 按主键选择
     */
    ProjectEstablishRoleUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectEstablishRoleUserModel> selectByModel(ProjectEstablishRoleUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishRoleUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishRoleUserModel model);

    List<ProjectEstablishRoleUserVo> selectProjectUserRolesByUserIds(@Param("list") List<Long> userIds);

    int updateByUserIdsAndStatus(@Param("model") ProjectEstablishRoleUserModel projectEstablishRoleUserModel, @Param("list") List<Long> projectUserIds);

    List<ProjectEstablishRoleUserVo> selectByFilterAndOrderParams(BasePageInfo<ProjectEstablishRoleUserModel> model);

    int updateModelsByIds(@Param("model") ProjectEstablishRoleUserPojo model, @Param("list") List<Long> ids);

    ProjectEstablishRoleUserModel selectByTeamIdAndUserId(@Param("teamId") Long teamId, @Param("userId") Long userId);
}