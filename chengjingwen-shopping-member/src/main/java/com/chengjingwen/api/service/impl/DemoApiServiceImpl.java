package com.chengjingwen.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.api.service.DemoApiService;
import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.common.redis.BaseRedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * demoapi 实现类
 * 
 * @author tangc
 *
 */
@Slf4j
@RestController
public class DemoApiServiceImpl extends BaseApiService implements DemoApiService {

	@Autowired
	private BaseRedisService baseRedisService;
	
	@Override
	public Map<String, Object> demo() {
		log.info("this is demo()....");
		return setResultSuccess();
	}

	@Override
	public Map<String, Object> setKey(String key, String value) {
		baseRedisService.setString(key, value);
		return setResultSuccess();
	}

	@Override
	public Map<String, Object> getKey(String key) {
		String value = baseRedisService.get(key);
		return setResultSuccessData(value);
	}

}
