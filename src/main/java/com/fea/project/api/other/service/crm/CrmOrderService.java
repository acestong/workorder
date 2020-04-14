package com.fea.project.api.other.service.crm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fea.project.api.other.io.project.IProjectConnectBusiness;
import com.fea.project.api.other.model.crm.CrmMoneyTranslateModel;
import com.fea.project.api.other.model.crm.vo.CrmOrderListVo;
import com.fea.project.api.other.model.crm.vo.OrderPaymentInfoVo;
import com.fea.project.api.other.model.crm.vo.OrderPaymentPlanVo;
import com.fea.project.api.other.model.customer.CrmCustomerModel;
import com.fea.project.api.other.service.customer.CrmCustomerService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/10/22 16:41
 **/
@Service
public class CrmOrderService implements IProjectConnectBusiness<CrmOrderListVo> {

    @Value("${crm.server.queryOrderList}")
    private String queryOrderList;

    @Value("${crm.server.queryCustomerIds}")
    private String queryCustomerIds;

    @Value("${crm.server.queryByOrderIds}")
    private String queryByOrderIds;

    @Value("${crm.server.getOrderPaymentDetail}")
    private String getOrderPaymentDetail;

    @Value("${crm.server.getOrderPaymentPlan}")
    private String getOrderPaymentPlan;

    @Value("${crm.server.getContractPaymentPlan}")
    private String getContractPaymentPlan;

    @Value("${crm.server.getContractPaymentDetail}")
    private String getContractPaymentDetail;

    @Value("${crm.server.queryProductByIds}")
    private String queryProductByIds;

    @Value("${crm.server.queryContractByIds}")
    private String queryContractByIds;

    @Autowired
    private CrmCustomerService crmCustomerService;

    @Autowired
    private CrmContractService crmContractService;


    @Override
    public List<CrmOrderListVo> getConnectBusiness(Long regId) {
        return RestTemplateUtil.exchangeForObject(queryOrderList, List.class, HttpMethod.POST);
    }

    @Override
    public List<Long> getCustomerIdsByBusinessIds(List<Long> businessIds) {
        return RestTemplateUtil.exchangeForObject(queryCustomerIds, List.class, HttpMethod.POST, JSON.toJSONString(businessIds));
    }

    private List<Long> getContractByIds(List<Long> businessIds) {
        return RestTemplateUtil.exchangeForObject(queryContractByIds, List.class, HttpMethod.POST, JSON.toJSONString(businessIds));
    }

    public List<CrmOrderListVo> getOrderInfosByIdsTreadPool(List<Long> orderIds, HttpServletRequest request) {
        try {
            Object result = RestTemplateUtil.exchangeForObject(queryByOrderIds, List.class, HttpMethod.POST, JSON.toJSONString(orderIds), request);
            return JSON.parseObject(JSON.toJSONString(result), new TypeReference<List<CrmOrderListVo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public List<OrderPaymentInfoVo> getOrderPaymentDetail(Long orderId){
        try {
            Object result = RestTemplateUtil.exchangeForObject(getOrderPaymentDetail, List.class, HttpMethod.POST,JSON.toJSONString(orderId));
            return JSON.parseObject(JSON.toJSONString(result), new TypeReference<List<OrderPaymentInfoVo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        //return RestTemplateUtil.exchangeForObject(getOrderPaymentDetail, List.class, HttpMethod.POST,JSON.toJSONString(orderId));
    }
    public List<OrderPaymentPlanVo> getOrderPaymentPlan(Long orderId){
        try {
            Object result = RestTemplateUtil.exchangeForObject(getOrderPaymentPlan, List.class, HttpMethod.POST,JSON.toJSONString(orderId));
            return JSON.parseObject(JSON.toJSONString(result), new TypeReference<List<OrderPaymentPlanVo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        //return RestTemplateUtil.exchangeForObject(getOrderPaymentPlan, List.class, HttpMethod.POST,JSON.toJSONString(orderId));
    }
    public List<OrderPaymentPlanVo> getContractPaymentPlan(Long contractId){
        try {
            Object result = RestTemplateUtil.exchangeForObject(getContractPaymentPlan, List.class, HttpMethod.POST,JSON.toJSONString(contractId));
            return JSON.parseObject(JSON.toJSONString(result), new TypeReference<List<OrderPaymentPlanVo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        //return RestTemplateUtil.exchangeForObject(getContractPaymentPlan, List.class, HttpMethod.POST,JSON.toJSONString(contractId));
    }

    public List<OrderPaymentInfoVo> getContractPaymentDetail(Long contractId){
        try {
            Object result = RestTemplateUtil.exchangeForObject(getContractPaymentDetail, List.class, HttpMethod.POST, JSON.toJSONString(contractId));
            return JSON.parseObject(JSON.toJSONString(result), new TypeReference<List<OrderPaymentInfoVo>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Long> getProductsByIds(List<Long> list) {
        return RestTemplateUtil.exchangeForObject(queryProductByIds, List.class, HttpMethod.POST, JSON.toJSONString(list));
    }

    @Override
    public List<Long> getCustomersAreaByBusinessIds(List<Long> list) {
        List<Long> customerIds = getCustomerIdsByBusinessIds(list);
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getREGIONID()))
                .map(x -> Long.parseLong(x.getREGIONID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getCustomersResourceByBusinessIds(List<Long> list) {
        List<Long> customerIds = getCustomerIdsByBusinessIds(list);
        List<CrmCustomerModel> customerModels = this.crmCustomerService.selectByIds(customerIds);
        return customerModels.stream().filter(x -> !Objects.isNull(x.getINDUSTRYID()))
                .map(x -> Long.parseLong(x.getINDUSTRYID())).collect(Collectors.toList());
    }

    @Override
    public List<Long> getConnectSaleChanceTypeByBusinessIds(List<Long> list) {
        List<Long> contractIds = RestTemplateUtil.exchangeForObject(queryProductByIds, List.class, HttpMethod.POST, JSON.toJSONString(list));
        return crmContractService.getConnectSaleChanceTypeByBusinessIds(contractIds);
    }

    @Override
    public CrmMoneyTranslateModel getContractCostByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行关联销售机会类型查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<Long> crmContractModels = this.getContractByIds(list);
        return this.crmContractService.getContractCostByBusinessIds(crmContractModels);
    }


    @Override
    public CrmMoneyTranslateModel getConnectSaleChanceEstimatedContractAmountByBusinessIds(List<Long> list) {
        if (list == null) {
            throw new SystemParamCheckException("销售机会传入异常，无法进行关联销售机会类型查询");
        }
        if (list.isEmpty()) {
            return null;
        }
        List<Long> crmContractModels = this.getContractByIds(list);
        return this.crmContractService.getConnectSaleChanceEstimatedContractAmountByBusinessIds(crmContractModels);
    }
}
