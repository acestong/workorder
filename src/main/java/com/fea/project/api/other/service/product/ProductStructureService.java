package com.fea.project.api.other.service.product;

import com.fea.project.api.other.dao.product.ProductStructureMapper;
import com.fea.project.api.other.model.product.ProductStructureModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/28.
 * 产品分类表 Service
 */
@Service
public class ProductStructureService {

    @Autowired
    private ProductStructureMapper productStructureMapper;

    /**
     * 按主键选择
     */
    public ProductStructureModel selectById(Long ID) {
        return ID == null ? null : this.productStructureMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<ProductStructureModel> selectByModel(ProductStructureModel model) {
        return model == null ? new ArrayList<>(0) : this.productStructureMapper.selectByModel(model);
    }

    public List<Map<String, Object>> selectProductsByLevel(Long parentId, Long regId) {
        if (regId == null) {
            throw new SystemParamCheckException("传入的组织机构id无效，无法进行产品结构查询");
        }
        List<ProductStructureModel> productStructureModels = this.productStructureMapper.selectByParentId(parentId, regId);
        return productStructureModels.stream().map(x -> {
            Map<String, Object> map = new HashMap<>(2);
            map.put("id", x.getID());
            map.put("name", x.getGROUPNAME());
            return map;
        }).collect(Collectors.toList());
    }

    public List<ProductStructureModel> selectProductsByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入的参数异常，无法进行查询");
        }
        if (ids.isEmpty()) {
            return new ArrayList<>();
        }
        return this.productStructureMapper.selectProductsByIds(ids);
    }
}