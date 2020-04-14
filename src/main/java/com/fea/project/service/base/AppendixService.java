package com.fea.project.service.base;

import com.fea.project.dao.base.AppendixMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.RequestReturnCodeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.PageInfoQueryOrderAndFilterModel;
import com.fea.project.model.base.AppendixModel;
import com.fea.project.model.base.BaseResultModel;
import com.fea.project.util.ListUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/05/07.
 * 附件表  Service
 */
@Service
public class AppendixService {

    @Autowired
    private AppendixMapper appendixMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.appendixMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.appendixMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(AppendixModel model) {
        return model != null && this.appendixMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<AppendixModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<AppendixModel> list : ListUtil.getSubList(models, 100)) {
                this.appendixMapper.insertList(list);
            }
        } else {
            return this.appendixMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(AppendixModel model) {
        return model != null && this.appendixMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public AppendixModel selectById(Long id) {
        return id == null ? null : this.appendixMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<AppendixModel> selectByModel(AppendixModel model) {
        return model == null ? new ArrayList<>(0) : this.appendixMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(AppendixModel model) {
        return !(model == null || model.getId() == null) && this.appendixMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(AppendixModel model) {
        return !(model == null || model.getId() == null) && this.appendixMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(AppendixModel model) {
        return !(model == null || model.getId() == null) && this.appendixMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(AppendixModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.appendixMapper.insert(model) == 1;
        }
        return this.appendixMapper.updateById(model) == 1;
    }

    public Boolean updateBusinessIdByIds(Long id, List<Long> appendixs) {
        if (appendixs == null || appendixs.isEmpty()) {
            return true;
        }
        if (id == null) {
            return false;
        }
        //将之前的不属于当前提交的id文件，状态进行假删除
        this.appendixMapper.updateAppendixDeleteStatusWhenNotInAppendixs(id, appendixs);
        //更新本次文件
        this.appendixMapper.updateBusinessIdByIds(id, appendixs);
        return true;
    }


    /**
     * 插入数据
     *
     * @param appendixModel
     * @param request
     * @return
     */
    public AppendixModel insertModel(AppendixModel appendixModel, HttpServletRequest request) {
        try {


            appendixModel.setDelStatus(DeleteStatusEnum.NOT_DELETE.getStatus());

            //插入数据
            if (this.insertSelective(appendixModel)) {
                return appendixModel;
            }

        } catch (Exception ex) {
            return null;
        }

        return null;
    }


    public List<AppendixModel> selectByFilterAndOrderParams(PageInfoQueryOrderAndFilterModel<AppendixModel> caseModelPageInfoQueryOrderAndFilterModel) {
        return this.appendixMapper.selectByFilterAndOrderParams(caseModelPageInfoQueryOrderAndFilterModel);
    }


    public BaseResultModel listByParam(BasePageInfo<AppendixModel> pageInfo) throws Exception {
        //如果是从线索中点开，查看当前人负责的
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(), true);
        List<AppendixModel> list = this.selectByFilterAndOrderParams(new PageInfoQueryOrderAndFilterModel<>(pageInfo));
        return RequestReturnCodeEnum.createRightModel(new BasePageInfo<>(list));
    }

}