package com.fea.project.service.project.history;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.history.HistoryStepVerifyMapper;
import com.fea.project.model.project.history.HistoryStepVerifyModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/19.
 */
@Service
public class HistoryStepVerifyService {

    @Autowired
    private HistoryStepVerifyMapper historyStepVerifyMapper;



    /**
     * 插入多条数据
     */
    public boolean insertList(List<HistoryStepVerifyModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<HistoryStepVerifyModel> list : ListUtil.getSubList(models, 100)) {
                this.historyStepVerifyMapper.insertList(list);
            }
        } else {
            return this.historyStepVerifyMapper.insertList(models) > 0;
        }
        return true;
    }


    public boolean insertListSelective(List<HistoryStepVerifyModel> historyStepVerifyModels, Long historyProjectId) {
        if(historyStepVerifyModels == null || historyProjectId == null){
            throw new SystemParamCheckException("传入的参数异常，阶段审核信息无法生成草稿").appendAlaramMsg("historyProjectId:" + historyProjectId);
        }
        if(historyStepVerifyModels.isEmpty()){
            return Boolean.TRUE;
        }
        historyStepVerifyModels.forEach(x -> x.setHistoryId(historyProjectId));
        if(this.historyStepVerifyMapper.insertList(historyStepVerifyModels) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("阶段审核信息生成异常");
    }

    public HistoryStepVerifyModel selectById(Long id) {
        if(id == null){
            throw new SystemParamCheckException("传入的id异常，无法进行查询");
        }
        return this.historyStepVerifyMapper.selectById(id);
    }
}