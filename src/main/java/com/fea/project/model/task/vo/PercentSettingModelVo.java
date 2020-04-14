package com.fea.project.model.task.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentSettingModelVo {

	  /*
     * 条件枚举键
     */
    private Long actionId;

    /*
     * 条件枚举值 < > = 等等
     */
    private String actionName;
    /*
     * 级别枚举键 
     */
    private Long estimateId;

    /*
     * 级别枚举值 优异 优秀 合格 差 极差
     */
    private String estimateName;
    
    private Double value;
}
