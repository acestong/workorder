package com.fea.project.api.other.service.crm;

import com.fea.project.api.other.dao.crm.CrmContractMapper;
import com.fea.project.api.other.enums.base.EnableStatusEnum;
import com.fea.project.api.other.io.project.IProjectConnectBusiness;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.model.base.vo.SysUserVo;
import com.fea.project.api.other.model.crm.CrmContractModel;
import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.api.other.model.crm.CrmSaleChanceModel;
import com.fea.project.api.other.model.crm.vo.CrmContractVo;
import com.fea.project.api.other.model.crm.vo.CrmSaleChanceVo;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.api.other.service.customer.CrmCustomerService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/26.
 * 合同 Service
 */
@Service
public class CrmContractService implements IProjectConnectBusiness<CrmContractModel> {

    @Autowired
    private CrmContractMapper crmContractMapper;


    @Autowired
    private CrmCustomerService crmCustomerService;

    @Autowired
    private CrmSaleChanceService crmSaleChanceService;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 按主键选择
     */
    public CrmContractModel selectById(Long id) {
        return id == null ? null : this.crmContractMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<CrmContractModel> selectByModel(CrmContractModel model) {
        return model == null ? new ArrayList<>(0) : this.crmContractMapper.selectByModel(model);
    }


    @Override
    public List<CrmContractModel> getConnectBusiness(Long regId) {
        if (regId == null) {
            return new ArrayList<>();
        }
        CrmContractModel model = new CrmContractModel();
        model.setRegId(regId);
        model.setIsRemove(EnableStatusEnum.ENABLE.getStatus());
        return this.crmContractMapper.selectByModel(model);
    }

    @Override
    public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
        return this.crmContractMapper.selectByIds(businessIds).stream().map(CrmContractModel::getCustomerId).distinct().collect(Collectors.toList());
    }


    public List<CrmContractVo> selectByIds(List<Long> ids) {
        if (ListUtil.isNullOrEmpty(ids)) {
            return new ArrayList<>();
        }
        List<CrmContractVo> list = this.crmContractMapper.selectVosByIds(ids);
        List<Long> userIds = list.stream().filter(x -> !Objects.isNull(x.getOwnerId())).map(CrmContractVo::getOwnerId).collect(Collectors.toList());
        Map<Long, String> userInfo = this.sysUserService.selectDepMap(userIds);
        list.forEach(x -> {
            if(!Objects.isNull(x.getOwnerId())){
                x.setDepName(userInfo.get(x.getOwnerId()));
            }
        });
        return list;
    }

    @Override
    public List<Long> getProductsByIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("传入的合同参数异常，无法查询合同下的产品");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return crmContractMapper.getProductsByIds(list);
    }

    @Override
    public List<Long> getCustomersAreaByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("合同id传入异常，无法进行客户区域查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<CrmContractModel> crmContractModels = this.crmContractMapper.selectByIds(list);
        List<Long> customerIds = crmContractModels.stream().filter(x -> !Objects.isNull(x.getCustomerId()))
                .map(CrmContractModel::getCustomerId).collect(Collectors.toList());
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getREGIONID()))
                .map(x -> Long.parseLong(x.getREGIONID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getCustomersResourceByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("合同id传入异常，无法进行客户区域查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<CrmContractModel> crmContractModels = this.crmContractMapper.selectByIds(list);
        List<Long> customerIds = crmContractModels.stream().filter(x -> !Objects.isNull(x.getCustomerId()))
                .map(CrmContractModel::getCustomerId).collect(Collectors.toList());
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getINDUSTRYID()))
                .map(x -> Long.parseLong(x.getINDUSTRYID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getConnectSaleChanceTypeByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("合同id传入异常，无法进行客户区域查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> crmSaleTypeIds = this.crmContractMapper.selectByIds(list).stream()
                .filter(x -> Objects.isNull(x.getBusinessId())).map(CrmContractModel::getBusinessId).distinct().collect(Collectors.toList());
        return crmSaleChanceService.getConnectSaleChanceTypeByBusinessIds(crmSaleTypeIds);
    }

    @Override
    public CrmMoneyTranslateModel getContractCostByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("合同id传入异常，无法进行合同金额查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<CrmContractModel> contractModels = this.crmContractMapper.selectByIds(list);
        List<Long> currencyIds = contractModels.stream().map(CrmContractModel::getCurrencyId).distinct().collect(Collectors.toList());
        if (currencyIds.size() != 1) {
            return null;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (CrmContractModel tmpModel : contractModels) {
            total = total.add(tmpModel.getAmount() == null ? BigDecimal.ZERO : tmpModel.getAmount());
        }
        return new CrmMoneyTranslateModel(currencyIds.get(0), total);
    }

    @Override
    public CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("合同id传入异常，无法进行合同金额查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<Long> crmSaleTypeIds = this.crmContractMapper.selectByIds(list).stream()
                .filter(x -> Objects.isNull(x.getBusinessId())).map(CrmContractModel::getBusinessId).distinct().collect(Collectors.toList());
        List<CrmSaleChanceVo> crmSaleChanceModels = this.crmSaleChanceService.selectByIds(crmSaleTypeIds);
        List<Long> currencyIds = crmSaleChanceModels.stream().map(CrmSaleChanceModel::getCurrencyId).distinct().collect(Collectors.toList());
        if (currencyIds.size() != 1) {
            return null;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (CrmSaleChanceModel tmpModel : crmSaleChanceModels) {
            total = total.add(tmpModel.getMoney() == null ? BigDecimal.ZERO : new BigDecimal(tmpModel.getMoney()));
        }
        return new CrmMoneyTranslateModel(currencyIds.get(0), total);
    }

    public List<CrmContractModel> selectBySaleChanceTypes(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("项目销售类型");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return this.crmContractMapper.selectBySaleChanceTypes(list);
    }
}