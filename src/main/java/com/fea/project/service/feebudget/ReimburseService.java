package com.fea.project.service.feebudget;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.dao.base.SysUserMapper;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.base.ProjectDictionaryItemMapper;
import com.fea.project.dao.feebudget.ProjectFeeDubgetMapper;
import com.fea.project.dao.feebudget.ProjectFeeDubgetParentMapper;
import com.fea.project.dao.feebudget.ReimburseMapper;
import com.fea.project.dao.feebudget.TallyMapper;
import com.fea.project.dao.role.ProjectRoleMapper;
import com.fea.project.dao.task.TaskModelMapper;
import com.fea.project.dao.task.TaskWorkReportModelMapper;
import com.fea.project.dao.user.ProjectUserMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.feebudget.FeeTypeEnum;
import com.fea.project.enums.feebudget.IsDraftEnum;
import com.fea.project.enums.feebudget.MaterialEnum;
import com.fea.project.enums.feebudget.ReimbTypeEnum;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.feebudget.*;
import com.fea.project.model.feebudget.vo.*;
import com.fea.project.model.role.ProjectRoleModel;
import com.fea.project.model.task.TaskModel;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 报销管理模块表 Service
 */
@Service
public class ReimburseService {

    @Autowired
    private ReimburseMapper reimburseMapper;
    @Autowired
    private TallyMapper tallyMapper;
    @Autowired
    private ProjectUserMapper projectUserMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ProjectRoleMapper projectRoleMapper;
    @Autowired
    private TaskModelMapper taskModelMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectFeeDubgetMapper projectFeeDubgetMapper;
    @Autowired
    private ProjectDictionaryItemMapper projectDictionaryItemMapper;
    @Autowired
    private TaskWorkReportModelMapper taskWorkReportModelMapper;
    @Autowired
    private ProjectFeeDubgetService projectFeeDubgetService;
    @Autowired
    private ProjectFeeCostService projectFeeCostService;
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;
    @Autowired
    private ProjectFeeDubgetParentMapper projectFeeDubgetParentMapper;

