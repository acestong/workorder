package com.fea.project.dao.project.history;

import com.fea.project.model.project.history.HistoryStepModel;
import com.fea.project.model.project.history.vo.HistoryStepVo;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
public interface HistoryStepMapper {
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
    int insert(HistoryStepModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<HistoryStepModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(HistoryStepModel model);
    /**
     * 按主键选择
     */
    HistoryStepModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<HistoryStepVo> selectByModel(HistoryStepModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(HistoryStepModel model);
    /**
     * 按主键更新
     */
    int updateById(HistoryStepModel model);
}