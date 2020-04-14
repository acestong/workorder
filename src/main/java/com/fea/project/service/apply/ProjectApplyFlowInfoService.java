package com.fea.project.service.apply;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.apply.ProjectApplyFlowInfoMapper;
import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.flow.base.ProjectPersonTypeEnum;
import com.fea.project.enums.flow.base.ProjectSignTypeEnum;
import com.fea.project.model.apply.ProjectApplyFlowInfoModel;
import com.fea.project.model.apply.ProjectApplyFlowVerifyModel;
import com.fea.project.model.apply.pojo.ProjectApplyFlowInfoPojo;
import com.fea.project.model.apply.vo.ProjectApplyFlowInfoVo;
import com.fea.project.model.businessflow.ProjectBusinessFlowModel;
import com.fea.project.model.businessflow.ProjectBusinessFlowVerifyerModel;
import com.fea.project.service.businessflow.ProjectBusinessFlowVerifyerService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/11/18.
 */
@Service
public class ProjectApplyFlowInfoService {

    @Autowired
    private ProjectApplyFlowInfoMapper projectApplyFlowInfoMapper;

    @Autowired
    private ProjectApplyFlowVerifyService projectApplyFlowVerifyService;

    @Autowired
    private ProjectBusinessFlowVerifyerService projectBusinessFlowVerifyerService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyFlowInfoMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyFlowInfoMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyFlowInfoModel model) {
        return model != null && this.projectApplyFlowInfoMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyFlowInfoModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectApplyFlowInfoModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyFlowInfoMapper.insertList(list);
            }
        } else {
            return this.projectApplyFlowInfoMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyFlowInfoModel model) {
        return model != null && this.projectApplyFlowInfoMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyFlowInfoModel selectById(Long id) {
        return id == null ? null : this.projectApplyFlowInfoMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyFlowInfoModel> selectByModel(ProjectApplyFlowInfoModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyFlowInfoMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyFlowInfoModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowInfoMapper.updateByIdSelective(model) >= 0;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyFlowInfoModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowInfoMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyFlowInfoModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyFlowInfoMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectApplyFlowInfoModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyFlowInfoMapper.insert(model) == 1;
        }
        return this.projectApplyFlowInfoMapper.updateById(model) == 1;
    }

    public boolean insertList(List<ProjectApplyFlowInfoPojo> projectApplyFlowInfoModels, Long applyId) {
        if (ListUtil.isNullOrEmpty(projectApplyFlowInfoModels)) {
            return false;
        }
        projectApplyFlowInfoModels.forEach(x -> {
            x.setApplyId(applyId);
            if (this.insertSelective(x) && projectApplyFlowVerifyService.insertList(x.getProjectApplyFlowVerifyModels(), x.getId())) {
                return;
            }
            throw new SystemParamCheckException("项目流程数据新增异常");
        });
        return true;
    }

    public List<ProjectApplyFlowInfoVo> selectByApplyId(Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id无效，无法进行申请单详情查看");
        }
        return this.projectApplyFlowInfoMapper.selectByApplyId(applyId);
    }

    public ProjectApplyFlowInfoVo selectWaitingVerifyModel(Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id无效，无法进行申请单详情查看");
        }
        return this.projectApplyFlowInfoMapper.selectWaitingVerifyModel(applyId);
    }

    public ProjectApplyFlowInfoPojo createProjectApplyInfo(Long applyerId, ProjectBusinessFlowModel projectBusinessFlowModel, SysUserModel sysUserModel, Long parentId) {
        if (projectBusinessFlowModel == null) {
            return null;
        }
        //获取流程第一步，并创建待审核信息
        ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel = projectBusinessFlowVerifyerService.selectProjectBusinessFlowVerifyer(projectBusinessFlowModel.getId(), projectBusinessFlowModel.getListId(), parentId);
        if (projectBusinessFlowVerifyerModel == null) {
            return null;
        }
        ProjectApplyFlowInfoPojo projectApplyFlowInfoPojo = projectBusinessFlowVerifyerModel.createFirstStepVerifyModel();
        projectApplyFlowInfoPojo.setProjectBusinessFlowVerifyId(projectBusinessFlowVerifyerModel.getOriginalId());
        List<Long> userIds = this.getProjectBusinessFlowVerifyerIds(projectBusinessFlowVerifyerModel, applyerId);
        List<ProjectApplyFlowVerifyModel> projectApplyFlowVerifyModels = userIds.stream().map(x -> new ProjectApplyFlowVerifyModel(x, projectBusinessFlowVerifyerModel, sysUserModel, Objects.equals(x, applyerId), parentId)).collect(Collectors.toList());
        projectApplyFlowInfoPojo.setProjectApplyFlowVerifyModels(projectApplyFlowVerifyModels);
        Date now = new Date();
        //或签状态
        if (Objects.equals(projectBusinessFlowVerifyerModel.getVerifyType(), ProjectSignTypeEnum.TYPE_SINGLE_SIGN.getValue())) {
            List<ProjectApplyFlowVerifyModel> list = projectApplyFlowInfoPojo.getProjectApplyFlowVerifyModels().stream()
                    .filter(x -> Objects.equals(x.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue()))
                    .collect(Collectors.toList());
            if (!list.isEmpty()) {
                projectApplyFlowInfoPojo.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
                projectApplyFlowInfoPojo.setActionTime(now);
                projectApplyFlowInfoPojo.setStopTime("");
            } else {
                projectApplyFlowInfoPojo.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
            }
        } else {
            //会签，单人状态
            List<ProjectApplyFlowVerifyModel> list = projectApplyFlowInfoPojo.getProjectApplyFlowVerifyModels().stream()
                    .filter(x -> Objects.equals(x.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue())
                            || Objects.equals(x.getVerifyStatus(), ProjectApplyVerifyStatusEnum.TYPE_APPLY.getValue()))
                    .collect(Collectors.toList());
            if (Objects.equals(list.size(), projectApplyFlowInfoPojo.getProjectApplyFlowVerifyModels().size())) {
                projectApplyFlowInfoPojo.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue());
                projectApplyFlowInfoPojo.setActionTime(now);
                projectApplyFlowInfoPojo.setStopTime("");
            } else {
                projectApplyFlowInfoPojo.setVerifyStatus(ProjectApplyVerifyStatusEnum.TYPE_VERIFYING.getValue());
            }
        }
        return projectApplyFlowInfoPojo;
    }

    private List<Long> getProjectBusinessFlowVerifyerIds(ProjectBusinessFlowVerifyerModel projectBusinessFlowVerifyerModel, Long applyer) {
        Integer typeId = projectBusinessFlowVerifyerModel.getPersonType();
        List<Long> ids = Stream.of(projectBusinessFlowVerifyerModel.getDetailStr().split(","))
                .filter(StringUtil::isNotEmpty).map(Long::parseLong).distinct().collect(Collectors.toList());
        return ProjectPersonTypeEnum.getTargetEnum(typeId).getPersonTypeUsers(ids, applyer);
    }

    public ProjectApplyFlowInfoModel selectNotVerifyModelsByApplyId(Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id异常，无法进行查询");
        }
        return this.projectApplyFlowInfoMapper.selectWaitingVerifyModel(applyId);
    }

    public List<ProjectApplyFlowInfoVo> selectVerifyedModelsByApplyId(Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id异常，无法进行查询");
        }
        return this.projectApplyFlowInfoMapper.selectVerifyedModelsByApplyId(applyId);
    }

    public List<ProjectApplyFlowInfoVo> selectCanRevertStep(Long applyId) {
        if (applyId == null) {
            throw new SystemParamCheckException("传入的申请id异常，无法进行查询");
        }
        return this.projectApplyFlowInfoMapper.selectCanRevertStep(applyId);
    }
}