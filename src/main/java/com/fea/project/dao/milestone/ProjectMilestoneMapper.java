package com.fea.project.dao.milestone;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/19
 * 项目里程碑 mapper
 */
@Mapper
public interface ProjectMilestoneMapper {
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
    int insert(ProjectMilestoneModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectMilestoneModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectMilestoneModel model);
    /**
     * 按主键选择
     */
    ProjectMilestoneModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectMilestoneModel> selectByModel(ProjectMilestoneModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectMilestoneModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectMilestoneModel model);
    /**
     * 分页查询
     */
    List<ProjectMilestoneVo> selectByFilterAndParams(BasePageInfo<ProjectMilestoneVo> model);
    /**
     * 获取一个里程碑
     */
    ProjectMilestoneModel selectMilestoneByProjectIdAndSort(ProjectMilestoneModel model);
    /**
     * 根据类型获取里程碑数量
     */
    Integer selectMilestoneCountByType(ProjectMilestoneModel model);
    /**
     *
     */
    Integer existsCheck(ProjectMilestoneModel model);
    Integer maxSortCheck(ProjectMilestoneModel model);
    List<ProjectMilestoneVo> selectListByModel(ProjectMilestoneModel model);
    /**
     * 获取列表
     */
    List<ProjectMilestoneModel> selectByModelIds(List<Long> ids);
}