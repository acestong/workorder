package com.fea.project.dao.project;

import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.vo.ProjectViewVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface ProjectViewMapper {
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
    int insert(ProjectViewModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectViewModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectViewModel model);

    /**
     * 按主键选择
     */
    ProjectViewModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectViewModel> selectByModel(ProjectViewModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectViewModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectViewModel model);

    List<ProjectViewModel> selectRegDefaultViewByRegId(@Param("regId") Long regId, @Param("userId") Long userId, @Param("status") Integer status);

    List<ProjectViewModel> selectSelfConfigUserViewByRegId(@Param("regId") Long regId, @Param("userId") Long userId);

    ProjectViewVo selectInfoAndDetailSetById(@Param("id") Long id);

    List<ProjectViewModel> selectSelfConfigByUserIdAndCommonUse(@Param("userId") Long userId, @Param("commonUse") Integer commonUse);

}