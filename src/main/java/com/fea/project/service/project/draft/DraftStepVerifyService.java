package com.fea.project.service.project.draft;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.draft.DraftStepVerifyMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
@Service
public class DraftStepVerifyService {

    @Autowired
    private DraftStepVerifyMapper draftStepVerifyMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.draftStepVerifyMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.draftStepVerifyMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(DraftStepVerifyModel model) {
        return model != null && this.draftStepVerifyMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<DraftStepVerifyModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<DraftStepVerifyModel> list : ListUtil.getSubList(models, 100)) {
                this.draftStepVerifyMapper.insertList(list);
            }
        } else {
            return this.draftStepVerifyMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(DraftStepVerifyModel model) {
        return model != null && this.draftStepVerifyMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public DraftStepVerifyModel selectById(Long id) {
        return id == null ? null : this.draftStepVerifyMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<DraftStepVerifyModel> selectByModel(DraftStepVerifyModel model) {
        return model == null ? new ArrayList<>(0) : this.draftStepVerifyMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(DraftStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.draftStepVerifyMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(DraftStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.draftStepVerifyMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(DraftStepVerifyModel model) {
        return !(model == null || model.getId() == null) && this.draftStepVerifyMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(DraftStepVerifyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.draftStepVerifyMapper.insert(model) == 1;
        }
        return this.draftStepVerifyMapper.updateById(model) == 1;
    }

    public boolean insertListSelective(List<DraftStepVerifyModel> draftStepVerifyModels, Long draftId) {
        if(draftStepVerifyModels == null || draftId == null){
            throw new SystemParamCheckException("传入的参数异常，阶段审核信息无法生成草稿").appendAlaramMsg("draftId:" + draftId);
        }
        if(draftStepVerifyModels.isEmpty()){
            return Boolean.TRUE;
        }
        draftStepVerifyModels.forEach(x -> x.setDraftId(draftId));
        if(this.draftStepVerifyMapper.insertList(draftStepVerifyModels) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("阶段审核信息生成异常");
    }

    public boolean insertByProjectStepModel(DraftStepModel model, SysUserModel sysUserModel) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("项目阶段新增异常");
        }
        DraftStepVerifyModel draftStepVerifyModel = new DraftStepVerifyModel(model);
        draftStepVerifyModel.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if (this.draftStepVerifyMapper.insertSelective(draftStepVerifyModel) >= 0) {
            return true;
        }
        throw new SystemParamCheckException("项目阶段新增异常");
    }

}