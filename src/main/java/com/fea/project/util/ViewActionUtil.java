package com.fea.project.util;

import com.fea.project.enums.base.ProjectListActionEnum;
import com.fea.project.enums.base.ProjectNumberActionEnum;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 10:57
 **/
public class ViewActionUtil {

    public static final List<Map<String, Object>> projectViewListActionList = ProjectListActionEnum.getMap();
    public static final List<Map<String, Object>> projectViewNumberActionList = ProjectNumberActionEnum.getMap();

    public static List<Map<String, Object>> getProjectViewListActionList() {
        return projectViewListActionList;
    }

    public static List<Map<String, Object>> getProjectViewNumberActionList() {
        return projectViewNumberActionList;
    }
}
