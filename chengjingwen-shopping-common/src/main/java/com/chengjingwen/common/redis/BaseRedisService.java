package com.chengjingwen.common.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 封装redis
 * 
 * @author tangc
 *
 */
@Component
public class BaseRedisService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 向redis中添加信息
	 * 
	 * @param key
	 * @param value
	 */
	public void setString(String key, Object value) {
		set(key, value, null);
	}

	/**
	 * 向redis中添加信息
	 * 
	 * @param key
	 * @param value
	 * @param timeOut
	 */
	public void setString(String key, Object value, Long timeOut) {
		set(key, value, timeOut);
	}

	/**
	 * 添加信息的基本实现
	 * 
	 * @param key
	 * @param value
	 * @param timeOut
	 */
	public void set(String key, Object value, Long timeOut) {

		if (value != null) {
			if (value instanceof String) {
				String setValue = (String) value;
				stringRedisTemplate.opsForValue().set(key, setValue);
			}
		}
		// 设置有效期
		if (timeOut != null)
			stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
	}

	/**
	 * 使用key 查找redis信息
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 使用key删除redis信息
	 * 
	 * @param key
	 */
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}
}
