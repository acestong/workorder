package com.fea.project.workorder.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeModelVo {

	private Long typeId;
	
	private String typeName;
	
	private List<TypeModelVo> children;
}
