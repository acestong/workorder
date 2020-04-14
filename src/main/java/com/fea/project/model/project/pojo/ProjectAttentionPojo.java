package com.fea.project.model.project.pojo;

import lombok.Data;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/30 11:27
 * 项目关注model
 **/
@Data
public class ProjectAttentionPojo {

    private Long id;
    //true为关注，false取消关注
    private Boolean attention;

}
