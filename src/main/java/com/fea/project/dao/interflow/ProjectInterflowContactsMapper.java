package com.fea.project.dao.interflow;

import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Mapper
public interface ProjectInterflowContactsMapper {
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
    int insert(ProjectInterflowContactsModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowContactsModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowContactsModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowContactsModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowContactsModel> selectByModel(ProjectInterflowContactsModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowContactsModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowContactsModel model);

    /**
     * 根据businessId获取数据
     */
    List<Long> selectByBusinessId(@Param("businessId") Long businessId);
}