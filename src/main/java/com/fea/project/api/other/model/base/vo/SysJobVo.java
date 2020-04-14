package com.fea.project.api.other.model.base.vo;

import com.fea.project.api.other.model.base.SysJobModel;
import com.fea.project.api.other.model.base.SysUserModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/26.
 * 职位表 实体类
 */
@Data
public class SysJobVo extends SysJobModel {

    private List<SysUserModel> sysUserModels;

}