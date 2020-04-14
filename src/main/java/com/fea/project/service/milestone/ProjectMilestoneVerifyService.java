package com.fea.project.service.milestone;

import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.milestone.ProjectMilestoneMapper;
import com.fea.project.dao.milestone.ProjectMilestoneVerifyMapper;

import com.fea.project.enums.apply.ProjectApplyVerifyStatusEnum;
import com.fea.project.enums.milestone.IsFinishEnum;
import com.fea.project.model.milestone.ProjectMilestoneModel;
import com.fea.project.model.milestone.ProjectMilestoneVerifyModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fea.project.service.apply.io.IProjectApplyBusiness;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/01/19
 */
@Service
public class ProjectMilestoneVerifyService implements IProjectApplyBusiness {

    @Resource
    private ProjectMilestoneVerifyMapper projectMilestoneVerifyMapper;
    @Resource
    private ProjectMilestoneMapper projectMilestoneMapper;

    /**
     * 根据项目id获取
     *
     */
    public ProjectMilestoneVerifyModel selectByProjectId(Long projectId){
        ProjectMilestoneVerifyModel verifyModel = projectMilestoneVerifyMapper.selectByProjectId(projectId);
        return verifyModel;
    }
    /**
     * 按主键更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateByIdSelective(ProjectMilestoneVerifyModel model){
        if (model==null || model.getId()==null) {
            throw new SystemParamCheckException("主键id不能为空");
        }
        int i = projectMilestoneVerifyMapper.updateByIdSelective(model);
        if (i==1){
            try {
                ProjectMilestoneVerifyModel verifyModel = projectMilestoneVerifyMapper.selectById(model.getId());
                //将该项目的里程碑列表全部更新
                List<ProjectMilestoneModel> list = projectMilestoneMapper.selectByModel(ProjectMilestoneModel.builder().projectId(verifyModel.getProjectId()).build());
                list.forEach(milestone->{
                    if (!IsFinishEnum.FINISH.getCode().equals(milestone.getIsFinish())){
                        milestone.setStatus(model.getVerifyStatus());
                        int j = projectMilestoneMapper.updateByIdSelective(milestone);
                    }
                    /*if (!ProjectApplyVerifyStatusEnum.TYPE_HAS_VERIFY.getValue().equals(milestone.getStatus())){

                    }*/
                });
                return true;
            } catch (Exception e) {
               throw new SystemParamCheckException("数据更新报错，请重试");
            }
        }
        throw new SystemParamCheckException("更新失败");
    }
    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectMilestoneVerifyModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectMilestoneVerifyMapper.insert(model) == 1;
        }
        return this.projectMilestoneVerifyMapper.updateById(model) == 1;
    }

    @Override
    public Map<? extends Long, ? extends String> getBusinessNameMap(List<Long> ids) {
        List<ProjectMilestoneVerifyModel> list = projectMilestoneVerifyMapper.selectByModelIds(ids);
        return list.stream().collect(Collectors.toMap(ProjectMilestoneVerifyModel::getId,ProjectMilestoneVerifyModel::getName));
    }
}