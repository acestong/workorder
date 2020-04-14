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
public class PublishCollectModel implements Serializable {
//	收藏id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishCollectId;
//    动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//	收藏人姓名
    private String userName;
//    收藏人ID
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
//    收藏时间
    private Date createTime;

    private static final long serialVersionUID = 1L;

}