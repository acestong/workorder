package com.fea.project.dao.baseconfig;

import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/27.
 */
public interface ProjectCodeShortNameMapper {
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
    int insert(ProjectCodeShortNameModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectCodeShortNameModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectCodeShortNameModel model);

    /**
     * 按主键选择
     */
    ProjectCodeShortNameModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectCodeShortNameModel> selectByModel(ProjectCodeShortNameModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectCodeShortNameModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectCodeShortNameModel model);

    List<ProjectCodeShortNameModel> selectRegProjectCodeShortName(@Param("regId") Long regId, @Param("codeId") Long codeId);

    int deleteByCodeIdAndIdNotInIds(@Param("codeId") Long projectCodeId, @Param("list") List<Long> shortNameIds);
}