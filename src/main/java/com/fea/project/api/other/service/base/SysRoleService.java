package com.fea.project.api.other.service.base;


import com.fea.project.api.other.dao.base.SysRoleMapper;
import com.fea.project.api.other.model.base.SysRoleModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.model.flow.vo.ProjectFlowPersonTypeSelectVo;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/14.
 * 角色表 Service
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 按主键选择
     */
    public SysRoleModel selectById(Long ROLEID) {
        return ROLEID == null ? null : this.sysRoleMapper.selectById(ROLEID);
    }

    /**
     * 按模型选择
     */
    public List<SysRoleModel> selectByModel(SysRoleModel model) {
        return model == null ? new ArrayList<>(0) : this.sysRoleMapper.selectByModel(model);
    }


    public Object selectModelsByUserReg() {
        List<SysRoleModel> list = this.sysRoleMapper.selectByModel(new SysRoleModel(UserUtil.getUserRegId(), EnableStatusEnum.ENABLE.getStatus()));
        return list.stream().map(ProjectFlowPersonTypeSelectVo::new).collect(Collectors.toList());
    }

    public List<SysRoleModel> selectByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行查询");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.sysRoleMapper.selectByIds(roleIds);
    }

    public List<Long> selectSysUserIdsByRoleIds(List<Long> roleIds) {
        if (roleIds == null) {
            throw new SystemParamCheckException("传入的角色id异常，无法进行查询");
        }
        if (roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.sysUserService.selectByRoleIds(roleIds);
    }
}