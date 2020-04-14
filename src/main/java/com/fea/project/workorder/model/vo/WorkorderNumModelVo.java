package com.fea.project.workorder.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 编号生成model
 * @author st
 * @since
 *
 */
@Data
@AllArgsConstructor
public class WorkorderNumModelVo {

	private String num;
	
	private Date date;
	
	public WorkorderNumModelVo() {
		this.date = new Date();
	}
}
