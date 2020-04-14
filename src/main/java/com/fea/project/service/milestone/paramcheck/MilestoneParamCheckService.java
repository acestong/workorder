package com.fea.project.service.milestone.paramcheck;

import com.fea.project.dao.milestone.ProjectMilestoneMapper;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class MilestoneParamCheckService {

    @Resource
    private ProjectMilestoneMapper projectMilestoneMapper;
    /**
     * 新增aop数据校验
     **/
    public boolean insertModel(ProjectMilestoneModel model){
        return  this.projectMilestoneMapper.insertSelective(model)>0;
    }
    /**
     * 新增aop数据校验
     **/
    public boolean updateModel(ProjectMilestoneModel model){
        return  this.projectMilestoneMapper.updateByIdSelective(model)>0;
    }
}
