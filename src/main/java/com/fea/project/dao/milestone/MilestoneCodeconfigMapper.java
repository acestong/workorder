package com.fea.project.dao.milestone;

import com.fea.project.model.milestone.MilestoneCodeconfigModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/10/29.
 * 编码配置表 mapper
 */
@Mapper
public interface MilestoneCodeconfigMapper {
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
    int insert(MilestoneCodeconfigModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<MilestoneCodeconfigModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(MilestoneCodeconfigModel model);
    /**
     * 按主键选择
     */
    MilestoneCodeconfigModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<MilestoneCodeconfigModel> selectByModel(MilestoneCodeconfigModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(MilestoneCodeconfigModel model);
    /**
     * 按主键更新
     */
    int updateById(MilestoneCodeconfigModel model);
   /**
    * 根据编码类型和组织查询
    */
    MilestoneCodeconfigModel selectByType(MilestoneCodeconfigModel model);
}