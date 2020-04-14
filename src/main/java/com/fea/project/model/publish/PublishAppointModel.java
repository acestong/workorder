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
public class PublishAppointModel implements Serializable {
	
//	 @提醒id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishAppointId;
//	 @动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//    @提醒用户id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishAppointUserId;
//    @提醒用户名
    private String publishAppointUserName;
//    创建人id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createId;
//    创建人名
    private String createBy;
//    创建时间
    private Date createTime;
//    是否已读，未读为0，已读为1
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long isRead;

    private static final long serialVersionUID = 1L;
}