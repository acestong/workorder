package com.fea.project.service.businessflow;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.businessflow.ProjectBusinessFlowMapper;
import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.businessflow.pojo.ProjectBusinessFlowPojo;
import com.fea.project.model.flow.ProjectFlowListModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/16.
 */
@Service
public class ProjectBusinessFlowService {

    @Autowired
    private ProjectBusinessFlowMapper projectBusinessFlowMapper;

    @Autowired
    private ProjectFlowService projectFlowService;

    @Autowired
    private ProjectBusinessFlowListService projectBusinessFlowListService;

    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFlowVerifyerService;


    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBusinessFlowMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBusinessFlowMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBusinessFlowModel model) {
        return model != null && this.projectBusinessFlowMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBusinessFlowModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBusinessFlowModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBusinessFlowMapper.insertList(list);
            }
        } else {
            return this.projectBusinessFlowMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBusinessFlowModel model) {
        return model != null && this.projectBusinessFlowMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBusinessFlowModel selectById(Long id) {
        return id == null ? null : this.projectBusinessFlowMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBusinessFlowModel> selectByModel(ProjectBusinessFlowModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBusinessFlowMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBusinessFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBusinessFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBusinessFlowModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBusinessFlowModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectBusinessFlowMapper.insert(model) == 1;
        }
        return this.projectBusinessFlowMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectBusinessFlowModel copyFlowToBusiness(ProjectBusinessFlowPojo model) {
        if (model == null || model.getListId() == null || model.getId() == null) {
            throw new SystemParamCheckException("传入的参数异常,无法查询流程信息");
        }
        ProjectFlowVo projectFlowVo = this.projectFlowService.selectOne(new ProjectFlowModel(model.getId()));
        if (projectFlowVo == null) {
            throw new SystemParamCheckException("流程信息不存在,请刷新后重试");
        }
        projectFlowVo.getProjectFlowListModels().add(projectFlowVo.getDefaultFlowModel());
        ProjectBusinessFlowModel projectBusinessFlowModel = new ProjectBusinessFlowModel(projectFlowVo, model);
        List<ProjectFlowListVo> list = projectFlowVo.getProjectFlowListModels();
        if (!list.stream().map(ProjectFlowListModel::getId).collect(Collectors.toList()).contains(model.getListId())) {
            throw new SystemParamCheckException("判定的审批流程走向已经不存在，请重新提交判定");
        }
        if (this.projectBusinessFlowMapper.insertSelective(projectBusinessFlowModel) >= 0
                && this.projectBusinessFlowListService.insertListByProjectFLowList(list, projectBusinessFlowModel.getId())) {
            return projectBusinessFlowModel;
        }
        throw new SystemParamCheckException("项目流程信息同步异常");
    }

}