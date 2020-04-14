package com.fea.project.dao.milestone;

import com.fea.project.model.milestone.ProjectMilestoneDeliveryModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/10/21.
 * 项目里程碑交付物要求 mapper
 */
@Mapper
public interface ProjectMilestoneDeliveryMapper {
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
    int insert(ProjectMilestoneDeliveryModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectMilestoneDeliveryModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectMilestoneDeliveryModel model);
    /**
     * 按主键选择
     */
    ProjectMilestoneDeliveryModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectMilestoneDeliveryModel> selectByModel(ProjectMilestoneDeliveryModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectMilestoneDeliveryModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectMilestoneDeliveryModel model);
    /**
     * 获取列表
     */
    List<ProjectMilestoneDeliveryVo> selectByMilestoneId(Long id);
}