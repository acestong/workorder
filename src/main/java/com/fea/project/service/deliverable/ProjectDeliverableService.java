package com.fea.project.service.deliverable;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.deliverable.ProjectDeliverableMapper;
import com.fea.project.dao.milestone.ProjectMilestoneDeliverableMapper;
import com.fea.project.dao.project.ProjectDeliverClaimMapper;
import com.fea.project.dao.task.TaskDeliverProductModelMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.deliverable.DeliverableTypeEnum;
import com.fea.project.enums.milestone.DeliveryStatusEnum;
import com.fea.project.enums.milestone.MilestoneCodeConfigEnum;
import com.fea.project.enums.project.ProjectDeliverStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.deliverable.ProjectDeliverableModel;
import com.fea.project.model.deliverable.vo.ProjectDeliverableInsertVo;
import com.fea.project.model.deliverable.vo.ProjectDeliverableVo;
import com.fea.project.model.deliverable.vo.QueryDeliverableParamVo;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.model.projectdata.DataTeamVo;
import com.fea.project.model.task.TaskDeliverProductModel;
import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessProjectDeliverableApplyImplService;
import com.fea.project.service.milestone.MilestoneCodeconfigService;
import com.fea.project.service.milestone.ProjectMilestoneDeliverableService;
import com.fea.project.service.projectdata.DataFileService;
import com.fea.project.service.task.ITaskDeliverProductService;
import com.fea.project.service.team.ProjectTeamService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 * @date 2019/12/06
 */
@Service
public class ProjectDeliverableService implements IProjectApplyBusiness {

