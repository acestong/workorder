package com.fea.project.api.other.model.base.vo;

import com.fea.project.api.other.model.base.SysDepartmentModel;
import com.fea.project.api.other.model.base.SysEmployeeModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/15 18:01
 **/
@Data
public class SysDepartmentVo extends SysDepartmentModel {

    private List<SysEmployeeModel> sysEmployeeModelList;

}
