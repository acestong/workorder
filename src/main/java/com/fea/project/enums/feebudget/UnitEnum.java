package com.fea.project.enums.feebudget;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2020/1/15 10:16
 **/
public enum UnitEnum {
    GE(1L,"个"),
    TAI(2L,"台"),
    ZHANG(3L,"张"),
    PING(4L,"瓶"),
    TAO(5L,"套"),
    ZHI(6L,"只"),
    JIAN(7L,"件"),
    BA(8L,"把"),
    BAO(9L,"包"),
    HE(10L,"盒"),
    JIN(11L,"斤");


    private Long id;
    private String text;


    UnitEnum(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
