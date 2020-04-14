package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowVisitingMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.interflow.ContactTypeEnum;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.enums.interflow.PhoneTypeEnum;
import com.fea.project.enums.interflow.VisitingTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import com.fea.project.model.interflow.vo.InterflowCommonVo;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowVisitingModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowVisitingModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
public class ProjectInterflowVisitingService {

    @Resource
    private ProjectInterflowVisitingMapper projectInterflowVisitingMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectInterflowContactsService contactsService;
    @Autowired
    private ProjectAppendixService projectAppendixService;

    /**
     * 获取列表
     */
    public List<ProjectInterflowListShowVo> showVisitingList(QueryInterflowParamVo model){
        List<ProjectInterflowListShowVo> listShowVos = projectInterflowVisitingMapper.selectShowListByProjectId(model);
        listShowVos.forEach(vo->{
            vo.setTypeString(InterflowTypeEnum.getMap().get(vo.getType()));
            vo.setWayString(VisitingTypeEnum.getMap().get(vo.getWay()));
        });
        return listShowVos;
    }
    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo insert(InterflowCommonVo<ProjectInterflowVisitingModel> model) {
        if (model==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectInterflowVisitingModel visitingModel = model.getModel();
        visitingModel.setCreateId(currentUsr.getUserId());
        visitingModel.setCreateBy(currentUsr.getRealName());
        visitingModel.setCreateTime(new Date());
        visitingModel.setType(InterflowTypeEnum.VISITING.getCode());
        visitingModel.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        int insert = this.projectInterflowVisitingMapper.insert(visitingModel);
        if (insert == 1){
            Long visitingModelId = visitingModel.getId();
            //添加外部联系人
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                contact.setBusinessId(visitingModelId);
                contact.setCreateId(currentUsr.getUserId());
                contact.setCreateBy(currentUsr.getRealName());
                contact.setCreateTime(new Date());
                contact.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
            });
            try {
                boolean b = contactsService.insertList(contactModels);
            } catch (Exception e) {
                throw new SystemParamCheckException("新增报错，请重试");
            }
            //关联附件
            List<Long> appendixIds = model.getAppendixIds();
            appendixIds.forEach(appendixId->{
                try {
                    boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId, visitingModelId));
                } catch (Exception e) {
                    throw new SystemParamCheckException("新增报错，请重试");
                }
            });
            return model;
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    /**
     * 获取详情
     */
    public InterflowCommonVo<ProjectInterflowVisitingModelVo> getPhoneModelVo(ProjectInterflowVisitingModel model){
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectInterflowVisitingModelVo visitingModelVo =
                projectInterflowVisitingMapper.selectModelVoById(model.getId());
        visitingModelVo.setTypeString(InterflowTypeEnum.getMap().get(visitingModelVo.getType()));
        visitingModelVo.setWayString(VisitingTypeEnum.getMap().get(visitingModelVo.getWay()));
        visitingModelVo.setContactTypeString(ContactTypeEnum.getMap().get(visitingModelVo.getContactType()));
        List<ProjectInterflowContactsModel> contactsModels = new ArrayList<>();
        if (Objects.equals(visitingModelVo.getContactType(),ContactTypeEnum.INTERNAL_CONTACT.getCode())){
            if (visitingModelVo.getContactId()!=null){
                SysUserModel userModel = sysUserService.selectById(visitingModelVo.getContactId());
                visitingModelVo.setContactName(userModel.getRealName());
            }

        }else if (Objects.equals(visitingModelVo.getContactType(),ContactTypeEnum.EXTERNAL_CONTACT.getCode())){
            contactsModels= contactsService.selectByModel(new ProjectInterflowContactsModel(visitingModelVo.getId()));
        }
        return new InterflowCommonVo<>(visitingModelVo,contactsModels,new ArrayList<>());
    }

    /**
     * 保存编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo<ProjectInterflowVisitingModel> update(InterflowCommonVo<ProjectInterflowVisitingModel> model){
        if (model==null){
            throw new SystemParamCheckException("参数传入错误，无法新增");
        }
        try {
            SysUserModel currentUsr = sysUserService.getCurrentUsr();
            ProjectInterflowVisitingModel visitingModel = model.getModel();
            visitingModel.setUpdateId(currentUsr.getUserId());
            visitingModel.setUpdateBy(currentUsr.getRealName());
            visitingModel.setUpdateTime(new Date());
            int i = this.projectInterflowVisitingMapper.updateByIdSelective(visitingModel);
            //外部联系人
            List<Long> contactIdList = contactsService.selectByBusinessId(visitingModel.getId());
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                if (contact.getId()!=null && contactIdList.contains(contact.getId())){
                    contactIdList.remove(contact.getId());
                }
                contact.setBusinessId(visitingModel.getId());
                boolean b = contactsService.insertOrUpdate(contact);
            });
            boolean b = contactsService.deleteByIds(contactIdList);
            //附件
            List<Long> list = projectAppendixService.selectIdByBusinessId(visitingModel.getId());
            List<Long> appendixIds = model.getAppendixIds();
            appendixIds.forEach(appendixId->{
                if (list.contains(appendixId)){
                    list.remove(appendixId);
                }
                boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId,
                        visitingModel.getId()));
            });
            boolean b1 = projectAppendixService.deleteByIds(list);
        } catch (Exception e) {
            throw new SystemParamCheckException("数据更新报错，请重试");
        }
        return model;
    }

    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowVisitingModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowVisitingModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowVisitingMapper.insertList(list);
            }
        } else {
            return this.projectInterflowVisitingMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowVisitingModel model) {
        return model != null && this.projectInterflowVisitingMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowVisitingModel selectById(Long id) {
        return id == null ? null : this.projectInterflowVisitingMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowVisitingModel> selectByModel(ProjectInterflowVisitingModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowVisitingMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowVisitingModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowVisitingMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowVisitingModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowVisitingMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowVisitingModel model) {
        if (model == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateId(user.getUserId());
        model.setUpdateBy(user.getRealName());
        model.setUpdateTime(new Date());
        model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        int update = this.projectInterflowVisitingMapper.updateByIdSelective(model);
        if (update==1){
            return true;
        }
        throw new SystemParamCheckException("数据更新失败请重试");
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectInterflowVisitingModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectInterflowVisitingMapper.insert(model) == 1;
        }
        return this.projectInterflowVisitingMapper.updateById(model) == 1;
    }
}