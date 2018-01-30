package com.chengjingwen.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chengjingwen.base.controller.BaseController;
import com.chengjingwen.constants.BaseApiConstants;
import com.chengjingwen.entity.UserEntity;
import com.chengjingwen.feign.UserFeign;

@Controller
public class RegistContoroller extends BaseController {

	private static final String REGIST = "regist";
	private static final String LOGIN = "login";
	@Autowired
	private UserFeign userFeign;

	
	@RequestMapping("/locaRegist")
	public String locaRegist() {
		return REGIST;
	}

	
	@RequestMapping("/regist")
	public String regist(UserEntity userEntity, HttpServletRequest req) {
		try {
			Map<String, Object> registMap = userFeign.regist(userEntity);
			Integer code = (Integer) registMap.get(BaseApiConstants.HTTP_CODE_NAME);
			if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
				String msg = (String) registMap.get("msg");
				return setError(req, REGIST, msg);
			}
			//注册成功
			return LOGIN;
		} catch (Exception e) {
		
			return setError(req, REGIST, "注册失败");
		}
	}


}
