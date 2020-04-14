package com.fea.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成任务交付物的编号
 * @author st
 *
 */
public class TaskDeliverProductNumUtil {

	private static int num;
	private static String tempFormat;
	
	public static String getNum() {
		String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
		if(! format .equals(tempFormat)) {
			num= 0;
		}
		tempFormat = format;
		//生成4为序列号
		return "JFW" + format + String.format("%04d", ++num);
	}
}
