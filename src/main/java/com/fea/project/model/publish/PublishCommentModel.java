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
public class PublishCommentModel implements Serializable {
//	评论id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishCommentId;
//    业务类型,暂时只有动态模块,通用部分，暂时不使用
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessType;
//    业务ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long businessId;
//    评论人姓名
    private String userName;
//    评论人ID 
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
//    评论时间
    private Date commentTime;
//	评论内容
    private String content;
//评论类型，枚举类型，1为评论，2为回复
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentType;
//是否已读，枚举类型
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long isRead;

    private static final long serialVersionUID = 1L;

   
}