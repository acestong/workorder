package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowMeetingAgendaMapper;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowMeetingAgendaModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ProjectInterflowMeetingAgendaService {

    @Resource
    private ProjectInterflowMeetingAgendaMapper projectInterflowMeetingAgendaMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectInterflowMeetingAgendaMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectInterflowMeetingAgendaMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectInterflowMeetingAgendaModel model) {
        return model != null && this.projectInterflowMeetingAgendaMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowMeetingAgendaModel> models) {
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowMeetingAgendaModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowMeetingAgendaMapper.insertList(list);
            }
        } else {
            return this.projectInterflowMeetingAgendaMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowMeetingAgendaModel model) {
        return model != null && this.projectInterflowMeetingAgendaMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowMeetingAgendaModel selectById(Long id) {
        return id == null ? null : this.projectInterflowMeetingAgendaMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowMeetingAgendaModel> selectByModel(ProjectInterflowMeetingAgendaModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowMeetingAgendaMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowMeetingAgendaModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAgendaMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowMeetingAgendaModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAgendaMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowMeetingAgendaModel model) {

        return !(model == null || model.getId() == null) && this.projectInterflowMeetingAgendaMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(ProjectInterflowMeetingAgendaModel model) {
        if (model == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        if (model.getId() == null) {
            model.setCreateId(user.getUserId());
            model.setCreateBy(user.getRealName());
            model.setCreateTime(new Date());
            int insert = this.projectInterflowMeetingAgendaMapper.insert(model);
            if(insert==1){
                return true;
            }
        }else {
            model.setUpdateId(user.getUserId());
            model.setUpdateBy(user.getRealName());
            model.setUpdateTime(new Date());
            int update = this.projectInterflowMeetingAgendaMapper.updateById(model);
            if(update==1){
                return true;
            }
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    public List<Long> selectByBusinessId(Long meetingId) {
        List<Long> list = projectInterflowMeetingAgendaMapper.selectByBusinessId(meetingId);
        return list;
    }
}