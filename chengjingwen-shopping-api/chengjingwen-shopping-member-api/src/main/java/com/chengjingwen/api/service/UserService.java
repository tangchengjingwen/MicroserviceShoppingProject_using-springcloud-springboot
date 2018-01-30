package com.chengjingwen.api.service;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chengjingwen.entity.UserEntity;

/**
 * 用户服务
 * @author tangc
 *
 */

@RequestMapping("/member")
public interface UserService {
	/**
	 * 注册服务
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/regist")
	public Map<String, Object> regist(@RequestBody UserEntity userEntity);
	
	/**
	 * 登录
	 * 登陆成功后，生成对应的token作为key，userid作为value存放在redis中，返回token给客户端 
	 * @return
	 */
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody UserEntity userEntity);
	/**
	 * 使用token查找用户信息
	 * @param token
	 * @return
	 */
	@PostMapping("/getUser")
	public Map<String, Object> getUser(@RequestParam("token") String token);


	/**
	 * 使用openid关联用户信息
	 * @param openid
	 * @return
	 */
	@PostMapping("/userLoginOpenID")
	public Map<String, Object> userLoginOpenID(@RequestParam("openid") String openid);


}
