package com.fea.project.service.flow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.flow.ProjectFlowVerifyerMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.flow.ProjectFlowVerifyerModel;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.model.flow.pojo.ProjectFlowVerifyerPojo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/10/10.
 */
@Service
public class ProjectFlowVerifyerService {

    @Autowired
    private ProjectFlowVerifyerMapper projectFlowVerifyerMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFlowVerifyerMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFlowVerifyerMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFlowVerifyerModel model) {
        return model != null && this.projectFlowVerifyerMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFlowVerifyerModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFlowVerifyerModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFlowVerifyerMapper.insertList(list);
            }
        } else {
            return this.projectFlowVerifyerMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFlowVerifyerModel model) {
        return model != null && this.projectFlowVerifyerMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFlowVerifyerModel selectById(Long id) {
        return id == null ? null : this.projectFlowVerifyerMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFlowVerifyerModel> selectByModel(ProjectFlowVerifyerModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFlowVerifyerMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowVerifyerMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowVerifyerMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFlowVerifyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowVerifyerMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFlowVerifyerModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFlowVerifyerMapper.insertSelective(model) >= 0;
        }
        return this.projectFlowVerifyerMapper.updateById(model) >= 0;
    }

    boolean insertOrUpdateProjectFLowVerifyers(ProjectFlowListPojo model, SysUserModel sysUserModel) {
        List<ProjectFlowVerifyerPojo> projectFlowVerifyerModels = model.getProjectFlowVerifyerModels();
        Long listId = model.getId();
        if (Objects.isNull(listId)) {
            throw new SystemParamCheckException("传入的流程条件id传入异常，无法进行插入");
        }
        projectFlowVerifyerModels.sort(Comparator.comparingInt(x -> x.getIndex() == null ? 0 : x.getIndex()));
        projectFlowVerifyerModels.forEach(x -> {
            x.setListId(listId);
            x.setUserInfo(sysUserModel, Objects.isNull(x.getId()) ? ActionEnum.INSERT_ACTION : ActionEnum.UPDATE_ACTION);
            x.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        });
        List<Long> cantDeleteIds = projectFlowVerifyerModels.stream().filter(x -> !Objects.isNull(x.getId()))
                .map(ProjectFlowVerifyerPojo::getId).collect(Collectors.toList());
        if (this.projectFlowVerifyerMapper.updateModelDeleteByListIdAndCantDeleteList(new ProjectFlowVerifyerModel(sysUserModel)
                , Stream.of(listId).collect(Collectors.toList()), cantDeleteIds) >= 0 && this.insertOrUpdateList(projectFlowVerifyerModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目流程抄送人添加异常");
    }

    private boolean insertOrUpdateList(List<ProjectFlowVerifyerPojo> projectFlowVerifyerModels) {
        ProjectFlowVerifyerPojo lastModel = null;
        for (ProjectFlowVerifyerPojo model : projectFlowVerifyerModels) {
            if (lastModel != null) {
                model.setParentId(lastModel.getId());
            }
            this.insertOrUpdate(model);
            lastModel = model;
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByModel(ProjectFlowListPojo model, SysUserModel sysUserModel) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("传入的流程id异常，无法进行删除");
        }
        ProjectFlowVerifyerModel projectFlowVerifyerModel = new ProjectFlowVerifyerModel();
        projectFlowVerifyerModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectFlowVerifyerModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectFlowVerifyerMapper.updateModelDeleteByListIdAndCantDeleteList(projectFlowVerifyerModel, model.getIds(), new ArrayList<>()) >= 0) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("数据删除异常，无法进行删除");
    }
}