package com.fea.project.dao.feebudget;

import com.fea.project.model.feebudget.FeePurchaseDetailModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 采购明细表 mapper
 */
@Mapper
public interface FeePurchaseDetailMapper {
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
    int insert(FeePurchaseDetailModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<FeePurchaseDetailModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(FeePurchaseDetailModel model);
    /**
     * 按主键选择
     */
    FeePurchaseDetailModel selectById(Long ID);
    /**
     * 按模型选择
     */
    List<FeePurchaseDetailModel> selectByModel(FeePurchaseDetailModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(FeePurchaseDetailModel model);
    /**
     * 按主键更新
     */
    int updateById(FeePurchaseDetailModel model);
}