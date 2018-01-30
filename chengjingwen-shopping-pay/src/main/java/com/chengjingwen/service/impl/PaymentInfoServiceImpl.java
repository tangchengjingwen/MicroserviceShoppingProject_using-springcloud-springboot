package com.chengjingwen.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.common.redis.BaseRedisService;
import com.chengjingwen.common.token.TokenUtils;
import com.chengjingwen.dao.PaymentInfoDao;
import com.chengjingwen.entity.PaymentInfo;
import com.chengjingwen.service.PaymentInfoService;
import com.chengjingwen.utils.DateUtils;

@RestController
@RequestMapping("/pay")
public class PaymentInfoServiceImpl extends BaseApiService implements PaymentInfoService {

	@Autowired
	private PaymentInfoDao paymentInfoDao;
	@Autowired
	private TokenUtils tokenUtils;
	@Autowired
	private BaseRedisService baseRedisService;

	@Override
	@RequestMapping("/addPayInfoToken")
	public Map<String, Object> addPayInfoToken(@RequestBody PaymentInfo paymentInfo) {
		// 1.添加paymentInfo
		paymentInfo.setCreated(DateUtils.getTimestamp());
		paymentInfo.setUpdated(DateUtils.getTimestamp());
		paymentInfoDao.savePaymentType(paymentInfo);
		Long id = paymentInfo.getId();
		if (id == null) {
			return setResultError("系统错误，未获取到支付ID...");
		}
		// 2.生成对应token
		String payToken = tokenUtils.getPayToken();
		// 3. 将token作为key，id作为value存放到redis中
		baseRedisService.setString(payToken, id + "");
		// 4.返回token
		return setResultSuccessData(payToken);
	}

	@Override
	@RequestMapping("/getPayInfoToken")
	public Map<String, Object> getPayInfoToken(@RequestParam("token") String token) {
		// 1.判断token是否为空
		if (StringUtils.isEmpty(token)) {
			return setResultError("token不能为空!!!");
		}
		// 2.使用token去Redis查找对应支付信息ID
		String payInfoId = baseRedisService.get(token);
		long newPayInfoId = Long.parseLong(payInfoId);
		// 3.使用支付信息ID去数据库中查找支付信息
		PaymentInfo paymentInfo = paymentInfoDao.getPaymentInfo(newPayInfoId);
		return setResultSuccessData(paymentInfo);
	}

	@Override
	@RequestMapping("/getByOrderIdPayInfo")
	public Map<String, Object> getByOrderIdPayInfo(String orderId) {
		// 获取支付信息
		PaymentInfo paymentInfo = paymentInfoDao.getByOrderIdPayInfo(orderId);
		if (paymentInfo == null) {
			return setResultError("未查询到支付信息!!!");
		}
		return setResultSuccessData(paymentInfo);
	}

	@Override
	@RequestMapping("/updatePayInfo")
	public Map<String, Object> updatePayInfo(PaymentInfo paymentInfo) {
		// 更新支付信息
		paymentInfoDao.updatePayInfo(paymentInfo);
		return setResultSuccess();
	}

}
