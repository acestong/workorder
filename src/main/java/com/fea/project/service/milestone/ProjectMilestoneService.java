package com.fea.project.service.milestone;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigMilestoneMapper;
import com.fea.project.dao.milestone.ProjectMilestoneMapper;
import com.fea.project.dao.project.ProjectStepMapper;
import com.fea.project.dao.task.TaskModelMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.milestone.ChangeStatusEnum;
import com.fea.project.enums.milestone.IsFinishEnum;
import com.fea.project.enums.milestone.IsWarnEnum;
import com.fea.project.enums.milestone.MilestoneCodeConfigEnum;
import com.fea.project.enums.plan.PlanCheckStatusEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.enums.task.CancelTaskStatusEnum;
import com.fea.project.enums.task.ProjectTaskStatusEnum;
import com.fea.project.enums.task.StopTaskStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.config.ProjectConfigMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneDeliveryModel;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import com.fea.project.model.milestone.vo.MilestoneRelateVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneInsertVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneVo;
import com.fea.project.model.milestone.vo.ProjectStepShowVo;
import com.fea.project.model.plan.vo.PlanAndSonPlanModelVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.vo.TaskAndSonTaskModelVo;
import com.fea.project.model.task.vo.TaskModelVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessMilestoneApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessMilestoneChangeApplyImplService;
import com.fea.project.service.milestone.paramcheck.MilestoneParamCheckService;
import com.fea.project.service.plan.IPlanService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.role.ProjectRoleService;
import com.fea.project.service.task.ITaskService;
import com.fea.project.service.team.ProjectTeamService;
import com.fea.project.service.util.DateCalculationDaysUtil;
import com.github.pagehelper.PageHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 * @date 2019/10/19
 * 项目里程碑 Service
 */
@Service
public class ProjectMilestoneService implements IProjectApplyBusiness {

