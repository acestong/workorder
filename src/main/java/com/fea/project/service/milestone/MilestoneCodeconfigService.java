package com.fea.project.service.milestone;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.milestone.MilestoneCodeconfigMapper;
import com.fea.project.enums.milestone.MilestoneCodeConfigEnum;
import com.fea.project.model.milestone.MilestoneCodeconfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/26
 * 编码配置表 Service
 */
@Service
public class MilestoneCodeconfigService {

    @Resource
    private MilestoneCodeconfigMapper codeconfigMapper;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 查询当前组织下的编码配置
     */
    @Transactional(rollbackFor = Exception.class)
    public List<MilestoneCodeconfigModel> findCodeConfigByRegId(Long regId) throws Exception{
        SysUserModel user = sysUserService.getCurrentUsr();
        MilestoneCodeconfigModel codeconfigModel = new MilestoneCodeconfigModel();
        codeconfigModel.setRegId(regId);
        List<MilestoneCodeconfigModel> codeconfigModels = codeconfigMapper.selectByModel(codeconfigModel);
        if (codeconfigModels.isEmpty()){
            //当前不存在编码配置，默认创建
            for (int i = 0; i< MilestoneCodeConfigEnum.values().length; i++){
                MilestoneCodeconfigModel model = MilestoneCodeconfigModel.builder()
                        .type(MilestoneCodeConfigEnum.values()[i].getType())
                        .prefix(MilestoneCodeConfigEnum.values()[i].getPrefix())
                        .isDate(true)
                        .isPrefix(true)
                        .nextNo(0L)
                        .noLen(4)
                        .regId(user.getRegId())
                        .createBy(user.getRealName())
                        .createId(user.getUserId())
                        .createTime(new Date())
                        .updateTime(new Date())
                        .build();
                codeconfigModels.add(model);
            }
            //将默认编码配置添加至库
            int i = codeconfigMapper.insertList(codeconfigModels);
            if (i!=codeconfigModels.size()){
                throw new SystemParamCheckException("数据初始化失败，请重试");
            }
        }else {
            return codeconfigModels;
        }
        return null;
    }
    /**
     * 编辑当前组织下的编码配置
     */
    public boolean editCodeConfigModel(MilestoneCodeconfigModel model){
        //编辑前缀，是否含日期，和编码长度
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateBy(user.getRealName());
        model.setUpdateId(user.getUserId());
        model.setUpdateTime(new Date());
        int i = codeconfigMapper.updateByIdSelective(model);
        if (i!=1){
            return false;
        }
        return true;
    }
    /**
     * 根据编码类型和其对应规则生成相应编码号
     */
    private String generateNumber(Long regId , Integer type) throws Exception{
        SysUserModel user = sysUserService.getCurrentUsr();
        MilestoneCodeconfigModel model = new MilestoneCodeconfigModel();
        model.setType(type);
        model.setRegId(regId);
        StringBuffer strCode = new StringBuffer("");
        //根据codeType,regId 去查询数据库....
        MilestoneCodeconfigModel bean = codeconfigMapper.selectByType(model);
        String prefix = "";
        boolean is_prefix = true;
        boolean is_date = true;
        Long next_no = 0L;
        Integer len = 4;
        Date now = new Date();
        // 格式化的时间字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取编码规则
        if(null != bean){
            prefix = bean.getPrefix();
            is_prefix = bean.getIsPrefix();
            is_date = bean.getIsDate();
            len = bean.getNoLen();
            if(null != bean.getNextNo()){
                Date dc = bean.getUpdateTime();
                if(dc != null && sdf.format(dc).compareTo(sdf.format(now))==-1){
                    next_no = 0L;
                    MilestoneCodeconfigModel upModel = new MilestoneCodeconfigModel();
                    upModel.setId(bean.getId());
                    upModel.setNextNo(next_no);
                    upModel.setUpdateTime(now);
                    int i = codeconfigMapper.updateByIdSelective(upModel);
                    if (i!=1){
                        throw new Exception("编码生成错误，请重试");
                    }
                }else{
                    next_no = bean.getNextNo();
                }
            }
            if(is_prefix){
                strCode.append(prefix);
            }
            if(is_date){
                String strDate = sdf.format(now);
                strCode.append(strDate);
            }
            strCode.append(convertNum2String(next_no+1, len));
        }else{
            //如果没有初始值，默认：日期+4位数值格式（201907310001）
            String strDate = sdf.format(now);
            strCode.append(MilestoneCodeConfigEnum.queryPrefix(type));
            strCode.append(strDate);
            strCode.append(convertNum2String(next_no+1, len));
            MilestoneCodeconfigModel newModel = MilestoneCodeconfigModel.builder()
                    .type(type)
                    .prefix(MilestoneCodeConfigEnum.queryPrefix(type))
                    .isDate(true)
                    .isPrefix(true)
                    .nextNo(next_no+1)
                    .noLen(len)
                    .regId(user.getRegId())
                    .createBy(user.getRealName())
                    .createId(user.getUserId())
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            int i = codeconfigMapper.insertSelective(newModel);
            if (i!=1){
                throw new Exception();
            }
        }
        return strCode.toString();
    }

    private MilestoneCodeconfigModel setCodeNextNo(Long regId, Integer type) throws Exception{
        MilestoneCodeconfigModel model = new MilestoneCodeconfigModel();
        model.setType(type);
        model.setRegId(regId);
        MilestoneCodeconfigModel bean = codeconfigMapper.selectByType(model);
        if(null != bean){
            Long next_no = bean.getNextNo();
            if(null != next_no){
                //自增加1
                bean.setNextNo(next_no + 1);
            }else{
                bean.setNextNo(1L);
            }
            Date now = new Date();
            bean.setUpdateTime(now);
            int i = codeconfigMapper.updateByIdSelective(bean);
            if (i!=1){
                throw new Exception("编码生成错误，请重试");
            }
        }
        return bean;
    }
    @Transactional(rollbackFor = Exception.class)
    public synchronized String getAutoCodeNum(Integer type) throws Exception{
        SysUserModel user = sysUserService.getCurrentUsr();
        Long regId = user.getRegId();
        String strCode = this.generateNumber(regId, type);
        this.setCodeNextNo(regId, type);
        return strCode;
    }
    public static String convertNum2String(Long num,Integer len){
        String strNo = num.toString();
        while (strNo.length() < len){
            strNo = "0" + strNo;
        }

        return strNo;
    }

}