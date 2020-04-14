package com.fea.project.service.config;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigMilestoneMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.config.ProjectConfigMilestoneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/04.
 */
@Service
public class ProjectConfigMilestoneService {

    @Autowired
    private ProjectConfigMilestoneMapper projectConfigMilestoneMapper;
    @Autowired
    private SysUserService sysUserService;


    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigMilestoneModel> models, Long projectId) {
        if (models == null) {
            throw new SystemParamCheckException("里程碑参数传入异常");
        }
        if (projectId == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行插入");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        List<Long> cantDeleteIds = models.stream().filter(x -> x.getId() != null)
                .map(ProjectConfigMilestoneModel::getId).distinct().collect(Collectors.toList());
        if (this.projectConfigMilestoneMapper.deleteByProjectIdAndCantDeleteIds(projectId, cantDeleteIds) >= 0
                && this.insertListOneByOne(models, sysUserModel)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目里程碑类型添加报错");
    }

    private boolean insertListOneByOne(List<ProjectConfigMilestoneModel> models, SysUserModel sysUserModel) {
        for (ProjectConfigMilestoneModel model : models) {
            this.insertOrUpdateModel(model, sysUserModel);
        }
        return Boolean.TRUE;
    }

    private boolean insertOrUpdateModel(ProjectConfigMilestoneModel model, SysUserModel sysUserModel) {
        if (model == null) {
            throw new SystemParamCheckException("里程碑类型数据异常，无法进行更新");
        }
        if (model.getId() == null) {
            model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            model.setRegId(sysUserModel.getRegId());
            return this.projectConfigMilestoneMapper.insertSelective(model) >= 0;
        }
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        return this.projectConfigMilestoneMapper.updateByIdSelective(model) >= 0;
    }


    /**
     * 插入数据,字段为空时不插入
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertModel(ProjectConfigMilestoneModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setRegId(currentUsr.getRegId());
        model.setUserInfo(currentUsr, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectConfigMilestoneMapper.insertSelective(model) >= 0) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目里程碑类型添加报错");
    }

    /**
     * 根据项目id查询对应的里程碑类型
     *
     * @param model
     * @return
     */
    public List<Map<String, Object>> selectTypeListByModel(ProjectConfigMilestoneModel model) {

        return projectConfigMilestoneMapper.selectByModel(model).stream().map(x -> new HashMap<String, Object>() {{
            put("id", x.getId());
            put("name", x.getName());
        }}).collect(Collectors.toList());
    }

    public List<ProjectConfigMilestoneModel> getMilestoneTypeList(ProjectConfigMilestoneModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id无效，无法进行查询");
        }
        List<ProjectConfigMilestoneModel> list = this.projectConfigMilestoneMapper.selectByModel(model);
        return list;
    }
}