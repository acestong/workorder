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
public class PublishTransmitModel implements Serializable {
//	转发id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
//动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pubishId;
//    转发人ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishTransmitUserId;
//    转发时间
    private Date publishTransmitTime;
//转发内容
    private String publishContent;

    private static final long serialVersionUID = 1L;

}