package com.fea.project.service.team;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysDepartmentVo;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.team.ProjectTeamUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.role.ProjectRoleUserModel;
import com.fea.project.model.role.pojo.ProjectRoleUserPojo;
import com.fea.project.model.role.vo.ProjectRoleUserVo;
import com.fea.project.model.team.ProjectTeamModel;
import com.fea.project.model.team.ProjectTeamUserModel;
import com.fea.project.model.team.pojo.ProjectTeamUserPojo;
import com.fea.project.model.team.vo.ProjectTeamUserVo;
import com.fea.project.model.team.vo.TeamPersonSelectVo;
import com.fea.project.model.user.ProjectUserModel;
import com.fea.project.service.role.ProjectRoleUserService;
import com.fea.project.service.user.ProjectUserService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectTeamUserService {

    @Autowired
    private ProjectTeamUserMapper projectTeamUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectUserService projectUserService;

    @Autowired
    private ProjectTeamService projectTeamService;

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private ProjectRoleUserService projectRoleUserService;



    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectTeamUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectTeamUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectTeamUserModel model) {
        return model != null && this.projectTeamUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectTeamUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectTeamUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectTeamUserMapper.insertList(list);
            }
        } else {
            return this.projectTeamUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectTeamUserModel model) {
        return model != null && this.projectTeamUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectTeamUserModel selectById(Long id) {
        return id == null ? null : this.projectTeamUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectTeamUserModel> selectByModel(ProjectTeamUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectTeamUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectTeamUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectTeamUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectTeamUserMapper.insert(model) == 1;
        }
        return this.projectTeamUserMapper.updateById(model) == 1;
    }

    public BasePageInfo<ProjectTeamUserVo> listByParam(BasePageInfo<ProjectTeamUserModel> pageInfo) {
        ProjectTeamModel projectTeamModel = this.projectTeamService.selectById(pageInfo.getModel().getTeamId());
        if (ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName().equals(projectTeamModel.getShortName())) {
            pageInfo.getModel().setCanRoot(true);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<ProjectTeamUserVo> projectTeamUserVos = this.projectTeamUserMapper.selectByFilterAndOrderParams(pageInfo);
        List<Long> userIds = projectTeamUserVos.stream().map(ProjectTeamUserVo::getRealUserId).collect(Collectors.toList());
        List<SysUserModel> sysUserModels = this.sysUserService.selectBaseInfoByIds(userIds);
        Map<Long, SysUserModel> userMap = new HashMap<>(16);
        sysUserModels.forEach(tmp -> {
            if (userMap.get(tmp.getUserId()) != null) {
                StringBuffer sb = new StringBuffer(StringUtil
                        .isEmpty(userMap.get(tmp.getUserId()).getRoleName()) ? "" : userMap.get(tmp.getUserId()).getRoleName());
                if (StringUtil.isEmpty(sb.toString()) || StringUtil.isEmpty(tmp.getRoleName())) {
                    sb = sb.append(StringUtil.isEmpty(tmp.getRoleName()) ? "" : tmp.getRoleName());
                } else {
                    sb = sb.append(" ").append(StringUtil.isEmpty(tmp.getRoleName()) ? "" : tmp.getRoleName());
                }
                userMap.get(tmp.getUserId()).setRoleName(sb.toString());
                return;
            }
            userMap.put(tmp.getUserId(), tmp);
        });
        Map<Long, ProjectRoleUserVo> roleMap = this.projectRoleUserService.selectProjectUserRolesByUserIds(userIds)
                .stream().filter(projectRoleUserVo -> projectRoleUserVo.getRoleName() != null)
                .collect(Collectors.toMap(ProjectRoleUserVo::getUserId, projectRoleUserVo -> projectRoleUserVo));
        projectTeamUserVos.forEach(tmp -> {
            SysUserModel sysUserModel = userMap.get(tmp.getRealUserId());
            if (sysUserModel != null) {
                tmp.setUserName(sysUserModel.getRealName());
                tmp.setDeptName(sysUserModel.getDeptName());
                tmp.setGender(sysUserModel.getGender());
                tmp.setPhone(sysUserModel.getPhone());
                tmp.setDutyName(sysUserModel.getDutyName());
                tmp.setMail(sysUserModel.getMail());
                tmp.setRegName(sysUserModel.getRegName());
                tmp.setRoleName(roleMap.get(tmp.getRealUserId()) == null ? null : roleMap.get(tmp.getRealUserId()).getRoleName());
                tmp.setRoleId(roleMap.get(tmp.getRealUserId()) == null ? null : roleMap.get(tmp.getRealUserId()).getRoleId());
            }
        });
        return new BasePageInfo<>(projectTeamUserVos);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserModel insertUserFromReg(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("项目成员id无效，无法进行新增");
        }
        ProjectTeamModel projectTeamModel = this.projectTeamService.selectById(model.getTeamId());
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        if (projectTeamModel.getParentId() != null) {
            throw new SystemParamCheckException("当前团队节点无法拉取组织人员信息");
        }
        List<ProjectUserModel> projectUserModels = ProjectUserModel.createList(model, projectTeamModel.getProjectId(), userModel);
        if (projectUserService.insertList(projectUserModels)) {
            //将人员邦入未分组人员
            ProjectTeamModel ungroupModel = this.projectTeamService.selectTeamByProjectIdAndShortName(projectTeamModel.getProjectId(), ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName());
            List<ProjectTeamUserModel> projectTeamUserModels = projectUserModels.stream().map(tmp -> new ProjectTeamUserModel(tmp.getId(), ungroupModel.getId(), userModel)).collect(Collectors.toList());
            if (projectTeamUserMapper.insertList(projectTeamUserModels) >= 0) {
                return model;
            }
        }
        throw new SystemParamCheckException("项目添加人员报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserModel insertUserFromTeam(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("团队成员id无效，无法进行新增");
        }
        ProjectTeamModel projectTeamModel = this.projectTeamService.selectById(model.getTeamId());
        if (projectTeamModel == null) {
            throw new SystemParamCheckException("当前团队信息不存在，请刷新后重试");
        }
        List<ProjectUserModel> projectUserModels = this.projectUserService.selectByProjectIdAndUserIds(projectTeamModel.getProjectId(), model.getUserIds());
        List<Long> projectUserIds = projectUserModels.stream().map(ProjectUserModel::getId).collect(Collectors.toList());
        List<Long> projectTeamUserIds = this.projectTeamUserMapper.selectByUserIds(projectUserIds).stream().map(ProjectTeamUserModel::getId).collect(Collectors.toList());
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        ProjectTeamUserPojo projectTeamUserModel = new ProjectTeamUserPojo(model.getTeamId());
        projectTeamUserModel.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if (this.projectTeamUserMapper.updateModelsByUserIds(projectTeamUserModel, projectTeamUserIds) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("团队成员团队数据变更异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserPojo updateModel(ProjectTeamUserPojo model) {
        if (model.getId() == null && model.getRoleId() == null) {
            throw new SystemParamCheckException("团队成员id参数异常，无法进行更新");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectRoleUserModel projectRoleUserModel = this.projectRoleUserService.selectByTeamIdAndUserId(model.getTeamId(), model.getUserId());
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectTeamUserMapper.updateByIdSelective(model) >= 0) {
            //用户角色进行更新
            if (projectRoleUserModel == null) {
                model.setUserIds(Stream.of(model.getUserId()).collect(Collectors.toList()));
                this.projectRoleUserService.insertModel(new ProjectRoleUserPojo(model));
            } else {
                if (!projectRoleUserModel.getRoleId().equals(model.getRoleId())) {
                    projectRoleUserModel.setRoleId(model.getRoleId());
                    projectRoleUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
                    this.projectRoleUserService.updateByIdSelective(projectRoleUserModel);
                }
            }
            return model;
        }
        throw new SystemParamCheckException("数据更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserPojo deleteModels(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("团队成员id传入异常，无法进行删除");
        }
        List<ProjectTeamUserModel> list = this.projectTeamUserMapper.selectByIds(model.getIds());
        List<Long> projectUserIds = list.stream().map(ProjectTeamUserModel::getUserId).collect(Collectors.toList());
        if (this.projectTeamUserMapper.deleteByIds(model.getIds()) >= 0 && this.projectUserService.updateUserStatusDelete(projectUserIds)
                && this.projectRoleUserService.updateUserRoleDelete(projectUserIds)) {
            return model;
        }
        throw new SystemParamCheckException("团队用户删除失败，无法进行删除");
    }


    public List<TeamPersonSelectVo> selectDeptUser(ProjectUserModel projectUserModel) {
        if (projectUserModel == null || projectUserModel.getProjectId() == null) {
            throw new SystemParamCheckException("项目团队id传入报错，无法进行查询");
        }
        List<Long> userIds = this.projectUserService.selectUserListByProjectId(projectUserModel)
                .stream().map(SysUserModel::getUserId).collect(Collectors.toList());
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        //查询企业信息
        List<SysDepartmentVo> sysDepartmentVos = this.sysDepartmentService.selectDepartmentAndUsers(sysUserModel, userIds);
        return TeamPersonSelectVo.createList(sysDepartmentVos);
    }

    public List<TeamPersonSelectVo> selectDeptUserWithNoParam() {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        //查询企业信息
        List<SysDepartmentVo> sysDepartmentVos = this.sysDepartmentService.selectDepartmentAndUsers(sysUserModel, Collections.emptyList());
        return TeamPersonSelectVo.createList(sysDepartmentVos);
    }


    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserPojo leftTeam(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectTeamModel ungroupTeam = this.projectTeamService.selectUngroupTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入未分组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        return updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
    }


    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserModel leftProject(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectTeamModel ungroupTeam = this.projectTeamService.selectRemoveTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入离开项目组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        this.updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
        //人员状态变更
        if (this.projectUserService.updateUserToRemoveStatusByProjectTeamUserIds(model.getIds(), sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
    }

    /**
     * 通过主键ids，更新对应数据
     *
     * @param model
     * @param ungroupTeam
     * @return
     */
    private ProjectTeamUserPojo updateProjectUserModelsByUserIds(ProjectTeamUserPojo model, ProjectTeamModel ungroupTeam, SysUserModel sysUserModel) {
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setTeamId(ungroupTeam.getId());
        if (this.projectTeamUserMapper.updateModelsByUserIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("移出当前团队，数据更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectTeamUserModel enterProject(ProjectTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectTeamModel ungroupTeam = this.projectTeamService.selectUngroupTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入离开项目组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        this.updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
        //人员状态变更
        if (this.projectUserService.updateUserToStandardStatusByProjectTeamUserIds(model.getIds(), sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
    }


    public boolean updateDeleteByModelAndProjectId(ProjectTeamUserModel projectTeamUserModel, Long projectId) {
        if(projectTeamUserModel == null || projectId == null || projectTeamUserModel.getUserId() == null){
            throw new SystemParamCheckException("团队数据传入异常，无法进行删除");
        }
        return this.projectTeamUserMapper.updateDeleteByModelAndProjectId(projectTeamUserModel, projectId) >= 0;
    }

    public boolean insertListByProjectUserModels(List<ProjectUserModel> projectUserModels) {
        if(projectUserModels == null){
            throw new SystemParamCheckException("项目用户传入异常，无法生成团队用户信息");
        }
        if(projectUserModels.isEmpty()){
            return Boolean.TRUE;
        }
        ProjectTeamModel unGroupModel = this.projectTeamService.selectTeamByProjectIdAndShortName(
                projectUserModels.get(0).getProjectId(), ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName());
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        if(unGroupModel == null){
            throw new SystemParamCheckException("该项目下未分组团队数据异常");
        }
        List<ProjectTeamUserModel> projectTeamUserModels = projectUserModels.stream().map(x -> new ProjectTeamUserModel(x, unGroupModel.getId(), sysUserModel)).collect(Collectors.toList());
        if(this.projectTeamUserMapper.insertList(projectTeamUserModels) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目团队用户添加异常");
    }

    /**
     * 立项阶段人力资源删除用户时使用
     * @param projectId
     * @param projectUserIds
     * @return
     */
    public boolean deleteByProjectIdAndProjectUserIds(Long projectId, List<Long> projectUserIds) {
        if(projectId == null || projectUserIds == null){
            throw new SystemParamCheckException("传入参数异常,无法进行删除");
        }
        if(projectUserIds.isEmpty()){
            return Boolean.TRUE;
        }
        return this.projectTeamUserMapper.deleteByProjectIdAndProjectUserIds(projectId, projectUserIds) >= 0;
    }
}