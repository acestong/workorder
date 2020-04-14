package com.fea.project.service.flow;

import com.fea.project.api.other.model.base.SysDictionaryItemModel;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysDictionaryItemService;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.flow.ProjectFlowListMapper;
import com.fea.project.enums.base.ActionEnum;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.base.ProjectActionCodeEnum;
import com.fea.project.enums.flow.base.ProjectFlowTypeEnum;
import com.fea.project.enums.flow.base.ProjectFlowVerifyTypeEnum;
import com.fea.project.enums.flow.base.ProjectPersonTypeEnum;
import com.fea.project.model.establishproject.team.ProjectEstablishTeamModel;
import com.fea.project.model.flow.ProjectFlowListModel;
import com.fea.project.model.flow.ProjectFlowModel;
import com.fea.project.model.flow.pojo.ProjectFlowListPojo;
import com.fea.project.model.flow.vo.ProjectFlowCopyerVo;
import com.fea.project.model.flow.vo.ProjectFlowListConditionVo;
import com.fea.project.model.flow.vo.ProjectFlowListVo;
import com.fea.project.model.flow.vo.ProjectFlowVerifyerVo;
import com.fea.project.util.ListUtil;
import com.fea.project.util.NumberUtil;
import com.fea.project.util.UserUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/10/10.
 */
@Service
public class ProjectFlowListService {

    @Autowired
    private ProjectFlowListMapper projectFlowListMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ProjectFlowListConditionService projectFlowListConditionService;

    @Autowired
    private ProjectFlowCopyerService projectFlowCopyerService;

    @Autowired
    private ProjectFlowVerifyerService projectFlowVerifyerService;

    public static final String CURRENCY_CODE = "currency";
    @Autowired
    private SysDictionaryItemService sysDictionaryItemService;

    /**
     * 按主键删除
     */
    public boolean deleteById(Long id) {
        return id != null && this.projectFlowListMapper.deleteById(id) >= 0;
    }

    /**
     * 按主键删除
     */
    public boolean deleteByIds(List<Long> ids) {
        return ids != null && (ids.isEmpty() || this.projectFlowListMapper.deleteByIds(ids) > 0);
    }

