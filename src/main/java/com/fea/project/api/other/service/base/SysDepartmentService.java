package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysDepartmentMapper;
import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.base.SysEmployeeModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysDepartmentVo;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/15.
 */
@Service
public class SysDepartmentService {

    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Autowired
    private SysEmployeeService sysEmployeeService;


    /**
     * 按主键选择
     */
    public SysDepartmentModel selectById(Long DEPID) {
        return DEPID == null ? null : this.sysDepartmentMapper.selectById(DEPID);
    }

    /**
     * 按模型选择
     */
    public List<SysDepartmentModel> selectByModel(SysDepartmentModel model) {
        return model == null ? new ArrayList<>(0) : this.sysDepartmentMapper.selectByModel(model);
    }

    public List<SysDepartmentVo> selectDepartmentAndUsers(SysUserModel sysUserModel, List<Long> userIds) {
        if (sysUserModel == null) {
            throw new SystemParamCheckException("当前登陆人信息异常，请刷新后重试");
        }
        List<SysDepartmentVo> sysDepartmentVos = this.sysDepartmentMapper.selectByRegId(sysUserModel.getRegId());
        List<Long> departIds = sysDepartmentVos.stream().map(SysDepartmentVo::getDEPID).collect(Collectors.toList());
        List<SysEmployeeModel> sysEmployeeModels = this.sysEmployeeService.selectByDepartmentIdsAndNotUserIds(departIds, userIds, sysUserModel);
        Map<Long, List<SysEmployeeModel>> map = new HashMap<>(departIds.size());
        List<SysEmployeeModel> tmpList = null;
        for (int i = 0; i < sysEmployeeModels.size(); i++) {
            tmpList = map.computeIfAbsent(sysEmployeeModels.get(i).getDEPID(), k -> new ArrayList<>());
            tmpList.add(sysEmployeeModels.get(i));
        }
        sysDepartmentVos.forEach(tmp -> tmp.setSysEmployeeModelList(map.get(tmp.getDEPID()) == null ? new ArrayList<>() : map.get(tmp.getDEPID())));
        return sysDepartmentVos;
    }

    public List<SysDepartmentModel> selectByIds(List<Long> deptIds) {
        if (deptIds == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        if (deptIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.sysDepartmentMapper.selectByIds(deptIds);
    }

    public List<SysDepartmentVo> selectByRegId(Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id异常，无法进行查询");
        }
        return this.sysDepartmentMapper.selectByRegId(regId);
    }

    public List<TeamPersonSelectVo> selectDeptTreeByRegId(Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id异常，无法进行查询");
        }
        return TeamPersonSelectVo.createList(this.sysDepartmentMapper.selectByRegId(regId));
    }
}