package com.fea.project.workorder.dao;

import com.fea.project.workorder.model.WorkorderTypeModel;
import com.fea.project.workorder.model.WorkorderTypeModelExample;
import com.fea.project.workorder.model.vo.TypeModelVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkorderTypeModelMapper {
    long countByExample(WorkorderTypeModelExample example);

    int deleteByExample(WorkorderTypeModelExample example);

    int deleteByPrimaryKey(Long workorderTypeId);

    int insert(WorkorderTypeModel record);

    int insertSelective(WorkorderTypeModel record);

    List<WorkorderTypeModel> selectByExample(WorkorderTypeModelExample example);
    
    List<WorkorderTypeModel> selectByModel(WorkorderTypeModel model);
    
    /**
     * 获取树型类型结构
     * @param orgId
     * @return
     */
    List<TypeModelVo> selectRootTypeListByorgId(Long orgId);

    WorkorderTypeModel selectByPrimaryKey(Long workorderTypeId);

    int updateByExampleSelective(@Param("record") WorkorderTypeModel record, @Param("example") WorkorderTypeModelExample example);

    int updateByExample(@Param("record") WorkorderTypeModel record, @Param("example") WorkorderTypeModelExample example);

    int updateByPrimaryKeySelective(WorkorderTypeModel record);

    int updateByPrimaryKey(WorkorderTypeModel record);
}