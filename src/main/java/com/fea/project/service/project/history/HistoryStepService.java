package com.fea.project.service.project.history;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.history.HistoryStepMapper;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.history.HistoryStepModel;
import com.fea.project.model.project.history.HistoryStepVerifyModel;
import com.fea.project.model.project.history.vo.HistoryStepVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/19.
 */
@Service
public class HistoryStepService {

    @Autowired
    private HistoryStepMapper historyStepMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private HistoryStepVerifyService historyStepVerifyService;


    /**
     * 插入多条数据
     */
    public boolean insertList(List<HistoryStepModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<HistoryStepModel> list : ListUtil.getSubList(models, 100)) {
                this.historyStepMapper.insertList(list);
            }
        } else {
            return this.historyStepMapper.insertList(models) > 0;
        }
        return true;
    }


    public boolean insertListSelective(List<HistoryStepModel> historyStepModels, Long historyProjectId) {
        if(historyStepModels == null || historyProjectId == null){
            throw new SystemParamCheckException("传入的阶段数据异常，项目旧版本阶段生成错误");
        }
        if(historyStepModels.isEmpty()){
            return Boolean.TRUE;
        }
        historyStepModels.forEach(x -> x.setHistoryId(historyProjectId));
        if(this.insertList(historyStepModels)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目旧版本阶段生成错误");
    }

    public List<HistoryStepVo> listByHistoryId(HistoryStepModel model) {
        if (model == null || model.getHistoryId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        List<HistoryStepVo> list = this.historyStepMapper.selectByModel(model);
        List<Long> leadIds = list.stream().map(HistoryStepVo::getLeader).collect(Collectors.toList());
        Map<Long, SysUserModel> userMap = this.sysUserService.selectBaseInfoByIds(leadIds).stream()
                .collect(Collectors.toMap(SysUserModel::getUserId, sysUserModel -> sysUserModel));
        Map<Integer, String> projectStepVerifyStatusEnm = ProjectStepStatusEnum.getMap();
        list.forEach(x -> {
            x.setStepVerifyStatusName(projectStepVerifyStatusEnm.get(x.getStepVerifyStatus()));
            SysUserModel tmpModel = userMap.get(x.getLeader());
            if (tmpModel == null) { return;}
            x.setLeadName(tmpModel.getRealName());
            x.setDeptName(tmpModel.getDeptName());
        });
        return list;
    }

    public HistoryStepVerifyModel selectVerifyProjectStepDetail(HistoryStepVerifyModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行查询");
        }
        return this.historyStepVerifyService.selectById(model.getId());
    }
}