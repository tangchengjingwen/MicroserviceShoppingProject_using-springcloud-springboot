package com.chengjingwen.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chengjingwen.common.mybatis.BaseDao;
import com.chengjingwen.entity.UserEntity;

@Mapper
public interface UserDao extends BaseDao {

	@Select("select ID,USERNAME,PASSWORD,phone,EMAIL, created,updated from mb_user  WHERE PHONE=#{phone} and password=#{password};")
	public UserEntity getUserPhoneAndPwd(@Param("phone") String phone, @Param("password") String password);

	@Select("select ID,USERNAME,PASSWORD,phone,EMAIL, created,updated from mb_user  WHERE id=#{id};")
	public UserEntity getUserInfo(@Param("id") Long id);

	@Select("select ID,USERNAME,PASSWORD,phone,EMAIL, created,updated from mb_user  WHERE openid=#{openid};")
	public UserEntity findUserOpenId(@Param("openid") String openid);

	@Update("update mb_user set openid=#{openid},updated=#{updated} where id=#{id}")
	public void updateUserOpenId(@Param("openid") String openid, @Param("updated") Timestamp updated,
			@Param("id") Long id);
}
