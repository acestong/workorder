package com.fea.project.dao.project.draft;

import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.draft.vo.DraftDeliverClaimVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
public interface DraftDeliverClaimMapper {
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
    int insert(DraftDeliverClaimModel model);
    /**
     * 插入多条数据
     */
    int insertList(List<DraftDeliverClaimModel> models);
    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(DraftDeliverClaimModel model);
    /**
     * 按主键选择
     */
    DraftDeliverClaimModel selectById(Long id);
    /**
     * 按模型选择
     */
    List<DraftDeliverClaimVo> selectByModel(DraftDeliverClaimModel model);
    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(DraftDeliverClaimModel model);
    /**
     * 按主键更新
     */
    int updateById(DraftDeliverClaimModel model);

    int updateDelStatusByDraftId(@Param("draftId") Long draftId, @Param("delStatus") Integer status);

    List<DraftDeliverClaimModel> selectByDraftId(@Param("draftId") Long draftId);
}