package com.fea.project.service.util;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.util.UniqueCheckMapper;
import com.fea.project.model.util.UniqueCheckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/9/20 15:43
 **/
@Service
public class UniqueCheckService {

    @Autowired
    private UniqueCheckMapper uniqueCheckMapper;

    public boolean checkCurrentParamIsUnique(UniqueCheckModel uniqueCheckModel) throws SystemParamCheckException {
        if (uniqueCheckModel == null) {
            throw new SystemParamCheckException("传入的检查参数唯一性的对象无效");
        }
        return this.uniqueCheckMapper.selectCurrentParamHasUseNo(uniqueCheckModel) == 0;
    }

}
