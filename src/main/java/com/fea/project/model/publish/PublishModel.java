package com.fea.project.model.publish;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PublishModel implements Serializable {
//	动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//    发布人姓名
    private String userName;
//    发布人id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
//    发布时间
    private Date createTime;
//    发布来源类型（1 PC 2 Iphone 3 Android）来源于枚举
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long originType;
//    发布地点
    private String place;
//    发布内容
    private String content;
//    是否全公司发布（0 否 1是）
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long isCompanyPublish;
//    注册组织ID
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long regId;
//    相关业务类型，详见constant对象，老系统再用，暂时不用 预留接口，转发而来或者创建而来
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessType;
//    相关业务id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;
//    项目id，有则填，非项目id则不需要填
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long projectId;
//  是否是转发的动态
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long isTransmitedPublish;
//    如果是转发的动态，则需传入转发的动态id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long transmitedPublishId;

    private static final long serialVersionUID = 1L;

}