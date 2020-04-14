package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.model.plan.vo.ProjectTreeModelVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/09/25.
 * 用户表 mapper
 */
public interface SysUserMapper {

    /**
     * 按主键选择
     */
    SysUserModel selectById(Long USERID);

    /**
     * 按模型选择
     */
    List<SysUserModel> selectByModel(SysUserModel model);

    List<SysUserVo> selectByRegIds(@Param("list") List<Long> list);

    List<SysUserModel> selectByIds(@Param("list") List<Long> userIds);

    List<SysUserModel> selectBaseInfoByIds(@Param("list") List<Long> userIds);

    List<SysUserVo> selectUserInfoAndDeptInfoByIds(@Param("list") List<Long> userIds);

    Long selectJobIdByUserId(@Param("userId") Long userId);
    
    Long selectJobIdByUserIdWithParentId(@Param("userId") Long userId);

    List<SysUserVo> selectSysUserByJobId(@Param("jobId") Long jobId);

    List<SysUserModel> selectUsersByJobIds(@Param("list") List<Long> jobs);
    
    /**
     * 获取上级用户
     * @param jobId
     * @return
     */
    SysUserModel selectUserByParentJobId(@Param("jobId")Long jobId);

    List<SysUserModel> selectSysUserByRoleIds(@Param("list") List<Long> roleIds);

    Long selectSuperiorId(@Param("empId") Long empId);

    SysUserModel selectByEmpIdAndApplyer(@Param("empId") Long empId);

    ProjectTreeModelVo selectManagerInfo(Long leaderId);

    List<SysUserModel> selectByOrgIds(@Param("list") List<Long> orgIds);
}