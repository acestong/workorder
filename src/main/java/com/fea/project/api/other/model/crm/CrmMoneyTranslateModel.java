package com.fea.project.api.other.model.crm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/6 17:34
 **/
@Data
public class CrmMoneyTranslateModel {

    /**
     * 货币类型
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long currencyId;

    private BigDecimal amount;

    public CrmMoneyTranslateModel(Long currencyId, BigDecimal amount) {
        this.currencyId = currencyId;
        this.amount = amount;
    }
}
