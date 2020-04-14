package com.fea.project.dao.establishproject.team;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamUserPojo;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamUserVo;
import com.fea.project.model.team.vo.ProjectTeamUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 */
public interface ProjectEstablishTeamUserMapper {
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
    int insert(ProjectEstablishTeamUserModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishTeamUserModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishTeamUserModel model);

    /**
     * 按主键选择
     */
    ProjectEstablishTeamUserModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectEstablishTeamUserModel> selectByModel(ProjectEstablishTeamUserModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishTeamUserModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishTeamUserModel model);

    List<ProjectTeamUserVo> selectByTeamId(@Param("teamId") Long teamId);

    List<ProjectEstablishTeamUserModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectTeamUserVo> selectAllProjectUserByTeamId(@Param("teamId") Long teamId);

    List<ProjectEstablishTeamUserVo> selectByFilterAndOrderParams(BasePageInfo<ProjectEstablishTeamUserModel> pageInfo);

    int updateModelsByUserIds(@Param("model") ProjectEstablishTeamUserPojo model, @Param("list") List<Long> ids);

    List<ProjectEstablishTeamUserModel> selectByUserIds(@Param("list") List<Long> projectUserIds);
}