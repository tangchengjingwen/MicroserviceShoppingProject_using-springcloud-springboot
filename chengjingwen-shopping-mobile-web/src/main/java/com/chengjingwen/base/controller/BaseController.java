package com.chengjingwen.base.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.constants.BaseApiConstants;
import com.chengjingwen.entity.UserEntity;
import com.chengjingwen.feign.UserFeign;

/**
 * 前台服务基本类
 * 
 * @author tangc
 *
 */
@Controller
public class BaseController {
	@Autowired
	private UserFeign userFeign;

	public UserEntity getUserEntity(String token) {
		Map<String, Object> userMap = userFeign.getUser(token);
		Integer code = (Integer) userMap.get(BaseApiConstants.HTTP_CODE_NAME);
		if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
			return null;
		}
		//获取data参数
		LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>) userMap.get(BaseApiConstants.HTTP_Data_NAME);
		String json = new JSONObject().toJSONString(linkedHashMap);
		UserEntity userEntity = new JSONObject().parseObject(json, UserEntity.class);
		return userEntity;
	}
	
	public String setError(HttpServletRequest req, String address, String msg) {
		req.setAttribute("error", msg);
		return address;
	}

}
