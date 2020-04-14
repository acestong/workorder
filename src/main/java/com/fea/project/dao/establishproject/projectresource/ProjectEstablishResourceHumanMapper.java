package com.fea.project.dao.establishproject.projectresource;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.projectresource.ProjectEstablishResourceHumanModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishResourceHumanVo;

import java.util.List;

/**
 * Created by Administrator on 2020/01/10.
 */
public interface ProjectEstablishResourceHumanMapper {
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
    int insert(ProjectEstablishResourceHumanModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectEstablishResourceHumanModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectEstablishResourceHumanModel model);
    /**
     * 按主键选择
     */
    ProjectEstablishResourceHumanModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectEstablishResourceHumanModel> selectByModel(ProjectEstablishResourceHumanModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectEstablishResourceHumanModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectEstablishResourceHumanModel model);

    List<ProjectEstablishResourceHumanModel> selectVisiableUsers(Long projectId);

    List<ProjectEstablishResourceHumanVo> selectByFilterAndOrderParams(BasePageInfo<ProjectEstablishResourceHumanModel> basePageInfo);
}