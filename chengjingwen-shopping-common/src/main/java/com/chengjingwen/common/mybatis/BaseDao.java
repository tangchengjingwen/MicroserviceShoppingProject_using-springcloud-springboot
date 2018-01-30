package com.chengjingwen.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface BaseDao {

	//注解作用：自定义sql语句
	@InsertProvider(method = "save", type = BaseProvider.class)
	public void save(@Param("oj")Object oj, @Param("table")String table);
	
	
}
