package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowMeetingAppendixMapper;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowMeetingAppendixModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Service
public class ProjectInterflowMeetingAppendixService {

    @Resource
    private ProjectInterflowMeetingAppendixMapper projectInterflowMeetingAppendixMapper;

    @Autowired
    private SysUserService sysUserService;
    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectInterflowMeetingAppendixMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectInterflowMeetingAppendixMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectInterflowMeetingAppendixModel model) {
        return model != null && this.projectInterflowMeetingAppendixMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowMeetingAppendixModel> models) {
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowMeetingAppendixModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowMeetingAppendixMapper.insertList(list);
            }
        } else {
            return this.projectInterflowMeetingAppendixMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowMeetingAppendixModel model) {
        return model != null && this.projectInterflowMeetingAppendixMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowMeetingAppendixModel selectById(Long id) {
        return id == null ? null : this.projectInterflowMeetingAppendixMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowMeetingAppendixModel> selectByModel(ProjectInterflowMeetingAppendixModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowMeetingAppendixMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowMeetingAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAppendixMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowMeetingAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAppendixMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowMeetingAppendixModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAppendixMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(ProjectInterflowMeetingAppendixModel model) {
        if (model == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        if (model.getId() == null) {
            model.setCreateId(user.getUserId());
            model.setCreateBy(user.getRealName());
            model.setCreateTime(new Date());
            int insert = this.projectInterflowMeetingAppendixMapper.insert(model);
            if(insert==1){
                return true;
            }
        }else {
            model.setUpdateId(user.getUserId());
            model.setUpdateBy(user.getRealName());
            model.setUpdateTime(new Date());
            int update = this.projectInterflowMeetingAppendixMapper.updateById(model);
            if(update==1){
                return true;
            }
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    /**
     * 获取会议资料列表
     */
    public List<ProjectInterflowMeetingAppendixModel> selectByMeetingId(ProjectInterflowMeetingAppendixModel model) {
        if (model==null || model.getBusinessId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        return this.projectInterflowMeetingAppendixMapper.selectByMeetingId(model.getBusinessId());
    }
    public List<Long> selectIdtByMeetingId(Long businessId) {
        if (businessId==null ){
            return new ArrayList<>();
        }
        return this.projectInterflowMeetingAppendixMapper.selectByMeetingId(businessId).stream().map(ProjectInterflowMeetingAppendixModel::getId).collect(Collectors.toList());
    }
}