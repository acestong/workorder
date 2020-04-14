package com.fea.project.service.role;

import com.fea.project.dao.role.ProjectRoleAuthorityDisableMapper;
import com.fea.project.model.role.ProjectRoleAuthorityDisableModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/18.
 */
@Service
public class ProjectRoleAuthorityDisableService {

    @Autowired
    private ProjectRoleAuthorityDisableMapper projectRoleAuthorityDisableMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleAuthorityDisableMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleAuthorityDisableMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleAuthorityDisableModel model) {
        return model != null && this.projectRoleAuthorityDisableMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleAuthorityDisableModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleAuthorityDisableModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleAuthorityDisableMapper.insertList(list);
            }
        } else {
            return this.projectRoleAuthorityDisableMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleAuthorityDisableModel model) {
        return model != null && this.projectRoleAuthorityDisableMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleAuthorityDisableModel selectById(Long id) {
        return id == null ? null : this.projectRoleAuthorityDisableMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleAuthorityDisableModel> selectByModel(ProjectRoleAuthorityDisableModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleAuthorityDisableMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleAuthorityDisableModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDisableMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleAuthorityDisableModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDisableMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleAuthorityDisableModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityDisableMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleAuthorityDisableModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleAuthorityDisableMapper.insert(model) == 1;
        }
        return this.projectRoleAuthorityDisableMapper.updateById(model) == 1;
    }
}