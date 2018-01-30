package com.chengjingwen.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.chengjingwen.common.mybatis.BaseDao;
import com.chengjingwen.entity.ItemEntity;

@Mapper
public interface ItemDao extends BaseDao {

	@Select("select a.id as id ,a.title as title ,a.sell_point as sellPoint, a.price as price,a.num as num,a.barcode as barcode,a.image as image ,a.parent_id as parentId,a.cid as cid,a.status as status,a.created as created,a.updated as updated from tb_item as a inner join  tb_item_cat as b on a.parent_id=b.id where b.id =#{id} LIMIT 0,8")
	public List<ItemEntity> getIndexItem(@Param("id") Long id);

	@Select("select a.id as id ,a.title as title ,a.sell_point as sellPoint, a.price as price,a.num as num,a.barcode as barcode,a.image as image ,a.parent_id as parentId,a.cid as cid,a.status as status,a.created as created,a.updated as updated from tb_item as a where a.id =#{id}")
	public ItemEntity getItem(@Param("id") Long id);
}
