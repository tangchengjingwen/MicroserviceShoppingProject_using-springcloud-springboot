package com.chengjingwen.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chengjingwen.entity.ItemCatEntity;

@Mapper
public interface ItemCatDao {
	@Select("select id as id , parent_id as parentId ,name as name, img as img,status as status , is_parent as  isParent, created as created ,updated as updated from tb_item_cat")
	public List<ItemCatEntity> allItemCat();
}
