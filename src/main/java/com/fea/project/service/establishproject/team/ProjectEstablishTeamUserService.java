package com.fea.project.service.establishproject.team;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysDepartmentVo;
import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.establishproject.team.ProjectEstablishTeamUserMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.team.ProjectDefaultRootTeamEnum;
import com.fea.project.enums.team.ProjectDefaultTeamEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.establishproject.role.ProjectEstablishRoleUserModel;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamUserModel;
import com.fea.project.model.establishproject.user.ProjectEstablishUserModel;
import com.fea.project.model.establishproject.pojo.ProjectEstablishRoleUserPojo;
import com.fea.project.model.establishproject.pojo.ProjectEstablishTeamUserPojo;
import com.fea.project.model.establishproject.vo.EstablishTeamPersonSelectVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishRoleUserVo;
import com.fea.project.model.establishproject.vo.ProjectEstablishTeamUserVo;
import com.fea.project.service.establishproject.user.ProjectEstablishUserService;
import com.fea.project.service.establishproject.role.ProjectEstablishRoleUserService;
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
public class ProjectEstablishTeamUserService {

    @Autowired
    private ProjectEstablishTeamUserMapper projectEstablishTeamUserMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectEstablishUserService projectEstablishUserService;

    @Autowired
    private ProjectEstablishTeamService projectEstablishTeamService;

    @Autowired
    private SysDepartmentService sysDepartmentService;

