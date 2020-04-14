package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowContactsMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Service
public class ProjectInterflowContactsService {

    @Autowired
    private SysUserService sysUserService;
    @Resource
    private ProjectInterflowContactsMapper projectInterflowContactsMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectInterflowContactsMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        if (ids != null && (ids.isEmpty())){
            return true;
        }
        return this.projectInterflowContactsMapper.deleteByIds(ids) > 0;
    }

    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public ProjectInterflowContactsModel insert(ProjectInterflowContactsModel model) {
        if (model != null){
            throw new SystemParamCheckException("传入参数错误，添加失败");
        }
        //插入创建人信息
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setCreateId(user.getUserId());
        model.setCreateBy(user.getRealName());
        model.setCreateTime(new Date());
        model.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        int insert = this.projectInterflowContactsMapper.insert(model);
        if (insert != 1){
            throw new SystemParamCheckException("新增报错，请重试");
        }
        return model;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowContactsModel> models) {
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowContactsModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowContactsMapper.insertList(list);
            }
        } else {
            return this.projectInterflowContactsMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowContactsModel model) {
        return model != null && this.projectInterflowContactsMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowContactsModel selectById(Long id) {
        return id == null ? null : this.projectInterflowContactsMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowContactsModel> selectByModel(ProjectInterflowContactsModel model) {
        if (model==null || model.getBusinessId()==null){
            throw new SystemParamCheckException("参数传入异常，查询错误");
        }
        model.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        return this.projectInterflowContactsMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowContactsModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowContactsMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowContactsModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowContactsMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(ProjectInterflowContactsModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        int delete = this.projectInterflowContactsMapper.deleteById(model.getId());
        if(delete==1){
            return true;
        }
        throw new SystemParamCheckException("删除报错，请重试");
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(ProjectInterflowContactsModel model) {
        if (model == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        if (model.getId() == null) {
            model.setCreateId(user.getUserId());
            model.setCreateBy(user.getRealName());
            model.setCreateTime(new Date());
            model.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
            int insert = this.projectInterflowContactsMapper.insert(model);
            if(insert==1){
                return true;
            }
        }else {

            model.setUpdateId(user.getUserId());
            model.setUpdateBy(user.getRealName());
            model.setUpdateTime(new Date());
            int update = this.projectInterflowContactsMapper.updateById(model);
            if(update==1){
                return true;
            }
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    /**
     * 根据businessId获取数据
     */
    List<Long> selectByBusinessId(Long businessId){
        List<Long> list = projectInterflowContactsMapper.selectByBusinessId(businessId);
        return list;
    }
}