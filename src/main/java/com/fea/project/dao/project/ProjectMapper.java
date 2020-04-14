package com.fea.project.dao.project;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.plan.vo.ProjectTreeModelVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/09/23.
 * 项目信息表 mapper
 */
public interface ProjectMapper {
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
    int insert(ProjectModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectModel model);
    /**
     * 按主键选择
     */
    ProjectModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectModel> selectByModel(ProjectModel model);
    /**
     * 按主键选择相关模型列表
     */
    List<ProjectTreeModelVo> selectProjectTreeById(Long id);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectModel model);

    List<ProjectVo> selectByFilterAndOrderParams(BasePageInfo<ProjectPojo> pageInfo);

    ProjectModel selectByRoleId(@Param("roleId") Long roleId);

    ProjectVo selectOne(@Param("id") Long id, @Param("establishFlag") Boolean establishFlag);

    List<ProjectVo> listByUserId(BasePageInfo<ProjectPojo> pageInfo);

    ProjectModel selectModelByStepId(@Param("stepId") Long stepId);

    List<ProjectModel> selectByIds(@Param("list") List<Long> ids);

    ProjectModel selectModelByIdAndConditionModel(@Param("id") Long businessId, @Param("map") Map<Integer, String> conditionMap);

    List<ProjectVo> selectWithEstablishProjectByFilterAndOrderParams(BasePageInfo<ProjectPojo> pageInfo);

    int updateEstablishStatus(@Param("id") Long id, @Param("establishment") Integer establishment);

    int updateDelStatusByProjectId(@Param("id") Long id, @Param("delStatus") Integer delStatus);

    int updateSelectiveByIdOnEstablish(ProjectModel projectModel);

    List<ProjectModel> selectByCreateId(@Param("createId") Long userId);

    List<ProjectModel> selectByAttention(@Param("userId") Long userId);

    List<ProjectModel> selectByLeader(@Param("leaderId") Long userId);

    List<ProjectModel> selectByJoiner(@Param("userId") Long userId);

    List<ProjectModel> selectByLeaders(@Param("list") List<Long> leaders);

    List<ProjectVo> listByViewInfo(BasePageInfo<ProjectPojo> pageInfo);
}