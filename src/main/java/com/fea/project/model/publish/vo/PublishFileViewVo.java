package com.fea.project.model.publish.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class PublishFileViewVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long fileId;
	private String fileName;
	private String filePath;
}
