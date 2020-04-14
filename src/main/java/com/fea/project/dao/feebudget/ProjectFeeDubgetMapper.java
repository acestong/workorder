package com.fea.project.dao.feebudget;



import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.feebudget.ProjectFeeDubgetModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
@Mapper
public interface ProjectFeeDubgetMapper {
    /**
     * 预算变更
     */
    //int feeDubgetChange(List<Long> ids);
    /**
     *分页查询项目预算列表
     */
    List<ProjectFeeDubgetModel> selectByFilterAndParams(PageInfoQueryOrderAndFilterModel<ProjectFeeDubgetModel> model);
    /**
     * 新建项目预算
     */
    int insertSelective(ProjectFeeDubgetModel model);
    /**
     * 预算信息
     */
    ProjectFeeDubgetModel selectById(Long id);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFeeDubgetModel model);
    /**
     * 删除
     */
    int deleteProjectFeeDubget(Long id);
    /**
     * 项目预算提交审核
     */
    int updateByIds(List<Long> ids);
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
    int insert(ProjectFeeDubgetModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFeeDubgetModel> models);
    /**
     * 按模型选择
     */
    List<ProjectFeeDubgetModel> selectByModel(ProjectFeeDubgetModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectFeeDubgetModel model);
}