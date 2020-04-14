package com.fea.project.model.flow;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/14 10:11
 **/
@Data
public class PersonSelectParamModel {

    private Object selectList;
    private List<Map<String, Object>> signatureTypes;
}
