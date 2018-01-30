package com.chengjingwen.pay.service;

import com.chengjingwen.entity.PaymentInfo;
import com.chengjingwen.entity.PaymentType;


/**
 * 支付类型适配器
 * @author tangc
 *
 */
public interface PayAdaptService {
	public String pay(PaymentInfo paymentInfo,PaymentType paymentType );
}
