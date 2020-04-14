package com.fea.project.controller.websocket;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fea.project.model.websocket.MessageInfoVo;
import com.fea.project.service.websocket.WebSocketServer;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

	//页面请求
	@GetMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String userId) {
		ModelAndView mav=new ModelAndView("/socket");
		mav.addObject("userId", userId);
		return mav;
	}
	//推送数据接口
	@ResponseBody
	@PostMapping("/socket/push")
	public void pushToWeb(@RequestBody MessageInfoVo model) {  
		System.out.println(model);
		try {
//			WebSocketServer.sendInfo("[{\"info\":\"全部\",\"type\":1,\"count\":null},{\"info\":\"@我\",\"type\":2,\"count\":9},{\"info\":\"我的收藏\",\"type\":3,\"count\":null},{\"info\":\"赞我的\",\"type\":4,\"count\":2},{\"info\":\"我评论的\",\"type\":5,\"count\":3}]", model.getUserId());
			WebSocketServer.sendInfo(model.getMessage(), model.getUserId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
} 
