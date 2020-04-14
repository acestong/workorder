package com.fea.project.api.other.model.login;

import lombok.Data;

import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/17 17:49
 **/
@Data
public class SystemQueryReturnModel {


    private Boolean status;
    private String url;
    private Map<String, Long> map;

}
