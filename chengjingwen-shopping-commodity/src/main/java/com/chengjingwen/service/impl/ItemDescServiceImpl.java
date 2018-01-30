package com.chengjingwen.service.impl;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.api.service.ItemDescService;
import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.dao.ItemDescDao;
import com.chengjingwen.entity.ItemDescEntity;

@RestController
public class ItemDescServiceImpl extends BaseApiService implements ItemDescService {
	@Autowired
	private ItemDescDao itemDescDao;

	@RequestMapping("/getItemDesc")
	public Map<String, Object> getItemDesc(@RequestParam("id") Long id) {
		ItemDescEntity itemDesc = itemDescDao.getItemDesc(id);
		return setResultSuccessData(itemDesc);
	}

}
