package com.chengjingwen.controller.callback;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chengjingwen.pay.service.CallbackService;
import com.unionpay.acp.sdk.AcpService;
import com.unionpay.acp.sdk.LogUtil;
import com.unionpay.acp.sdk.SDKConstants;

@RequestMapping("/pay/callback")
@Controller
public class YinLianCallbackController {
	@Autowired
	private CallbackService callbackService;
	private static final String PAY_SUCCESS = "pay_success";
	private static final String PAY_FAIL = "pay_fail";

	/**
	 * 功能说明:同步回调
	 * 
	 * @return
	 */
	@RequestMapping("/syn")
	public String syn(HttpServletRequest request) {
		Map<String, String> synResultMap = callbackService.syn(request);

		String encoding = request.getParameter(SDKConstants.param_encoding);
		if (!AcpService.validate(synResultMap, encoding)) {
			LogUtil.writeLog("验证签名结果[失败].");
			return PAY_FAIL;
		}
		request.setAttribute("txnAmt", Double.parseDouble(synResultMap.get("txnAmt")) / 100);
		request.setAttribute("orderId", Long.parseLong(synResultMap.get("orderId")));
		LogUtil.writeLog("验证签名结果[成功].");
		return PAY_SUCCESS;

	}

	/**
	 * 功能说明:异步回调
	 * 
	 * @return
	 */
	@RequestMapping("/asyn")
	public String asyn(HttpServletRequest request) {
		return callbackService.asyn(request);
	}

}