package com.fea.project.dao.deliverable;

import com.fea.project.model.deliverable.ProjectDeliverableModel;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.deliverable.vo.QueryDeliverableParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/06.
 */
@Mapper
public interface ProjectDeliverableMapper {
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
    int insert(ProjectDeliverableModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectDeliverableModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectDeliverableModel model);
    /**
     * 按主键选择
     */
    ProjectDeliverableModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectDeliverableModel> selectByModel(ProjectDeliverableModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectDeliverableModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectDeliverableModel model);
    /**
     * 按模型选择
     */
    List<ProjectDeliverableVo> selectDeliverableByProjectId(@Param("paramVo")QueryDeliverableParamVo model);

    /**
     *  获取详情
     * @param id 主键
     */
    ProjectDeliverableVo selectProjectDeliverableInfoById(@Param("id") Long id);

    List<ProjectDeliverableModel> selectListByIds(List<Long> ids);
}