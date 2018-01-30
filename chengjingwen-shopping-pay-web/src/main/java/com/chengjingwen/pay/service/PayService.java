package com.chengjingwen.pay.service;

import org.springframework.stereotype.Service;

import com.chengjingwen.entity.PaymentInfo;


@Service
public interface PayService {
	
	public String pay(PaymentInfo paymentInfo);
	
}
