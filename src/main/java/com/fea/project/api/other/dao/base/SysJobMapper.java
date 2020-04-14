package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysJobModel;
import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.model.project.vo.UserIdAndJobIdModel;
import com.fea.project.model.user.vo.UserWithJobVo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/26.
 * 职位表 mapper
 */
public interface SysJobMapper {

    /**
     * 按主键选择
     */
    SysJobModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<SysJobModel> selectByModel(SysJobModel model);
    /**
     * 按照orgId和ParentId选择
     */
    List<SysJobModel> selectByOrgIdAndParentId(SysJobModel model);

    List<SysJobVo> selectTreeListByJobId(@Param("jobId") Long jobId);

  /**
   * 通过用户Id返回职位Id
   * @param userId
   * @return
   */
    Long selectJobIdByUserId(Long userId);
    /**
     * 通过jobId返回用户相关列表信息
     * @param jobId
     * @return
     */
    List<UserWithJobVo> selectUserInfoByJobId(Long jobId);
    /**
     * 通过orgId获取员工职位Model列表
     * @param orgId
     * @return
     */
    List<EmpTreeModelVo> selectEmpInfoByOrgId(Long orgId);

    List<UserIdAndJobIdModel> selectByRegIdAndJobIds(@Param("regId") Long regId, @Param("list") List<Long> jobIds);
}