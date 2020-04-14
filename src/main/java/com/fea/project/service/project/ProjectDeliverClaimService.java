package com.fea.project.service.project;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectDeliverClaimMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.project.ProjectDeliverStatusEnum;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.draft.DraftDeliverClaimModel;
import com.fea.project.model.project.vo.ProjectDeliverClaimVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/30.
 */
@Service
public class ProjectDeliverClaimService {

    @Autowired
    private ProjectDeliverClaimMapper projectDeliverClaimMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectDeliverClaimMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectDeliverClaimMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectDeliverClaimModel model) {
        return model != null && this.projectDeliverClaimMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectDeliverClaimModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectDeliverClaimModel> list : ListUtil.getSubList(models, 100)) {
                this.projectDeliverClaimMapper.insertList(list);
            }
        } else {
            return this.projectDeliverClaimMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectDeliverClaimModel model) {
        return model != null && this.projectDeliverClaimMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectDeliverClaimModel selectById(Long id) {
        return id == null ? null : this.projectDeliverClaimMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectDeliverClaimVo> selectByModel(ProjectDeliverClaimModel model) {
        return model == null ? new ArrayList<>(0) : this.projectDeliverClaimMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.projectDeliverClaimMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.projectDeliverClaimMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectDeliverClaimModel model) {
        return !(model == null || model.getId() == null) && this.projectDeliverClaimMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(ProjectDeliverClaimModel model) {
        if (model == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行更新");
        }
        if (model.getId() == null) {
            return this.projectDeliverClaimMapper.insertSelective(model) >= 0;
        }
        return this.projectDeliverClaimMapper.updateByIdSelective(model) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectDeliverClaimModel insertModel(ProjectDeliverClaimModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        model.setDeliverStatus(ProjectDeliverStatusEnum.getInitStatus());
        if (this.projectDeliverClaimMapper.insertSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息创建失败");
    }

    public List<ProjectDeliverClaimVo> listByProjectId(ProjectDeliverClaimModel model) {
        if (model == null || model.getProjectId() == null) {
            throw new SystemParamCheckException("项目交付信息传入参数异常，无法进行查询");
        }
        List<ProjectDeliverClaimVo> list = this.projectDeliverClaimMapper.selectByModel(model);
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
    public ProjectDeliverClaimModel updateModel(ProjectDeliverClaimModel model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        if (this.projectDeliverClaimMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息创建失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectDeliverClaimModel deleteModel(ProjectDeliverClaimModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("交付物参数未传入，无法进行删除");
        }
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectDeliverClaimMapper.updateByIdSelective(model) >= 0) {
            return model;
        }
        throw new SystemParamCheckException("项目交付信息删除失败");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdateList(List<DraftDeliverClaimModel> draftDeliverClaimModels, Long projectId) {
        if(draftDeliverClaimModels == null || projectId == null){
            throw new SystemParamCheckException("参数异常，无法将数据同步到正式数据上");
        }
        List<ProjectDeliverClaimModel> projectDeliverClaimModels = new ArrayList<>();
        List<Long> keepDeliverIds = new ArrayList<>();
        draftDeliverClaimModels.forEach(x -> {
            projectDeliverClaimModels.add(new ProjectDeliverClaimModel(x));
            if(x.getOriginalId() != null){
                keepDeliverIds.add(x.getOriginalId());
            }
        });
        if(this.projectDeliverClaimMapper.updateDeleteStatusByProjectIdAndKeepSaveIds(projectId, keepDeliverIds) >= 0
            && this.insertOrUpdateOneByOne(projectDeliverClaimModels)){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目交付声明更新失败");
    }

    private boolean insertOrUpdateOneByOne(List<ProjectDeliverClaimModel> projectDeliverClaimModels) {
        if(projectDeliverClaimModels.isEmpty()){
            return Boolean.TRUE;
        }
        for (int i = 0; i < projectDeliverClaimModels.size(); i++) {
            this.insertOrUpdate(projectDeliverClaimModels.get(i));
        }
        return Boolean.TRUE;
    }
}