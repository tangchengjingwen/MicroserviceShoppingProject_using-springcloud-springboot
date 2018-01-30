package com.chengjingwen.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 提供支付类型接口
 * @author tangc
 *
 */
@RequestMapping("/pay")
public interface PaymentTypeService {
	/**
	 * 根据id获得支付类型
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPaymentType")
	public Map<String, Object> getPaymentType(@RequestParam("id") Long id);
	
	
}
