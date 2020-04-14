package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PlanNameInfoModelVO {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planId;
	private String planName; 
}
 