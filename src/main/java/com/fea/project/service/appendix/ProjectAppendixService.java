package com.fea.project.service.appendix;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.appendix.ProjectAppendixMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.plan.vo.AppendixIdAndNameInfoModelVo;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/10/25.
 * 附件表  Service
 */
@Service
public class ProjectAppendixService {

    @Autowired
    private ProjectAppendixMapper projectAppendixMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectAppendixMapper.deleteById(id) >= 0;
    }
    /**
     * 按业务id删除
     */
    public boolean deleteByBusinessId(Long businessId) {
    	return businessId != null && this.projectAppendixMapper.deleteByBusinessId(businessId) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectAppendixMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectAppendixModel model) {
        return model != null && this.projectAppendixMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectAppendixModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectAppendixModel> list : ListUtil.getSubList(models, 100)) {
                this.projectAppendixMapper.insertList(list);
            }
        } else {
            return this.projectAppendixMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public ProjectAppendixModel insertSelective(ProjectAppendixModel model) {
        if (this.projectAppendixMapper.insertSelective(model) == 1){
            return model;
        }
        return null ;
    }

    /**
     * 按主键选择
     */
    public ProjectAppendixModel selectById(Long id) {
        return id == null ? null : this.projectAppendixMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectAppendixModel> selectByModel(ProjectAppendixModel model) {

        return model == null ? new ArrayList<>(0) : this.projectAppendixMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateByIdSelective(ProjectAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectAppendixMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectAppendixMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectAppendixModel model) {
        //更新刪除状态
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        return !(model == null || model.getId() == null) && this.projectAppendixMapper.updateByIdSelective(model) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectAppendixModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectAppendixMapper.insert(model) == 1;
        }
        return this.projectAppendixMapper.updateById(model) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateByBusinessIdAndIds(Long businessId, List<Long> appendixs) {
        if(appendixs == null || businessId == null){
            throw new SystemParamCheckException("传入的参数异常，附件信息更新异常");
        }
        if(this.projectAppendixMapper.updateDeleteStatueByBusinessIdAndIds(businessId, appendixs) >= 0 &&
                appendixs.isEmpty()){
            return Boolean.TRUE;
        }
        if(this.projectAppendixMapper.updateByBusinessIdAndIds(businessId, appendixs) >= 0){
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("附件信息更新异常");
    }
    /**
     * 通过业务id查询附件的id和文件名称
     */
    public List<AppendixIdAndNameInfoModelVo> selectIdAndNameByBusiness(Long businessId){
        return projectAppendixMapper.selectIdAndNameByBusiness(businessId);
    }
    public List<Long> selectIdByBusinessId(Long businessId){
        if (businessId==null){
            return new ArrayList<>();
        }
        return projectAppendixMapper.selectIdAndNameByBusiness(businessId).stream().map(AppendixIdAndNameInfoModelVo::getAppendixId).collect(Collectors.toList());
    }
}