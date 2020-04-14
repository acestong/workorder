package com.fea.project.service.project;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.project.ProjectMHourManageModelMapper;
import com.fea.project.model.project.ProjectConfirmTimeModel;
import com.fea.project.model.project.ProjectMHourManageModel;
import com.fea.project.model.project.ProjectOvertimeModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @autor Administrator
 * @date: 2019/12/9
 * @time: 17:51
 */
@Service
public class ProjectMhourManageService {

    @Autowired
    private ProjectMHourManageModelMapper projectMhourManageMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectOverTimeService projectOverTimeService;

    @Autowired
    private ProjectConfirmTimeService projectConfirmTimeService;


    /**
     * 插入数据
     * (首先判断是否有加班工时数据 有添加加班工时数据  没有添加任务工时 添加后添加到确认工时表中 默认状态为 未确认状态 )
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertModel(JSONObject model) {
        SysUserModel sysUserModel = this.sysUserService.getCurrentUsr();
       //插入数据
        if ( model == null) {
            throw new SystemParamCheckException("工时信息传入为空，无法进行新增");
        }

        //取到对象
        HashMap OvertimeMap = (HashMap) model.get("ProjeOvertime");
        String overtimeId="";
        //如果有加班数据
        if(OvertimeMap!=null && OvertimeMap.size()!=0){
            JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(OvertimeMap));
            //获取到加班对象
            ProjectOvertimeModel projectOverTime = (ProjectOvertimeModel)JSONObject.toJavaObject(itemJSONObj,ProjectOvertimeModel.class);
            int insertOver = projectOverTimeService.insertModel(projectOverTime);
            //取出对象id
            overtimeId=String.valueOf(projectOverTime.getId());
        }
        //取出当前工时对象
        HashMap ProjectMHourManageMap = (HashMap) model.get("ProjectMHourManage");
        if (ProjectMHourManageMap!=null && ProjectMHourManageMap.size()!=0){
            JSONObject mHourJSONObj = JSONObject.parseObject(JSON.toJSONString(ProjectMHourManageMap));
            ProjectMHourManageModel projectMHourManageModel = (ProjectMHourManageModel)JSONObject.toJavaObject(mHourJSONObj,ProjectMHourManageModel.class);
            projectMHourManageModel.setCreateBy(sysUserService.getCurrentUsr().getRealName());
            projectMHourManageModel.setCreateId(sysUserService.getCurrentUsr().getUserId());
            projectMHourManageModel.setCreateTime(new Date());
            projectMHourManageModel.setOvertimeId(overtimeId);
            projectMHourManageModel.setConfirmStatus(0);
            int insert = projectMhourManageMapper.insert(projectMHourManageModel);
            if (insert<0){
                throw new SystemParamCheckException("新增失败！");
            }
            //插入成功后调用确认工时表插入方法 （添加上报id ）
            ProjectConfirmTimeModel projectConfirmTimeModel=new ProjectConfirmTimeModel();
            projectConfirmTimeModel.setReportid(Long.valueOf(projectMHourManageModel.getId()));
            projectConfirmTimeModel.setReportuserid(projectMHourManageModel.getCreateId());
            projectConfirmTimeModel.setReporttimenum(Long.valueOf(projectMHourManageModel.getUploadTimenum()));
            projectConfirmTimeModel.setCreateTime(projectMHourManageModel.getUploadTime());
            projectConfirmTimeModel.setConfirmstatus(0);
            projectConfirmTimeService.insertModel(projectConfirmTimeModel);
        }
    }

    /**
     * 根据日期查询我的日工时list
     * @param selectDate
     * @return
     */

