package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProjectUserIdAndNameInfoModelVO {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long projectId;
	private String projectName;
	private Long projectManagerId;
	private String projectManagerName;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamId;
	private String teamName; 
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamLeaderId;
	private String teamLeaderName;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long userId;
	private String userName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long planType;
}
 