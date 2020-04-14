package com.fea.project.service.baseconfig;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodePLanRegChildMapper;
import com.fea.project.enums.baseconfig.ProjectBaseConfigPlanCodeTypeEnum;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.model.baseconfig.ProjectBaseSetPlanModel;
import com.fea.project.model.baseconfig.ProjectCodePLanRegChildModel;
import com.fea.project.util.DateUtil;
import com.fea.project.util.ListUtil;
import com.fea.project.util.StringUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/11/05.
 */
@Service
public class ProjectCodePLanRegChildService {

    @Autowired
    private ProjectCodePLanRegChildMapper projectCodePLanRegChildMapper;

    @Autowired
    private ProjectBaseSetPlanService projectBaseSetPlanService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectCodePLanRegChildMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectCodePLanRegChildMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectCodePLanRegChildModel model) {
        return model != null && this.projectCodePLanRegChildMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectCodePLanRegChildModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectCodePLanRegChildModel> list : ListUtil.getSubList(models, 100)) {
                this.projectCodePLanRegChildMapper.insertList(list);
            }
        } else {
            return this.projectCodePLanRegChildMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectCodePLanRegChildModel model) {
        return model != null && this.projectCodePLanRegChildMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectCodePLanRegChildModel selectById(Long id) {
        return id == null ? null : this.projectCodePLanRegChildMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectCodePLanRegChildModel> selectByModel(ProjectCodePLanRegChildModel model) {
        return model == null ? new ArrayList<>(0) : this.projectCodePLanRegChildMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectCodePLanRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodePLanRegChildMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectCodePLanRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodePLanRegChildMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectCodePLanRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodePLanRegChildMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectCodePLanRegChildModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectCodePLanRegChildMapper.insertSelective(model) == 1;
        }
        return this.projectCodePLanRegChildMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 该方法未加锁，使用时请根据范围进行加锁
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String selectPlanCode(ProjectCodePLanRegChildModel model) {
        if (model == null || model.getProjectId() == null
                || !ProjectBaseConfigPlanCodeTypeEnum.getPlanCodes().contains(model.getTypeId())) {
            throw new SystemParamCheckException("项目参数传入异常，计划编号无法获取");
        }
        if (ProjectBaseConfigPlanCodeTypeEnum.TYPE_PROJECT_CHILDREN_PLAN.getValue()
                .equals(model.getTypeId()) && model.getParentPlanId() == null) {
            throw new SystemParamCheckException("父计划id未传入");
        } else if (!ProjectBaseConfigPlanCodeTypeEnum.TYPE_PROJECT_CHILDREN_PLAN.getValue()
                .equals(model.getTypeId())) {
            model.setParentPlanId(null);
        }
        //获取组织下的整体配置
        ProjectBaseSetPlanModel projectBaseSetPlanModel = this.projectBaseSetPlanService
                .selectByRegIdAndTypeId(UserUtil.getUserRegId(), model.getTypeId());
        if (projectBaseSetPlanModel == null || projectBaseSetPlanModel.getNumber() == null) {
            throw new SystemParamCheckException("计划编号设置异常，请进行确认");
        }
        Date date = new Date();
        model.setDateStr(DateUtil.getTimeStrByDateAndDateFormate(date
                , ProjectCodeDateStrEnum.TYPE_YEAR.getDateFormat()));
        return this.selectPlanCodeByProjectInfo(model, projectBaseSetPlanModel, date);
    }

    private String selectPlanCodeByProjectInfo(ProjectCodePLanRegChildModel model, ProjectBaseSetPlanModel projectBaseSetPlanModel, Date date) {
        List<ProjectCodePLanRegChildModel> list = this.projectCodePLanRegChildMapper.selectByModel(model);
        if (list.size() > 1) {
            throw new SystemParamCheckException("查询出当前项目下多条项目编号数据，请确认参数是否正确");
        }
        if (list.isEmpty()) {
            model.setRegId(UserUtil.getUserRegId());
            model.setPlanCode(StringUtil.getInitStartCodeByLength(projectBaseSetPlanModel.getNumber()));
        } else {
            model = list.get(0);
        }
        model.setPlanCode(StringUtil.getNextCodeByCurrentStr(model.getPlanCode(), projectBaseSetPlanModel.getNumber()));
        if (this.insertOrUpdate(model)) {
            return projectBaseSetPlanModel.getPlanCodeNumber(date) + model.getPlanCode();
        }
        throw new SystemParamCheckException("计划编号生成报错");
    }
}