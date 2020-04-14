package com.fea.project.service.fieldconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.fieldconfig.ProjectFieldConfigPersonMapper;
import com.fea.project.model.fieldconfig.ProjectFieldConfigEnterpriseModel;
import com.fea.project.model.fieldconfig.ProjectFieldConfigModel;
import com.fea.project.model.fieldconfig.ProjectFieldConfigPersonModel;
import com.fea.project.model.fieldconfig.pojo.ProjectUpdateFieldPojo;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/01/19.
 */
@Service
public class ProjectFieldConfigPersonService {

    @Autowired
    private ProjectFieldConfigPersonMapper projectFieldConfigPersonMapper;

    @Autowired
    private ProjectFieldConfigEnterpriseService projectFieldConfigEnterpriseService;

    @Autowired
    private SysUserService sysUserService;



    private List<Map<String, String>> selectListColumnsByTypeAndUserId(Integer type, Long userId){
        if(type == null || userId == null){
            throw new SystemParamCheckException("业务类型或是用户id异常，无法进行查询");
        }
        List<ProjectFieldConfigPersonModel> projectFieldConfigPersonModels = this.projectFieldConfigPersonMapper.selectByModel(new ProjectFieldConfigPersonModel(type, userId));
        if(projectFieldConfigPersonModels.isEmpty()){
            List<ProjectFieldConfigEnterpriseModel> projectFieldConfigEnterpriseModels = this.projectFieldConfigEnterpriseService.selectModelsOrInit(type);
            SysUserModel userModel = this.sysUserService.getCurrentUsr();
            projectFieldConfigPersonModels = ProjectFieldConfigPersonModel.createListByEnterpriseList(projectFieldConfigEnterpriseModels, userModel);
            this.projectFieldConfigPersonMapper.insertList(projectFieldConfigPersonModels);
        }
        List<String> fieldNames = projectFieldConfigPersonModels.stream().map(ProjectFieldConfigPersonModel::getFieldName).collect(Collectors.toList());
        List<ProjectFieldConfigEnterpriseModel> list = this.projectFieldConfigEnterpriseService.selectByModel(new ProjectFieldConfigEnterpriseModel(UserUtil.getUserRegId(), type));
        list = list.stream().filter(x -> fieldNames.contains(x.getFieldName())).collect(Collectors.toList());
        return list.stream().map(x -> new HashMap<String, String>(2){{
            put("fieldName", x.getFieldName());
            put("name", x.getName());
        }}).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Map<String, String>> selectColumnsByType(ProjectFieldConfigPersonModel model) {
        if(model == null || model.getTypeId() == null){
            throw new SystemParamCheckException("参数异常，无法查询对应的字段数据");
        }
        Long userId = UserUtil.getUserId();
        return this.selectListColumnsByTypeAndUserId(model.getTypeId(), userId);
    }

    public Map<String, List<ProjectFieldConfigModel>> selectConfigFieldByType(ProjectFieldConfigPersonModel model) {
        if(model == null || model.getTypeId() == null){
            throw new SystemParamCheckException("参数异常，无法查询对应的字段数据");
        }
        Long userId = UserUtil.getUserId();
        List<ProjectFieldConfigEnterpriseModel> projectFieldConfigEnterpriseModels = this.projectFieldConfigEnterpriseService.selectByModel(new ProjectFieldConfigEnterpriseModel(UserUtil.getUserRegId(), model.getTypeId()));
        List<ProjectFieldConfigPersonModel> projectFieldConfigPersonModels = this.projectFieldConfigPersonMapper.selectByModel(new ProjectFieldConfigPersonModel(model.getTypeId(), userId));
        if(projectFieldConfigEnterpriseModels.isEmpty()){
            throw new SystemParamCheckException("企业字段配置未配置请先进行配置");
        }
        List<ProjectFieldConfigModel> enterpriseModels = projectFieldConfigEnterpriseModels.stream().map(ProjectFieldConfigModel::new).collect(Collectors.toList());
        Map<String, ProjectFieldConfigEnterpriseModel> enterpriseMap = projectFieldConfigEnterpriseModels.stream().collect(Collectors.toMap(ProjectFieldConfigEnterpriseModel::getFieldName, x -> x));
        List<ProjectFieldConfigModel> personModels = new ArrayList<>();
        projectFieldConfigPersonModels.forEach(x -> {
            if(enterpriseMap.containsKey(x.getFieldName())){
                personModels.add(new ProjectFieldConfigModel(enterpriseMap.get(x.getFieldName())));
            }
        });
        if(enterpriseModels.removeAll(personModels)){
            return new HashMap<String, List<ProjectFieldConfigModel>>(2){{
                put("canSet", enterpriseModels);
                put("hasSet", personModels);
            }};
        }
        throw new SystemParamCheckException("参数查询异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectUpdateFieldPojo updateConfigField(ProjectUpdateFieldPojo model) {
        if(model == null || model.getTypeId() == null || model.getEnterpriseIds() == null){
            throw new SystemParamCheckException("传入的配置类型异常，无法进行设定");
        }
        if(model.getEnterpriseIds().isEmpty()){
            throw new SystemParamCheckException("无法对该业务模块不配置字段");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectFieldConfigEnterpriseModel> list = this.projectFieldConfigEnterpriseService.selectByIds(model.getEnterpriseIds());
        List<ProjectFieldConfigPersonModel> projectFieldConfigPersonModels = ProjectFieldConfigPersonModel.createListByEnterpriseList(list, userModel);
        if(this.projectFieldConfigPersonMapper.deleteByTypeIdAndUserId(model.getTypeId(), userModel.getUserId()) >= 0
            && this.projectFieldConfigPersonMapper.insertList(projectFieldConfigPersonModels) >= 0){
            return model;
        }
        throw new SystemParamCheckException("数据字段更新失败");
    }
}