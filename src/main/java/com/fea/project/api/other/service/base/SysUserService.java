package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysUserMapper;
import com.fea.project.api.other.enums.base.DeleteStatusEnum;
import com.fea.project.api.other.enums.base.EnableStatusEnum;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.plan.vo.ProjectTreeModelVo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.util.StringUtil;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/09/25.
 * 用户表 Service
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysJobService sysJobService;

    /**
     * 按主键选择
     */
    public SysUserModel selectById(Long USERID) {
        return USERID == null ? null : this.sysUserMapper.selectById(USERID);
    }

    /**
     * 按模型选择
     */
    public List<SysUserModel> selectByModel(SysUserModel model) {
        return model == null ? new ArrayList<>(0) : this.sysUserMapper.selectByModel(model);
    }


    public List<SysUserModel> selectByRegId(Long regId) {
        SysUserModel sysUserModel = new SysUserModel();
        sysUserModel.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
        sysUserModel.setIsDisabled(EnableStatusEnum.ENABLE.getStatus());
        sysUserModel.setRegId(regId);
        return this.sysUserMapper.selectByModel(sysUserModel);
    }

    public List<SysUserVo> selectByRegIds(List<Long> list) {
        if (ListUtil.isNullOrEmpty(list)) {
            return new ArrayList<>();
        }
        return this.sysUserMapper.selectByRegIds(list);
    }

    public SysUserModel getCurrentUsr() {
        Long userId = UserUtil.getUserId();
        SysUserModel user = (userId == null) ? null : this.sysUserMapper.selectById(userId);
        if (user == null) {
            throw new SystemParamCheckException("当前访问用户无效");
        }
        return user;
    }

    public List<SysUserModel> selectByIds(List<Long> userIds) {
        if (ListUtil.isNullOrEmpty(userIds)) {
            return new ArrayList<>();
        }
        return this.sysUserMapper.selectByIds(userIds);
    }

    public List<SysUserModel> selectBaseInfoByIds(List<Long> userIds) {
        if (ListUtil.isNullOrEmpty(userIds)) {
            return new ArrayList<>();
        }
        List<SysUserModel> list = this.sysUserMapper.selectBaseInfoByIds(userIds);
        List<SysUserModel> finalList = new ArrayList<>();
        Map<Long, SysUserModel> map = new HashMap<>();
        list.forEach(tmp -> {
            SysUserModel model = map.get(tmp.getUserId());
            if (model == null) {
                map.put(tmp.getUserId(), tmp);
                finalList.add(tmp);
                return;
            }
            StringBuffer sb = new StringBuffer(StringUtil
                    .isEmpty(model.getRoleName()) ? "" : model.getRoleName());
            if (StringUtil.isEmpty(sb.toString()) || StringUtil.isEmpty(tmp.getRoleName())) {
                sb = sb.append(StringUtil.isEmpty(tmp.getRoleName()) ? "" : tmp.getRoleName());
            } else {
                sb = sb.append(" ").append(tmp.getRoleName());
            }
            model.setRoleName(sb.toString());
        });
        return finalList;
    }

    public List<SysUserVo> selectUserInfoAndDeptInfoByIds(List<Long> userIds) {
        if (ListUtil.isNullOrEmpty(userIds)) {
            return Collections.emptyList();
        }
        return this.sysUserMapper.selectUserInfoAndDeptInfoByIds(userIds);
    }

    public List<SysJobVo> selectUserJobs(Long userId) {
        if (userId == null) {
            throw new SystemParamCheckException("当前用户id异常，请刷新后重试");
        }
        Long jobId = this.sysUserMapper.selectJobIdByUserId(userId);
        List<SysJobVo> sysJobModels = (jobId == null) ? Collections.emptyList() : sysJobService.selectTreeListByJobId(jobId);
        sysJobModels.stream().filter(x -> Objects.equals(jobId, x.getID())).forEach(x -> x.setSysUserModels(Collections.emptyList()));
        return sysJobModels;
    }

    public List<SysUserModel> selectCurrentUserAdminUsers(Long userId) {
        if (userId == null) { 
            throw new SystemParamCheckException("当前用户id异常，请刷新后重试");
        }
        Long jobId = this.sysUserMapper.selectJobIdByUserId(userId);
        List<SysJobVo> sysJobModels = (jobId == null) ? Collections.emptyList() : sysJobService.selectTreeListByJobId(jobId);
        return sysJobModels.isEmpty() ? Collections.emptyList() : this.sysUserMapper.selectUsersByJobIds(sysJobModels.stream().map(SysJobVo::getID).collect(Collectors.toList()));
    }
    public List<SysUserModel> selectCurrentUserAdminUsersWithParentId(Long userId) {
    	if (userId == null) {
    		throw new SystemParamCheckException("当前用户id异常，请刷新后重试");
    	}
    	Long jobId = this.sysUserMapper.selectJobIdByUserIdWithParentId(userId);
    	List<SysJobVo> sysJobModels = (jobId == null) ? Collections.emptyList() : sysJobService.selectTreeListByJobId(jobId);
    	return sysJobModels.isEmpty() ? Collections.emptyList() : this.sysUserMapper.selectUsersByJobIds(sysJobModels.stream().map(SysJobVo::getID).collect(Collectors.toList()));
    }

    public List<Long> selectByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("传入的角色id异常,无法进行查询");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        List<SysUserModel> sysUserModels = this.sysUserMapper.selectSysUserByRoleIds(roleIds);
        return sysUserModels.stream().map(SysUserModel::getUserId).distinct().collect(Collectors.toList());
    }

    public List<Long> selectCurrentUsersAdminUsers(Long aboveLevel, Long applyer) {
        if (aboveLevel == null || applyer == null) {
            throw new SystemParamCheckException("传入参数异常，无法查询当前申请人的上级信息");
        }
        SysUserModel sysUserModel = this.sysUserMapper.selectById(applyer);
        Long empId = sysUserModel.getEmpId();
        if (empId == null) {
            throw new SystemParamCheckException("当前用户没有上级信息");
        }
        int level = Integer.valueOf(aboveLevel + "");
        while (level > 0) {
            empId = this.sysUserMapper.selectSuperiorId(empId);
            if (empId == null) {
                throw new SystemParamCheckException("当前用户没有该" + aboveLevel + "级的上级");
            }
            level--;
        }
        SysUserModel superiorUser = this.sysUserMapper.selectByEmpIdAndApplyer(empId);
        if (superiorUser == null) {
            throw new SystemParamCheckException("当前用户没有该" + aboveLevel + "级的上级");
        }
        return Stream.of(superiorUser.getUserId()).collect(Collectors.toList());
    }

    public  ProjectTreeModelVo selectManagerInfo(Long leaderId) {
    	return leaderId == null?null:this.sysUserMapper.selectManagerInfo(leaderId);
    }

    public List<SysUserModel> selectByOrgIds(List<Long> orgIds) {
        if(ListUtil.isNullOrEmpty(orgIds)){
            return new ArrayList<>();
        }
        return this.sysUserMapper.selectByOrgIds(orgIds);
    }

    public Map<Long, String> selectDepMap(List<Long> userIds) {
        if(ListUtil.isNullOrEmpty(userIds)){
            return new HashMap<>(0);
        }
        List<SysUserModel> sysUserVos = this.selectBaseInfoByIds(userIds);
        return sysUserVos.stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getDeptName));
    }
    
    /**
     * 获取上级用户userModel 
     * @param userId
     * @return 
     */
    public SysUserModel selectUserByParentJobId(Long userId) {
    	if(userId == null) {
    		return null;
    	}
    	Long jobId = this.sysUserMapper.selectJobIdByUserIdWithParentId(userId);
    	SysUserModel sysUserModel = this.sysUserMapper.selectUserByParentJobId(jobId);
		return jobId == null ? null : sysUserModel;
    }
    
    
}