package com.fea.project.service.establishproject.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.project.ProjectQueryPersonOrTeamEnum;
import com.fea.project.enums.project.ProjectQueryTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishProjectPojo;
import com.fea.project.model.establishproject.project.ProjectEstablishProjectModel;
import com.fea.project.model.establishproject.vo.ProjectEstablishVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectStatisticsVo;
import com.fea.project.model.project.vo.ProjectUserSelectVo;
import com.fea.project.model.project.vo.ProjectViewVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.project.ProjectQueryService;
import com.fea.project.service.project.ProjectService;
import com.fea.project.service.project.ProjectViewService;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/26 10:28
 **/
@Service
public class ProjectEstablishQueryService {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectEstablishProjectService projectEstablishProjectService;
    @Autowired
    private ProjectQueryService projectQueryService;


    public BasePageInfo<ProjectEstablishVo> listByUserIds(BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        Integer queryType = basePageInfo.getModel().getQueryType();
        if (!ProjectQueryTypeEnum.getFullList().contains(queryType)) {
            throw new SystemParamCheckException("当前类型未定义，无法进行查询");
        }
        //查询全部项目
        if(Objects.equals(ProjectQueryTypeEnum.TYPE_ALL_PROJECT.getValue(), basePageInfo.getModel().getQueryType())){
            List<Long> projectIds = this.selectAllUserProject();
            if(projectIds.isEmpty()){
                return new BasePageInfo<>(Collections.emptyList());
            }
            basePageInfo.getModel().setIds(projectIds);
        }else if (ProjectQueryTypeEnum.getUserQueryList().contains(basePageInfo.getModel().getQueryType())){
            //查询人员项目
            basePageInfo.getModel().setUserIds(new ArrayList<Long>(1) {{
                add(UserUtil.getUserId());
            }});
        }else if(Objects.equals(ProjectQueryTypeEnum.TYPE_MANAGE_USER_PROJECT.getValue(), basePageInfo.getModel().getQueryType())){
            //查询下属负责的项目
            List<Long> establishLeaders = projectService.selectLeaderIdsByLeftSelectTypeAndId(new ProjectPojo(basePageInfo.getModel().getSelectId(), basePageInfo.getModel().getSelectType()));
            List<Long> projectIds = ListUtil.isNullOrEmpty(establishLeaders)?new ArrayList<>():this.projectEstablishProjectService.selectByEstablishLeaders(establishLeaders).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
            if(projectIds.isEmpty()){
                return new BasePageInfo<>(Collections.emptyList());
            }
            basePageInfo.getModel().setIds(projectIds);
        }
        return projectEstablishProjectService.listByParam(basePageInfo);
    }

    /**
     * 查询当前用户关联的所有项目
     * @return
     */
    private List<Long> selectAllUserProject() {
        List<Long> projectIds = new ArrayList<>();
        //我创建的项目
        List<Long> createProjectIds = this.projectEstablishProjectService.selectByCreateId(UserUtil.getUserId()).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
        //我关注的项目
        List<Long> payAttentionIds = this.projectEstablishProjectService.selectByAttention(UserUtil.getUserId()).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
        //我负责的项目
        List<Long> leaderProjectIds = this.projectEstablishProjectService.selectByEstablishLeader(UserUtil.getUserId()).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
        //我参与的项目
        List<Long> joinProjectIds = this.projectEstablishProjectService.selectByJoiner(UserUtil.getUserId()).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
        //我管辖人员负责项目
        List<Long> leaderIds = this.projectService.selectUserIdsByCurrentUser();
        List<Long> managePersonProjectIds = ListUtil.isNullOrEmpty(leaderIds)?new ArrayList<>():this.projectEstablishProjectService.selectByEstablishLeaders(leaderIds).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
        //我额外的项目TODO

        projectIds.addAll(createProjectIds);
        projectIds.addAll(payAttentionIds);
        projectIds.addAll(leaderProjectIds);
        projectIds.addAll(joinProjectIds);
        projectIds.addAll(managePersonProjectIds);
        return projectIds.stream().distinct().collect(Collectors.toList());
    }

    public List<Long> selectCurrentUserAdminUserIds() {
        Long userId = UserUtil.getUserId();
        List<SysUserModel> sysUserModels = this.sysUserService.selectCurrentUserAdminUsers(userId);
        return sysUserModels.stream().map(SysUserModel::getUserId).collect(Collectors.toList());
    }

    public List<ProjectUserSelectVo> selectTreeList() {
        return projectQueryService.selectTreeList();
    }

    public ProjectStatisticsVo selectProjectCondition(BasePageInfo<ProjectEstablishProjectPojo> basePageInfo) {
        Integer queryType = basePageInfo.getModel().getQueryType();
        if (!ProjectQueryTypeEnum.getFullList().contains(queryType)) {
            throw new SystemParamCheckException("当前类型未定义，无法进行查询");
        }
        //查询全部项目
        if(Objects.equals(ProjectQueryTypeEnum.TYPE_ALL_PROJECT.getValue(), basePageInfo.getModel().getQueryType())){
            List<Long> projectIds = this.selectAllUserProject();
            if(projectIds.isEmpty()){
                return ProjectStatisticsVo.initModel();
            }
            basePageInfo.getModel().setIds(projectIds);
        }else if (ProjectQueryTypeEnum.getUserQueryList().contains(basePageInfo.getModel().getQueryType())){
            //查询人员项目
            basePageInfo.getModel().setUserIds(new ArrayList<Long>(1) {{
                add(UserUtil.getUserId());
            }});
        }else if(Objects.equals(ProjectQueryTypeEnum.TYPE_MANAGE_USER_PROJECT.getValue(), basePageInfo.getModel().getQueryType())){
            //查询下属负责的项目
            List<Long> establishLeaders = projectService.selectLeaderIdsByLeftSelectTypeAndId(new ProjectPojo(basePageInfo.getModel().getSelectId(), basePageInfo.getModel().getSelectType()));
            List<Long> projectIds = ListUtil.isNullOrEmpty(establishLeaders)?new ArrayList<>():this.projectEstablishProjectService.selectByEstablishLeaders(establishLeaders).stream().map(ProjectEstablishProjectModel::getId).collect(Collectors.toList());
            if(projectIds.isEmpty()){
                return ProjectStatisticsVo.initModel();
            }
            basePageInfo.getModel().setIds(projectIds);
        }
        basePageInfo.setPageNum(0);
        basePageInfo.setPageSize(0);
        List<ProjectEstablishVo> list = this.projectEstablishProjectService.checkParamAndSelectBaseProjectEstablishModels(basePageInfo);
        List<ProjectVo> projectVos = list.stream().map(x -> {
            ProjectVo tmpModel = new ProjectVo();
            tmpModel.setPlanEndTime(x.getPlanEndTime());
            return tmpModel;
        }).collect(Collectors.toList());
        return projectService.statisticsProjectModelsToStatisticsVo(projectVos);


    }
}
