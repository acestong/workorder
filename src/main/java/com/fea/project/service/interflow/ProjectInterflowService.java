package com.fea.project.service.interflow;


import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.interflow.ProjectInterflowEmailsModel;
import com.fea.project.model.interflow.ProjectInterflowMeetingModel;
import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import com.fea.project.model.interflow.ProjectInterflowVisitingModel;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import com.fea.project.model.projectdata.DataTeamVo;
import com.fea.project.service.projectdata.DataFileService;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Service
public class ProjectInterflowService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectInterflowService.class);


    @Autowired
    private ProjectInterflowMeetingService projectInterflowMeetingService;
    @Autowired
    private ProjectInterflowPhoneService projectInterflowPhoneService;
    @Autowired
    private ProjectInterflowEmailsService projectInterflowEmailsService;
    @Autowired
    private ProjectInterflowVisitingService projectInterflowVisitingService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private DataFileService dataFileService;
    /**
     * 按模型选择
     */
    public PageInfo<ProjectInterflowListShowVo> showList(BasePageInfo<DataTeamVo> model) {
        if (model.getModel().getProjectId() == null){
            throw new SystemParamCheckException("参数传入有误，无法查询");
        }
        QueryInterflowParamVo queryInterflowParamVo = new QueryInterflowParamVo(model);
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //存放userIds
        ArrayList<Long> createIds = new ArrayList<>();
        if (null == model.getModel().getTag()){
            //我的
            createIds.add(currentUsr.getUserId());
            queryInterflowParamVo.setCreateIds(createIds);
        }else if (0 == model.getModel().getTag()){
            //团队的
            List<Long> userIdsByTeamId = dataFileService.getUserIdsByTeamId(model.getModel().getId());
            if (userIdsByTeamId.isEmpty()){
                return new BasePageInfo<>(new ArrayList<>());
            }
            queryInterflowParamVo.setCreateIds(userIdsByTeamId);

        }else if (1 == model.getModel().getTag()){
            //员工的
            if (model.getModel().getId() == null){
                throw new SystemParamCheckException("参数传入错误，无法查询");
            }
            createIds.add(model.getModel().getId());
            queryInterflowParamVo.setCreateIds(createIds);
        }else {
            //全部的
        }
        List<ProjectInterflowListShowVo> finalList=new ArrayList<>();
        Integer total = 0;
        List<ProjectInterflowListShowVo> meetingList = projectInterflowMeetingService.showMeetingList(queryInterflowParamVo);
        total+=meetingList.size();
        List<ProjectInterflowListShowVo> phoneList = projectInterflowPhoneService.showPhoneList(queryInterflowParamVo);
        total+=phoneList.size();
        List<ProjectInterflowListShowVo> emailsList = projectInterflowEmailsService.showEmailsList(queryInterflowParamVo);
        total+=emailsList.size();
        List<ProjectInterflowListShowVo> visitingList = projectInterflowVisitingService.showVisitingList(queryInterflowParamVo);
        total+=visitingList.size();
        finalList.addAll(meetingList);
        finalList.addAll(phoneList);
        finalList.addAll(emailsList);
        finalList.addAll(visitingList);
        Collections.sort(finalList);
        //返回数据处理
        Integer index = (model.getPageNum()-1)*model.getPageSize();
        Integer toIndex = model.getPageNum()*model.getPageSize()>=total?
                total:model.getPageNum()*model.getPageSize();
        List<ProjectInterflowListShowVo> subList = ListUtil.getSubList(finalList, index, toIndex);
        PageInfo<ProjectInterflowListShowVo> pageInfo = new BasePageInfo<>(subList);
        pageInfo.setTotal(total);
        pageInfo.setPageNum(model.getPageNum());
        pageInfo.setPageSize(model.getPageSize());
        return pageInfo;
    }

    /**
     * 按主键删除
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectInterflowListShowVo delete(ProjectInterflowListShowVo model) {
        if (model==null || model.getId()==null || model.getType()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        if (Objects.equals(InterflowTypeEnum.MEETING.getCode(),model.getType())){
            projectInterflowMeetingService.deleteById(new ProjectInterflowMeetingModel(model.getId()));
        }else if(Objects.equals(InterflowTypeEnum.PHONE.getCode(),model.getType())){
            projectInterflowPhoneService.deleteById(new ProjectInterflowPhoneModel(model.getId()));
        }else if(Objects.equals(InterflowTypeEnum.EMAILS.getCode(),model.getType())){
            projectInterflowEmailsService.deleteById(new ProjectInterflowEmailsModel(model.getId()));
        }else if(Objects.equals(InterflowTypeEnum.VISITING.getCode(),model.getType())){
            projectInterflowVisitingService.deleteById(new ProjectInterflowVisitingModel(model.getId()));
        }else {
            throw new SystemParamCheckException("交流类型参数传入错误");
        }
        return model;
    }
}