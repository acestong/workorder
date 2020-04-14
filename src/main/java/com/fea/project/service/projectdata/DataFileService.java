package com.fea.project.service.projectdata;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.plan.PlanAppendixModelMapper;
import com.fea.project.dao.plan.PlanModelMapper;
import com.fea.project.dao.task.TaskModelMapper;
import com.fea.project.dao.team.ProjectTeamMapper;
import com.fea.project.enums.AppendixTypeEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.plan.PlanAppendixModel;
import com.fea.project.model.projectdata.*;
import com.fea.project.model.task.TaskModel;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.team.ProjectTeamService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Administrator
 */
@Service
public class DataFileService {
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectTeamService projectTeamService;
    @Autowired
    private ProjectTeamMapper projectTeamMapper;
    @Autowired
    private PlanAppendixModelMapper planAppendixModelMapper;
    @Autowired
    private PlanModelMapper planModelMapper;
    @Autowired
    private TaskModelMapper taskModelMapper;
    @Autowired
    private ProjectAppendixService projectAppendixService;

    /**
     * 获取附件资料类型
     */
    public List<ProjectDictionaryItemSelectVo> getAppendixType() {
        Long regId = sysUserService.getCurrentUsr().getRegId();
        List<ProjectDictionaryItemSelectVo> voList = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(
                new ProjectDictionaryModel(DictionaryTypeEnum.APPENDIX_DATA_TYPE.getValue(), regId));
        return voList;
    }

    /**
     *获取团队树
     */
    public List<FinalTreeVo> getAppendixTeamListByProjectId(Long projectId) {
        //存放团队要操作的团队信息
        Map<Long, ProjectTeamTreeVo> map = new HashMap<>();
        //获取我负责的团队
        List<ProjectTeamTreeVo> leaderTeam = projectTeamService.getLeaderTeamByProjectIdAndLeaderId(projectId);
        //获取下属团队
        addChildTeam(leaderTeam, map);
        //团队列表
        List<ProjectTeamTreeVo> teamList = new ArrayList<>();
        for (ProjectTeamTreeVo value : map.values()) {
            teamList.add(value);
        }
        //获取团队下人员
        for (ProjectTeamTreeVo vo : teamList) {
            List<Long> ids = projectTeamService.getLeaderTeamUserByTeamId(vo.getTeamId());
            List<SysUserModel> sysUserModels = sysUserService.selectByIds(ids);
            vo.setChild(FinalTreeVo.FinalTreeList(sysUserModels,vo.getTeamId()));
        }
        //封装成树
        List<FinalTreeVo> list = new ArrayList<>();
        teamList.forEach(team -> {
            ProjectTeamTreeVo vo = map.get(team.getParentId());
            if (vo == null) {
                list.add(new FinalTreeVo(team));
                return;
            }
            map.get(team.getParentId()).getChild().add(new FinalTreeVo(team));
        });

        return list;
    }

    /**
     * 获取下属团队
     */
    void addChildTeam(List<ProjectTeamTreeVo> projectTeamTreeVos, Map<Long, ProjectTeamTreeVo> teamMap) {
        for (ProjectTeamTreeVo vo : projectTeamTreeVos) {
            teamMap.put(vo.getTeamId(), vo);
            List<ProjectTeamTreeVo> childTeamByTeamId = projectTeamMapper.getChildTeamByTeamId(vo.getTeamId());
            if (!childTeamByTeamId.isEmpty()) {
                for (ProjectTeamTreeVo projectTeamTreeVo : childTeamByTeamId) {
                    teamMap.put(projectTeamTreeVo.getTeamId(), projectTeamTreeVo);
                    addChildTeam(childTeamByTeamId, teamMap);
                }
            }
        }
    }

    /**
     * 获取当前团队下及下属团队人员
     *
     * @param teamId 团队id
     */
    public List<Long> getUserIdsByTeamId(Long teamId) {
        //当前团队的人员
        List<Long> userIds = projectTeamMapper.getLeaderTeamUserByTeamId(teamId);
        //获取团队下属团队集合
        Map<Long, ProjectTeamTreeVo> teamMap = new HashMap<>();
        List<ProjectTeamTreeVo> childTeamByTeamId = projectTeamMapper.getChildTeamByTeamId(teamId);
        addChildTeam(childTeamByTeamId, teamMap);
        List<ProjectTeamTreeVo> teamList = new ArrayList<>();
        for (ProjectTeamTreeVo value : teamMap.values()) {
            teamList.add(value);
        }
        for (ProjectTeamTreeVo vo : teamList) {
            List<Long> ids = projectTeamService.getLeaderTeamUserByTeamId(vo.getTeamId());
            userIds.addAll(ids);
        }
        return userIds;
    }

