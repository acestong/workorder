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
public class PublishCommentReplyModel implements Serializable {
//评论回复id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishCommentReplyId;
//评论id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishCommentId;
//    被回复人ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
//    被回复人姓名
    private String userName;
//    回复人ID
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long replyUserId;
//    回复人姓名
    private String replyUserName;
//    回复时间
    private Date replyTime;
//    回复内容
    private String replyContent;

    private static final long serialVersionUID = 1L;

}