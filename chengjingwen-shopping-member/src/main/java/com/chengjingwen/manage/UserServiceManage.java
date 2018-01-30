package com.chengjingwen.manage;

import java.util.Map;



import com.chengjingwen.entity.UserEntity;


public interface UserServiceManage {
	/**
	 * 注册服务
	 * @param userEntity
	 */
	public void regist(UserEntity userEntity);
	
	/**
	 * 加盐加密
	 * @param phone
	 * @param password
	 * @return
	 */
	public String md5PassSalt(String phone, String password);
	
	/**
	 * 登录
	 * @param userEntity
	 */
	public Map<String, Object> login(UserEntity userEntity);
	
	/**
	 * 通过token查找用户信息
	 * @param token
	 * @return
	 */
	public Map<String, Object> getUser(String token);

	public Map<String, Object> userLoginOpenID(String openid);
}
