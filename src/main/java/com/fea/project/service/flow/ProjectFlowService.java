package com.fea.project.service.flow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.flow.ProjectFlowMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectFlowVerifyTypeEnum;
import com.fea.project.enums.flow.base.ProjectPersonTypeEnum;
import com.fea.project.enums.project.ProjectStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.flow.PersonSelectParamModel;
import com.fea.project.model.flow.ProjectFlowListModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.flowtype.FlowTypeIdAndParamIdModel;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.model.flow.pojo.ProjectFlowPersonTypePojo;
import com.fea.project.model.flow.pojo.ProjectFlowPojo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/10.
 */
@Service
public class ProjectFlowService {

    @Autowired
    private ProjectFlowMapper projectFlowMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectFlowListService projectFlowListService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFlowMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFlowMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFlowModel model) {
        return model != null && this.projectFlowMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFlowModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFlowModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFlowMapper.insertList(list);
            }
        } else {
            return this.projectFlowMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFlowModel model) {
        return model != null && this.projectFlowMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFlowModel selectById(Long id) {
        return id == null ? null : this.projectFlowMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFlowModel> selectByModel(ProjectFlowModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFlowMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFlowModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFlowMapper.insertSelective(model) >= 0;
        }
        return this.projectFlowMapper.updateByIdSelective(model) >= 0;
    }

    public List<ProjectFlowModel> selectByIds(List<Long> flowIds) {
        if (ListUtil.isNullOrEmpty(flowIds)) {
            return new ArrayList<>();
        }
        return this.projectFlowMapper.selectByIds(flowIds);
    }

    public BasePageInfo<ProjectFlowVo> selectProjectFlowByParam(BasePageInfo<ProjectFlowPojo> model) {
        PageHelper.startPage(model.getPageNum(), model.getPageSize(), true);
        List<ProjectFlowVo> list = this.projectFlowMapper.selectProjectFlowByParam(model);
        Map<Long, String> projectTypeMap = projectDictionaryItemService.selectByIds(list.stream()
                .filter(x -> !Objects.isNull(x.getProjectType())).map(ProjectFlowVo::getProjectType).collect(Collectors.toList()))
                .stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
        Map<Integer, String> flowTypeMap = ProjectFlowTypeEnum.getMap();
        Map<Integer, String> statusMap = EnableStatusEnum.getStatusMap();
        List<Long> projectIds = list.stream().filter(x -> !Objects.isNull(x.getProjectId())).map(ProjectFlowVo::getProjectId).collect(Collectors.toList());
        Map<Long, String> nameMap = this.projectService.selectByIds(projectIds);
        list.forEach(x -> {
            x.setFlowTypeName(flowTypeMap.get(x.getFlowType()));
            x.setStatusName(statusMap.get(x.getState()));
            x.setProjectName(Objects.isNull(x.getProjectId()) ? null : nameMap.get(x.getProjectId()));
            x.setProjectTypeName(projectTypeMap.get(x.getProjectType()));
        });
        return new BasePageInfo<>(list);
    }

    public Object selectProjectFlowParam(ProjectFlowModel model) {
        if (model == null || model.getFlowType() == null) {
            throw new SystemParamCheckException("传入的流程类型无效，无法进行查询");
        }
        return ProjectFlowTypeEnum.getProjectFlowParam(model.getFlowType());
    }

    public Object selectFlowTypeParamByFlowTypeIdAndParamId(FlowTypeIdAndParamIdModel model) {
        if (model == null || model.getFlowType() == null) {
            throw new SystemParamCheckException("传入的流程类型异常，无法进行查询");
        }
        model.setRegId(UserUtil.getUserRegId());
        return ProjectFlowTypeEnum.getProjectFlowParamDetailInfo(model);
    }

    public BasePageInfo<ProjectFlowVo> listByParam(BasePageInfo<ProjectFlowPojo> pageInfo) {
        pageInfo.getModel().setRegId(UserUtil.getUserRegId());
        return this.selectProjectFlowByParam(pageInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectFlowPojo updateModel(ProjectFlowPojo model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, Objects.isNull(model.getId()) ? ActionEnum.INSERT_ACTION : ActionEnum.UPDATE_ACTION);
        if (this.insertOrUpdate(model)) {
            ProjectFlowListPojo projectFlowListPojo = null;
            if (model.getDefaultFlowModel() != null) {
                projectFlowListPojo = model.getDefaultFlowModel();
                projectFlowListPojo.setFlowId(model.getId());
                projectFlowListService.updateModel(projectFlowListPojo, ProjectFlowVerifyTypeEnum.TYPE_DEFAULT);
            }
            List<Long> ids = Objects.isNull(model.getProjectFlowListIds()) ? new ArrayList<>() : model.getProjectFlowListIds();
            if (projectFlowListPojo != null) {
                ids.add(projectFlowListPojo.getId());
            }
            if (this.projectFlowListService.deleteByNoDefaultAndNoIds(model.getId(), ids) && this.projectFlowListService.updateModelByIds(new ProjectFlowListModel(sysUserModel, model.getId()), ids)) {
                return model;
            }
        }
        throw new SystemParamCheckException("数据更新异常");
    }

    public List<Map<String, Object>> selectProjectFlowType() {
        return ProjectFlowTypeEnum.getFullType();
    }

    public ProjectFlowVo selectOne(ProjectFlowModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("id传入异常，无法进行");
        }
        ProjectFlowVo projectFlowVo = this.projectFlowMapper.selectVoById(model.getId());
        projectFlowListService.fileFullFlowInfo(projectFlowVo.getProjectFlowListModels());
        for (ProjectFlowListVo tmpModel : projectFlowVo.getProjectFlowListModels()) {
            if (Objects.equals(tmpModel.getIndex(), ProjectFlowVerifyTypeEnum.TYPE_DEFAULT.getIndex())) {
                projectFlowVo.setDefaultFlowModel(tmpModel);
                projectFlowVo.getProjectFlowListModels().remove(tmpModel);
                break;
            }
        }
        Long projectId = projectFlowVo.getProjectId();
        if (!Objects.isNull(projectId)) {
            ProjectModel projectModel = this.projectService.selectById(projectId);
            projectFlowVo.setProjectName(Objects.isNull(projectModel) ? null : projectModel.getName());
        }
        ProjectDictionaryItemModel projectTypeModel = Objects.isNull(projectFlowVo.getProjectType()) ? null : this.projectDictionaryItemService.selectById(projectFlowVo.getProjectType());
        projectFlowVo.setProjectTypeName(Objects.isNull(projectTypeModel) ? null : projectTypeModel.getName());
        return projectFlowVo;
    }

    public PersonSelectParamModel selectPersonByPersonType(ProjectFlowPersonTypePojo model) {
        if (model == null || model.getPersonType() == null) {
            throw new SystemParamCheckException("人员信息异常，无法进行查询");
        }
        PersonSelectParamModel personSelectParamModel = new PersonSelectParamModel();
        personSelectParamModel.setSelectList(ProjectPersonTypeEnum.getTargetEnum(model.getPersonType()).getPersonCanSelectList(model));
        personSelectParamModel.setSignatureTypes(ProjectPersonTypeEnum.getTargetEnum(model.getPersonType()).getSignatureTypes());
        return personSelectParamModel;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectFlowModel deleteModel(ProjectFlowModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("流程id传入异常，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectFlowMapper.updateByIdSelective(model) >= 0
                && this.projectFlowListService.deleteByFlowInfo(model)) {
            return model;
        }
        throw new SystemParamCheckException("项目流程删除异常，无法进行删除");
    }

    public ProjectFlowModel changeState(ProjectFlowModel model) {
        if (model == null || model.getId() == null || model.getState() == null
                || EnableStatusEnum.getStatusMap().get(model.getState()) == null) {
            throw new SystemParamCheckException("传入的参数异常，流程状态无法修改");
        }
        ProjectFlowModel projectFlowModel = this.projectFlowMapper.selectById(model.getId());
        if (projectFlowModel == null) {
            throw new SystemParamCheckException("当前流程不存在，无法进行状态变更");
        }
        if (Objects.equals(projectFlowModel.getState(), model.getState())) {
            throw new SystemParamCheckException("当前状态无需进行变更");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectFlowMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("状态变更异常，无法进行变更");
    }

    public BasePageInfo<ProjectVo> selectProjectByReg(BasePageInfo<ProjectPojo> model) throws ExecutionException, InterruptedException {
        if (model == null || model.getModel() == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        model.getModel().setRegId(UserUtil.getUserRegId());
        model.getModel().setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.getModel().setProjectStatus(ProjectStatusEnum.TYPE_NOT_FINISH.getValue());
        Long type = model.getModel().getType();
        if (type != null) {
            List<Long> typeList = this.projectDictionaryItemService.selectTreeById(type).stream().map(ProjectDictionaryItemModel::getId).collect(Collectors.toList());
            model.getModel().setType(null);
            model.getModel().setTypeList(typeList);
        }
        return this.projectService.listWithEstablishProjectByParam(model);
    }

    public List<ProjectDictionaryItemSelectVo> selectProjectTypeByReg() {
        return projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_TYPE.getValue(), UserUtil.getUserRegId()));
    }
}