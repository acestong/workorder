package com.fea.project.controller.product;

import com.fea.project.model.product.ProjectProductSwotModel;
import java.util.List;

import com.fea.project.service.product.ProjectProductSwotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 * @date 2020/03/20
 */
@RestController
@RequestMapping("projectProductSwot")
public class ProjectProductSwotController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductSwotController.class);


    @Autowired
    private ProjectProductSwotService projectProductSwotService;


    /**
     * 插入数据
     */
    @RequestMapping("insertSwot")
    @ResponseBody
    public ProjectProductSwotModel insert(@RequestBody ProjectProductSwotModel model) {
        if (this.projectProductSwotService.insert(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("showSwotList")
    @ResponseBody
    public Object showSwotList(@RequestBody ProjectProductSwotModel model) {
        return this.projectProductSwotService.selectSwotList(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("updateSwot")
    @ResponseBody
    public ProjectProductSwotModel update(@RequestBody ProjectProductSwotModel model) {
        if (this.projectProductSwotService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("deleteSwot")
    @ResponseBody
    public ProjectProductSwotModel delete(@RequestBody ProjectProductSwotModel model) {
        if (this.projectProductSwotService.deleteById(model)) {
            return model;
        }
        return null;
    }
}