package com.chengjingwen.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.dao.PaymentTypeDao;
import com.chengjingwen.entity.PaymentType;
import com.chengjingwen.service.PaymentTypeService;

@Service
@RestController
@RequestMapping("/pay")
public class PaymentTypeServiceImpl extends BaseApiService implements PaymentTypeService {
	@Autowired
	private PaymentTypeDao paymentTypeDao;

	@RequestMapping("/getPaymentType")
	public Map<String, Object> getPaymentType(@RequestParam("id") Long id) {
		PaymentType paymentType = paymentTypeDao.getPaymentType(id);
		if (paymentType == null) {
			return setResultError("未查找到类型");
		}
		return setResultSuccessData(paymentType);
	}

}
