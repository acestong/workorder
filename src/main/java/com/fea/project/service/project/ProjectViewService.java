package com.fea.project.service.project;


import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectViewMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.EnableStatusEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.project.ProjectQueryTypeEnum;
import com.fea.project.enums.project.ProjectViewFieldEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectConcernModel;
import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.pojo.ProjectViewPojo;
import com.fea.project.model.project.vo.*;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/10/28.
 */
@Service
public class ProjectViewService {

    @Autowired
    private ProjectViewMapper projectViewMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectViewSelfConfigService projectViewSelfConfigService;

    @Autowired
    private ProjectConcernService projectConcernService;

    @Autowired
    private ProjectService projectService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectViewMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectViewMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectViewModel model) {
        return model != null && this.projectViewMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectViewModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectViewModel> list : ListUtil.getSubList(models, 100)) {
                this.projectViewMapper.insertList(list);
            }
        } else {
            return this.projectViewMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectViewModel model) {
        return model != null && this.projectViewMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectViewModel selectById(Long id) {
        return id == null ? null : this.projectViewMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectViewModel> selectByModel(ProjectViewModel model) {
        return model == null ? new ArrayList<>(0) : this.projectViewMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectViewModel model) {
        return !(model == null || model.getId() == null) && this.projectViewMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectViewModel model) {
        return !(model == null || model.getId() == null) && this.projectViewMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectViewModel model) {
        return !(model == null || model.getId() == null) && this.projectViewMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectViewModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectViewMapper.insert(model) == 1;
        }
        return this.projectViewMapper.updateById(model) == 1;
    }

    public Map<String, Object> listByCurrentUser() {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        if (sysUserModel.getRegId() == null || sysUserModel.getUserId() == null) {
            throw new SystemParamCheckException("当前用户信息异常，无法进行查询").appendAlaramMsg(sysUserModel.getRegId() + "-" + sysUserModel.getUserId());
        }
        //获取系统预定义数据
        List<ProjectViewModel> defaultViews = this.selectRegDefaultViewByRegId(sysUserModel);
        List<ProjectViewModel> selfConfigViews = this.selectUserViewByRegId(sysUserModel);
        return new HashMap<String, Object>(2) {{
            put("defaultView", defaultViews);
            put("selfConfigView", selfConfigViews);
        }};
    }

    private List<ProjectViewModel> selectUserViewByRegId(SysUserModel sysUserModel) {
        return this.projectViewMapper.selectSelfConfigUserViewByRegId(sysUserModel.getRegId()
                , sysUserModel.getUserId());
    }

    /**
     * 获取当前组织的预定义视图
     *
     * @param sysUserModel
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ProjectViewModel> selectRegDefaultViewByRegId(SysUserModel sysUserModel) {
        List<ProjectViewModel> list = this.projectViewMapper.selectRegDefaultViewByRegId(sysUserModel.getRegId(), sysUserModel.getUserId(), null);
        if (list.isEmpty()) {
            list = this.projectViewMapper.selectRegDefaultViewByRegId(null, null, EnableStatusEnum.ENABLE.getStatus());
            list.forEach(x -> {
                x.setUserId(sysUserModel.getUserId());
                x.setRegId(sysUserModel.getRegId());
                x.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
            });
            if (this.insertList(list)) {
                return list;
            }
            throw new SystemParamCheckException("人员预定义视图生成报错");
        }
        return list;
    }

    public List<ProjectViewModel> listDefaultVisiableView() {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        if (sysUserModel.getRegId() == null || sysUserModel.getUserId() == null) {
            throw new SystemParamCheckException("当前用户信息异常，无法进行查询")
                    .appendAlaramMsg(sysUserModel.getRegId() + "-" + sysUserModel.getUserId());
        }
        return this.selectRegDefaultViewByRegId(sysUserModel);
    }

    public List<ProjectViewModel> listSelfConfigView() {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        if (sysUserModel.getRegId() == null || sysUserModel.getUserId() == null) {
            throw new SystemParamCheckException("当前用户信息异常，无法进行查询")
                    .appendAlaramMsg(sysUserModel.getRegId() + "-" + sysUserModel.getUserId());
        }
        return this.selectUserViewByRegId(sysUserModel);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectViewModel insertModel(ProjectViewPojo model) {
        if (!ListUtil.isNullOrEmpty(model.getProjectViewSelfConfigModels())) {
            Set<Integer> viewSelfTypes = model.getProjectViewSelfConfigModels().stream().map(ProjectViewSelfConfigModel::getFieldType).collect(Collectors.toSet());
            if (!Objects.equals(viewSelfTypes.size(), model.getProjectViewSelfConfigModels().size())) {
                throw new SystemParamCheckException("存在相同的视图类型被定义多次");
            }
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectViewMapper.insertSelective(model) >= 0
                && this.projectViewSelfConfigService.insertProjectSelfConfigModels(model.getId(), model.getProjectViewSelfConfigModels())) {
            return model;
        }
        throw new SystemParamCheckException("项目视图添加异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectViewModel updateModel(ProjectViewPojo model) {
        if (!ListUtil.isNullOrEmpty(model.getProjectViewSelfConfigModels())) {
            Set<Integer> viewSelfTypes = model.getProjectViewSelfConfigModels().stream().map(ProjectViewSelfConfigModel::getFieldType).collect(Collectors.toSet());
            if (!Objects.equals(viewSelfTypes.size(), model.getProjectViewSelfConfigModels().size())) {
                throw new SystemParamCheckException("存在相同的视图类型被定义多次");
            }
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectViewMapper.updateByIdSelective(model) >= 0
                && this.projectViewSelfConfigService.deleteModelsByViewId(model.getId())
                && this.projectViewSelfConfigService.insertProjectSelfConfigModels(model.getId(), model.getProjectViewSelfConfigModels())) {
            return model;
        }
        throw new SystemParamCheckException("项目视图添加异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectViewModel deleteModel(ProjectViewModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("视图信息传入异常，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectViewMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目视图删除异常");
    }

    public List<ProjectViewSelectVo> selectSelfConfigViewParam() {
        return ProjectViewSelectVo.createList(ProjectViewFieldEnum.getCanUsedViewTypes());
    }

    public ProjectViewModel seeOrNotDefaultView(ProjectViewModel model) {
        if (model == null || model.getId() == null || model.getStatus() == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行隐藏或是关闭").appendAlaramMsg(JSON.toJSONString(model));
        }
        model.setUserInfo(this.sysUserService.getCurrentUsr(), ActionEnum.UPDATE_ACTION);
        if (this.projectViewMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("视图状态修改失败");
    }

    public ProjectViewVo selectSelfConfigViewDetail(ProjectViewModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("传入的视图id异常，无法进行查询");
        }
        ProjectViewVo projectViewVo = this.projectViewMapper.selectInfoAndDetailSetById(model.getId());
        List<ProjectViewSelfConfigVo> projectViewSelfConfigVos = projectViewVo.getProjectViewSelfConfigVos();
        projectViewSelfConfigVos.forEach(x -> {
            x.setFieldTypeName(ProjectViewFieldEnum.getFieldTextMap().get(x.getFieldType()));
            x.setFilterTypeName(ProjectActionCodeEnum.getActionStr(x.getActionCode(), x.getFilterType()));
            x.setValueList(Stream.of(x.getFilterValue().split(",")).filter(StringUtil::isNotEmpty).collect(Collectors.toList()));
        });
        return projectViewVo;
    }

    public Object selectViewParamByTypeId(ProjectViewModel projectViewModel) {
        if(projectViewModel == null || projectViewModel.getTypeId() == null){
            throw new SystemParamCheckException("传入的类型id异常，无法进行查询");
        }
        ProjectViewFieldEnum targetEnum = ProjectViewFieldEnum.getTargetType(projectViewModel.getTypeId());
        if(targetEnum == null){
            return new ArrayList<>();
        }
        return targetEnum.selectParamByRegId(UserUtil.getUserRegId());
    }

    public BasePageInfo<ProjectVo> listByParam(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        if(pageInfo == null){
            throw new SystemParamCheckException("传入的参数异常");
        }
        if(pageInfo.getModel() == null){
            pageInfo.setModel(new ProjectPojo());
        }
        ProjectPojo tmp = pageInfo.getModel();
        if(!ListUtil.isNullOrEmpty(tmp.getOrgs())){
            List<Long> userIds = sysUserService.selectByOrgIds(tmp.getOrgs()).stream().map(SysUserModel::getUserId).distinct().collect(Collectors.toList());
            userIds.addAll(tmp.getLeaderIds() == null?new ArrayList<>():tmp.getLeaderIds());
            tmp.setLeaderIds(userIds.stream().distinct().collect(Collectors.toList()));
        }
        return this.projectService.selectProjectByViewInfo(pageInfo);
    }

    public ProjectStatisticsVo selectProjectCondition(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        if(pageInfo == null){
            throw new SystemParamCheckException("传入的参数异常");
        }
        if(pageInfo.getModel() == null){
            pageInfo.setModel(new ProjectPojo());
        }
        pageInfo.setPageSize(0);
        pageInfo.setPageSize(0);
        BasePageInfo<ProjectVo> basePageInfo = this.listByParam(pageInfo);
        return projectService.statisticsProjectModelsToStatisticsVo(basePageInfo.getList());
    }

    public BasePageInfo<ProjectVo> listByViewId(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        if (pageInfo == null || pageInfo.getModel() == null || pageInfo.getModel().getViewId() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        List<ProjectViewSelfConfigModel> projectViewSelfConfigModels = this.projectViewSelfConfigService.selectByModel(new ProjectViewSelfConfigModel(pageInfo.getModel().getViewId()));
        if(ListUtil.isNullOrEmpty(projectViewSelfConfigModels)){
            return new BasePageInfo<>(Collections.emptyList());
        }
        List<String> conditionStrs = projectViewSelfConfigModels.stream().map(ProjectViewSelfConfigModel::getConditionStr).collect(Collectors.toList());
        pageInfo.getModel().setConditionStrs(conditionStrs);
        return this.projectService.selectProjectByViewInfo(pageInfo);

    }

    public ProjectStatisticsVo selectProjectConditionByViewId(BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        if (pageInfo == null || pageInfo.getModel() == null || pageInfo.getModel().getViewId() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        List<ProjectViewSelfConfigModel> projectViewSelfConfigModels = this.projectViewSelfConfigService.selectByModel(new ProjectViewSelfConfigModel(pageInfo.getModel().getViewId()));
        if(ListUtil.isNullOrEmpty(projectViewSelfConfigModels)){
            return ProjectStatisticsVo.initModel();
        }
        List<String> conditionStrs = projectViewSelfConfigModels.stream().map(ProjectViewSelfConfigModel::getConditionStr).collect(Collectors.toList());
        pageInfo.getModel().setConditionStrs(conditionStrs);
        pageInfo.setPageSize(0);
        pageInfo.setPageSize(0);
        BasePageInfo<ProjectVo> basePageInfo = this.projectService.selectProjectByViewInfo(pageInfo);
        return projectService.statisticsProjectModelsToStatisticsVo(basePageInfo.getList());

    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectViewModel exchangeViewCommonUserStatus(ProjectViewModel projectViewModel) {
        if(projectViewModel == null || projectViewModel.getId() == null){
            throw new SystemParamCheckException("传入的视图id异常，无法进行查询");
        }
        projectViewModel = this.projectViewMapper.selectById(projectViewModel.getId());
        projectViewModel.setUserInfo(sysUserService.getCurrentUsr(), ActionEnum.UPDATE_ACTION);
        projectViewModel.setCommonUse(Objects.isNull(projectViewModel.getCommonUse())
                || Objects.equals(projectViewModel.getCommonUse(), EnableStatusEnum.DISABLE.getStatus())
                ? EnableStatusEnum.ENABLE.getStatus():EnableStatusEnum.DISABLE.getStatus());
        if(this.projectViewMapper.updateByIdSelective(projectViewModel) >= 0){
            return projectViewModel;
        }
        throw new SystemParamCheckException("视图常用设置异常，无法进行设置");
    }

    public List<ProjectViewModel> selectCommonUserViews() {
        Long userId = UserUtil.getUserId();
        Integer commonUse = EnableStatusEnum.ENABLE.getStatus();
        return this.projectViewMapper.selectSelfConfigByUserIdAndCommonUse(userId, commonUse);
    }

}