    @Resource
    private ProjectMilestoneMapper projectMilestoneMapper;
    @Autowired
    private ProjectMilestoneDeliveryService projectMilestoneDeliveryService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectAppendixService projectAppendixService;
    @Autowired
    private MilestoneCodeconfigService milestoneCodeconfigService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRoleService projectRoleService;
    @Autowired
    private ITaskService taskService;
    @Resource
    private TaskModelMapper taskModelMapper;
    @Autowired
    private IPlanService planService;
    @Autowired
    private ProjectTeamService projectTeamService;
    @Resource
    private ProjectConfigMilestoneMapper projectConfigMilestoneMapper;
    @Resource
    private ProjectStepMapper projectStepMapper;
    @Autowired
    private ProjectMilestoneVerifyService milestoneVerifyService;
    @Autowired
    private MilestoneParamCheckService milestoneParamCheckService;
    /**
     * 工作流相关bean
     */
    @Autowired
    private ProjectBusinessMilestoneApplyImplService applyImplService;
    @Autowired
    private ProjectBusinessMilestoneChangeApplyImplService changeApplyImplService;
    /**
     * 新增数据
     */
    public ProjectMilestoneModel newProjectMilestone(ProjectMilestoneModel model){
        //生成里程碑编号
        String num=null;
        try {
            num = milestoneCodeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.MILESTONE_NUMBER.getType());
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemParamCheckException("编号生成错误，请重试！");
        }
        model.setNumber(num);
        return model;
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean insertMilestone(ProjectMilestoneInsertVo<ProjectMilestoneModel> modelVo) throws Exception{
        //先将里程碑主表信息添加
        if (modelVo==null || modelVo.getModel()==null){
            throw new SystemParamCheckException("参数不能为空！");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectMilestoneModel model = modelVo.getModel();
        //判断里程碑排序序号
        Integer integer = projectMilestoneMapper.maxSortCheck(model);
        if (integer==null){
            model.setSort(1);
        }else {
            model.setSort(integer+1);
        }
        //判断是否是排序为1
        if (model.getSort()>0 && model.getSort()==1){
            model.setIsFinish(IsFinishEnum.EXECUTING.getCode());
        }else if(model.getSort()>1) {
            model.setIsFinish(IsFinishEnum.NOT_BEGIN.getCode());
        }else {
            throw new SystemParamCheckException("里程碑排序序号格式不正确");
        }
        //创建人信息，组织id，版本，删除状态
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateTime(new Date());
        model.setRegId(currentUsr.getRegId());
        model.setOrgId(currentUsr.getOrgId());
        model.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue());
        //新增默认版本为v1.0
        model.setVersion(1);
        String num=null;
        try {
            num = milestoneCodeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.MILESTONE_NUMBER.getType());
        } catch (Exception e) {
            throw new SystemParamCheckException("编号生成错误，请重试！");
        }
        model.setNumber(num);
        boolean i = milestoneParamCheckService.insertModel(model);
        if (!i){
            throw new SystemParamCheckException("添加失败，请重试！");
        }
        //将里程碑id和交付要求关联
        Long milestoneId = model.getId();
        List<Long> deliveryIds = modelVo.getDeliveryIds();
        for (Long deliveryId : deliveryIds){
            ProjectMilestoneDeliveryModel deliveryModel = ProjectMilestoneDeliveryModel.builder()
                    .id(deliveryId)
                    .milestoneId(milestoneId)
                    .build();
            boolean b = projectMilestoneDeliveryService.updateByIdSelective(deliveryModel);
            if (!b){
                throw new SystemParamCheckException(" 添加失败，请重试！");
            }
        }
        //更新附件业务表
        List<Long> appendixIds = modelVo.getAppendixs();
        for (Long appendixId : appendixIds){
            ProjectAppendixModel projectAppendixModel = ProjectAppendixModel.builder()
                    .id(appendixId)
                    .businessId(milestoneId)
                    .build();
            boolean update = projectAppendixService.updateByIdSelective(projectAppendixModel);
            if (!update){
                throw new SystemParamCheckException(" 添加失败，请重试！");
            }
        }
        return true;
    }

    /**
    * 查询，筛选
    */
    public BasePageInfo<ProjectMilestoneVo> selectByFilterAndParams(BasePageInfo<ProjectMilestoneVo> model){
        if (model==null || model.getModel()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        if (Objects.equals(0L, model.getModel().getType())){
            //我负责的里程碑
            model.getModel().setType(null);
            model.getModel().setOwnerId(sysUserService.getCurrentUsr().getUserId());
        }
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectMilestoneVo> projectMilestones = projectMilestoneMapper.selectByFilterAndParams(model);
        //处理展示数据，预警状态，完成度%等
        for (int i=0;i<projectMilestones.size();i++){
            //第一个里程碑开始时间
            projectMilestones.get(0).setStartTime(projectMilestones.get(0).getCreateTime());
            if (IsFinishEnum.FINISH.getCode().equals(projectMilestones.get(i).getIsFinish())){
                //已完成情况
                projectMilestones.get(i).setPmgressbar("100%");
                //完成时间
                Date finishTime =projectMilestones.get(i).getFinishTime();
                //计划结束时间
                Date endTime = projectMilestones.get(i).getEndTime();
                //相差的天数
                long days = DateCalculationDaysUtil.getCalculationDays(endTime,finishTime);
                if (days>0){
                    //超期
                    projectMilestones.get(i).setIsWarn(IsWarnEnum.OVER_TIME.getCode());
                    projectMilestones.get(i).setWarnStatus("超期"+days+"天完成");
                }else if(days==0){
                    //准时
                    projectMilestones.get(i).setIsWarn(IsWarnEnum.NORMAL.getCode());
                    projectMilestones.get(i).setWarnStatus("准时完成");
                }else {
                    //提前
                    projectMilestones.get(i).setIsWarn(IsWarnEnum.AHEAD_TIME.getCode());
                    projectMilestones.get(i).setWarnStatus("提前"+(-days)+"天完成");
                }
            }else if (IsFinishEnum.EXECUTING.getCode().equals(projectMilestones.get(i).getIsFinish())) {
                //计划结束时间
                Date endTime = projectMilestones.get(i).getEndTime();
                //当前时间
                Date dateTime = new Date();
                //相差的天数
                long days = DateCalculationDaysUtil.getCalculationDays(endTime,dateTime);
                if (days>0){
                    //超期
                    //projectMilestones.get(i).setIsWarn(IsWarnEnum.OVER_TIME.getCode());
                    //projectMilestones.get(i).setWarnStatus("已超期"+days+"天");
                }else {

                }
                projectMilestones.get(i).setIsWarn(IsWarnEnum.EXECUTING.getCode());
                //查询任务数量及其完成数量计算完成进度
                String pmgressbar = computeMilestonePmgressbarById(projectMilestones.get(i).getProjectId(),
                        projectMilestones.get(i).getId());
                projectMilestones.get(i).setPmgressbar(pmgressbar);
            }
            projectMilestones.get(i).setStatusString(ProjectApplyVerifyStatusEnum.getMap().get(projectMilestones.get(i).getStatus()));
            projectMilestones.get(i).setIsFinishStr(IsFinishEnum.queryText(projectMilestones.get(i).getIsFinish()));

        }
        return new BasePageInfo<>(projectMilestones);
    }
    /**
     *里程碑详情
     */
    public ProjectMilestoneVo getProjectMilestoneModel(ProjectMilestoneModel model){
        if (model.getId()==null){
            throw new SystemParamCheckException("未传入id，查询失败");
        }
        ProjectMilestoneModel projectMilestoneModel = projectMilestoneMapper.selectById(model.getId());
        ProjectModel projectModel = projectService.selectById(projectMilestoneModel.getProjectId());
        if (projectMilestoneModel==null){
            throw new SystemParamCheckException("未查询到相应数据！");
        }
        String s = JSON.toJSONString(projectMilestoneModel);
        ProjectMilestoneVo projectMilestoneVo = JSON.parseObject(s, ProjectMilestoneVo.class);
        projectMilestoneVo.setProjectName(projectModel.getName());
        if (IsFinishEnum.FINISH.getCode().equals(projectMilestoneVo.getIsFinish())){
            //已完成情况
            projectMilestoneVo.setPmgressbar("100%");
            //完成时间
            Date finishTime = projectMilestoneVo.getFinishTime();
            //计划结束时间
            Date endTime = projectMilestoneVo.getEndTime();
            //相差的天数
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,finishTime);
            if (days>0){
                //超期
                projectMilestoneVo.setWarnStatus("超期"+days+"天完成");
            }else if(days==0){
                //准时
                projectMilestoneVo.setWarnStatus("准时完成");
            }else {
                //提前
                projectMilestoneVo.setWarnStatus("提前"+(-days)+"天完成");
            }
        }else if (IsFinishEnum.EXECUTING.getCode().equals(projectMilestoneVo.getIsFinish())){
            //未完成情况
            //计划结束时间
            Date endTime = projectMilestoneVo.getEndTime();
            //当前时间
            Date dateTime = new Date();
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,dateTime);
            if (days>0){
                //超期
                projectMilestoneVo.setWarnStatus("已超期"+days+"天");
            }else {
                //正常，准时
                projectMilestoneVo.setWarnStatus("正常");
            }
            //查询任务数量及其完成数量计算完成进度
            String pmgressbar = computeMilestonePmgressbarById(projectMilestoneModel.getProjectId(), model.getId());
            projectMilestoneVo.setPmgressbar(pmgressbar);
        }
        projectMilestoneVo.setStatusString(ProjectApplyVerifyStatusEnum.getMap().get(projectMilestoneVo.getStatus()));
        projectMilestoneVo.setIsFinishStr(IsFinishEnum.queryText(projectMilestoneVo.getIsFinish()));
        return projectMilestoneVo;
    }
    /**
    *  编辑
    */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(ProjectMilestoneInsertVo<ProjectMilestoneModel> modelVo){

        if (modelVo==null || modelVo.getModel().getId()==null){
            throw new SystemParamCheckException("未传入id，操作失败");
        }
        ProjectMilestoneModel model = modelVo.getModel();
        //已完成的里程碑不能编辑
        ProjectMilestoneModel projectMilestoneModel = projectMilestoneMapper.selectById(model.getId());
        if (Objects.equals(IsFinishEnum.FINISH,projectMilestoneModel.getIsFinish())){
            throw new SystemParamCheckException("里程碑已确认，操作失败");
        }
        //更新人信息
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        boolean updateModel = milestoneParamCheckService.updateModel(model);
        //将里程碑id和交付要求关联
        Long milestoneId = model.getId();
        List<Long> deliveryIds = modelVo.getDeliveryIds();
        if (!deliveryIds.isEmpty()) {
            for (Long deliveryId : deliveryIds) {
                ProjectMilestoneDeliveryModel deliveryModel = ProjectMilestoneDeliveryModel.builder()
                        .id(deliveryId)
                        .milestoneId(milestoneId)
                        .build();
                boolean b = projectMilestoneDeliveryService.updateByIdSelective(deliveryModel);
                if (!b) {
                    throw new SystemParamCheckException(" 操作失败，请重试！");
                }
            }
        }
        //更新附件业务表
        List<Long> appendixIds = modelVo.getAppendixs();
        if (!appendixIds.isEmpty()) {
            for (Long appendixId : appendixIds) {
                ProjectAppendixModel projectAppendixModel = ProjectAppendixModel.builder()
                        .id(appendixId)
                        .businessId(milestoneId)
                        .build();
                boolean update = projectAppendixService.updateByIdSelective(projectAppendixModel);
                if (!update) {
                    throw new SystemParamCheckException(" 操作失败，请重试！");
                }
            }
        }
        if (updateModel){
            return true;
        }
        return false;
    }
   /**
    *删除
    */
   @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(ProjectMilestoneModel model){
        if (model.getId()==null){
            throw new SystemParamCheckException("未传入id，删除失败");
        }
        //更新人信息
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
            model.setUpdateId(currentUsr.getUserId());
            model.setUpdateBy(currentUsr.getRealName());
            model.setUpdateTime(new Date());
            model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        int i = projectMilestoneMapper.updateByIdSelective(model);
        //删除后取消关联业务
        boolean b = this.cancelRelate(model.getId());

        if (i>=0){
            return true;
        }
        return false;
    }
    /**
     * 里程碑删除，关联业务取消关联
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelRelate(Long milestoneId){
        List<MilestoneRelateVo> planVos = this.selectPlanModelByMilestoneId(milestoneId);
        List<Long> planIds = planVos.stream().map(MilestoneRelateVo::getId).collect(Collectors.toList());
        if (!planIds.isEmpty() && planIds.size()>0){
            int i = planService.cancelMilestone(planIds);
            if (i!=planIds.size()){
                throw new SystemParamCheckException("更新失败，请重试");
            }
        }
        List<MilestoneRelateVo> taskVos = this.selectTaskModelByMilestoneId(milestoneId);
        List<Long> taskIds = taskVos.stream().map(MilestoneRelateVo::getId).collect(Collectors.toList());
        if (!taskIds.isEmpty() && taskIds.size()>0){
            int j = taskModelMapper.cancelMilestone(taskIds);
            if (j!=taskIds.size()){
                throw new SystemParamCheckException("更新失败，请重试");
            }
        }
        return true;
    }
    /**
     *确认完成
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean finishById(ProjectMilestoneModel model){
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("未传入id，操作失败");
        }
        //获取执行状态
        ProjectMilestoneModel projectMilestoneModel = projectMilestoneMapper.selectById(model.getId());
        //获取审核状态
        ProjectMilestoneVerifyModel verifyModel = milestoneVerifyService.selectByProjectId(projectMilestoneModel.getProjectId());
        if (verifyModel==null){
            throw new SystemParamCheckException("该里程碑不符合确认完成要求");
        }
        if (Objects.equals(IsFinishEnum.EXECUTING.getCode(),projectMilestoneModel.getIsFinish())
                &&Objects.equals(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue(),verifyModel.getVerifyStatus())){
            //必须是执行中且审核完成状态才能确认
            //确认人信息
            SysUserModel currentUsr = sysUserService.getCurrentUsr();
            model.setIsFinish(IsFinishEnum.FINISH.getCode());
            model.setNotarize(currentUsr.getRealName());
            model.setFinishTime(new Date());
            int i = projectMilestoneMapper.updateByIdSelective(model);
            //确认后将进入下一个里程碑
            List<ProjectMilestoneVo> list = projectMilestoneMapper.selectListByModel(new ProjectMilestoneModel(projectMilestoneModel.getProjectId()));
            int k=0;
            for(int j=0;j<list.size();j++){
                if (list.get(j).getId().equals(model.getId())){
                    k=j+1;
                }
            };
            if(k<list.size()&& k>0){
                ProjectMilestoneVo projectMilestoneVo = list.get(k);
                ProjectMilestoneModel lastMilestone = new ProjectMilestoneModel();
                lastMilestone.setId(projectMilestoneVo.getId());
                lastMilestone.setIsFinish(IsFinishEnum.EXECUTING.getCode());
                projectMilestoneMapper.updateByIdSelective(lastMilestone);
            }
            if (i>=0){
                return true;
            }
            throw new SystemParamCheckException("操作失败，请重试");
        }
        throw new SystemParamCheckException("该里程碑执行状态不符合确认完成要求");
    }

    /**
     *里程碑类型视图
     */
    public List<Map<String, Object>> milestoneTypeAndCountList(ProjectMilestoneModel model){

        ProjectConfigMilestoneModel configMilestoneModel = new ProjectConfigMilestoneModel();
        configMilestoneModel.setProjectId(model.getProjectId());
        configMilestoneModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        List<ProjectConfigMilestoneModel> projectConfigMilestoneModels = projectConfigMilestoneMapper.selectByModel(configMilestoneModel);
        //获取对应的里程碑数量,项目id，typeId
        List<Map<String, Object>> list = new ArrayList<>();
        projectConfigMilestoneModels.forEach( pcm ->{
            model.setType(pcm.getId());
            Integer integer = projectMilestoneMapper.selectMilestoneCountByType(model);
            list.add(new HashMap<String, Object>(){{
                         put("type",pcm.getId().toString());
                         put("name",pcm.getName());
                         put("count",integer);
                     }}
            );
        });
        //我负责的的里程碑,项目id，ownerId
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectMilestoneModel projectMilestoneModel = new ProjectMilestoneModel();
        projectMilestoneModel.setProjectId(model.getProjectId());
        projectMilestoneModel.setOwnerId(currentUsr.getUserId());
        Integer myCount = projectMilestoneMapper.selectMilestoneCountByType(projectMilestoneModel);
        list.add(new HashMap<String, Object>(){{
            put("type","0");
            put("name","我负责的里程碑");
            put("count",myCount);
        }});
        return list;
    }
    public List<Map<String, Object>> projectStepByProjectId(ProjectStepModel model){
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        List<ProjectStepVo> list = this.projectStepMapper.selectByModel(model);
        List<Map<String, Object>> finalList = new ArrayList<>();
        for (ProjectStepVo vo : list){
            finalList.add(new HashMap<String, Object>(){{
                put("projectStageId",vo.getId());
                put("projectStage",vo.getName());
            }});
        }
        return finalList;
    }
    public List<ProjectStepShowVo> projectStepListByProjectId(ProjectStepModel model){
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        List<ProjectStepShowVo> list = this.projectStepMapper.selectVoListByModel(model);
        if(!list.isEmpty()){
            //处理展示数据，预警状态，完成度%等
            int finishIndex=0;
            for(int i=0;i<list.size();i++){
                if (Objects.equals(ProjectStepStatusEnum.TYPE_FINISH.getValue(),list.get(i).getStepVerifyStatus())){
                    finishIndex=i;
                    list.get(i).setIsFinish(IsFinishEnum.FINISH.getCode());
                    //已确认完成情况
                    list.get(i).setPmgressbar("100%");
                    //完成时间
                    Date finishTime = list.get(i).getStepEndTime();
                    //计划结束时间
                    Date endTime = list.get(i).getEndTime();
                    //相差的天数
                    long days = DateCalculationDaysUtil.getCalculationDays(endTime,finishTime);
                    if (days>0){
                        //超期
                        list.get(i).setIsWarn(IsWarnEnum.OVER_TIME.getCode());
                        list.get(i).setWarnStatus("超期"+days+"天完成");
                    }else if(days==0){
                        //准时
                        list.get(i).setIsWarn(IsWarnEnum.NORMAL.getCode());
                        list.get(i).setWarnStatus("准时完成");
                    }else {
                        //提前
                        list.get(i).setIsWarn(IsWarnEnum.AHEAD_TIME.getCode());
                        list.get(i).setWarnStatus("提前"+(-days)+"天完成");
                    }
                }else if(Objects.equals(ProjectStepStatusEnum.TYPE_RUNNING.getValue(),list.get(i).getStepVerifyStatus())){
                    //计划开始时间
                    Date startTime = list.get(i).getStartTime();
                    //计划结束时间
                    Date endTime = list.get(i).getEndTime();
                    //当前时间
                    Date dateTime = new Date();
                    long days = DateCalculationDaysUtil.getCalculationDays(endTime,dateTime);
                    if (days>0){
                        //超期
                        //vo.setIsWarn(IsWarnEnum.OVER_TIME.getCode());
                        //vo.setWarnStatus("已超期"+days+"天");
                    }else {

                    }
                    list.get(i).setIsWarn(IsWarnEnum.EXECUTING.getCode());
                    //查询任务数量及其完成数量计算完成进度
                    String pmgressbar = computeStepPmgressbar(list.get(i).getProjectId(), list.get(i).getId());
                    list.get(i).setPmgressbar(pmgressbar);
                }else {
                    list.get(i).setIsFinish(IsFinishEnum.NOT_BEGIN.getCode());
                }
            }
            if(list.size()!=(finishIndex+1) && list.get(finishIndex+1)!=null){
                list.get(finishIndex+1).setIsFinish(IsFinishEnum.EXECUTING.getCode());
                list.get(finishIndex+1).setIsWarn(IsWarnEnum.EXECUTING.getCode());
                //查询任务数量及其完成数量计算完成进度
                String pmgressbar = computeStepPmgressbar(list.get(finishIndex+1).getProjectId(),
                        list.get(finishIndex+1).getId());
                list.get(finishIndex+1).setPmgressbar(pmgressbar);
            }
        }

        return list;
    }
    /**
     * 获取里程碑列表
     *
     */
    public BasePageInfo<ProjectMilestoneVo> selectByProjectId(BasePageInfo<ProjectMilestoneVo> model){

        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectMilestoneVo> projectMilestoneVos = projectMilestoneMapper.selectByFilterAndParams(model);
        projectMilestoneVos.forEach(vo ->{
           vo.setStatusString(ProjectApplyVerifyStatusEnum.getMap().get(vo.getStatus()));
           vo.setIsFinishStr(IsFinishEnum.queryText(vo.getIsFinish()));
        });
        return new BasePageInfo<>(projectMilestoneVos);
    }

    /**
     * 里程碑计算任务完成比例
     *
     */
    public String computeMilestonePmgressbarByTime(Long projectId, DateTime startTime, DateTime endTime){
        //根据起始时间获取期间的任务总数量和完成的任务数量，计算其完成的比例
        List<TaskAndSonTaskModelVo> taskAndSonTaskModelVos = taskModelMapper.selectTaskListByProjectId(projectId);
        int totalTask=0;
        int finishTask=0;
        String Pmgressbar=null;
        for (TaskAndSonTaskModelVo task : taskAndSonTaskModelVos){
            if (Objects.equals(task.getCancelTaskStatus(), CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus())
                    || Objects.equals(task.getStopTaskStatus(), StopTaskStatusEnum.NOT_STOP_TASK.getStatus())){
                if (startTime.toDate().before(task.getTaskStartTime()) && task.getTaskEndTime().before(endTime.toDate())){
                    if (task.getTaskProgrossRate() == 1){
                        //已完成的数量
                        finishTask+=1;
                    }
                    totalTask+=1;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0%");
        //可以设置精确几位小数
        df.setMaximumFractionDigits(2);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        if (totalTask>0){
            double rate= finishTask * 1.0/ totalTask * 1.0;
            Pmgressbar = df.format(rate);
        }else {
            Pmgressbar = "0%";
        }
        return Pmgressbar;
    }
    public String computeMilestonePmgressbarById(Long projectId, Long milestoneId){
        //根据起始时间获取期间的任务总数量和完成的任务数量，计算其完成的比例
        List<TaskAndSonTaskModelVo> taskAndSonTaskModelVos = taskModelMapper.selectTaskListByProjectId(projectId);
        int totalTask=0;
        int finishTask=0;
        String Pmgressbar=null;
        for (TaskAndSonTaskModelVo task : taskAndSonTaskModelVos){
            if (Objects.equals(task.getCancelTaskStatus(), CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus())
                    || Objects.equals(task.getStopTaskStatus(), StopTaskStatusEnum.NOT_STOP_TASK.getStatus())){
                if (Objects.equals(task.getMilestoneId(),milestoneId)){
                    if (task.getTaskProgrossRate() == 1){
                        //已完成的数量
                        finishTask+=1;
                    }
                    totalTask+=1;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0%");
        //可以设置精确几位小数
        df.setMaximumFractionDigits(2);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        if (totalTask>0){
            double rate= finishTask * 1.0/ totalTask * 1.0;
            Pmgressbar = df.format(rate);
        }else {
            Pmgressbar = "0%";
        }
        return Pmgressbar;
    }
    /**
     * 项目阶段计算任务完成比例
     */
    public String computeStepPmgressbar(Long projectId, Long stepId){
        //获取期间的任务总数量和完成的任务数量，计算其完成的比例
        int totalTask=0;
        int finishTask=0;
        String Pmgressbar=null;
        TaskModel taskModel = new TaskModel();
        taskModel.setProjectId(projectId);
        taskModel.setProjectStep(stepId);
        List<TaskModelVo> taskList = taskService.getTaskByProjectStepAndProjectId(taskModel);
        for(TaskModelVo task : taskList){
            if (Objects.equals(task.getCancelTaskStatus(), CancelTaskStatusEnum.NOT_CANCEL_TASK.getStatus())
                    || Objects.equals(task.getStopTaskStatus(), StopTaskStatusEnum.NOT_STOP_TASK.getStatus())){
                if (task.getTaskProgrossRate() == 1){
                    //已完成的数量（完成比例为1）
                    finishTask+=1;
                }
                totalTask+=1;
            }
        }
        DecimalFormat df = new DecimalFormat("0%");
        //可以设置精确几位小数
        df.setMaximumFractionDigits(2);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        if (totalTask>0){
            double rate= finishTask * 1.0/ totalTask * 1.0;
            Pmgressbar = df.format(rate);
        }else {
            Pmgressbar = "0%";
        }
        return Pmgressbar;
    }

    /**
     * 项目阶段详情
     */
    public ProjectStepShowVo getStepDetail(ProjectStepModel model){
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        ProjectStepShowVo projectStep = this.projectStepMapper.selectStepDetailVoById(model.getId());

        //处理枚举字段
        projectStep.setStepVerifyStatusName(ProjectStepStatusEnum.getMap().get(projectStep.getStepVerifyStatus()==null?0:projectStep.getStepVerifyStatus()));
        projectStep.setWarnStatus(stepWarnStatus(projectStep));
        if (Objects.equals(ProjectStepStatusEnum.TYPE_FINISH.getValue(),projectStep.getStepVerifyStatus())){
            projectStep.setPmgressbar("100%");
        }else {
            projectStep.setPmgressbar(computeStepPmgressbar(projectStep.getProjectId(), projectStep.getId()));
        }
        //负责人
        SysUserModel userModel = sysUserService.selectById(projectStep.getLeader());
        projectStep.setLeadName(userModel.getRealName());
        return projectStep;
    }
    /**
     * 里程碑预警状态
     *
     */
    public String milestoneWarnStatus(ProjectMilestoneVo vo) {

        String warnStatus = "";
        if (Objects.equals(IsFinishEnum.FINISH.getCode(), vo.getIsFinish())) {
            //已确认完成情况
            vo.setPmgressbar("100%");
            //完成时间
            Date finishTime = vo.getFinishTime();
            //计划结束时间
            Date endTime = vo.getEndTime();
            //相差的天数
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,finishTime);
            if (days > 0) {
                //超期
                vo.setIsWarn(IsWarnEnum.OVER_TIME.getCode());
                warnStatus = "超期" + days + "天完成";
            } else if (days == 0) {
                //准时
                vo.setIsWarn(IsWarnEnum.NORMAL.getCode());
                warnStatus = "准时完成";
            } else {
                //提前
                vo.setIsWarn(IsWarnEnum.AHEAD_TIME.getCode());
                warnStatus = "提前" + (-days) + "天完成";
            }
        } else if (IsFinishEnum.EXECUTING.getCode().equals(vo.getIsFinish())){
            //计划开始时间
            Date startTime = vo.getStartTime();
            //计划结束时间
            Date endTime = vo.getEndTime();
            //当前时间
            Date dateTime = new Date();
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,dateTime);
            if (days > 0) {
                //超期
                warnStatus = "已超期" + days + "天";
            } else {
                //正常，准时
                warnStatus = "正常";
            }
            vo.setIsWarn(IsWarnEnum.EXECUTING.getCode());
            //查询任务数量及其完成数量计算完成进度
            String pmgressbar = computeMilestonePmgressbarById(vo.getProjectId(),
                    vo.getId());
            vo.setPmgressbar(pmgressbar);
        }
        return warnStatus;
    }
    /**
     * 项目阶段预警状态
     *
     */
    public String stepWarnStatus(ProjectStepShowVo vo) {
        String warnStatus = "";
        if (Objects.equals(ProjectStepStatusEnum.TYPE_FINISH.getValue(), vo.getStepVerifyStatus())) {
            //已确认完成情况
            vo.setPmgressbar("100%");
            //完成时间
            Date finishTime = vo.getStepEndTime();
            //计划结束时间
            Date endTime = vo.getEndTime();
            //相差的天数
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,finishTime);
            if (days > 0) {
                //超期
                warnStatus = "超期" + days + "天完成";
            } else if (days == 0) {
                //准时
                warnStatus = "准时完成";
            } else {
                //提前
                warnStatus = "提前" + (-days) + "天完成";
            }
        } else if (Objects.equals(ProjectStepStatusEnum.TYPE_RUNNING.getValue(), vo.getStepVerifyStatus())){             //未完成情况
            //计划开始时间
            Date startTime = vo.getStartTime();
            //计划结束时间
            Date endTime = vo.getEndTime();
            //当前时间
            Date dateTime = new Date();
            long days = DateCalculationDaysUtil.getCalculationDays(endTime,dateTime);
            if (days > 0) {
                //超期
                warnStatus = "已超期" + days + "天";
            } else {
                //正常，准时
                warnStatus = "正常";
            }
        }
        return warnStatus;
    }

    /**
     * 里程碑关联计划
     */
    public List<MilestoneRelateVo> selectPlanModelByMilestoneId(Long milestoneId){
        List<MilestoneRelateVo> finalList = new ArrayList<>();
        List<PlanAndSonPlanModelVo> planAndSonPlanModelVos =planService.selectPlanModelByMilestoneId(milestoneId);
        if (planAndSonPlanModelVos.isEmpty()){
            return finalList;
        }
        Set<Long> userIds = new HashSet<>();
        planAndSonPlanModelVos.forEach(tmp -> {
            if (tmp.getPlanLeaderId() != null) {
                userIds.add(tmp.getPlanLeaderId());
            }
        });
        Map<Long, SysUserModel> map = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId
                        , sysUserModel -> sysUserModel));
        planAndSonPlanModelVos.forEach(vo -> {
            MilestoneRelateVo relateVo = new MilestoneRelateVo(vo);
            relateVo.setStatusStr(PlanCheckStatusEnum.getValue(vo.getCheckStatus().intValue()));
            if (0 == (vo.getLeaderIdOrTeamId()==null?0:vo.getLeaderIdOrTeamId())){
                relateVo.setLeaderId(vo.getPlanLeaderId());
                relateVo.setLeaderName(map.get(vo.getPlanLeaderId()).getRealName());
                relateVo.setLeaderTeamId(vo.getPlanTeamId());
                if (vo.getPlanTeamId()!=null){
                    relateVo.setLeaderTeamName(projectTeamService.selectById(vo.getPlanTeamId()).getName());
                }
            }else {
                relateVo.setTeamId(vo.getPlanTeamId());
                if (vo.getPlanTeamId()!=null) {
                    relateVo.setTeamName(projectTeamService.selectById(vo.getPlanTeamId()).getName());
                }
                relateVo.setTeamLeaderId(vo.getPlanLeaderId());
                relateVo.setTeamLeaderName(map.get(vo.getPlanLeaderId()).getRealName());
            }
            finalList.add(relateVo);
        });
        return finalList;
    }

    /**
     * 里程碑关联任务
     */
    public List<MilestoneRelateVo> selectTaskModelByMilestoneId(Long milestoneId) {
        List<MilestoneRelateVo> finalList = new ArrayList<>();
        List<TaskAndSonTaskModelVo> modelVos = taskModelMapper.selectTaskModelByMilestoneId(milestoneId);
        if (modelVos.isEmpty()){
            return finalList;
        }
        Set<Long> userIds = new HashSet<>();
        modelVos.forEach(tmp -> {
            if (tmp.getTaskLeaderId() != null) {
                userIds.add(tmp.getTaskLeaderId());
            }
        });
        Map<Long, SysUserModel> map = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId
                        , sysUserModel -> sysUserModel));
        modelVos.forEach(vo -> {
            MilestoneRelateVo relateVo = new MilestoneRelateVo(vo);
            //执行状态
            if (vo.getTaskProgrossRate()>=1){
                relateVo.setStatusStr(ProjectTaskStatusEnum.TYPE_FINISH.getText());
            }else if (vo.getTaskProgrossRate()<=0){
                relateVo.setStatusStr(ProjectTaskStatusEnum.TYPE_UNSTART.getText());
            }else {
                relateVo.setStatusStr(ProjectTaskStatusEnum.TYPE_RUNNING.getText());
            }

            if (0 == (vo.getLeaderIdOrTeamId()==null?0:vo.getLeaderIdOrTeamId())){
                relateVo.setLeaderId(vo.getTaskLeaderId());
                relateVo.setLeaderName(map.get(vo.getTaskLeaderId()).getRealName());
                relateVo.setLeaderTeamId(vo.getTaskTeamId());
                if (vo.getTaskTeamId()!=null) {
                    relateVo.setLeaderTeamName(projectTeamService.selectById(vo.getTaskTeamId()).getName());
                }
            }else {
                relateVo.setTeamId(vo.getTaskTeamId());
                if (vo.getTaskTeamId()!=null) {
                    relateVo.setTeamName(projectTeamService.selectById(vo.getTaskTeamId()).getName());
                }
                relateVo.setTeamLeaderId(vo.getTaskLeaderId());
                relateVo.setTeamLeaderName(map.get(vo.getTaskLeaderId()).getRealName());
            }
            finalList.add(relateVo);
        });
        return finalList;
    }

    /**
     * 里程碑提交审批
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectMilestoneVerifyModel verifyMilestone(ProjectMilestoneVerifyModel model) {
        if (model==null || model.getProjectId()==null || model.getName()==null){
            throw new SystemParamCheckException("参数传入错误，无法提交");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        //检查是否提交
        ProjectMilestoneVerifyModel verifyModel = milestoneVerifyService.selectByProjectId(model.getProjectId());
        if (verifyModel!=null){
            return this.verifyMilestoneChange(model);
        }else {
            verifyModel=new ProjectMilestoneVerifyModel();
            verifyModel.setProjectId(model.getProjectId());
            verifyModel.setName(model.getName());
            verifyModel.setRemark(model.getRemark());
            verifyModel.setApplyUserId(user.getUserId());
            verifyModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
            verifyModel.setVersion(1);
            verifyModel.setCreateId(user.getUserId());
            verifyModel.setCreateBy(user.getRealName());
            verifyModel.setCreateTime(new Date());

            boolean b = this.milestoneVerifyService.insertOrUpdate(verifyModel);

            if (b){
                if (this.applyImplService.createApplyInfo(verifyModel)) {
                    return verifyModel;
                }
            }
            throw new SystemParamCheckException("提交审核异常，无法进行提交");
        }
    }

    /**
     * 里程碑变更
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ProjectMilestoneVo> changeMilestone(ProjectMilestoneModel model) {
        //里程碑变更
        if (model.getProjectId()==null){
            throw new SystemParamCheckException("参数传入错误，无法进行操作");
        }
        List<ProjectMilestoneVo> list = null;
        try {
            ProjectMilestoneVerifyModel verifyModel = milestoneVerifyService.selectByProjectId(model.getProjectId());
            Integer version = verifyModel.getVersion();
            verifyModel.setVersion(version+1);
            verifyModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue());
            boolean b = milestoneVerifyService.insertOrUpdate(verifyModel);
            list = projectMilestoneMapper.selectListByModel(model);
            list.forEach(tmp -> {
                if (!Objects.equals(tmp.getIsFinish(),IsFinishEnum.FINISH.getCode())){
                    //已确认完成的不做变更,将里程碑存为变更草稿状态
                    tmp.setStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue());
                    tmp.setCode(ChangeStatusEnum.CHANGING.getCode());
                    tmp.setVersion(tmp.getVersion()+1);
                    ProjectMilestoneModel build = ProjectMilestoneModel.builder()
                            .id(tmp.getId())
                            .projectId(tmp.getProjectId())
                            .version(tmp.getVersion()+1)
                            .status(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue())
                            .code(ChangeStatusEnum.CHANGING.getCode())
                            .build();
                    int i = projectMilestoneMapper.updateByIdSelective(build);
                }
                tmp.setStatusString(ProjectApplyVerifyStatusEnum.getMap().get(tmp.getStatus()));
                tmp.setIsFinishStr(IsFinishEnum.queryText(tmp.getIsFinish()));
                String warnStatus = this.milestoneWarnStatus(tmp);
                tmp.setWarnStatus(warnStatus);
            });
        } catch (Exception e) {
            throw new SystemParamCheckException("数据更新报错，请重试");
        }
        return list;
    }

    /**
     * 里程碑变更提交审批
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectMilestoneVerifyModel verifyMilestoneChange(ProjectMilestoneVerifyModel model) {
        if (model==null || model.getProjectId()==null || model.getName()==null){
            throw new SystemParamCheckException("参数传入错误，无法提交");
        }
        //检查是否可以提交
        ProjectMilestoneVerifyModel verifyModel = milestoneVerifyService.selectByProjectId(model.getProjectId());
        if (verifyModel!=null){
            if (!ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(verifyModel.getVerifyStatus()==null?
                    ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():verifyModel.getVerifyStatus())){
                throw new SystemParamCheckException("当前审批状态无法提交审批");
            }else {
                SysUserModel user = sysUserService.getCurrentUsr();
                verifyModel.setName(model.getName());
                verifyModel.setRemark(model.getRemark());
                verifyModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
                verifyModel.setVersion(verifyModel.getVersion()+1);
                verifyModel.setApplyUserId(user.getUserId());
                verifyModel.setUpdateId(user.getUserId());
                verifyModel.setUpdateBy(user.getRealName());
                verifyModel.setUpdateTime(new Date());
                if (this.milestoneVerifyService.updateByIdSelective(verifyModel)
                        && this.changeApplyImplService.createApplyInfo(verifyModel)) {
                    return this.getProjectMilestoneInfo(model);
                }
            }
        }
        throw new SystemParamCheckException("提交审核异常，无法进行提交");
    }
    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
        List<ProjectMilestoneModel> list = projectMilestoneMapper.selectByModelIds(ids);
        return list.stream().collect(Collectors.toMap(ProjectMilestoneModel::getId,ProjectMilestoneModel::getName));
    }

    /**
     * 更新审核状态
     *
     */
    public boolean updateByIdSelective(ProjectMilestoneModel model) {
        return !(model == null || model.getId() == null) && this.projectMilestoneMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 获取项目里程碑信息
     */
    public ProjectMilestoneVerifyModel getProjectMilestoneInfo(ProjectMilestoneVerifyModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectMilestoneVerifyModel verifyModel = milestoneVerifyService.selectByProjectId(model.getProjectId());
        if (verifyModel==null){
            verifyModel=new ProjectMilestoneVerifyModel();
            verifyModel.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue());
        }
        verifyModel.setVerifyStatusStr(ProjectApplyVerifyStatusEnum.getMap().get(verifyModel.getVerifyStatus()));
        return verifyModel;
    }
}