package com.fea.project.service.flow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.flow.ProjectFlowListConditionMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectFlowVerifyTypeEnum;
import com.fea.project.model.flow.ProjectFlowListConditionModel;
import com.fea.project.model.flow.pojo.ProjectFlowListConditionPojo;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/10/10.
 */
@Service
public class ProjectFlowListConditionService {

    @Autowired
    private ProjectFlowListConditionMapper projectFlowListConditionMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFlowListConditionMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFlowListConditionMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFlowListConditionModel model) {
        return model != null && this.projectFlowListConditionMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFlowListConditionModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFlowListConditionModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFlowListConditionMapper.insertList(list);
            }
        } else {
            return this.projectFlowListConditionMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFlowListConditionModel model) {
        return model != null && this.projectFlowListConditionMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFlowListConditionModel selectById(Long id) {
        return id == null ? null : this.projectFlowListConditionMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFlowListConditionModel> selectByModel(ProjectFlowListConditionModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFlowListConditionMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListConditionMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListConditionMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFlowListConditionModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListConditionMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFlowListConditionModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFlowListConditionMapper.insertSelective(model) >= 0;
        }
        return this.projectFlowListConditionMapper.updateByIdSelective(model) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    boolean insertOrUpdateProjectConditions(ProjectFlowListPojo model, SysUserModel sysUserModel, ProjectFlowVerifyTypeEnum projectFlowVerifyTypeEnum) {
        List<ProjectFlowListConditionPojo> projectFlowListConditionModels = model.getProjectFlowListConditionModels();
        Long listId = model.getId();
        if (Objects.isNull(listId)) {
            throw new SystemParamCheckException("流程id传入异常，无法进行条件信息添加");
        }
        if (Objects.equals(projectFlowVerifyTypeEnum, ProjectFlowVerifyTypeEnum.TYPE_DEFAULT)) {
            return true;
        } else if (projectFlowListConditionModels.isEmpty()) {
            throw new SystemParamCheckException("条件流程，新增或是变更时，流程条件为必填项");
        }
        projectFlowListConditionModels.forEach(x -> {
            x.setListId(listId);
            x.setUserInfo(sysUserModel, Objects.isNull(x.getId()) ? ActionEnum.INSERT_ACTION : ActionEnum.UPDATE_ACTION);
            x.setConditionStr(ProjectFlowTypeEnum.getTargetMap(model.getTypeId()).getConditionStr(x));
            x.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        });
        List<Long> cantDeleteIds = projectFlowListConditionModels.stream().filter(x -> x.getId() != null)
                .map(ProjectFlowListConditionModel::getId).collect(Collectors.toList());
        if (this.projectFlowListConditionMapper.updateModelDeleteByListIdAndCantDeleteList(new ProjectFlowListConditionModel(sysUserModel)
                , Stream.of(listId).collect(Collectors.toList()), cantDeleteIds) >= 0 && this.insertOrUpdateList(projectFlowListConditionModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目条件插入异常");
    }

    /**
     * 根据查询的集合确认到底是插入还是更新
     *
     * @param projectFlowListConditionModels
     * @return
     */
    private boolean insertOrUpdateList(List<ProjectFlowListConditionPojo> projectFlowListConditionModels) {
        for (ProjectFlowListConditionModel model : projectFlowListConditionModels) {
            this.insertOrUpdate(model);
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteModel(ProjectFlowListPojo model, SysUserModel sysUserModel) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("传入的流程id异常，无法进行删除");
        }
        ProjectFlowListConditionModel projectFlowListConditionModel = new ProjectFlowListConditionModel();
        projectFlowListConditionModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectFlowListConditionModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectFlowListConditionMapper.updateModelDeleteByListIdAndCantDeleteList(projectFlowListConditionModel, model.getIds(), new ArrayList<>()) >= 0) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("数据删除异常，无法进行删除");
    }
}