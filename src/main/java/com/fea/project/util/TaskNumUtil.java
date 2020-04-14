package com.fea.project.util;

import com.fea.project.enums.task.IsDateEnum;
import com.fea.project.enums.task.IsHeadLetterEnum;
import com.fea.project.model.task.TaskNumModel;
import com.fea.project.model.task.vo.TaskNumModelVo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成任务编号(不包含项目任务)
 * @author st
 *
 */
public class TaskNumUtil {

	
	public static String getNum(TaskNumModel taskNumModel) {
		TaskNumModelVo taskNumModelVo = new TaskNumModelVo();
		String day = new SimpleDateFormat("yyyyMMdd").format(taskNumModel.getToday());
		String headLetter = "";
		if(taskNumModel.getIsHeadLetter() == IsHeadLetterEnum.IS_HEAD_LETTER.getStatus().longValue()) {
			headLetter = taskNumModel.getHeadLetter();
		}
		String date = "";
		if(taskNumModel.getIsDate() == IsDateEnum.IS_DATE.getStatus().longValue()) {
			date = day;
		}
		Integer seriesDigit = 1;
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		if(today.equals(day)) {
			seriesDigit = taskNumModel.getSeriesDigit().intValue();
		}
		//生成4为序列号
		return headLetter + date + String.format("%0"+taskNumModel.getDigit()+"d", seriesDigit);
	}
}
