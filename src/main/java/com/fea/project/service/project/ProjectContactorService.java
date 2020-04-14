package com.fea.project.service.project;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.customer.CrmContactModel;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.model.customer.CrmStructureModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.customer.CrmContactService;
import com.fea.project.api.other.service.customer.CrmCustomerService;
import com.fea.project.api.other.service.customer.CrmStructureService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectContactorMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectResourceEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectContactorModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectContactorPojo;
import com.fea.project.model.project.vo.ProjectContactorVo;
import com.fea.project.model.project.vo.ProjectContactorsSelectVo;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/10/24.
 */
@Service
public class ProjectContactorService {

    @Autowired
    private ProjectContactorMapper projectContactorMapper;

    @Autowired
    private CrmContactService crmContactService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CrmStructureService crmStructureService;


    @Autowired
    private CrmCustomerService crmCustomerService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectContactorMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectContactorMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectContactorModel model) {
        return model != null && this.projectContactorMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectContactorModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectContactorModel> list : ListUtil.getSubList(models, 100)) {
                this.projectContactorMapper.insertList(list);
            }
        } else {
            return this.projectContactorMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectContactorModel model) {
        return model != null && this.projectContactorMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectContactorModel selectById(Long id) {
        return id == null ? null : this.projectContactorMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectContactorModel> selectByModel(ProjectContactorModel model) {
        return model == null ? new ArrayList<>(0) : this.projectContactorMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectContactorMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectContactorMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectContactorModel model) {
        return !(model == null || model.getId() == null) && this.projectContactorMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectContactorModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectContactorMapper.insert(model) == 1;
        }
        return this.projectContactorMapper.updateById(model) == 1;
    }

    public BasePageInfo<ProjectContactorVo> listByParam(BasePageInfo<ProjectContactorModel> model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize(), true);
        List<ProjectContactorVo> list = this.projectContactorMapper.selectByFilterAndOrderParams(model);
        List<Long> contactorIds = list.stream().map(ProjectContactorVo::getContactorId).collect(Collectors.toList());
        Map<Long, CrmContactModel> map = this.crmContactService.selectByIds(contactorIds)
                .stream().collect(Collectors.toMap(CrmContactModel::getID, crmContactModel -> crmContactModel));
        list.forEach(tmp -> {
            CrmContactModel tmpModel = map.get(tmp.getContactorId());
            if (tmpModel == null) {
                return;
            }
            tmp.setContactBaseInfo(tmpModel);
        });
        return new BasePageInfo<>(list);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectContactorModel updateModel(ProjectContactorModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectContactorMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("联系人数据更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectContactorPojo insertModel(ProjectContactorPojo model) {
        if (ListUtil.isNullOrEmpty(model.getContactorIds())) {
            throw new SystemParamCheckException("联系人选择异常，无法进行新增").appendAlaramMsg(JSON.toJSONString(model));
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        List<ProjectContactorModel> list = model.getContactorIds().stream().map(x -> new ProjectContactorModel(model, x)).collect(Collectors.toList());
        if (this.projectContactorMapper.insertList(list) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("联系人数据插入异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectContactorPojo deleteModels(ProjectContactorPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("信息传入异常，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectContactorMapper.updateModelsByIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("联系人数据删除异常");
    }

    public List<ProjectContactorsSelectVo> selectContactorsByProjectId(ProjectContactorModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行联系人查询");
        }
        ProjectModel projectModel = this.projectService.selectById(model.getProjectId());
        if (projectModel == null) {
            throw new SystemParamCheckException("项目信息已经删除，无法进行查询");
        }
        List<Long> businessIds = StringUtil.isEmpty(projectModel.getConnectId()) ? Collections.emptyList() : Stream.of(projectModel.getConnectId().split(",")).filter(StringUtils::isNotEmpty).map(Long::parseLong).collect(Collectors.toList());
        List<Long> customerIds = ProjectResourceEnum.getCustomersByBussinessType(projectModel.getResource(), businessIds);
        List<CrmCustomerModel> crmCustomerModels = this.crmCustomerService.selectByIds(customerIds);
        //查询对应部门
        List<CrmStructureModel> crmStructureModels = this.crmStructureService.selectByCustomerIds(customerIds);
        //查询对应联系人
        List<CrmContactModel> crmContactModels = this.crmContactService.selectByCustomerIds(customerIds);
        return ProjectContactorsSelectVo.createList(crmCustomerModels, crmStructureModels, crmContactModels);
    }
}