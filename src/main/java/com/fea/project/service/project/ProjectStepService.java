package com.fea.project.service.project;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectStepMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import com.fea.project.model.project.vo.ProjectStepVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectStepService {

    @Autowired
    private ProjectStepMapper projectStepMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectStepVerifyService projectStepVerifyService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectStepMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectStepMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectStepModel model) {
        return model != null && this.projectStepMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectStepModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectStepModel> list : ListUtil.getSubList(models, 100)) {
                this.projectStepMapper.insertList(list);
            }
        } else {
            return this.projectStepMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectStepModel model) {
        return model != null && this.projectStepMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectStepModel selectById(Long id) {
        return id == null ? null : this.projectStepMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectStepVo> selectByModel(ProjectStepModel model) {
        return model == null ? new ArrayList<>(0) : this.projectStepMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectStepModel model) {
        return !(model == null || model.getId() == null) && this.projectStepMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectStepModel model) {
        return !(model == null || model.getId() == null) && this.projectStepMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectStepModel model) {
        return !(model == null || model.getId() == null) && this.projectStepMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectStepModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectStepMapper.insert(model) == 1;
        }
        return this.projectStepMapper.updateById(model) == 1;
    }

    public List<ProjectStepVo> listByProjectId(ProjectStepModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        List<ProjectStepVo> list = this.projectStepMapper.selectByModel(model);
        List<Long> leadIds = list.stream().map(ProjectStepVo::getLeader).collect(Collectors.toList());
        Map<Long, SysUserModel> userMap = this.sysUserService.selectBaseInfoByIds(leadIds).stream()
                .collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
        Map<Integer, String> projectStepVerifyStatusEnm = ProjectStepStatusEnum.getMap();
        list.forEach(x -> {
            x.setStepVerifyStatusName(projectStepVerifyStatusEnm.get(x.getStepVerifyStatus()));
            SysUserModel tmpModel = userMap.get(x.getLeader());
            if (tmpModel == null) {
                return;
            }
            x.setLeadName(tmpModel.getRealName());
            x.setDeptName(tmpModel.getDeptName());
        });
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectStepModel insertModel(ProjectStepModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectStepMapper.insertSelective(model) >= 0 && projectStepVerifyService.insertByProjectStepModel(model, sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段添加报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectStepModel updateModel(ProjectStepModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectStepMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段添加报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectStepModel deleteModel(ProjectStepModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("阶段删除传入数据报错")
                    .appendAlaramMsg(JSON.toJSONString(model));
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectStepMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段删除报错");
    }

    public ProjectStepVerifyModel verifyProjectStep(ProjectStepVerifyModel model) {
        return this.projectStepVerifyService.updateModel(model);
    }

    public ProjectStepVerifyModel selectVerifyProjectStepDetail(ProjectStepVerifyModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行查询");
        }
        return this.projectStepVerifyService.selectById(model.getId());
    }
    /**
     * 根据项目id查询其项目阶段
     */
    public List<ProjectStepModel> findByProjectId(ProjectStepModel model){
        return projectStepMapper.selectByProjectId(model.getProjectId());
    }

    public List<Map<String, Object>> selectByProjectId(ProjectStepModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("传入的项目id异常，无法进行查询");
        }
        List<ProjectStepVo> list = this.projectStepMapper.selectByModel(model);
        return list.stream().map(x -> new HashMap<String, Object>() {{
            put("value", x.getId().toString());
            put("text", x.getName());
        }}).collect(Collectors.toList());
    }

    public boolean insertOrUpdateList(List<DraftStepVo> draftStepVos, Long projectId) {
        if(draftStepVos == null || projectId == null){
            throw new SystemParamCheckException("参数异常，无法将数据同步到正式数据上");
        }
        List<ProjectStepVo> projectStepVos = new ArrayList<>();
        List<Long> keepStepIds = new ArrayList<>();
        draftStepVos.forEach(x -> {
            projectStepVos.add(new ProjectStepVo(x));
            if(x.getOriginalId() != null){
                keepStepIds.add(x.getOriginalId());
            }
        });
        if(this.updateDeleteStatusOnStepAndStepVerify(projectId, keepStepIds)
                && this.insertOrUpdateOneByOne(projectStepVos)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目交付声明更新失败");
    }

    private boolean updateDeleteStatusOnStepAndStepVerify(Long projectId, List<Long> keepStepIds) {
        if(projectId == null || keepStepIds == null){
            throw new SystemParamCheckException("传入的参数异常，无法进行更新");
        }
        List<ProjectStepModel> projectStepModels = this.projectStepMapper.selectByProjectIdAndKeepSaveIds(projectId, keepStepIds);
        List<Long> needDeleteIds = projectStepModels.stream().map(ProjectStepModel::getId).collect(Collectors.toList());
        if(needDeleteIds.isEmpty()){
            return Boolean.TRUE;
        }
        if(this.projectStepMapper.updateDeleteStatusByIds(needDeleteIds) >= 0
            && this.projectStepVerifyService.deleteByStepIds(needDeleteIds)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("变更数据移除失败");
    }

    private boolean insertOrUpdateOneByOne(List<ProjectStepVo> projectStepVos) {
        if(projectStepVos.isEmpty()){
            return Boolean.TRUE;
        }
        for (int i = 0; i < projectStepVos.size(); i++) {
            this.insertOrUpdateVo(projectStepVos.get(i));
        }
        return Boolean.TRUE;
    }

    private boolean insertOrUpdateVo(ProjectStepVo projectStepVo) {
        if(projectStepVo == null){
            throw new SystemParamCheckException("项目阶段参数异常，无法进行更新");
        }
        if(projectStepVo.getId() == null && this.projectStepMapper.insertSelective(projectStepVo) >= 0){
            Long stepId = projectStepVo.getId();
            List<ProjectStepVerifyModel> tmpList = projectStepVo.getProjectStepVerifyModels();
            tmpList.forEach(x -> x.setStepId(stepId));
            this.projectStepVerifyService.insertList(tmpList);
            return Boolean.TRUE;
        }
        if(this.projectStepMapper.updateByIdSelective(projectStepVo) >= 0){
            List<ProjectStepVerifyModel> tmpList = projectStepVo.getProjectStepVerifyModels();
            tmpList.forEach(x -> this.projectStepVerifyService.updateByIdSelective(x));
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目阶段更新异常");
    }
}