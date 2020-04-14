package com.fea.project.controller.project;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.project.ProjectDeliverClaimModel;
import com.fea.project.model.project.ProjectMHourManageModel;
import com.fea.project.model.project.ProjectOvertimeTypeModel;
import com.fea.project.model.task.TaskWorkReportModel;
import com.fea.project.model.task.vo.TaskWorkReportModelVo;
import com.fea.project.service.project.ProjectConfirmTimeService;
import com.fea.project.service.project.ProjectDeliverClaimService;
import com.fea.project.service.project.ProjectMhourManageService;
import com.fea.project.service.project.ProjectOverTimeTypeService;
import com.fea.project.service.task.ITaskWorkReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @autor yujia.qiang
 * @date: 2019/12/9
 * @time: 14:57
 */
@RestController
@RequestMapping("MHourManageController")
public class ProjectMHourManageController {
    @Autowired
    private ProjectMhourManageService projectMhourManageService;
    @Resource
    private ITaskWorkReportService iTaskWorkReportService;

    @Autowired
    private ProjectOverTimeTypeService ProjectOverTimeTypeService;



    //添加日志
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectContactorController.class);
    /**
     * 我的工时-工时汇报
    /

    /**
     * 当日任务工时汇总查询 根据时间
     * @param SelectDate
     * @return
     */
     @RequestMapping("getWorkReportByDay")
     public Map<String,Object> getWorkReportByDay(String SelectDate){
         //时间格式转换
         SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

         Map<String,Object> TaskWorkReportList=new HashMap<>();
         if(SelectDate==null || SelectDate.equals("")){
             throw new SystemParamCheckException("查询时间不可为空！");
         }
         try {
             Date date=simpleDateFormat.parse(SelectDate);
         //根据时间查询当日任务
//             TaskWorkReportList=iTaskWorkReportService.getWorkReportByDay(date);
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return TaskWorkReportList;
     }

    /**
     * 查询加班类型
     * @return
     */
    @RequestMapping("getOverTimeType")
     public Map<String,Object> getOverTimeType(){
         Map<String,Object> OvertimeTypeMap=new HashMap<>();
         List<ProjectOvertimeTypeModel> OvertimeTypeList=ProjectOverTimeTypeService.getAllOvertimeType();
         OvertimeTypeMap.put("OvertimeTypeList",OvertimeTypeList);
         return  OvertimeTypeMap;
     }



    /**
     * 插入数据
     */
    @RequestMapping("insertModel")
    public void insertModel(@RequestBody JSONObject model) {
        //获取工时对象
        this.projectMhourManageService.insertModel(model);
    }

    /**
     * 我的工时查询 日
     */
    @RequestMapping("getMyhourManageByTime")
    public  Map<String,Object> getMyhourManageByTime(String SelectDate,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        Map<String, Object> myhourManageByTime = projectMhourManageService.getMyhourManageByTime(SelectDate, PageNum, PageSize);
        List<ProjectMHourManageModel> MyhourManageByTimeList= (List<ProjectMHourManageModel>) myhourManageByTime.get("projectMHourManageList");
        MyhourManageByTimeMap.put("MyhourManageByTimeList",MyhourManageByTimeList);
        MyhourManageByTimeMap.put("total",myhourManageByTime.get("total"));
        return MyhourManageByTimeMap;
    }

    /**
     * 我的工时查询 周
     */
    @RequestMapping("getMyhourManageByWeek")
    public  Map<String,Object> getMyhourManageByWeek(String SelectDate,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        //列表查询
        Map<String, Object> MyhourManageByWeekListmap=projectMhourManageService.getMyhourManageByWeek(SelectDate,PageNum,PageSize);
        List<ProjectMHourManageModel> MyhourManageByWeekList= (List<ProjectMHourManageModel>) MyhourManageByWeekListmap.get("MyhourManageByWeekList");
        MyhourManageByTimeMap.put("MyhourManageByWeekList",MyhourManageByWeekList);
        MyhourManageByTimeMap.put("total",MyhourManageByWeekListmap.get("total"));
        //合计查询
        List<ProjectMHourManageModel> MyhourManagekSum= projectMhourManageService.getSumMyhourManage(SelectDate,"week");
        MyhourManageByTimeMap.put("MyhourManagekSum",MyhourManagekSum);
        return MyhourManageByTimeMap;
    }

    /**
     * 我的工时查询 月
     */
    @RequestMapping("getMyhourManageByMonthe")
    public  Map<String,Object> getMyhourManageByMonthe(String SelectDate,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        Map<String, Object> MyhourManageByMonthemap=projectMhourManageService.getMyhourManageByMonthe(SelectDate,PageNum,PageSize);
        List<ProjectMHourManageModel> MyhourManageByMontheList= (List<ProjectMHourManageModel>) MyhourManageByMonthemap.get("projectMHourManageMontheList");
        MyhourManageByTimeMap.put("MyhourManageByTimeList",MyhourManageByMontheList);
        MyhourManageByTimeMap.put("total",MyhourManageByMonthemap.get("total"));

        List<ProjectMHourManageModel> MyhourManagekSum= projectMhourManageService.getSumMyhourManage(SelectDate,"Month");
        MyhourManageByTimeMap.put("MyhourManagekSum",MyhourManagekSum);
        return MyhourManageByTimeMap;
    }

    /**
     * 根据id 获取工时详情
     * @param id
     * @return
     */
    @RequestMapping("getMyhourManageDesByid")
    public  Map<String,Object> getMyhourManageDesByid(String id){
        Map<String,Object> MyhourManageDes=new HashMap<>();
        MyhourManageDes=projectMhourManageService.getMyhourManageDesByid(id);
        return  MyhourManageDes;

    }

    /**
     * 获取团队工时 日-周-月
     * @param projectId    团队id
     * @param SelectDate   选择日期
     * @param type         选择类型（日 周 月）
     * @return
     */

    @RequestMapping("getMyhourManageLisProjectid")
    public  Map<String,Object> getTeamhourManageListProjectid(String projectId,String SelectDate,String type,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageDes=new HashMap<>();
        MyhourManageDes=projectMhourManageService.getTeamhourManageDesProjectid(projectId,SelectDate,type,PageNum,PageSize);
        return  MyhourManageDes;

    }

    /**
     * 团队成员工时详情
     * @param id
     * @return
     */
    @RequestMapping("getTeamhourManageDesById")
    public Map<String,Object> getTeamhourManageDesById(String id){
        Map<String,Object> MyhourManageDes=new HashMap<>();
        MyhourManageDes=projectMhourManageService.getMyhourManageDesByid(id);
        return  MyhourManageDes;
    }

    /**
     /**
     * 成员 工时查询 日
     */
    @RequestMapping("getMemberhourManageByTime")
    public  Map<String,Object> getMemberhourManageByTime(String SelectDate,String createid,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        Map<String,Object>  MemhourManageByTimeMap=projectMhourManageService.getMemberhourManageByTime(SelectDate,createid,PageNum,PageSize);
        List<ProjectMHourManageModel> MemhourManageByTimeList= (List<ProjectMHourManageModel>) MemhourManageByTimeMap.get("projectMHourManageList");
        MyhourManageByTimeMap.put("MemhourManageByTimeList",MemhourManageByTimeList);
        MyhourManageByTimeMap.put("total",MemhourManageByTimeMap.get("total"));
        return MyhourManageByTimeMap;
    }

    /**
     * 成员 工时查询 周
     */
    @RequestMapping("getMeberhourManageByWeek")
    public  Map<String,Object> getMeberhourManageByWeek(String SelectDate,String createid,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        //列表查询
        Map<String,Object> MemhourManageByWeekMap=projectMhourManageService.geMemhourManageByWeek(SelectDate,createid,PageNum,PageSize);
        List<ProjectMHourManageModel> MemhourManageByWeekList= (List<ProjectMHourManageModel>) MemhourManageByWeekMap.get("projectMHourManageWeekList");
        MyhourManageByTimeMap.put("MemhourManageByWeekList",MemhourManageByWeekList);
        MyhourManageByTimeMap.put("total",MemhourManageByWeekMap.get("total"));
        //合计查询
        List<ProjectMHourManageModel> MemhourManagekSum= projectMhourManageService.getSumMemhourManage(SelectDate,"week",createid);
        MyhourManageByTimeMap.put("MemhourManagekSum",MemhourManagekSum);
        return MyhourManageByTimeMap;
    }

    /**
     * 成员 工时查询 月
     */
    @RequestMapping("getMemberhourManageByMonthe")
    public  Map<String,Object> getMemberhourManageByMonthe(String SelectDate,String createid,Integer PageNum,Integer PageSize){
        Map<String,Object> MyhourManageByTimeMap=new HashMap<>();
        Map<String,Object> MemhourManageByMontheMap=projectMhourManageService.getMemhourManageByMonthe(SelectDate,createid,PageNum,PageSize);
        List<ProjectMHourManageModel> MemhourManageByMontheList= (List<ProjectMHourManageModel>) MemhourManageByMontheMap.get("projectMHourManageMontheList");
        MyhourManageByTimeMap.put("MemhourManageByMontheList",MemhourManageByMontheList);
        MyhourManageByTimeMap.put("total",MemhourManageByMontheMap.get("total"));
        List<ProjectMHourManageModel> MemhourManagekSum= projectMhourManageService.getSumMemhourManage(SelectDate,"Month",createid);
        MyhourManageByTimeMap.put("MemhourManagekSum",MemhourManagekSum);
        return MyhourManageByTimeMap;
    }



}
