package com.chengjingwen.api.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.api.service.UserService;
import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.entity.UserEntity;
import com.chengjingwen.manage.UserServiceManage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {
	@Autowired
	private UserServiceManage userServiceManage;

	@Override
	public Map<String, Object> regist(@RequestBody UserEntity userEntity) {

		if (StringUtils.isEmpty(userEntity.getUserName())) {
			return setResultParameterError("用户名称不能为空");
		}
		if (StringUtils.isEmpty(userEntity.getPassword())) {
			return setResultParameterError("用户密码不能为空");
		}
		try {
			userServiceManage.regist(userEntity);
			return setResultSuccess();
		} catch (Exception e) {
			// TODO: handle exception
			log.info("###rehist() ERROR:" + e);
			return setResultError("注册失败!");
		}

	}

	@Override
	public Map<String, Object> login(@RequestBody UserEntity userEntity) {
		return userServiceManage.login(userEntity);
	}

	@Override
	public Map<String, Object> getUser(@RequestParam("token")String token) {
		if (StringUtils.isEmpty(token)) {
			return setResultError("token不能为空！！");
		}
		return userServiceManage.getUser(token);
	}

	@Override
	public Map<String, Object> userLoginOpenID(@RequestParam("openid")String openid) {

		return userServiceManage.userLoginOpenID(openid);
	}

}
