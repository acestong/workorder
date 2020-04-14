package com.fea.project.service.project.view;

import com.fea.project.api.other.service.base.SysDepartmentService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.service.project.view.io.IProjectDefaultViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 10:05
 * 项目类型
 **/
@Service
public class ProjectDeptViewServiceImpl implements IProjectDefaultViewService {

    @Autowired
    private SysDepartmentService sysDepartmentService;


    @Override
    public List<Map<String, Object>> queryParamByParent(Long parentId, Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("组织id传入异常，无法进行查询");
        }
        return this.sysDepartmentService.selectByRegId(regId).stream().map(x -> {
            {
                Map<String, Object> map = new HashMap<>(2);
                map.put("value", x.getDEPID());
                map.put("text", x.getDEPNAME());
                return map;
            }
        }).collect(Collectors.toList());
    }
}
