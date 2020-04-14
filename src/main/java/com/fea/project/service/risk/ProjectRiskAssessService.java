package com.fea.project.service.risk;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.base.ProjectDictionaryItemMapper;
import com.fea.project.dao.project.ProjectMapper;
import com.fea.project.dao.project.ProjectStepMapper;
import com.fea.project.dao.risk.ProjectRiskAppendixMapper;
import com.fea.project.dao.risk.ProjectRiskAssessMapper;
import com.fea.project.dao.risk.ProjectRiskMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.risk.IsCheckEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.product.ProjectProductAppendixModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.model.project.ProjectStepModel;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import com.fea.project.model.risk.ProjectRiskAssessModel;
import com.fea.project.service.product.ProjectProductAppendixService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Service
public class ProjectRiskAssessService {

    @Autowired
    private ProjectRiskAssessMapper projectRiskAssessMapper;
    @Autowired
    private ProjectRiskAppendixMapper projectRiskAppendixMapper;
    @Autowired
    private ProjectRiskMapper projectRiskMapper;
    @Autowired
    private ProjectRiskAppendixService projectRiskAppendixService;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ProjectStepMapper projectStepMapper;
    @Autowired
    private ProjectDictionaryItemMapper projectDictionaryItemMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 新建项目风险评估
     */
    public ProjectRiskAssessModel addProjectRiskAssess(ProjectRiskAssessModel model){
        Long projectId = model.getProjectId();
        ProjectModel projectModel = projectMapper.selectById(projectId);
        if (model.getProjectRiskId()!=null){
            String stage = projectRiskMapper.selectById(model.getProjectRiskId()).getStage();
            model.setStage(stage);
        }
        String name = projectModel.getName();
        model.setProjectName(name);

        return model;
    }

    /**
     * 新建项目风险评估提交
     */
    public boolean insertSelective(ProjectRiskAssessModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setRegId(currentUsr.getRegId());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setIsCheck(IsCheckEnum.NOT_SUBMIT.getCode());
        model.setEvaluator(currentUsr.getRealName());
        this.projectRiskAssessMapper.insertSelective(model);
        //新增附件表
        Long id = model.getId();
        List<ProjectRiskAppendixModel> contentAppendix = model.getContentAppendix();
        contentAppendix.forEach(temp ->{
            temp.setBusinessId(id);
            temp.setBusinessName("风险评估内容");
            projectRiskAppendixService.insertSelective(temp);
        });
        return model != null;
    }

    /**
     *分页查询项目风险评估列表
     */
    public BasePageInfo<ProjectRiskAssessModel> selectByFilterAndOrderParams(BasePageInfo<ProjectRiskAssessModel> model){
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectRiskAssessModel> projectRiskAssessModels = projectRiskAssessMapper.selectByFilterAndParams(new PageInfoQueryOrderAndFilterModel<>(model));
        projectRiskAssessModels.forEach(temp->{
            if (temp.getStageId()!=null){
                String stage = projectStepMapper.selectById(temp.getStageId()).getName();
                temp.setStage(stage);
            }
        });
        return new BasePageInfo<>(projectRiskAssessModels);
    }

    /**
     * 项目风险评估详情
     */
    public ProjectRiskAssessModel selectById(ProjectRiskAssessModel projectRiskAssessModel) {
        Long id = projectRiskAssessModel.getId();
        ProjectRiskAssessModel model = projectRiskAssessMapper.selectById(id);
        List<ProjectRiskAppendixModel> contentAppendix = projectRiskAppendixMapper.selectByModel(
                ProjectRiskAppendixModel.builder().businessId(id).businessName("风险评估内容").build());
        contentAppendix.forEach(temp->{
            if (temp.getTypeId()!=null){
                temp.setType(projectDictionaryItemMapper.selectById(temp.getTypeId()).getName());
            }

        });
        if (model.getStageId()!=null){
            String name = projectStepMapper.selectById(model.getStageId()).getName();
            model.setStage(name);
        }
        model.setContentAppendix(contentAppendix);
        return model;
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRiskAssessModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectRiskAssessMapper.updateByIdSelective(model) == 1;
    }


    /**
     * 按主键删除项目风险评估
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRiskAssessMapper.deleteProjectRiskAssess(id) >= 0;
    }
    /**
     * 项目风险评估提交审批
     */
    public boolean updateById(ProjectRiskAssessModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskAssessMapper.checkSubmit(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRiskAssessMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRiskAssessModel model) {
        return model != null && this.projectRiskAssessMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRiskAssessModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRiskAssessModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRiskAssessMapper.insertList(list);
            }
        } else {
            return this.projectRiskAssessMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按模型选择
     */
    public List<ProjectRiskAssessModel> selectByModel(ProjectRiskAssessModel model) {
        return model == null ? new ArrayList<>(0) : this.projectRiskAssessMapper.selectByModel(model);
    }


    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRiskAssessModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRiskAssessMapper.insert(model) == 1;
        }
        return this.projectRiskAssessMapper.updateById(model) == 1;
    }
}