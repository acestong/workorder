package com.fea.project.dao.role;

import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.model.role.ProjectRoleAuthorityModel;
import com.fea.project.model.role.vo.ProjectRoleAuthorityVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectRoleAuthorityMapper {
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
    int insert(ProjectRoleAuthorityModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleAuthorityModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleAuthorityModel model);

    /**
     * 按主键选择
     */
    ProjectRoleAuthorityModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleAuthorityModel> selectByModel(ProjectRoleAuthorityModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleAuthorityModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleAuthorityModel model);

    List<ProjectRoleAuthorityVo> selectRegAuthority(@Param("regId") Long regId);

    List<ProjectRoleAuthorityModel> selectByIds(@Param("list") List<Long> ids);
}