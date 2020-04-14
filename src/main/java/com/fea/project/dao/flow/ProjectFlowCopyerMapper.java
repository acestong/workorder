package com.fea.project.dao.flow;

import com.fea.project.model.flow.ProjectFlowCopyerModel;
import com.fea.project.model.flow.vo.ProjectFlowCopyerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
public interface ProjectFlowCopyerMapper {
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
    int insert(ProjectFlowCopyerModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFlowCopyerModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFlowCopyerModel model);

    /**
     * 按主键选择
     */
    ProjectFlowCopyerModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectFlowCopyerModel> selectByModel(ProjectFlowCopyerModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFlowCopyerModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectFlowCopyerModel model);

    List<ProjectFlowCopyerVo> selectListByFlowListId(@Param("listId") Long listId);

    int updateModelDeleteByListIdAndCantDeleteList(@Param("model") ProjectFlowCopyerModel projectFlowCopyerModel, @Param("listIds") List<Long> listIds, @Param("list") List<Long> cantDeleteIds);
}