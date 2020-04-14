package com.fea.project.dao.fieldconfig;

import com.fea.project.model.fieldconfig.ProjectFieldConfigEnterpriseModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/19.
 */
public interface ProjectFieldConfigEnterpriseMapper {
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
    int insert(ProjectFieldConfigEnterpriseModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFieldConfigEnterpriseModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFieldConfigEnterpriseModel model);
    /**
     * 按主键选择
     */
    ProjectFieldConfigEnterpriseModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectFieldConfigEnterpriseModel> selectByModel(ProjectFieldConfigEnterpriseModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFieldConfigEnterpriseModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectFieldConfigEnterpriseModel model);

    List<ProjectFieldConfigEnterpriseModel> selectSysInit(@Param("typeId") Integer typeId);

    List<ProjectFieldConfigEnterpriseModel> selectByIds(@Param("list") List<Long> enterpriseIds);
}