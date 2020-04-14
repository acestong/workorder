package com.fea.project.dao.apply;

import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.vo.ProjectApplyFlowVerifyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
public interface ProjectApplyFlowVerifyMapper {
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
    int insert(ProjectApplyFlowVerifyModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyFlowVerifyModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyFlowVerifyModel model);

    /**
     * 按主键选择
     */
    ProjectApplyFlowVerifyModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyFlowVerifyModel> selectByModel(ProjectApplyFlowVerifyModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyFlowVerifyModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyFlowVerifyModel model);

    List<ProjectApplyFlowVerifyVo> selectByApplyFlowId(@Param("applyFlowId") Long applyFlowId);

    List<ProjectApplyFlowVerifyModel> selectNeedVerifyModelsByApplyId(@Param("applyId") Long applyId);

    List<ProjectApplyFlowVerifyModel> selectUnVerifyModelsByApplyFlowId(@Param("applyFlowId") Long applyFlowId);

}