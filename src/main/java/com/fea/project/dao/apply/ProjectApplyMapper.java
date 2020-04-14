package com.fea.project.dao.apply;

import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.apply.vo.ProjectApplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/18.
 */
public interface ProjectApplyMapper {
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
    int insert(ProjectApplyModel model);

    /**
     * 插入多条数据
     */
    int insertList(List<ProjectApplyModel> models);

    /**
     * 插入数据,字段为空时不插入
     */
    int insertSelective(ProjectApplyModel model);

    /**
     * 按主键选择
     */
    ProjectApplyModel selectById(Long id);

    /**
     * 按模型选择
     */
    List<ProjectApplyModel> selectByModel(ProjectApplyModel model);

    /**
     * 按主键更新,字段为空时不更新
     */
    int updateByIdSelective(ProjectApplyModel model);

    /**
     * 按主键更新
     */
    int updateById(ProjectApplyModel model);

    List<ProjectApplyVo> selectByFilterAndOrderParams(BasePageInfo<ProjectApplyPojo> basePageInfo);

    ProjectApplyVo selectOne(@Param("id") Long id);

    List<ProjectApplyVo> selectApplysByUserIdAndNumber(@Param("userId") Long userId, @Param("pageNum") Integer pageNum, @Param("sortKey") String sortKey, @Param("sortValue") String sortValue);

    List<ProjectApplyModel> selectRunningFlowByProjectIdAndApplyType(@Param("projectId") Long projectId, @Param("applyType") Integer applyType);

    int updateVerifyStatusById(@Param("id") Long id, @Param("verifyStatus") Integer verifyStatus);

    int updateVerifyStatusByBusinessIdAndVerifyStatus(@Param("newStatus") Integer newStatus, @Param("businessId") Long businessId, @Param("oldStatus") Integer oldStatus);

    List<ProjectApplyVo> selecNeedVerifytByFilterAndOrderParams(BasePageInfo<ProjectApplyPojo> basePageInfo);

    ProjectApplyVo selectByBusinessIdAndApplyTypes(@Param("businessId") Long business, @Param("list") List<Integer> applyTypes);
}