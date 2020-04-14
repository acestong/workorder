package com.fea.project.service.config;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.config.ProjectConfigEstimateCloseMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.config.ProjectCloseTypeEnum;
import com.fea.project.model.config.ProjectConfigEstimateCloseModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/08.
 */
@Service
public class ProjectConfigEstimateCloseService {

    @Autowired
    private ProjectConfigEstimateCloseMapper projectConfigEstimateCloseMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConfigEstimateCloseMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConfigEstimateCloseMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConfigEstimateCloseModel model) {
        return model != null && this.projectConfigEstimateCloseMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConfigEstimateCloseModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConfigEstimateCloseModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConfigEstimateCloseMapper.insertList(list);
            }
        } else {
            return this.projectConfigEstimateCloseMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConfigEstimateCloseModel model) {
        return model != null && this.projectConfigEstimateCloseMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConfigEstimateCloseModel selectById(Long id) {
        return id == null ? null : this.projectConfigEstimateCloseMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConfigEstimateCloseModel> selectByModel(ProjectConfigEstimateCloseModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConfigEstimateCloseMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConfigEstimateCloseModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateCloseMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConfigEstimateCloseModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateCloseMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConfigEstimateCloseModel model) {
        return !(model == null || model.getId() == null) && this.projectConfigEstimateCloseMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectConfigEstimateCloseModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectConfigEstimateCloseMapper.insert(model) == 1;
        }
        return this.projectConfigEstimateCloseMapper.updateById(model) == 1;
    }

    public List<ProjectConfigEstimateCloseModel> selectByCloseIdAndTypeId(Long closeId, Integer typeId) {
        if (closeId == null || typeId == null) {
            return new ArrayList<>();
        }
        return this.projectConfigEstimateCloseMapper.selectByModel(new ProjectConfigEstimateCloseModel(closeId, typeId));
    }

    public boolean deleteByBusinessIdAndTypeIdThenInsertList(Long closeId, Integer typeId, List<ProjectConfigEstimateCloseModel> projectConfigEstimateCloseModels) {
        if (closeId == null || typeId == null) {
            throw new SystemParamCheckException("传入的结项id以及类型id异常");
        }
        if (this.projectConfigEstimateCloseMapper.deleteByCloseId(closeId) >= 0) {
            if (ListUtil.isNullOrEmpty(projectConfigEstimateCloseModels)) {
                return true;
            }
            SysUserModel userModel = this.sysUserService.getCurrentUsr();
            //对数据进行判定，如果按照阶段，判定阶段参数id以及阶段权重是否一致
            projectConfigEstimateCloseModels.forEach(tmp -> {
                if (ProjectCloseTypeEnum.TYPE_STEP.getValue().equals(typeId) &&
                        (tmp.getStepId() == null || tmp.getStepWeight() == null)) {
                    throw new SystemParamCheckException("结项阶段设置时，阶段id以及权重为必填项");
                }
                tmp.setUserInfo(userModel, ActionEnum.INSERT_ACTION);
                tmp.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
                tmp.setCloseId(closeId);
            });
            if (this.insertList(projectConfigEstimateCloseModels)) {
                return true;
            }
        }
        throw new SystemParamCheckException("结项参数更新失败");
    }
}