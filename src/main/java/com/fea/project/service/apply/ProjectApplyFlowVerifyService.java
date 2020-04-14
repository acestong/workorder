package com.fea.project.service.apply;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.apply.ProjectApplyFlowVerifyMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyActionStatusEnum;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.ProjectApplyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowVerifyPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.model.apply.vo.ProjectApplyFlowVerifyVo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/11/18.
 */
@Service
public class ProjectApplyFlowVerifyService {

    @Autowired
    private ProjectApplyFlowVerifyMapper projectApplyFlowVerifyMapper;

    @Autowired
    private ProjectApplyFlowInfoService projectApplyFlowInfoService;

    @Autowired
    private ProjectApplyService applyService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyFlowVerifyMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyFlowVerifyMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyFlowVerifyModel model) {
        return model != null && this.projectApplyFlowVerifyMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyFlowVerifyModel> models, Long flowId) {
        if (ListUtil.isNullOrEmpty(models)) {
            return false;
        }
        models.forEach(x -> x.setApplyFlowId(flowId));
        if (models.size() > 100) {
            for (List<ProjectApplyFlowVerifyModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyFlowVerifyMapper.insertList(list);
            }
        } else {
            return this.projectApplyFlowVerifyMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyFlowVerifyModel model) {
        return model != null && this.projectApplyFlowVerifyMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyFlowVerifyModel selectById(Long id) {
        return id == null ? null : this.projectApplyFlowVerifyMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyFlowVerifyModel> selectByModel(ProjectApplyFlowVerifyModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyFlowVerifyMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyFlowVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowVerifyMapper.updateByIdSelective(model) >= 0;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyFlowVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowVerifyMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyFlowVerifyModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowVerifyMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdateSelective(ProjectApplyFlowVerifyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyFlowVerifyMapper.insertSelective(model) == 1;
        }
        return this.projectApplyFlowVerifyMapper.updateByIdSelective(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectApplyFlowVerifyPojo updateModel(ProjectApplyFlowVerifyPojo model) {
        ProjectApplyVerifyActionStatusEnum tagetEnum = ProjectApplyVerifyActionStatusEnum.getTargetMap(model.getActionType());
        ProjectApplyFlowInfoVo projectApplyFlowInfoVo = projectApplyFlowInfoService.selectWaitingVerifyModel(model.getApplyId());
        if (projectApplyFlowInfoVo == null) {
            throw new SystemParamCheckException("当前流程已经结束，无法进行审核");
        }
        ProjectApplyModel projectApplyModel = this.applyService.selectById(model.getApplyId());
        if (projectApplyModel == null) {
            throw new SystemParamCheckException("当前申请不存在，无法进行审核");
        }
        List<ProjectApplyFlowVerifyVo> projectApplyFlowVerifyVos = projectApplyFlowInfoVo.getProjectApplyFlowVerifyModels();
        Map<Long, ProjectApplyFlowVerifyVo> applyFlowVerifyVoMap = projectApplyFlowVerifyVos.stream()
                .collect(Collectors.toMap(ProjectApplyFlowVerifyModel::getVerifyerId, x -> x));
        tagetEnum.checkUserStatus(applyFlowVerifyVoMap, projectApplyModel.getApplyerId(), !StringUtil.isEmpty(projectApplyFlowInfoVo.getStopTime()));
        ProjectApplyFlowVerifyVo tmpModel = applyFlowVerifyVoMap.get(UserUtil.getUserId());
        model.setBaseInfo(tmpModel, projectApplyFlowVerifyVos.get(0).getCreateTime());
        //撤回时候，无法自动匹配到数据，需要手动设置applyFlowId
        if(model.getApplyFlowId() == null){ model.setApplyFlowId(projectApplyFlowInfoVo.getId());}
        if (tagetEnum.updateInfoByStatus(model, projectApplyFlowInfoVo)) {
            return model;
        }
        throw new SystemParamCheckException("数据更新失败");
    }

    public List<ProjectApplyFlowVerifyModel> selectUnVerifyModelsByApplyFlowId(Long applyFlowId) {
        if (applyFlowId == null) {
            throw new SystemParamCheckException("传入的申请流程id异常，无法查询该流程下要审核人信息");
        }
        return this.projectApplyFlowVerifyMapper.selectUnVerifyModelsByApplyFlowId(applyFlowId);
    }

}