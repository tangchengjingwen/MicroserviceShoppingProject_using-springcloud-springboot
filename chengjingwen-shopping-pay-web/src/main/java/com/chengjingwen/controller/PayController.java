package com.chengjingwen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

	import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.base.controller.BaseController;
import com.chengjingwen.entity.PaymentInfo;
import com.chengjingwen.feign.PaymentInfoFeign;
import com.chengjingwen.pay.service.PayService;
import com.chengjingwen.utils.ResultUtils;

@Controller
@RequestMapping("/pay")
public class PayController extends BaseController {
	@Autowired
	private PaymentInfoFeign paymentInfoFeign;

	@Autowired
	private PayService payService;

	@RequestMapping("/payGateway")
	public void payGateway(String token, HttpServletResponse resp) throws IOException {
		// 防止乱码
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		try {
			// 使用token查找支付信息
			Map<String, Object> payInfoToken = paymentInfoFeign.getPayInfoToken(token);
			Map<String, Object> resultMap = (Map<String, Object>) ResultUtils.getResultMap(payInfoToken);
			// 通过对应信息查找对应支付方式
			String jsonString = new JSONObject().toJSONString(resultMap);
			// 判断支付方式，调用对应具体的sdk
			PaymentInfo paymentInfo = new JSONObject().parseObject(jsonString, PaymentInfo.class);
			if (paymentInfo == null) {
				out.write("没有找到该接口");
				return;
			}

			String html = payService.pay(paymentInfo);
			out.println(html);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			out.println("系统错误!!");
		} finally {
			out.close();
		}
	}

}
