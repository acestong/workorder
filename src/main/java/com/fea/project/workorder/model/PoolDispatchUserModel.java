package com.fea.project.workorder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolDispatchUserModel implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dispatchId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long poolId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long autoDispatchId;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    private String userName;

    private Long workorderCount;
    
    private static final long serialVersionUID = 1L;
}