    @Resource
    private ProjectDeliverableMapper projectDeliverableMapper;
    @Resource
    private ProjectMilestoneDeliverableMapper milestoneDeliverableMapper;
    @Resource
    private TaskDeliverProductModelMapper taskDeliverProductModelMapper;
    @Autowired
    private ProjectAppendixService projectAppendixService;
    @Autowired
    private DataFileService dataFileService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private MilestoneCodeconfigService codeconfigService;
    @Autowired
    private ProjectTeamService projectTeamService;
    @Autowired
    private ProjectAppendixService appendixService;
    @Resource
    private ProjectDeliverClaimMapper projectDeliverClaimMapper;
    @Autowired
    private ProjectMilestoneDeliverableService projectMilestoneDeliverableService;
    @Autowired
    private ITaskDeliverProductService taskDeliverProductService;
    /**
     * 流程相关Bean
     */
    @Autowired
    private ProjectBusinessProjectDeliverableApplyImplService projectBusinessProjectDeliverableApplyImplService;
    /**
     * 获取交付物列表，返回
     */
    public PageInfo<ProjectDeliverableVo> getDeliverableList(BasePageInfo<DataTeamVo> model){
        QueryDeliverableParamVo queryDeliverableParamVo = new QueryDeliverableParamVo(model);
        if (model.getModel().getProjectId() == null){
            throw new SystemParamCheckException("参数传入有误，无法查询");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //存放userIds
        ArrayList<Long> deliverIds = new ArrayList<>();
        if (null == model.getModel().getTag()){
            //我的资料
            deliverIds.add(currentUsr.getUserId());
            queryDeliverableParamVo.setDeliverIds(deliverIds);
        }else if (0 == model.getModel().getTag()){
            //团队的资料
            List<Long> userIdsByTeamId = dataFileService.getUserIdsByTeamId(model.getModel().getId());
            if (userIdsByTeamId.isEmpty()){
                return new BasePageInfo<>(new ArrayList<>());
            }
            queryDeliverableParamVo.setDeliverIds(userIdsByTeamId);

        }else if (1 == model.getModel().getTag()){
            //员工的资料
            if (model.getModel().getId() == null){
                throw new SystemParamCheckException("参数传入错误，无法查询");
            }
            deliverIds.add(model.getModel().getId());
            queryDeliverableParamVo.setDeliverIds(deliverIds);
        }
        //根据项目id获取项目交付物
        Integer total = 0;
        List<ProjectDeliverableVo> projectDeliverableVos =
                projectDeliverableMapper.selectDeliverableByProjectId(queryDeliverableParamVo);
        total+=projectDeliverableVos.size();
        projectDeliverableVos.forEach(project ->{
            project.setDeliverableType(DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode());
            project.setDeliverableTypeString(DeliverableTypeEnum.PROJECT_DELIVERABLE.getText());
        });
        //里程碑交付物
        List<ProjectDeliverableVo> milestoneDeliverableVos =
                milestoneDeliverableMapper.selectDeliverableVoByProjectId(queryDeliverableParamVo);
        total+=milestoneDeliverableVos.size();
        milestoneDeliverableVos.forEach(milestone ->{
            milestone.setDeliverableType(DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode());
            milestone.setDeliverableTypeString(DeliverableTypeEnum.MILESTONE_DELIVERABLE.getText());
        });
        //任务交付物
        List<ProjectDeliverableVo> taskDeliverableVos =
                taskDeliverProductModelMapper.selectTaskDeliverableVoByProjectId(queryDeliverableParamVo);
        total+=taskDeliverableVos.size();
        taskDeliverableVos.forEach(task ->{
            task.setDeliverableType(DeliverableTypeEnum.TASK_DELIVERABLE.getCode());
            task.setDeliverableTypeString(DeliverableTypeEnum.TASK_DELIVERABLE.getText());

        });
        //将三种交付物汇总
        projectDeliverableVos.addAll(milestoneDeliverableVos);
        projectDeliverableVos.addAll(taskDeliverableVos);
        Collections.sort(projectDeliverableVos);
        //返回数据处理
        Integer index = (model.getPageNum()-1)*model.getPageSize();
        Integer toIndex = model.getPageNum()*model.getPageSize()>=total?
                total:model.getPageNum()*model.getPageSize();
        List<ProjectDeliverableVo> subList = ListUtil.getSubList(projectDeliverableVos, index, toIndex);
        subList.forEach(modelVo ->{
            if (modelVo.getVerifyer() != null){
                SysUserModel userModel = sysUserService.selectById(modelVo.getVerifyer());
                modelVo.setVerifyerName(userModel.getRealName());
            }
            modelVo.setVerifyerStatusString(ProjectApplyVerifyStatusEnum.getMap().get(modelVo.getVerifyerStatus()==null?
                    ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():modelVo.getVerifyerStatus()));
            modelVo.setDeliverName(modelVo.getCreateBy());
            ProjectTeamModel team = projectTeamService.getTeamByProjectIdAndUserId(model.getModel().getProjectId(),
                    modelVo.getDeliver());
            if (team != null){
                modelVo.setTeam(team.getName());
            }
            modelVo.setDeliverStatusString(DeliveryStatusEnum.queryText(modelVo.getDeliverStatus()));
        });
        PageInfo<ProjectDeliverableVo> pageInfo = new PageInfo<>(subList);
        pageInfo.setTotal(total);
        pageInfo.setPageNum(model.getPageNum());
        pageInfo.setPageSize(model.getPageSize());
        return pageInfo;
    }
    /**
     * 根据交付物id和交付物类型获取其详情
     *
     */
    public ProjectDeliverableVo getDeliverableInfo(ProjectDeliverableVo model){
        if (model.getDeliverableType() == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectDeliverableVo deliverableVo = null;
        if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            deliverableVo = projectDeliverableMapper.selectProjectDeliverableInfoById(model.getId());
            deliverableVo.setDeliverableType(DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode());
            deliverableVo.setDeliverableTypeString(DeliverableTypeEnum.PROJECT_DELIVERABLE.getText());
        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode())){
            deliverableVo = milestoneDeliverableMapper.selectMilestoneDeliverableInfoById(model.getId());
            deliverableVo.setDeliverableType(DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode());
            deliverableVo.setDeliverableTypeString(DeliverableTypeEnum.MILESTONE_DELIVERABLE.getText());
        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.TASK_DELIVERABLE.getCode())){
            deliverableVo = taskDeliverProductModelMapper.selectTaskDeliverableInfoById(model.getId());
            deliverableVo.setDeliverableType(DeliverableTypeEnum.TASK_DELIVERABLE.getCode());
            deliverableVo.setDeliverableTypeString(DeliverableTypeEnum.TASK_DELIVERABLE.getText());
        }else {
            throw new SystemParamCheckException("参数传入错误");
        }
        if (deliverableVo != null){
            if (deliverableVo.getVerifyer() != null){
                SysUserModel userModel = sysUserService.selectById(deliverableVo.getVerifyer());
                deliverableVo.setVerifyerName(userModel.getRealName());
            }
            deliverableVo.setVerifyerStatusString(ProjectApplyVerifyStatusEnum.getMap().get(deliverableVo.getVerifyerStatus()==null?
                    ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():deliverableVo.getVerifyerStatus()));
            deliverableVo.setDeliverName(deliverableVo.getCreateBy());
            ProjectTeamModel team = projectTeamService.getTeamByProjectIdAndUserId(deliverableVo.getProjectId(),
                    deliverableVo.getDeliver());
            if (team != null){
                deliverableVo.setTeam(team.getName());
            }
            deliverableVo.setDeliverStatusString(DeliveryStatusEnum.queryText(deliverableVo.getDeliverStatus()));
        }
        return deliverableVo;
    }

    /**
     * 新增交付物
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDeliverableVo addDeliverable(ProjectDeliverableInsertVo<ProjectDeliverableVo> model){

        if (model.getModel().getDeliverableType() == null || model == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        Date date = new Date();
        Long modelId = null;
        if (Objects.equals(model.getModel().getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            String num = null;
            try {
                num = codeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.PROJECT_DELIVERABLE_NUMBER.getType());
            } catch (Exception e) {
                throw new SystemParamCheckException("编号生成错误，请重试");
            }
            ProjectDeliverableModel projectDeliverableModel = new ProjectDeliverableModel(model.getModel());
            projectDeliverableModel.setDeliverableNum(num);
            projectDeliverableModel.setCreateId(user.getUserId());
            projectDeliverableModel.setCreateBy(user.getRealName());
            projectDeliverableModel.setCreateTime(date);
            projectDeliverableModel.setDeliver(user.getUserId());
            projectDeliverableModel.setDeliverTime(date);
            projectDeliverableModel.setDeliverStatus(DeliveryStatusEnum.SUCCESS_DELIVERY.getCode());
            projectDeliverableModel.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
            int i = projectDeliverableMapper.insertSelective(projectDeliverableModel);
            if (i == 1){
                modelId=projectDeliverableModel.getId();
                List<Long> appendixIds = model.getAppendixs();
                appendixIds.forEach(id ->{
                    boolean b = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(id, projectDeliverableModel.getId()));
                });
            }else {
                throw new SystemParamCheckException("新增失败");
            }
        }else if (Objects.equals(model.getModel().getDeliverableType(),DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode())){
            String num = null;
            try {
                num = codeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.MILESTONE_DELIVERABLE_NUMBER.getType());
            } catch (Exception e) {
                throw new SystemParamCheckException("编号生成错误，请重试");
            }
            ProjectMilestoneDeliverableModel projectMilestoneDeliverableModel = new ProjectMilestoneDeliverableModel(model.getModel());
            projectMilestoneDeliverableModel.setDeliverableNumber(num);
            projectMilestoneDeliverableModel.setCreateId(user.getUserId());
            projectMilestoneDeliverableModel.setCreateBy(user.getRealName());
            projectMilestoneDeliverableModel.setCreateTime(date);
            projectMilestoneDeliverableModel.setDeliver(user.getUserId());
            projectMilestoneDeliverableModel.setDeliverTime(date);
            projectMilestoneDeliverableModel.setDeliverStatus(DeliveryStatusEnum.SUCCESS_DELIVERY.getCode());
            projectMilestoneDeliverableModel.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
            int i = milestoneDeliverableMapper.insertSelective(projectMilestoneDeliverableModel);
            if (i == 1){
                modelId=projectMilestoneDeliverableModel.getId();
                List<Long> appendixIds = model.getAppendixs();
                appendixIds.forEach(id ->{
                    boolean b = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(id, projectMilestoneDeliverableModel.getId()));
                });
            }else {
                throw new SystemParamCheckException("新增失败");
            }
        }else if (Objects.equals(model.getModel().getDeliverableType(),DeliverableTypeEnum.TASK_DELIVERABLE.getCode())){
            String num = null;
            try {
                num = codeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.TASK_DELIVERABLE_NUMBER.getType());
            } catch (Exception e) {
                throw new SystemParamCheckException("编号生成错误，请重试");
            }
            TaskDeliverProductModel taskDeliverProductModel = new TaskDeliverProductModel();
            taskDeliverProductModel.setTaskId(model.getModel().getBusinessId());
            taskDeliverProductModel.setDeliverProductName(model.getModel().getDeliverableName());
            taskDeliverProductModel.setDeliverProductNum(num);
            taskDeliverProductModel.setDeliverProduceDesc(model.getModel().getDescription());
            taskDeliverProductModel.setTaskDeliverTime(model.getModel().getDeliveryTime());
            taskDeliverProductModel.setTaskDelivererId(user.getUserId());
            taskDeliverProductModel.setTaskDelivererName(user.getRealName());
            taskDeliverProductModel.setCreateId(user.getUserId());
            taskDeliverProductModel.setCreateBy(user.getRealName());
            taskDeliverProductModel.setCreateTime(date);
            taskDeliverProductModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue());
            int i = taskDeliverProductModelMapper.insertSelective(taskDeliverProductModel);
            if (i == 1){
                modelId=taskDeliverProductModel.getDeliverProductId();
                List<Long> appendixIds = model.getAppendixs();
                appendixIds.forEach(id ->{
                    boolean b = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(id,
                            taskDeliverProductModel.getDeliverProductId()));
                });
            }else {
                throw new SystemParamCheckException("新增失败");
            }
        }
        //返回给前端
        model.getModel().setId(modelId);
        return model.getModel();
    }

    public List<ProjectAppendixModel> getDeliverableAppendixList(ProjectDeliverableVo model){
        if (model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectAppendixModel appendixModel = new ProjectAppendixModel();
        appendixModel.setBusinessId(model.getId());
        List<ProjectAppendixModel> projectAppendixModels = appendixService.selectByModel(appendixModel);
        return projectAppendixModels;
    }
    /**
     * 交付物编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean editDeliverable(ProjectDeliverableInsertVo<ProjectDeliverableVo> modelVo){
        if (modelVo == null || modelVo.getModel().getDeliverableType() == null || modelVo.getModel().getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectDeliverableVo model = modelVo.getModel();
        SysUserModel user = sysUserService.getCurrentUsr();
        if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            ProjectDeliverableModel deliverableModel = new ProjectDeliverableModel(model);
            deliverableModel.setId(model.getId());
            deliverableModel.setUpdateId(user.getUserId());
            deliverableModel.setUpdateBy(user.getRealName());
            deliverableModel.setUpdateTime(new Date());
            projectDeliverableMapper.updateByIdSelective(deliverableModel);

        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode())){
            ProjectMilestoneDeliverableModel deliverableModel = new ProjectMilestoneDeliverableModel(model);
            deliverableModel.setId(model.getId());
            deliverableModel.setUpdateId(user.getUserId());
            deliverableModel.setUpdateBy(user.getRealName());
            deliverableModel.setUpdateTime(new Date());
            milestoneDeliverableMapper.updateByIdSelective(deliverableModel);

        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.TASK_DELIVERABLE.getCode())){
            TaskDeliverProductModel taskDeliverProductModel = new TaskDeliverProductModel();
            taskDeliverProductModel.setDeliverProductId(model.getId());
            taskDeliverProductModel.setTaskId(model.getBusinessId());
            taskDeliverProductModel.setDeliverProductName(model.getDeliverableName());
            taskDeliverProductModel.setDeliverProduceDesc(model.getDescription());
            taskDeliverProductModel.setTaskDeliverTime(model.getDeliveryTime());
            taskDeliverProductModel.setUpdateId(user.getUserId());
            taskDeliverProductModel.setUpdateBy(user.getRealName());
            taskDeliverProductModel.setUpdateTime(new Date());
            taskDeliverProductModelMapper.updateByPrimaryKeySelective(taskDeliverProductModel);
        }else {
            throw new SystemParamCheckException("参数传入错误");
        }
        try {
            List<Long> appendixIds = modelVo.getAppendixs();
            appendixIds.forEach(id ->{
                boolean b = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(id, model.getId()));
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemParamCheckException("数据更新报错，请重试！");
        }
        return true;
    }
    /**
     * 交付物删除
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteDeliverable(ProjectDeliverableVo model){
        if (model.getDeliverableType() == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            ProjectDeliverableModel deliverableModel = new ProjectDeliverableModel();
            deliverableModel.setId(model.getId());
            deliverableModel.setDelState(DeleteStatusEnum.DELETE.getStatus());
            deliverableModel.setUpdateId(user.getUserId());
            deliverableModel.setUpdateBy(user.getRealName());
            deliverableModel.setUpdateTime(new Date());
            projectDeliverableMapper.updateByIdSelective(deliverableModel);

        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode())){
            ProjectMilestoneDeliverableModel deliverableModel = new ProjectMilestoneDeliverableModel();
            deliverableModel.setId(model.getId());
            deliverableModel.setDelState(DeleteStatusEnum.DELETE.getStatus());
            deliverableModel.setUpdateId(user.getUserId());
            deliverableModel.setUpdateBy(user.getRealName());
            deliverableModel.setUpdateTime(new Date());
            milestoneDeliverableMapper.updateByIdSelective(deliverableModel);

        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.TASK_DELIVERABLE.getCode())){
            TaskDeliverProductModel taskDeliverProductModel = new TaskDeliverProductModel();
            taskDeliverProductModel.setDeliverProductId(model.getId());
            taskDeliverProductModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus().longValue());
            taskDeliverProductModel.setUpdateId(user.getUserId());
            taskDeliverProductModel.setUpdateBy(user.getRealName());
            taskDeliverProductModel.setUpdateTime(new Date());
            taskDeliverProductModelMapper.updateByPrimaryKeySelective(taskDeliverProductModel);
        }else {
            throw new SystemParamCheckException("参数传入错误");
        }
        return true;
    }
    /**
     * 获取项目交付物要求
     */
    public BasePageInfo<ProjectDeliverClaimVo> getDeliveryListByProjectId(BasePageInfo<ProjectDeliverClaimModel> model) {
        if (model == null || model.getModel().getProjectId() == null) {
            throw new SystemParamCheckException("项目交付信息传入参数异常，无法进行查询");
        }
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectDeliverClaimVo> list = this.projectDeliverClaimMapper.selectByModel(model.getModel());
        Set<Long> userIds = new HashSet<>();
        list.forEach(tmp -> {
            if (tmp.getLeader() != null) {
                userIds.add(tmp.getLeader());
            }
            if (tmp.getVerifyer() != null) {
                userIds.add(tmp.getVerifyer());
            }
            if (tmp.getDeliver() != null) {
                userIds.add(tmp.getDeliver());
            }
        });
        Map<Long, SysUserModel> map = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId
                        , sysUserModel -> sysUserModel));
        Map<Integer, String> deliverStatusMap = ProjectDeliverStatusEnum.getMap();
        Map<Integer, String> verifyStatusMap = ProjectApplyVerifyStatusEnum.getMap();
        list.forEach(tmp -> {
            tmp.setDeliverName(map.get(tmp.getDeliver()) == null ? null : map.get(tmp.getDeliver()).getRealName());
            tmp.setDeliverStatusName(deliverStatusMap.get(tmp.getDeliverStatus()));
            tmp.setLeaderName(map.get(tmp.getLeader()) == null ? null : map.get(tmp.getDeliver()).getRealName());
            tmp.setVerifyerName(map.get(tmp.getVerifyer()) == null ? null : map.get(tmp.getVerifyer()).getRealName());
            tmp.setVerifyerStatusName(verifyStatusMap.get(tmp.getVerifyerStatus()));
        });
        return new BasePageInfo<>(list);
    }

    /**
     * 交付物提交审核
     * @param model (交付物主键，类型)
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectDeliverableModel verifyDeliverable(ProjectDeliverableModel model){
        if (model.getId()==null || model.getDeliverableType()==null){
            throw new SystemParamCheckException("参数传入错误，操作失败");
        }
        if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            //判断是否满足提交条件
            if (!this.checkVerifyStatus(model)){
                throw new SystemParamCheckException("当前审批状态无法提交审批");
            }
            ProjectDeliverableModel deliverableModel = projectDeliverableMapper.selectById(model.getId());
            deliverableModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
            if (this.projectBusinessProjectDeliverableApplyImplService.createApplyInfo(deliverableModel)
                    && this.projectDeliverableMapper.updateByIdSelective(deliverableModel) >= 0) {

                return model;
            }
            throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.MILESTONE_DELIVERABLE.getCode())){
            ProjectMilestoneDeliverableModel deliverableModel = new ProjectMilestoneDeliverableModel();
            deliverableModel.setId(model.getId());
            try {
                projectMilestoneDeliverableService.verifyMilestoneDeliverable(deliverableModel);
            } catch (Exception e) {
                throw new SystemParamCheckException("提交审核错误，请重试！");
            }
        }else if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.TASK_DELIVERABLE.getCode())){
            TaskDeliverProductModel taskDeliverProductModel = new TaskDeliverProductModel();
            taskDeliverProductModel.setDeliverProductId(model.getId());
            try {
                taskDeliverProductService.verifyTaskDeliverable(taskDeliverProductModel);
            } catch (Exception e) {
                throw new SystemParamCheckException("提交审核错误，请重试！");
            }
        }else {
            throw new SystemParamCheckException("交付物类型参数传入错误");
        }
        return model;
    }
    private Boolean checkVerifyStatus(ProjectDeliverableModel model){
        if (Objects.equals(model.getDeliverableType(),DeliverableTypeEnum.PROJECT_DELIVERABLE.getCode())){
            ProjectDeliverableModel projectDeliverableModel = projectDeliverableMapper.selectById(model.getId());
            if (ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(projectDeliverableModel.getVerifyerStatus()==null?ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():projectDeliverableModel.getVerifyerStatus())){
                return true;
            }
        }
        return false;
    }
    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectDeliverableModel model) {
        return !(model == null || model.getId() == null) && this.projectDeliverableMapper.updateByIdSelective(model) == 1;
    }

    public ProjectDeliverableModel selectById(ProjectDeliverableModel model){
        ProjectDeliverableModel projectDeliverableModel = projectDeliverableMapper.selectById(model.getId());
        return projectDeliverableModel;
    }
    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
        List<ProjectDeliverableModel> projectDeliverableModels = projectDeliverableMapper.selectListByIds(ids);

        return projectDeliverableModels.stream().collect(Collectors.toMap(ProjectDeliverableModel::getId,
                ProjectDeliverableModel::getDeliverableName));
    }

}