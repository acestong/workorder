package com.fea.project.service.fieldconfig;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.fieldconfig.ProjectFieldConfigEnterpriseMapper;
import com.fea.project.model.fieldconfig.ProjectFieldConfigEnterpriseModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2020/01/19.
 */
@Service
public class ProjectFieldConfigEnterpriseService {

    @Autowired
    private ProjectFieldConfigEnterpriseMapper projectFieldConfigEnterpriseMapper;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFieldConfigEnterpriseModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFieldConfigEnterpriseModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFieldConfigEnterpriseMapper.insertList(list);
            }
        } else {
            return this.projectFieldConfigEnterpriseMapper.insertList(models) > 0;
        }
        return true;
    }


    @Transactional(rollbackFor = Exception.class)
    public List<ProjectFieldConfigEnterpriseModel> selectModelsOrInit(Integer typeId) {
        if(typeId == null){
            throw new SystemParamCheckException("传入的类型id异常，无法进行查询");
        }
        Long regId = UserUtil.getUserRegId();
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectFieldConfigEnterpriseModel> list = this.projectFieldConfigEnterpriseMapper.selectByModel(new ProjectFieldConfigEnterpriseModel(regId, typeId));
        if(list.isEmpty()){
            list = this.projectFieldConfigEnterpriseMapper.selectSysInit(typeId);
            if(list.isEmpty()){
                throw new SystemParamCheckException("数据库中未定义初始化的类型字段数据");
            }
            list = ProjectFieldConfigEnterpriseModel.createNewList(list, regId, userModel);
            this.insertList(list);
        }
        return list;
    }

    public List<ProjectFieldConfigEnterpriseModel> selectByModel(ProjectFieldConfigEnterpriseModel projectFieldConfigEnterpriseModel) {
        if(projectFieldConfigEnterpriseModel == null){
            throw new SystemParamCheckException("参数传入异常，无法查询企业字段配置");
        }
        return this.projectFieldConfigEnterpriseMapper.selectByModel(projectFieldConfigEnterpriseModel);
    }

    public List<ProjectFieldConfigEnterpriseModel> selectByIds(List<Long> enterpriseIds) {
        if(enterpriseIds == null){
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        if(enterpriseIds.isEmpty()){
            return Collections.emptyList();
        }
        return this.projectFieldConfigEnterpriseMapper.selectByIds(enterpriseIds);
    }
}