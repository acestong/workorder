package com.fea.project.dao.establishproject.role;

import com.fea.project.model.establishproject.role.ProjectEstablishRoleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectEstablishRoleMapper {
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
    int insert(ProjectEstablishRoleModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishRoleModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishRoleModel model);

    /**
     * 按主键选择
     */
    ProjectEstablishRoleModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectEstablishRoleModel> selectByModel(ProjectEstablishRoleModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishRoleModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishRoleModel model);

    List<ProjectEstablishRoleModel> selectByIds(@Param("list") List<Long> roleIds);
}