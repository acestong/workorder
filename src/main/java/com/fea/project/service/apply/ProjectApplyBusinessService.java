package com.fea.project.service.apply;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.model.flow.vo.ProjectFlowVo;
import com.fea.project.service.apply.io.IProjectFlowListChoose;
import com.fea.project.service.flow.ProjectFlowService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wuqi
 * @version 1.0
 * @since 2020/1/4 17:46
 **/
@Service
public class ProjectApplyBusinessService {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private ProjectFlowService projectFlowService;

    public Long getCurrentFlowNeedChooseFlowList(Long businessId, Long flowId, IProjectFlowListChoose projectFlowListChoose) {
        if (businessId == null || flowId == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行流程数据筛选");
        }
        ProjectFlowVo projectFlowVo = projectFlowService.selectOne(new ProjectFlowModel(flowId));
        List<ProjectFlowListVo> projectFlowListModels = projectFlowVo.getProjectFlowListModels();
        Long flowListId = null;
        //通过业务id以及对应的无法求出的类型，直接对类型进行查询
        Map<Integer, Object> otherDBConnectInfo = null;
        try {
            otherDBConnectInfo = this.selectDBConnectInfo(businessId, projectFlowVo.getFlowType());
        } catch (Exception e) {
            throw new SystemParamCheckException(e);
        }
        for (ProjectFlowListVo tmp : projectFlowListModels) {
            if (this.selectModelByIdAndConditionModel(businessId, tmp, projectFlowVo.getFlowType(), otherDBConnectInfo, projectFlowListChoose) != null) {
                flowListId = tmp.getId();
                break;
            }
        }
        if (flowListId != null) {
            return flowListId;
        }
        return projectFlowVo.getDefaultFlowModel().getId();
    }

    /**
     * 通过业务id查询出关联的所有业务数据
     *
     * @param businessId
     * @return
     */
    private Map<Integer, Object> selectDBConnectInfo(Long businessId, Integer flowType) throws Exception {
        ProjectFlowTypeEnum targetEnum = ProjectFlowTypeEnum.getTargetMap(flowType);
        List<Integer> list = targetEnum.getOtherDBCheckTypeList();
        Map<Integer, Object> map = new HashMap<>();
        if (ListUtil.isNullOrEmpty(list)) {
            return map;
        }
        Future[] futures = new Future[list.size()];
        for (int i = 0; i < list.size(); i++) {
            final int tmp = i;
            futures[i] = threadPoolExecutor.submit(() -> targetEnum.getConnectInfoByBusinessId(list.get(tmp), businessId));
        }
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), futures[i].get());
        }
        return map;
    }

    /**
     * @param businessId         业务id
     * @param tmp                项目流程信息
     * @param flowType           流程类型
     * @param otherDBConnectInfo 关联的其他数据库数据
     * @return
     */
    private Object selectModelByIdAndConditionModel(Long businessId, ProjectFlowListVo tmp, Integer flowType, Map<Integer, Object> otherDBConnectInfo, IProjectFlowListChoose projectFlowListChoose) {
        //获取参数，并将参数组装成map，与businessId拼成查询sql，进行查询
        List<ProjectFlowListConditionVo> list = tmp.getProjectFlowListConditionModels();
        if (ListUtil.isNullOrEmpty(list)) {
            throw new SystemParamCheckException("项目创建流程绑定的流程信息存在条件定义异常，请进行确认");
        }
        Map<Integer, String> conditionMap = new HashMap<>();
        ProjectFlowTypeEnum targetEnum = ProjectFlowTypeEnum.getTargetMap(flowType);
        List<Integer> types = targetEnum.getOtherDBCheckTypeList();
        Map<Integer, ProjectFlowListConditionVo> anotherDBCheck = new HashMap<>();
        list.forEach(x -> {
            if (types.contains(x.getFieldType())) {
                anotherDBCheck.put(x.getFieldType(), x);
                return;
            }
            conditionMap.put(x.getFieldType(), x.getConditionStr());
        });
        //对跨表类型进行取值判断
        if (this.checkOtherDBTypeList(anotherDBCheck, otherDBConnectInfo, targetEnum)) {
            return projectFlowListChoose.selectModelByIdAndConditionModel(businessId, conditionMap);
        }
        return null;
    }

    private boolean checkOtherDBTypeList(Map<Integer, ProjectFlowListConditionVo> anotherDBCheck, Map<Integer, Object> otherDBConnectInfo, ProjectFlowTypeEnum targetEnum) {
        ProjectFlowListConditionVo projectFlowListConditionVo = null;
        for (Map.Entry<Integer, ProjectFlowListConditionVo> tmp : anotherDBCheck.entrySet()) {
            projectFlowListConditionVo = tmp.getValue();
            Object businessInfo = otherDBConnectInfo.get(tmp.getKey());
            if (businessInfo == null || !targetEnum.isSatisfied(tmp.getKey(), projectFlowListConditionVo, businessInfo)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
