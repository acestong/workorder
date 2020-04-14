package com.fea.project.service.baseconfig;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodeTaskRegChildMapper;
import com.fea.project.enums.baseconfig.ProjectBaseConfigTaskCodeTypeEnum;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.model.baseconfig.ProjectBaseSetTaskModel;
import com.fea.project.model.baseconfig.ProjectCodeTaskRegChildModel;
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
public class ProjectCodeTaskRegChildService {

    @Autowired
    private ProjectCodeTaskRegChildMapper projectCodeTaskRegChildMapper;

    @Autowired
    private ProjectBaseSetTaskService projectBaseSetTaskService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectCodeTaskRegChildMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectCodeTaskRegChildMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectCodeTaskRegChildModel model) {
        return model != null && this.projectCodeTaskRegChildMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectCodeTaskRegChildModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectCodeTaskRegChildModel> list : ListUtil.getSubList(models, 100)) {
                this.projectCodeTaskRegChildMapper.insertList(list);
            }
        } else {
            return this.projectCodeTaskRegChildMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectCodeTaskRegChildModel model) {
        return model != null && this.projectCodeTaskRegChildMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectCodeTaskRegChildModel selectById(Long id) {
        return id == null ? null : this.projectCodeTaskRegChildMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectCodeTaskRegChildModel> selectByModel(ProjectCodeTaskRegChildModel model) {
        return model == null ? new ArrayList<>(0) : this.projectCodeTaskRegChildMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectCodeTaskRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeTaskRegChildMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectCodeTaskRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeTaskRegChildMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectCodeTaskRegChildModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeTaskRegChildMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectCodeTaskRegChildModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectCodeTaskRegChildMapper.insertSelective(model) == 1;
        }
        return this.projectCodeTaskRegChildMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 该方法未加锁，使用时请根据范围进行加锁
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String selectTaskCode(ProjectCodeTaskRegChildModel model) {
    	 if (model == null || model.getProjectId() == null || !ProjectBaseConfigTaskCodeTypeEnum.getPlanCodes().contains(model.getTypeId())) {
            throw new SystemParamCheckException("项目参数传入异常，计划编号无法获取");
        }
        if (ProjectBaseConfigTaskCodeTypeEnum.TYPE_PROJECT_CHILDREN_TASK.getValue()
                .equals(model.getTypeId()) && model.getParentTaskId() == null) {
            throw new SystemParamCheckException("父计划id未传入");
        } else if (!ProjectBaseConfigTaskCodeTypeEnum.TYPE_PROJECT_CHILDREN_TASK.getValue()
                .equals(model.getTypeId())) {
            model.setParentTaskId(null);
        }
        //获取组织下的整体配置
        ProjectBaseSetTaskModel projectBaseSetTaskModel = this.projectBaseSetTaskService
                .selectByRegIdAndTypeId(UserUtil.getUserRegId(), model.getTypeId());
        if (projectBaseSetTaskModel == null || projectBaseSetTaskModel.getNumber() == null) {
            throw new SystemParamCheckException("计划编号设置异常，请进行确认");
        }
        Date date = new Date();
        model.setDateStr(DateUtil.getTimeStrByDateAndDateFormate(date
                , ProjectCodeDateStrEnum.TYPE_YEAR.getDateFormat()));
        return this.selectTaskCodeByProjectInfo(model, projectBaseSetTaskModel, date);

    }

    private String selectTaskCodeByProjectInfo(ProjectCodeTaskRegChildModel model, ProjectBaseSetTaskModel projectBaseSetTaskModel, Date date) {
        List<ProjectCodeTaskRegChildModel> list = this.projectCodeTaskRegChildMapper.selectByModel(model);
        if (list.size() > 1) {
            throw new SystemParamCheckException("查询出当前项目下多条项目编号数据，请确认参数是否正确");
        }
        if (list.isEmpty()) {
            model.setRegId(UserUtil.getUserRegId());
            model.setTaskCode(StringUtil.getInitStartCodeByLength(projectBaseSetTaskModel.getNumber()));
        } else {
            model = list.get(0);
        }
        model.setTaskCode(StringUtil.getNextCodeByCurrentStr(model.getTaskCode(), projectBaseSetTaskModel.getNumber()));
        if (this.insertOrUpdate(model)) {
            return projectBaseSetTaskModel.getPlanCodeNumber(date) + model.getTaskCode();
        }
        throw new SystemParamCheckException("计划编号生成报错");
    }
}