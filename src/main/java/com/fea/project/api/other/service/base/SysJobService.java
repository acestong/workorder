package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysJobMapper;
import com.fea.project.api.other.model.base.SysJobModel;
import com.fea.project.api.other.model.base.vo.EmpTreeModelVo;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.publish.GenderEnum;
import com.fea.project.model.project.vo.UserIdAndJobIdModel;
import com.fea.project.model.user.vo.UserWithJobVo;

import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2019/10/26.
 * 职位表 Service
 */
@Service
public class SysJobService {

    @Autowired
    private SysJobMapper sysJobMapper;

    /**
     * 按主键选择
     */
    public SysJobModel selectById(Long ID) {
        return ID == null ? null : this.sysJobMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<SysJobModel> selectByModel(SysJobModel model) {
        return model == null ? new ArrayList<>(0) : this.sysJobMapper.selectByModel(model);
    }

    public List<SysJobVo> selectTreeListByJobId(Long jobId) {
        if (jobId == null) {
            throw new SystemParamCheckException("当前人员角色信息不存在，请刷新后重试");
        }
        return this.sysJobMapper.selectTreeListByJobId(jobId);
    }
    
    /*
     * 通过用户Id返回职位Id
     */
    public Long selectJobIdByUserId(Long userId) {
    	 if (userId == null) {
             throw new SystemParamCheckException("传入用户为空，无法查询职位");
         }
    	return this.sysJobMapper.selectJobIdByUserId(userId);
    };
    //通过jobId返回用户相关列表信息
    public List<UserWithJobVo> selectUserInfoByJobId(Long jobId){
    	 if (jobId == null) {
             throw new SystemParamCheckException("传入职位Id为空，无法查询用户");
         }
    	 List<UserWithJobVo> list = this.sysJobMapper.selectUserInfoByJobId(jobId);
    	 list.stream().forEach((model) -> {
    		 model.setGenderStr(GenderEnum.getValue(model.getGender().intValue()));
    	 });
    	return list;
    };

    /**
     * 按orgId和ParentId选择
     */
    public List<EmpTreeModelVo> selectByOrgIdAndParentId(Long orgId) {
        return this.sysJobMapper.selectEmpInfoByOrgId(orgId);
    }

    public List<UserIdAndJobIdModel> selectByRegIdAndJobIds(Long regId, List<Long> jobIds) {
        if(regId == null || ListUtil.isNullOrEmpty(jobIds)){
            return Collections.emptyList();
        }
        return this.sysJobMapper.selectByRegIdAndJobIds(regId, jobIds);
    }
}