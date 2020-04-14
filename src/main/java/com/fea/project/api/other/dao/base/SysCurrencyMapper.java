package com.fea.project.api.other.dao.base;


import com.fea.project.api.other.model.base.SysCurrencyModel;

import java.util.List;

/**
 * Created by Administrator on 2020/03/05.
 */
public interface SysCurrencyMapper {
    /**
     * 按主键删除
     */
    int deleteById(Long ID);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(SysCurrencyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<SysCurrencyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(SysCurrencyModel model);
    /**
     * 按主键选择
     */
    SysCurrencyModel selectById(Long ID);
    /**
     * 按模型选择
     */
    List<SysCurrencyModel> selectByModel(SysCurrencyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(SysCurrencyModel model);
    /**
     * 按主键更新
     */
    int updateById(SysCurrencyModel model);
}