package com.fea.project.dao.establishproject.team;

import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamVo;
import com.fea.project.model.projectdata.ProjectTeamTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
@Mapper
public interface ProjectEstablishTeamMapper {
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
    int insert(ProjectEstablishTeamModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishTeamModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishTeamModel model);

    /**
     * 按主键选择
     */
    ProjectEstablishTeamModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectEstablishTeamModel> selectByModel(ProjectEstablishTeamModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishTeamModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishTeamModel model);

    List<ProjectEstablishTeamModel> selectListByShortNameNullAndProjectId(@Param("projectId") Long projectId);


    List<ProjectEstablishTeamVo> selectProjectId(@Param("projectId") Long projectId);

    ProjectEstablishTeamModel selectUngroupTeamByOrdernaryTeamUserId(@Param("userId") Long projectTeamUserPkId, @Param("shortName") String shortName);

    ProjectEstablishTeamModel selectUngroupTeamByProjectIdAndShortName(@Param("projectId") Long projectId, @Param("shortName") String shortName);
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
    ProjectEstablishTeamModel getTeamByProjectIdAndUserId(@Param("projectId") Long projectId,
                                                 @Param("userId") Long userId);

    List<ProjectEstablishTeamModel> selectByIds(@Param("list") List<Long> ids);
}