package com.fea.project.controller.publish;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fea.project.api.other.model.base.SysUserModel;
import com.fea.project.api.other.service.base.SysUserService;
import com.fea.project.configure.exception.SystemParamCheckException;
import com.fea.project.enums.publish.IsTransmitedPublishEnum;
import com.fea.project.enums.publish.PublishNavigateTypeEnum;
import com.fea.project.model.BasePageInfo;
import com.fea.project.model.publish.vo.PublishGetViewVo;
import com.fea.project.model.publish.vo.PublishModelVo;
import com.fea.project.model.publish.vo.PublishNavigateViewVo;
import com.fea.project.model.publish.vo.PublishViewVo;
import com.fea.project.model.publish.vo.WebSocketMessageVo;
import com.fea.project.service.publish.IPublishService;
import com.fea.project.service.websocket.WebSocketServer;
import com.fea.project.util.JSONChange;

@RestController
@RequestMapping("/publish")
public class PublishController {

	@Resource
	private IPublishService service;
	@Resource
	private SysUserService sysUserService;
	//注入WebSocketServer,实现实时获取数据
	@Resource
	private WebSocketServer webSocketServer;

	private static List<PublishNavigateViewVo> countList;
	
	
	@PostMapping("/insert")
	public void save(@RequestBody PublishModelVo publishModelVo) {
		publishModelVo.setIsTransmitedPublish(IsTransmitedPublishEnum.IS_NOT_TRANSMIT_PUBLISH.getStatus().longValue());
		service.save(publishModelVo);
		webSocket();
	}
	
	@PostMapping("/transmit")
	public void transmit(@RequestBody PublishModelVo publishModelVo) {
		if(publishModelVo.getTransmitedPublishId() == null) {
			throw new SystemParamCheckException("转发的原动态Id为空");
		}
		publishModelVo.setIsTransmitedPublish(IsTransmitedPublishEnum.IS_TRANSMIT_PUBLISH.getStatus().longValue());
		service.save(publishModelVo);
		webSocket();
	}
	@PostMapping("/delete")
	public void delete(@RequestBody PublishModelVo publishModelVo) throws JsonProcessingException {
		service.delete(publishModelVo);
		webSocket();
	}
	
	
	@PostMapping
	public BasePageInfo<PublishViewVo> getAll(@RequestBody BasePageInfo<PublishGetViewVo> page) {
		return service.getAll(page);
	}
	
	
	@GetMapping("/getAllCount")
	public Object getAllCount(Long businessId,Long businessType) throws JsonProcessingException {
		return countList == null ? JSONChange.objToJson(service.getAllCount(businessId,businessType)) : JSONChange.objToJson(countList);
	}
	
	@GetMapping("/getAllCountTemp")
	public Object getAllCountTemp(Long businessId,Long businessType) {
		return countList == null ? service.getAllCount(businessId,businessType) :countList;
	}
	
	@GetMapping("/getUserInfo")
	public Object getUserInfo() {
		return service.getUserInfo();
	}
	@GetMapping("/selectScopeUserListByprojectId")
	public Object selectScopeUserListByprojectId(Long projectId) {
		return service.selectScopeUserListByprojectId(projectId);
	}
	
	/*
	 * 动态计数以及列表实时获取
	 */
	private Map<String, Object> webSocket() {
		Map<String, Object> map = new HashMap<>();
		String message = webSocketServer.getMessage();
		WebSocketMessageVo messageVo = new WebSocketMessageVo();
		SysUserModel currentUsr = sysUserService.getCurrentUsr();
		try {
			messageVo = (WebSocketMessageVo) JSONChange.jsonToObj(new WebSocketMessageVo(), message);
			if (message != null) {
				BasePageInfo<PublishGetViewVo> basePageInfo = new BasePageInfo<PublishGetViewVo>();
				basePageInfo.setPageNum(messageVo.getPageNum());
				basePageInfo.setPageSize(messageVo.getPageSize());
				basePageInfo.setModel(new PublishGetViewVo(null, null, messageVo.getType()));
				map.put("allPublish", getAll(basePageInfo));
			} else {
				try {
					BasePageInfo<PublishGetViewVo> basePageInfo = new BasePageInfo<PublishGetViewVo>();
					basePageInfo.setPageNum(1);
					basePageInfo.setPageSize(10);
					basePageInfo.setModel(new PublishGetViewVo(null, null,PublishNavigateTypeEnum.ALL_PUBLISH.getStatus().intValue()));
					map.put("allPublish", getAll(basePageInfo));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("allCount", getAllCountTemp(messageVo.getBusinessId(), messageVo.getBusinessType()));
		try {
			WebSocketServer.sendInfo(JSONChange.objToJson(map), currentUsr.getUserId().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
//	private Map<String,Object> webSocket(PublishModelVo publishModelVo){
//		SysUserModel currentUsr = sysUserService.getCurrentUsr();
//		Map<String,Object> map = new HashMap<>();
//		map.put("allCount", getAllCountTemp(publishModelVo.getBusinessId(),publishModelVo.getBusinessType()));
//		String message = webSocketServer.getMessage();
//		if(message != null) {
//			try {
//				WebSocketMessageVo messageVo = (WebSocketMessageVo) JSONChange.jsonToObj(new WebSocketMessageVo(), message);
//				BasePageInfo<PublishGetViewVo> basePageInfo = new BasePageInfo<PublishGetViewVo>();
//				basePageInfo.setPageNum(messageVo.getPageNum());
//				basePageInfo.setPageSize(messageVo.getPageSize());
//				basePageInfo.setModel(new PublishGetViewVo(null, null, messageVo.getType()));
//				map.put("allPublish", getAll(basePageInfo));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else {
//			try {
//				BasePageInfo<PublishGetViewVo> basePageInfo = new BasePageInfo<PublishGetViewVo>();
//				basePageInfo.setPageNum(1);
//				basePageInfo.setPageSize(10);
//				basePageInfo.setModel(new PublishGetViewVo(null, null, PublishNavigateTypeEnum.ALL_PUBLISH.getStatus().intValue()));
//				map.put("allPublish", getAll(basePageInfo));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		try {
//			WebSocketServer.sendInfo(JSONChange.objToJson(map), currentUsr.getUserId().toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return map;
//	}
}
