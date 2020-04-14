package com.fea.project.service.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigMapper;
import com.fea.project.enums.ProjectCompareTypeEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.config.ProjectConfigEnum;
import com.fea.project.enums.config.ProjectEstimateTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.config.*;
import com.fea.project.model.config.pojo.ProjectConfigDetailPojo;
import com.fea.project.model.config.pojo.ProjectConfigPojo;
import com.fea.project.model.config.vo.ProjectConfigDetailVo;
import com.fea.project.model.config.vo.ProjectConfigVo;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.pojo.ProjectFlowPojo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/08.
 */
@Service
public class ProjectConfigService {

    @Autowired
    private ProjectConfigMapper projectConfigMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectConfigEstimateDevlierableService projectConfigEstimateDevlierableService;

    @Autowired
    private ProjectConfigEstimateTaskService projectConfigEstimateTaskService;

    @Autowired
    private ProjectConfigEstimateCloseService projectConfigEstimateCloseService;

    @Autowired
    private ProjectConfigEstimatePercentService projectConfigEstimatePercentService;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private ProjectFlowService projectFlowService;

    @Autowired
    private ProjectConfigMilestoneService projectConfigMilestoneService;


    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private ProjectService projectService;


    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConfigMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConfigMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConfigModel model) {
        return model != null && this.projectConfigMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConfigModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConfigMapper.insertList(list);
            }
        } else {
            return this.projectConfigMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConfigModel model) {
        return model != null && this.projectConfigMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConfigModel selectById(Long id) {
        return id == null ? null : this.projectConfigMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConfigModel> selectByModel(ProjectConfigModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConfigMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectConfigModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectConfigMapper.insert(model) == 1;
        }
        return this.projectConfigMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigDetailVo listByParam(ProjectConfigPojo model) throws Exception {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id参数无效，无法进行查询");
        }
        List<ProjectConfigModel> list = this.projectConfigMapper.selectByModel(model);
        ProjectModel projectModel = this.projectService.selectById(model.getProjectId());
        ProjectConfigDetailVo returnModel = null;
        if (ListUtil.isNullOrEmpty(list)) {
            //初始化数据
            SysUserModel sysUserModel = sysUserService.getCurrentUsr();
            list = ProjectConfigModel.createList(ProjectConfigEnum.getConfigType(model.getIsEstablish()), sysUserModel, model.getProjectId());
            this.projectConfigMapper.insertList(list);
            returnModel = new ProjectConfigDetailVo(JSON.parseObject(JSON.toJSONString(list), new TypeReference<List<ProjectConfigVo>>() {}));
        } else {
            List<ProjectConfigVo> projectConfigVos = JSON.parseObject(JSON.toJSONString(list), new TypeReference<List<ProjectConfigVo>>() {
            });
            Map<Integer, ProjectConfigModel> map = list.stream().collect(Collectors.toMap(ProjectConfigModel::getTypeId, projectConfigModel -> projectConfigModel));
            Future<List<ProjectConfigVo>> projectConfigVoFuture = this.getProjectConfigVoCompoundModel(projectConfigVos);
            Future<ProjectConfigEstimateDeliverableCompoundModel> deliverableCompoundModelFuture = this.getProjectConfigEstimateDeliverableCompoundModel(map);
            Future<ProjectConfigEstimateTaskCompoundModel> taskCompoundModelFuture = this.getProjectConfigEstimateTaskCompoundModel(map);
            Future<ProjectConfigEstimateCloseCompoundModel> closeCompoundModelFuture = this.getProjectConfigEstimateCloseCompoundModel(map);
            Future<List<ProjectConfigMilestoneModel>> projectConfigMilestoneFuture = this.getProjectConfigMilestoneModels(model);
            returnModel = new ProjectConfigDetailVo(projectConfigVoFuture.get(), deliverableCompoundModelFuture.get()
                    , taskCompoundModelFuture.get(), closeCompoundModelFuture.get(), projectConfigMilestoneFuture.get());
        }
        returnModel.setIsInit(Objects.isNull(projectModel.getVerifyStatus())? EnableStatusEnum.ENABLE.getStatus():EnableStatusEnum.DISABLE.getStatus());
        return returnModel;
    }

    private Future<List<ProjectConfigMilestoneModel>> getProjectConfigMilestoneModels(ProjectConfigModel model) {
        return threadPoolExecutor.submit(() -> this.projectConfigMilestoneService.getMilestoneTypeList(new ProjectConfigMilestoneModel(model.getProjectId())));
    }

    private Future<List<ProjectConfigVo>> getProjectConfigVoCompoundModel(List<ProjectConfigVo> projectConfigVos) {
        return threadPoolExecutor.submit(() -> {
            List<Integer> flowTypes = ProjectConfigEnum.getFlowTypeId();
            List<Long> flowIds = projectConfigVos.stream().filter(x -> StringUtil.isNotEmpty(x.getRemark()) && flowTypes.contains(x.getTypeId()))
                    .map(x -> Long.parseLong(x.getRemark())).distinct().collect(Collectors.toList());
            Map<Long, String> projectFlowMap = this.projectFlowService.selectByIds(flowIds)
                    .stream().collect(Collectors.toMap(ProjectFlowModel::getId, ProjectFlowModel::getName));
            projectConfigVos.forEach(x -> {
                if (StringUtil.isEmpty(x.getRemark())) {
                    return;
                }
                if (flowTypes.contains(x.getTypeId())) {
                    x.setRemarkName(projectFlowMap.get(Long.parseLong(x.getRemark())));
                    return;
                }
            });
            return projectConfigVos;
        });
    }

    /**
     * 通过当前枚举以及对应的配置类型获取结项相关信息
     *
     * @param map
     * @return
     */
    private Future<ProjectConfigEstimateCloseCompoundModel> getProjectConfigEstimateCloseCompoundModel(Map<Integer, ProjectConfigModel> map) {
        return threadPoolExecutor.submit(() -> {
            ProjectConfigModel close = map.get(ProjectConfigEnum.CLOSE_PROJECT_CLOSE_ESTIMATE.getValue());
            if (close == null || ProjectConfigEnum.setClose().equals(close.getState())) {
                return null;
            }
            List<ProjectConfigEstimateCloseModel> projectConfigEstimateCloseModels = projectConfigEstimateCloseService.selectByCloseIdAndTypeId(close.getId()
                    , StringUtil.isEmpty(close.getRemark()) ? null : Integer.parseInt(close.getRemark()));
            return new ProjectConfigEstimateCloseCompoundModel(projectConfigEstimateCloseModels);
        });
    }

    /**
     * 通过当前枚举以及对应的配置类型获取配置项
     *
     * @param map
     * @return
     */
    private Future<ProjectConfigEstimateDeliverableCompoundModel> getProjectConfigEstimateDeliverableCompoundModel(Map<Integer, ProjectConfigModel> map) {
        return threadPoolExecutor.submit(() -> {
            ProjectConfigModel deliverable = map.get(ProjectConfigEnum.DELIVERABLE_PROJECT_DELIVERABLE_ESTIMATE.getValue());
            if (deliverable == null || ProjectConfigEnum.setClose().equals(deliverable.getState())) {
                return null;
            }
            ProjectConfigEstimateDevlierableModel projectConfigEstimateDevlierableModel = projectConfigEstimateDevlierableService.selectByDevlierableId(deliverable.getId());
            List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels = projectConfigEstimatePercentService.selectByBusinessId(deliverable.getId(), ProjectEstimateTypeEnum.TYPE_DELIVERABLE.getValue());
            return new ProjectConfigEstimateDeliverableCompoundModel(projectConfigEstimateDevlierableModel, projectConfigEstimatePercentModels);
        });
    }

    /**
     * 通过当前枚举以及对应的配置类型获取配置项
     *
     * @param map
     * @return
     */
    private Future<ProjectConfigEstimateTaskCompoundModel> getProjectConfigEstimateTaskCompoundModel(Map<Integer, ProjectConfigModel> map) {
        return threadPoolExecutor.submit(() -> {
            ProjectConfigModel task = map.get(ProjectConfigEnum.TASK_PROJECT_TASK_ESTIMATE.getValue());
            if (task == null || ProjectConfigEnum.setClose().equals(task.getState())) {
                return null;
            }
            ProjectConfigEstimateTaskModel projectConfigEstimateTaskModel = projectConfigEstimateTaskService.selectByTaskId(task.getId());
            List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels = projectConfigEstimatePercentService.selectByBusinessId(task.getId(), ProjectEstimateTypeEnum.TYPE_TASK.getValue());
            return new ProjectConfigEstimateTaskCompoundModel(projectConfigEstimateTaskModel, projectConfigEstimatePercentModels);
        });
    }

    /**
     * 对复合model进行参数更新
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigDetailPojo updateByProjectConfigModel(ProjectConfigDetailPojo model) throws ExecutionException, InterruptedException {
        if (ListUtil.isNullOrEmpty(model.getProjectConfigModelList())) {
            throw new SystemParamCheckException("传入的流程配置参数异常，无法进行配置");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        Long projectId = projectConfigMapper.selectById(model.getProjectConfigModelList().get(0).getId()).getProjectId();
        //对流程进行添加
        if (this.updateList(model.getProjectConfigModelList(), user)) {
            //获取三个部分信息进行相关更新
            Map<Integer, ProjectConfigModel> map = model.getProjectConfigModelList().stream().collect(Collectors.toMap(ProjectConfigModel::getTypeId, projectConfigModel -> projectConfigModel));
            ProjectConfigEstimateDeliverableCompoundModel projectConfigEstimateDeliverableCompoundModel = model.getProjectConfigEstimateDeliverableCompoundModel();
            ProjectConfigEstimateTaskCompoundModel projectConfigEstimateTaskCompoundModel = model.getProjectConfigEstimateTaskCompoundModel();
            ProjectConfigEstimateCloseCompoundModel projectConfigEstimateCloseCompoundModel = model.getProjectConfigEstimateCloseCompoundModel();
            List<ProjectConfigMilestoneModel> projectConfigMilestoneModels = model.getProjectConfigMilestoneModels();
            Map<Integer, String> actionMap = ProjectCompareTypeEnum.getMap();
            Boolean diverable = this.saveOrUpdateProjectConfigEstimateDeliverable(projectConfigEstimateDeliverableCompoundModel, map, actionMap);
            Boolean task = this.saveOrUpdateProjectConfigEstimateTask(projectConfigEstimateTaskCompoundModel, map, actionMap);
            Boolean close = this.saveOrUpdateProjectConfigEstimateClose(projectConfigEstimateCloseCompoundModel, map);
            Boolean milestone = this.saveOrUpdateProjectConfigMilestone(projectConfigMilestoneModels, projectId);
            if (diverable && task && close && milestone) {
                return model;
            }
        }
        throw new SystemParamCheckException("数据更新异常");
    }

    private Boolean saveOrUpdateProjectConfigMilestone(List<ProjectConfigMilestoneModel> projectConfigMilestoneModels, Long projectId) {
        return this.projectConfigMilestoneService.insertList(projectConfigMilestoneModels, projectId);
    }

    private Boolean saveOrUpdateProjectConfigEstimateClose(ProjectConfigEstimateCloseCompoundModel projectConfigEstimateCloseCompoundModel, Map<Integer, ProjectConfigModel> map) {
        ProjectConfigModel close = map.get(ProjectConfigEnum.CLOSE_PROJECT_CLOSE_ESTIMATE.getValue());
        if (ProjectConfigEnum.setClose().equals(close.getState())) {
            return true;
        }
        if (projectConfigEstimateCloseCompoundModel == null) {
            throw new SystemParamCheckException("传入的结项参数无效");
        }
        //删除对应的数据，插入新的数据
        Integer typeId = StringUtil.isEmpty(close.getRemark()) ? null : Integer.parseInt(close.getRemark());
        if (this.projectConfigEstimateCloseService.deleteByBusinessIdAndTypeIdThenInsertList(close.getId(), typeId, projectConfigEstimateCloseCompoundModel.getProjectConfigEstimateCloseModels())) {
            return true;
        }
        throw new SystemParamCheckException("交付物评价设置保存报错");
    }

    /**
     * 保存或是更新项目任务权重信息
     *
     * @param projectConfigEstimateTaskCompoundModel
     * @param map
     * @param actionMap
     * @return
     */
    private Boolean saveOrUpdateProjectConfigEstimateTask(ProjectConfigEstimateTaskCompoundModel projectConfigEstimateTaskCompoundModel
            , Map<Integer, ProjectConfigModel> map, Map<Integer, String> actionMap) {
        ProjectConfigModel task = map.get(ProjectConfigEnum.TASK_PROJECT_TASK_ESTIMATE.getValue());
        if (ProjectConfigEnum.setClose().equals(task.getState())) {
            return true;
        }
        if (projectConfigEstimateTaskCompoundModel == null) {
            throw new SystemParamCheckException("传入的任务参数无效");
        }
        List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels = projectConfigEstimateTaskCompoundModel.getProjectConfigEstimatePercentModels();
        translatePercentConfigNames(projectConfigEstimatePercentModels, actionMap, task.getId(), ProjectEstimateTypeEnum.TYPE_TASK);
        if (this.projectConfigEstimateTaskService.insertOrUpdate(projectConfigEstimateTaskCompoundModel.getProjectConfigEstimateTaskModel()) != null
                && this.projectConfigEstimatePercentService.deleteByBusinessIdAndInsertList(task.getId(), projectConfigEstimatePercentModels)) {
            return true;
        }
        throw new SystemParamCheckException("交付物评价设置保存报错");
    }

    private void translatePercentConfigNames(List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels, Map<Integer, String> actionMap, Long businessId, ProjectEstimateTypeEnum projectEstimateTypeEnum) {
        Set<Long> estimateIds = projectConfigEstimatePercentModels.stream().map(ProjectConfigEstimatePercentModel::getEstimateId).collect(Collectors.toSet());
        List<ProjectDictionaryItemModel> items = this.projectDictionaryItemService.selectByIds(new ArrayList<>(estimateIds));
        Map<Long, String> estimateMap = items.stream().collect(Collectors.toMap(ProjectDictionaryItemModel::getId, ProjectDictionaryItemModel::getName));
        if(projectConfigEstimatePercentModels.isEmpty()){
            return;
        }
        projectConfigEstimatePercentModels.forEach(tmpModel -> {
            tmpModel.setBusinessId(businessId);
            tmpModel.setTypeId(projectEstimateTypeEnum.getValue());
            tmpModel.setActionName(tmpModel.getActionId() == null ? null : actionMap.get(tmpModel.getActionId()));
            tmpModel.setEstimateName(tmpModel.getEstimateId() == null ? null : estimateMap.get(tmpModel.getEstimateId()));
        });
    }

    /**
     * 保存或是更新项目交付物权重信息
     *
     * @param projectConfigEstimateDeliverableCompoundModel
     * @param map
     * @param actionMap
     * @return
     */
    private Boolean saveOrUpdateProjectConfigEstimateDeliverable(ProjectConfigEstimateDeliverableCompoundModel projectConfigEstimateDeliverableCompoundModel
            , Map<Integer, ProjectConfigModel> map, Map<Integer, String> actionMap) {
        ProjectConfigModel deliverable = map.get(ProjectConfigEnum.DELIVERABLE_PROJECT_DELIVERABLE_ESTIMATE.getValue());
        if (ProjectConfigEnum.setClose().equals(deliverable.getState())) {
            return true;
        }
        if (projectConfigEstimateDeliverableCompoundModel == null) {
            throw new SystemParamCheckException("传入的交付物参数无效");
        }
        List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels = projectConfigEstimateDeliverableCompoundModel.getProjectConfigEstimatePercentModels();
        translatePercentConfigNames(projectConfigEstimatePercentModels, actionMap, deliverable.getId(), ProjectEstimateTypeEnum.TYPE_DELIVERABLE);
        if (this.projectConfigEstimateDevlierableService.insertOrUpdate(projectConfigEstimateDeliverableCompoundModel.getProjectConfigEstimateDevlierableModel()) != null
                && this.projectConfigEstimatePercentService.deleteByBusinessIdAndInsertList(deliverable.getId(), projectConfigEstimatePercentModels)) {
            return true;
        }
        throw new SystemParamCheckException("交付物评价设置保存报错");
    }

    private boolean updateList(List<ProjectConfigModel> projectConfigModelList, SysUserModel user) {
        if (ListUtil.isNullOrEmpty(projectConfigModelList)) {
            return false;
        }
        List<Integer> flowIds = ProjectConfigEnum.getNeedInputFLowIdList();
        for (ProjectConfigModel projectConfigModel : projectConfigModelList) {
            this.updateModel(projectConfigModel, user, flowIds);
        }
        return true;
    }

    private void updateModel(ProjectConfigModel projectConfigModel, SysUserModel user, List<Integer> flowIds) {
        if (projectConfigModel.getState().equals(ProjectConfigEnum.setStart()) && flowIds.contains(projectConfigModel.getTypeId())
                && StringUtil.isEmpty(projectConfigModel.getRemark())) {
            throw new SystemParamCheckException("当流程激活时，请选择要执行的流程信息").appendAlaramMsg(projectConfigModel.getTypeId() + "");
        }
        projectConfigModel.setUserInfo(user, ActionEnum.UPDATE_ACTION);
        this.projectConfigMapper.updateByIdSelective(projectConfigModel);
    }

    public BasePageInfo<ProjectFlowVo> selectProjectFlowByParam(BasePageInfo<ProjectFlowPojo> model) {
        ProjectModel projectModel = this.projectService.selectById(model.getModel().getProjectId());
        model.getModel().setProjectType(projectModel.getType());
        model.getModel().setRegId(UserUtil.getUserRegId());
        model.getModel().setSelectConfig(Boolean.TRUE);
        return this.projectFlowService.selectProjectFlowByParam(model);
    }

    public List<Map<String, Object>> selectActionCode() {
        return ProjectCompareTypeEnum.getProjectFlowSetActionCode();
    }

    public List<ProjectDictionaryItemSelectVo> selectProjectEstimateLevel() {
        return this.projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_ESTIMATE_VALUE.getValue(), UserUtil.getUserRegId()));
    }
}