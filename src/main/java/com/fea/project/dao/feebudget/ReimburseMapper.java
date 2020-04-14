package com.fea.project.dao.feebudget;

import com.fea.project.model.feebudget.ReimburseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 报销管理模块表 mapper
 */
@Mapper
public interface ReimburseMapper {
    /**
     *报销-采购费用
     */
    List<ReimburseModel> selectPurchase(ReimburseModel model);
    /**
     *报销-采购费用
     */
    List<ReimburseModel> selectPurchaseByDate(ReimburseModel model);
    /**
     *报销-日常费用
     */
    List<ReimburseModel> selectDaily(ReimburseModel model);
    /**
     *报销-出差费用
     */
    List<ReimburseModel> selectTravel(ReimburseModel model);
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
    int insert(ReimburseModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<ReimburseModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ReimburseModel model);
    /**
     * 按主键选择
     */
    ReimburseModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<ReimburseModel> selectByModel(ReimburseModel model);
    /**
     * date
     */
    List<ReimburseModel> selectDateList(@Param("relatedBill")Byte relatedBill,@Param("billId")Long billId);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ReimburseModel model);
    /**
     * 按主键更新
     */
    int updateById(ReimburseModel model);
}