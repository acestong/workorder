package com.fea.project.dao.establishproject.project;

import com.fea.project.model.establishproject.project.ProjectEstablishStepModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishStepVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/30.
 */
public interface ProjectEstablishStepMapper {
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
    int insert(ProjectEstablishStepModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishStepModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishStepModel model);
    /**
     * 按主键选择
     */
    ProjectEstablishStepModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectEstablishStepVo> selectByModel(ProjectEstablishStepModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishStepModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishStepModel model);

    List<ProjectEstablishStepModel> selectBeforeById(@Param("id") Long id);

    List<ProjectEstablishStepModel> selectByIds(@Param("list") List<Long> ids);

    List<ProjectEstablishStepModel> selectLeftNeedUpdate(@Param("id") Long id);

    ProjectEstablishVo selectModelByIdAndConditionModel(@Param("id") Long businessId, @Param("map") Map<Integer, String> conditionMap);
}