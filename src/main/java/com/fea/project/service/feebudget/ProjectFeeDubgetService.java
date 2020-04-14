package com.fea.project.service.feebudget;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.dao.base.PdtUnitMapper;
import com.fea.project.api.other.dao.base.SysCurrencyMapper;
import com.fea.project.api.other.dao.crm.CrmContractMapper;
import com.fea.project.api.other.dao.crm.CrmOrderMapper;
import com.fea.project.api.other.dao.customer.CrmCustomerMapper;
import com.fea.project.api.other.model.base.PdtUnitModel;
import com.fea.project.api.other.model.base.SysCurrencyModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.crm.CrmContractModel;
import com.fea.project.api.other.model.crm.CrmOrderModel;
import com.fea.project.api.other.model.crm.vo.OrderPaymentInfoVo;
import com.fea.project.api.other.model.crm.vo.OrderPaymentPlanVo;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.crm.CrmOrderService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.base.ProjectDictionaryItemMapper;
import com.fea.project.dao.feebudget.ProjectFeeDubgetMapper;
import com.fea.project.dao.feebudget.ProjectFeeDubgetParentMapper;
import com.fea.project.dao.project.ProjectMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.feebudget.IsDraftEnum;
import com.fea.project.enums.risk.IsCheckEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.feebudget.ProjectFeeDubgetModel;
import com.fea.project.model.feebudget.ProjectFeeDubgetParentModel;
import com.fea.project.model.feebudget.vo.DubgetChangeGraphVo;
import com.fea.project.model.feebudget.vo.DubgetClassifyVo;
import com.fea.project.model.feebudget.vo.OrderContractVo;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessFeeDubgetApplyImplService;
import com.fea.project.service.businessflow.flowtype.ProjectBusinessFeeDubgetChangeApplyImplService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/10.
 */
@Service
public class ProjectFeeDubgetService implements IProjectApplyBusiness {

    @Autowired
    private ProjectFeeDubgetMapper projectFeeDubgetMapper;
    @Autowired
    private ProjectDictionaryItemMapper projectDictionaryItemMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private CrmOrderMapper crmOrderMapper;
    @Autowired
    private CrmContractMapper crmContractMapper;
    @Autowired
    private CrmCustomerMapper crmCustomerMapper;
    @Autowired
    private CrmOrderService crmOrderService;
    @Autowired
    private ProjectFeeDubgetParentMapper projectFeeDubgetParentMapper;
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;
    @Autowired
    private ProjectBusinessFeeDubgetApplyImplService applyImplService;
    @Autowired
    private ProjectBusinessFeeDubgetChangeApplyImplService changeApplyImplService;
    @Autowired
    private SysCurrencyMapper sysCurrencyMapper;
    @Autowired
    private PdtUnitMapper pdtUnitMapper;


