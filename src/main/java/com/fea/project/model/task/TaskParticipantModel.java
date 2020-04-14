package com.fea.project.model.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskParticipantModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskPanticipantId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskPaticipantUserId;

    private static final long serialVersionUID = 1L;

  
}