    /**
     * 获取附件资料列表
     *
     */
    public BasePageInfo<AppendixDataFileVo> getAppendixListByIds(BasePageInfo<DataTeamVo> dataFileVo) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //处理业务ids
        IdsVo idsVo = new IdsVo();
        if (dataFileVo.getModel().getProjectId() == null){
            throw new SystemParamCheckException("参数传入错误，无法获取");
        }
        idsVo.setProjectId(dataFileVo.getModel().getProjectId());
        idsVo.setBusinessIds(getBusinessIds(dataFileVo.getModel().getProjectId()));
        idsVo.setFilters(dataFileVo.getFilters());
        idsVo.setKeywords(dataFileVo.getKeywords());
        idsVo.setSortKey(dataFileVo.getSortKey());
        idsVo.setSortValue(dataFileVo.getSortValue());
        //存放userIds
        ArrayList<Long> list = new ArrayList<>();
        if (null == dataFileVo.getModel().getTag()){
            //我的资料
            list.add(currentUsr.getUserId());
            idsVo.setCreateIds(list);
        }else if (0 == dataFileVo.getModel().getTag()){
            //团队的资料
            List<Long> userIdsByTeamId = getUserIdsByTeamId(dataFileVo.getModel().getId());
            if (userIdsByTeamId.isEmpty()){
                return new BasePageInfo<>(new ArrayList<>());
            }
            idsVo.setCreateIds(userIdsByTeamId);

        }else if (1 == dataFileVo.getModel().getTag()){
            //员工的资料
            if (dataFileVo.getModel().getId() == null){
                throw new SystemParamCheckException("参数传入错误，无法获取");
            }
            list.add(dataFileVo.getModel().getId());
            idsVo.setCreateIds(list);
        }
        PageHelper.startPage(dataFileVo.getPageNum(),dataFileVo.getPageSize());
        List<AppendixDataFileVo> planAppendixModels = planAppendixModelMapper.selectAppendixByIdsAndProjectId(idsVo);
        //关联项目阶段信息，关联任务信息
        for (AppendixDataFileVo model : planAppendixModels){
            if (AppendixTypeEnum.PLAN.getCode().equals(model.getBusinessType())){
                //计划转任务，获取对应任务名称
                TaskModel taskModel = taskModelMapper.selectByPlanTransferId(model.getBusinessId());
                if (taskModel!=null){
                    model.setTaskId(taskModel.getTaskId());
                    model.setTaskName(taskModel.getTaskName());
                }

            }else if (AppendixTypeEnum.TASK.getCode().equals(model.getBusinessType())){
                TaskModel taskModel = taskModelMapper.selectByPrimaryKey(model.getBusinessId());
                if (taskModel!=null) {
                    model.setTaskId(taskModel.getTaskId());
                    model.setTaskName(taskModel.getTaskName());
                }
            }else if (AppendixTypeEnum.PROJECT.getCode().equals(model.getBusinessType())){

            }
        };
        return new BasePageInfo<>(planAppendixModels);
    }
    /**
     * 获取任务或计划的IDS
     */
    public List<Long> getBusinessIds(Long projectId){
        List<Long> list = taskModelMapper.selectTaskIdByProjectId(projectId);
        list.addAll(taskModelMapper.selectPlanTaskIdByProjectId(projectId));
        return list;
    }
    /**
     * 新增项目资料
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addAppendixDataFile(AppendixDataFileVo modelVo) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        PlanAppendixModel model = PlanAppendixModel.builder()
                .businessAppendixId(null)
                .projectId(modelVo.getProjectId())
                .businessId(modelVo.getTaskId())
                .businessAppendixName(modelVo.getBusinessAppendixName())
                .businessAppendixType(modelVo.getBusinessAppendixType())
                .businessAppendixDesc(modelVo.getBusinessAppendixDesc())
                .businessType(AppendixTypeEnum.TASK.getCode())
                .businessName(AppendixTypeEnum.TASK.getType())
                .projectStep(modelVo.getProjectStepId())
                .createId(currentUsr.getUserId())
                .createBy(currentUsr.getRealName())
                .createTime(new Date())
                .delStatus(DeleteStatusEnum.NOT_DELETE.getStatus().longValue())
                .build();
        int insert = planAppendixModelMapper.insertSelective(model);
        if (insert != 1){
            throw new SystemParamCheckException("新增报错，请重试！");
        }
        //更新附件表
        List<Long> appendixIds = modelVo.getAppendixId();
        appendixIds.forEach(appendixId ->{
            ProjectAppendixModel appendixModel = new ProjectAppendixModel();
            appendixModel.setId(appendixId);
            appendixModel.setBusinessId(model.getBusinessAppendixId());
            boolean b = projectAppendixService.updateByIdSelective(appendixModel);
            if (!b){
                throw new SystemParamCheckException("新增报错，请重试！");
            }
        });

        return true;
    }
}
