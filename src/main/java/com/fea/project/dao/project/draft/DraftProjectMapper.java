package com.fea.project.dao.project.draft;

import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.vo.DraftProjectVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/10.
 * 项目信息表 mapper
 */
public interface DraftProjectMapper {
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
    int insert(DraftProjectModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<DraftProjectModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(DraftProjectModel model);
    /**
     * 按主键选择
     */
    DraftProjectVo selectById(Long id);
    /**
     * 按模型选择
     */
    List<DraftProjectModel> selectByModel(DraftProjectModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(DraftProjectModel model);
    /**
     * 按主键更新
     */
    int updateById(DraftProjectModel model);

    DraftProjectModel selectModelByIdAndConditionModel(@Param("id") Long businessId, @Param("map") Map<Integer, String> conditionMap);
}