    /**
     * 新建项目预算
     * 先查询当前预算列表的草稿状态版本号，若没有，先新建一个父表,默认版本号为1
     * 若有，直接新增，若无，先新增一个版本号为1的父表
     */
    public boolean insertSelective(ProjectFeeDubgetModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        Long projectId = model.getProjectId();
        ProjectFeeDubgetParentModel parentModel = projectFeeDubgetParentMapper.selectNotDraft(projectId,IsDraftEnum.DRATE.getCode());
        if (parentModel==null){//即当前没有已经提交的预算版本--新建
            ProjectFeeDubgetParentModel parentModelNew = new ProjectFeeDubgetParentModel();
            parentModelNew.setVersion(1L);
            parentModel.setName("第1版本预算");
            parentModelNew.setVerifyerStatus(ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getColorStatusType());//默认未提交审核
            parentModelNew.setIsDraft(IsDraftEnum.DRATE.getCode());//默认为草稿
            parentModelNew.setCreateId(currentUsr.getUserId());
            parentModelNew.setCreateBy(currentUsr.getRealName());
            parentModelNew.setCreateTime(new Date());
            parentModelNew.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
            projectFeeDubgetParentMapper.insertSelective(parentModelNew);
            //得到添加的父表的id，将其添加到子表中
            model.setParentId(parentModelNew.getId());
        }else {
            //有则直接新增
            model.setParentId(parentModel.getId());
        }
        model.setIsDraft(IsDraftEnum.DRATE.getCode());
        model.setCheckStatus(IsCheckEnum.NOT_SUBMIT.getCode());
        model.setRegId(currentUsr.getRegId());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        projectFeeDubgetMapper.insertSelective(model);
        return model != null;
    }

    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
        List<ProjectFeeDubgetParentModel> list = projectFeeDubgetParentMapper.selectByModelIds(ids);
        return list.stream().collect(Collectors.toMap(ProjectFeeDubgetParentModel::getId,ProjectFeeDubgetParentModel::getName));
    }

    /**
     * 提交审核
     */
    public void check(Long id){
        //将父id下的父表的审核状态修改为未审核(2)，草稿状态修改为非草稿(0)
        ProjectFeeDubgetParentModel model=new ProjectFeeDubgetParentModel();
        model.setId(id);
        model.setUpdateTime(new Date());
        model.setIsDraft(IsDraftEnum.NOT_DRAFT.getCode());
        projectFeeDubgetParentMapper.updateByIdSelective(model);
    }

    public ProjectFeeDubgetParentModel verify(ProjectFeeDubgetParentModel model) {
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("参数错误，无法提交");
        }
        //检查是否可以提交
        ProjectFeeDubgetParentModel parentModel = projectFeeDubgetParentMapper.selectById(model.getId());
        if (parentModel!=null){
            if (!ProjectApplyVerifyStatusEnum.getCanSubmitStatus().contains(parentModel.getVerifyerStatus()==null?
                    ProjectApplyVerifyStatusEnum.TYPE_UNCOMMIT.getValue():parentModel.getVerifyerStatus())){
                throw new SystemParamCheckException("当前审批状态无法提交审批");
            }
        }
        model.setVerifyerStatus(IsCheckEnum.NOT_AUDIT.getCode());
        if (this.applyImplService.createApplyInfo(parentModel)
                ) {
            return model;
        }
        throw new SystemParamCheckException("提交审核异常，无法进行提交");
    }


    /**
     * 预算变更
     */
    public void updateVersion(Long id){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //查询当前项目下非草稿状态的父预算的版本（正在使用的版本）,得到新版本
        Long projectId = projectFeeDubgetParentMapper.selectById(id).getProjectId();
        ProjectFeeDubgetParentModel parentModelOld = projectFeeDubgetParentMapper.selectNotDraft(projectId,IsDraftEnum.NOT_DRAFT.getCode());
        Long version = parentModelOld.getVersion();
        Long newVersion=version+1;
        //新建父表，同时版本号+1，草稿(1)+未审核状态(1)，并添加到数据库
        ProjectFeeDubgetParentModel parentModel = new ProjectFeeDubgetParentModel();
        parentModel.setProjectId(projectId);
        parentModel.setVersion(newVersion);
        parentModel.setName("第"+newVersion+"版本预算");
        parentModel.setVerifyerStatus(IsCheckEnum.NOT_SUBMIT.getCode());//默认未提交审核
        parentModel.setIsDraft(IsDraftEnum.DRATE.getCode());//默认为草稿
        parentModel.setCreateId(currentUsr.getUserId());
        parentModel.setCreateBy(currentUsr.getRealName());
        parentModel.setCreateTime(new Date());
        parentModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        projectFeeDubgetParentMapper.insertSelective(parentModel);
        //同时将上一个非草稿状态版本的预算复制一份为草稿状态，审核状态为未审核
        List<ProjectFeeDubgetModel> dubgetModels = projectFeeDubgetMapper.selectByModel(
                ProjectFeeDubgetModel.builder().parentId(id).build());
        List<ProjectFeeDubgetModel> newModels=new ArrayList<>();
        dubgetModels.forEach(dubget ->{
            ProjectFeeDubgetModel dubgetModel = new ProjectFeeDubgetModel();
            dubgetModel.setParentId(parentModel.getId());//新的父id
            dubgetModel.setRegId(dubget.getRegId());
            dubgetModel.setProjectId(dubget.getProjectId());
            dubgetModel.setName(dubget.getName());
            dubgetModel.setAmount(dubget.getAmount());
            dubgetModel.setCurrency(dubget.getCurrency());
            dubgetModel.setType(dubget.getType());
            dubgetModel.setStepId(dubget.getStepId());
            dubgetModel.setStage(dubget.getStage());
            dubgetModel.setStartTime(dubget.getStartTime());
            dubgetModel.setEndTime(dubget.getEndTime());
            dubgetModel.setDeclares(dubget.getDeclares());
            dubgetModel.setCheckStatus(IsCheckEnum.NOT_SUBMIT.getCode());
            dubgetModel.setIsDraft(IsDraftEnum.DRATE.getCode());
            dubgetModel.setCreateId(dubget.getCreateId());
            dubgetModel.setCreateBy(dubget.getCreateBy());
            dubgetModel.setCreateTime(dubget.getCreateTime());
            projectFeeDubgetMapper.insertSelective(dubgetModel);
            newModels.add(dubgetModel);
        });
    }

    public ProjectFeeDubgetParentModel updateVersionCheck(ProjectFeeDubgetParentModel model) {
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("参数错误，无法提交");
        }
        //检查是否可以提交
        ProjectFeeDubgetParentModel parentModel = projectFeeDubgetParentMapper.selectById(model.getId());
        if (parentModel!=null){
            if (ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue()!=parentModel.getVerifyerStatus()){
                throw new SystemParamCheckException("当前审批状态无法提交审批");
            }
        }
        if (this.changeApplyImplService.createApplyInfo(parentModel)
                && this.projectFeeDubgetParentMapper.updateByIdSelective(parentModel) >= 0) {
            //上一个版本的草稿状态修改为2-已变更
            projectFeeDubgetParentMapper.updateDraftStatusById(model.getId(),IsDraftEnum.CHANGED.getCode());
            return model;
        }
        throw new SystemParamCheckException("预算变更提交审核异常，无法进行提交");
    }

    /**
     *分页查询项目预算列表
     */
    public JSONObject selectByFilterAndOrderParams(BasePageInfo<ProjectFeeDubgetModel> model){
        //查询父表有无当前项目下草稿状态+未审核的数据(1,1)
        Long projectId = model.getModel().getProjectId();
        Long parentId=0l;
        Integer isCheck=0;
        ProjectFeeDubgetParentModel parentModel = projectFeeDubgetParentMapper.selectDraft(
                projectId,IsDraftEnum.DRATE.getCode(),IsCheckEnum.NOT_SUBMIT.getCode());
        if (parentModel!=null){//有草稿
            parentId=parentModel.getId();
            isCheck=parentModel.getVerifyerStatus();
        }else {//没有草稿，查询父表已审核成功+非草稿预算
            ProjectFeeDubgetParentModel parentModel2 = projectFeeDubgetParentMapper.selectDraft(
                    projectId,IsDraftEnum.NOT_DRAFT.getCode(),IsCheckEnum.SUCCESS_AUDIT.getCode());
            try {
                parentId=parentModel2.getId();
                isCheck=parentModel2.getVerifyerStatus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        model.getModel().setParentId(parentId);
        List<ProjectFeeDubgetModel> projectFeeDubgetModels = projectFeeDubgetMapper.selectByFilterAndParams(new PageInfoQueryOrderAndFilterModel<>(model));
        BigDecimal amount=BigDecimal.ZERO;
        for (ProjectFeeDubgetModel temp:projectFeeDubgetModels){
            temp.setTypeString(this.getFeeType(temp.getType()));
            try {
                amount=amount.add(temp.getAmount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BasePageInfo<ProjectFeeDubgetModel> pageInfo = new BasePageInfo<>(projectFeeDubgetModels);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount",amount);
        jsonObject.put("parentId",parentId.toString());
        jsonObject.put("isCheck",isCheck);
        jsonObject.put("list",pageInfo);
        return jsonObject;
    }

    /**
     * 项目预算列表
     */
    public List<ProjectFeeDubgetModel> projectFeeDubgetList(Long projectId){
        return projectFeeDubgetMapper.selectByModel(ProjectFeeDubgetModel.builder().projectId(projectId).build());
    }

    /**
     * 预算变化曲线图
     */
    public List<DubgetChangeGraphVo> dubgetChangeGraph(ProjectFeeDubgetParentModel model){
        //该项目下已审核（VerifyerStatus=3）的预算版本列表
        List<ProjectFeeDubgetParentModel> models = projectFeeDubgetParentMapper.selectByModel(model);
        List<DubgetChangeGraphVo> vos=new ArrayList<>();
        for (ProjectFeeDubgetParentModel parentModel:models){
            DubgetChangeGraphVo vo=new DubgetChangeGraphVo();
            if (parentModel.getVerifyerStatus()==3){
                //SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                vo.setDate(parentModel.getUpdateTime());
                List<ProjectFeeDubgetModel> list = projectFeeDubgetMapper.selectByModel(
                        ProjectFeeDubgetModel.builder().parentId(parentModel.getId()).build());
                BigDecimal money=BigDecimal.ZERO;
                for (ProjectFeeDubgetModel dubgetModel:list){
                    money=money.add(dubgetModel.getAmount());
                }
                vo.setMoney(money);
                vos.add(vo);
            }
        }
        return vos;
    }


    /**
     * 通过数据字典获取项目费用类型
     */
    public String getFeeType(Long type){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        List<ProjectDictionaryItemModel> projectDictionaryItemModels = projectDictionaryItemMapper.selectByShortNameAndRegIdAndDelStatus(
                DictionaryTypeEnum.PROJECT_FEE_TYPE.getValue(), currentUsr.getRegId(), DeleteStatusEnum.NOT_DELETE.getStatus());
        String name=null;
        for (ProjectDictionaryItemModel model:projectDictionaryItemModels){
            try {
                if (type.equals(model.getId())){
                    name=model.getName();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return name;
    }
    /**
     * 预算信息
     */
    public ProjectFeeDubgetModel selectById(Long id) {
        ProjectFeeDubgetModel model = this.projectFeeDubgetMapper.selectById(id);
        model.setCheckStatusString(IsCheckEnum.queryText(model.getCheckStatus()));
        return model;
    }
    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFeeDubgetModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectFeeDubgetMapper.updateByIdSelective(model) == 1;
    }
    /**
     * 项目回款明细
     */
    public JSONObject paymentDetail(ProjectFeeDubgetModel model){
        List<OrderPaymentInfoVo> orderPaymentInfoVos=new ArrayList<>();
        ProjectModel projectModel = projectMapper.selectById(model.getProjectId());
        List<Long> ids = this.selectIds(model.getProjectId());//业务id的List
        for (Long id:ids){
            if (projectModel.getResource()==1){//合同
                orderPaymentInfoVos.addAll(crmOrderService.getContractPaymentDetail(id));
            }else if (projectModel.getResource()==3){//订单
                orderPaymentInfoVos.addAll(crmOrderService.getOrderPaymentDetail(id));
            }
        }
        BigDecimal amount=BigDecimal.ZERO;
        for (OrderPaymentInfoVo vo:orderPaymentInfoVos){
            amount=amount.add(new BigDecimal(vo.getGatherAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount",amount);
        jsonObject.put("orderPaymentInfoVos",orderPaymentInfoVos);
        return jsonObject;

    }
    /**
     * 项目回款计划
     */
    public JSONObject paymentPlan(ProjectFeeDubgetModel model){
        List<OrderPaymentPlanVo> orderPaymentPlanVos=new ArrayList<>();
        ProjectModel projectModel = projectMapper.selectById(model.getProjectId());
        List<Long> ids = this.selectIds(model.getProjectId());//业务id的List
        ids.forEach(id ->{
            if (projectModel.getResource()==1){//合同
                List<OrderPaymentPlanVo> orderPaymentPlan = crmOrderService.getContractPaymentPlan(id);
                orderPaymentPlanVos.addAll(orderPaymentPlan);
            }else if (projectModel.getResource()==3){//订单
                List<OrderPaymentPlanVo> orderPaymentPlan = crmOrderService.getOrderPaymentPlan(id);
                orderPaymentPlanVos.addAll(orderPaymentPlan);
            }
        });
        BigDecimal amount=BigDecimal.ZERO;
        for (OrderPaymentPlanVo vo:orderPaymentPlanVos){
            amount=amount.add(new BigDecimal(vo.getAmount().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount",amount);
        jsonObject.put("orderPaymentPlanVos",orderPaymentPlanVos);
        return jsonObject;


    }
    /**
     * 根据项目id查询其关联的业务id
     */
    public List<Long> selectIds(Long projectId){
        ProjectModel projectModel = projectMapper.selectById(projectId);
        String connectId = projectModel.getConnectId();
        List<String> idsString = Arrays.asList(connectId.split(","));//关联业务id集合
        List<Long> ids =new ArrayList<>();
        for (String idString:idsString){
            if (idsString!=null && idsString.size()!=0 && connectId!=null && connectId !="") {
                try {
                    ids.add(Long.parseLong(idString));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return ids;
    }
    /**
     * 关联业务合同/关联订单
     */
    public JSONObject selectOrderContractVo(ProjectFeeDubgetModel model){
        ProjectModel projectModel = projectMapper.selectById(model.getProjectId());
        List<OrderContractVo> orderContractVos=new ArrayList<>();
        List<Long> ids = this.selectIds(model.getProjectId());
        JSONObject jsonObject = new JSONObject();
        ids.forEach(id ->{
            if (projectModel.getResource()==1){//合同
                try {
                    CrmContractModel contractModel = crmContractMapper.selectById(id);
                    orderContractVos.add(OrderContractVo.builder()
                                .num(contractModel.getCode())
                                .name(contractModel.getName())
                                .customId(contractModel.getCustomerId())
                                .customName(contractModel.getCustomerName())
                                .money(new BigDecimal(contractModel.getAmount().toString()))
                                .saleId(contractModel.getOwnerId())
                                .saleName(contractModel.getOwner())
                                .time(contractModel.getCreateTime())
                                .build());
                    jsonObject.put("type","合同");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (projectModel.getResource()==3){//订单
                CrmOrderModel orderModel = crmOrderMapper.selectById(id);
                orderContractVos.add(OrderContractVo.builder()
                        .num(orderModel.getNum())
                        .name(orderModel.getTitle())
                        .customName(crmCustomerMapper.selectById(orderModel.getCustomId()).getNAME())
                        .contractName(crmContractMapper.selectById(orderModel.getContractId()).getName())
                        .money(orderModel.getMoney())
                        .saleId(orderModel.getChargeSaleId())
                        .saleName(orderModel.getChargeSale())
                        .time(orderModel.getOrderTime())
                        .build());
                jsonObject.put("type","订单");
            }
        });
        BigDecimal money=BigDecimal.ZERO;
        for (OrderContractVo vo:orderContractVos){
            money = money.add(vo.getMoney());
        }
        jsonObject.put("amount",money);
        jsonObject.put("list",orderContractVos);
        return jsonObject;
    }

    /**
     * 项目预算分类饼图
     */
    public List<DubgetClassifyVo> projectFeeDubgetClassify(ProjectFeeDubgetModel model){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        Long projectId = model.getProjectId();
        List<DubgetClassifyVo> dubgetClassifyVos=new ArrayList<>();
        //几种费用类型
        ProjectDictionaryModel projectDictionaryModel=new ProjectDictionaryModel();
        projectDictionaryModel.setRegId(currentUsr.getRegId());
        projectDictionaryModel.setShortName(DictionaryTypeEnum.PROJECT_FEE_TYPE.getValue());
        List<ProjectDictionaryItemSelectVo> projectDictionaryItemSelectVos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(projectDictionaryModel);
        //几种费用类型的类型名称，金额
        for (ProjectDictionaryItemSelectVo temp:projectDictionaryItemSelectVos){
            DubgetClassifyVo dubgetClassifyVo=new DubgetClassifyVo();
            List<ProjectFeeDubgetModel> projectFeeDubgetModels = projectFeeDubgetMapper.selectByModel(
                    ProjectFeeDubgetModel.builder().type(Long.parseLong(projectDictionaryItemMapper.selectById(temp.getId()).getIndex().toString())).projectId(projectId).build());
            BigDecimal amount=BigDecimal.ZERO;
            for (ProjectFeeDubgetModel dubgetModel:projectFeeDubgetModels){
                amount = amount.add(dubgetModel.getAmount());
            }
            dubgetClassifyVo.setFeeType(temp.getName());
            dubgetClassifyVo.setAmount(amount);
            dubgetClassifyVos.add(dubgetClassifyVo);
        }
        return dubgetClassifyVos;
    }

    /**
     * 币种列表
     */
    public List<SysCurrencyModel> currencyList(){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        List<SysCurrencyModel> models = sysCurrencyMapper.selectByModel(SysCurrencyModel.builder().REGID(currentUsr.getRegId()).build());
        return models;
    }

    /**
     * 物品单位列表
     */
    public List<PdtUnitModel> getUnitList(){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        List<PdtUnitModel> models = pdtUnitMapper.selectByModel(PdtUnitModel.builder().REGID(currentUsr.getRegId()).build());
        return models;
    }


    /**
     * 提交审核提交
     */
    public boolean checkSubmit(List<Long> ids) {
        return projectFeeDubgetMapper.updateByIds(ids)>0;

    }
    /**
     * 删除
     */
    public boolean deleteProjectFeeDubget(ProjectFeeDubgetModel model){
        return !(model == null || model.getId() == null) && this.projectFeeDubgetMapper.deleteProjectFeeDubget(model.getId()) == 1;

    }



    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFeeDubgetMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFeeDubgetMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFeeDubgetModel model) {
        return model != null && this.projectFeeDubgetMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFeeDubgetModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFeeDubgetModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFeeDubgetMapper.insertList(list);
            }
        } else {
            return this.projectFeeDubgetMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按模型选择
     */
    public List<ProjectFeeDubgetModel> selectByModel(ProjectFeeDubgetModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFeeDubgetMapper.selectByModel(model);
    }


    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFeeDubgetModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeDubgetMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFeeDubgetModel model) {
        return !(model == null || model.getId() == null) && this.projectFeeDubgetMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFeeDubgetModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFeeDubgetMapper.insert(model) == 1;
        }
        return this.projectFeeDubgetMapper.updateById(model) == 1;
    }

}