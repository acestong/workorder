package com.fea.project.model.publish.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishGetViewVo {

	private Long userId;
	private Long regId;
	private Integer type;
}
