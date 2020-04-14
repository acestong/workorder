package com.fea.project.dao.apply;

import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
public interface ProjectApplyFlowInfoMapper {
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
    int insert(ProjectApplyFlowInfoModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyFlowInfoModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyFlowInfoModel model);

    /**
     * 按主键选择
     */
    ProjectApplyFlowInfoModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyFlowInfoModel> selectByModel(ProjectApplyFlowInfoModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyFlowInfoModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyFlowInfoModel model);

    List<ProjectApplyFlowInfoVo> selectByApplyId(@Param("applyId") Long applyId);

    ProjectApplyFlowInfoVo selectWaitingVerifyModel(@Param("applyId") Long applyId);

    List<ProjectApplyFlowInfoVo> selectVerifyedModelsByApplyId(@Param("applyId") Long applyId);

    List<ProjectApplyFlowInfoVo> selectCanRevertStep(@Param("applyId") Long applyId);
}