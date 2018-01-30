package com.chengjingwen.base.controller;

import javax.servlet.http.HttpServletRequest;

import com.chengjingwen.common.api.BaseApiService;

public class BaseController extends BaseApiService{

	public static final String ERROR = "common/error";
	
	public String setError(HttpServletRequest req, String msg, String address) {
		req.setAttribute("error", msg);
		return address;
	}
	
}
