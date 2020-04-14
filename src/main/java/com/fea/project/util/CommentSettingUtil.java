package com.fea.project.util;

import java.util.ArrayList;
import java.util.List;

import com.fea.project.enums.task.ActionNameEnum;
import com.fea.project.enums.task.EstimanteNameEnum;
import com.fea.project.model.task.CommentSettingModel;
import com.fea.project.model.task.DeliverableSettingModel;
import com.fea.project.model.task.PercentSettingModel;
import com.fea.project.model.task.vo.PercentSettingModelVo;

/**
 * 如果未对评论做相关设置，那么获取评论参数时返回默认的参数模型
 * @author st
 *
 */
public class CommentSettingUtil {

	/**
	 * 获取评论默认设置
	 * @return CommentSettingModel
	 */
	public static CommentSettingModel getDefaultCommentSetting() {
		return new CommentSettingModel(0.5, 0.5);
	}
	
	/**
	 * 获取交付物默认设置
	 * @return DeliverableSettingModel
	 */
	public static DeliverableSettingModel getDefaultDeliverableSetting() {
		return new DeliverableSettingModel(0.5,0.5);
	}
	
	public static List<PercentSettingModelVo> getDefaultPercentSetting() {
		List<PercentSettingModelVo> list = new ArrayList<PercentSettingModelVo>();
		Double value = 80.0;
		for (EstimanteNameEnum en : EstimanteNameEnum.values()) {
			PercentSettingModelVo modelVo = new PercentSettingModelVo(ActionNameEnum.GT.getStatus().longValue(),
					ActionNameEnum.GT.getInfo(), en.getStatus().longValue(), en.getInfo(),value);
			list.add(modelVo);
			value-=20;
		}
		return list;
	}
}
