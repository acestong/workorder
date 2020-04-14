package com.fea.project.service.interflow;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.dao.interflow.ProjectInterflowEmailsMapper;
import com.fea.project.enums.base.DeleteStatusEnum;
import com.fea.project.enums.interflow.ContactTypeEnum;
import com.fea.project.enums.interflow.EmailTypeEnum;
import com.fea.project.enums.interflow.InterflowTypeEnum;
import com.fea.project.enums.interflow.PhoneTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.appendix.ProjectAppendixModel;
import com.fea.project.model.interflow.ProjectInterflowContactsModel;
import com.fea.project.model.interflow.vo.*;
import com.fea.project.service.appendix.ProjectAppendixService;
import com.fea.project.util.ListUtil;
import com.fea.project.model.interflow.ProjectInterflowEmailsModel;
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
public class ProjectInterflowEmailsService {

    @Resource
    private ProjectInterflowEmailsMapper projectInterflowEmailsMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ProjectInterflowContactsService contactsService;
    @Autowired
    private ProjectAppendixService projectAppendixService;

    /**
     * 获取列表
     */
    public List<ProjectInterflowListShowVo> showEmailsList(QueryInterflowParamVo model){
        List<ProjectInterflowListShowVo> listShowVos = projectInterflowEmailsMapper.selectShouwListByProjectId(model);
        listShowVos.forEach(vo->{
            vo.setTypeString(InterflowTypeEnum.getMap().get(vo.getType()));
            vo.setWayString(EmailTypeEnum.getMap().get(vo.getWay()));
        });
        return listShowVos;
    }
    /**
     * 插入数据
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo insert(InterflowCommonVo<ProjectInterflowEmailsModel> model) {
        if (model==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel currentUsr = sysUserService.getCurrentUsr();
        ProjectInterflowEmailsModel emailsModel = model.getModel();
        emailsModel.setCreateId(currentUsr.getUserId());
        emailsModel.setCreateBy(currentUsr.getRealName());
        emailsModel.setCreateTime(new Date());
        emailsModel.setType(InterflowTypeEnum.EMAILS.getCode());
        emailsModel.setDelStates(DeleteStatusEnum.NOT_DELETE.getStatus());
        int insert = this.projectInterflowEmailsMapper.insert(emailsModel);
        if (insert == 1){
            Long emailsModelId = emailsModel.getId();
            //添加外部联系人
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                contact.setBusinessId(emailsModelId);
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
                    boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId, emailsModelId));
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
    public InterflowCommonVo<ProjectInterflowEmailsModelVo> getPhoneModelVo(ProjectInterflowEmailsModel model){
        if (model==null || model.getId()==null){
            throw new SystemParamCheckException("参数传入错误");
        }
        ProjectInterflowEmailsModelVo emailsModelVo = projectInterflowEmailsMapper.selectModelVoById(model.getId());
        emailsModelVo.setTypeString(InterflowTypeEnum.getMap().get(emailsModelVo.getType()));
        emailsModelVo.setWayString(PhoneTypeEnum.getMap().get(emailsModelVo.getWay()));
        emailsModelVo.setContactTypeString(ContactTypeEnum.getMap().get(emailsModelVo.getContactType()));
        List<ProjectInterflowContactsModel> contactsModels = new ArrayList<>();
        if (Objects.equals(emailsModelVo.getContactType(),ContactTypeEnum.INTERNAL_CONTACT.getCode())){
            if (emailsModelVo.getContactId()!=null){
                SysUserModel userModel = sysUserService.selectById(emailsModelVo.getContactId());
                emailsModelVo.setContactName(userModel.getRealName());
            }

        }else if (Objects.equals(emailsModelVo.getContactType(),ContactTypeEnum.EXTERNAL_CONTACT.getCode())){
            contactsModels= contactsService.selectByModel(new ProjectInterflowContactsModel(emailsModelVo.getId()));
        }
        return new InterflowCommonVo<>(emailsModelVo,contactsModels,new ArrayList<>());
    }

    /**
     * 保存编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public InterflowCommonVo<ProjectInterflowEmailsModel> update(InterflowCommonVo<ProjectInterflowEmailsModel> model){
        if (model==null){
            throw new SystemParamCheckException("参数传入错误，无法新增");
        }
        try {
            SysUserModel currentUsr = sysUserService.getCurrentUsr();
            ProjectInterflowEmailsModel emailModel = model.getModel();
            emailModel.setUpdateId(currentUsr.getUserId());
            emailModel.setUpdateBy(currentUsr.getRealName());
            emailModel.setUpdateTime(new Date());
            int i = this.projectInterflowEmailsMapper.updateByIdSelective(emailModel);
            //外部联系人
            List<Long> contactIdList = contactsService.selectByBusinessId(emailModel.getId());
            List<ProjectInterflowContactsModel> contactModels = model.getContactModels();
            contactModels.forEach(contact->{
                if (contact.getId()!=null && contactIdList.contains(contact.getId())){
                    contactIdList.remove(contact.getId());
                }
                contact.setBusinessId(emailModel.getId());
                boolean b = contactsService.insertOrUpdate(contact);
            });
            boolean b = contactsService.deleteByIds(contactIdList);
            //附件
            List<Long> list = projectAppendixService.selectIdByBusinessId(emailModel.getId());
            List<Long> appendixIds = model.getAppendixIds();
            appendixIds.forEach(appendixId->{
                if (list.contains(appendixId)){
                    list.remove(appendixId);
                }
                boolean c = projectAppendixService.updateByIdSelective(new ProjectAppendixModel(appendixId,
                        emailModel.getId()));
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
    public boolean insertList(List<ProjectInterflowEmailsModel> models) {
        if (models == null) {
            return false;
        }
        if (models.isEmpty()) {
            return true;
        }
        if (models.size() > 100) {
            for (List<ProjectInterflowEmailsModel> list : ListUtil.getSubList(models, 100)) {
                this.projectInterflowEmailsMapper.insertList(list);
            }
        } else {
            return this.projectInterflowEmailsMapper.insertList(models) > 0;
        }
        return true;
    }

    /**
     * 插入数据,字段为空时不插入
     */
    public boolean insertSelective(ProjectInterflowEmailsModel model) {
        return model != null && this.projectInterflowEmailsMapper.insertSelective(model) == 1;
    }

