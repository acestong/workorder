package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectMHourManageModelMapper;
import com.fea.project.dao.project.ProjectOvertimeModelMapper;
import com.fea.project.model.project.ProjectOvertimeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @autor Administrator
 * @date: 2019/12/11
 * @time: 9:42
 */
@Service
public class ProjectOverTimeService {



    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectOvertimeModelMapper projectOvertimeModelMapper;


    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertModel(ProjectOvertimeModel model) {
        model.setCreateBy(sysUserService.getCurrentUsr().getRealName());
        model.setCreateId(sysUserService.getCurrentUsr().getUserId());
        model.setCreateTime(new Date());
       return projectOvertimeModelMapper.insert(model);
    }




}
