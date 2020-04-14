package com.fea.project.service.product;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.product.ProjectProductSpecificMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.product.ProjectProductAppendixModel;
import com.fea.project.model.product.ProjectProductSpecificModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2020/03/20.
 */
@Service
public class ProjectProductSpecificService {

    @Autowired
    private ProjectProductSpecificMapper projectProductSpecificMapper;
    @Autowired
    private ProjectProductAppendixService projectProductAppendixService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增产品规格
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertSelective(ProjectProductSpecificModel model) {
        if (model == null ){
            throw new SystemParamCheckException("参数传入错误");
        }
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        this.projectProductSpecificMapper.insertSelective(model);
        //新增附件表
        Long id = model.getId();
        List<Long> appendixIds = model.getAppendixIds();
        appendixIds.forEach(temp ->{
            ProjectProductAppendixModel appendix=new ProjectProductAppendixModel();
            appendix.setAppendixId(temp);
            appendix.setBusinessId(id);
            projectProductAppendixService.insertSelective(appendix);
        });
        return model != null;
    }


    /**
     * 编辑
     */
    public boolean updateByIdSelective(ProjectProductSpecificModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新人
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectProductSpecificMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductSpecificMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductSpecificMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductSpecificModel model) {
        return model != null && this.projectProductSpecificMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductSpecificModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductSpecificModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductSpecificMapper.insertList(list);
            }
        } else {
            return this.projectProductSpecificMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectProductSpecificModel selectById(Long id) {
        return id == null ? null : this.projectProductSpecificMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductSpecificModel> selectByModel(ProjectProductSpecificModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductSpecificMapper.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductSpecificModel model) {
        return !(model == null || model.getId() == null) && this.projectProductSpecificMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductSpecificModel model) {
        return !(model == null || model.getId() == null) && this.projectProductSpecificMapper.deleteProductSpecific(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductSpecificModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductSpecificMapper.insert(model) == 1;
        }
        return this.projectProductSpecificMapper.updateById(model) == 1;
    }
}