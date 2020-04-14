package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PageInfoFromFrontModel {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long pageNum;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long pageSize; 
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planId; 
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planTransferId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long businessId;//与planId相同作用，通用化
}
 