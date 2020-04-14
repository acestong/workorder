package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectStepVerifyMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.project.ProjectActionStatusEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.project.ProjectStepVerifyModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2019/11/06.
 */
@Service
public class ProjectStepVerifyService {

    @Autowired
    private ProjectStepVerifyMapper projectStepVerifyMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectStepVerifyMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectStepVerifyMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectStepVerifyModel model) {
        return model != null && this.projectStepVerifyMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectStepVerifyModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectStepVerifyModel> list : ListUtil.getSubList(models, 100)) {
                this.projectStepVerifyMapper.insertList(list);
            }
        } else {
            return this.projectStepVerifyMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectStepVerifyModel model) {
        return model != null && this.projectStepVerifyMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectStepVerifyModel selectById(Long id) {
        return id == null ? null : this.projectStepVerifyMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectStepVerifyModel> selectByModel(ProjectStepVerifyModel model) {
        return model == null ? new ArrayList<>(0) : this.projectStepVerifyMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectStepVerifyMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectStepVerifyMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectStepVerifyMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectStepVerifyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectStepVerifyMapper.insert(model) == 1;
        }
        return this.projectStepVerifyMapper.updateById(model) == 1;
    }

    boolean insertByProjectStepModel(ProjectStepModel model, SysUserModel sysUserModel) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目阶段新增异常");
        }
        ProjectStepVerifyModel projectStepVerifyModel = new ProjectStepVerifyModel(model);
        projectStepVerifyModel.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if (this.projectStepVerifyMapper.insertSelective(projectStepVerifyModel) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("项目阶段新增异常");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectStepVerifyModel updateModel(ProjectStepVerifyModel model) {
        //检查一下当前项目状态，如果该项目未审核通过，无法进行确认
        ProjectModel projectModel = this.projectService.selectModelByStepId(model.getStepId());
        if (!ProjectActionStatusEnum.TYPE_RUNNING.getValue().equals(projectModel.getActionStatus())) {
            throw new SystemParamCheckException("当前项目状态无法进行阶段确认");
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setStatus(ProjectStepStatusEnum.TYPE_FINISH.getValue());
        model.setVerifyInfo(sysUserModel);
        if (this.projectStepVerifyMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("确认过程异常，无法进行确认");
    }

    public List<ProjectStepVerifyModel> selectByStepIds(List<Long> stepIds) {
        if(Objects.isNull(stepIds)){
            throw new SystemParamCheckException("传入的阶段id无效，无法进行查询");
        }
        if(stepIds.isEmpty()){
            return Collections.emptyList();
        }
        return this.projectStepVerifyMapper.selectByStepIds(stepIds);
    }

    public boolean deleteByStepIds(List<Long> stepIds) {
        if(stepIds == null){
            throw new SystemParamCheckException("阶段id传入异常，无法进行删除");
        }
        if(stepIds.isEmpty()){
            return Boolean.TRUE;
        }
        return this.projectStepVerifyMapper.deleteByStepIds(stepIds) >= 0;
    }
}