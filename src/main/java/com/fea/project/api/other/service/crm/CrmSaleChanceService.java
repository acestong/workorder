package com.fea.project.api.other.service.crm;

import com.fea.project.api.other.dao.crm.CrmSaleChanceMapper;
import com.fea.project.api.other.enums.base.DeleteStatusEnum;
import com.fea.project.api.other.io.project.IProjectConnectBusiness;
import com.fea.project.api.other.model.crm.CrmContractModel;
import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.api.other.model.crm.CrmSaleChanceModel;
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
 */
@Service
public class CrmSaleChanceService implements IProjectConnectBusiness<CrmSaleChanceModel> {

    @Autowired
    private CrmSaleChanceMapper crmSaleChanceMapper;

    @Autowired
    private CrmCustomerService crmCustomerService;

    @Autowired
    private CrmContractService crmContractService;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键选择
     */
    public CrmSaleChanceModel selectById(Long ID) {
        return ID == null ? null : this.crmSaleChanceMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<CrmSaleChanceModel> selectByModel(CrmSaleChanceModel model) {
        return model == null ? new ArrayList<>(0) : this.crmSaleChanceMapper.selectByModel(model);
    }

    @Override
    public List<CrmSaleChanceModel> getConnectBusiness(Long regId) {
        if (regId == null) {
            return new ArrayList<>();
        }
        CrmSaleChanceModel model = new CrmSaleChanceModel();
        model.setRegId(regId);
        model.setDelState(DeleteStatusEnum.NOT_DELETE.getStatus());
        return this.crmSaleChanceMapper.selectByModel(model);
    }

    @Override
    public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
        return this.crmSaleChanceMapper.selectByIds(businessIds).stream().map(CrmSaleChanceModel::getCustomerId).distinct().collect(Collectors.toList());
    }

    public List<CrmSaleChanceVo> selectByIds(List<Long> ids) {
        if (ListUtil.isNullOrEmpty(ids)) {
            return new ArrayList<>();
        }
        List<CrmSaleChanceVo> crmSaleChanceVos = this.crmSaleChanceMapper.selectVosByIds(ids);
        List<Long> userIds = crmSaleChanceVos.stream().filter(x -> !Objects.isNull(x.getOwnerId())).map(CrmSaleChanceModel::getOwnerId).collect(Collectors.toList());
        Map<Long, String> map = this.sysUserService.selectDepMap(userIds);
        crmSaleChanceVos.forEach(x -> {
            if(x.getOwnerId() != null){
                x.setDepName(map.get(x.getOwnerId()));
            }
        });
        return crmSaleChanceVos;
    }

    @Override
    public List<Long> getProductsByIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("传入的销售线索id传入异常，无法查询相关产品");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return this.crmSaleChanceMapper.getProductsByIds(list);
    }

    @Override
    public List<Long> getCustomersAreaByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行客户区域查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<CrmSaleChanceModel> crmSaleChanceModels = this.crmSaleChanceMapper.selectByIds(list);
        List<Long> customerIds = crmSaleChanceModels.stream().filter(x -> !Objects.isNull(x.getCustomerId()))
                .map(CrmSaleChanceModel::getCustomerId).collect(Collectors.toList());
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getREGIONID()))
                .map(x -> Long.parseLong(x.getREGIONID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getCustomersResourceByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行客户区域查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<CrmSaleChanceModel> crmSaleChanceModels = this.crmSaleChanceMapper.selectByIds(list);
        List<Long> customerIds = crmSaleChanceModels.stream().filter(x -> !Objects.isNull(x.getCustomerId()))
                .map(CrmSaleChanceModel::getCustomerId).collect(Collectors.toList());
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getINDUSTRYID()))
                .map(x -> Long.parseLong(x.getINDUSTRYID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getConnectSaleChanceTypeByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行关联销售机会类型查询");
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<CrmSaleChanceModel> crmSaleChanceModels = this.crmSaleChanceMapper.selectByIds(list);
        return crmSaleChanceModels.stream().filter(x -> !Objects.isNull(x.getSaleChanceTypeId()))
                .map(CrmSaleChanceModel::getSaleChanceTypeId).distinct().collect(Collectors.toList());
    }


    @Override
    public CrmMoneyTranslateModel getContractCostByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行关联销售机会类型查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<CrmContractModel> crmContractModels = this.crmContractService.selectBySaleChanceTypes(list);
        List<Long> currencyIds = crmContractModels.stream().map(CrmContractModel::getCurrencyId).distinct().collect(Collectors.toList());
        if (currencyIds.size() != 1) {
            return null;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (CrmContractModel tmpModel : crmContractModels) {
            total = total.add(tmpModel.getAmount() == null ? BigDecimal.ZERO : tmpModel.getAmount());
        }
        return new CrmMoneyTranslateModel(currencyIds.get(0), total);
    }

    @Override
    public CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行关联销售机会类型查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<CrmSaleChanceModel> saleChanceModels = this.crmSaleChanceMapper.selectByIds(list);
        List<Long> currencyIds = saleChanceModels.stream().map(CrmSaleChanceModel::getCurrencyId).distinct().collect(Collectors.toList());
        if (currencyIds.size() != 1) {
            return null;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (CrmSaleChanceModel tmpModel : saleChanceModels) {
            total = total.add(tmpModel.getMoney() == null ? BigDecimal.ZERO : new BigDecimal(tmpModel.getMoney()));
        }
        return new CrmMoneyTranslateModel(currencyIds.get(0), total);
    }
}