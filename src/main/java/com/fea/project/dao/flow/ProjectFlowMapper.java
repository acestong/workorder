package com.fea.project.dao.flow;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.pojo.ProjectFlowPojo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */
public interface ProjectFlowMapper {
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
    int insert(ProjectFlowModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectFlowModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectFlowModel model);

    /**
     * 按主键选择
     */
    ProjectFlowModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectFlowModel> selectByModel(ProjectFlowModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectFlowModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectFlowModel model);

    List<ProjectFlowModel> selectByIds(@Param("list") List<Long> flowIds);

    List<ProjectFlowVo> selectProjectFlowByParam(BasePageInfo<ProjectFlowPojo> model);

    ProjectFlowVo selectVoById(@Param("id") Long id);


}