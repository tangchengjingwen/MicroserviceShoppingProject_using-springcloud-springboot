package com.chengjingwen.common.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 封装一些相同字段和属性
 * 
 * @author tangc
 *
 */
@Getter
@Setter
public class BaseEntity {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private Timestamp created;
	/**
	 * 修改时间
	 */
	private Timestamp updated;
}
