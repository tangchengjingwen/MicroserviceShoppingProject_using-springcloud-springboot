package com.chengjingwen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chengjingwen.adapter.MessageAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SMSMailboxService implements MessageAdapter{

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void distribute(JSONObject jsonObject) {

		//解析json
		String mail = jsonObject.getString("mail");
		String userName = jsonObject.getString("userName");
		log.info("###消费者收到消息。。。mail:{},userName:{} ", mail, userName);
		//发送邮件
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail);
		message.setTo(mail); // 自己给自己发送邮件
		message.setSubject("唐成靖文的商城...");
		message.setText("恭喜您  " + userName + " 今天成为了微信商城的用户,谢谢您的关注!");
		log.info("###发送短信邮箱 mail:{}", mail);
		mailSender.send(message);

	}

}
