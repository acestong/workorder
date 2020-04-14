package com.fea.project.service.milestone;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.milestone.ProjectMilestoneDeliverableMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.milestone.MilestoneCodeConfigEnum;
import com.fea.project.enums.milestone.DeliveryStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliverableVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryInsertVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.apply.ProjectApplyService;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessMilestoneDeliverableApplyImplService;
import com.fea.project.service.milestone.paramcheck.DeliverableParamCheckService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 * @date 2019/10/22
 */
@Service
public class ProjectMilestoneDeliverableService implements IProjectApplyBusiness {

    @Resource
    private ProjectMilestoneDeliverableMapper projectMilestoneDeliverableMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectAppendixService projectAppendixService;
    @Autowired
    private MilestoneCodeconfigService milestoneCodeconfigService;
    @Autowired
    private ProjectBusinessMilestoneDeliverableApplyImplService milestoneDeliverableApplyImplService;
    @Autowired
    private ProjectApplyService projectApplyService;
    @Autowired
    private DeliverableParamCheckService deliverableParamCheckService;

    /**
     * 插入数据,新增
     */
    public boolean insert(ProjectMilestoneDeliverableModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //存入创建人信息
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateTime(new Date());
        model.setDeliverTime(new Date());
        model.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectMilestoneDeliverableMapper.insert(model) == 1;
    }
    /**
     * 插入数据,字段为空时不插入
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertSelective(ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliverableModel> modelVo) throws Exception{
        //存入创建人信息
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //编号
        String num=null;
        try {
            num = milestoneCodeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.MILESTONE_DELIVERABLE_NUMBER.getType());
        } catch (Exception e) {
            throw new SystemParamCheckException("编号生成错误，请重试");
        }
        ProjectMilestoneDeliverableModel model = modelVo.getModel();
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateTime(new Date());
        model.setDeliverTime(new Date());
        model.setDeliver(currentUsr.getUserId());
        model.setDeliverableNumber(num);
        //交付状态
        model.setDeliverStatus(DeliveryStatusEnum.IN_DELIVERING.getCode());
        model.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
        boolean i = this.deliverableParamCheckService.insertModel(model);
        if (!i){
            throw new SystemParamCheckException(" 添加失败，请重试！");
        }
        //更新附件表
        List<Long> appendixIds = modelVo.getAppendixs();
        for (Long appendixId : appendixIds){
            ProjectAppendixModel projectAppendixModel = ProjectAppendixModel.builder()
                    .id(appendixId)
                    .businessId(model.getId())
                    .build();
            boolean update = projectAppendixService.updateByIdSelective(projectAppendixModel);
            if (!update){
                throw new SystemParamCheckException(" 添加失败，请重试！");
            }
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectMilestoneDeliverableModel selectById(Long id) {
        return id == null ? null : this.projectMilestoneDeliverableMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public BasePageInfo<ProjectMilestoneDeliverableVo> selectByModel(BasePageInfo<ProjectMilestoneDeliverableModel> model) {
        //根据里程碑id查询
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectMilestoneDeliverableVo> projectMilestoneDeliverableModels =
                this.projectMilestoneDeliverableMapper.selectDeliverableVoByModel(model.getModel());

        List<Long> Ids =
                projectMilestoneDeliverableModels.stream().map(ProjectMilestoneDeliverableVo::getVerifyer).collect(Collectors.toList());
        Map<Long, SysUserModel> userMap = this.sysUserService.selectBaseInfoByIds(Ids).stream()
                .collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));

        projectMilestoneDeliverableModels.forEach(pmd->{
            //查询流程审核信息
            List<ProjectApplyModel> projectApplyModels = projectApplyService.selectByModel(new ProjectApplyModel(pmd.getId()));
            if (!projectApplyModels.isEmpty()){
                //projectApplyService.selectOne(projectApplyModels)
            }
            pmd.setDeliverStatusString(DeliveryStatusEnum.queryText(pmd.getDeliverStatus()));
            pmd.setVerifyerStatusString(ProjectApplyVerifyStatusEnum.getMap().get(pmd.getVerifyerStatus()==null? 1 :
                    pmd.getVerifyerStatus()));
            pmd.setVerifyerName(userMap.get(pmd.getVerifyer())==null?"":userMap.get(pmd.getVerifyer()).getRealName());
            pmd.setAppendixList(projectAppendixService.selectIdAndNameByBusiness(pmd.getId()));
        });
        return new BasePageInfo<>(projectMilestoneDeliverableModels);
    }
    public boolean update(ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliverableModel> modelVo) {
        //先更新实体
        if (modelVo == null || modelVo.getModel().getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectMilestoneDeliverableModel model = modelVo.getModel();
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        boolean i = this.deliverableParamCheckService.updateModel(model);
        if (!i){
            throw new SystemParamCheckException(" 添加失败，请重试！");
        }
        //更新附件表
        List<Long> appendixIds = modelVo.getAppendixs();
        for (Long appendixId : appendixIds){
            ProjectAppendixModel projectAppendixModel = ProjectAppendixModel.builder()
                    .id(appendixId)
                    .businessId(model.getId())
                    .build();
            boolean update = projectAppendixService.updateByIdSelective(projectAppendixModel);
            if (!update){
                throw new SystemParamCheckException(" 添加失败，请重试！");
            }
        }
        return true;
    }
    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectMilestoneDeliverableModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectMilestoneDeliverableMapper.updateByIdSelective(model) == 1;
    }
    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectMilestoneDeliverableModel model) {
        //更新删除状态
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        model.setDelState(DeleteStatusEnum.DELETE.getStatus());
        return !(model == null || model.getId() == null) && this.projectMilestoneDeliverableMapper.updateByIdSelective(model) >= 0;
    }
    /**
     * 获取里程碑交付物编号
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectMilestoneDeliverableModel getDeliverableNum(ProjectMilestoneDeliverableModel model){
        //生成编号
        String num=null;
        try {
            num = milestoneCodeconfigService.getAutoCodeNum(MilestoneCodeConfigEnum.MILESTONE_DELIVERABLE_NUMBER.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.setDeliverableNumber(num);
        return model;
    }

    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {

        List<ProjectMilestoneDeliverableModel> list = projectMilestoneDeliverableMapper.selectListByIds(ids);

        return list.stream().collect(Collectors.toMap(ProjectMilestoneDeliverableModel::getId,
                ProjectMilestoneDeliverableModel::getDeliverableName));
    }
    /**
     * 获取交付物列表
     */
    public List<ProjectMilestoneDeliverableModel> getMilestoneDeliverableModels(List<Long> ids){
        return projectMilestoneDeliverableMapper.selectListByIds(ids);
    }
    /**
     * 里程碑交付物审批
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectMilestoneDeliverableModel verifyMilestoneDeliverable(ProjectMilestoneDeliverableModel model){
        ProjectMilestoneDeliverableModel deliverableModel = projectMilestoneDeliverableMapper.selectById(model.getId());
        //判断审批状态是否满足
        if (!ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(deliverableModel.getVerifyerStatus()==null?
                ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():deliverableModel.getVerifyerStatus())){
            throw new SystemParamCheckException("当前状态无法再次提交审批");
        }
        deliverableModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
        if (this.milestoneDeliverableApplyImplService.createApplyInfo(deliverableModel)
                && this.projectMilestoneDeliverableMapper.updateByIdSelective(deliverableModel) >= 0) {
            return deliverableModel;
        }
        throw new SystemParamCheckException("项目提交审核异常，无法进行提交");
    }
}