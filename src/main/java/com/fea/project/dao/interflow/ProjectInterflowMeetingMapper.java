package com.fea.project.dao.interflow;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowMeetingModel;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowMeetingModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowMeetingMapper {
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
    int insert(ProjectInterflowMeetingModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowMeetingModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowMeetingModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowMeetingModel selectById(Long id);
    /**
     * 按主键选择
     * @return ProjectInterflowMeetingModelVo
     */
    ProjectInterflowMeetingModelVo selectModelVoById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowMeetingModel> selectByModel(ProjectInterflowMeetingModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowMeetingModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowMeetingModel model);
    /**
     * 按模型选择
     */
    List<ProjectInterflowListShowVo> selectShowListByProjectId(@Param("paramVo") QueryInterflowParamVo paramVo);
}