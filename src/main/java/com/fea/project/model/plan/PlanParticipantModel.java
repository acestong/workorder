package com.fea.project.model.plan;

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
public class PlanParticipantModel implements Serializable {
	 @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planPanticipantId;

	 @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planId;

	 @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planPaticipantUserId;
	 
	 private String userName;

    private static final long serialVersionUID = 1L;

}