    /**
     * 插入数据
     */
    public boolean insert(ProjectFlowListModel model) {
        return model != null && this.projectFlowListMapper.insert(model) == 1;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectFlowListModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectFlowListModel> list : ListUtil.getSubList(models, 100)) {
                this.projectFlowListMapper.insertList(list);
            }
        } else {
            return this.projectFlowListMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectFlowListModel model) {
        return model != null && this.projectFlowListMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectFlowListModel selectById(Long id) {
        return id == null ? null : this.projectFlowListMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectFlowListModel> selectByModel(ProjectFlowListModel model) {
        return model == null ? new ArrayList<>(0) : this.projectFlowListMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectFlowListModel model) {
        return !(model == null || model.getId() == null) && this.projectFlowListMapper.deleteById(model.getId()) >= 0;
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectFlowListModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectFlowListMapper.insertSelective(model) >= 0;
        }
        return this.projectFlowListMapper.updateByIdSelective(model) >= 0;
    }

    public List<ProjectFlowListVo> selectProjectFlowListByParam(ProjectFlowListModel model) {
        if (model == null || model.getFlowId() == null) {
            throw new SystemParamCheckException("流程id传入异常，无法进行查询");
        }
        return this.projectFlowListMapper.selectVosByModels(model);
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectFlowListPojo updateModel(ProjectFlowListPojo model, ProjectFlowVerifyTypeEnum projectFlowVerifyTypeEnum) {
        if (!Objects.equals(model.getFlowConfigType(), ProjectFlowVerifyTypeEnum.TYPE_DEFAULT.getValue()) && ListUtil.isNullOrEmpty(model.getProjectFlowListConditionModels())) {
            throw new SystemParamCheckException("条件参数无存在，无法定义条件类型数据");
        }
        if (model.getId() != null) {
            ProjectFlowListModel tmpModel = this.projectFlowListMapper.selectById(model.getId());
            model.setIndex(tmpModel.getIndex());
            if (!Objects.equals(model.getFlowConfigType(), ProjectFlowVerifyTypeEnum.TYPE_DEFAULT.getValue())) {
                model.setId(null);
            }
        } else {
            model.setIndex(ProjectFlowVerifyTypeEnum.getIndex(model.getFlowConfigType()));
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.INSERT_ACTION);
        if (this.insertOrUpdate(model)
                && this.projectFlowListConditionService.insertOrUpdateProjectConditions(model, sysUserModel, projectFlowVerifyTypeEnum)
                && this.projectFlowCopyerService.insertOrUpdateProjectFlowCopyers(model, sysUserModel)
                && this.projectFlowVerifyerService.insertOrUpdateProjectFLowVerifyers(model, sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("流程条件数据添加报错");
    }

    public List<ProjectFlowListVo> selectList(ProjectFlowListPojo model) {
        if (Objects.isNull(model) || ListUtil.isNullOrEmpty(model.getIds())) {
            throw new SystemParamCheckException("传入的id异常，无法进行查询");
        }
        List<ProjectFlowListVo> list = this.projectFlowListMapper.selectVosByIds(model.getIds());
        this.fileFullFlowInfo(list);
        return list;
    }

    public void fileFullFlowInfo(List<ProjectFlowListVo> list) {
        if (ListUtil.isNullOrEmpty(list)) {
            return;
        }
        Map<Integer, Set<Long>> copyerNameMap = new HashMap<>();
        Map<Integer, Set<Long>> verifyNameMap = new HashMap<>();
        Map<Integer, Set<Object>> conditionMap = new HashMap<>();
        Integer typeId = list.get(0).getTypeId();
        Map<Integer, String> flowVerifyTypeNamesMap = ProjectFlowTypeEnum.getTargetMap(typeId).getFlowTypeConditionMap();
        Map<Integer, Map<Integer, String>> actionMap = ProjectActionCodeEnum.getActionMap();
        Map<Long, String> currencyType = this.sysDictionaryItemService.selectByShortNameAndRegId(CURRENCY_CODE, UserUtil.getUserRegId())
                .stream().collect(Collectors.toMap(SysDictionaryItemModel::getITEMID, SysDictionaryItemModel::getDICVALUE));
        list.forEach(x -> {
            List<ProjectFlowVerifyerVo> verifyerVos = x.getProjectFlowVerifyerModels();
            List<ProjectFlowCopyerVo> copyerVos = x.getProjectFlowCopyerModels();
            List<ProjectFlowListConditionVo> conditionVos = x.getProjectFlowListConditionModels();
            copyerVos.forEach(y -> {
                if (StringUtil.isEmpty(y.getDetailStr())) {
                    return;
                }
                ListUtil.addWithNull(copyerNameMap.computeIfAbsent(y.getPersonType(), value -> new HashSet<>())
                        , Long.parseLong(y.getDetailStr()));
            });
            verifyerVos.forEach(y -> {
                if (StringUtil.isEmpty(y.getDetailStr())) {
                    return;
                }
                ListUtil.addWithNull(verifyNameMap.computeIfAbsent(y.getPersonType(), value -> new HashSet<>())
                        , Long.parseLong(y.getDetailStr()));
            });
            conditionVos.forEach(y -> {
                y.setFieldTypeName(flowVerifyTypeNamesMap.get(y.getFieldType()));
                y.setFilterTypeName(actionMap.computeIfAbsent(y.getActionCode(), value -> new HashMap<>()).get(y.getFilterType()));
                if (Objects.equals(ProjectActionCodeEnum.TYPE_NUMBER.getValue(), y.getActionCode())) {
                    y.setFilterValues(Stream.of(y.getFilterValue().split(",")).filter(StringUtil::isNotEmpty).collect(Collectors.toList()));
                    y.setFilterValueUnitName(currencyType.get(y.getFilterValueUnit()));
                } else {
                    y.setFilterValues(new ArrayList<>());
                }
                if (Objects.equals(y.getFilterType(), ProjectActionCodeEnum.TYPE_VARCHAR.getValue())) {
                    ListUtil.addAllWithNull(conditionMap.computeIfAbsent(y.getFieldType(), value -> new HashSet<>())
                            , Stream.of(y.getFilterValue().split(",")).filter(StringUtil::isNotEmpty)
                                    .map(Long::parseLong).collect(Collectors.toSet()));
                }
            });
        });
        //流程抄送人翻译
        Map<Integer, Map<Long, String>> copyerMap = ProjectPersonTypeEnum.getNamesMap(copyerNameMap);
        Map<Integer, Map<Long, String>> verifyMap = ProjectPersonTypeEnum.getNamesMap(verifyNameMap);
        Map<Integer, Map<Long, String>> conditionNamesMap = ProjectFlowTypeEnum.getTargetConditionNamesMap(typeId, conditionMap);
        list.forEach(x -> {
            List<ProjectFlowVerifyerVo> verifyerVos = x.getProjectFlowVerifyerModels();
            List<ProjectFlowCopyerVo> copyerVos = x.getProjectFlowCopyerModels();
            List<ProjectFlowListConditionVo> conditionVos = x.getProjectFlowListConditionModels();
            copyerVos.forEach(y -> y.setDetailStrName(Objects.equals(y.getPersonType(), ProjectPersonTypeEnum.TYPE_APPLYER.getValue()) ?
                    ProjectPersonTypeEnum.TYPE_APPLYER.getText() : copyerMap.computeIfAbsent(y.getPersonType(), value -> new HashMap<>()).get(Long.parseLong(y.getDetailStr()))));
            verifyerVos.forEach(y -> y.setDetailStrName(Objects.equals(y.getPersonType(), ProjectPersonTypeEnum.TYPE_APPLYER.getValue()) ?
                    ProjectPersonTypeEnum.TYPE_APPLYER.getText() : verifyMap.computeIfAbsent(y.getPersonType(), value -> new HashMap<>()).get(Long.parseLong(y.getDetailStr()))));
            conditionVos.forEach(y -> {
                Map<Long, String> tmpMap = conditionNamesMap.computeIfAbsent(y.getFieldType(), key -> new HashMap<>());
                if (tmpMap.isEmpty()) {
                    return;
                }
                Stream.of(y.getFilterValue().split(",")).filter(z -> !StringUtil.isEmpty(z))
                        .map(Long::parseLong).forEach(z -> y.getFilterValues().add(tmpMap.get(z)));
            });
        });
    }


    public void fillVerifyInfo(List<ProjectFlowVerifyerVo> list) {
        if (ListUtil.isNullOrEmpty(list)) {
            throw new SystemParamCheckException("审核人信息定义异常");
        }
        Map<Integer, Set<Long>> verifyNameMap = new HashMap<>();
        list.forEach(projectFlowVerifyerVo -> {
            if (StringUtil.isEmpty(projectFlowVerifyerVo.getDetailStr())) {
                return;
            }
            ListUtil.addWithNull(verifyNameMap.computeIfAbsent(projectFlowVerifyerVo.getPersonType(), value -> new HashSet<>())
                    , Long.parseLong(projectFlowVerifyerVo.getDetailStr()));
        });
        Map<Integer, Map<Long, String>> verifyMap = ProjectPersonTypeEnum.getNamesMap(verifyNameMap);
        list.forEach(projectFlowVerifyerVo -> projectFlowVerifyerVo.setDetailStrName(Objects.equals(projectFlowVerifyerVo.getPersonType(), ProjectPersonTypeEnum.TYPE_APPLYER.getValue()) ?
                ProjectPersonTypeEnum.TYPE_APPLYER.getText() : verifyMap.computeIfAbsent(projectFlowVerifyerVo.getPersonType(), value -> new HashMap<>()).get(Long.parseLong(projectFlowVerifyerVo.getDetailStr()))));
    }

    boolean updateModelByIds(ProjectFlowListModel model, List<Long> ids) {
        if (model == null || ids == null) {
            throw new SystemParamCheckException("参数传入异常，无法进行更新");
        }
        if (ids.isEmpty()) {
            return true;
        }
        return this.projectFlowListMapper.updateModelByIds(model, ids) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProjectFlowListModel deleteModel(ProjectFlowListPojo model) {
        if (model == null || model.getIds() == null) {
            throw new SystemParamCheckException("条件流程id异常，无法进行删除");
        }
        if (model.getIds().isEmpty()) {
            return model;
        }
        SysUserModel sysUserModel = sysUserService.getCurrentUsr();
        model.setUserInfo(sysUserModel, ActionEnum.UPDATE_ACTION);
        model.setDelStatus(DeleteStatusEnum.DELETE.getStatus());
        if (this.projectFlowListMapper.updateByIdsSelective(model) >= 0
                && this.projectFlowListConditionService.deleteModel(model, sysUserModel)
                && this.projectFlowVerifyerService.deleteByModel(model, sysUserModel)
                && this.projectFlowCopyerService.deleteByModel(model, sysUserModel)) {
            return model;
        }
        throw new SystemParamCheckException("项目删除异常，无法进行删除");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByFlowInfo(ProjectFlowModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("流程id传入异常，无法进行删除");
        }
        if (this.deleteByFlowId(model.getId())) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目删除异常，无法进行删除");
    }

    private boolean deleteByFlowId(Long flowId) {
        List<Long> flowListIds = this.projectFlowListMapper.selectByModel(new ProjectFlowListModel(flowId)).stream()
                .map(ProjectFlowListModel::getId).collect(Collectors.toList());
        if (this.deleteModel(new ProjectFlowListPojo(flowListIds)) != null) {
            return Boolean.TRUE;
        }
        throw new SystemParamCheckException("项目删除异常，无法进行删除");
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByNoDefaultAndNoIds(Long flowId, List<Long> ids) {
        if (ids == null || flowId == null) {
            throw new SystemParamCheckException("删除条件流程传参异常");
        }
        return this.projectFlowListMapper.deleteByNoDefaultAndNoIds(flowId, ids) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Long> exchangeIndex(List<Long> ids) {
        if(ListUtil.isNullOrEmpty(ids) || ids.size() != NumberUtil.SIZE_TWO){
            throw new SystemParamCheckException("传入的列表id异常，无法进行操作");
        }
        List<ProjectFlowListModel> projectFlowListModels = this.projectFlowListMapper.selectByIds(ids);
        if(projectFlowListModels.size() != ids.size()){
            throw new SystemParamCheckException("传入的列表id查询异常，请刷新后重试");
        }
        if(!Objects.equals(projectFlowListModels.get(0).getFlowId(), projectFlowListModels.get(1).getFlowId())){
            throw new SystemParamCheckException("当前队列归属于不同的项目，无法调整顺序");
        }
        SysUserModel userModel = sysUserService.getCurrentUsr();
        List<ProjectFlowListModel> actionList = ProjectFlowListModel.createExchangeIndexList(projectFlowListModels, userModel);
        actionList.forEach(x -> this.projectFlowListMapper.updateByIdSelective(x));
        return ids;
    }
}