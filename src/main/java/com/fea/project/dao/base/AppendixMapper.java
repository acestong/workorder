package com.fea.project.dao.base;

import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.base.AppendixModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/05/07.
 * 附件表  mapper
 */
public interface AppendixMapper {
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
    int insert(AppendixModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<AppendixModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(AppendixModel model);

    /**
     * 按主键选择
     */
    AppendixModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<AppendixModel> selectByModel(AppendixModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(AppendixModel model);

    /**
     * 按主键更新
     */
    int updateById(AppendixModel model);

    void updateBusinessIdByIds(@Param("id") Long id, @Param("list") List<Long> appendixs);

    List<AppendixModel> selectByBusinessId(@Param("businessId") Long businessId);


    List<AppendixModel> selectByFilterAndOrderParams(PageInfoQueryOrderAndFilterModel<AppendixModel> caseModelPageInfoQueryOrderAndFilterModel);

    int updateAppendixDeleteStatusWhenNotInAppendixs(@Param("businessId") Long businessId, @Param("list") List<Long> appendixs);
}