    /**
     *费用控制统计图
     */
    public DubgetVsFeeVo dubgetVsFee(ReimburseModel model){
        DubgetVsFeeVo dubgetVsFeeVo=new DubgetVsFeeVo();
        BigDecimal dubgetAmount=BigDecimal.ZERO;//预算总额
        //查询最新版本的预算总额-已审核通过+不是草稿
        ProjectFeeDubgetParentModel parentModel = new ProjectFeeDubgetParentModel();
        parentModel.setIsDraft(IsDraftEnum.NOT_DRAFT.getCode());
        parentModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
        List<ProjectFeeDubgetParentModel> parentModels = projectFeeDubgetParentMapper.selectByModel(parentModel);
        if (parentModels.isEmpty()){
            parentModel.setIsDraft(IsDraftEnum.CHANGED.getCode());
            parentModels = projectFeeDubgetParentMapper.selectByModel(parentModel);
        }
        Long parentId = parentModels.get(0).getId();
        List<ProjectFeeDubgetModel> list = projectFeeDubgetService.projectFeeDubgetList(model.getBillId());
        for (ProjectFeeDubgetModel feeDubgetModel:list){
            if (feeDubgetModel.getParentId()==parentId || feeDubgetModel.getParentId().equals(parentId)){
                dubgetAmount=dubgetAmount.add(feeDubgetModel.getAmount());
            }

        }
        dubgetVsFeeVo.setBudgetAmount(dubgetAmount);
        BigDecimal humanCost = new BigDecimal(this.selectHumanCost(model).get("totalAmount").toString());//人工成本
        BigDecimal purchaseMaterial = new BigDecimal(this.purchaseMaterial(model).get("totalAmount").toString());//物料费用
        BigDecimal purchaseOther = new BigDecimal(this.purchaseOther(model).get("totalAmount").toString());//其他费用
        BigDecimal daily = new BigDecimal(this.daily(model).get("totalAmount").toString());//日常费用
        BigDecimal travel = new BigDecimal(this.travel(model).get("totalAmount").toString());//出差费用
        BigDecimal feeAmount=humanCost.add(purchaseMaterial).add(purchaseOther).add(daily).add(travel);
        dubgetVsFeeVo.setProportion(feeAmount.divide(dubgetAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"");//占比
        dubgetVsFeeVo.setFeeAmount(feeAmount);//费用总额
        dubgetVsFeeVo.setSurplusAmount(dubgetAmount.subtract(feeAmount));
        return dubgetVsFeeVo;
    }


    /**
     * 实际支出费用占比饼图
     */
    public List<FeeClassifyVo> feeClassify(ReimburseModel model){
        List<FeeClassifyVo> feeClassifyVos=new ArrayList<>();
        BigDecimal humanCost = new BigDecimal(this.selectHumanCost(model).get("totalAmount").toString());//人工成本
        BigDecimal purchaseMaterial = new BigDecimal(this.purchaseMaterial(model).get("totalAmount").toString());//物料费用
        BigDecimal purchaseOther = new BigDecimal(this.purchaseOther(model).get("totalAmount").toString());//其他费用
        BigDecimal daily = new BigDecimal(this.daily(model).get("totalAmount").toString());//日常费用
        BigDecimal travel = new BigDecimal(this.travel(model).get("totalAmount").toString());//出差费用
        //新增物料成本总计金额
        BigDecimal materialCost = this.materialCost(model);
        //新增其他成本总计金额
        BigDecimal otherCost = this.otherCost(model);
        feeClassifyVos.add(new FeeClassifyVo(FeeTypeEnum.HUMAN.getText(),humanCost));//人工成本
        feeClassifyVos.add(new FeeClassifyVo(FeeTypeEnum.REIMB.getText(),daily.add(travel)));//报销费用
        feeClassifyVos.add(new FeeClassifyVo(FeeTypeEnum.MATERIAL.getText(),purchaseMaterial.add(materialCost)));//物料成本
        feeClassifyVos.add(new FeeClassifyVo(FeeTypeEnum.OTHER.getText(),purchaseOther.add(otherCost)));//其他成本
        return feeClassifyVos;
    }

    /**
     * 费用类型统计图
     */
    public JSONObject dubgetVsFeeClassify(ReimburseModel model){
        List<DubgetVsFeeClassifyVo> dubgetVsFeeClassifyVos=new ArrayList<>();
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        Long projectId = model.getBillId();
        //几种费用类型
        ProjectDictionaryModel projectDictionaryModel=new ProjectDictionaryModel();
        projectDictionaryModel.setRegId(currentUsr.getRegId());
        projectDictionaryModel.setShortName(DictionaryTypeEnum.PROJECT_FEE_TYPE.getValue());
        List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(projectDictionaryModel);
        //几种费用类型的类型名称，金额
        for (ProjectDictionaryItemSelectVo temp:projectDictionaryItemSelectVos){
            DubgetVsFeeClassifyVo vo=new DubgetVsFeeClassifyVo();
            ProjectFeeDubgetParentModel parentModel = new ProjectFeeDubgetParentModel();
            parentModel.setIsDraft(IsDraftEnum.NOT_DRAFT.getCode());
            parentModel.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
            List<ProjectFeeDubgetParentModel> parentModels = projectFeeDubgetParentMapper.selectByModel(parentModel);
            if (parentModels.isEmpty()){
                parentModel.setIsDraft(IsDraftEnum.CHANGED.getCode());
                parentModels = projectFeeDubgetParentMapper.selectByModel(parentModel);
            }
            Long parentId = parentModels.get(0).getId();
            List<ProjectFeeDubgetModel> projectFeeDubgetModels = projectFeeDubgetMapper.selectByModel(
                    ProjectFeeDubgetModel.builder().type(Long.parseLong(projectDictionaryItemMapper.selectById(temp.getId()).getId().toString())).projectId(projectId).parentId(parentId).build());
            BigDecimal amount=BigDecimal.ZERO;
            for (ProjectFeeDubgetModel dubgetModel:projectFeeDubgetModels){
                amount = amount.add(dubgetModel.getAmount());
            }
            vo.setFeeType(temp.getName());//费用类型
            vo.setDubgetAmount(amount);//预算金额
            BigDecimal reimburAmount=BigDecimal.ZERO;//实际支出金额
            if(temp.getName().equals(FeeTypeEnum.HUMAN.getText())){
                reimburAmount = new BigDecimal(this.selectHumanCost(model).get("totalAmount").toString());
            }else if(temp.getName().equals(FeeTypeEnum.DAILY.getText())){
                reimburAmount = new BigDecimal(this.daily(model).get("totalAmount").toString());
            }else if(temp.getName().equals(FeeTypeEnum.TRAVEL.getText())){
                reimburAmount = new BigDecimal(this.travel(model).get("totalAmount").toString());
            }else if(temp.getName().equals(FeeTypeEnum.MATERIAL.getText())){
                reimburAmount = new BigDecimal(this.purchaseMaterial(model).get("totalAmount").toString()).add(this.materialCost(model));
            }else if(temp.getName().equals(FeeTypeEnum.OTHER.getText())){
                reimburAmount = new BigDecimal(this.purchaseOther(model).get("totalAmount").toString()).add(this.otherCost(model));
            }
            vo.setReimburAmount(reimburAmount);
            vo.setSurplusAmount(amount.subtract(reimburAmount));//剩余预算
            if (amount.compareTo(BigDecimal.ZERO)!=0){
                vo.setProportion(reimburAmount.divide(amount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"%");//占比
            }else {
                vo.setProportion("0");
            }
            dubgetVsFeeClassifyVos.add(vo);
        }
        JSONObject jsonObject = new JSONObject();
        BigDecimal dubgetAmountTotal=BigDecimal.ZERO;
        BigDecimal reimburAmountTotal=BigDecimal.ZERO;
        String totalProportion=null;
        for (DubgetVsFeeClassifyVo vo:dubgetVsFeeClassifyVos){
            dubgetAmountTotal=dubgetAmountTotal.add(vo.getDubgetAmount());
            reimburAmountTotal=reimburAmountTotal.add(vo.getReimburAmount());
        }
        BigDecimal surplusAmountTotal=dubgetAmountTotal.subtract(reimburAmountTotal);
        if (dubgetAmountTotal.compareTo(BigDecimal.ZERO)!=0){
            totalProportion=reimburAmountTotal.divide(dubgetAmountTotal, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString();
        }else {
            totalProportion="0";
        }
        jsonObject.put("list",dubgetVsFeeClassifyVos);
        jsonObject.put("dubgetAmountTotal",dubgetAmountTotal);
        jsonObject.put("reimburAmountTotal",reimburAmountTotal);
        jsonObject.put("surplusAmountTotal",surplusAmountTotal);
        jsonObject.put("totalProportion",totalProportion);
        return jsonObject;
    }

    /**
     * 项目预算-成本对比图
     */

    public JSONObject dubgetVsCost(ReimburseModel model){
        List<DubgetVsCostVo> dubgetVsCostVos=new ArrayList<>();
        //日期List
        List<ReimburseModel> reimburseModelList = reimburseMapper.selectDateList(Byte.valueOf("6"), model.getBillId());
        reimburseModelList.forEach(temp->{ Date applyDate = temp.getApplyDate();
            DubgetVsCostVo dubgetVsCostVo = new DubgetVsCostVo();
            dubgetVsCostVo.setDate(applyDate);//报销日期
            //累计成本金额
            dubgetVsCostVo.setAccumulativeAmount(this.selectAccumulativeAmount(model.getBillId(),applyDate));
            dubgetVsCostVo.setHumanCost(BigDecimal.ZERO);//人工成本
            BigDecimal businessCost = this.businessCost(model.getBillId(), applyDate);
            dubgetVsCostVo.setBusinessCost(businessCost);//差旅费1
            BigDecimal dailyCost = this.dailyCost(model.getBillId(), applyDate);
            dubgetVsCostVo.setDailyCost(dailyCost);//日常费用2
            BigDecimal materialCost = this.materialCost(applyDate, model);
            dubgetVsCostVo.setMaterialCost(materialCost);//物料费用3
            BigDecimal otherCost = this.otherCost(applyDate, model);
            dubgetVsCostVo.setOtherCost(otherCost);//其他费用3
            //当天成本金额
            dubgetVsCostVo.setTodayAmount(businessCost.add(dailyCost).add(materialCost).add(otherCost));
            dubgetVsCostVos.add(dubgetVsCostVo);

        });
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("budgetAmount",this.dubgetVsFee(model).getBudgetAmount());
        jsonObject.put("feeAmount",this.dubgetVsFee(model).getFeeAmount());
        jsonObject.put("list",dubgetVsCostVos);
        return jsonObject;

    }

    /**
     * 当天出差费用
     */
    public BigDecimal businessCost(Long projectId, Date date){
        List<ReimburseModel> reimburseModels = reimburseMapper.selectByModel(
                ReimburseModel.builder().billId(projectId).applyDate(date).reimbType(ReimbTypeEnum.BUSINESS.getCode().byteValue()).build());
        BigDecimal businessCost=BigDecimal.ZERO;
        for (ReimburseModel model:reimburseModels){
            businessCost=businessCost.add(new BigDecimal(model.getMoney().toString()));
        }
        return businessCost;
    }

    /**
     * 当天日常费用
     */
    public BigDecimal dailyCost(Long projectId, Date date){
        List<ReimburseModel> reimburseModels = reimburseMapper.selectByModel(
                ReimburseModel.builder().billId(projectId).applyDate(date).reimbType(ReimbTypeEnum.EVERYDAY.getCode().byteValue()).build());
        BigDecimal dailyCost=BigDecimal.ZERO;
        for (ReimburseModel model:reimburseModels){
            dailyCost=dailyCost.add(new BigDecimal(model.getMoney().toString()));
        }
        return dailyCost;
    }

    /**
     * 截止当前的累计报销额
     */
    public BigDecimal selectAccumulativeAmount(Long projectId, Date date){
        List<ReimburseModel> reimburseModels = reimburseMapper.selectByModel(ReimburseModel.builder().billId(projectId).build());
        BigDecimal accumulativeAmount=BigDecimal.ZERO;
        for (ReimburseModel model:reimburseModels){
            if (model.getApplyDate().compareTo(date)==-1 ||model.getApplyDate().compareTo(date)==0){
                accumulativeAmount=accumulativeAmount.add(new BigDecimal(model.getMoney().toString()));
            }
        }
        return accumulativeAmount;

    }

    /**
     * 新增物料成本总计金额
     */
    public BigDecimal materialCost(ReimburseModel model){
        ProjectFeeCostModel projectFeeCostModel=new ProjectFeeCostModel();
        projectFeeCostModel.setProjectId(model.getBillId());
        BigDecimal materialCost=BigDecimal.ZERO;
        List<ProjectFeeCostModel> projectFeeCostModels = projectFeeCostService.materialCostList(projectFeeCostModel);
        for (ProjectFeeCostModel feeCostModel:projectFeeCostModels){
            materialCost=materialCost.add(feeCostModel.getCost());
        }
        return materialCost;
    }

    /**
     * 新增其他成本总计金额
     */
    public BigDecimal otherCost(ReimburseModel model){
        ProjectFeeCostModel projectFeeCostModel=new ProjectFeeCostModel();
        projectFeeCostModel.setProjectId(model.getBillId());
        BigDecimal otherCost=BigDecimal.ZERO;
        List<ProjectFeeCostModel> feeCostModels = projectFeeCostService.otherCostlList(projectFeeCostModel);
        for (ProjectFeeCostModel feeCostModel:feeCostModels){
            if (feeCostModel.getCost()!=null){
                otherCost=otherCost.add(feeCostModel.getCost());
            }

        }
        return otherCost;
    }


    /**
     * 人工成本
     */
    public JSONObject selectHumanCost(ReimburseModel model){
        List<HumanCostVo> humanCostVos=new ArrayList<>();
        //项目下人员id的list
        List<Long> longs = projectUserMapper.selectByProjectId(model.getBillId());
        longs.forEach(userId->{
            HumanCostVo humanCostVo=new HumanCostVo();
            humanCostVo.setUserId(userId);//人员id
            humanCostVo.setName(sysUserMapper.selectById(userId).getRealName());//人员名称
            ProjectRoleModel projectRoleModel = projectRoleMapper.selectRoleNameAndCostByUserId(userId);
            if (projectRoleModel!=null){
                humanCostVo.setRole(projectRoleModel.getName());//角色名称
                humanCostVo.setCost(projectRoleModel.getCost());//人天成本
                Long hour = this.selectHourByUserId(userId);//实际工时(小时)
                humanCostVo.setHour(hour);
                if (hour != 0) {
                    humanCostVo.setTotalCost(projectRoleModel.getCost().divide(new BigDecimal("8")).multiply(new BigDecimal(hour)));//实际成本
                    humanCostVos.add(humanCostVo);
                }
            }
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (HumanCostVo humanCostVo:humanCostVos){
            totalAmount=totalAmount.add(humanCostVo.getTotalCost());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("humanCostVos",humanCostVos);
        jsonObject.put("totalAmount",totalAmount);
        return jsonObject;

    }

    /**
     * 人员实际工时
     */
    public Long selectHourByUserId(Long userId){
        List<TaskModel> taskModels = taskModelMapper.selectTaskIdByUserId(userId);
        Long actualTaskDuration=0l;
        for (TaskModel taskModel:taskModels){
            TaskWorkReportModel model = taskWorkReportModelMapper.selectLatestOneByTaskId(taskModel.getTaskId());
            if (model!=null){
                actualTaskDuration=actualTaskDuration+model.getActualTaskDuration();
            }
        }
        return actualTaskDuration;
    }

    /**
     * 报销-采购费用-物料费用
     */
    public JSONObject purchaseMaterial(ReimburseModel model){
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        List<ReimburseModel> reimburseModels = reimburseMapper.selectPurchase(model);
        List<ReimburseVo> reimburseVoList = this.modelChangeVo(reimburseModels);
        reimburseVoList.forEach(temp ->{
            if (MaterialEnum.ASSET_PURCHASE.getText().equals(temp.getFeeType())){
                reimburseVos.add(temp);
            }
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVos){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reimburseVos",reimburseVos);
        jsonObject.put("totalAmount",totalAmount);
        return jsonObject;
    }

    /**
     * 当天物料费用
     */
    public BigDecimal materialCost(Date date,ReimburseModel model){
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        List<ReimburseModel> reimburseModels = reimburseMapper.selectPurchase(model);
        List<ReimburseVo> reimburseVoList = this.modelChangeVo(reimburseModels);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        reimburseVoList.forEach(temp ->{
            if (MaterialEnum.ASSET_PURCHASE.getText().equals(temp.getFeeType()) && df.format(date).compareTo(df.format(temp.getApplyTime()))==0){
                reimburseVos.add(temp);
            }
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVos){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        return totalAmount;
    }



    /**
     * 报销-采购费用-其他费用
     */
    public JSONObject purchaseOther(ReimburseModel model){
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        List<ReimburseModel> reimburseModels = reimburseMapper.selectPurchase(model);
        List<ReimburseVo> reimburseVoList = this.modelChangeVo(reimburseModels);
        reimburseVoList.forEach(temp ->{
            if (!MaterialEnum.ASSET_PURCHASE.getText().equals(temp.getFeeType())){
                reimburseVos.add(temp);
            }
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVos){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reimburseVos",reimburseVos);
        jsonObject.put("totalAmount",totalAmount);
        return jsonObject;
    }

    /**
     * 当天其他费用
     */
    public BigDecimal otherCost(Date date,ReimburseModel model){
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        List<ReimburseModel> reimburseModels = reimburseMapper.selectPurchase(model);
        List<ReimburseVo> reimburseVoList = this.modelChangeVo(reimburseModels);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        reimburseVoList.forEach(temp ->{
            if (! MaterialEnum.ASSET_PURCHASE.getText().equals(temp.getFeeType()) && df.format(date).compareTo(df.format(temp.getApplyTime()))==0){
                reimburseVos.add(temp);
            }
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVos){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        return totalAmount;
    }

    /**
     * 报销-日常费用
     */
    public JSONObject daily(ReimburseModel model) {
        List<ReimburseModel> reimburseModels = reimburseMapper.selectDaily(model);
        List<ReimburseVo> reimburseVoList = this.modelChangeVo(reimburseModels);
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVoList){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reimburseVoList",reimburseVoList);
        jsonObject.put("totalAmount",totalAmount);
        return jsonObject;
    }

    /**
     * 报销-出差费用
     */
    public JSONObject travel(ReimburseModel model) {
        List<ReimburseModel> reimburseModels = reimburseMapper.selectTravel(model);
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        reimburseModels.forEach(temp ->{
            List<TallyModel> tallyModels = tallyMapper.selectByModel(TallyModel.builder().reimburseId(temp.getId()).build());
            tallyModels.forEach(tallyModel ->{
                ReimburseVo reimburseVo=new ReimburseVo();
                reimburseVo.setNum(temp.getSerialCode());
                reimburseVo.setReason(temp.getName());
                reimburseVo.setType(ReimbTypeEnum.ReimbTypeEnum(Integer.parseInt(temp.getReimbType().toString())));
                reimburseVo.setApplyTime(temp.getCreateTime());
                reimburseVo.setPerson(temp.getApplyName());
                reimburseVo.setTime(temp.getApplyDate());
                reimburseVo.setFeeType(tallyModel.getCateName());
                reimburseVo.setAmount(tallyModel.getMoney());
                reimburseVo.setCurrency(tallyModel.getCurrencyName());
                reimburseVos.add(reimburseVo);
            });
        });
        BigDecimal totalAmount=BigDecimal.ZERO;
        for (ReimburseVo reimburseVo:reimburseVos){
            totalAmount=totalAmount.add(new BigDecimal(reimburseVo.getAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reimburseVos",reimburseVos);
        jsonObject.put("totalAmount",totalAmount);
        return jsonObject;
    }

    /**
     *model转换为vo
     */
    public List<ReimburseVo> modelChangeVo(List<ReimburseModel> reimburseModels){
        List<ReimburseVo> reimburseVos=new ArrayList<>();
        reimburseModels.forEach(temp ->{
            ReimburseVo reimburseVo = new ReimburseVo();
            reimburseVo.setNum(temp.getSerialCode());
            reimburseVo.setReason(temp.getName());
            reimburseVo.setType(ReimbTypeEnum.ReimbTypeEnum(Integer.parseInt(temp.getReimbType().toString())));
            reimburseVo.setFeeType(temp.getFeeType());
            reimburseVo.setApplyTime(temp.getApplyDate());
            reimburseVo.setAmount(temp.getMoney());
            reimburseVo.setCurrency(temp.getCurrencyName());
            reimburseVo.setPerson(temp.getApplyName());
            reimburseVo.setTime(temp.getApplyDate());
            reimburseVos.add(reimburseVo);
        });
        return reimburseVos;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.reimburseMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.reimburseMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ReimburseModel model) {
        return model != null && this.reimburseMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ReimburseModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ReimburseModel> list : ListUtil.getSubList(models, 100)) {
                this.reimburseMapper.insertList(list);
            }
        } else {
            return this.reimburseMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ReimburseModel model) {
        return model != null && this.reimburseMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ReimburseModel selectById(Long id) {
        return id == null ? null : this.reimburseMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ReimburseModel> selectByModel(ReimburseModel model) {
        return model == null ? new ArrayList<>(0) : this.reimburseMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ReimburseModel model) {
        return !(model == null || model.getId() == null) && this.reimburseMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ReimburseModel model) {
        return !(model == null || model.getId() == null) && this.reimburseMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ReimburseModel model) {
        return !(model == null || model.getId() == null) && this.reimburseMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ReimburseModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.reimburseMapper.insert(model) == 1;
        }
        return this.reimburseMapper.updateById(model) == 1;
    }
}