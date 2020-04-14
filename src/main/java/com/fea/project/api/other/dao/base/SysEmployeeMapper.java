package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysEmployeeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 * 员工信息表 mapper
 */
public interface SysEmployeeMapper {

    /**
     * 按主键选择
     */
    SysEmployeeModel selectById(Long EMPID);

    /**
     * 按模型选择
     */
    List<SysEmployeeModel> selectByModel(SysEmployeeModel model);

    List<SysEmployeeModel> selectByDepartIdsAndNotUserIds(@Param("departIds") List<Long> departIds, @Param("userIds") List<Long> userIds, @Param("regId") Long regId);
}