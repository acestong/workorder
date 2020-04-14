package com.fea.project.service.baseconfig;

import com.alibaba.fastjson.TypeReference;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.baseconfig.ProjectCodeMapper;
import com.fea.project.enums.baseconfig.ProjectCodeDateStrEnum;
import com.fea.project.enums.task.ProjectTeamTagEnum;
import com.fea.project.model.baseconfig.ProjectCodeModel;
import com.fea.project.model.baseconfig.ProjectCodeShortNameModel;
import com.fea.project.model.baseconfig.pojo.ProjectCodePojo;
import com.fea.project.model.baseconfig.vo.ProjectCodeShortNameVo;
import com.fea.project.model.baseconfig.vo.ProjectCodeVo;
import com.fea.project.service.base.ProjectDictionaryItemService;
import com.fea.project.util.JsonUtil;
import com.fea.project.util.ListUtil;
import com.fea.project.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/09/27.
 */
@Service
public class ProjectCodeService {

    @Autowired
    private ProjectCodeMapper projectCodeMapper;

    @Autowired
    private ProjectDictionaryItemService projectDictionaryItemService;

    @Autowired
    private ProjectCodeShortNameService projectCodeShortNameService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectCodeMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectCodeMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectCodeModel model) {
        return model != null && this.projectCodeMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectCodeModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectCodeModel> list : ListUtil.getSubList(models, 100)) {
                this.projectCodeMapper.insertList(list);
            }
        } else {
            return this.projectCodeMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectCodeModel model) {
        return model != null && this.projectCodeMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectCodeModel selectById(Long id) {
        return id == null ? null : this.projectCodeMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectCodeModel> selectByModel(ProjectCodeModel model) {
        return model == null ? new ArrayList<>(0) : this.projectCodeMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectCodeModel model) {
        return !(model == null || model.getId() == null) && this.projectCodeMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrUpdate(ProjectCodeModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectCodeMapper.insertSelective(model) == 1;
        }
        return this.projectCodeMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 获取配置页面参数
     *
     * @return
     */
    public ProjectCodeModel selectConfig() {
        Long regId = UserUtil.getUserRegId();
        return this.selectOrCreateProjectCodeModel(regId);
    }

    public ProjectCodeVo selectConfig(Long regId) {
        return this.selectOrCreateProjectCodeModel(regId);
    }

    @Transactional(rollbackFor = Exception.class)
    synchronized ProjectCodeVo selectOrCreateProjectCodeModel(Long regId) {
        ProjectCodeVo model = this.projectCodeMapper.selectByRegId(regId);
        if (model == null) {
            model = this.projectCodeMapper.selectByRegId(null);
            ProjectCodeModel tmp = model.createNewModel(regId);
            this.projectCodeMapper.insert(tmp);
            model = this.projectCodeMapper.selectByRegId(regId);
        }
        //将关联的项目类型进行树状转型
        if (ListUtil.isNullOrEmpty(model.getProjectCodeShortNameModels())) {
            return model;
        }
        model.setProjectCodeShortNameModels(this.translateListToTree(model.getProjectCodeShortNameModels()));
        return model;
    }

    private List<ProjectCodeShortNameVo> translateListToTree(List<ProjectCodeShortNameVo> list) {
        Map<Long, ProjectCodeShortNameVo> map = list.stream().collect(Collectors.toMap(ProjectCodeShortNameVo::getDicProjectType, x -> x));
        List<ProjectCodeShortNameVo> returnList = new ArrayList<>();
        list.forEach(x -> {
            x.setTag(ProjectTeamTagEnum.TYPE_TEAM.getValue());
            ProjectCodeShortNameVo tmp = map.get(x.getParentCodeId());
            if (x.getParentCodeId() == null || tmp == null) {
                returnList.add(x);
                return;
            }
            if (tmp.getChildren() == null) {
                tmp.setChildren(new ArrayList<>());
            }
            tmp.getChildren().add(x);
        });
        return returnList;
    }

    @Transactional(rollbackFor = Exception.class)
    boolean insertOrUpdateProjectCode(ProjectCodePojo projectCodePojo) {
        List<ProjectCodeShortNameModel> projectCodeShortNameModels = projectCodePojo.getProjectCodeShortNameModels();
        projectCodePojo.setProjectCodeShortNameModels(null);
        ProjectCodeModel projectCodeModel = JsonUtil.translateFatherToChild(projectCodePojo, new TypeReference<ProjectCodeModel>() {
        });
        if (this.insertOrUpdate(projectCodeModel) && this.projectCodeShortNameService.insertOrUpdateList(projectCodeShortNameModels, projectCodeModel.getId())) {
            return true;
        }
        throw new SystemParamCheckException("项目编号更新报错");
    }

    public List<Map<String, Object>> selectDateTypeMap() {
        return ProjectCodeDateStrEnum.getProjectCodeNeedDateStr();
    }
}