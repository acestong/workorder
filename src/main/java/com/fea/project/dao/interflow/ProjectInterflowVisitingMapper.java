package com.fea.project.dao.interflow;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowVisitingModel;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowVisitingModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Mapper
public interface ProjectInterflowVisitingMapper {
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
    int insert(ProjectInterflowVisitingModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowVisitingModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowVisitingModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowVisitingModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowVisitingModel> selectByModel(ProjectInterflowVisitingModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowVisitingModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowVisitingModel model);
    /**
     * 按主键获取详情信息
     */
    ProjectInterflowVisitingModelVo selectModelVoById(Long id);
    /**
     * 按项目id获取拜访记录列表
     */
    List<ProjectInterflowListShowVo> selectShowListByProjectId(@Param("paramVo") QueryInterflowParamVo paramVo);
}