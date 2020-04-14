package com.fea.project.controller.baseconfig;

import com.fea.project.configure.annotations.base.PermissionAnno;
import com.fea.project.model.baseconfig.pojo.ProjectBaseSetPojo;
import com.fea.project.model.baseconfig.vo.ProjectBaseSetVo;
import com.fea.project.service.baseconfig.ProjectBaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuqi
 * @since 2019/11/5 11:49
 * 项目基础设置
 **/
@RestController
@RequestMapping("projectBaseConfig")
public class ProjectBaseConfigController {

    @Autowired
    private ProjectBaseConfigService projectBaseConfigService;

    /**
     * 查询基础设置
     *
     * @return
     */
    @RequestMapping("selectBaseSetConfig")
    @PermissionAnno("/projectManage/projectConfig")
    public ProjectBaseSetVo selectBaseSetConfig() {
        return projectBaseConfigService.selectBaseSetConfig();
    }

    @RequestMapping("updateBaseSetConfig")
    @PermissionAnno("/projectManage/projectConfig/updateConfig")
    public ProjectBaseSetPojo updateBaseSetConfig(@RequestBody ProjectBaseSetPojo model) {
        return projectBaseConfigService.updateBaseSetConfig(model);
    }
}
