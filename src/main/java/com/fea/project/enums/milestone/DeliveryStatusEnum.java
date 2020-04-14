package com.fea.project.enums.milestone;

public enum DeliveryStatusEnum {
    NO_DELIVERY(0,"未交付"),
    IN_DELIVERING(2,"交付中"),
    SUCCESS_DELIVERY(1,"已交付");

    private Integer code;
    private String text;

    DeliveryStatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public static String queryText(Integer code){
        for (int i = 0; i< DeliveryStatusEnum.values().length; i++){
            DeliveryStatusEnum ase= DeliveryStatusEnum.values()[i];
            if (ase.getCode().equals(code)){
                return ase.getText();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
