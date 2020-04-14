package com.fea.project.service.product;



import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.appendix.ProjectAppendixMapper;
import com.fea.project.dao.product.ProjectProductAppendixMapper;
import com.fea.project.dao.product.ProjectProductMapper;
import com.fea.project.dao.product.ProjectProductSpecificMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.product.ProjectProductAppendixModel;
import com.fea.project.model.product.ProjectProductModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.model.product.ProjectProductSpecificModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/19.
 */
@Service
public class ProjectProductService {

    @Autowired
    private ProjectProductMapper projectProductMapper;
    @Autowired
    private ProjectProductAppendixService projectProductAppendixService;
    @Autowired
    private ProjectProductAppendixMapper projectProductAppendixMapper;
    @Autowired
    private ProjectProductSpecificMapper projectProductSpecificMapper;
    @Autowired
    private ProjectAppendixMapper projectAppendixMapper;
    @Autowired
    private SysUserService sysUserService;


    /**
     * 新增产品详情
     */
    public boolean insertSelective(ProjectProductModel model) {
        if (model == null ){
            throw new SystemParamCheckException("参数传入错误");
        }
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setRegId(currentUsr.getRegId());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        this.projectProductMapper.insertSelective(model);
        //新增附件表
        Long id = model.getId();
        List<Long> appendixIds = model.getAppendixIds();
        appendixIds.forEach(temp ->{
            ProjectProductAppendixModel appendix=new ProjectProductAppendixModel();
            appendix.setAppendixId(temp);
            appendix.setBusinessId(id);
            appendix.setBusinessName("产品图片");
            projectProductAppendixService.insertSelective(appendix);
        });
        return model != null;
    }


    /**
     * 产品详情
     */
    public ProjectProductModel detail(ProjectProductModel model) {
        ProjectProductModel productModel = projectProductMapper.selectByModel(model).get(0);
        Long productId = productModel.getId();
        //产品图片列表
        List<ProjectProductAppendixModel> pictureList = projectProductAppendixMapper.selectByModel(
                ProjectProductAppendixModel.builder().businessId(productId).businessName("产品图片").build());
        pictureList.forEach(picture->{
            ProjectAppendixModel appendixModel = projectAppendixMapper.selectById(picture.getAppendixId());
            picture.setRealName(appendixModel.getRealName());
            picture.setUrl(appendixModel.getUrl());
        });
        productModel.setPictureList(pictureList);
        //产品规格型号列表
        List<ProjectProductSpecificModel> specificModels = projectProductSpecificMapper.selectByModel(
                ProjectProductSpecificModel.builder().productId(productId).build());
        //产品规格型号下的附件列表
        specificModels.forEach(temp->{
            List<ProjectProductAppendixModel> appendixModels = projectProductAppendixMapper.selectByModel(
                    ProjectProductAppendixModel.builder().businessId(temp.getId()).build());
            appendixModels.forEach(appendix->{
                ProjectAppendixModel appendixModel = projectAppendixMapper.selectById(appendix.getAppendixId());
                appendix.setRealName(appendixModel.getRealName());
                appendix.setUrl(appendixModel.getUrl());
            });
            temp.setAppendixModels(appendixModels);
        });
        productModel.setSpecificModels(specificModels);
        //产品详情附件列表
        List<ProjectProductAppendixModel> detailsAppendixs = projectProductAppendixMapper.selectByModel(
                ProjectProductAppendixModel.builder().businessId(productId).businessName("产品详情").build());
        detailsAppendixs.forEach(detailsAppendix->{
            ProjectAppendixModel appendixModel = projectAppendixMapper.selectById(detailsAppendix.getAppendixId());
            detailsAppendix.setRealName(appendixModel.getRealName());
            detailsAppendix.setUrl(appendixModel.getUrl());
        });
        productModel.setDetailsAppendixList(detailsAppendixs);
        return productModel;
    }


    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新人
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectProductMapper.updateByIdSelective(model) == 1;
    }


    /**
     * 按主键选择
     */
    public ProjectProductModel selectById(Long id) {
        return id == null ? null : this.projectProductMapper.selectById(id);
    }


    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductModel model) {
        return model != null && this.projectProductMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductMapper.insertList(list);
            }
        } else {
            return this.projectProductMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductModel> selectByModel(ProjectProductModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductMapper.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductModel model) {
        return !(model == null || model.getId() == null) && this.projectProductMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductModel model) {
        return !(model == null || model.getId() == null) && this.projectProductMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductMapper.insert(model) == 1;
        }
        return this.projectProductMapper.updateById(model) == 1;
    }
}