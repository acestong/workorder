package com.fea.project.service.project;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectConcernMapper;
import com.fea.project.model.project.ProjectConcernModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/09/23.
 * 项目关注表 Service
 */
@Service
public class ProjectConcernService {

    @Autowired
    private ProjectConcernMapper projectConcernMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectConcernMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectConcernMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectConcernModel model) {
        return model != null && this.projectConcernMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectConcernModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectConcernModel> list : ListUtil.getSubList(models, 100)) {
                this.projectConcernMapper.insertList(list);
            }
        } else {
            return this.projectConcernMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectConcernModel model) {
        return model != null && this.projectConcernMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectConcernModel selectById(Long id) {
        return id == null ? null : this.projectConcernMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectConcernModel> selectByModel(ProjectConcernModel model) {
        return model == null ? new ArrayList<>(0) : this.projectConcernMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectConcernModel model) {
        return !(model == null || model.getId() == null) && this.projectConcernMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectConcernModel model) {
        return !(model == null || model.getId() == null) && this.projectConcernMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectConcernModel model) {
        return !(model == null || model.getId() == null) && this.projectConcernMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectConcernModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectConcernMapper.insert(model) == 1;
        }
        return this.projectConcernMapper.updateById(model) == 1;
    }

    public ProjectConcernModel selectByProjectIdAndUserId(Long projectId, Long userId) {
        if (projectId == null || userId == null) {
            throw new SystemParamCheckException("项目关注数据查询报错").appendAlaramMsg(projectId + "-" + userId);
        }
        return this.projectConcernMapper.selectByProjectIdAndUserId(projectId, userId);
    }
}