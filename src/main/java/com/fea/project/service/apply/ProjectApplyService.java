package com.fea.project.service.apply;

import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.apply.ProjectApplyMapper;
import com.fea.project.enums.apply.ProjectApplyFlowStatusColorTypeEnum;
import com.fea.project.enums.apply.ProjectApplyVerifyActionStatusEnum;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectPersonTypeEnum;
import com.fea.project.enums.flow.base.ProjectSignTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.apply.pojo.ProjectApplyPojo;
import com.fea.project.model.apply.pojo.ProjectRevertShowPojo;
import com.fea.project.model.apply.vo.*;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.model.flow.vo.ProjectFlowVerifyerVo;
import com.fea.project.service.businessflow.ProjectBusinessFlowVerifyerService;
import com.fea.project.service.flow.ProjectFlowListService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.DateUtil;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/11/18.
 */
@Service
public class ProjectApplyService {

    @Autowired
    private ProjectApplyMapper projectApplyMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectApplyFlowInfoService projectApplyFlowInfoService;

    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFlowVerifyerService;

    @Autowired
    private ProjectFlowListService projectFlowListService;


    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyModel model) {
        return model != null && this.projectApplyMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectApplyModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyMapper.insertList(list);
            }
        } else {
            return this.projectApplyMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyModel model) {
        return model != null && this.projectApplyMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyModel selectById(Long id) {
        return id == null ? null : this.projectApplyMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyModel> selectByModel(ProjectApplyModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectApplyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyMapper.insert(model) == 1;
        }
        return this.projectApplyMapper.updateById(model) == 1;
    }

    public BasePageInfo<ProjectApplyVo> listByParam(BasePageInfo<ProjectApplyPojo> basePageInfo) {
        basePageInfo.getModel().setApplyerId(UserUtil.getUserId());
        basePageInfo.getModel().setCreateId(UserUtil.getUserId());
        String sortKey = basePageInfo.getSortKey();
        String sortValue = basePageInfo.getSortValue();
        //查询下属人员
        List<ProjectApplyVo> projectApplyVos = this.projectApplyMapper.selectApplysByUserIdAndNumber(UserUtil.getUserId(), basePageInfo.getPageNum(), sortKey, sortValue);
        basePageInfo.getModel().setIds(projectApplyVos.stream().map(ProjectApplyVo::getId).collect(Collectors.toList()));
        PageHelper.startPage(basePageInfo.getPageNum(), basePageInfo.getPageSize(), true);
        List<ProjectApplyVo> list = this.projectApplyMapper.selectByFilterAndOrderParams(basePageInfo);
        filterProjectApplyDetailParam(list);
        return new BasePageInfo<>(list);
    }


    /**
     * 流程查询基础数据补全
     *
     * @param list
     */
    private void filterProjectApplyDetailParam(List<ProjectApplyVo> list) {
        Set<Long> userIds = new HashSet<>();
        Set<Long> departIds = new HashSet<>();
        Map<Integer, Set<Long>> map = new HashMap<>();
        Set<Long> projectIds = new HashSet<>();
        list.forEach(x -> {
            ListUtil.addWithNull(userIds, x.getApplyerId());
            ListUtil.addWithNull(departIds, x.getApplyDepart());
            ListUtil.addWithNull(map.computeIfAbsent(x.getApplyType(), k -> new HashSet<>()), x.getBusinessId());
            ListUtil.addWithNull(projectIds, x.getProjectId());
        });
        //用户信息数据
        Map<Long, String> applyerMap = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        //申请部门数据
        Map<Long, String> departNameMap = this.sysDepartmentService.selectByIds(new ArrayList<>(departIds))
                .stream().collect(Collectors.toMap(SysDepartmentModel::getDEPID, SysDepartmentModel::getDEPNAME));
        //审批状态
        Map<Integer, String> verifyStatusMap = ProjectApplyVerifyStatusEnum.getMap();
        //业务名称
        Map<Long, String> businessNameMap = ProjectFlowTypeEnum.getNamesMap(map);
        Map<Long, String> projectNameMap = projectService.selectByIds(new ArrayList<>(projectIds));
        Date now = new Date();
        list.forEach(x -> {
            x.setApplyerName(applyerMap.get(x.getApplyerId()));
            x.setApplyDepartName(departNameMap.get(x.getApplyDepart()));
            x.setProjectName(projectNameMap.get(x.getProjectId()));
            x.setVerifyStatusName(verifyStatusMap.get(x.getVerifyStatus()));
            x.setBusinessName(businessNameMap.get(x.getBusinessId()));
            if (ProjectApplyVerifyStatusEnum.getRunningStatusList().contains(x.getVerifyStatus())) {
                x.setStopTime(DateUtil.getStopTime(x.getApplyTime(), now));
            }
            x.setApplyTypeName(ProjectFlowTypeEnum.getTargetMap(x.getApplyType()).getApplyName());
        });
    }


    public boolean insertProjectApplyInfo(ProjectApplyPojo applyModel) {
        if (applyModel == null) {
            return false;
        }
        ProjectApplyModel tmpModel = applyModel.createProjectApply();
        if (this.projectApplyMapper.insertSelective(tmpModel) >= 0
                && this.projectApplyFlowInfoService.insertList(applyModel.getProjectApplyFlowInfoModels(), tmpModel.getId())) {
            applyModel.setId(tmpModel.getId());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectApplyInfo(List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoPojos, Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id异常，无法进行流程数据插入");
        }
        if(projectApplyFlowInfoPojos.isEmpty()){
            return Boolean.TRUE;
        }
        if (this.projectApplyFlowInfoService.insertList(projectApplyFlowInfoPojos, applyId)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public ProjectApplyVo selectOne(ProjectApplyModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目申请id传入异常，无法进行查询");
        }
        ProjectApplyVo projectApplyVo = this.projectApplyMapper.selectOne(model.getId());
        filterProjectApplyDetailParam(Stream.of(projectApplyVo).collect(Collectors.toList()));
        List<ProjectApplyFlowInfoVo> projectApplyFlowInfoModels = projectApplyFlowInfoService.selectByApplyId(projectApplyVo.getId());
        List<ProjectApplyFlowVerifyerActionVo> projectApplyFlowVerifyerActionVos = new ArrayList<>();
        //翻译对应字段信息
        Set<Long> userIds = new HashSet<>();
        Date now = new Date();
        List<ProjectApplyFlowInfoVo> waitingActionModels = new ArrayList<>();
        projectApplyFlowInfoModels.forEach(x -> {
            List<ProjectApplyFlowVerifyVo> projectApplyFlowVerifyModels = x.getProjectApplyFlowVerifyModels();
            if (ListUtil.isNullOrEmpty(projectApplyFlowVerifyModels)) {
                return;
            }
            projectApplyFlowVerifyModels.forEach(y -> userIds.add(y.getVerifyerId()));
            projectApplyFlowVerifyerActionVos.addAll(ProjectApplyFlowVerifyerActionVo.createList(x, now));
            if (Objects.isNull(x.getActionTime())) {
                waitingActionModels.add(x);
            }
        });
        setProjectApplyActionStatus(projectApplyVo, waitingActionModels);
        Map<Long, String> userNameMap = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        Map<Integer, String> personTypeMap = ProjectPersonTypeEnum.getPersonTypeNames();
        Map<Integer, String> verifyTypeMap = ProjectSignTypeEnum.getVerifyTypeNames();
        Map<Integer, String> verifyStatusMap = ProjectApplyVerifyStatusEnum.getMap();
        Map<Integer, String> actionTypeMap = ProjectApplyVerifyActionStatusEnum.getMap();
        projectApplyFlowVerifyerActionVos.forEach(x -> {
            x.setPersonTypeName(personTypeMap.get(x.getPersonType()));
            x.setVerifyTypeName(verifyTypeMap.get(x.getVerifyType()));
            x.setVerifyStatusName(verifyStatusMap.get(x.getVerifyStatus()));
            x.setVerifyerName(userNameMap.get(x.getVerifyerId()));
            x.setActionTypeName(actionTypeMap.get(x.getActionType()));
            x.getChildren().forEach(y -> {
                y.setPersonTypeName(personTypeMap.get(y.getPersonType()));
                y.setVerifyTypeName(verifyTypeMap.get(y.getVerifyType()));
                y.setVerifyStatusName(verifyStatusMap.get(y.getVerifyStatus()));
                y.setVerifyerName(userNameMap.get(y.getVerifyerId()));
                y.setActionTypeName(actionTypeMap.get(y.getActionType()));
            });
        });
        projectApplyVo.setProjectApplyFlowVerifyerActionModels(projectApplyFlowVerifyerActionVos);
        return projectApplyVo;
    }

    /**
     * 根据当前人id确认当前人所拥有的按钮权限
     *
     * @param projectApplyVo
     * @param waitingActionModels
     */
    private void setProjectApplyActionStatus(ProjectApplyVo projectApplyVo, List<ProjectApplyFlowInfoVo> waitingActionModels) {
        Long applerId = projectApplyVo.getApplyerId();
        if (waitingActionModels.size() > 1 || (waitingActionModels.size() == 1 && waitingActionModels.get(0).getProjectApplyFlowVerifyModels().isEmpty())) {
            throw new SystemParamCheckException("流程状态异常，出现了多个节点未审核的状态,或是待审核节点下不存在审核人");
        } else if (waitingActionModels.size() == 0) {
            projectApplyVo.setIsRevert(Boolean.FALSE);
            projectApplyVo.setIsVerify(Boolean.FALSE);
        } else {
            List<Long> actionUserIds = new ArrayList<>();
            Map<Long, Boolean> needVerify = new HashMap<>();
            waitingActionModels.get(0).getProjectApplyFlowVerifyModels().forEach(x -> {
                actionUserIds.add(x.getVerifyerId());
                needVerify.put(x.getVerifyerId(), Objects.isNull(x.getActionTime()) ? Boolean.TRUE : Boolean.FALSE);
            });
            projectApplyVo.setIsRevert(UserUtil.getUserId().equals(applerId));
            projectApplyVo.setIsVerify(actionUserIds.contains(UserUtil.getUserId()) && Objects.equals(Boolean.TRUE, needVerify.get(UserUtil.getUserId())) ? Boolean.TRUE : Boolean.FALSE);
        }
    }

    public List<ProjectRevertShowPojo> selectCanRevertStep(ProjectApplyModel projectApplyModel) {
        if (projectApplyModel == null || projectApplyModel.getId() == null) {
            throw new SystemParamCheckException("传入的参数异常，可驳回流程顺序查询异常");
        }
        projectApplyModel = this.projectApplyMapper.selectById(projectApplyModel.getId());
        List<ProjectApplyFlowInfoVo> projectApplyFlowInfoVos = this.projectApplyFlowInfoService.selectCanRevertStep(projectApplyModel.getId());
        List<ProjectApplyFlowInfoVo> finalList = this.filterUsefulRollBackStep(projectApplyFlowInfoVos);
        Map<Long, List<Long>> userMap = finalList.stream().collect(Collectors.toMap(ProjectApplyFlowInfoVo::getId,
                x -> x.getProjectApplyFlowVerifyModels().stream().filter(y -> !Objects.isNull(y.getActionTime()))
                        .map(ProjectApplyFlowVerifyModel::getVerifyerId).collect(Collectors.toList())));
        Map<Long, String> userNameMap = sysUserService.selectByIds(userMap.entrySet().stream().flatMap(x -> x.getValue().stream()).distinct().collect(Collectors.toList()))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId, SysUserModel::getRealName));
        return projectApplyFlowInfoVos.stream().map(x -> new ProjectRevertShowPojo(x, userNameMap)).collect(Collectors.toList());
    }

    private List<ProjectApplyFlowInfoVo> filterUsefulRollBackStep(List<ProjectApplyFlowInfoVo> projectApplyFlowInfoVos) {
        List<ProjectApplyFlowInfoVo> finalList = new ArrayList<>();
        Map<Long, ProjectApplyFlowInfoVo> map = new HashMap<>();
        for (ProjectApplyFlowInfoVo projectApplyFlowInfoVo : projectApplyFlowInfoVos) {
            ProjectApplyFlowInfoVo tmpModel = map.get(projectApplyFlowInfoVo.getBusinessFlowVerifyId());
            int index = finalList.indexOf(tmpModel);
            if (tmpModel != null && index >= 0) {
                finalList = finalList.subList(0, index);
            }
            finalList.add(projectApplyFlowInfoVo);
            map.put(projectApplyFlowInfoVo.getBusinessFlowVerifyId(), projectApplyFlowInfoVo);
        }
        return finalList;
    }


    public List<ProjectApplyFlowVerifyPictureShowVo> selectApplyFlowStatus(ProjectApplyModel projectApplyModel) {
        if (Objects.isNull(projectApplyModel) || Objects.isNull(projectApplyModel.getId())) {
            throw new SystemParamCheckException("传入的申请流程参数异常，无法进行查询");
        }
        projectApplyModel = this.projectApplyMapper.selectById(projectApplyModel.getId());
        List<ProjectApplyFlowInfoVo> projectApplyFlowInfoVos = this.projectApplyFlowInfoService.selectVerifyedModelsByApplyId(projectApplyModel.getId());
        List<ProjectApplyFlowInfoVo> usefulList = this.currentFlowStatusMap(projectApplyFlowInfoVos);
        List<ProjectBusinessFlowVerifyerModel> projectBusinessFlowVerifyerModels = this.projectBusinessFlowVerifyerService.selectByProjectBusinessFlowId(projectApplyModel.getBusinessFlowId());
        Map<Long, ProjectFlowVerifyerVo> projectFlowVerifyerModelMap = projectBusinessFlowVerifyerModels.stream()
                .collect(Collectors.toMap(ProjectBusinessFlowVerifyerModel::getId, ProjectFlowVerifyerVo::new));
        List<ProjectFlowVerifyerVo> projectFlowVerifyerModels = new ArrayList<>(projectFlowVerifyerModelMap.values());
        projectFlowListService.fillVerifyInfo(new ArrayList<>(projectFlowVerifyerModels));
        Map<Long, ProjectApplyFlowVerifyPictureShowVo> map = new LinkedHashMap<>();
        projectFlowVerifyerModelMap.forEach((key, value) -> map.put(key, new ProjectApplyFlowVerifyPictureShowVo(value)));
        List<Long> flowInfoIds = new ArrayList<>();
        List<ProjectApplyFlowVerifyPictureShowVo> tmpList = new ArrayList<>();
        usefulList.forEach(x -> {
            ProjectApplyFlowVerifyPictureShowVo tmpModel = map.get(x.getBusinessFlowVerifyId());
            if (usefulList.indexOf(x) < usefulList.size() - 1 && flowInfoIds.contains(x.getBusinessFlowVerifyId())) {
                throw new SystemParamCheckException("有效流程过滤数据异常");
            }
            if (usefulList.indexOf(x) == usefulList.size() - 1 && flowInfoIds.contains(x.getBusinessFlowVerifyId())) {
                tmpList.get(tmpList.size() - 1).setBeatBack(flowInfoIds.size() - 1 - flowInfoIds.indexOf(x.getBusinessFlowVerifyId()));
                map.get(x.getBusinessFlowVerifyId()).setFlowStatus(ProjectApplyVerifyStatusEnum.getTargetEnum(x.getVerifyStatus()).getColorStatusType());
                return;
            }
            tmpModel.setFlowStatus(ProjectApplyVerifyStatusEnum.getTargetEnum(x.getVerifyStatus()).getColorStatusType());
            flowInfoIds.add(x.getBusinessFlowVerifyId());
            tmpList.add(tmpModel);
        });
        List<ProjectApplyFlowVerifyPictureShowVo> list = new ArrayList<>(map.values());
        list.forEach(x -> {
            if (x.getFlowStatus() == null) {
                x.setFlowStatus(ProjectApplyFlowStatusColorTypeEnum.TYPE_WAITING_ACTION.getValue());
            }
        });
        return orderVerifyer(list);
    }

    private List<ProjectApplyFlowVerifyPictureShowVo> orderVerifyer(List<ProjectApplyFlowVerifyPictureShowVo> list) {
        Map<Long, ProjectApplyFlowVerifyPictureShowVo> finalMap  = new HashMap<>(list.size());
        List<ProjectApplyFlowVerifyPictureShowVo> finalList = new ArrayList<>();
        list.forEach(x -> {
            if(x.getParentId() == null){
                if(!finalList.isEmpty()){
                    throw new SystemParamCheckException("流程数据定义异常");
                }
                finalList.add(x);
                return;
            }
            finalMap.put(x.getParentId(), x);
        });
        ProjectApplyFlowVerifyPictureShowVo tmpModel = finalList.get(0);
        while(finalMap.get(tmpModel.getId()) != null){
            tmpModel = finalMap.get(tmpModel.getId());
            finalList.add(tmpModel);
        }
        return finalList;
    }

    /**
     * 获取流程流程状态数据，移除无用的打回显示
     *
     * @param projectApplyFlowInfoVos
     * @return
     */
    private List<ProjectApplyFlowInfoVo> currentFlowStatusMap(List<ProjectApplyFlowInfoVo> projectApplyFlowInfoVos) {
        Map<Long, ProjectApplyFlowInfoVo> map = new LinkedHashMap<>();
        for (int i = 0; i < projectApplyFlowInfoVos.size(); i++) {
            if (map.containsKey(projectApplyFlowInfoVos.get(i).getBusinessFlowVerifyId()) &&
                    i != projectApplyFlowInfoVos.size() - 1) {
                Map<Long, ProjectApplyFlowInfoVo> tmpMap = new HashMap<>();
                for (Map.Entry<Long, ProjectApplyFlowInfoVo> currentMap : map.entrySet()) {
                    if (Objects.equals(currentMap.getKey(), projectApplyFlowInfoVos.get(i).getBusinessFlowVerifyId())) {
                        map = tmpMap;
                        break;
                    }
                    tmpMap.put(currentMap.getKey(), currentMap.getValue());
                }
            } else if (map.containsKey(projectApplyFlowInfoVos.get(i).getBusinessFlowVerifyId()) &&
                    i == projectApplyFlowInfoVos.size() - 1) {
                List<ProjectApplyFlowInfoVo> list = new ArrayList<>(map.values());
                list.add(projectApplyFlowInfoVos.get(i));
                return list;
            }
            map.put(projectApplyFlowInfoVos.get(i).getBusinessFlowVerifyId(), projectApplyFlowInfoVos.get(i));
        }
        return new ArrayList<>(map.values());
    }

    public List<ProjectApplyModel> selectRunningFlowByProjectIdAndApplyType(Long projectId, Integer applyType) {
        if(projectId == null || applyType == null){
            throw new SystemParamCheckException("参数传入异常");
        }
        return this.projectApplyMapper.selectRunningFlowByProjectIdAndApplyType(projectId, applyType);
    }

    public boolean updateVerifyStatusById(Long id, Integer verifyStatus) {
        if(id == null || verifyStatus == null){
            throw new SystemParamCheckException("传入参数异常，无法进行审核");
        }
        return this.projectApplyMapper.updateVerifyStatusById(id, verifyStatus) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateVerifyStatusByBusinessIdAndVerifyStatus(Integer newStatus, Long businessId, Integer oldStatus) {
        if(newStatus == null || businessId == null || oldStatus == null){
            throw new SystemParamCheckException("流程变更异常，无法进行更新");
        }
        return this.projectApplyMapper.updateVerifyStatusByBusinessIdAndVerifyStatus(newStatus, businessId, oldStatus) >= 0;
    }

    public BasePageInfo<ProjectApplyVo> listNeedVerifyByParam(BasePageInfo<ProjectApplyPojo> basePageInfo) {
        basePageInfo.getModel().setVerifyerId(UserUtil.getUserId());
        PageHelper.startPage(basePageInfo.getPageNum(), basePageInfo.getPageSize(), true);
        List<ProjectApplyVo> list = this.projectApplyMapper.selecNeedVerifytByFilterAndOrderParams(basePageInfo);
        filterProjectApplyDetailParam(list);
        return new BasePageInfo<>(list);
    }

    public ProjectApplyVo selectByBusinessIdAndApplyTypes(Long business, List<Integer> applyTypes) {
        if(business == null || ListUtil.isNullOrEmpty(applyTypes)){
            throw new SystemParamCheckException("传入的参数异常");
        }
        ProjectApplyVo model = this.projectApplyMapper.selectByBusinessIdAndApplyTypes(business, applyTypes);
        if(model == null){
            return null;
        }
        SysUserModel sysUserModel = this.sysUserService.selectById(model.getApplyerId());
        model.setApplyerName(sysUserModel.getRealName());
        model.setVerifyStatusName(ProjectApplyVerifyStatusEnum.getMap().get(model.getVerifyStatus()));
        return model;
    }
}