    /**
     * 按主键选择
     */
    public ProjectInterflowEmailsModel selectById(Long id) {
        return id == null ? null : this.projectInterflowEmailsMapper.selectById(id);
    }

    /**
     * 按模型选择
     */
    public List<ProjectInterflowEmailsModel> selectByModel(ProjectInterflowEmailsModel model) {
        return model == null ? new ArrayList<>(0) : this.projectInterflowEmailsMapper.selectByModel(model);
    }

    /**
     * 按主键更新,字段为空时不更新
     */
    public boolean updateByIdSelective(ProjectInterflowEmailsModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowEmailsMapper.updateByIdSelective(model) == 1;
    }

    /**
     * 按主键更新
     */
    public boolean updateById(ProjectInterflowEmailsModel model) {
        return !(model == null || model.getId() == null) && this.projectInterflowEmailsMapper.updateById(model) == 1;
    }

    /**
     * 按主键删除
     */
    public boolean deleteById(ProjectInterflowEmailsModel model) {
        if (model == null || model.getId() == null) {
            throw new SystemParamCheckException("参数传入错误");
        }
        SysUserModel user = sysUserService.getCurrentUsr();
        model.setUpdateId(user.getUserId());
        model.setUpdateBy(user.getRealName());
        model.setUpdateTime(new Date());
        model.setDelStates(DeleteStatusEnum.DELETE.getStatus());
        int update = this.projectInterflowEmailsMapper.updateByIdSelective(model);
        if (update == 1) {
            return true;
        }
        throw new SystemParamCheckException("数据更新失败请重试");
    }

    /**
     * 插入或更新
     */
    public boolean insertOrUpdate(ProjectInterflowEmailsModel model) {
        if (model == null) {
            return false;
        }
        if (model.getId() == null) {
            return this.projectInterflowEmailsMapper.insert(model) == 1;
        }
        return this.projectInterflowEmailsMapper.updateById(model) == 1;
    }
}