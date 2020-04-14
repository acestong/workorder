package com.fea.project.dao.project;

import com.fea.project.model.milestone.vo.ProjectStepShowVo;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectStepMapper {
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
    int insert(ProjectStepModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectStepModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectStepModel model);

    /**
     * 按主键选择
     */
    ProjectStepModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectStepVo> selectByModel(ProjectStepModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectStepModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectStepModel model);
    /**
     * 根据项目id查询其项目阶段
     */
    List<ProjectStepModel> selectByProjectId(Long projectId);

    List<ProjectStepModel> selectByProjectIdAndKeepSaveIds(@Param("projectId") Long projectId, @Param("list") List<Long> keepStepIds);

    int updateDeleteStatusByIds(@Param("list") List<Long> needDeleteIds);

    /**
     * 根据项目id获取
     *
     */
    List<ProjectStepShowVo> selectVoListByModel(ProjectStepModel model);

    /**
     * 按主键选择
     */
    ProjectStepShowVo selectStepDetailVoById(Long id);
}