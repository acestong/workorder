package com.fea.project.dao.project.history;

import com.fea.project.model.project.history.HistoryDeliverClaimModel;
import com.fea.project.model.project.history.vo.HistoryDeliverClaimVo;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
public interface HistoryDeliverClaimMapper {
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
    int insert(HistoryDeliverClaimModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<HistoryDeliverClaimModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(HistoryDeliverClaimModel model);
    /**
     * 按主键选择
     */
    HistoryDeliverClaimModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<HistoryDeliverClaimVo> selectByModel(HistoryDeliverClaimModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(HistoryDeliverClaimModel model);
    /**
     * 按主键更新
     */
    int updateById(HistoryDeliverClaimModel model);
}