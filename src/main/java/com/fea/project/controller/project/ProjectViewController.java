package com.fea.project.controller.project;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.project.ProjectViewModel;
import com.fea.project.model.project.pojo.ProjectPojo;
import com.fea.project.model.project.pojo.ProjectViewPojo;
import com.fea.project.model.project.vo.ProjectStatisticsVo;
import com.fea.project.model.project.vo.ProjectViewSelectVo;
import com.fea.project.model.project.vo.ProjectViewVo;
import com.fea.project.model.project.vo.ProjectVo;
import com.fea.project.service.project.ProjectViewService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2019/10/28.
 */
@RestController
@RequestMapping("projectView")
public class ProjectViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectViewController.class);

    @Autowired
    private ProjectViewService projectViewService;

    /**
     * 通过当前用户获取视图列表
     */
    @RequestMapping("listByCurrentUser")
    public Map<String, Object> listByCurrentUser() {
        return this.projectViewService.listByCurrentUser();
    }


    /**
     * 查询显示的默认视图
     *
     * @return
     */
    @RequestMapping("listDefaultVisiableView")
    public List<ProjectViewModel> listDefaultVisiableView() {
        return this.projectViewService.listDefaultVisiableView();
    }

    @RequestMapping("seeOrNotDefaultView")
    public ProjectViewModel seeOrNotDefaultView(@RequestBody ProjectViewModel model) {
        return this.projectViewService.seeOrNotDefaultView(model);
    }

    /**
     * 查询用户自配置的视图
     *
     * @return
     */
    @RequestMapping("listSelfConfigView")
    public List<ProjectViewModel> listSelfConfigView() {
        return this.projectViewService.listSelfConfigView();
    }

    /**
     * 查询用户自配置的视图详情
     *
     * @return
     */
    @RequestMapping("selectSelfConfigViewDetail")
    public ProjectViewVo selectSelfConfigViewDetail(@RequestBody ProjectViewModel model) {
        return this.projectViewService.selectSelfConfigViewDetail(model);
    }

    /**
     * 插入视图
     */
    @RequestMapping("insertModel")
    public ProjectViewModel insertModel(@RequestBody ProjectViewPojo model) {
        return this.projectViewService.insertModel(model);
    }

    /**
     * 更新视图
     */
    @RequestMapping("updateModel")
    public ProjectViewModel updateModel(@RequestBody ProjectViewPojo model) {
        return this.projectViewService.updateModel(model);
    }

    /**
     * 删除视图
     */
    @RequestMapping("deleteModel")
    public ProjectViewModel deleteModel(@RequestBody ProjectViewModel model) {
        return this.projectViewService.deleteModel(model);
    }

    @RequestMapping("selectSelfConfigViewParam")
    public List<ProjectViewSelectVo> selectSelfConfigViewParam() {
        return this.projectViewService.selectSelfConfigViewParam();
    }

    @RequestMapping("selectViewParamByTypeId")
    public Object selectViewParamByTypeId(@RequestBody ProjectViewModel projectViewModel) {
        return this.projectViewService.selectViewParamByTypeId(projectViewModel);
    }

    @RequestMapping("listByParam")
    public BasePageInfo<ProjectVo> listByParam(@RequestBody BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        return this.projectViewService.listByParam(pageInfo);
    }

    @RequestMapping("selectProjectCondition")
    public ProjectStatisticsVo selectProjectCondition(@RequestBody BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        if (basePageInfo == null || basePageInfo.getModel() == null) {
            throw new SystemParamCheckException("传入参数异常无法进行查询");
        }
        return this.projectViewService.selectProjectCondition(basePageInfo);
    }

    @RequestMapping("listByViewId")
    public BasePageInfo<ProjectVo> listByViewId(@RequestBody BasePageInfo<ProjectPojo> pageInfo) throws ExecutionException, InterruptedException {
        return this.projectViewService.listByViewId(pageInfo);
    }

    @RequestMapping("selectProjectConditionByViewId")
    public ProjectStatisticsVo selectProjectConditionByViewId(@RequestBody BasePageInfo<ProjectPojo> basePageInfo) throws ExecutionException, InterruptedException {
        return this.projectViewService.selectProjectConditionByViewId(basePageInfo);
    }


    @RequestMapping("exchangeViewCommonUserStatus")
    public ProjectViewModel exchangeViewCommonUserStatus(@RequestBody ProjectViewModel projectViewModel) throws ExecutionException, InterruptedException {
        return this.projectViewService.exchangeViewCommonUserStatus(projectViewModel);
    }

    @RequestMapping("selectCommonUserViews")
    public List<ProjectViewModel> selectCommonUserViews(){
        return this.projectViewService.selectCommonUserViews();
    }




}