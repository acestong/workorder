package com.fea.project.controller.base;

import com.fea.project.model.base.AppendixModel;
import com.fea.project.service.base.AppendixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2019/05/07.
 * 附件表  Controller
 */
@RestController
@RequestMapping("appendix")
public class AppendixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppendixController.class);


    @Autowired
    private AppendixService appendixService;

    /**
     * 跳转页面
     */
    @RequestMapping("page")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("appendix");
        return mv;
    }

    /**
     * 插入数据
     */
    @RequestMapping("insert")
    public AppendixModel insert(@RequestBody AppendixModel model) {
        if (this.appendixService.insert(model)) {
            return model;
        }
        return null;
    }


    /**
     * 按主键更新
     */
    @RequestMapping("update")
    public AppendixModel update(@RequestBody AppendixModel model) {
        if (this.appendixService.updateById(model)) {
            return model;
        }
        return null;
    }

    /**
     * 按主键删除
     */
    @RequestMapping("delete")
    public AppendixModel delete(@RequestBody AppendixModel model) {
        if (this.appendixService.deleteById(model)) {
            return model;
        }
        return null;
    }

}