    @Autowired
    private ProjectEstablishRoleUserService projectEstablishRoleUserService;



    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectEstablishTeamUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectEstablishTeamUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectEstablishTeamUserModel model) {
        return model != null && this.projectEstablishTeamUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectEstablishTeamUserModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectEstablishTeamUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectEstablishTeamUserMapper.insertList(list);
            }
        } else {
            return this.projectEstablishTeamUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectEstablishTeamUserModel model) {
        return model != null && this.projectEstablishTeamUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectEstablishTeamUserModel selectById(Long id) {
        return id == null ? null : this.projectEstablishTeamUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectEstablishTeamUserModel> selectByModel(ProjectEstablishTeamUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectEstablishTeamUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectEstablishTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectEstablishTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectEstablishTeamUserModel model) {
        return !(model == null || model.getId() == null) && this.projectEstablishTeamUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectEstablishTeamUserModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectEstablishTeamUserMapper.insert(model) == 1;
        }
        return this.projectEstablishTeamUserMapper.updateById(model) == 1;
    }

    public BasePageInfo<ProjectEstablishTeamUserVo> listByParam(BasePageInfo<ProjectEstablishTeamUserModel> pageInfo) {
        ProjectEstablishTeamModel projectEstablishTeamModel = this.projectEstablishTeamService.selectById(pageInfo.getModel().getTeamId());
        if (ProjectDefaultRootTeamEnum.TYPE_ROOT_TEAM.getShortName().equals(projectEstablishTeamModel.getShortName())) {
            pageInfo.getModel().setCanRoot(true);
        }
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<ProjectEstablishTeamUserVo> projectEstablishTeamUserVos = this.projectEstablishTeamUserMapper.selectByFilterAndOrderParams(pageInfo);
        List<Long> userIds = projectEstablishTeamUserVos.stream().map(ProjectEstablishTeamUserVo::getRealUserId).collect(Collectors.toList());
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
        Map<Long, ProjectEstablishRoleUserVo> roleMap = this.projectEstablishRoleUserService.selectProjectUserRolesByUserIds(userIds)
                .stream().filter(projectEstablishRoleUserVo -> projectEstablishRoleUserVo.getRoleName() != null)
                .collect(Collectors.toMap(ProjectEstablishRoleUserVo::getUserId, projectEstablishRoleUserVo -> projectEstablishRoleUserVo));
        projectEstablishTeamUserVos.forEach(tmp -> {
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
        return new BasePageInfo<>(projectEstablishTeamUserVos);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserModel insertUserFromReg(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("项目成员id无效，无法进行新增");
        }
        ProjectEstablishTeamModel projectEstablishTeamModel = this.projectEstablishTeamService.selectById(model.getTeamId());
        SysUserModel userModel = this.sysUserService.getCurrentUsr();
        if (projectEstablishTeamModel.getParentId() != null) {
            throw new SystemParamCheckException("当前团队节点无法拉取组织人员信息");
        }
        List<ProjectEstablishUserModel> projectEstablishUserModels = ProjectEstablishUserModel.createList(model, projectEstablishTeamModel.getProjectId(), userModel);
        if (projectEstablishUserService.insertList(projectEstablishUserModels)) {
            //将人员邦入未分组人员
            ProjectEstablishTeamModel ungroupModel = this.projectEstablishTeamService.selectUngroupTeamByProjectIdAndShortName(projectEstablishTeamModel.getProjectId(), ProjectDefaultTeamEnum.TYPE_UNGROUP_QUEUE.getShortName());
            List<ProjectEstablishTeamUserModel> projectEstablishTeamUserModels = projectEstablishUserModels.stream().map(tmp -> new ProjectEstablishTeamUserModel(tmp.getId(), ungroupModel.getId(), userModel)).collect(Collectors.toList());
            if (projectEstablishTeamUserMapper.insertList(projectEstablishTeamUserModels) >= 0) {
                return model;
            }
        }
        throw new SystemParamCheckException("项目添加人员报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserModel insertUserFromTeam(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getUserIds())) {
            throw new SystemParamCheckException("团队成员id无效，无法进行新增");
        }
        ProjectEstablishTeamModel projectEstablishTeamModel = this.projectEstablishTeamService.selectById(model.getTeamId());
        if (projectEstablishTeamModel == null) {
            throw new SystemParamCheckException("当前团队信息不存在，请刷新后重试");
        }
        List<ProjectEstablishUserModel> projectEstablishUserModels = this.projectEstablishUserService.selectByProjectIdAndUserIds(projectEstablishTeamModel.getProjectId(), model.getUserIds());
        List<Long> projectUserIds = projectEstablishUserModels.stream().map(ProjectEstablishUserModel::getId).collect(Collectors.toList());
        List<Long> projectTeamUserIds = this.projectEstablishTeamUserMapper.selectByUserIds(projectUserIds).stream().map(ProjectEstablishTeamUserModel::getId).collect(Collectors.toList());
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        ProjectEstablishTeamUserPojo projectEstablishTeamUserPojo = new ProjectEstablishTeamUserPojo(model.getTeamId());
        projectEstablishTeamUserPojo.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if (this.projectEstablishTeamUserMapper.updateModelsByUserIds(projectEstablishTeamUserPojo, projectTeamUserIds) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("团队成员团队数据变更异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserPojo updateModel(ProjectEstablishTeamUserPojo model) {
        if (model.getId() == null && model.getRoleId() == null) {
            throw new SystemParamCheckException("团队成员id参数异常，无法进行更新");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectEstablishRoleUserModel projectEstablishRoleUserModel = this.projectEstablishRoleUserService.selectByTeamIdAndUserId(model.getTeamId(), model.getUserId());
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectEstablishTeamUserMapper.updateByIdSelective(model) >= 0) {
            //用户角色进行更新
            if (projectEstablishRoleUserModel == null) {
                model.setUserIds(Stream.of(model.getUserId()).collect(Collectors.toList()));
                this.projectEstablishRoleUserService.insertModel(new ProjectEstablishRoleUserPojo(model));
            } else {
                if (!projectEstablishRoleUserModel.getRoleId().equals(model.getRoleId())) {
                    projectEstablishRoleUserModel.setRoleId(model.getRoleId());
                    projectEstablishRoleUserModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
                    this.projectEstablishRoleUserService.updateByIdSelective(projectEstablishRoleUserModel);
                }
            }
            return model;
        }
        throw new SystemParamCheckException("数据更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserPojo deleteModels(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("团队成员id传入异常，无法进行删除");
        }
        List<ProjectEstablishTeamUserModel> list = this.projectEstablishTeamUserMapper.selectByIds(model.getIds());
        List<Long> projectUserIds = list.stream().map(ProjectEstablishTeamUserModel::getUserId).collect(Collectors.toList());
        if (this.projectEstablishTeamUserMapper.deleteByIds(model.getIds()) >= 0 && this.projectEstablishUserService.updateUserStatusDelete(projectUserIds)
                && this.projectEstablishRoleUserService.updateUserRoleDelete(projectUserIds)) {
            return model;
        }
        throw new SystemParamCheckException("团队用户删除失败，无法进行删除");
    }


    public List<EstablishTeamPersonSelectVo> selectDeptUser(ProjectEstablishUserModel projectEstablishUserModel) {
        if (projectEstablishUserModel == null || projectEstablishUserModel.getProjectId() == null) {
            throw new SystemParamCheckException("项目团队id传入报错，无法进行查询");
        }
        List<Long> userIds = this.projectEstablishUserService.selectUserListByProjectId(projectEstablishUserModel)
                .stream().map(SysUserModel::getUserId).collect(Collectors.toList());
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        //查询企业信息
        List<SysDepartmentVo> sysDepartmentVos = this.sysDepartmentService.selectDepartmentAndUsers(sysUserModel, userIds);
        return EstablishTeamPersonSelectVo.createList(sysDepartmentVos);
    }

    public List<EstablishTeamPersonSelectVo> selectDeptUserWithNoParam() {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        //查询企业信息
        List<SysDepartmentVo> sysDepartmentVos = this.sysDepartmentService.selectDepartmentAndUsers(sysUserModel, Collections.emptyList());
        return EstablishTeamPersonSelectVo.createList(sysDepartmentVos);
    }


    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserPojo leftTeam(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectEstablishTeamModel ungroupTeam = this.projectEstablishTeamService.selectUngroupTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入未分组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        return updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
    }


    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserModel leftProject(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectEstablishTeamModel ungroupTeam = this.projectEstablishTeamService.selectRemoveTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入离开项目组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        this.updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
        //人员状态变更
        if (this.projectEstablishUserService.updateUserToRemoveStatusByProjectTeamUserIds(model.getIds(), sysUserModel)) {
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
    private ProjectEstablishTeamUserPojo updateProjectUserModelsByUserIds(ProjectEstablishTeamUserPojo model, ProjectEstablishTeamModel ungroupTeam, SysUserModel sysUserModel) {
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setTeamId(ungroupTeam.getId());
        if (this.projectEstablishTeamUserMapper.updateModelsByUserIds(model, model.getIds()) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("移出当前团队，数据更新异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectEstablishTeamUserModel enterProject(ProjectEstablishTeamUserPojo model) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
        }
        //通过参数查询出对应
        ProjectEstablishTeamModel ungroupTeam = this.projectEstablishTeamService.selectUngroupTeamByOrdernaryTeamUserId(model.getIds().get(0));
        //进行信息变更，将人员移入离开项目组
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        this.updateProjectUserModelsByUserIds(model, ungroupTeam, sysUserModel);
        //人员状态变更
        if (this.projectEstablishUserService.updateUserToStandardStatusByProjectTeamUserIds(model.getIds(), sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目团队人员信息异常，无法进行退组操作");
    }



}