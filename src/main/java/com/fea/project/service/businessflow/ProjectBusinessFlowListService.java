package com.fea.project.service.businessflow;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.businessflow.ProjectBusinessFlowListMapper;
import com.fea.project.model.businessflow.ProjectBusinessFlowListModel;
import com.fea.project.model.businessflow.pojo.ProjectBusinessFlowListPojo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
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
public class ProjectBusinessFlowListService {

    @Autowired
    private ProjectBusinessFlowListMapper projectBusinessFlowListMapper;

    @Autowired
    private ProjectBusinessFlowCopyerService projectBusinessFlowCopyerService;

    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFlowVerifyerService;

    @Autowired
    private ProjectBusinessFlowListConditionService projectBusinessFlowListConditionService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectBusinessFlowListMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectBusinessFlowListMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectBusinessFlowListModel model) {
        return model != null && this.projectBusinessFlowListMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectBusinessFlowListModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectBusinessFlowListModel> list : ListUtil.getSubList(models, 100)) {
                this.projectBusinessFlowListMapper.insertList(list);
            }
        } else {
            return this.projectBusinessFlowListMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectBusinessFlowListModel model) {
        return model != null && this.projectBusinessFlowListMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectBusinessFlowListModel selectById(Long id) {
        return id == null ? null : this.projectBusinessFlowListMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectBusinessFlowListModel> selectByModel(ProjectBusinessFlowListModel model) {
        return model == null ? new ArrayList<>(0) : this.projectBusinessFlowListMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectBusinessFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectBusinessFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectBusinessFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectBusinessFlowListMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectBusinessFlowListModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectBusinessFlowListMapper.insert(model) == 1;
        }
        return this.projectBusinessFlowListMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertListByProjectFLowList(List<ProjectFlowListVo> list, Long businessFlowId) {
        List<ProjectBusinessFlowListPojo> projectBusinessFlowListModels = list.stream()
                .map(x -> new ProjectBusinessFlowListPojo(x, businessFlowId)).collect(Collectors.toList());
        projectBusinessFlowListModels.forEach(x -> {
            if (this.projectBusinessFlowListMapper.insertSelective(x) >= 0
                    && this.projectBusinessFlowCopyerService.insertListWithListId(x.getProjectBusinessFlowCopyerModels(), businessFlowId)
                    && this.projectBusinessFlowVerifyerService.insertListWithListId(x.getProjectBusinessFlowVerifyerModels(), businessFlowId)
                    && this.projectBusinessFlowListConditionService.insertListWithListId(x.getProjectBusinessFlowListConditionModels(), businessFlowId)) {
                return;
            }
            throw new SystemParamCheckException("流程数据同步异常");
        });
        return Boolean.TRUE;
    }
}