    public   Map<String,Object>  getMyhourManageByTime(String selectDate,Integer PageNum,Integer PageSize) {
        //获取当前人id
        Long userid=sysUserService.getCurrentUsr().getUserId();
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        Map<String,Object> map=new HashMap<>();
        List<ProjectMHourManageModel> projectMHourManageList=new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=simpleDateFormat.parse(selectDate);
            SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTime = simpleDateFormat.format(date);
            //调用Mapp进行查询
            PageHelper.startPage(PageNum,PageSize,true);
            projectMHourManageList=projectMhourManageMapper.selectMyhourManageByTime(startTime,userid);
            PageInfo pageInfo = new PageInfo(projectMHourManageList);
            projectMHourManageList=pageInfo.getList();
            //获取总条数
            long total = pageInfo.getTotal();
            map.put("projectMHourManageList",projectMHourManageList);
            map.put("total",total);
            return map;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 根据日期查询我的  周 工时list
     * @param selectDate
     * @return
     */
    public Map<String,Object> getMyhourManageByWeek(String selectDate,Integer PageNum,Integer PageSize) {
//获取当前人id
        Long userid=sysUserService.getCurrentUsr().getUserId();
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageWeekList=new ArrayList<>();
            //调用Mapp进行查询
        PageHelper.startPage(PageNum,PageSize,true);
        projectMHourManageWeekList=projectMhourManageMapper.selectMyhourManageByWeek(selectDate,userid);
        PageInfo pageInfo = new PageInfo(projectMHourManageWeekList);
        projectMHourManageWeekList=pageInfo.getList();
        //获取总条数
        long total = pageInfo.getTotal();
        Map<String,Object> map=new HashMap<>();
        map.put("MyhourManageByWeekList",projectMHourManageWeekList);
        map.put("total",total);
        return map;
    }

    /**
     * 根据日期查询我的  月 工时list
     * @param selectDate
     * @return
     */

    public Map<String, Object> getMyhourManageByMonthe(String selectDate,Integer PageNum,Integer PageSize) {
//获取当前人id
        Long userid=sysUserService.getCurrentUsr().getUserId();
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageMontheList=new ArrayList<>();
            //调用Mapp进行查询
        PageHelper.startPage(PageNum,PageSize,true);
        projectMHourManageMontheList=projectMhourManageMapper.selectMyhourManageByMonthe(selectDate,userid);
        PageInfo pageInfo = new PageInfo(projectMHourManageMontheList);
        projectMHourManageMontheList=pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String,Object> map=new HashMap<>();
        map.put("projectMHourManageMontheList",projectMHourManageMontheList);
        map.put("total",total);
        return map;
    }

    public List<ProjectMHourManageModel> getSumMyhourManage(String selectDate,String type) {
        Long userid=sysUserService.getCurrentUsr().getUserId();
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageMontheSumList=new ArrayList<>();
        String sqlType="";
        if(type.equals("week")){
            //调用Mapp进行查询
            sqlType="DATE_FORMAT(tppm.upload_time,'%Y-%u')";
        }
        if (type.equals("Month")){
            //调用Mapp进行查询
            sqlType="DATE_FORMAT(tppm.upload_time,'%Y-%m')";

        }
        projectMHourManageMontheSumList=projectMhourManageMapper.selectMyhourSumMyhourManage(selectDate,userid,sqlType);

        return projectMHourManageMontheSumList;
    }
    //根据id查询我的工时详情
    public Map<String, Object> getMyhourManageDesByid(String id) {
        if(id==null || id==""){
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        Map<String,Object> MyhourManageDes=new HashMap<>();
        //工时详情
        List<ProjectMHourManageModel> MyhourManageDesList=new ArrayList<>();
        MyhourManageDesList=projectMhourManageMapper.selectmyhourManageDesByid(Long.valueOf(id));
        //汇报任务
        List<ProjectMHourManageModel> MyhourManageDesListReport=new ArrayList<>();
        MyhourManageDesListReport=projectMhourManageMapper.selectmyhourManageDesReportByid(Long.valueOf(id));
        //加班详情
        List<ProjectMHourManageModel> MyhourManageDesListOver=new ArrayList<>();
        MyhourManageDesListOver=projectMhourManageMapper.selectmyhourManageDesOverByid(Long.valueOf(id));
        //加班任务
        List<ProjectMHourManageModel> MyhourManageDesListOverReport=new ArrayList<>();
        MyhourManageDesListOverReport=projectMhourManageMapper.selectmyhourManageDesOverReportByid(Long.valueOf(id));
        MyhourManageDes.put("MyhourManageDesList",MyhourManageDesList);
        MyhourManageDes.put("MyhourManageDesListReport",MyhourManageDesListReport);
        MyhourManageDes.put("MyhourManageDesListOver",MyhourManageDesListOver);
        MyhourManageDes.put("MyhourManageDesListOverReport",MyhourManageDesListOverReport);

        //任务总工时
        long actual_task_duration =0l;
        //加班任务总工时
        long actual_task_durationOver =0l;
        //判空
        if (MyhourManageDesListReport.size()!=0 && MyhourManageDesListReport!=null){
            for (int i = 0; i <MyhourManageDesListReport.size() ; i++) {
                Map<String,Object> newMap = new HashMap<String, Object>();
                newMap= (Map<String, Object>) MyhourManageDesListReport.get(0);
                actual_task_duration= (long) newMap.get("actual_task_duration");
            }
        }
        if (MyhourManageDesListOverReport.size()!=0 && MyhourManageDesListOverReport!=null){
            for (int i = 0; i <MyhourManageDesListOverReport.size() ; i++) {
                Map<String,Object> newMap = new HashMap<String, Object>();
                newMap= (Map<String, Object>) MyhourManageDesListOverReport.get(0);
                actual_task_durationOver= (long) newMap.get("actual_task_duration");
            }
        }
        MyhourManageDes.put("durationSum",actual_task_duration);
        MyhourManageDes.put("durationSumOver",actual_task_durationOver);
        return MyhourManageDes;
    }

    /**
     * 查询列表信息
     * @param projectId
     * @param selectDate
     * @param type
     * @return
     */

    public Map<String, Object> getTeamhourManageDesProjectid(String projectId, String selectDate, String type,Integer PageNum,Integer PageSize) {
        //
        Map<String, Object> TeamhourManageDesProjectid=new HashMap<>();
        if ( selectDate == null ||selectDate=="" ||projectId==null ||projectId=="" || type==null || type=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageList=new ArrayList<>();
        List<ProjectMHourManageModel> projectMHourManageSum=new ArrayList<>();

        PageHelper.startPage(PageNum,PageSize,true);
        //调用Mapp进行查询 查询列表
        projectMHourManageList=projectMhourManageMapper.selectTeamhourManageDesProjectid(projectId,selectDate,type);
        PageInfo pageInfo = new PageInfo(projectMHourManageList);
        projectMHourManageList= pageInfo.getList();
        long total = pageInfo.getTotal();

        //调用Mapp进行总和 查询
        projectMHourManageSum=projectMhourManageMapper.selectTeamhourManageSum(projectId,selectDate,type);

        TeamhourManageDesProjectid.put("projectMHourManageList",projectMHourManageList);
        TeamhourManageDesProjectid.put("total",total);
        TeamhourManageDesProjectid.put("projectMHourManageSum",projectMHourManageSum);

        return TeamhourManageDesProjectid;
    }


    public  Map<String, Object> getMemberhourManageByTime(String selectDate, String createid,Integer PageNum,Integer PageSize) {
        Long userid=Long.valueOf(createid);
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageList=new ArrayList<>();
        Map<String,Object> newMap = new HashMap<String, Object>();
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date date=simpleDateFormat.parse(selectDate);
            SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startTime = simpleDateFormat.format(date);
            //调用Mapp进行查询
            PageHelper.startPage(PageNum,PageSize,true);
            projectMHourManageList=projectMhourManageMapper.selectMyhourManageByTime(startTime,userid);
            PageInfo pageInfo = new PageInfo(projectMHourManageList);
            projectMHourManageList=pageInfo.getList();
            long total = pageInfo.getTotal();
            newMap.put("projectMHourManageList",projectMHourManageList);
            newMap.put("total",total);
            return newMap;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newMap;
    }

    public  Map<String,Object> geMemhourManageByWeek(String selectDate, String createid,Integer PageNum,Integer PageSize) {
        Long userid=Long.valueOf(createid);
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageWeekList=new ArrayList<>();
        //调用Mapp进行查询
        PageHelper.startPage(PageNum,PageSize,true);
        projectMHourManageWeekList=projectMhourManageMapper.selectMyhourManageByWeek(selectDate,userid);
        PageInfo pageInfo = new PageInfo(projectMHourManageWeekList);
        projectMHourManageWeekList= pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String,Object> newMap = new HashMap<String, Object>();
        newMap.put("projectMHourManageWeekList",projectMHourManageWeekList);
        newMap.put("total",total);
        return newMap;
    }

    public List<ProjectMHourManageModel> getSumMemhourManage(String selectDate, String type, String createid) {
        Long userid=Long.valueOf(createid);
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageMontheSumList=new ArrayList<>();
        String sqlType="";
        if(type.equals("week")){
            //调用Mapp进行查询
            sqlType="DATE_FORMAT(tppm.upload_time,'%Y-%u')";
        }
        if (type.equals("Month")){
            //调用Mapp进行查询
            sqlType="DATE_FORMAT(tppm.upload_time,'%Y-%m')";

        }
        projectMHourManageMontheSumList=projectMhourManageMapper.selectMyhourSumMyhourManage(selectDate,userid,sqlType);

        return projectMHourManageMontheSumList;
    }

    public Map<String,Object> getMemhourManageByMonthe(String selectDate, String createid,Integer PageNum,Integer PageSize) {
        Long userid=Long.valueOf(createid);
        if ( selectDate == null ||selectDate=="") {
            throw new SystemParamCheckException("工时信息传入为空，无法进行查询");
        }
        List<ProjectMHourManageModel> projectMHourManageMontheList=new ArrayList<>();
        //调用Mapp进行查询
        PageHelper.startPage(PageNum,PageSize,true);
        projectMHourManageMontheList=projectMhourManageMapper.selectMyhourManageByMonthe(selectDate,userid);
        PageInfo pageInfo = new PageInfo(projectMHourManageMontheList);
        projectMHourManageMontheList=pageInfo.getList();
        long total = pageInfo.getTotal();
        Map<String,Object> newMap = new HashMap<String, Object>();
        newMap.put("projectMHourManageMontheList",projectMHourManageMontheList);
        newMap.put("total",total);
        return newMap;
    }
}
