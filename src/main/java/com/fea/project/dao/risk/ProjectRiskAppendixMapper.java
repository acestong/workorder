package com.fea.project.dao.risk;


import com.fea.project.model.risk.ProjectRiskAppendixModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/04.
 */
@Mapper
public interface ProjectRiskAppendixMapper {
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
    int insert(ProjectRiskAppendixModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectRiskAppendixModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectRiskAppendixModel model);
    /**
     * 按主键选择
     */
    ProjectRiskAppendixModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectRiskAppendixModel> selectByModel(ProjectRiskAppendixModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectRiskAppendixModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectRiskAppendixModel model);
    //删除附件
    int deleteRiskAppendix(Long id);
}