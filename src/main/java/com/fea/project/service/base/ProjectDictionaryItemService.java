package com.fea.project.service.base;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.base.ProjectDictionaryItemMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.DictionaryTypeEnum;
import com.fea.project.model.base.ProjectDictionaryItemModel;
import com.fea.project.model.base.ProjectDictionaryModel;
import com.fea.project.model.base.vo.ProjectDictionaryItemSelectVo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/09/25.
 */
@Service
public class ProjectDictionaryItemService {

    @Autowired
    private ProjectDictionaryItemMapper projectDictionaryItemMapper;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectDictionaryItemMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectDictionaryItemMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectDictionaryItemModel model) {
        return model != null && this.projectDictionaryItemMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectDictionaryItemModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectDictionaryItemModel> list : ListUtil.getSubList(models, 100)) {
                this.projectDictionaryItemMapper.insertList(list);
            }
        } else {
            return this.projectDictionaryItemMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectDictionaryItemModel model) {
        return model != null && this.projectDictionaryItemMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectDictionaryItemModel selectById(Long id) {
        return id == null ? null : this.projectDictionaryItemMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectDictionaryItemModel> selectByModel(ProjectDictionaryItemModel model) {
        return model == null ? new ArrayList<>(0) : this.projectDictionaryItemMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectDictionaryItemModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryItemMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectDictionaryItemModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryItemMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectDictionaryItemModel model) {
        return !(model == null || model.getId() == null) && this.projectDictionaryItemMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectDictionaryItemModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectDictionaryItemMapper.insert(model) == 1;
        }
        return this.projectDictionaryItemMapper.updateById(model) == 1;
    }

    public List<ProjectDictionaryItemSelectVo> listByShortNameAndRegIdWhenNullCreate(ProjectDictionaryModel model) {
        if (model == null || StringUtils.isEmpty(model.getShortName()) || model.getRegId() == null) {
            throw new SystemParamCheckException("数据字段特征码/人员组织信息未传入，无法查询对应的数据字典值");
        }
        Long regId = model.getRegId();
        List<ProjectDictionaryItemModel> list = null;
        synchronized (this) {
            list = this.projectDictionaryItemMapper
                    .selectByShortNameAndRegIdAndDelStatus(model.getShortName(), regId, DeleteStatusEnum.NOT_DELETE.getStatus());
            if (list.isEmpty()) {
                //检查是否已经存在复制后，删除的情况
                List<ProjectDictionaryItemModel> deleteList = this.projectDictionaryItemMapper
                        .selectByShortNameAndRegIdAndDelStatus(model.getShortName(), regId, DeleteStatusEnum.DELETE.getStatus());
                if (deleteList.isEmpty()) {
                    list = this.projectDictionaryItemMapper.selectByShortNameAndRegIdAndDelStatus(model.getShortName(), null, DeleteStatusEnum.NOT_DELETE.getStatus());
                    SysUserModel sysUserModel = sysUserService.selectById(UserUtil.getUserId());
                    list.forEach(tmp -> {
                        tmp.setId(null);
                        tmp.setRegId(regId);
                        tmp.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
                    });
                    this.projectDictionaryItemMapper.insertList(list);
                }
            }
        }
        return ProjectDictionaryItemSelectVo.createList(list);
    }

    /**
     * 基础参数包括,项目类型，优先级，项目级别，风险等级
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> selectProjectInitParamWhenNullCreate() {
        Long regId = UserUtil.getUserRegId();
        Map<String, Object> map = new HashMap<>(16);
        map.put(DictionaryTypeEnum.PROJECT_TYPE.getValue(), this.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_TYPE.getValue(), regId)));
        map.put(DictionaryTypeEnum.PROJECT_PRIORITY.getValue(), this.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_PRIORITY.getValue(), regId)));
        map.put(DictionaryTypeEnum.PROJECT_LEVEL.getValue(), this.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_LEVEL.getValue(), regId)));
        map.put(DictionaryTypeEnum.PROJECT_RISK_LEVEL.getValue(), this.listByShortNameAndRegIdWhenNullCreate(new ProjectDictionaryModel(DictionaryTypeEnum.PROJECT_RISK_LEVEL.getValue(), regId)));
        return map;
    }

    public List<ProjectDictionaryItemModel> selectByIds(List<Long> ids) {
        if (ids == null) {
            throw new SystemParamCheckException("传入参数异常，无法进行查询");
        }
        if (ids.isEmpty()) {
            return new ArrayList<>();
        }
        return this.projectDictionaryItemMapper.selectByIds(ids);
    }

    public List<ProjectDictionaryItemModel> selectTreeById(Long id) {
        if (id == null) {
            return new ArrayList<>();
        }
        return this.projectDictionaryItemMapper.selectTreeById(id);
    }
}