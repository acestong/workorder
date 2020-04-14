package com.fea.project.service.project.view;

import com.fea.project.api.other.service.product.ProductStructureService;
import com.fea.project.service.project.view.io.IProjectDefaultViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/28 14:16
 * 项目产品
 **/
@Service
public class ProjectProductViewServiceImpl implements IProjectDefaultViewService {

    @Autowired
    private ProductStructureService productStructureService;

    @Override
    public List<Map<String, Object>> queryParamByParent(Long parentId, Long regId) {
        return productStructureService.selectProductsByLevel(parentId, regId);
    }
}
