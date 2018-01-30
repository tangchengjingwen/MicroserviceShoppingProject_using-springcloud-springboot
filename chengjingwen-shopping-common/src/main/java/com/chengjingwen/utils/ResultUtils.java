package com.chengjingwen.utils;

import java.util.Map;

import com.chengjingwen.constants.BaseApiConstants;

public class ResultUtils {

	public static Object getResultMap(Map<String, Object> reusltItemDesc) {
		Integer code = (Integer) reusltItemDesc.get(BaseApiConstants.HTTP_CODE_NAME);
		if (code.equals(BaseApiConstants.HTTP_200_CODE)) {
			Object object = reusltItemDesc.get("data");
			return object;
		}
		return null;
	}

}
