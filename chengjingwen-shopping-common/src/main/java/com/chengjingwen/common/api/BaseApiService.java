package com.chengjingwen.common.api;

import java.util.HashMap;
import java.util.Map;

import com.chengjingwen.constants.BaseApiConstants;

/**
 * 封装通用baseapi 工具类
 * 
 * @author tangc
 *
 */
public class BaseApiService {
	/**
	 * 返回错误
	 * 
	 * @param msg
	 * @return
	 */
	public Map<String, Object> setResultError(String msg) {
		return setResult(BaseApiConstants.HTTP_500_CODE, msg, null);
	}

	/**
	 * 返回成功
	 * 
	 * @return
	 */
	public Map<String, Object> setResultSuccess() {
		return setResult(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, null);
	}
	/**
	 * 参数格式错误
	 * @return
	 */
	public Map<String, Object> setResultParameterError(String msg) {
		return setResult(BaseApiConstants.HTTP_400_CODE, msg, null);
	}

	/**
	 * 返回成功
	 * 
	 * @param msg
	 * @return
	 */
	public Map<String, Object> setResultSuccess(String msg) {
		return setResult(BaseApiConstants.HTTP_200_CODE, msg, null);
	}
	/**
	 * 返回成功
	 * @param data
	 * @return
	 */
	public Map<String, Object> setResultSuccessData(Object data) {
		return setResult(BaseApiConstants.HTTP_200_CODE, BaseApiConstants.HTTP_SUCCESS_NAME, data);
	}

	/**
	 * 自定义返回
	 * 	
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public Map<String, Object> setResult(Integer code, String msg, Object data) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put(BaseApiConstants.HTTP_CODE_NAME, code);
		result.put(BaseApiConstants.HTTP_MSG_NAME, msg);
		if (data != null)
			result.put(BaseApiConstants.HTTP_Data_NAME, data);
		return result;
	}
}
