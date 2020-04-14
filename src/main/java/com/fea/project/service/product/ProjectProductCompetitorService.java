package com.fea.project.service.product;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.product.ProjectProductCompetitorMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.risk.IsControlEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.product.ProjectProductCompetitorModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.model.risk.ProjectRiskAssessPlanModel;
import com.fea.project.model.risk.ProjectRiskModel;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/23.
 */
@Service
public class ProjectProductCompetitorService {

    @Autowired
    private ProjectProductCompetitorMapper projectProductCompetitorMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectProductCompetitorModel model) {
        if (model == null ){
            throw new SystemParamCheckException("参数传入错误");
        }
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectProductCompetitorMapper.insertSelective(model) == 1;
    }

    /**
     *分页查询项目风险列表
     */
    public BasePageInfo<ProjectProductCompetitorModel> selectByFilterAndOrderParams(BasePageInfo<ProjectProductCompetitorModel> model){
        PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<ProjectProductCompetitorModel> competitorModels = projectProductCompetitorMapper.selectByFilterAndParams(new PageInfoQueryOrderAndFilterModel<>(model));


        return new BasePageInfo<>(competitorModels);
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductCompetitorMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductCompetitorMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductCompetitorModel model) {
        return model != null && this.projectProductCompetitorMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductCompetitorModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductCompetitorModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductCompetitorMapper.insertList(list);
            }
        } else {
            return this.projectProductCompetitorMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectProductCompetitorModel selectById(Long id) {
        return id == null ? null : this.projectProductCompetitorMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductCompetitorModel> selectByModel(ProjectProductCompetitorModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductCompetitorMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductCompetitorModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新人
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectProductCompetitorMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductCompetitorModel model) {

        return !(model == null || model.getId() == null) && this.projectProductCompetitorMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductCompetitorModel model) {
        return !(model == null || model.getId() == null) && this.projectProductCompetitorMapper.deleteProductCompetitor(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductCompetitorModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductCompetitorMapper.insert(model) == 1;
        }
        return this.projectProductCompetitorMapper.updateById(model) == 1;
    }
}