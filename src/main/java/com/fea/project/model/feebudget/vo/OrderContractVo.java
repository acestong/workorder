package com.fea.project.model.feebudget.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: fangfan
 * @version: 1.0
 * @date: 2019/12/12 15:58
 **/
@Data
@Builder
public class OrderContractVo {
    private String num;
    private String name;
    private Long customId;
    private String customName;
    private BigDecimal money;
    private Long saleId;
    private String saleName;
    private Date time;
    private Long contractId;
    private String contractName;

}
