package com.fea.project.service.feebudget;


import com.fea.project.dao.feebudget.FeePurchaseDetailMapper;
import com.fea.project.model.feebudget.FeePurchaseDetailModel;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 * 采购明细表 Service
 */
@Service
public class FeePurchaseDetailService {

    @Autowired
    private FeePurchaseDetailMapper feePurchaseDetailMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long ID) {
        return ID != null && this.feePurchaseDetailMapper.deleteById(ID) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.feePurchaseDetailMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(FeePurchaseDetailModel model) {
        return model != null && this.feePurchaseDetailMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<FeePurchaseDetailModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<FeePurchaseDetailModel> list : ListUtil.getSubList(models, 100)) {
                this.feePurchaseDetailMapper.insertList(list);
            }
        } else {
            return this.feePurchaseDetailMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(FeePurchaseDetailModel model) {
        return model != null && this.feePurchaseDetailMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public FeePurchaseDetailModel selectById(Long ID) {
        return ID == null ? null : this.feePurchaseDetailMapper.selectById(ID);
    }

    /**
     * 按模型选择
     */
    public List<FeePurchaseDetailModel> selectByModel(FeePurchaseDetailModel model) {
        return model == null ? new ArrayList<>(0) : this.feePurchaseDetailMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(FeePurchaseDetailModel model) {
        return !(model == null || model.getID() == null) && this.feePurchaseDetailMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(FeePurchaseDetailModel model) {
        return !(model == null || model.getID() == null) && this.feePurchaseDetailMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(FeePurchaseDetailModel model) {
        return !(model == null || model.getID() == null) && this.feePurchaseDetailMapper.deleteById(model.getID()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(FeePurchaseDetailModel model) {
        if (model == null) {
            return false;
        }
        if (model.getID() == null) {
            return this.feePurchaseDetailMapper.insert(model) == 1;
        }
        return this.feePurchaseDetailMapper.updateById(model) == 1;
    }
}