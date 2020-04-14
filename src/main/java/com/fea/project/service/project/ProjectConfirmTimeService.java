package com.fea.project.service.project;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectConfirmTimeModelMapper;
import com.fea.project.dao.project.ProjectMHourManageModelMapper;
import com.fea.project.dao.project.ProjectOvertimeModelMapper;
import com.fea.project.model.project.ProjectConfirmTimeModel;
import com.fea.project.model.project.ProjectMHourManageModel;
import com.fea.project.model.project.ProjectOvertimeModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @autor Administrator
 * @date: 2019/12/12
 * @time: 14:24
 */
@Service
public class ProjectConfirmTimeService {



    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectConfirmTimeModelMapper projectConfirmTimeModelMapper;

    @Autowired
    private ProjectMHourManageModelMapper projectMHourManageModelMapper;


    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertModel(ProjectConfirmTimeModel model) {
        model.setCreateBy(sysUserService.getCurrentUsr().getRealName());
        model.setCreateId(sysUserService.getCurrentUsr().getUserId());
        model.setCreateTime(new Date());
       return projectConfirmTimeModelMapper.insert(model);
    }

    /**
     *
     * 通过时间查询未确认的工时列表 日
     * @param selectDate
     * @return
     */

    public Map<String, Object> getConfirmTimeByDay(String selectDate,String type,Integer PageNum,Integer PageSize) {
        //如果selectDate没有选择为null 返回所有  有选择 根据upload_time 进行筛选  0按日查询 1按周查询 2按月查询
        Map<String, Object> ConfirmTimeByDayMap = new HashMap<>();
        List<ProjectConfirmTimeModel> ConfirmTimeByDayList = new ArrayList<>();
        if (type.equals("") && type != null) {
            throw new SystemParamCheckException("请选择日期！");
        }
        //if (type.equals("0")) {
            //按照日查询
            PageHelper.startPage(PageNum,PageSize,true);
            ConfirmTimeByDayList = projectConfirmTimeModelMapper.selectConfirmTimeListByDay(selectDate, type);
            PageInfo pageInfo = new PageInfo(ConfirmTimeByDayList);
            ConfirmTimeByDayList=pageInfo.getList();
            long total = pageInfo.getTotal();
       /* } else{
            ConfirmTimeByDayList = projectConfirmTimeModelMapper.selectConfirmTimeListByWeekOrMon(selectDate, type);
        }*/
        ConfirmTimeByDayMap.put("ConfirmTimeByDayList",ConfirmTimeByDayList);
        ConfirmTimeByDayMap.put("total",total);
        return ConfirmTimeByDayMap;
    }

    /**
     * 通过id修改对象
     * @param JsonModel
     * @return
     */


    public void updateConfirmById(JSONObject JsonModel) {

        //获取确认工时 上报人id+确认工时
        Map<String,String> ConfirmTimeIdAndName= new HashMap<>();
        ArrayList< Map<String,String>> confirmIdAndTime= (ArrayList<Map<String, String>>) JsonModel.get("ConfirmIdAndTime");
        ProjectConfirmTimeModel projectConfirmTimeModel=new ProjectConfirmTimeModel();
        ProjectMHourManageModel projectMHourManageModel=new ProjectMHourManageModel();
        for (int i = 0; i <confirmIdAndTime.size() ; i++) {
            Long id=0l;
            Long confirmtimenum=0l;
            Long reportid=0l;
            ConfirmTimeIdAndName= confirmIdAndTime.get(i);
            id= Long.valueOf(ConfirmTimeIdAndName.get("id"));
            confirmtimenum= Long.valueOf(ConfirmTimeIdAndName.get("confirmTime"));
            //调用插入server
            if(id==0l || id==null){
                //返回选择异常
                throw new SystemParamCheckException("请选择一条记录进行确认操作！");
            }
            //查询要修改的对象 确认对象
            projectConfirmTimeModel=projectConfirmTimeModelMapper.selectByPrimaryKey(id);
            if(projectConfirmTimeModel==null){
                throw new SystemParamCheckException("选择的对象不存在！");
            }
            //查询要修改的对象 上报对象
            reportid=projectConfirmTimeModel.getReportid();
            projectMHourManageModel=projectMHourManageModelMapper.selectByPrimaryKey(reportid);
            if(projectMHourManageModel==null){
                throw new SystemParamCheckException("选择的对象不存在！");
            }
            //修改确认对象
            projectConfirmTimeModel.setConfirmtimenum(confirmtimenum);
            projectConfirmTimeModel.setConfirmstatus(1);
            projectConfirmTimeModel.setConfirmtime(new Date());
            projectConfirmTimeModel.setConfirmname(sysUserService.getCurrentUsr().getRealName());
            projectConfirmTimeModel.setConfirmuserid(sysUserService.getCurrentUsr().getUserId());

            int confimNum = projectConfirmTimeModelMapper.updateByPrimaryKey(projectConfirmTimeModel);
            //调用修改工时对象 通过上报id 修改工时对象审批状态
            projectMHourManageModel.setConfirmStatus(1);
            projectMHourManageModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
            projectMHourManageModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
            projectMHourManageModel.setUpdateTime(new Date());
            int reportNum = projectMHourManageModelMapper.updateByPrimaryKey(projectMHourManageModel);
            if((confimNum+reportNum)<1){
                throw new SystemParamCheckException("确认失败！");
            }
        }
    }

