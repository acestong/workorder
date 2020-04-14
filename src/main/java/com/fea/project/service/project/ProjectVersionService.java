package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectVersionMapper;
import com.fea.project.enums.project.ProjectVersionSelectTypeEnum;
import com.fea.project.model.project.ProjectVersionModel;
import com.fea.project.model.project.vo.ProjectVersionVo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2019/12/14.
 */
@Service
public class ProjectVersionService {

    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取流程版本
     * 将旧的流程版本设置为无效
     * 插入新的流程版本信息
     */
    @Transactional(rollbackFor = Exception.class)
    public synchronized Long createNewProjectVersionModel(Long projectId, Integer selectFlag, Long businessId){
        if(projectId == null || selectFlag == null
                || Objects.equals(selectFlag, ProjectVersionSelectTypeEnum.TYPE_HISTORY.getValue())
                || businessId == null){
            throw new SystemParamCheckException("传入的项目版本信息异常，无法获取版本信息");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        ProjectVersionModel projectVersionModel = this.projectVersionMapper.selectByProjectIdAndRealType(projectId, ProjectVersionSelectTypeEnum.TYPE_REAL.getValue());
        BigDecimal version = null;
        if(Objects.equals(selectFlag, ProjectVersionSelectTypeEnum.TYPE_REAL.getValue()) && projectVersionModel != null){
            //将之前正式版本无效化
            projectVersionModel.setSelectFlag(ProjectVersionSelectTypeEnum.TYPE_HISTORY.getValue());
            this.projectVersionMapper.updateByIdSelective(projectVersionModel);
            version = new BigDecimal(projectVersionModel.getVersionCode());
        }
        //生成信息
        ProjectVersionModel tmpModel = new ProjectVersionModel(projectId, selectFlag, businessId, version, sysUserModel);
        if(this.projectVersionMapper.insertSelective(tmpModel) >= 0){
            return tmpModel.getId();
        }
        throw new SystemParamCheckException("版本信息生成异常，无法进行生成");
    }

    /**
     * 根据当前用户创建最新项目的草稿版本信息
     * @param projectId 项目id
     * @param businessId 根据selectType，分别代表历史版本表中id， 草稿表中id， 项目正式表中id
     * @param versionCode 版本编号
     * @return Boolean类型
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean createDraftVersion(Long projectId, Long businessId, String versionCode){
        if(projectId == null || businessId == null){
            throw new SystemParamCheckException("根据正式版本生成用户草稿版本信息时，传入参数异常，无法进行生成").appendAlaramMsg("versionCode:" + versionCode);
        }
        if(StringUtil.isEmpty(versionCode)){
            throw new SystemParamCheckException("当前项目不是正式项目，无法生成草稿");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        ProjectVersionModel projectVersionModel = ProjectVersionModel.createNewDraftVersion(projectId
                , businessId, versionCode, userModel);
        if(this.projectVersionMapper.deleteByProjectIdAndSelectTypeAndCreateId(projectId
                , ProjectVersionSelectTypeEnum.TYPE_DRAFT.getValue() , userModel.getUserId()) >= 0
                && this.projectVersionMapper.insertSelective(projectVersionModel) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("草稿版本信息生成失败");
    }

    public List<ProjectVersionModel> selectByIds(List<Long> ids) {
        if(ids == null){
            throw new SystemParamCheckException("传入的版本ids异常，无法进行查询");
        }
        if(ids.isEmpty()){
            return Collections.emptyList();
        }
        return this.projectVersionMapper.selectByIds(ids);
    }

    /**
     * 删除草稿记录，变更当前版本为历史版本，新增新版本
     * @param businessId 当前草稿id
     * @param projectId 项目id
     * @param historyId 当前版本将要变为历史信息，历史表中主键id
     * @return 当前版本的id
     */
    @Transactional(rollbackFor = Exception.class)
    public Long deleteDraftVersionAndInsertNewRealVersion(Long businessId, Long projectId, Long historyId) {
        if(businessId == null || projectId == null){
            throw new SystemParamCheckException("草稿id或是项目id查询异常，无法进行版本更新");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        ProjectVersionModel currentVersion = this.projectVersionMapper.selectByProjectIdAndRealType(projectId, ProjectVersionSelectTypeEnum.TYPE_REAL.getValue());
        ProjectVersionModel newVersion = currentVersion.createNewRealVersion(sysUserModel);
        currentVersion.setSelectFlag(ProjectVersionSelectTypeEnum.TYPE_HISTORY.getValue());
        currentVersion.setBusinessId(historyId);
        if(this.projectVersionMapper.updateByIdSelective(currentVersion) >= 0
            && this.projectVersionMapper.deleteByBusinessIdAndProjectIdAndSelectType(businessId, projectId, ProjectVersionSelectTypeEnum.TYPE_DRAFT.getValue()) >= 0
            && this.projectVersionMapper.insertSelective(newVersion) > 0){
            return newVersion.getId();
        }
        throw new SystemParamCheckException("项目版本变更记录生成报错");
    }

    public Map<String, List<ProjectVersionVo>> selectProjectVersionInfo(ProjectVersionModel projectVersionModel) {
        if(projectVersionModel == null || projectVersionModel.getProjectId() == null){
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectVersionVo> projectVersionVos = this.projectVersionMapper.selectByProjectIdOrUserId(projectVersionModel.getProjectId(), userModel.getUserId());
        List<ProjectVersionVo> realVersions = new ArrayList<>();
        List<ProjectVersionVo> draftVersions = new ArrayList<>();
        Map<Integer, String> selectTypeMap = ProjectVersionSelectTypeEnum.getMap();
        projectVersionVos.forEach(x -> {
            x.setSelectFlagName(selectTypeMap.get(x.getSelectFlag()));
            if(!Objects.equals(x.getSelectFlag(), ProjectVersionSelectTypeEnum.TYPE_DRAFT.getValue())){
                realVersions.add(x);
            }else{
                if(!draftVersions.isEmpty()){
                    throw new SystemParamCheckException("该用户下草稿数据异常");
                }
                draftVersions.add(x);
            }
        });
        return new HashMap<String, List<ProjectVersionVo>>(2){{
            put("projectVersion", realVersions);
            put("draftVersion", draftVersions);
        }};

    }
}