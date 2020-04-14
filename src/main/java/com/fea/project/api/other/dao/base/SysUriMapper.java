package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysUriModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/03/06.
 * 通用资源表 mapper
 */
public interface SysUriMapper {
    /**
     * 按主键删除
     */
    int deleteById(Long URIID);
    /**
     * 按主键删除
     */
    int deleteByIds(List<Long> ids);
    /**
     * 插入数据
     */
    int insert(SysUriModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<SysUriModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(SysUriModel model);
    /**
     * 按主键选择
     */
    SysUriModel selectById(Long URIID);
    /**
     * 按模型选择
     */
    List<SysUriModel> selectByModel(SysUriModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(SysUriModel model);
    /**
     * 按主键更新
     */
    int updateById(SysUriModel model);

    List<SysUriModel> selectByCurrentUserProjectPriority(@Param("userId") Long userId, @Param("priorityStr") String projectManagePrioirtyStr);

    List<SysUriModel> selectByPriorityStr(@Param("priorityStr") String projectManagePriorityStr);
}