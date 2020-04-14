package com.fea.project.api.other.dao.product;

import com.fea.project.api.other.model.product.ProductStructureModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 * 产品分类表 mapper
 */
public interface ProductStructureMapper {

    /**
     * 按主键选择
     */
    ProductStructureModel selectById(Long ID);

    /**
     * 按模型选择
     */
    List<ProductStructureModel> selectByModel(ProductStructureModel model);

    List<ProductStructureModel> selectByParentId(@Param("parentId") Long parentId, @Param("regId") Long regId);

    List<ProductStructureModel> selectProductsByIds(@Param("list") List<Long> ids);
}