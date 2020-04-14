package com.fea.project.enums.product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */

public enum SwotTypeEnum {

    PRODUCT_COMPETITIVE_STENGTHS(1,"竞争优势"),
    PRODUCT_COMPETITIVE_WEAKNESS(2,"竞争劣势"),
    PRODUCT_EXTERNAL_OPPORTUNITY(3,"外部机会"),
    PRODUCT_SO_STRATEGY(4,"SO战略"),
    PRODUCT_WO_STRATEGY(5,"WO战略"),
    PRODUCT_EXTERNAL_THREATS(6,"外部威胁"),
    PRODUCT_ST_STRATEGY(7,"ST战略"),
    PRODUCT_WT_STRATEGY(8,"WT战略");

    private Integer type;
    private String text;

    SwotTypeEnum(Integer type, String text) {
        this.type = type;
        this.text = text;
    }

    public Integer getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        SwotTypeEnum[] enums = SwotTypeEnum.values();
        for (SwotTypeEnum tmp : enums) {
            map.put(tmp.getType(), tmp.getText());
        }
        return map;
    }
}
