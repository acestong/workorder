package com.fea.project.service.product;

import com.alibaba.fastjson.JSONObject;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.product.ProjectProductSwotMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.product.SwotTypeEnum;
import com.fea.project.model.product.ProjectProductSwotModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/03/20
 */
@Service
public class ProjectProductSwotService {

    @Resource
    private ProjectProductSwotMapper projectProductSwotMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductSwotMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductSwotMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(ProjectProductSwotModel model) {
        if (model == null ){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateId(currentUsr.getUserId());
        model.setCreateTime(new Date());
        model.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        return this.projectProductSwotMapper.insertSelective(model) > 0;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductSwotModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductSwotModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductSwotMapper.insertList(list);
            }
        } else {
            return this.projectProductSwotMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectProductSwotModel model) {
        return model != null && this.projectProductSwotMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectProductSwotModel selectById(Long id) {
        return id == null ? null : this.projectProductSwotMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductSwotModel> selectByModel(ProjectProductSwotModel model) {
        return model == null ? new ArrayList<>(0) : this.projectProductSwotMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductSwotModel model) {
        if (model == null || model.getId() == null){
            return false;
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        return this.projectProductSwotMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductSwotModel model) {
        return !(model == null || model.getId() == null) && this.projectProductSwotMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductSwotModel model) {
        if (model == null || model.getId() == null){
            return false;
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateTime(new Date());
        model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        return this.projectProductSwotMapper.updateByIdSelective(model) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductSwotModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductSwotMapper.insert(model) == 1;
        }
        return this.projectProductSwotMapper.updateById(model) == 1;
    }
    public Object selectSwotList(ProjectProductSwotModel model){
        if (model==null && model.getProjectId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        //获取立项产品名称
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("productName","产品名");
        List<ProjectProductSwotModel> projectProductSwotModels = projectProductSwotMapper.selectByModel(model);
        if (!projectProductSwotModels.isEmpty()){
            List<ProjectProductSwotModel> stengthsList = new ArrayList<>();
            List<ProjectProductSwotModel> weaknessList = new ArrayList<>();
            List<ProjectProductSwotModel> opportunityList = new ArrayList<>();
            List<ProjectProductSwotModel> soList = new ArrayList<>();
            List<ProjectProductSwotModel> woList = new ArrayList<>();
            List<ProjectProductSwotModel> threatsList = new ArrayList<>();
            List<ProjectProductSwotModel> stList = new ArrayList<>();
            List<ProjectProductSwotModel> wtList = new ArrayList<>();
            projectProductSwotModels.forEach(swot -> {
                if (Objects.equals(SwotTypeEnum.PRODUCT_COMPETITIVE_STENGTHS.getType(),swot.getSwotType())){
                    stengthsList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_COMPETITIVE_WEAKNESS.getType(),swot.getSwotType())){
                    weaknessList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_EXTERNAL_OPPORTUNITY.getType(),swot.getSwotType())){
                    opportunityList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_SO_STRATEGY.getType(),swot.getSwotType())){
                    soList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_WO_STRATEGY.getType(),swot.getSwotType())){
                    woList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_EXTERNAL_THREATS.getType(),swot.getSwotType())){
                    threatsList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_ST_STRATEGY.getType(),swot.getSwotType())){
                    stList.add(swot);
                }else if (Objects.equals(SwotTypeEnum.PRODUCT_WT_STRATEGY.getType(),swot.getSwotType())){
                    wtList.add(swot);
                }
            });
            jsonObject.put("stengthsList",stengthsList);
            jsonObject.put("weaknessList",weaknessList);
            jsonObject.put("opportunityList",opportunityList);
            jsonObject.put("soList",soList);
            jsonObject.put("woList",woList);
            jsonObject.put("threatsList",threatsList);
            jsonObject.put("stList",stList);
            jsonObject.put("wtList",wtList);
        }
        return jsonObject;
    }
}