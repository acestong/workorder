package com.fea.project.model.publish;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PublishLikeModel implements Serializable {
//	赞id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishLikeId;
//动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//    点赞人姓名
    private String userName;
//    点赞人ID
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
//    点赞时间
    private Date publishLikeTime;
//    是否已读，未读为0，已读为1
    private Long isRead;

    private static final long serialVersionUID = 1L;

}