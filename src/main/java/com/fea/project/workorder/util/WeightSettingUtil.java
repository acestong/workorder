package com.fea.project.workorder.util;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.workorder.dao.CommentWeightModelMapper;
import com.fea.project.workorder.enums.InsertOrUpdateEnum;
import com.fea.project.workorder.model.CommentWeightModel;

/**
 * 权重设置util类,通过当前orgId 进行默认设置
 * @author st
 * @since 2020/03/23
 */
@Component
public class WeightSettingUtil {

	@Resource
	private CommentWeightModelMapper mapper;
	@Resource
	private SysUserService sysUserService;
	
	
	private static WeightSettingUtil weightSettingUtil;
	// 初始化的时候，将本类中@resource注入的值变为静态
    @PostConstruct
    public void init() {
    	weightSettingUtil = this;
    	weightSettingUtil.mapper = this.mapper;
    	weightSettingUtil.sysUserService = this.sysUserService;
    }
	
	public static void setDefaultSettting() {
		SysUserModel currentUsr = WeightSettingUtil.weightSettingUtil.sysUserService.getCurrentUsr();
		CommentWeightModelMapper mapper = WeightSettingUtil.weightSettingUtil.mapper;
		if(mapper.selectByOrgId(currentUsr.getOrgId()) == null) {
			mapper.insertSelective(new CommentWeightModel(currentUsr,InsertOrUpdateEnum.INSERT));
		}
	}
	
}
