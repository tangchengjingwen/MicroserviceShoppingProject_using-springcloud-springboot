package com.chengjingwen.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 所有消息都会交给它进行转发
 * @author tangc
 *
 */
public interface MessageAdapter {
	//接收消息 
	public void distribute(JSONObject jsonObject);
}
