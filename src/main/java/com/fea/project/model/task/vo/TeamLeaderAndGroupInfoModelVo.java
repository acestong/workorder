package com.fea.project.model.task.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TeamLeaderAndGroupInfoModelVo {

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long teamId;
	private String teamName;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Long groupLeaderId; 
	private String groupLeaderName;
}
