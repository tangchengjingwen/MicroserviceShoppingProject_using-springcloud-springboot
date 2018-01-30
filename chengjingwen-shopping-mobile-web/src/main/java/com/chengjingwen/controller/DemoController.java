package com.chengjingwen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chengjingwen.base.controller.BaseController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DemoController extends BaseController{

	public static final String INDEX = "index";

	@RequestMapping("/index")
	public String index(HttpServletRequest req) {
		log.info("我的web工程搭建成功了！");
		return INDEX;
	}
	


}
