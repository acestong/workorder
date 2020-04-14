package com.fea.project.service.risk;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.risk.ProjectRiskAppendixMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/04.
 */
@Service
public class ProjectRiskAppendixService {

    @Autowired
    private ProjectRiskAppendixMapper projectRiskAppendixMapper;
    @Autowired
    private SysUserService sysUserService;


    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectRiskAppendixModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectRiskAppendixMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRiskAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAppendixMapper.deleteRiskAppendix(model.getId()) >= 0;
    }



    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRiskAppendixMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRiskAppendixMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRiskAppendixModel model) {
        return model != null && this.projectRiskAppendixMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRiskAppendixModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRiskAppendixModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRiskAppendixMapper.insertList(list);
            }
        } else {
            return this.projectRiskAppendixMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectRiskAppendixModel selectById(Long id) {
        return id == null ? null : this.projectRiskAppendixMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectRiskAppendixModel> selectByModel(ProjectRiskAppendixModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRiskAppendixMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRiskAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAppendixMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRiskAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAppendixMapper.updateById(model) == 1;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRiskAppendixModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRiskAppendixMapper.insert(model) == 1;
        }
        return this.projectRiskAppendixMapper.updateById(model) == 1;
    }
}