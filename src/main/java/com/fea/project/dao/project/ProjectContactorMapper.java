package com.fea.project.dao.project;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectContactorModel;
import com.fea.project.model.project.pojo.ProjectContactorPojo;
import com.fea.project.model.project.vo.ProjectContactorVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/24.
 */
public interface ProjectContactorMapper {
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
    int insert(ProjectContactorModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectContactorModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectContactorModel model);

    /**
     * 按主键选择
     */
    ProjectContactorModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectContactorModel> selectByModel(ProjectContactorModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectContactorModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectContactorModel model);

    List<ProjectContactorVo> selectByFilterAndOrderParams(BasePageInfo<ProjectContactorModel> model);

    int updateModelsByIds(@Param("model") ProjectContactorPojo model, @Param("list") List<Long> ids);
}