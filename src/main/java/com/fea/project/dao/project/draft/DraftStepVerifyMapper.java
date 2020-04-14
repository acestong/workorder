package com.fea.project.dao.project.draft;

import com.fea.project.model.project.draft.DraftStepVerifyModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface DraftStepVerifyMapper {
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
    int insert(DraftStepVerifyModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<DraftStepVerifyModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(DraftStepVerifyModel model);
    /**
     * 按主键选择
     */
    DraftStepVerifyModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<DraftStepVerifyModel> selectByModel(DraftStepVerifyModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(DraftStepVerifyModel model);
    /**
     * 按主键更新
     */
    int updateById(DraftStepVerifyModel model);

    List<DraftStepVerifyModel> selectByStepId(@Param("stepId") Long stepId);

}