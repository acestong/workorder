package com.fea.project.dao.role;

import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectRoleAuthorityConfigMapper {
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
    int insert(ProjectRoleAuthorityConfigModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleAuthorityConfigModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleAuthorityConfigModel model);

    /**
     * 按主键选择
     */
    ProjectRoleAuthorityConfigModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleAuthorityConfigModel> selectByModel(ProjectRoleAuthorityConfigModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleAuthorityConfigModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleAuthorityConfigModel model);

    int deleteByRoleId(@Param("roleId") Long roleId);

    List<ProjectRoleAuthorityConfigModel> selectByProjectIdAndUserId(@Param("projectId") Long projectId, @Param("userId") Long userId);
}