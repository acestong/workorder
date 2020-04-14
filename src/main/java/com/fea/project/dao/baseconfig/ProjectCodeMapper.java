package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.vo.ProjectCodeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
public interface ProjectCodeMapper {
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
    int insert(ProjectCodeModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodeModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodeModel model);

    /**
     * 按主键选择
     */
    ProjectCodeModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodeModel> selectByModel(ProjectCodeModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodeModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodeModel model);

    ProjectCodeVo selectByRegId(@Param("regId") Long regId);
}