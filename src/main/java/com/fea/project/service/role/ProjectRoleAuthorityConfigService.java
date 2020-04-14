package com.fea.project.service.role;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.role.ProjectRoleAuthorityConfigMapper;
import com.fea.project.model.role.ProjectRoleAuthorityConfigModel;
import com.fea.project.model.role.ProjectRoleAuthorityDetailModel;
import com.fea.project.util.ListUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2019/09/23.
 */
@Service
public class ProjectRoleAuthorityConfigService {

    @Autowired
    private ProjectRoleAuthorityConfigMapper projectRoleAuthorityConfigMapper;


    @Autowired
    private ProjectRoleAuthorityDetailService projectRoleAuthorityDetailService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRoleAuthorityConfigMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRoleAuthorityConfigMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRoleAuthorityConfigModel model) {
        return model != null && this.projectRoleAuthorityConfigMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRoleAuthorityConfigModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRoleAuthorityConfigModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRoleAuthorityConfigMapper.insertList(list);
            }
        } else {
            return this.projectRoleAuthorityConfigMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRoleAuthorityConfigModel model) {
        return model != null && this.projectRoleAuthorityConfigMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectRoleAuthorityConfigModel selectById(Long id) {
        return id == null ? null : this.projectRoleAuthorityConfigMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRoleAuthorityConfigModel> selectByModel(ProjectRoleAuthorityConfigModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRoleAuthorityConfigMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRoleAuthorityConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityConfigMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRoleAuthorityConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityConfigMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRoleAuthorityConfigModel model) {
        return !(model == null || model.getId() == null) && this.projectRoleAuthorityConfigMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRoleAuthorityConfigModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRoleAuthorityConfigMapper.insert(model) == 1;
        }
        return this.projectRoleAuthorityConfigMapper.updateById(model) == 1;
    }

    public List<ProjectRoleAuthorityConfigModel> selectByRoleId(Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("角色id传入异常，无法进行查询");
        }
        return this.projectRoleAuthorityConfigMapper.selectByModel(new ProjectRoleAuthorityConfigModel(roleId));
    }

    public boolean deleteByRoleId(@Param("roleId") Long roleId) {
        if (roleId == null) {
            throw new SystemParamCheckException("角色id传入异常，无法进行查询");
        }
        return this.projectRoleAuthorityConfigMapper.deleteByRoleId(roleId) >= 0;
    }


    public List<ProjectRoleAuthorityConfigModel> selectByProjectIdAndUserId(Long projectId, Long userId) {
        if(Objects.isNull(projectId) || Objects.isNull(userId)){
            throw new SystemParamCheckException("传入的参数异常，请刷新后重试");
        }
        return this.projectRoleAuthorityConfigMapper.selectByProjectIdAndUserId(projectId, userId);
    }
}