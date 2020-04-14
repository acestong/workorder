package com.fea.project.service.baseconfig;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodeRegChildMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.ProjectCodeRegChildModel;
import com.fea.project.model.project.ProjectModel;
import com.fea.project.service.project.ProjectService;
import com.fea.project.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/09/27.
 */
@Service
public class ProjectCodeRegChildService {

    @Autowired
    private ProjectCodeRegChildMapper projectCodeRegChildMapper;

    @Autowired
    private ProjectService projectService;


    public String getCurrentChildCode(Long parentId, Long regId) {
        if (parentId == null || regId == null) {
            throw new SystemParamCheckException("查询主项目编码时，参数传递无效");
        }
        ProjectModel projectModel = this.projectService.selectById(parentId);
        if (DeleteStatusEnum.DELETE.getStatus().equals(projectModel.getDelStatus())) {
            throw new SystemParamCheckException("主项目已经被删除，无法进行子项目创建");
        }
        ProjectCodeRegChildModel model = this.projectCodeRegChildMapper.selectByParentCode(projectModel.getCode(), regId);
        if (model == null) {
            throw new SystemParamCheckException("子项目编号表初始数据不存在");
        }
        String code = StringUtil.getNextCodeByCurrentStr(model.getChildProjectCode());
        model.setChildProjectCode(code);
        if (this.projectCodeRegChildMapper.updateByIdSelective(model) >= 0) {
            return model.getParentProjectCode() + (model.getChildShortName() == null ? "" : model.getChildShortName()) + code;
        }
        throw new SystemParamCheckException("子项目编号更新失败");
    }

    /**
     * 当子项目编号未初始化时，进行初始化
     *
     * @param parentProject
     * @param projectCodeModel
     * @return
     */
    boolean insertWhenChildNotAlive(String parentProject, ProjectCodeModel projectCodeModel) {
        if (StringUtils.isEmpty(parentProject) || projectCodeModel == null
                || projectCodeModel.getRegId() == null || projectCodeModel.getChildNumber() == null) {
            throw new SystemParamCheckException("子项目id初始化失败");
        }
        ProjectCodeRegChildModel model = this.projectCodeRegChildMapper.selectByParentCode(parentProject, projectCodeModel.getRegId());
        if (model != null) {
            return true;
        }
        model = new ProjectCodeRegChildModel(parentProject, projectCodeModel.getRegId(), StringUtil.getInitStartCodeByLength(projectCodeModel.getChildNumber()), projectCodeModel.getChildShortName());
        return this.projectCodeRegChildMapper.insert(model) >= 0;
    }
}