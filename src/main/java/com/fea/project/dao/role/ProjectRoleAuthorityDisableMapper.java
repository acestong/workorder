package com.fea.project.dao.role;

import com.fea.project.model.role.ProjectRoleAuthorityDisableModel;

import java.util.List;

/**
 * Created by Administrator on 2019/10/18.
 */
public interface ProjectRoleAuthorityDisableMapper {
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
    int insert(ProjectRoleAuthorityDisableModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleAuthorityDisableModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleAuthorityDisableModel model);

    /**
     * 按主键选择
     */
    ProjectRoleAuthorityDisableModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleAuthorityDisableModel> selectByModel(ProjectRoleAuthorityDisableModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleAuthorityDisableModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleAuthorityDisableModel model);
}