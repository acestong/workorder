package com.fea.project.controller.feebudget;


import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.model.base.PdtUnitModel;
import com.fea.project.api.other.model.base.SysCurrencyModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.crm.vo.OrderPaymentInfoVo;
import com.fea.project.api.other.model.crm.vo.OrderPaymentPlanVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.feebudget.ProjectFeeDubgetModel;
import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import com.fea.project.model.feebudget.vo.DubgetChangeGraphVo;
import com.fea.project.model.feebudget.vo.DubgetClassifyVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.feebudget.ProjectFeeDubgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/12/10.
 */
@RestController
@RequestMapping("projectFeeDubget")
public class ProjectFeeDubgetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFeeDubgetController.class);


    @Autowired
    private ProjectFeeDubgetService projectFeeDubgetService;
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 预算信息
     */
    @RequestMapping("detail")
    public ProjectFeeDubgetModel detail(@RequestBody ProjectFeeDubgetModel model) {
        return projectFeeDubgetService.selectById(model.getId());
    }

    /**
     * 新建项目预算
     */
    @RequestMapping("insert")
    public ProjectFeeDubgetModel insert(@RequestBody ProjectFeeDubgetModel model) {
        if (this.projectFeeDubgetService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 分页查询项目预算列表
     */
    @RequestMapping("list")
    public JSONObject show(@RequestBody BasePageInfo<ProjectFeeDubgetModel> model) {
        JSONObject basePageInfo = projectFeeDubgetService.selectByFilterAndOrderParams(model);
        return basePageInfo;
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectFeeDubgetModel update(@RequestBody ProjectFeeDubgetModel model) {
        if (this.projectFeeDubgetService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectFeeDubgetModel delete(@RequestBody ProjectFeeDubgetModel model) {
        if (this.projectFeeDubgetService.deleteProjectFeeDubget(model)) {
            return model;
        }
        return null;
    }

    /**
     *获取费用类型数据字典
     */
    @RequestMapping("/getProjectFeeType")
    public List<ProjectDictionaryItemSelectVo> getProjectRiskType() throws Exception{
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectDictionaryModel projectDictionaryModel = new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_FEE_TYPE.getValue(),
                currentUsr.getRegId());
        List<ProjectDictionaryItemSelectVo> vos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(projectDictionaryModel);
        return vos;
    }
    /**
     * 关联业务合同/关联订单
     */
    @RequestMapping("/selectOrderContract")
    public JSONObject selectOrderContractVo(@RequestBody ProjectFeeDubgetModel model){
        return projectFeeDubgetService.selectOrderContractVo(model);
    }
    /**
     * 项目回款明细
     */
    @RequestMapping("/selectPaymentDetail")
    public JSONObject selectPaymentDetail(@RequestBody ProjectFeeDubgetModel model){
        return projectFeeDubgetService.paymentDetail(model);
    }
    /**
     * 项目回款计划
     */
    @PostMapping("/selectPaymentPlan")
    public JSONObject selectPaymentPlan(@RequestBody ProjectFeeDubgetModel model){
        return projectFeeDubgetService.paymentPlan(model);
    }
    /**
     * 项目预算分类饼图
     */
    @RequestMapping("/dubgetClassify")
    public List<DubgetClassifyVo> dubgetClassify(@RequestBody ProjectFeeDubgetModel model){
        return projectFeeDubgetService.projectFeeDubgetClassify(model);
    }

    /**
     * 预算版本变更
     */
    @PostMapping("/updateVersion")
    public void updateVersion(@RequestBody ProjectFeeDubgetParentModel model){
        projectFeeDubgetService.updateVersionCheck(model);
    }
    /**
     * 预算提交审核
     */
    @RequestMapping("check")
    public void check(@RequestBody ProjectFeeDubgetParentModel model) {
        projectFeeDubgetService.verify(model);
    }

    /**
     * 预算变化曲线图
     */
    @RequestMapping("dubgetChangeGraph")
    public List<DubgetChangeGraphVo> dubgetChangeGraph(@RequestBody ProjectFeeDubgetParentModel model) {
        return projectFeeDubgetService.dubgetChangeGraph(model);
    }

    /**
     * 币种列表
     */
    @RequestMapping("currencyList")
    public List<SysCurrencyModel> currencyList() {
        return projectFeeDubgetService.currencyList();
    }

    /**
     *获取物品单位列表
     */
    @RequestMapping("unitList")
    public List<PdtUnitModel> getUnitList() {
        return projectFeeDubgetService.getUnitList();
    }

}