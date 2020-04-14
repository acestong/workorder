package com.fea.project.controller.feebudget;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.model.feebudget.ReimburseModel;
import com.fea.project.model.feebudget.vo.DubgetVsFeeClassifyVo;
import com.fea.project.model.feebudget.vo.DubgetVsFeeVo;
import com.fea.project.model.feebudget.vo.FeeClassifyVo;
import com.fea.project.service.feebudget.ReimburseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 报销管理模块表 Controller
 */
@RestController
@RequestMapping("reimburse")
public class ReimburseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReimburseController.class);


    @Autowired
    private ReimburseService reimburseService;

    /**
     * 费用控制统计图
     */
    @RequestMapping("dubgetVsFee")
    public DubgetVsFeeVo dubgetVsFee(@RequestBody ReimburseModel model) {
        DubgetVsFeeVo dubgetVsFeeVo = reimburseService.dubgetVsFee(model);
        return dubgetVsFeeVo;
    }

    /**
     * 费用类型统计图
     */
    @RequestMapping("dubgetVsFeeClassify")
    public JSONObject dubgetVsFeeClassify(@RequestBody ReimburseModel model) {
        return reimburseService.dubgetVsFeeClassify(model);
    }

    /**
     * 实际支出费用占比饼图
     */
    @RequestMapping("feeClassify")
    public List<FeeClassifyVo> feeClassify(@RequestBody ReimburseModel model) {
        List<FeeClassifyVo> feeClassifyVos = reimburseService.feeClassify(model);
        return feeClassifyVos;
    }

    /**
     * 项目预算-成本对比图
     */
    @RequestMapping("dubgetVsCost")
    public JSONObject dubgetVsCost(@RequestBody ReimburseModel model) {
        JSONObject jsonObject = reimburseService.dubgetVsCost(model);
        return jsonObject;
    }


    /**
     * 报销-采购费用-物料费用
     */
    @RequestMapping("purchaseMaterial")
    public JSONObject purchaseMaterial(@RequestBody ReimburseModel model) {
        JSONObject jsonObject = reimburseService.purchaseMaterial(model);
        return jsonObject;
    }

    /**
     * 报销-采购费用-其他费用
     */
    @RequestMapping("purchaseOther")
    public JSONObject purchaseOther(@RequestBody ReimburseModel model) {
        JSONObject jsonObject = reimburseService.purchaseOther(model);
        return jsonObject;
    }

    /**
     * 报销-日常费用
     */
    @RequestMapping("daily")
    public JSONObject daily(@RequestBody ReimburseModel model) {
        return reimburseService.daily(model);
    }

    /**
     * 报销-出差费用
     */
    @RequestMapping("travel")
    public JSONObject travel(@RequestBody ReimburseModel model) {
        return reimburseService.travel(model);
    }

    /**
     * 人工成本
     */
    @RequestMapping("humanCost")
    public JSONObject human(@RequestBody ReimburseModel model) {
        JSONObject jsonObject = reimburseService.selectHumanCost(model);
        return jsonObject;

    }

}