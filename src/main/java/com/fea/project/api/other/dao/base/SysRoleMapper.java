package com.fea.project.api.other.dao.base;

import com.fea.project.api.other.model.base.SysRoleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/11/14.
 * 角色表 mapper
 */
public interface SysRoleMapper {

    /**
     * 按主键选择
     */
    SysRoleModel selectById(Long ROLEID);

    /**
     * 按模型选择
     */
    List<SysRoleModel> selectByModel(SysRoleModel model);


    List<SysRoleModel> selectByIds(@Param("list") List<Long> roleIds);
}