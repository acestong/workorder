package com.fea.project.model.config.pojo;

import com.fea.project.model.config.ProjectConfigModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/10/08.
 */
@Data
public class ProjectConfigPojo extends ProjectConfigModel {

    /**
     * 0为正常，1为立项
     */
    private Integer isEstablish;

}