package com.fea.project.service.apply;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.apply.ProjectApplyCodeMapper;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.model.apply.ProjectApplyCodeModel;
import com.fea.project.model.apply.ProjectApplyCodeRegModel;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 */
@Service
public class ProjectApplyCodeService {

    @Autowired
    private ProjectApplyCodeMapper projectApplyCodeMapper;

    @Autowired
    private ProjectApplyCodeRegService projectApplyCodeRegService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectApplyCodeMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectApplyCodeMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectApplyCodeModel model) {
        return model != null && this.projectApplyCodeMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectApplyCodeModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectApplyCodeModel> list : ListUtil.getSubList(models, 100)) {
                this.projectApplyCodeMapper.insertList(list);
            }
        } else {
            return this.projectApplyCodeMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectApplyCodeModel model) {
        return model != null && this.projectApplyCodeMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectApplyCodeModel selectById(Long id) {
        return id == null ? null : this.projectApplyCodeMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectApplyCodeModel> selectByModel(ProjectApplyCodeModel model) {
        return model == null ? new ArrayList<>(0) : this.projectApplyCodeMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectApplyCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectApplyCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectApplyCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectApplyCodeMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectApplyCodeModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectApplyCodeMapper.insert(model) == 1;
        }
        return this.projectApplyCodeMapper.updateById(model) == 1;
    }

    /**
     * 创建组织流程申请类型码
     *
     * @param flowType
     * @return
     */
    public synchronized String createRegFlowTypeCode(int flowType) {
        Long regId = UserUtil.getUserRegId();
        ProjectApplyCodeModel projectApplyCodeModel = this.getProjectApplyCodeConfig(regId, flowType);
        //判定周期是否需要进行更新还是新增
        Date currentTime = new Date();
        String dateStr = new SimpleDateFormat(ProjectCodeDateStrEnum.getTargetDateFormat(projectApplyCodeModel.getDataStr())).format(currentTime);
        ProjectApplyCodeRegModel projectApplyCodeRegModel = projectApplyCodeRegService.getProjectApplyCodeConfig(regId, flowType, projectApplyCodeModel, currentTime);
        return projectApplyCodeModel.getShortName() + dateStr + projectApplyCodeRegModel.getLastCode();
    }

    private ProjectApplyCodeModel getProjectApplyCodeConfig(Long regId, int flowType) {
        ProjectApplyCodeModel projectApplyCodeModel = this.projectApplyCodeMapper.selectByRegIdAndFlowType(regId, flowType);
        if (projectApplyCodeModel == null) {
            projectApplyCodeModel = this.projectApplyCodeMapper.selectDefaultSet(flowType);
            if (projectApplyCodeModel == null) {
                throw new SystemParamCheckException("项目流程流程申请编号配置表中不存在默认配置");
            }
            projectApplyCodeModel.setRegId(regId);
            this.projectApplyCodeMapper.insertSelective(projectApplyCodeModel);
        }
        return projectApplyCodeModel;
    }
}