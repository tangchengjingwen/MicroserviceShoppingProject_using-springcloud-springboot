package com.chengjingwen.mq.distribute;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.adapter.MessageAdapter;
import com.chengjingwen.constants.MQInterfaceType;
import com.chengjingwen.service.SMSMailboxService;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费消息 从队列中获取最新消息  
 * @author tangc
 *
 */
@Slf4j
@Component
public class ConsumerDistribute {
	
	@Autowired
	private SMSMailboxService sMSMailboxService;

	@JmsListener(destination = "mail_queue")
	public void distribute(String json) {
		log.info("###消息服务###收到消息，消息内容json{}：" + json);
		if(StringUtils.isEmpty(json)) {
			return;
		}
		JSONObject jsonObject = new JSONObject().parseObject(json);
		JSONObject header = jsonObject.getJSONObject("header");
		String interfaceType = header.getString("interfaceType");
		MessageAdapter messageAdapter = null;
		switch (interfaceType) {
		//发送邮件
		case MQInterfaceType.SMS_MAIL:
			messageAdapter = sMSMailboxService;
			break;

		default:
			break;
		}
		
		JSONObject content = jsonObject.getJSONObject("content");
		messageAdapter.distribute(content); 
	}
}
