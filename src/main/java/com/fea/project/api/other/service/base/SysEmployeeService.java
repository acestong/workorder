package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysEmployeeMapper;
import com.fea.project.api.other.model.base.SysEmployeeModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 * 员工信息表 Service
 */
@Service
public class SysEmployeeService {

    @Autowired
    private SysEmployeeMapper sysEmployeeMapper;


    /**
     * 按主键选择
     */
    public SysEmployeeModel selectById(Long EMPID) {
        return EMPID == null ? null : this.sysEmployeeMapper.selectById(EMPID);
    }

    /**
     * 按模型选择
     */
    public List<SysEmployeeModel> selectByModel(SysEmployeeModel model) {
        return model == null ? new ArrayList<>(0) : this.sysEmployeeMapper.selectByModel(model);
    }


    public List<SysEmployeeModel> selectByDepartmentIdsAndNotUserIds(List<Long> departIds, List<Long> userIds, SysUserModel sysUserModel) {
        if (ListUtil.isNullOrEmpty(departIds)) {
            return new ArrayList<>();
        }
        return this.sysEmployeeMapper.selectByDepartIdsAndNotUserIds(departIds, userIds, sysUserModel.getRegId());
    }
}