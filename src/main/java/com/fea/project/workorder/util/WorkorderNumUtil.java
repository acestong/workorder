package com.fea.project.workorder.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成任务编号(不包含项目任务)
 * @author st
 *
 */
public class WorkorderNumUtil {

	private static Map<String,String> map = new HashMap<>();
	private static Integer digit = 1;
	
	public static String getNum() {
		String head = "GD";
		String todatMap = map.get("today");
		String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
		 if(todatMap == null) {
			 map.put("today", format);
		 }
		 else if(!todatMap.equals(format)){
			digit = 1;
		}else {
			digit ++;
		}
		 map.put("today", format);
		String num = head + format +String.format("%05d", digit);
		System.out.println(">>>>>>>>>>>>>>>>>>"+num);
		return num;
	}
	
}
