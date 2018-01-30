package com.chengjingwen.constants;

/**
 * 时间常量
 * 
 * @author tangc
 *
 */
public interface Constants {
	// 保证90天不失效
	long USER_TOKEN_TERMVALIDITY = 60 * 60 * 24 * 90l;

	int WEBUSER_COOKIE_TOKEN_TERMVALIDITY = 1000 * 60 * 60 * 24 * 90;

	String USER_TOKEN = "token";

	String USER_SESSION_OPENID = "openid";

	String USER_SOURCE_QQ = "qq";

	String PAY_SUCCES = "ok";
	String PAY_FAIL = "fail";
}
