package com.fea.project.dao.team;

import com.fea.project.model.projectdata.ProjectTeamTreeVo;
import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.team.vo.ProjectTeamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@Mapper
public interface ProjectTeamMapper {
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
    int insert(ProjectTeamModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectTeamModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectTeamModel model);

    /**
     * 按主键选择
     */
    ProjectTeamModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectTeamModel> selectByModel(ProjectTeamModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectTeamModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectTeamModel model);

    List<ProjectTeamModel> selectListByShortNameNullAndProjectId(@Param("projectId") Long projectId);


    List<ProjectTeamVo> selectProjectId(@Param("projectId") Long projectId);

    ProjectTeamModel selectUngroupTeamByOrdernaryTeamUserId(@Param("userId") Long projectTeamUserPkId, @Param("shortName") String shortName);

    ProjectTeamModel selectTeamByProjectIdAndShortName(@Param("projectId") Long projectId, @Param("shortName") String shortName);
    /**
    * 获取指定项目id下我所负责的团队
    */
    List<ProjectTeamTreeVo> getLeaderTeamByProjectIdAndLeaderId(@Param("projectId") Long projectId,
                                                                @Param("leader") Long leader);
    /**
    * 根据团队id查询团队下的人员
    */
    List<Long> getLeaderTeamUserByTeamId(@Param("teamId") Long teamId);
    /**
     * 获取指定团队id下属的团队
     */
    List<ProjectTeamTreeVo> getChildTeamByTeamId(@Param("teamId") Long teamId);
    /**
     *
     *
     */
    ProjectTeamModel getTeamByProjectIdAndUserId(@Param("projectId") Long projectId,
                                                 @Param("userId") Long userId);

    List<ProjectTeamModel> selectStandardTeamModels(@Param("projectId") Long projectId);

    List<ProjectTeamModel> selectByIds(@Param("list") List<Long> ids);
}