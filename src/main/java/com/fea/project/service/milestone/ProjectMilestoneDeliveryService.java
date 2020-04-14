package com.fea.project.service.milestone;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.milestone.ProjectMilestoneDeliverableMapper;
import com.fea.project.dao.milestone.ProjectMilestoneDeliveryMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.milestone.DeliveryStatusEnum;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import com.fea.project.model.milestone.ProjectMilestoneDeliveryModel;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryInsertVo;
import com.fea.project.model.milestone.vo.ProjectMilestoneDeliveryVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.milestone.paramcheck.DeliveryParamCheckService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 * @date 2019/10/21
 * 项目里程碑交付物 Service
 */
@Service
public class ProjectMilestoneDeliveryService {

    @Resource
    private ProjectMilestoneDeliveryMapper projectMilestoneDeliveryMapper;
    @Autowired
    private SysUserService sysUserService;
    @Resource
    private ProjectMilestoneDeliverableMapper projectMilestoneDeliverableMapper;
    @Autowired
    private ProjectAppendixService projectAppendixService;
    @Autowired
    private DeliveryParamCheckService deliveryParamCheckService;
    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectMilestoneDeliveryMapper.deleteByIds(ids) > 0);
    }
    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectMilestoneDeliveryModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectMilestoneDeliveryModel> list : ListUtil.getSubList(models, 100)) {
                this.projectMilestoneDeliveryMapper.insertList(list);
            }
        } else {
            return this.projectMilestoneDeliveryMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertSelective(ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliveryModel> modelVo) {
        //存入创建人信息
        ProjectMilestoneDeliveryModel model = modelVo.getModel();
        if (model==null){
            throw new SystemParamCheckException("未传入数据，添加错误");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateTime(new Date());
        model.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
        boolean i = this.deliveryParamCheckService.insertModel(model);
        //更新对应附件信息
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
        if (i){
            return true;
        }
        throw new SystemParamCheckException(" 添加失败，请重试！");
    }

    /**
     * 按主键选择
     */
    public ProjectMilestoneDeliveryModel selectById(Long id) {
        return id == null ? null : this.projectMilestoneDeliveryMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectMilestoneDeliveryModel> selectByModel(ProjectMilestoneDeliveryModel model) {
        return model == null ? new ArrayList<>(0) : this.projectMilestoneDeliveryMapper.selectByModel(model);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean update(ProjectMilestoneDeliveryInsertVo<ProjectMilestoneDeliveryModel> modelVo) {
        ProjectMilestoneDeliveryModel model = modelVo.getModel();
        SysUserModel currentUsr = sysUserService.getCurrentUsr();

        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        boolean i = this.deliveryParamCheckService.updateModel(model);
        if (!i){
            throw new SystemParamCheckException("更新失败，请重试！");
        }
        //更新对应附件信息
        List<Long> appendixIds = modelVo.getAppendixs();
        for (Long appendixId : appendixIds){
            ProjectAppendixModel projectAppendixModel = ProjectAppendixModel.builder()
                    .id(appendixId)
                    .businessId(model.getId())
                    .build();
            boolean update = projectAppendixService.updateByIdSelective(projectAppendixModel);
            if (!update){
                throw new SystemParamCheckException("更新失败，请重试！");
            }
        }
        return true;
    }
    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectMilestoneDeliveryModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectMilestoneDeliveryMapper.updateByIdSelective(model) == 1;
    }
    /**
     * 按主键更新
     */
    public boolean updateById(ProjectMilestoneDeliveryModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectMilestoneDeliveryMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectMilestoneDeliveryModel model) {
        //更新删除状态
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        model.setDelState(DeleteStatusEnum.DELETE.getStatus());
        return !(model == null || model.getId() == null) && this.projectMilestoneDeliveryMapper.updateByIdSelective(model) >= 0;
    }
    /**
     * 获取交付要求详情列表
     *
     */
    public List<ProjectMilestoneDeliveryVo> selectByMilestoneId(Long milestoneId){
        List<ProjectMilestoneDeliveryVo> projectMilestoneDeliveryVos = projectMilestoneDeliveryMapper.selectByMilestoneId(milestoneId);

        List<Long> Ids =
                projectMilestoneDeliveryVos.stream().map(ProjectMilestoneDeliveryVo::getVerifyer).collect(Collectors.toList());
        Map<Long, SysUserModel> userMap = this.sysUserService.selectBaseInfoByIds(Ids).stream()
                .collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
        projectMilestoneDeliveryVos.forEach( vo ->{
            if (vo.getVerifyer()!=null){
                vo.setVerifyerName(userMap.get(vo.getVerifyer()).getRealName()==null?"":userMap.get(vo.getVerifyer()).getRealName());
            }
            List<ProjectMilestoneDeliverableModel> deliverableModelList =
                    projectMilestoneDeliverableMapper.selectByModel(new ProjectMilestoneDeliverableModel(vo.getId()));
            if (!deliverableModelList.isEmpty() || deliverableModelList.size()>0){
                vo.setVerifyer(deliverableModelList.get(0).getVerifyer());
                vo.setVerifyerStatus(deliverableModelList.get(0).getVerifyerStatus());
                vo.setVerifyerTime(deliverableModelList.get(0).getVerifyerTime());
                vo.setDeliveryStatus(deliverableModelList.get(0).getDeliverStatus());
            }else {
                vo.setDeliveryStatus(DeliveryStatusEnum.NO_DELIVERY.getCode());
            }
            vo.setDeliveryStatusString(DeliveryStatusEnum.queryText(vo.getDeliveryStatus()));
            vo.setVerifyerStatusString(ProjectApplyVerifyStatusEnum.getMap().get(vo.getVerifyerStatus()));
            vo.setAppendixList(projectAppendixService.selectIdAndNameByBusiness(vo.getId()));
        });
        return projectMilestoneDeliveryVos;
    }
}