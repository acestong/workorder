package com.fea.project.model.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskNumModel implements Serializable {
	
//	任务编号id
    private Long id;
//    当前用户id
    private Long curUserId;
//    是否需要开头字母
    private Long isHeadLetter;
//    开头字母
    private String headLetter;
//	是否需要日期
    private Long isDate;
//    当前日期
    private Date today;
//    位数
    private Long digit;
//    当前序列号
    private Long seriesDigit;
//    是否是子计划
    private Long isSonTask;

    private static final long serialVersionUID = 1L;

}