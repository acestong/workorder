package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectMHourManageModelMapper;
import com.fea.project.dao.project.ProjectOvertimeTypeModelMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectDeliverStatusEnum;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.ProjectOvertimeTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor Administrator
 * @date: 2019/12/11
 * @time: 9:42
 */
@Service
public class ProjectOverTimeTypeService {

    @Autowired
    private ProjectMHourManageModelMapper projectMhourManageMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectOvertimeTypeModelMapper projectOvertimeTypeModelMapper;

    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDeliverClaimModel insertModel(ProjectDeliverClaimModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDeliverStatus(ProjectDeliverStatusEnum.getInitStatus());
        throw new SystemParamCheckException("");
    }

    /**
     * 获取加班类型
     * @return
     */
    public List<ProjectOvertimeTypeModel> getAllOvertimeType(){
        List<ProjectOvertimeTypeModel> ProjectOvertimeTypeList=projectOvertimeTypeModelMapper.selectOvertimeTypeAll();
        return ProjectOvertimeTypeList;
    }


}
