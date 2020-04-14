package com.fea.project.dao.flow;

import com.fea.project.model.flow.ProjectFlowListModel;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
public interface ProjectFlowListMapper {
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
    int insert(ProjectFlowListModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFlowListModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFlowListModel model);

    /**
     * 按主键选择
     */
    ProjectFlowListModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectFlowListModel> selectByModel(ProjectFlowListModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFlowListModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectFlowListModel model);

    List<ProjectFlowListVo> selectVosByModels(ProjectFlowListModel model);

    List<ProjectFlowListVo> selectByFlowId(@Param("flowId") Long flowId);

    int updateModelByIds(@Param("model") ProjectFlowListModel model, @Param("list") List<Long> ids);

    int updateByIdsSelective(ProjectFlowListPojo model);

    int deleteByNoDefaultAndNoIds(@Param("flowId") Long flowId, @Param("list") List<Long> ids);

    List<ProjectFlowListVo> selectVosByIds(@Param("list") List<Long> ids);

    List<ProjectFlowListModel> selectByIds(@Param("list") List<Long> ids);
}