package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysOrgRegisterMapper;
import com.fea.project.api.other.model.base.SysOrgRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 * 组织注册表 Service
 */
@Service
public class SysOrgRegisterService {

    @Autowired
    private SysOrgRegisterMapper sysOrgRegisterMapper;


    /**
     * 按主键选择
     */
    public SysOrgRegisterModel selectById(Long REGID) {
        return REGID == null ? null : this.sysOrgRegisterMapper.selectById(REGID);
    }

    /**
     * 按模型选择
     */
    public List<SysOrgRegisterModel> selectByModel(SysOrgRegisterModel model) {
        return model == null ? new ArrayList<>(0) : this.sysOrgRegisterMapper.selectByModel(model);
    }

}