package com.chengjingwen.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.chengjingwen.api.service.UserService;

/**
 * 调用eureka中的member服务
 * @author tangc
 *
 */

@FeignClient("member")
public interface UserFeign extends UserService {
//
//	/**
//	 * 使用token查找用户信息
//	 * @param token
//	 * @return
//	 */
//	@PostMapping("/member/getUser")
//	public Map<String, Object> getUser(@RequestParam("token") String token);
	
}
