package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowPhoneMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.interflow.ContactTypeEnum;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.enums.interflow.PhoneTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import com.fea.project.model.interflow.ProjectInterflowPhoneModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fea.project.model.interflow.vo.InterflowCommonVo;
import com.fea.project.model.interflow.vo.ProjectInterflowListShowVo;
import com.fea.project.model.interflow.vo.ProjectInterflowPhoneModelVo;
import com.fea.project.model.interflow.vo.QueryInterflowParamVo;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 *
 * @author Administrator
 * @date 2020/01/09
 */
@Service
public class ProjectInterflowPhoneService {

    @Resource
    private ProjectInterflowPhoneMapper projectInterflowPhoneMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectInterflowContactsService contactsService;
    @Autowired
    private ProjectAppendixService projectAppendixService;

    /**
     * 获取列表
     */
    public List<ProjectInterflowListShowVo> showPhoneList(QueryInterflowParamVo model){
        List<ProjectInterflowListShowVo> listShowVos = projectInterflowPhoneMapper.selectShowListByProjectId(model);
        listShowVos.forEach(vo->{
            vo.setTypeString(InterflowTypeEnum.getMap().get(vo.getType()));
            vo.setWayString(PhoneTypeEnum.getMap().get(vo.getWay()));
        });
        return listShowVos;
    }
    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo insert(InterflowCommonVo<ProjectInterflowPhoneModel> model) {
        if (model==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectInterflowPhoneModel phoneModel = model.getModel();
        phoneModel.setCreateId(currentUsr.getUserId());
        phoneModel.setCreateBy(currentUsr.getRealName());
        phoneModel.setCreateTime(new Date());
        phoneModel.setType(InterflowTypeEnum.PHONE.getCode());
        phoneModel.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        int insert = this.projectInterflowPhoneMapper.insert(phoneModel);
        if (insert == 1){
            Long phoneModelId = phoneModel.getId();
            //添加外部联系人
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                contact.setBusinessId(phoneModelId);
                contact.setCreateId(currentUsr.getUserId());
                contact.setCreateBy(currentUsr.getRealName());
                contact.setCreateTime(new Date());
                contact.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
            });
            try {
                boolean b = contactsService.insertList(contactModels);
            } catch (Exception e) {
                throw new SystemParamCheckException("数据更新报错，请重试");
            }
            //关联附件
            List<Long> appendixIds = model.getAppendixIds();
            appendixIds.forEach(appendixId->{
                try {
                    boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId, phoneModelId));
                } catch (Exception e) {
                    throw new SystemParamCheckException("数据更新报错，请重试");
                }
            });
            return model;
        }
        throw new SystemParamCheckException("新增报错，请重试");
    }
    /**
     * 获取详情
     */
    public InterflowCommonVo<ProjectInterflowPhoneModelVo> getPhoneModelVo(ProjectInterflowPhoneModel model){
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectInterflowPhoneModelVo phoneModelVo = projectInterflowPhoneMapper.selectModelVoById(model.getId());
        phoneModelVo.setTypeString(InterflowTypeEnum.getMap().get(phoneModelVo.getType()));
        phoneModelVo.setWayString(PhoneTypeEnum.getMap().get(phoneModelVo.getWay()));
        phoneModelVo.setContactTypeString(ContactTypeEnum.getMap().get(phoneModelVo.getContactType()));
        List<ProjectInterflowContactsModel> contactsModels = new ArrayList<>();
        if (Objects.equals(phoneModelVo.getContactType(),ContactTypeEnum.INTERNAL_CONTACT.getCode())){
            if (phoneModelVo.getContactId()!=null){
                SysUserModel userModel = sysUserService.selectById(phoneModelVo.getContactId());
                phoneModelVo.setContactName(userModel.getRealName());
            }

        }else if (Objects.equals(phoneModelVo.getContactType(),ContactTypeEnum.EXTERNAL_CONTACT.getCode())){
            contactsModels= contactsService.selectByModel(new ProjectInterflowContactsModel(phoneModelVo.getId()));
        }
        return new InterflowCommonVo<>(phoneModelVo,contactsModels,new ArrayList<>());
    }

    /**
     * 保存编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo<ProjectInterflowPhoneModel> update(InterflowCommonVo<ProjectInterflowPhoneModel> model){
        if (model==null){
            throw new SystemParamCheckException("参数传入错误，无法新增");
        }
        try {
            SysUserModel currentUsr = sysUserService.getCurrentUsr();
            ProjectInterflowPhoneModel phoneModel = model.getModel();
            phoneModel.setUpdateId(currentUsr.getUserId());
            phoneModel.setUpdateBy(currentUsr.getRealName());
            phoneModel.setUpdateTime(new Date());
            int i = this.projectInterflowPhoneMapper.updateByIdSelective(phoneModel);
            //外部联系人
            List<Long> contactList = contactsService.selectByBusinessId(phoneModel.getId());
            if (model.getContactModels()!=null || !model.getContactModels().isEmpty()){
                List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
                contactModels.forEach(contact->{
                    if (contact.getId()!=null && contactList.contains(contact.getId())){
                        contactList.remove(contact.getId());
                    }
                    contact.setBusinessId(phoneModel.getId());
                    boolean b = contactsService.insertOrUpdate(contact);
                });
            }
            boolean b1 = contactsService.deleteByIds(contactList);
            //附件
            List<Long> appendixIdList = projectAppendixService.selectIdByBusinessId(phoneModel.getId());
            List<Long> appendixIds = model.getAppendixIds();
            appendixIds.forEach(appendixId->{
                if (appendixIdList.contains(appendixId)){
                    appendixIdList.remove(appendixId);
                }
                boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId,
                            phoneModel.getId()));
            });
            boolean b = projectAppendixService.deleteByIds(appendixIdList);
        } catch (Exception e) {
            throw new SystemParamCheckException("数据更新报错，请重试");
        }
        return model;
    }
    /**
     * 插入多条数据
     */
    public boolean insertList(List<ProjectInterflowPhoneModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowPhoneModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowPhoneMapper.insertList(list);
            }
        } else {
            return this.projectInterflowPhoneMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowPhoneModel model) {
        return model != null && this.projectInterflowPhoneMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowPhoneModel selectById(Long id) {
        return id == null ? null : this.projectInterflowPhoneMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowPhoneModel> selectByModel(ProjectInterflowPhoneModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowPhoneMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowPhoneModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowPhoneMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowPhoneModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowPhoneMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowPhoneModel model) {
        if (model == null || model.getId() == null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateId(user.getUserId());
        model.setUpdateBy(user.getRealName());
        model.setUpdateTime(new Date());
        model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        int update = this.projectInterflowPhoneMapper.updateByIdSelective(model);
        if (update==1){
            return true;
        }
        throw new SystemParamCheckException("数据更新失败请重试");
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectInterflowPhoneModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectInterflowPhoneMapper.insert(model) == 1;
        }
        return this.projectInterflowPhoneMapper.updateById(model) == 1;
    }
}