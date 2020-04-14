package com.fea.project.dao.role;

import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.model.role.ProjectRoleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectRoleMapper {
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
    int insert(ProjectRoleModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleModel model);

    /**
     * 按主键选择
     */
    ProjectRoleModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleModel> selectByModel(ProjectRoleModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleModel model);

    List<ProjectRoleModel> selectByIds(@Param("list") List<Long> roleIds);

    List<ProjectRoleModel> selectUserRolesByUserId(@Param("userId") Long userId);

    /**
     * 根据userId查询
     */
    ProjectRoleModel selectRoleNameAndCostByUserId(@Param("userId") Long userId);

    ProjectRoleModel selectRoleByProjectIdAndShortName(@Param("projectId") Long projectId, @Param("shortName") String shortName);
}