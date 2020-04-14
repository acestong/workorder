package com.fea.project.service.product;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.annotations.base.PrimaryKey;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.product.ProjectProductMapper;
import com.fea.project.dao.product.ProjectProductProfitMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.model.product.ProjectProductProfitModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/27.
 */
@Service
public class ProjectProductProfitService {

    @Autowired
    private ProjectProductProfitMapper projectProductProfitMapper;
    @Autowired
    private ProjectProductMapper projectProductMapper;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectProductProfitModel model) {
        if (model == null || model.getProductId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        //查询当前产品下利润分析字段列表
        List<ProjectProductProfitModel> models = projectProductProfitMapper.selectByModel(
                ProjectProductProfitModel.builder().productId(model.getProductId()).build());
        //默认每次字段排序+1
        int maxOrdering=0;
        if (models.isEmpty()){
            maxOrdering=0;
        }
        for (int i=0;i<models.size();i++){
            if (models.get(i).getOrdering()>maxOrdering){
                maxOrdering=models.get(i).getOrdering();
            }
        }
        model.setOrdering(maxOrdering+1);
        //创建人
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        model.setCreateId(currentUsr.getUserId());
        model.setCreateBy(currentUsr.getRealName());
        model.setCreateTime(new Date());
        model.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());
        return model != null && this.projectProductProfitMapper.insertSelective(model) == 1;
    }

    /**
     * 按模型选择
     */
    public List<ProjectProductProfitModel> selectByModel(ProjectProductProfitModel model) {
        List<ProjectProductProfitModel> models = projectProductProfitMapper.selectByModel(model);
        models.forEach(temp->{
            temp.setProductName(projectProductMapper.selectById(temp.getProductId()).getName());
        });
        return models;
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectProductProfitModel model) {
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        //更新人
        model.setUpdateId(currentUsr.getUserId());
        model.setUpdateBy(currentUsr.getRealName());
        model.setUpdateTime(new Date());
        return !(model == null || model.getId() == null) && this.projectProductProfitMapper.updateByIdSelective(model) == 1;
    }

    public void moveUp(Long id) {
        //获取要上移的那条数据的信息
        ProjectProductProfitModel profitModel = projectProductProfitMapper.selectById(id);
        //查询上一条记录
        ProjectProductProfitModel profit = new ProjectProductProfitModel();
        profit.setOrdering(profitModel.getOrdering()-1);
        ProjectProductProfitModel profitPrev = projectProductProfitMapper.selectByModel(profit).get(0);
        //最上面的记录不能上移
        if (profitPrev == null) {
            return;
        }
        //交换两条记录的sort值
        Integer temp = profitModel.getOrdering();
        profitModel.setOrdering(profitPrev.getOrdering());
        profitPrev.setOrdering(temp);
        //更新到数据库
        projectProductProfitMapper.updateByIdSelective(profitModel);
        projectProductProfitMapper.updateByIdSelective(profitPrev);
    }

    public void moveDown(Long id) {
        //获取要下移的那条数据的信息
        ProjectProductProfitModel profitModel = projectProductProfitMapper.selectById(id);
        //查询下一条记录
        ProjectProductProfitModel profit = new ProjectProductProfitModel();
        profit.setOrdering(profitModel.getOrdering()+1);
        ProjectProductProfitModel moveDown = projectProductProfitMapper.selectByModel(profit).get(0);
        //最下面的记录不能下移
        if (moveDown == null) {
            return;
        }
        //交换两条记录的sort值
        Integer temp = profitModel.getOrdering();
        profitModel.setOrdering(moveDown.getOrdering());
        moveDown.setOrdering(temp);
        //更新到数据库
        projectProductProfitMapper.updateByIdSelective(profitModel);
        projectProductProfitMapper.updateByIdSelective(moveDown);
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectProductProfitMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectProductProfitMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectProductProfitModel model) {
        return model != null && this.projectProductProfitMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectProductProfitModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectProductProfitModel> list : ListUtil.getSubList(models, 100)) {
                this.projectProductProfitMapper.insertList(list);
            }
        } else {
            return this.projectProductProfitMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 按主键选择
     */
    public ProjectProductProfitModel selectById(Long id) {
        return id == null ? null : this.projectProductProfitMapper.selectById(id);
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectProductProfitModel model) {
        return !(model == null || model.getId() == null) && this.projectProductProfitMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectProductProfitModel model) {
        return !(model == null || model.getId() == null) && this.projectProductProfitMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectProductProfitModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectProductProfitMapper.insert(model) == 1;
        }
        return this.projectProductProfitMapper.updateById(model) == 1;
    }
}