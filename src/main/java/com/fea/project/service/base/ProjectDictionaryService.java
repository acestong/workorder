package com.fea.project.service.base;

import com.fea.project.dao.base.ProjectDictionaryMapper;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/09/25.
 */
@Service
public class ProjectDictionaryService {

    @Autowired
    private ProjectDictionaryMapper projectDictionaryMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectDictionaryMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectDictionaryMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectDictionaryModel model) {
        return model != null && this.projectDictionaryMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectDictionaryModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectDictionaryModel> list : ListUtil.getSubList(models, 100)) {
                this.projectDictionaryMapper.insertList(list);
            }
        } else {
            return this.projectDictionaryMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectDictionaryModel model) {
        return model != null && this.projectDictionaryMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectDictionaryModel selectById(Long id) {
        return id == null ? null : this.projectDictionaryMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectDictionaryModel> selectByModel(ProjectDictionaryModel model) {
        return model == null ? new ArrayList<>(0) : this.projectDictionaryMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectDictionaryModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectDictionaryModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectDictionaryModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectDictionaryModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectDictionaryMapper.insert(model) == 1;
        }
        return this.projectDictionaryMapper.updateById(model) == 1;
    }

    /**
     * 查询所有系统内置以及跟当前组织相关的
     *
     * @return
     */
    public List<ProjectDictionaryModel> listAll() {
        Long regId = UserUtil.getUserRegId();
        return this.projectDictionaryMapper.selectByRegId(regId);
    }
}