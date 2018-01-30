package com.chengjingwen.dao;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.chengjingwen.entity.PaymentType;

@Mapper
public interface PaymentTypeDao {

	@Select("select * from payment_type where id = #{id}")
	public PaymentType getPaymentType(@Param("id") Long id);

}
