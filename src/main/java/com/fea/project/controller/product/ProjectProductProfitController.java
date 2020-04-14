package com.fea.project.controller.product;

import com.fea.project.model.product.ProjectProductProfitModel;
import java.util.List;
import com.fea.project.service.product.ProjectProductProfitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/03/27.
 */
@RestController
@RequestMapping("projectProductProfit")
public class ProjectProductProfitController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProductProfitController.class);


    @Autowired
    private ProjectProductProfitService projectProductProfitService;


    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public ProjectProductProfitModel insert(@RequestBody ProjectProductProfitModel model) {
        if (this.projectProductProfitService.insertSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按模型选择
     */
    @RequestMapping("show")
    public List<ProjectProductProfitModel> show(@RequestBody ProjectProductProfitModel model) {
        return this.projectProductProfitService.selectByModel(model);
    }

    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public ProjectProductProfitModel update(@RequestBody ProjectProductProfitModel model) {
        if (this.projectProductProfitService.updateByIdSelective(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public ProjectProductProfitModel delete(@RequestBody ProjectProductProfitModel model) {
        if (this.projectProductProfitService.deleteById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 更新排序
     */
    @RequestMapping("updateSort")
    public ProjectProductProfitModel updateSort(@RequestBody ProjectProductProfitModel model) {
        Long id = model.getId();
        String sortStr = model.getSortStr();
        if (sortStr.equals("down")) {
                projectProductProfitService.moveDown(id);
        } else if (sortStr.equals("up")) {
                projectProductProfitService.moveUp(id);
        }
        return model;
    }

}