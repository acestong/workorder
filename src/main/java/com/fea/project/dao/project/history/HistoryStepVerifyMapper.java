package com.fea.project.dao.project.history;

import com.fea.project.model.project.history.HistoryStepVerifyModel;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
public interface HistoryStepVerifyMapper {
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
    int insert(HistoryStepVerifyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<HistoryStepVerifyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(HistoryStepVerifyModel model);
    /**
     * 按主键选择
     */
    HistoryStepVerifyModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<HistoryStepVerifyModel> selectByModel(HistoryStepVerifyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(HistoryStepVerifyModel model);
    /**
     * 按主键更新
     */
    int updateById(HistoryStepVerifyModel model);
}