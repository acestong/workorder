package com.fea.project.service.project.draft;

import com.alibaba.fastjson.JSON;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.draft.DraftStepMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectStepStatusEnum;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.DraftStepModel;
import com.fea.project.model.project.draft.DraftStepVerifyModel;
import com.fea.project.model.project.draft.vo.DraftStepVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/10.
 */
@Service
public class DraftStepService {

    @Autowired
    private DraftStepMapper draftStepMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DraftStepVerifyService draftStepVerifyService;

    @Autowired
    private DraftProjectService draftProjectService;


    /**
     * 插入数据
     */
    public boolean insert(DraftStepModel model) {
        return model != null && this.draftStepMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<DraftStepModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<DraftStepModel> list : ListUtil.getSubList(models, 100)) {
                this.draftStepMapper.insertList(list);
            }
        } else {
            return this.draftStepMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(DraftStepModel model) {
        return model != null && this.draftStepMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public DraftStepModel selectById(Long id) {
        return id == null ? null : this.draftStepMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<DraftStepVo> selectByModel(DraftStepModel model) {
        return model == null ? new ArrayList<>(0) : this.draftStepMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(DraftStepModel model) {
        return !(model == null || model.getId() == null) && this.draftStepMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(DraftStepModel model) {
        return !(model == null || model.getId() == null) && this.draftStepMapper.updateById(model) == 1;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(DraftStepModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.draftStepMapper.insert(model) == 1;
        }
        return this.draftStepMapper.updateById(model) == 1;
    }

    public boolean insertListSelective(List<DraftStepModel> draftStepModels, Long draftProjectId) {
        if(draftStepModels == null || draftProjectId == null){
            throw new SystemParamCheckException("传入的阶段数据异常，项目阶段草稿生成错误");
        }
        if(draftStepModels.isEmpty()){
            return Boolean.TRUE;
        }
        draftStepModels.forEach(x -> x.setDraftId(draftProjectId));
        if(this.insertList(draftStepModels)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("阶段数据草稿生成错误");
    }

    public List<DraftStepVo> listByDraftId(DraftStepModel model) {
        if (model == null || model.getDraftId() == null) {
            throw new SystemParamCheckException("项目阶段查询，参数报错");
        }
        List<DraftStepVo> list = this.draftStepMapper.selectByModel(model);
        List<Long> leadIds = list.stream().map(DraftStepVo::getLeader).collect(Collectors.toList());
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

    @Transactional(rollbackFor = Exception.class)
    public DraftStepModel insertModel(DraftStepModel model) {
        DraftProjectModel projectModel = this.draftProjectService.selectById(model.getDraftId());
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setProjectId(projectModel.getOriginalId());
        if (this.draftStepMapper.insertSelective(model) >= 0
                && draftStepVerifyService.insertByProjectStepModel(model, sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段添加报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public DraftStepModel updateModel(DraftStepModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.draftStepMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段添加报错");
    }

    @Transactional(rollbackFor = Exception.class)
    public DraftStepModel deleteModel(DraftStepModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("阶段删除传入数据报错")
                    .appendAlaramMsg(JSON.toJSONString(model));
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.draftStepMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目阶段删除报错");
    }


    public DraftStepVerifyModel selectVerifyProjectStepDetail(DraftStepVerifyModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行查询");
        }
        return this.draftStepVerifyService.selectById(model.getId());
    }

    public boolean updateDelStatusByDraftId(Long draftId, Integer status) {
        if(draftId == null || status == null){
            throw new SystemParamCheckException("草稿信息删除失败，无法进行版本覆盖");
        }
        return this.draftStepMapper.updateDelStatusByDraftId(draftId, status) >= 0;
    }

    public List<DraftStepVo> selectByDraftId(Long draftId) {
        if(draftId == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法获取对应的阶段数据");
        }
        return this.draftStepMapper.selectByDraftId(draftId);
    }
}