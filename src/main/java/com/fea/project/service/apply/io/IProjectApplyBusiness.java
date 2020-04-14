package com.fea.project.service.apply.io;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/11/19 17:51
 **/
public interface IProjectApplyBusiness {

    Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids);
}
