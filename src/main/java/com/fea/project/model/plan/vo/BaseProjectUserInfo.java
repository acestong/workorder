package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BaseProjectUserInfo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long projectId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long userId; 
}
 