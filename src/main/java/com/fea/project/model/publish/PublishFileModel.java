package com.fea.project.model.publish;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PublishFileModel implements Serializable {
//	动态附件主键id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
//    内容发布ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pubishId;
//    附件ID
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishFileId;

    private static final long serialVersionUID = 1L;
}