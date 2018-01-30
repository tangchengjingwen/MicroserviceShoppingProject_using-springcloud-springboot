package com.chengjingwen.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chengjingwen.entity.PaymentInfo;

/**
 * 提供支付信息服务接口
 * @author tangc
 *
 */
@RequestMapping("/pay")
public interface PaymentInfoService {

	/**
	 * 支付信息换取支付令牌
	 * @param paymentInfo
	 * @return
	 */
	@RequestMapping("/addPayInfoToken")
	public Map<String, Object> addPayInfoToken(@RequestBody PaymentInfo paymentInfo);
	/**
	 * 使用token查找支付信息(orderID)
	 * @param token
	 * @return
	 */
	@RequestMapping("/getPayInfoToken")
	public Map<String, Object> getPayInfoToken(@RequestParam("token") String token);
	/**
	 * 使用订单号查找用户支付信息
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/getByOrderIdPayInfo")
	public Map<String, Object> getByOrderIdPayInfo(@RequestParam("orderId")String orderId);
	/**
	 * 更新用户支付信息
	 * @param paymentInfo
	 * @return
	 */
	@RequestMapping("/updatePayInfo")
	public Map<String, Object> updatePayInfo(@RequestBody PaymentInfo paymentInfo);
	
	
	
}
