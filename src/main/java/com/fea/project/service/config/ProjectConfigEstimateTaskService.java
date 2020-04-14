package com.fea.project.service.config;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigEstimateTaskMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.config.ProjectConfigEstimateTaskModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
@Service
public class ProjectConfigEstimateTaskService {

    @Autowired
    private ProjectConfigEstimateTaskMapper projectConfigEstimateTaskMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConfigEstimateTaskMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConfigEstimateTaskMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConfigEstimateTaskModel model) {
        return model != null && this.projectConfigEstimateTaskMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigEstimateTaskModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConfigEstimateTaskModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConfigEstimateTaskMapper.insertList(list);
            }
        } else {
            return this.projectConfigEstimateTaskMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConfigEstimateTaskModel model) {
        return model != null && this.projectConfigEstimateTaskMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConfigEstimateTaskModel selectById(Long id) {
        return id == null ? null : this.projectConfigEstimateTaskMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConfigEstimateTaskModel> selectByModel(ProjectConfigEstimateTaskModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConfigEstimateTaskMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConfigEstimateTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateTaskMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConfigEstimateTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateTaskMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConfigEstimateTaskModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateTaskMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigEstimateTaskModel insertOrUpdate(ProjectConfigEstimateTaskModel model) {
        if (model == null) {
            throw new SystemParamCheckException("任务权重设置更新,参数校验失败");
        }
        if (model.getId() == null) {
            return this.insertModel(model);
        }
        return this.updateModel(model);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigEstimateTaskModel updateModel(ProjectConfigEstimateTaskModel model) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectConfigEstimateTaskMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("任务权重设置更新失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigEstimateTaskModel insertModel(ProjectConfigEstimateTaskModel model) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectConfigEstimateTaskMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("任务权重设置新增失败");
    }

    public ProjectConfigEstimateTaskModel selectByTaskId(Long taskId) {
        if (taskId == null) {
            return null;
        }
        List<ProjectConfigEstimateTaskModel> list = this.projectConfigEstimateTaskMapper
                .selectByModel(new ProjectConfigEstimateTaskModel(taskId));
        return list.isEmpty() ? null : list.get(0);
    }
}