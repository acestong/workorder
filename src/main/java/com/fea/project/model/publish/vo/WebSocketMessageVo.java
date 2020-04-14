package com.fea.project.model.publish.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebSocketMessageVo {

	private Integer pageSize;
	private Integer pageNum;
	private Integer type;
	private Long businessId;
	private Long businessType;
}
