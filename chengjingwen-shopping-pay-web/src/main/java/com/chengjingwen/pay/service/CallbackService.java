package com.chengjingwen.pay.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 支付回调服务接口
 * @author tangc
 *
 */
public interface CallbackService {
	/**
	 * 同步回调
	 * 
	 * @return
	 */
	public Map<String, String> syn(HttpServletRequest request);

	/**
	 * 异步回调
	 * 
	 * @return
	 */
	public String asyn(HttpServletRequest request);
}
