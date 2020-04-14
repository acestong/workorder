package com.fea.project.service.project.view.io;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 14:15
 **/
public interface IProjectDefaultViewService {

    List<Map<String, Object>> queryParamByParent(Long parentId, Long regId);
}
