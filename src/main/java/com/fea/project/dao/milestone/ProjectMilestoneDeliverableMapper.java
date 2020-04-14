package com.fea.project.dao.milestone;

import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.deliverable.vo.QueryDeliverableParamVo;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliverableVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/22.
 */
@Mapper
public interface ProjectMilestoneDeliverableMapper {
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
    int insert(ProjectMilestoneDeliverableModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectMilestoneDeliverableModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectMilestoneDeliverableModel model);
    /**
     * 按主键选择
     */
    ProjectMilestoneDeliverableModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectMilestoneDeliverableModel> selectByModel(ProjectMilestoneDeliverableModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectMilestoneDeliverableModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectMilestoneDeliverableModel model);
    /**
     * 获取列表
     */
    List<ProjectMilestoneDeliverableVo> selectDeliverableVoByModel(ProjectMilestoneDeliverableModel model);

    /**
     *  获取列表
     * @param model 项目id等
     */
    List<ProjectDeliverableVo> selectDeliverableVoByProjectId(@Param("paramVo") QueryDeliverableParamVo model);

    /**
     *  获取详情
     * @param id 主键
     */
    ProjectDeliverableVo selectMilestoneDeliverableInfoById(@Param("id") Long id);
    /**
    *
    */
    List<ProjectMilestoneDeliverableModel> selectListByIds(List<Long> ids);
}