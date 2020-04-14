package com.fea.project.model.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.product.ProjectProductAppendixModel;
import lombok.Data;

import java.util.List;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/3/26 14:43
 **/
@Data
public class ProductDetailVo {
    //产品id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    //产品名称
    private String name;
    //产品分类
    private String classify;
    //产品类型
    private String type;
    //主单位
    private String unit;
    //产品图片列表
    private List<ProjectProductAppendixModel> pictureList;
    //产品说明
    private String description;
    //产品性能
    private String performance;
    //产品结构
    private String structure;
    //产品适用范围
    private String scope;
    //产品规格型号列表
    private List<ProjectProductAppendixModel> specificAppendixList;
    //产品需求背景
    private String background;
    //产品详情附件列表
    private List<ProjectProductAppendixModel> detailsAppendixList;
}
