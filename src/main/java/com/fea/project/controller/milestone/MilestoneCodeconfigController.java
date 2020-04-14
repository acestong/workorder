package com.fea.project.controller.milestone;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.model.milestone.MilestoneCodeconfigModel;
import com.fea.project.service.milestone.MilestoneCodeconfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/29
 * 编码配置表 Controller
 */
@RestController
@RequestMapping("projectCodeconfig")
public class MilestoneCodeconfigController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MilestoneCodeconfigController.class);

    @Autowired
    private MilestoneCodeconfigService projectCodeconfigService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 按模型选择
     */
    @RequestMapping("showList")
    public List<MilestoneCodeconfigModel> show() throws Exception{
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        return this.projectCodeconfigService.findCodeConfigByRegId(currentUsr.getRegId());
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public MilestoneCodeconfigModel update(@RequestBody MilestoneCodeconfigModel model) {
        if (this.projectCodeconfigService.editCodeConfigModel(model)) {
            return model;
        }
        return null;
    }
}