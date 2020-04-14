package com.fea.project.service.config;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigEstimatePercentMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.config.ProjectConfigEstimatePercentModel;
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
public class ProjectConfigEstimatePercentService {

    @Autowired
    private ProjectConfigEstimatePercentMapper projectConfigEstimatePercentMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConfigEstimatePercentMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConfigEstimatePercentMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConfigEstimatePercentModel model) {
        return model != null && this.projectConfigEstimatePercentMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigEstimatePercentModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConfigEstimatePercentModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConfigEstimatePercentMapper.insertList(list);
            }
        } else {
            return this.projectConfigEstimatePercentMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConfigEstimatePercentModel model) {
        return model != null && this.projectConfigEstimatePercentMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConfigEstimatePercentModel selectById(Long id) {
        return id == null ? null : this.projectConfigEstimatePercentMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConfigEstimatePercentModel> selectByModel(ProjectConfigEstimatePercentModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConfigEstimatePercentMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConfigEstimatePercentModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimatePercentMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConfigEstimatePercentModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimatePercentMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConfigEstimatePercentModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimatePercentMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectConfigEstimatePercentModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectConfigEstimatePercentMapper.insert(model) == 1;
        }
        return this.projectConfigEstimatePercentMapper.updateById(model) == 1;
    }

    public List<ProjectConfigEstimatePercentModel> selectByBusinessId(Long businessId, Integer typeId) {
        if (businessId == null || typeId == null) {
            return new ArrayList<>();
        }
        return this.projectConfigEstimatePercentMapper.selectByModel(new ProjectConfigEstimatePercentModel(businessId, typeId));
    }

    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean deleteByBusinessIdAndInsertList(Long businessId, List<ProjectConfigEstimatePercentModel> projectConfigEstimatePercentModels) {
        if (businessId == null) {
            throw new SystemParamCheckException("交付物权重分数设置保存报错，传入参数异常");
        }
        if (this.projectConfigEstimatePercentMapper.deleteByBusinessId(businessId) >= 0) {
            for (ProjectConfigEstimatePercentModel projectConfigEstimatePercentModel : projectConfigEstimatePercentModels) {
                this.insertModel(projectConfigEstimatePercentModel);
            }
            return true;
        }
        throw new SystemParamCheckException("权重分数更新报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectConfigEstimatePercentModel insertModel(ProjectConfigEstimatePercentModel projectConfigEstimatePercentModel) {
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        projectConfigEstimatePercentModel.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        projectConfigEstimatePercentModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        if (this.projectConfigEstimatePercentMapper.insertSelective(projectConfigEstimatePercentModel) >= 0) {
            return projectConfigEstimatePercentModel;
        }
        throw new SystemParamCheckException("权重分数更新报错");
    }
}