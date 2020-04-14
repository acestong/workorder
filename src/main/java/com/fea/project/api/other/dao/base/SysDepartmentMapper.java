package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.base.vo.SysDepartmentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */
public interface SysDepartmentMapper {

    /**
     * 按主键选择
     */
    SysDepartmentModel selectById(Long DEPID);

    /**
     * 按模型选择
     */
    List<SysDepartmentModel> selectByModel(SysDepartmentModel model);

    List<SysDepartmentVo> selectByRegId(@Param("regId") Long regId);

    List<SysDepartmentModel> selectByIds(@Param("list") List<Long> deptIds);
}