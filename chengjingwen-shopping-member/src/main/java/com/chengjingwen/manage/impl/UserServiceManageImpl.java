package com.chengjingwen.manage.impl;

import java.util.Map;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.common.redis.BaseRedisService;
import com.chengjingwen.common.token.TokenUtils;
import com.chengjingwen.constants.Constants;
import com.chengjingwen.constants.DBTableConstants;
import com.chengjingwen.constants.MQInterfaceType;
import com.chengjingwen.dao.UserDao;
import com.chengjingwen.entity.UserEntity;
import com.chengjingwen.manage.UserServiceManage;
import com.chengjingwen.mq.producer.RegisterMailboxProducer;
import com.chengjingwen.utils.DateUtils;
import com.chengjingwen.utils.MD5Util;
import com.ctc.wstx.api.EmptyElementHandler.SetEmptyElementHandler;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceManageImpl extends BaseApiService implements UserServiceManage {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RegisterMailboxProducer registerMailboxProducer;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private BaseRedisService baseRedisService;

	@Value("${messages.queue}")
	private String MESSAGES_QUEUE;

	@Override
	public void regist(UserEntity userEntity) {

		userEntity.setCreated(DateUtils.getTimestamp());
		userEntity.setUpdated(DateUtils.getTimestamp());
		String phone = userEntity.getPhone();
		String password = userEntity.getPassword();
		userEntity.setPassword(md5PassSalt(phone, password));
		userDao.save(userEntity, DBTableConstants.TABLE_MB_USER);
		// 队列
		Destination destination = new ActiveMQQueue(MESSAGES_QUEUE);
		// 组装报文格式
		String mailMessage = mailMessage(userEntity.getEmail(), userEntity.getUserName());
		log.info("###regist() 注册发送邮件报文mailMessage{}:" + mailMessage);
		registerMailboxProducer.send(destination, mailMessage);
	}

	@Override
	public String md5PassSalt(String phone, String password) {

		String newPassword = MD5Util.MD5(phone + password);

		return newPassword;
	}

	/**
	 * 封装报文格式传到MQ中
	 * 
	 * @param email
	 * @param userName
	 * @return
	 */
	private String mailMessage(String email, String userName) {
		JSONObject root = new JSONObject();
		JSONObject header = new JSONObject();
		header.put("interfaceType", MQInterfaceType.SMS_MAIL);
		JSONObject content = new JSONObject();

		content.put("mail", email);
		content.put("userName", userName);
		root.put("header", header);
		root.put("content", content);
		return root.toString();
	}

	@Override
	public Map<String, Object> login(UserEntity userEntity) {
		

		// 往数据库查找数据
		String phone = userEntity.getPhone();
		String password = userEntity.getPassword();
		String newPassword = md5PassSalt(phone, password);
		UserEntity userPhoneAndPwd = userDao.getUserPhoneAndPwd(phone, newPassword);
		if (userPhoneAndPwd == null) {
			return setResultError("账号或密码错误！");
		}
		String openId = userEntity.getOpenId();
		Long userId = userPhoneAndPwd.getId();
		if (!StringUtils.isEmpty(openId)) {
			//修改到数据库中
			userDao.updateUserOpenId(openId, DateUtils.getTimestamp(), userId);
		}
		
		// 生成对应token
		String token = setUserToken(userId);
		// 返回token
		return setResultSuccessData(token);
	}

	@Override
	public Map<String, Object> getUser(String token) {
		// 从redis中查找到userid
		String userId = baseRedisService.get(token);
		if (StringUtils.isEmpty(userId)) {
			return setResultError("用户已经过期");
		}
		long newUserId = Long.parseLong(userId);
		UserEntity userInfo = userDao.getUserInfo(newUserId);
		userInfo.setPassword(null);
		return setResultSuccessData(userInfo);
	}

	@Override
	public Map<String, Object> userLoginOpenID(String openid) {

		UserEntity userEntity = userDao.findUserOpenId(openid);
		if (userEntity == null) {
			return setResultError("没有关联用户!!");
		}
		// 关联了，需要自动登录
		// 生成对应token
		String token = setUserToken(userEntity.getId());
		return setResultSuccessData(token);
	}

	private String setUserToken(Long id) {
		// 生成对应token
		String token = tokenUtils.getToken();
		// 将用户的userid作为value存放在Redis中，token作为key
		baseRedisService.set(token, id + "", Constants.USER_TOKEN_TERMVALIDITY);
		return token;
	}
}
