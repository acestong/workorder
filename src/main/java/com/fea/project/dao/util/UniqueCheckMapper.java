package com.fea.project.dao.util;

import com.fea.project.model.util.UniqueCheckModel;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 15:44
 **/
public interface UniqueCheckMapper {

    int selectCurrentParamHasUseNo(UniqueCheckModel uniqueCheckModel);

}
