package com.fea.project.service.project.draft;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.draft.DraftDeliverClaimMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectDeliverStatusEnum;
import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.draft.DraftProjectModel;
import com.fea.project.model.project.draft.vo.DraftDeliverClaimVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/12/10.
 */
@Service
public class DraftDeliverClaimService {

    @Autowired
    private DraftDeliverClaimMapper draftDeliverClaimMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DraftProjectService draftProjectService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.draftDeliverClaimMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.draftDeliverClaimMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(DraftDeliverClaimModel model) {
        return model != null && this.draftDeliverClaimMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<DraftDeliverClaimModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<DraftDeliverClaimModel> list : ListUtil.getSubList(models, 100)) {
                this.draftDeliverClaimMapper.insertList(list);
            }
        } else {
            return this.draftDeliverClaimMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(DraftDeliverClaimModel model) {
        return model != null && this.draftDeliverClaimMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public DraftDeliverClaimModel selectById(Long id) {
        return id == null ? null : this.draftDeliverClaimMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<DraftDeliverClaimVo> selectByModel(DraftDeliverClaimModel model) {
        return model == null ? new ArrayList<>(0) : this.draftDeliverClaimMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(DraftDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.draftDeliverClaimMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(DraftDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.draftDeliverClaimMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(DraftDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.draftDeliverClaimMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(DraftDeliverClaimModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.draftDeliverClaimMapper.insert(model) == 1;
        }
        return this.draftDeliverClaimMapper.updateById(model) == 1;
    }

    public boolean insertListSelective(List<DraftDeliverClaimModel> draftDeliverClaimModels, Long draftProjectId) {
        if(draftDeliverClaimModels == null || draftProjectId == null){
            throw new SystemParamCheckException("传入的交付声明数据异常，交付声明草稿生成错误");
        }
        if(draftDeliverClaimModels.isEmpty()){
            return Boolean.TRUE;
        }
        draftDeliverClaimModels.forEach(x -> x.setDraftId(draftProjectId));
        if(this.insertList(draftDeliverClaimModels)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("交付声明草稿生成错误");
    }

    @Transactional(rollbackFor = Exception.class)
    public DraftDeliverClaimModel insertModel(DraftDeliverClaimModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        DraftProjectModel draftProjectModel = this.draftProjectService.selectById(model.getDraftId());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDeliverStatus(ProjectDeliverStatusEnum.getInitStatus());
        model.setProjectId(draftProjectModel.getOriginalId());
        if (this.draftDeliverClaimMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息创建失败");
    }

    public List<DraftDeliverClaimVo> listByDraft(DraftDeliverClaimModel model) {
        if (model == null || model.getDraftId() == null) {
            throw new SystemParamCheckException("项目交付信息传入参数异常，无法进行查询");
        }
        List<DraftDeliverClaimVo> list = this.draftDeliverClaimMapper.selectByModel(model);
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

    @Transactional(rollbackFor = Exception.class)
    public DraftDeliverClaimModel updateModel(DraftDeliverClaimModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.draftDeliverClaimMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public DraftDeliverClaimModel deleteModel(DraftDeliverClaimModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("交付物参数未传入，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.draftDeliverClaimMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息删除失败");
    }

    public boolean updateDelStatusByDraftId(Long draftId, Integer status) {
        if(draftId == null || status == null){
            throw new SystemParamCheckException("草稿信息删除失败，无法进行版本覆盖");
        }
        return this.draftDeliverClaimMapper.updateDelStatusByDraftId(draftId, status) >= 0;
    }

    public List<DraftDeliverClaimModel> selectByDraftId(Long draftId) {
        if(draftId == null){
            throw new SystemParamCheckException("传入的草稿id异常，无法获取对应的交付物说明");
        }
        return this.draftDeliverClaimMapper.selectByDraftId(draftId);
    }
}