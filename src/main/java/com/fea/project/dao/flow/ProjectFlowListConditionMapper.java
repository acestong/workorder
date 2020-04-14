package com.fea.project.dao.flow;

import com.fea.project.model.flow.ProjectFlowListConditionModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
public interface ProjectFlowListConditionMapper {
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
    int insert(ProjectFlowListConditionModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFlowListConditionModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFlowListConditionModel model);

    /**
     * 按主键选择
     */
    ProjectFlowListConditionModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectFlowListConditionModel> selectByModel(ProjectFlowListConditionModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFlowListConditionModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectFlowListConditionModel model);

    List<ProjectFlowListConditionVo> selectListByFlowListId(@Param("listId") Long listId);

    int updateModelDeleteByListIdAndCantDeleteList(@Param("model") ProjectFlowListConditionModel projectFlowListConditionModel, @Param("listIds") List<Long> listIds, @Param("list") List<Long> cantDeleteIds);

}