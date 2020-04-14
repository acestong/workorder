package com.fea.project.model.plan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TeamLeaderAndGroupInfoModelVO {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamId;
	private String teamName;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long groupLeaderId;
	private String groupLeaderName; 
}
 