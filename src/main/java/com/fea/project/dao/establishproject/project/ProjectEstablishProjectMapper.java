package com.fea.project.dao.establishproject.project;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.establishproject.vo.ProjectInnerProjectBusinessVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/23.
 */
public interface ProjectEstablishProjectMapper {
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
    int insert(ProjectEstablishProjectModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishProjectModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishProjectModel model);
    /**
     * 按主键选择
     */
    ProjectEstablishProjectModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectEstablishProjectModel> selectByModel(ProjectEstablishProjectModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishProjectModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishProjectModel model);

    ProjectEstablishProjectModel selectByProjectId(@Param("projectId") Long projectId);

    int updateContentByProjectId(ProjectEstablishProjectPojo model);

    List<ProjectEstablishVo> selectByFilterAndOrderParams(BasePageInfo<ProjectEstablishProjectPojo> basePageInfo);

    List<ProjectInnerProjectBusinessVo> selectInnerProjectBussinessByProjectIds(@Param("list") List<Long> projectIds);

    List<ProjectEstablishProjectModel> selectByCreateId(@Param("createId") Long userId);

    List<ProjectEstablishProjectModel> selectByAttention(@Param("userId") Long userId);

    List<ProjectEstablishProjectModel> selectByEstablishLeader(@Param("establishLeader") Long userId);

    List<ProjectEstablishProjectModel> selectByJoiner(@Param("userId") Long userId);

    List<ProjectEstablishProjectModel> selectByEstablishLeaders(@Param("list") List<Long> leaderIds);
}