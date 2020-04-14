package com.fea.project.service.establishproject.projectresource;


import java.util.*;
import java.util.stream.Collectors;

import com.fea.project.api.other.enums.base.GenderTypeEnum;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.projectresource.ProjectEstablishResourceHumanMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.publish.GenderEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishResourceHumanPojo;
import com.fea.project.model.establishproject.projectresource.ProjectEstablishResourceHumanModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishResourceHumanVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.team.ProjectTeamUserService;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2020/01/10.
 */
@Service
public class ProjectEstablishResourceHumanService {

    @Autowired
    private ProjectEstablishResourceHumanMapper projectEstablishResourceHumanMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private ProjectTeamUserService projectTeamUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishResourceHumanMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishResourceHumanMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishResourceHumanModel model) {
        return model != null && this.projectEstablishResourceHumanMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishResourceHumanModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishResourceHumanModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishResourceHumanMapper.insertList(list);
            }
        } else {
            return this.projectEstablishResourceHumanMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishResourceHumanModel model) {
        return model != null && this.projectEstablishResourceHumanMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishResourceHumanModel selectById(Long id) {
        return id == null ? null : this.projectEstablishResourceHumanMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishResourceHumanModel> selectByModel(ProjectEstablishResourceHumanModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishResourceHumanMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishResourceHumanModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishResourceHumanMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishResourceHumanModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishResourceHumanMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishResourceHumanModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishResourceHumanMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishResourceHumanModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishResourceHumanMapper.insert(model) == 1;
        }
        return this.projectEstablishResourceHumanMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishResourceHumanModel deleteModel(ProjectEstablishResourceHumanModel model) {
        if(model == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入异常，无法进行删除");
        }
        ProjectEstablishResourceHumanModel dbDate = this.projectEstablishResourceHumanMapper.selectById(model.getId());
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(userModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        List<Long> projectUserIds = this.projectUserService.selectByProjectIdAndUserIds(dbDate.getProjectId(), new ArrayList<Long>(){{add(dbDate.getUserId());}})
                .stream().map(ProjectUserModel::getId).collect(Collectors.toList());
        if(this.projectEstablishResourceHumanMapper.updateByIdSelective(model) >= 0
            && this.projectUserService.deleteByIds(projectUserIds)
            && this.projectTeamUserService.deleteByProjectIdAndProjectUserIds(dbDate.getProjectId(), projectUserIds)){
            return model;
        }
        throw new SystemParamCheckException("删除异常，无法进行删除");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishResourceHumanModel updateModel(ProjectEstablishResourceHumanModel model) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if(this.projectEstablishResourceHumanMapper.updateByIdSelective(model) >= 0){
            return model;
        }
        throw new SystemParamCheckException("信息更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishResourceHumanPojo insertUserList(ProjectEstablishResourceHumanPojo projectEstablishResourceHumanPojo) {
        if(projectEstablishResourceHumanPojo == null || projectEstablishResourceHumanPojo.getUserIds() == null
            || projectEstablishResourceHumanPojo.getProjectId() == null){
            throw new SystemParamCheckException("人员信息插入异常，无法进行插入");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        List<Long> userIds = this.projectUserService.selectUserIdsByProjectId(projectEstablishResourceHumanPojo.getProjectId());
        Set<Long> hasInsertUserIds = new HashSet<>(userIds);
        projectEstablishResourceHumanPojo.setUserIds(projectEstablishResourceHumanPojo.getUserIds().stream().filter(x -> !hasInsertUserIds.contains(x)).collect(Collectors.toList()));
        if(projectEstablishResourceHumanPojo.getUserIds().isEmpty()){
            return projectEstablishResourceHumanPojo;
        }
        List<ProjectEstablishResourceHumanModel> list = projectEstablishResourceHumanPojo.getUserIds().stream()
                .map(x -> new ProjectEstablishResourceHumanModel(x, sysUserModel, projectEstablishResourceHumanPojo.getProjectId())).collect(Collectors.toList());
        List<ProjectUserModel> projectUserModels = ProjectUserModel.createList(
                new HashSet<>(projectEstablishResourceHumanPojo.getUserIds())
                , projectEstablishResourceHumanPojo.getProjectId(), sysUserModel, ActionEnum.INSERT_ACTION);
        if(this.projectEstablishResourceHumanMapper.insertList(list) >= 0
                && this.projectUserService.insertList(projectUserModels)
                && this.projectTeamUserService.insertListByProjectUserModels(projectUserModels)
            ){
            return projectEstablishResourceHumanPojo;
        }
        throw new SystemParamCheckException("人员信息插入异常");
    }

    public List<ProjectEstablishResourceHumanVo> listByParam(BasePageInfo<ProjectEstablishResourceHumanModel> basePageInfo) {
        if(basePageInfo== null || basePageInfo.getModel() == null || basePageInfo.getModel().getProjectId() == null){
            throw new SystemParamCheckException("参数传入异常，无法进行查询");
        }
        List<ProjectEstablishResourceHumanVo> list = this.projectEstablishResourceHumanMapper.selectByFilterAndOrderParams(basePageInfo);
        List<Long> userIds = list.stream().map(ProjectEstablishResourceHumanModel::getUserId).distinct().collect(Collectors.toList());
        Map<Long, SysUserModel> map = this.sysUserService.selectBaseInfoByIds(userIds).stream().collect(Collectors.toMap(SysUserModel::getUserId, x -> x));
        Map<Integer, String> genderMap = GenderTypeEnum.getMap();
        list.forEach(x -> {
            SysUserModel tmpModel = map.get(x.getUserId());
            if(tmpModel == null){
                return;
            }
            x.setDutyName(tmpModel.getDutyName());
            x.setGenderName(genderMap.get(tmpModel.getGender()));
            x.setName(tmpModel.getRealName());
            x.setRoleName(tmpModel.getRoleName());
        });
        return list;
    }
}