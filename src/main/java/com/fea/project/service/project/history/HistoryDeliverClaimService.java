package com.fea.project.service.project.history;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.history.HistoryDeliverClaimMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.project.ProjectDeliverStatusEnum;
import com.fea.project.model.project.history.HistoryDeliverClaimModel;
import com.fea.project.model.project.history.vo.HistoryDeliverClaimVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/19.
 */
@Service
public class HistoryDeliverClaimService {

    @Autowired
    private HistoryDeliverClaimMapper historyDeliverClaimMapper;

    @Autowired
    private SysUserService sysUserService;


    /**
     * 插入多条数据
     */
    public boolean insertList(List<HistoryDeliverClaimModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<HistoryDeliverClaimModel> list : ListUtil.getSubList(models, 100)) {
                this.historyDeliverClaimMapper.insertList(list);
            }
        } else {
            return this.historyDeliverClaimMapper.insertList(models) > 0;
        }
        return true;
    }



    public boolean insertListSelective(List<HistoryDeliverClaimModel> historyDeliverClaimModels, Long historyProjectId) {
        if(historyDeliverClaimModels == null || historyProjectId == null){
            throw new SystemParamCheckException("传入的交付声明数据异常，项目旧版本数据生成错误");
        }
        if(historyDeliverClaimModels.isEmpty()){
            return Boolean.TRUE;
        }
        historyDeliverClaimModels.forEach(x -> x.setHistoryId(historyProjectId));
        if(this.insertList(historyDeliverClaimModels)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目旧版本交付声明数据生成错误");
    }

    public List<HistoryDeliverClaimVo> listByHistory(HistoryDeliverClaimModel model) {
        if (model == null || model.getHistoryId() == null) {
            throw new SystemParamCheckException("项目交付信息传入参数异常，无法进行查询");
        }
        List<HistoryDeliverClaimVo> list = this.historyDeliverClaimMapper.selectByModel(model);
        Set<Long> userIds = new HashSet<>();
        list.forEach(tmp -> {
            if (tmp.getLeader() != null) {
                userIds.add(tmp.getLeader());
            }
            if (tmp.getVerifyer() != null) {
                userIds.add(tmp.getVerifyer());
            }
            if (tmp.getDeliver() != null) {
                userIds.add(tmp.getDeliver());
            }
        });
        Map<Long, SysUserModel> map = this.sysUserService.selectByIds(new ArrayList<>(userIds))
                .stream().collect(Collectors.toMap(SysUserModel::getUserId
                        , sysUserModel -> sysUserModel));
        Map<Integer, String> deliverStatusMap = ProjectDeliverStatusEnum.getMap();
        Map<Integer, String> verifyStatusMap = ProjectApplyVerifyStatusEnum.getMap();
        list.forEach(tmp -> {
            tmp.setDeliverName(map.get(tmp.getDeliver()) == null ? null : map.get(tmp.getDeliver()).getRealName());
            tmp.setDeliverStatusName(deliverStatusMap.get(tmp.getDeliverStatus()));
            tmp.setLeaderName(map.get(tmp.getLeader()) == null ? null : map.get(tmp.getDeliver()).getRealName());
            tmp.setVerifyerName(map.get(tmp.getVerifyer()) == null ? null : map.get(tmp.getVerifyer()).getRealName());
            tmp.setVerifyerStatusName(verifyStatusMap.get(tmp.getVerifyerStatus()));
        });
        return list;
    }
}