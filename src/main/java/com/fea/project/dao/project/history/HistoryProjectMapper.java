package com.fea.project.dao.project.history;

import com.fea.project.model.project.history.HistoryProjectModel;
import com.fea.project.model.project.history.vo.HistoryProjectVo;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 * 项目信息表 mapper
 */
public interface HistoryProjectMapper {
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
    int insert(HistoryProjectModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<HistoryProjectModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(HistoryProjectModel model);
    /**
     * 按主键选择
     */
    HistoryProjectVo selectById(Long id);
    /**
     * 按模型选择
     */
    List<HistoryProjectModel> selectByModel(HistoryProjectModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(HistoryProjectModel model);
    /**
     * 按主键更新
     */
    int updateById(HistoryProjectModel model);
}