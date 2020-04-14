package com.fea.project.service.baseconfig;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodeShortNameMapper;
import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/27.
 */
@Service
public class ProjectCodeShortNameService {

    @Autowired
    private ProjectCodeShortNameMapper projectCodeShortNameMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectCodeShortNameMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectCodeShortNameMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectCodeShortNameModel model) {
        return model != null && this.projectCodeShortNameMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectCodeShortNameModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectCodeShortNameModel> list : ListUtil.getSubList(models, 100)) {
                this.projectCodeShortNameMapper.insertList(list);
            }
        } else {
            return this.projectCodeShortNameMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectCodeShortNameModel model) {
        return model != null && this.projectCodeShortNameMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectCodeShortNameModel selectById(Long id) {
        return id == null ? null : this.projectCodeShortNameMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectCodeShortNameModel> selectByModel(ProjectCodeShortNameModel model) {
        return model == null ? new ArrayList<>(0) : this.projectCodeShortNameMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectCodeShortNameModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeShortNameMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectCodeShortNameModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeShortNameMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectCodeShortNameModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeShortNameMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectCodeShortNameModel model) {
        if (model == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行更新");
        }
        if (model.getId() == null) {
            return this.projectCodeShortNameMapper.insertSelective(model) == 1;
        }
        return this.projectCodeShortNameMapper.updateByIdSelective(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    Boolean insertOrUpdateList(List<ProjectCodeShortNameModel> projectCodeShortNameModels, Long projectCodeId) {
        if (projectCodeId == null || projectCodeShortNameModels == null) {
            throw new SystemParamCheckException("传入的参数异常，无法添加项目编号简称");
        }
        List<Long> shortNameIds = projectCodeShortNameModels.stream().filter(x -> x.getId() != null)
                .map(ProjectCodeShortNameModel::getId).collect(Collectors.toList());
        if (this.projectCodeShortNameMapper.deleteByCodeIdAndIdNotInIds(projectCodeId, shortNameIds) >= 0
                && this.insertOrUpdateOneByOne(projectCodeShortNameModels)) {
            return true;
        }
        throw new SystemParamCheckException("项目简称更新失败");
    }

    private boolean insertOrUpdateOneByOne(List<ProjectCodeShortNameModel> projectCodeShortNameModels) {
        for (ProjectCodeShortNameModel projectCodeShortNameModel : projectCodeShortNameModels) {
            if (StringUtil.isEmpty(projectCodeShortNameModel.getShortCode())) {
                continue;
            }
            this.insertOrUpdate(projectCodeShortNameModel);
        }
        return true;
    }
}