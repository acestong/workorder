package com.fea.project.dao.interflow;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowEmailsModel;
import com.fea.project.model.interflow.vo.ProjectInterflowEmailsModelVo;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowEmailsMapper {
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
    int insert(ProjectInterflowEmailsModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowEmailsModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowEmailsModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowEmailsModel selectById(Long id);

    ProjectInterflowEmailsModelVo selectModelVoById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowEmailsModel> selectByModel(ProjectInterflowEmailsModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowEmailsModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowEmailsModel model);
    /**
     * 获取列表
     */
    List<ProjectInterflowListShowVo> selectShouwListByProjectId(@Param("paramVo") QueryInterflowParamVo paramVo);
}