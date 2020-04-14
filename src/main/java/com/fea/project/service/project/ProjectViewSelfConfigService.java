package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.crm.CrmDictionaryIndustryService;
import com.fea.project.api.other.service.crm.CrmDictionaryRegionService;
import com.fea.project.api.other.service.product.ProductStructureService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectViewSelfConfigMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.team.ProjectTeamUserService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/28.
 */
@Service
public class ProjectViewSelfConfigService {

    @Autowired
    private ProjectViewSelfConfigMapper projectViewSelfConfigMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private ProjectTeamUserService projectTeamUserService;

    @Autowired
    private CrmDictionaryIndustryService crmDictionaryIndustryService;

    @Autowired
    private CrmDictionaryRegionService crmDictionaryRegionService;

    @Autowired
    private ProductStructureService productStructureService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectViewSelfConfigMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectViewSelfConfigMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectViewSelfConfigModel model) {
        return model != null && this.projectViewSelfConfigMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectViewSelfConfigModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectViewSelfConfigModel> list : ListUtil.getSubList(models, 100)) {
                this.projectViewSelfConfigMapper.insertList(list);
            }
        } else {
            return this.projectViewSelfConfigMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectViewSelfConfigModel model) {
        return model != null && this.projectViewSelfConfigMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectViewSelfConfigModel selectById(Long id) {
        return id == null ? null : this.projectViewSelfConfigMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectViewSelfConfigModel> selectByModel(ProjectViewSelfConfigModel model) {
        return model == null ? new ArrayList<>(0) : this.projectViewSelfConfigMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectViewSelfConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectViewSelfConfigMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectViewSelfConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectViewSelfConfigMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectViewSelfConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectViewSelfConfigMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectViewSelfConfigModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectViewSelfConfigMapper.insert(model) == 1;
        }
        return this.projectViewSelfConfigMapper.updateById(model) == 1;
    }

    boolean insertProjectSelfConfigModels(Long viewId, List<ProjectViewSelfConfigModel> projectViewSelfConfigModels) {
        if (viewId == null) {
            throw new SystemParamCheckException("传入的视图id无效，无法进行新增");
        }
        if (ListUtil.isNullOrEmpty(projectViewSelfConfigModels)) {
            return true;
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        projectViewSelfConfigModels.forEach(x -> {
            x.setActionCode(ProjectViewFieldEnum.getActionCodeMap().get(x.getFieldType()) == null ?
                    null : ProjectViewFieldEnum.getActionCodeMap().get(x.getFieldType()).getValue());
            x.setConditionStr(ProjectActionCodeEnum.getExplainStr(x));
            x.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            x.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            x.setViewId(viewId);
        });
        if (this.insertList(projectViewSelfConfigModels)) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("自定义视图添加异常");
    }

    public boolean deleteModelsByViewId(Long viewId) {
        if (viewId == null) {
            throw new SystemParamCheckException("视图id传入异常，无法进行数据更新");
        }
        return this.projectViewSelfConfigMapper.deleteByViewId(viewId) >= 0;
    }

    public Map<Integer, Object> queryProjectSelfConfigViewParam() {
        Long regId = UserUtil.getUserRegId();
        Map<Integer, Object> map = new HashMap<>();
        //项目类型
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_TYPE.getValue(), this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_TYPE.getValue(), regId)));
        //项目级别
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_LEVEL.getValue(), this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_LEVEL.getValue(), regId)));
        //项目所属行业
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_RESOURCE.getValue(), this.crmDictionaryIndustryService.selectIndustryByLevel(null, regId));
        //项目所属区域
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_AREA.getValue(), this.crmDictionaryRegionService.selectRegionByLevel(null, regId));
        //项目风险等级
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_RISK_LEVEL.getValue(), this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_LEVEL.getValue(), regId)));
        //项目关联产品
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_CONNECT_RPODUCT.getValue(), this.productStructureService.selectProductsByLevel(null, regId));
        //项目创建人
        map.put(ProjectViewFieldEnum.TYPE_PROJECT_CREATER.getValue(), this.projectTeamUserService.selectDeptUserWithNoParam());
        return map;
    }
}