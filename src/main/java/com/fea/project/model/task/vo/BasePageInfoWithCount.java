package com.fea.project.model.task.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fea.project.model.BasePageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BasePageInfoWithCount<T> extends BasePageInfo<T> {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
		private Integer totalTask;
	    
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	    private Integer unStartTask;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	    private Integer procedingTask;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	    private Integer finishedTask;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	    private Integer commentedTask;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	    private Integer uncommentedTask;
	
	    public BasePageInfoWithCount(List<T> list) {
	        super(list);
	    } 
	    
}
