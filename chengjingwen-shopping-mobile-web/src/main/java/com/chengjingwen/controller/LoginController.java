package com.chengjingwen.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chengjingwen.base.controller.BaseController;
import com.chengjingwen.constants.BaseApiConstants;
import com.chengjingwen.constants.Constants;
import com.chengjingwen.entity.UserEntity;
import com.chengjingwen.feign.UserFeign;
import com.chengjingwen.web.CookieUtil;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

@Controller
public class LoginController extends BaseController {

	private static final String LOGIN = "login";
	private static final String INDEX = "index";
	private static final String ERROR = "error";
	private static final String ASSOCIATEDACCOUNT = "associatedAccount";

	@Autowired
	private UserFeign userFeign;

	@RequestMapping("/locaLogin")
	public String locaLogin(String source, HttpServletRequest req) {
		req.setAttribute("source", source);
		return LOGIN;
	}

	@RequestMapping("/login")
	public String login(UserEntity userEntity, HttpServletRequest req, HttpServletResponse resp, String source, HttpSession session) {
		
		if (!StringUtils.isEmpty(source) && source.equals(Constants.USER_SOURCE_QQ)) { 
			String openid = (String) session.getAttribute(Constants.USER_SESSION_OPENID);
			userEntity.setOpenId(openid);
		}
		
		Map<String, Object> login = userFeign.login(userEntity);

		Integer code = (Integer) login.get(BaseApiConstants.HTTP_CODE_NAME);
		if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
			String msg = (String) login.get("msg");
			return setError(req, LOGIN, msg);
		}
		// 登录成功之后，获取token，将token存放到cookie中
		String token = (String) login.get("data");
		CookieUtil.addCookie(resp, Constants.USER_TOKEN, token, Constants.WEBUSER_COOKIE_TOKEN_TERMVALIDITY);

		return INDEX;
	}

	/**
	 * 跳转到QQ授权地址
	 * 
	 * @param req
	 * @return
	 * @throws QQConnectException
	 */
	@RequestMapping("/locaQQLogin")
	public String locaQQLogin(HttpServletRequest req) throws QQConnectException {
		String authorizeURL = new Oauth().getAuthorizeURL(req);
		return "redirect:" + authorizeURL;
	}

	@RequestMapping("/qqLoginCallback")
	public String qqLoginCallback(HttpServletRequest req, HttpServletResponse resq, HttpSession session) throws QQConnectException {
		// String code = req.getParameter("code");
		// 步骤
		// 1.获取授权码
		// 2.获取access_token
		AccessToken accessTokenObj = new Oauth().getAccessTokenByRequest(req);
		String accessToken = accessTokenObj.getAccessToken();
		if (StringUtils.isEmpty(accessToken)) {
			return setError(req, ERROR, "QQ授权失败!");
		}
		// 3.获取openid
		OpenID openIDObj = new OpenID(accessToken);
		String userOpenID = openIDObj.getUserOpenID();
		if (StringUtils.isEmpty(userOpenID)) {
			return setError(req, ERROR, "QQ授权失败!");
		}
		// 4.数据库查找openid是否关联，如果没有关联先跳转到关联账号页面，如果关联则直接登录
		Map<String, Object> userLoginOpenID = userFeign.userLoginOpenID(userOpenID);
		Integer code = (Integer) userLoginOpenID.get(BaseApiConstants.HTTP_CODE_NAME);
		if (code.equals(BaseApiConstants.HTTP_200_CODE)) {
			String token = (String) userLoginOpenID.get("data");
			CookieUtil.addCookie(resq, Constants.USER_TOKEN, token, Constants.WEBUSER_COOKIE_TOKEN_TERMVALIDITY);
			return "redirect:/" + INDEX;
		}
		
		//没有关联账户，跳转到关联页面
		session.setAttribute(Constants.USER_SESSION_OPENID, userOpenID);
		return ASSOCIATEDACCOUNT;

	}

}
