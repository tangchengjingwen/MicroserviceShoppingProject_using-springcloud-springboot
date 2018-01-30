package com.chengjingwen.common.mybatis;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.chengjingwen.utils.ReflectionUtils;

public class BaseProvider {

	/**
	 * 自定义封装sql语句
	 * 
	 * @return
	 */
	public String save(Map<String, Object> map) {
		// 实体类
		Object oj = map.get("oj");
		// 表名称
		String table = (String) map.get("table");
		// 生成添加的sql语句,使用反射机制
		// 1.使用反射机制加载类的所有属性

		SQL sql = new SQL() {
			{
				INSERT_INTO(table);
				VALUES(ReflectionUtils.FatherAndSonField(oj), ReflectionUtils.FatherAndSonValue(oj));
			}
		};

		return sql.toString();
	}

}
