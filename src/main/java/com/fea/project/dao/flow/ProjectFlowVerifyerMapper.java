package com.fea.project.dao.flow;

import com.fea.project.model.flow.ProjectFlowVerifyerModel;
import com.fea.project.model.flow.vo.ProjectFlowVerifyerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
public interface ProjectFlowVerifyerMapper {
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
    int insert(ProjectFlowVerifyerModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFlowVerifyerModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFlowVerifyerModel model);

    /**
     * 按主键选择
     */
    ProjectFlowVerifyerModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectFlowVerifyerModel> selectByModel(ProjectFlowVerifyerModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFlowVerifyerModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectFlowVerifyerModel model);

    List<ProjectFlowVerifyerVo> selectListByFlowListId(@Param("listId") Long listId);

    int updateModelDeleteByListIdAndCantDeleteList(@Param("model") ProjectFlowVerifyerModel projectFlowVerifyerModel, @Param("listIds") List<Long> listIds, @Param("list") List<Long> cantDeleteIds);

}