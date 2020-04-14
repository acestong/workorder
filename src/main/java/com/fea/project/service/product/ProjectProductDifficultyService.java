package com.fea.project.service.product;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.appendix.ProjectAppendixMapper;
import com.fea.project.dao.product.ProjectProductAppendixMapper;
import com.fea.project.dao.product.ProjectProductDifficultyMapper;

import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.product.ProjectProductAppendixModel;
import com.fea.project.model.product.ProjectProductDifficultyModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/23.
 */
@Service
public class ProjectProductDifficultyService {

    @Autowired
    private ProjectProductDifficultyMapper projectProductDifficultyMapper;
    @Autowired
    private ProjectProductAppendixService projectProductAppendixService;
    @Autowired
    private ProjectProductAppendixMapper projectProductAppendixMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectAppendixMapper projectAppendixMapper;

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectProductDifficultyModel model) {
        if (model == null ){
            throw new SystemParamCheckException("参数传入错误");
        }
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        this.projectProductDifficultyMapper.insertSelective(model);
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
     *分页查询项目风险列表
     */
    public BasePageInfo<ProjectProductDifficultyModel> selectByFilterAndOrderParams(BasePageInfo<ProjectProductDifficultyModel> model){
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectProductDifficultyModel> difficultyModels = projectProductDifficultyMapper.selectByFilterAndParams(new PageInfoQueryOrderAndFilterModel<>(model));
        for (ProjectProductDifficultyModel difficulty:difficultyModels){
            List<ProjectProductAppendixModel> appendixs = projectProductAppendixMapper.selectByModel(
                    ProjectProductAppendixModel.builder().businessId(difficulty.getId()).build());
            appendixs.forEach(temp ->{
                ProjectAppendixModel projectAppendixModel = projectAppendixMapper.selectById(temp.getAppendixId());
                temp.setUrl(projectAppendixModel.getUrl());
                temp.setRealName(projectAppendixModel.getRealName());
            });
            difficulty.setAppendixModels(appendixs);
        }


        return new BasePageInfo<>(difficultyModels);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductDifficultyModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新人
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectProductDifficultyMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductDifficultyModel model) {
        return !(model == null || model.getId() == null) && this.projectProductDifficultyMapper.deleteProductDifficulty(model.getId()) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductDifficultyMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductDifficultyMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductDifficultyModel model) {
        return model != null && this.projectProductDifficultyMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductDifficultyModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductDifficultyModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductDifficultyMapper.insertList(list);
            }
        } else {
            return this.projectProductDifficultyMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectProductDifficultyModel selectById(Long id) {
        return id == null ? null : this.projectProductDifficultyMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductDifficultyModel> selectByModel(ProjectProductDifficultyModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductDifficultyMapper.selectByModel(model);
    }


    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductDifficultyModel model) {
        return !(model == null || model.getId() == null) && this.projectProductDifficultyMapper.updateById(model) == 1;
    }


    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductDifficultyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductDifficultyMapper.insert(model) == 1;
        }
        return this.projectProductDifficultyMapper.updateById(model) == 1;
    }
}