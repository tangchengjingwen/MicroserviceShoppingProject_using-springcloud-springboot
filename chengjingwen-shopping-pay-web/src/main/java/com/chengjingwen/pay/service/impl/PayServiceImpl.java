package com.chengjingwen.pay.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.entity.PaymentInfo;
import com.chengjingwen.entity.PaymentType;
import com.chengjingwen.feign.PaymentTypeFeign;
import com.chengjingwen.pay.service.PayAdaptService;
import com.chengjingwen.pay.service.PayService;
import com.chengjingwen.utils.ResultUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private PaymentTypeFeign paymentTypeFeign;
	@Autowired
	private YinLianPay yinLinPay;
	@Override
	public String pay(PaymentInfo paymentInfo) {
		// 获取支付类型id
		Long typeId = paymentInfo.getTypeId();
		//根据支付信息表里的支付类型id去数据库查找支付类型集合
		Map<String, Object> paymentTypeMap = paymentTypeFeign.getPaymentType(typeId);
		if(paymentTypeMap == null) {
			log.error("###pay() typeId:{}, paymentTypeMap is null###");
			return null;
		}
		//获取支付类型
		Map<String, Object> data = (Map<String, Object>) ResultUtils.getResultMap(paymentTypeMap);
		String jsonString = new JSONObject().toJSONString(data);
		PaymentType paymentType = new JSONObject().parseObject(jsonString, PaymentType.class);
		if (paymentType == null) {
			return null;
		}
		String typeName = paymentType.getTypeName();
		PayAdaptService paAdaptService = null;
		//判断支付类型，然后执行相应的支付操作
		switch (typeName) {
		case "yinlianPay":
			paAdaptService = yinLinPay;
			break;

		default:
			break;
		}
		
		return paAdaptService.pay(paymentInfo, paymentType);
	}

}
