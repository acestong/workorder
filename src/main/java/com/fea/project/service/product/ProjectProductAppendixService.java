package com.fea.project.service.product;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.product.ProjectProductAppendixMapper;

import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.product.ProjectProductAppendixModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/23.
 */
@Service
public class ProjectProductAppendixService {

    @Autowired
    private ProjectProductAppendixMapper projectProductAppendixMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectProductAppendixModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectProductAppendixMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductAppendixModel model) {
        projectProductAppendixMapper.deleteProductAppendix(model.getId());
        return model != null;
    }


    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductAppendixMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductAppendixMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductAppendixModel model) {
        return model != null && this.projectProductAppendixMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductAppendixModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductAppendixModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductAppendixMapper.insertList(list);
            }
        } else {
            return this.projectProductAppendixMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectProductAppendixModel selectById(Long id) {
        return id == null ? null : this.projectProductAppendixMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductAppendixModel> selectByModel(ProjectProductAppendixModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductAppendixMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectProductAppendixMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectProductAppendixMapper.updateById(model) == 1;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductAppendixModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductAppendixMapper.insert(model) == 1;
        }
        return this.projectProductAppendixMapper.updateById(model) == 1;
    }
}