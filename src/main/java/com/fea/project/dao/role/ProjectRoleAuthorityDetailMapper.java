package com.fea.project.dao.role;

import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.model.role.vo.ProjectRoleAuthorityDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/18.
 */
public interface ProjectRoleAuthorityDetailMapper {
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
    int insert(ProjectRoleAuthorityDetailModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRoleAuthorityDetailModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRoleAuthorityDetailModel model);

    /**
     * 按主键选择
     */
    ProjectRoleAuthorityDetailModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectRoleAuthorityDetailModel> selectByModel(ProjectRoleAuthorityDetailModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRoleAuthorityDetailModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectRoleAuthorityDetailModel model);

    List<ProjectRoleAuthorityDetailVo> selectByAuthorityId(@Param("authorityId") Long authorityId);

    List<ProjectRoleAuthorityDetailModel> selectByIds(@Param("list") List<Long> ids);


}