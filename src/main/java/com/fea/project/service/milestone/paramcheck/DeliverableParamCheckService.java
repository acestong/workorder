package com.fea.project.service.milestone.paramcheck;

import com.fea.project.dao.milestone.ProjectMilestoneDeliverableMapper;
import com.fea.project.model.milestone.ProjectMilestoneDeliverableModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class DeliverableParamCheckService {
    @Resource
    private ProjectMilestoneDeliverableMapper projectMilestoneDeliverableMapper;
    /**
     * 新增aop数据校验
     **/
    public boolean insertModel(ProjectMilestoneDeliverableModel model){
        return  this.projectMilestoneDeliverableMapper.insertSelective(model)>0;
    }
    /**
     * 新增aop数据校验
     **/
    public boolean updateModel(ProjectMilestoneDeliverableModel model){
        return  this.projectMilestoneDeliverableMapper.updateByIdSelective(model)>0;
    }
}
