package com.fea.project.dao.project.draft;

import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
public interface DraftStepMapper {
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
    int insert(DraftStepModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<DraftStepModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(DraftStepModel model);
    /**
     * 按主键选择
     */
    DraftStepModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<DraftStepVo> selectByModel(DraftStepModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(DraftStepModel model);
    /**
     * 按主键更新
     */
    int updateById(DraftStepModel model);

    int updateDelStatusByDraftId(@Param("draftId") Long draftId, @Param("delStatus") Integer status);


    List<DraftStepVo> selectByDraftId(@Param("draftId") Long draftId);
}