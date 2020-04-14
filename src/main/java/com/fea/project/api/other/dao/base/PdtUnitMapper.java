package com.fea.project.api.other.dao.base;


import com.fea.project.api.other.model.base.PdtUnitModel;

import java.util.List;

/**
 * Created by Administrator on 2020/03/05.
 */
public interface PdtUnitMapper {
    /**
     * 按主键删除
     */
    int deleteById(Long UNITID);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(PdtUnitModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<PdtUnitModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(PdtUnitModel model);
    /**
     * 按主键选择
     */
    PdtUnitModel selectById(Long UNITID);
    /**
     * 按模型选择
     */
    List<PdtUnitModel> selectByModel(PdtUnitModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(PdtUnitModel model);
    /**
     * 按主键更新
     */
    int updateById(PdtUnitModel model);
}