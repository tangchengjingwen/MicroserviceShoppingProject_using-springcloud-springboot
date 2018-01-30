package com.chengjingwen.entity;

import com.chengjingwen.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity extends BaseEntity {

	private String userName;
	private String password;
	private String phone;
	private String email;
	private String openId;
	

}
