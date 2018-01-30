package com.chengjingwen.api.service;

import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * demo
 * 
 * @author tangc
 *
 */
@RequestMapping("/demo")
public interface DemoApiService {

	/**
	 * 服务demo
	 * 
	 * @return
	 */
	@GetMapping("/demo")
	public Map<String, Object> demo();

	@GetMapping("/setKey")
	public Map<String, Object> setKey(String key, String value);
	
	@GetMapping("/getKey")
	public Map<String, Object> getKey(String key);
}
