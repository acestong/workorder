package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysOrgRegisterModel;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 * 组织注册表 mapper
 */
public interface SysOrgRegisterMapper {

    /**
     * 按主键选择
     */
    SysOrgRegisterModel selectById(Long REGID);

    /**
     * 按模型选择
     */
    List<SysOrgRegisterModel> selectByModel(SysOrgRegisterModel model);

}