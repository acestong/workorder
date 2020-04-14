package com.fea.project.dao.interflow;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowPhoneModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/01/09.
 */
@Mapper
public interface ProjectInterflowPhoneMapper {
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
    int insert(ProjectInterflowPhoneModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectInterflowPhoneModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectInterflowPhoneModel model);
    /**
     * 按主键选择
     */
    ProjectInterflowPhoneModel selectById(Long id);

    ProjectInterflowPhoneModelVo selectModelVoById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectInterflowPhoneModel> selectByModel(ProjectInterflowPhoneModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectInterflowPhoneModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectInterflowPhoneModel model);
    /**
     * 获取展示列表
     */
    List<ProjectInterflowListShowVo> selectShowListByProjectId(@Param("paramVo") QueryInterflowParamVo paramVo);
}