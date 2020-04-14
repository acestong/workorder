package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowMeetingMapper;
import com.fea.project.dao.interflow.ProjectInterflowMeetingUserMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.enums.interflow.MeetingTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.base.AppendixModel;
import com.fea.project.model.interflow.*;
import com.fea.project.model.interflow.vo.InterflowMeetingVo;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowMeetingModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.util.ListUtil;

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
public class ProjectInterflowMeetingService {

    @Resource
    private ProjectInterflowMeetingMapper projectInterflowMeetingMapper;
    @Autowired
    private ProjectInterflowMeetingUserService meetingUserService;
    @Autowired
    private ProjectInterflowContactsService contactsService;
    @Autowired
    private ProjectInterflowMeetingAgendaService agendaService;
    @Autowired
    private ProjectInterflowMeetingAppendixService meetingAppendixService;
    @Autowired
    private ProjectAppendixService appendixService;
    @Autowired
    private SysUserService sysUserService;

    public List<ProjectInterflowListShowVo> showMeetingList(QueryInterflowParamVo model){
        List<ProjectInterflowListShowVo> listShowVos = projectInterflowMeetingMapper.selectShowListByProjectId(model);
        listShowVos.forEach(vo->{
            vo.setTypeString(InterflowTypeEnum.getMap().get(vo.getType()));
            vo.setWayString(MeetingTypeEnum.getMap().get(vo.getWay()));
        });
        return listShowVos;
    }
    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(InterflowMeetingVo<ProjectInterflowMeetingModel> model) {
        if (model == null) {
            throw new SystemParamCheckException("参数传入错误，无法新增");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectInterflowMeetingModel meetingModel = model.getMeetingModel();
        meetingModel.setType(InterflowTypeEnum.MEETING.getCode());
        meetingModel.setCreateId(currentUsr.getUserId());
        meetingModel.setCreateBy(currentUsr.getRealName());
        meetingModel.setCreateTime(new Date());
        meetingModel.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        //添加会议主表
        int i = projectInterflowMeetingMapper.insertSelective(meetingModel);
        if (i == 1) {
            try {
                Long meetingId = meetingModel.getId();
                //添加内部参与人
                List<ProjectInterflowMeetingUserModel> meetingUserModels = new ArrayList<>();
                model.getMeetingModel().getUserIds().forEach(id -> {
                    meetingUserModels.add(new ProjectInterflowMeetingUserModel(meetingId, id, currentUsr));
                });
                boolean a = meetingUserService.insertList(meetingUserModels);
                //添加外部联系人
                List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
                contactModels.forEach(contact -> {
                    contact.setBusinessId(meetingId);
                    contact.setCreateId(currentUsr.getUserId());
                    contact.setCreateBy(currentUsr.getRealName());
                    contact.setCreateTime(new Date());
                    contact.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
                });
                boolean b = contactsService.insertList(contactModels);
                //添加会议议程
                List<ProjectInterflowMeetingAgendaModel> agendaModels = model.getAgendaModels();
                agendaModels.forEach(agenda -> {
                    agenda.setMeetingId(meetingId);
                    agenda.setCreateId(currentUsr.getUserId());
                    agenda.setCreateBy(currentUsr.getRealName());
                    agenda.setCreateTime(new Date());
                });
                boolean c = agendaService.insertList(agendaModels);
                //添加会议资料
                List<ProjectInterflowMeetingAppendixModel> meetingAppendixModels = model.getMeetingAppendixModels();
                meetingAppendixModels.forEach(meetingAppendix -> {
                    meetingAppendix.setBusinessId(meetingId);
                    meetingAppendix.setCreateId(currentUsr.getUserId());
                    meetingAppendix.setCreateBy(currentUsr.getRealName());
                    meetingAppendix.setCreateTime(new Date());
                    boolean b1 = meetingAppendixService.insertSelective(meetingAppendix);
                    if (b1) {
                        List<ProjectAppendixModel> appendixIds = meetingAppendix.getAppendixIds();
                        appendixIds.forEach(appendixId -> {
                            boolean e = appendixService.updateByIdSelective(new ProjectAppendixModel(appendixId.getId(),
                                    meetingAppendix.getId()));
                        });
                    }
                });
                //附件处理
                List<Long> appendixIds = model.getAppendixIds();
                appendixIds.forEach(appendixId -> {
                    boolean e = appendixService.updateByIdSelective(new ProjectAppendixModel(appendixId,
                            meetingId));
                });
            } catch (Exception e) {
                throw new SystemParamCheckException("数据更新报错，请重试");
            }
        } else {
            throw new SystemParamCheckException("新增失败，请重试");
        }
        return true;
    }
    /**
     * 按主键选择
     */
    public InterflowMeetingVo selectById(ProjectInterflowMeetingModel model) {
        if (model==null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectInterflowMeetingModelVo meetingModelVo = this.projectInterflowMeetingMapper.selectModelVoById(model.getId());
        meetingModelVo.setTypeString(InterflowTypeEnum.getMap().get(meetingModelVo.getType()));
        meetingModelVo.setWayString(MeetingTypeEnum.getMap().get(meetingModelVo.getWay()));
        if (!meetingModelVo.getUserIds().isEmpty()){
            List<SysUserModel> sysUserModels = sysUserService.selectByIds(meetingModelVo.getUserIds());
            List<String> collect = sysUserModels.stream().map(SysUserModel::getRealName).collect(Collectors.toList());
            meetingModelVo.setUserNames(collect);
        }
        //获取外部联系人
        List<ProjectInterflowContactsModel> contactsModels =
                contactsService.selectByModel(new ProjectInterflowContactsModel(model.getId()));
        //获取会议议程
        List<ProjectInterflowMeetingAgendaModel> agendaModels =
                agendaService.selectByModel(new ProjectInterflowMeetingAgendaModel(model.getId()));
        //获取会议资料
        List<ProjectInterflowMeetingAppendixModel> meetingAppendixModels =
                meetingAppendixService.selectByMeetingId(new ProjectInterflowMeetingAppendixModel(model.getId()));
        meetingAppendixModels.forEach(meetingAppendixModel ->{
            meetingAppendixModel.setAppendixIds(appendixService.selectByModel(new ProjectAppendixModel(meetingAppendixModel.getId())));
        });
        return new InterflowMeetingVo(meetingModelVo,contactsModels,agendaModels,meetingAppendixModels);
    }
    /**
     * 保存编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowMeetingVo update(InterflowMeetingVo<ProjectInterflowMeetingModel> model){
        if (model==null){
            throw new SystemParamCheckException("参数传入错误，无法更新");
        }
        try {
            SysUserModel currentUsr = sysUserService.getCurrentUsr();
            ProjectInterflowMeetingModel meetingModel = model.getMeetingModel();
            meetingModel.setUpdateId(currentUsr.getUserId());
            meetingModel.setUpdateBy(currentUsr.getRealName());
            meetingModel.setUpdateTime(new Date());
            int i = this.projectInterflowMeetingMapper.updateByIdSelective(meetingModel);
            //内部参与人处理
            List<Long> userIds = meetingModel.getUserIds()==null?new ArrayList<>():meetingModel.getUserIds();
            boolean a = meetingUserService.updateMeetingUsers(meetingModel.getId(),userIds);
            //外部联系人
            List<Long> contactsList = contactsService.selectByBusinessId(meetingModel.getId());
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                if (contact.getId()!=null && contactsList.contains(contact.getId())){
                    contactsList.remove(contact.getId());
                }
                contact.setBusinessId(meetingModel.getId());
                boolean b = contactsService.insertOrUpdate(contact);
            });
            boolean b = contactsService.deleteByIds(contactsList);
            //会议议程
            List<Long> agendList = agendaService.selectByBusinessId(meetingModel.getId());
            List<ProjectInterflowMeetingAgendaModel> agendaModels = model.getAgendaModels()==null?new ArrayList<>():model.getAgendaModels();
            agendaModels.forEach(agenda->{
                if (agenda.getId()!=null && agendList.contains(agenda.getId())){
                    agendList.remove(agenda.getId());
                }
                agenda.setMeetingId(meetingModel.getId());
                boolean c = agendaService.insertOrUpdate(agenda);
            });
            boolean b1 = agendaService.deleteByIds(agendList);
            //会议资料
            List<Long> meetingAppendixIds = meetingAppendixService.selectIdtByMeetingId(meetingModel.getId());
            List<ProjectInterflowMeetingAppendixModel> meetingAppendixModels = model.getMeetingAppendixModels()==null?new ArrayList<>():model.getMeetingAppendixModels();
            meetingAppendixModels.forEach(meetingAppendix->{
                if (meetingAppendix.getId()!=null && meetingAppendixIds.contains(meetingAppendix.getId())){
                    meetingAppendixIds.remove(meetingAppendix.getId());
                }
                meetingAppendix.setBusinessId(meetingModel.getId());
                boolean d = meetingAppendixService.insertOrUpdate(meetingAppendix);
                if (d){
                    List<Long> meetingAppendixList = appendixService.selectIdByBusinessId(meetingAppendix.getId());
                    List<ProjectAppendixModel> appendixIds = meetingAppendix.getAppendixIds();
                    appendixIds.forEach(appendixId->{
                        if (meetingAppendixList.contains(appendixId.getId())){
                            meetingAppendixList.remove(appendixId.getId());
                        }
                        try {
                            boolean e = appendixService.updateByIdSelective(new ProjectAppendixModel(appendixId.getId(),
                                    meetingAppendix.getId()));
                        } catch (Exception e) {
                            throw new SystemParamCheckException("数据更新报错，请重试");
                        }
                    });
                    boolean b3 = appendixService.deleteByIds(meetingAppendixList);
                }
            });
            boolean b2 = meetingAppendixService.deleteByIds(meetingAppendixIds);
            //会议附件
            if (model.getAppendixIds()!=null){
                List<Long> appendixList = appendixService.selectIdByBusinessId(meetingModel.getId());
                List<Long> appendixIds = model.getAppendixIds();
                appendixIds.forEach(appendixId->{
                    if (appendixList.contains(appendixId)){
                        appendixList.remove(appendixId);
                    }
                    boolean e = appendixService.updateByIdSelective(new ProjectAppendixModel(appendixId,
                            meetingModel.getId()));
                });
                boolean b3 = appendixService.deleteByIds(appendixList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemParamCheckException("数据更新报错，请重试");
        }
        return model;
    }
    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowMeetingModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowMeetingModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowMeetingMapper.insertList(list);
            }
        } else {
            return this.projectInterflowMeetingMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowMeetingModel model) {
        return model != null && this.projectInterflowMeetingMapper.insertSelective(model) == 1;
    }


    /**
     * 按模型选择
     */
    public List<ProjectInterflowMeetingModel> selectByModel(ProjectInterflowMeetingModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowMeetingMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowMeetingModel model) {
        if (model == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateId(user.getUserId());
        model.setUpdateBy(user.getRealName());
        model.setUpdateTime(new Date());
        int i = this.projectInterflowMeetingMapper.updateByIdSelective(model);
        if (i==1){
            return true;
        }
        return false;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowMeetingModel model) {

        return !(model == null || model.getId() == null) && this.projectInterflowMeetingMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(ProjectInterflowMeetingModel model) {
        if (model == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateId(user.getUserId());
        model.setUpdateBy(user.getRealName());
        model.setUpdateTime(new Date());
        model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        int i = this.projectInterflowMeetingMapper.updateByIdSelective(model);
        if (i==1){
            return true;
        }
        throw new SystemParamCheckException("数据更新失败请重试");
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectInterflowMeetingModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectInterflowMeetingMapper.insert(model) == 1;
        }
        return this.projectInterflowMeetingMapper.updateById(model) == 1;
    }
}