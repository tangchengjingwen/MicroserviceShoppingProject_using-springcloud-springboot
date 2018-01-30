package com.chengjingwen.api.service;

import java.util.Map;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * 功能说明:商品服务
 * 
 * @author 余胜军
 *
 */
@RequestMapping("/item")
public interface ItemService {
	/**
	 * 首页展示商品
	 * 
	 * @return
	 */
	@RequestMapping("/getIndexItem")
	public Map<String, Object> getIndexItem();

	/**
	 * 查询商品
	 * 
	 * @return
	 */
	@RequestMapping("/geItem")
	public Map<String, Object> geItem(@RequestParam("id") Long id);
}
