package com.fea.project.dao.milestone;

import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import java.util.List;

/**
 * Created by Administrator on 2020/01/19.
 */
public interface ProjectMilestoneVerifyMapper {
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
    int insert(ProjectMilestoneVerifyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectMilestoneVerifyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectMilestoneVerifyModel model);
    /**
     * 按主键选择
     */
    ProjectMilestoneVerifyModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectMilestoneVerifyModel> selectByModel(ProjectMilestoneVerifyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectMilestoneVerifyModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectMilestoneVerifyModel model);
    /**
     * 按项目主键获取
     */
    ProjectMilestoneVerifyModel selectByProjectId(Long projectId);
    /**
     * 获取列表
     */
    List<ProjectMilestoneVerifyModel> selectByModelIds(List<Long> ids);
}