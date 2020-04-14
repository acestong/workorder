package com.fea.project.api.other.service.base;

import com.fea.project.api.other.dao.base.SysUriMapper;
import com.fea.project.api.other.model.base.SysUriModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/03/06.
 * 通用资源表 Service
 */
@Service
public class SysUriService {

    @Autowired
    private SysUriMapper sysUriMapper;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long URIID) {
        return URIID != null && this.sysUriMapper.deleteById(URIID) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.sysUriMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(SysUriModel model) {
        return model != null && this.sysUriMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<SysUriModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<SysUriModel> list : ListUtil.getSubList(models, 100)) {
                this.sysUriMapper.insertList(list);
            }
        } else {
            return this.sysUriMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(SysUriModel model) {
        return model != null && this.sysUriMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public SysUriModel selectById(Long URIID) {
        return URIID == null ? null : this.sysUriMapper.selectById(URIID);
    }

    /**
     * 按模型选择
     */
    public List<SysUriModel> selectByModel(SysUriModel model) {
        return model == null ? new ArrayList<>(0) : this.sysUriMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(SysUriModel model) {
        return !(model == null || model.getURIID() == null) && this.sysUriMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(SysUriModel model) {
        return !(model == null || model.getURIID() == null) && this.sysUriMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(SysUriModel model) {
        return !(model == null || model.getURIID() == null) && this.sysUriMapper.deleteById(model.getURIID()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(SysUriModel model) {
        if (model == null) {
            return false;
        }
        if (model.getURIID() == null) {
            return this.sysUriMapper.insert(model) == 1;
        }
        return this.sysUriMapper.updateById(model) == 1;
    }


    public List<SysUriModel> selectByCurrentUserProjectPriority(String projectManagePrioirtyStr) {
        Long userId = UserUtil.getUserId();
        return this.sysUriMapper.selectByCurrentUserProjectPriority(userId, projectManagePrioirtyStr);
    }

    public List<SysUriModel> selectByPriorityStr(String projectManagePriorityStr) {
        return this.sysUriMapper.selectByPriorityStr(projectManagePriorityStr);
    }
}