    public void updateConfirmByWeekOrMon(JSONObject jsonModel) {
        //获取确认工时 上报人id+确认工时
        Map<String,String> ConfirmTimeIdAndName= new HashMap<>();
        ArrayList< Map<String,String>> confirmIdAndTime= (ArrayList<Map<String, String>>) jsonModel.get("ConfirmIdAndTime");
        ProjectConfirmTimeModel projectConfirmTimeModel=new ProjectConfirmTimeModel();
        ProjectMHourManageModel projectMHourManageModel=new ProjectMHourManageModel();
        for (int i = 0; i <confirmIdAndTime.size() ; i++) {
            String id="";
            Long confirmtimenum=0l;
            Long reportid=0l;
            ConfirmTimeIdAndName= confirmIdAndTime.get(i);
            id= String.valueOf(ConfirmTimeIdAndName.get("id")); //根据id查询
            if(id=="" || id==null){
                //返回选择异常
                throw new SystemParamCheckException("请选择一条记录进行确认操作！");
            }

            //因为可能有多条,id为多个则
            String[] split = id.split(",");
            for (int j = 0; j < split.length; j++) {
                Long s = Long.valueOf(split[i]);
                //根据id查询每条记录
                projectConfirmTimeModel=projectConfirmTimeModelMapper.selectByPrimaryKey(s);
                if(projectConfirmTimeModel==null){
                    throw new SystemParamCheckException("选择的对象不存在！");
                }
                confirmtimenum= Long.valueOf(ConfirmTimeIdAndName.get("confirmTime"));
                //调用插入server
                //查询要修改的对象 确认对象
                //查询要修改的对象 上报对象
                reportid=projectConfirmTimeModel.getReportid();
                projectMHourManageModel=projectMHourManageModelMapper.selectByPrimaryKey(reportid);
                if(projectMHourManageModel==null){
                    throw new SystemParamCheckException("选择的对象不存在！");
                }
                //修改确认对象
                projectConfirmTimeModel.setConfirmtimenum(confirmtimenum);
                projectConfirmTimeModel.setConfirmstatus(1);
                projectConfirmTimeModel.setConfirmtime(new Date());
                projectConfirmTimeModel.setConfirmname(sysUserService.getCurrentUsr().getRealName());
                projectConfirmTimeModel.setConfirmuserid(sysUserService.getCurrentUsr().getUserId());

                int confimNum = projectConfirmTimeModelMapper.updateByPrimaryKey(projectConfirmTimeModel);
                //调用修改工时对象 通过上报id 修改工时对象审批状态
                projectMHourManageModel.setConfirmStatus(1);
                projectMHourManageModel.setUpdateId(sysUserService.getCurrentUsr().getUserId());
                projectMHourManageModel.setUpdateBy(sysUserService.getCurrentUsr().getRealName());
                projectMHourManageModel.setUpdateTime(new Date());
                projectMHourManageModelMapper.updateByPrimaryKey(projectMHourManageModel);
            }
        }
    }
}
