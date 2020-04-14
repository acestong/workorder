package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysJobVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.project.ProjectQueryPersonOrTeamEnum;
import com.fea.project.enums.project.ProjectQueryTypeEnum;
import com.fea.project.enums.project.ProjectRoleAuthorityActionTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.ProjectViewSelfConfigModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.vo.ProjectStatisticsVo;
import com.fea.project.model.project.vo.ProjectUserSelectVo;
import com.fea.project.model.project.vo.ProjectViewVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
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
public class ProjectQueryService {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SysUserService sysUserService;


    public BasePageInfo<ProjectVo> listByUserIds(BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        setQueryUserIds(basePageInfo);
        if(basePageInfo.getModel().getUserIds().isEmpty()){
            return new BasePageInfo<>(Collections.emptyList());
        }
        return projectService.listByParam(basePageInfo);
    }


    public List<ProjectUserSelectVo> selectTreeList() {
        Long userId = UserUtil.getUserId();
        List<SysJobVo> sysJobModels = this.sysUserService.selectUserJobs(userId);
        return ProjectUserSelectVo.createList(sysJobModels);
    }

    public List<Long> selectCurrentUserAdminUserIds() {
        Long userId = UserUtil.getUserId();
        List<SysUserModel> sysUserModels = this.sysUserService.selectCurrentUserAdminUsers(userId);
        return sysUserModels.stream().map(SysUserModel::getUserId).collect(Collectors.toList());
    }

    public ProjectStatisticsVo selectProjectConditionByUserIds(BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        setQueryUserIds(basePageInfo);
        if(ProjectQueryTypeEnum.TYPE_ALL_PROJECT.getValue().equals(basePageInfo.getModel().getQueryType())){
            basePageInfo.setPageSize(0);
            basePageInfo.setPageNum(0);
            List<ProjectVo> projectVos = this.projectService.selectAllProjectModel(basePageInfo);
            return this.projectService.statisticsProjectModelsToStatisticsVo(projectVos);
        }
        if(ProjectQueryTypeEnum.selectStandardQueryType().contains(basePageInfo.getModel().getQueryType()) && ListUtil.isNullOrEmpty(basePageInfo.getModel().getUserIds())){
            return ProjectStatisticsVo.initModel();
        }
        return projectService.selectProjectCondition(basePageInfo);
    }

    private void setQueryUserIds(BasePageInfo<ProjectPojo> basePageInfo) {
        Integer queryType = basePageInfo.getModel().getQueryType();
        if (!ProjectQueryTypeEnum.getFullList().contains(queryType)) {
            throw new SystemParamCheckException("当前类型未定义，无法进行查询");
        }
        if (Objects.equals(basePageInfo.getModel().getPersonOrTeamType(), ProjectQueryPersonOrTeamEnum.TYPE_PERSON.getValue())) {
            basePageInfo.getModel().setUserIds(new ArrayList<Long>(1) {{
                add(UserUtil.getUserId());
            }});
        } else if (Objects.equals(basePageInfo.getModel().getPersonOrTeamType(), ProjectQueryPersonOrTeamEnum.TYPE_TEAM.getValue())) {
            List<Long> userIds = this.selectCurrentUserAdminUserIds();
            basePageInfo.getModel().setUserIds(userIds);
        }
    }
}
