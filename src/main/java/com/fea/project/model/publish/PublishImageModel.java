package com.fea.project.model.publish;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PublishImageModel implements Serializable {
	
//	图片主键id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
//动态id
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long publishId;
//图片路径
    private String publishImagePath;

    private static final long serialVersionUID = 1L;

}