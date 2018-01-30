package com.chengjingwen.entity;

import java.math.BigInteger;


import com.chengjingwen.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品
 * @author Administrator
 *
 */
@Getter
@Setter
public class ItemEntity extends BaseEntity {

	/**
	 * 标题
	 */
	private String title;
	/**
	 * 商品卖点
	 */
	private String sellPoint;
	/**
	 * 商品价格
	 */
	private BigInteger price;
	/**
	 * 商品数量
	 */
	private Integer num;
	/**
	 * 商品条纹码
	 * 
	 */
	private String barcode;
	/**
	 * 图片地址
	 */
	private String image;
	/**
	 * 父亲ID
	 */
	private Long parentId;
    /**
     * 栏目
     */
	private Long cid;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
	private Byte status;
	/**
	 * 商品名称
	 */
	private String typeName;

}
