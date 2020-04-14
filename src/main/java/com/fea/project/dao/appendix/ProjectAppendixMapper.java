package com.fea.project.dao.appendix;

import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/25.
 * 附件表  mapper
 */
@Mapper
public interface ProjectAppendixMapper {
    /**
     * 按主键删除
     */
    int deleteById(Long id);
    /**
     * 按业务id删除
     */
    int deleteByBusinessId(Long businessId);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(ProjectAppendixModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ProjectAppendixModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectAppendixModel model);
    /**
     * 按主键选择
     */
    ProjectAppendixModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ProjectAppendixModel> selectByModel(ProjectAppendixModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectAppendixModel model);
    /**
     * 按主键更新
     */
    int updateById(ProjectAppendixModel model);

    List<ProjectAppendixModel> selectByBusinessId(@Param("businessId") Long businessId);

    int updateByBusinessIdAndIds(@Param("businessId") Long businessId, @Param("list") List<Long> appendixs);

    int updateDeleteStatueByBusinessIdAndIds(@Param("businessId") Long businessId, @Param("list") List<Long> appendixs);
    /**
     * 通过业务id查询附件的id和文件名称
     * */
    List<AppendixIdAndNameInfoModelVo> selectIdAndNameByBusiness(@Param("businessId") Long businessId);
}