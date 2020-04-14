package com.fea.project.service.flow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.flow.ProjectFlowCopyerMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.flow.ProjectFlowCopyerModel;
import com.fea.project.model.flow.pojo.ProjectFlowCopyerPojo;
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
public class ProjectFlowCopyerService {

    @Autowired
    private ProjectFlowCopyerMapper projectFlowCopyerMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFlowCopyerMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFlowCopyerMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFlowCopyerModel model) {
        return model != null && this.projectFlowCopyerMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFlowCopyerModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFlowCopyerModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFlowCopyerMapper.insertList(list);
            }
        } else {
            return this.projectFlowCopyerMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFlowCopyerModel model) {
        return model != null && this.projectFlowCopyerMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFlowCopyerModel selectById(Long id) {
        return id == null ? null : this.projectFlowCopyerMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFlowCopyerModel> selectByModel(ProjectFlowCopyerModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFlowCopyerMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowCopyerMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowCopyerMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFlowCopyerModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowCopyerMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFlowCopyerModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFlowCopyerMapper.insertSelective(model) >= 0;
        }
        return this.projectFlowCopyerMapper.updateByIdSelective(model) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    boolean insertOrUpdateProjectFlowCopyers(ProjectFlowListPojo model, SysUserModel sysUserModel) {
        List<ProjectFlowCopyerPojo> projectFlowCopyerModels = model.getProjectFlowCopyerModels();
        Long listId = model.getId();
        if (Objects.isNull(listId)) {
            throw new SystemParamCheckException("传入的流程条件id传入异常，无法进行插入");
        }
        projectFlowCopyerModels.forEach(x -> {
            x.setListId(listId);
            x.setUserInfo(sysUserModel, Objects.isNull(x.getId()) ? ActionEnum.INSERT_ACTION : ActionEnum.UPDATE_ACTION);
            x.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        });
        List<Long> cantDeleteIds = projectFlowCopyerModels.stream().filter(x -> !Objects.isNull(x.getId()))
                .map(ProjectFlowCopyerPojo::getId).collect(Collectors.toList());
        if (this.projectFlowCopyerMapper.updateModelDeleteByListIdAndCantDeleteList(new ProjectFlowCopyerModel(sysUserModel)
                , Stream.of(listId).collect(Collectors.toList()), cantDeleteIds) >= 0 && this.insertOrUpdateList(projectFlowCopyerModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目流程抄送人添加异常");
    }

    private boolean insertOrUpdateList(List<ProjectFlowCopyerPojo> projectFlowCopyerModels) {
        for (ProjectFlowCopyerPojo model : projectFlowCopyerModels) {
            this.insertOrUpdate(model);
        }
        return true;
    }

    public boolean deleteByModel(ProjectFlowListPojo model, SysUserModel sysUserModel) {
        if (model == null || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("传入的流程id异常，无法进行删除");
        }
        ProjectFlowCopyerModel projectFlowCopyerModel = new ProjectFlowCopyerModel();
        projectFlowCopyerModel.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        projectFlowCopyerModel.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectFlowCopyerMapper.updateModelDeleteByListIdAndCantDeleteList(projectFlowCopyerModel, model.getIds(), new ArrayList<>()) >= 0) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("数据删除异常，无法进行删除");
    }
}