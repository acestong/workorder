package com.fea.project.service.milestone.paramcheck;

import com.fea.project.dao.milestone.ProjectMilestoneDeliveryMapper;
import com.fea.project.model.milestone.ProjectMilestoneDeliveryModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class DeliveryParamCheckService {
    @Resource
    private ProjectMilestoneDeliveryMapper projectMilestoneDeliveryMapper;

    /**
     * 新增aop数据校验
     **/
    public boolean insertModel(ProjectMilestoneDeliveryModel model){
        return  this.projectMilestoneDeliveryMapper.insertSelective(model)>0;
    }
    /**
     * 新增aop数据校验
     **/
    public boolean updateModel(ProjectMilestoneDeliveryModel model){
        return  this.projectMilestoneDeliveryMapper.updateByIdSelective(model)>0;
    }
}
