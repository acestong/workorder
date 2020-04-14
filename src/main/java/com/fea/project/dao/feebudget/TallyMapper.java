package com.fea.project.dao.feebudget;

import com.fea.project.model.feebudget.TallyModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 记账管理模块表 mapper
 */
@Mapper
public interface TallyMapper {
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
    int insert(TallyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<TallyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(TallyModel model);
    /**
     * 按主键选择
     */
    TallyModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<TallyModel> selectByModel(TallyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(TallyModel model);
    /**
     * 按主键更新
     */
    int updateById(TallyModel model);
}