package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowMeetingUserMapper;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowMeetingUserModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Service
public class ProjectInterflowMeetingUserService {

    @Resource
    private ProjectInterflowMeetingUserMapper projectInterflowMeetingUserMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectInterflowMeetingUserMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectInterflowMeetingUserMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectInterflowMeetingUserModel model) {
        return model != null && this.projectInterflowMeetingUserMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowMeetingUserModel> models) {
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowMeetingUserModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowMeetingUserMapper.insertList(list);
            }
        } else {
            return this.projectInterflowMeetingUserMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowMeetingUserModel model) {
        return model != null && this.projectInterflowMeetingUserMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowMeetingUserModel selectById(Long id) {
        return id == null ? null : this.projectInterflowMeetingUserMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowMeetingUserModel> selectByModel(ProjectInterflowMeetingUserModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowMeetingUserMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowMeetingUserModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingUserMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowMeetingUserModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingUserMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowMeetingUserModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowMeetingUserMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectInterflowMeetingUserModel model) {
        if (model == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        if (model.getId() == null) {
            model.setCreateId(user.getUserId());
            model.setCreateBy(user.getRealName());
            model.setCreateTime(new Date());
            int insert = this.projectInterflowMeetingUserMapper.insert(model);
            if(insert==1){
                return true;
            }
        }else {
            model.setUpdateId(user.getUserId());
            model.setUpdateBy(user.getRealName());
            model.setUpdateTime(new Date());
            int update = this.projectInterflowMeetingUserMapper.updateById(model);
            if(update==1){
                return true;
            }
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    public boolean updateMeetingUsers(Long meetingId,List<Long> userIds){
        /*List<Long> oldList = projectInterflowMeetingUserMapper.selectUsersByMeetingId(meetingId);
        oldList.removeAll(userIds);*/
        int i = projectInterflowMeetingUserMapper.deleteByMeetingId(meetingId);
        SysUserModel user = sysUserService.getCurrentUsr();
        List<ProjectInterflowMeetingUserModel> meetingUserModels = new ArrayList<>();
        userIds.forEach(id ->{
            meetingUserModels.add(new ProjectInterflowMeetingUserModel(meetingId,id,user));
        });
        int j = projectInterflowMeetingUserMapper.insertList(meetingUserModels);
        if (i>=0 && j>=0){
            return true;
        }
        throw new SystemParamCheckException("会议参与人更新错误，请重试");
    }
    /**
     * 获取会议内部参与人IDS
     */
    public List<Long> selectUsersByMeetingId(Long meetingId){
        List<Long> list = projectInterflowMeetingUserMapper.selectUsersByMeetingId(meetingId);
        return list;
    }

}