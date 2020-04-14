package com.fea.project.model.establishproject.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.model.project.ProjectModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/8 14:13
 **/
@Data
public class ProjectEstablishProjectStartModel {

    @PrimaryKey(field = "id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    protected Date planStartTime;

    protected Date planEndTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected BigDecimal duration;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long leader;

}
