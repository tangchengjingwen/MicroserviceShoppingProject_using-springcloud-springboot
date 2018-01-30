package com.chengjingwen.mq.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 往消息服务推送邮件信息
 * @author tangc
 *
 */

@Service
public class RegisterMailboxProducer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	public void send(Destination destination, String json) {
		jmsMessagingTemplate.convertAndSend(destination, json);
	}
}
