package com.fea.project.model.establishproject.pojo;

import com.fea.project.model.establishproject.projectresource.ProjectEstablishResourceHumanModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/10 15:04
 **/
@Data
public class ProjectEstablishResourceHumanPojo extends ProjectEstablishResourceHumanModel{

    private List<Long> userIds;
}
