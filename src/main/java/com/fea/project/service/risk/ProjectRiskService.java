package com.fea.project.service.risk;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.dao.base.ProjectDictionaryItemMapper;
import com.fea.project.dao.risk.ProjectRiskAppendixMapper;
import com.fea.project.dao.risk.ProjectRiskAssessMapper;
import com.fea.project.dao.risk.ProjectRiskAssessPlanMapper;
import com.fea.project.dao.risk.ProjectRiskMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.enums.risk.IsControlEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.model.risk.ProjectRiskAppendixModel;
import com.fea.project.model.risk.ProjectRiskAssessModel;
import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import com.fea.project.model.risk.ProjectRiskModel;
import com.fea.project.model.risk.vo.ProjectRiskAssessVo;
import com.fea.project.model.risk.vo.ProjectRiskVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/03.
 */
@Service
public class ProjectRiskService {

    @Autowired
    private ProjectRiskMapper projectRiskMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectRiskAssessMapper projectRiskAssessMapper;
    @Autowired
    private ProjectRiskAssessPlanMapper projectRiskAssessPlanMapper;
    @Autowired
    private ProjectDictionaryItemMapper projectDictionaryItemMapper;
    @Autowired
    private ProjectRiskAppendixMapper projectRiskAppendixMapper;
    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    /**
     * 新增项目风险
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertSelective(ProjectRiskModel model) {
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setIsControl(IsControlEnum.queryCode(model.getIsControlString()));
        model.setRegId(currentUsr.getRegId());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        model.setType(model.getType());
        this.projectRiskMapper.insertSelective(model);
        //更新风险评估计划表
        List<ProjectRiskAssessPlanModel> projectRiskAssessPlanModels = model.getProjectRiskAssessPlanModels();
        if (projectRiskAssessPlanModels!=null){
            projectRiskAssessPlanModels.forEach(temp ->{
                temp.setProjectRiskId(model.getId());
                temp.setCreateId(currentUsr.getUserId());
                temp.setCreateBy(currentUsr.getRealName());
                temp.setCreateTime(new Date());
                temp.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
                projectRiskAssessPlanMapper.insertSelective(temp);
            });
        }
        return model != null;
    }

    /**
     * 上传附件
     */


