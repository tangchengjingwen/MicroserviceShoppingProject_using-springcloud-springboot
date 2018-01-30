package com.chengjingwen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chengjingwen.api.service.ItemService;
import com.chengjingwen.common.api.BaseApiService;
import com.chengjingwen.dao.ItemCatDao;
import com.chengjingwen.dao.ItemDao;
import com.chengjingwen.entity.ItemCatEntity;
import com.chengjingwen.entity.ItemEntity;

@RestController
public class ItemServiceImpl extends BaseApiService implements ItemService {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private ItemCatDao itemCatDao;

	@RequestMapping("/getIndexItem")
	public Map<String, Object> getIndexItem() {
		// 查询所有的类型
		List<ItemCatEntity> listItemCat = itemCatDao.allItemCat();
		Map<String, Object> reuslt = new HashMap<String, Object>();
		for (ItemCatEntity itemCatEntity : listItemCat) {
			Long id = itemCatEntity.getId();
			String name = itemCatEntity.getName();
			List<ItemEntity> listItem = itemDao.getIndexItem(id);
			if (!(listItem.isEmpty() && listItem.size() <= 0)) {
				reuslt.put(name, listItem);
			}

		}
		return setResultSuccessData(reuslt);
	}

	@Override
	public Map<String, Object> geItem(@RequestParam("id") Long id) {
		ItemEntity item = itemDao.getItem(id);
		if(item==null){
			return setResultError("没有查询到结果");
		}
		return setResultSuccessData(item);
	}

}
