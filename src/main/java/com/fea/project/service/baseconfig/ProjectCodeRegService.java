package com.fea.project.service.baseconfig;

import com.alibaba.fastjson.JSON;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodeRegMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.enums.baseconfig.ProjectCodePeriodEnum;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.ProjectCodeRegModel;
import com.fea.project.model.baseconfig.vo.ProjectCodeVo;
import com.fea.project.model.project.pojo.ProjectCodeQueryPojo;
import com.fea.project.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/09/27.
 * 项目组织编号 Service
 */
@Service
public class ProjectCodeRegService {

    @Autowired
    private ProjectCodeRegMapper projectCodeRegMapper;

    @Autowired
    private ProjectCodeService projectCodeService;

    @Autowired
    private ProjectCodeRegChildService projectCodeRegChildService;

    /**
     * 父类合同
     *
     * @param model
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String getProjectCodeByRegId(ProjectCodeQueryPojo model) {
        if (model == null || model.getRegId() == null || model.getProjectType() == null) {
            throw new SystemParamCheckException("查询项目编码，传入参数报错").appendAlaramMsg(JSON.toJSONString(model));
        }
        if (model.getParentId() != null) {
            return this.projectCodeRegChildService.getCurrentChildCode(model.getParentId(), model.getRegId());
        }
        Date currentTime = model.getCurrentTime() == null ? new Date() : model.getCurrentTime();
        ProjectCodeVo projectCodeVo = projectCodeService.selectConfig(model.getRegId());
        ProjectCodeRegModel projectCodeRegModel = this.projectCodeRegMapper.selectByRegId(model.getRegId());
        String shortName = projectCodeVo.getShortName(model.getProjectType());
        String projectCode = this.createCurrentProjectCode(currentTime, projectCodeVo, projectCodeRegModel);
        StringBuffer sb = new StringBuffer(StringUtils.isEmpty(shortName) ? "" : shortName).append(projectCode);
        //如果子节点数据未创建进行相应创建
        if (this.projectCodeRegChildService.insertWhenChildNotAlive(sb.toString(), projectCodeVo)) {
            return sb.toString();
        }
        throw new SystemParamCheckException("子项目节点数据创建失败").appendAlaramMsg(sb.toString());
    }

    /**
     * 创建当前父节点项目编码
     *
     * @param currentTime
     * @param projectCodeModel
     * @param projectCodeRegModel
     * @return
     */
    private String createCurrentProjectCode(Date currentTime, ProjectCodeModel projectCodeModel, ProjectCodeRegModel projectCodeRegModel) {
        String dateFormat = ProjectCodeDateStrEnum.getTargetDateFormat(projectCodeModel.getDataStr());
        String dateStr = dateFormat == null ? "" : new SimpleDateFormat(dateFormat).format(currentTime);
        Integer parentNumber = projectCodeModel.getParentNumber();
        //创建新的对象
        if (projectCodeRegModel == null || ProjectCodePeriodEnum.getTargetEnum(projectCodeModel.getCreatePeriod())
                .isNeedRefreshCode(currentTime, projectCodeRegModel.getUpdateTime())) {
            return createNewPeriodCode(currentTime, projectCodeModel.getRegId(), dateStr, parentNumber);
        }
        //查询当前周期是否与之前一致，如果一致，进行编号递增
        projectCodeRegModel.setUpdateTime(currentTime);
        projectCodeRegModel.setParentProject(StringUtil.getNextCodeByCurrentStr(projectCodeRegModel.getParentProject()
                , projectCodeModel.getParentNumber()));
        if (this.projectCodeRegMapper.updateByIdSelective(projectCodeRegModel) >= 0) {
            return dateStr + projectCodeRegModel.getParentProject();
        }
        throw new SystemParamCheckException("更新组织项目编码列表失败");
    }

    /**
     * 创建新周期的项目编码
     *
     * @param currentTime
     * @param regId
     * @param dateStr
     * @param parentNumber
     * @return
     */
    private String createNewPeriodCode(Date currentTime, Long regId, String dateStr, Integer parentNumber) {
        ProjectCodeRegModel projectCodeRegModel;
        projectCodeRegModel = ProjectCodeRegModel.createModel(regId, DeleteStatusEnum.NOT_DELETE.getStatus()
                , currentTime, StringUtil.getNextCodeByCurrentStr(StringUtil.getInitStartCodeByLength(parentNumber)));
        //移除组织旧的数据
        if (this.projectCodeRegMapper.updateCloseByRegId(regId) >= 0
                && this.projectCodeRegMapper.insert(projectCodeRegModel) > 0) {
            return dateStr + projectCodeRegModel.getParentProject();
        }
        throw new SystemParamCheckException("项目编号生成报错");
    }
}