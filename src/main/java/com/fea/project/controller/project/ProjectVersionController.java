package com.fea.project.controller.project;

import com.fea.project.model.project.ProjectVersionModel;
import com.fea.project.model.project.vo.ProjectVersionVo;
import com.fea.project.service.project.ProjectVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wuqi
 * @version 1.0
 * @since 2019/12/19 15:20
 **/
@RestController
@RequestMapping("projectVersion")
public class ProjectVersionController {

    @Autowired
    private ProjectVersionService projectVersionService;

    @RequestMapping("selectProjectVersionInfo")
    public Map<String, List<ProjectVersionVo>> selectProjectVersionInfo(@RequestBody ProjectVersionModel projectVersionModel){
        return this.projectVersionService.selectProjectVersionInfo(projectVersionModel);
    }

}
