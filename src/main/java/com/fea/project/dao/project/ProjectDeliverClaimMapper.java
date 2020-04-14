package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/30.
 */
public interface ProjectDeliverClaimMapper {
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
    int insert(ProjectDeliverClaimModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectDeliverClaimModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectDeliverClaimModel model);
    /**
     * 按主键选择
     */
    ProjectDeliverClaimModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectDeliverClaimVo> selectByModel(ProjectDeliverClaimModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectDeliverClaimModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectDeliverClaimModel model);

    int updateDeleteStatusByProjectIdAndKeepSaveIds(@Param("projectId") Long projectId, @Param("list") List<Long> keepDeliverIds);

}