    /**
     *分页查询项目风险列表
     */
    public BasePageInfo<ProjectRiskModel> selectByFilterAndOrderParams(BasePageInfo<ProjectRiskModel> model){
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectRiskModel> projectRiskModels = projectRiskMapper.selectByFilterAndParams(new PageInfoQueryOrderAndFilterModel<>(model));
        projectRiskModels.forEach(temp ->{
            temp.setIsControlString(IsControlEnum.queryDescription(temp.getIsControl()));
            temp.setTypeString(this.getRiskType(temp.getType()));
            temp.setImpactString(temp.getImpact().toString());
            temp.setProbabilityString(temp.getProbability().toPlainString());
            temp.setRatingString(temp.getRating().toString());
            //查询该项目风险下是否有风险评估计划
            List<ProjectRiskAssessPlanModel> planModels = projectRiskAssessPlanMapper.selectByModel(ProjectRiskAssessPlanModel.builder().projectRiskId(temp.getId()).build());
            if (planModels.isEmpty()){
                temp.setIsAssess(IsControlEnum.CAN_NOT_CONTROL.getText());
            }else {
                temp.setIsAssess(IsControlEnum.CAN_CONTROL.getText());
            }
        });

        return new BasePageInfo<>(projectRiskModels);
    }
    /**
     * 通过数据字典获取项目风险类型
     */
    public String getRiskType(Long type){
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        List<ProjectDictionaryItemSelectVo> vos = projectDictionaryItemService.listByShortNameAndRegIdWhenNullCreate(
                ProjectDictionaryModel.builder().shortName(DictionaryTypeEnum.PROJECT_RISK_TYPE.getValue()).regId(currentUsr.getRegId()).build());

        String name=null;
       for (ProjectDictionaryItemSelectVo vo:vos){
           Long id = projectDictionaryItemMapper.selectById(vo.getId()).getId();
           if (type==id ||type.equals(id)){

               name=vo.getName();
           }
       }
        return name;
    }
    /**
     * 项目风险详情
     */
    public ProjectRiskModel selectById(ProjectRiskModel projectRiskModel) {
        Long id = projectRiskModel.getId();
        ProjectRiskModel model = projectRiskMapper.selectById(id);
        model.setTypeString(this.getRiskType(model.getType()));
        model.setIsControlString(IsControlEnum.queryDescription(model.getIsControl()));
        List<ProjectRiskAppendixModel> solutonsAppendix = projectRiskAppendixMapper.selectByModel(
                ProjectRiskAppendixModel.builder().businessId(id).businessName("应对措施").build());
        solutonsAppendix.forEach(solutons->{
            if (solutons.getTypeId()!=null){
                solutons.setType(projectDictionaryItemMapper.selectById(solutons.getTypeId()).getName());
            }

        });
        List<ProjectRiskAppendixModel> contingencyPlanAppendix = projectRiskAppendixMapper.selectByModel(
                ProjectRiskAppendixModel.builder().businessId(id).businessName("应急计划").build());
        contingencyPlanAppendix.forEach(contingency->{
            if (contingency.getTypeId()!=null){
                contingency.setType(projectDictionaryItemMapper.selectById(contingency.getTypeId()).getName());
            }

        });
        model.setSolutonsAppendix(solutonsAppendix);
        model.setContingencyPlanAppendix(contingencyPlanAppendix);
        //风险评估计划列表
        List<ProjectRiskAssessPlanModel> planModels = projectRiskAssessPlanMapper.selectByModel(ProjectRiskAssessPlanModel.builder().projectRiskId(id).build());
        model.setProjectRiskAssessPlanModels(planModels);
        return model;
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectRiskModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setIsControl(IsControlEnum.queryCode(model.getIsControlString()));
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectRiskMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 风险预警
     */
    public List<ProjectRiskVo> selectByModel(ProjectRiskModel model) {
        List<ProjectRiskModel> projectRiskModels = projectRiskMapper.selectByModel(model);
        List<ProjectRiskVo> projectRiskVos=new ArrayList<>();
        projectRiskModels.forEach(temp ->{
            ProjectRiskVo projectRiskVo =new ProjectRiskVo();
            projectRiskVo.setName(temp.getName());
            projectRiskVo.setRating(temp.getRating());
            List<ProjectRiskAssessModel> assessModels = projectRiskAssessMapper.selectByModel(ProjectRiskAssessModel.builder().projectRiskId(temp.getId()).build());
            List<ProjectRiskAssessVo> assessVos=new ArrayList<>();
            assessModels.forEach(assess->{
                ProjectRiskAssessVo assessVo = new ProjectRiskAssessVo();
                assessVo.setTime(assess.getTime());
                assessVo.setRating(assess.getRating());
                assessVos.add(assessVo);
                projectRiskVo.setProjectRiskAssessVos(assessVos);
            });

            projectRiskVos.add(projectRiskVo);
        });

        return projectRiskVos;
    }

    /**
     * 按主键删除项目风险
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectRiskMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectRiskMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectRiskModel model) {
        return model != null && this.projectRiskMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectRiskModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectRiskModel> list : ListUtil.getSubList(models, 100)) {
                this.projectRiskMapper.insertList(list);
            }
        } else {
            return this.projectRiskMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectRiskModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectRiskModel model) {
        return !(model == null || model.getId() == null) && this.projectRiskMapper.deleteProjectRisk(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectRiskModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectRiskMapper.insert(model) == 1;
        }
        return this.projectRiskMapper.updateById(model) == 1;
    }
}