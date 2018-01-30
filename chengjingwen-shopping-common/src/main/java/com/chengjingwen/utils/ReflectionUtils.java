package com.chengjingwen.utils;

import java.lang.reflect.Field;
import java.sql.Timestamp;

import org.apache.ibatis.jdbc.SQL;

import com.chengjingwen.common.entity.TestEntity;

/**
 * 反射工具类
 * 
 * @author tangc
 *
 */
public class ReflectionUtils {

	/**
	 * 封装当前类和父类所有属性，拼接属性sql
	 * 
	 * @return
	 */
	public static String FatherAndSonField(Object oj) {
		if (oj == null) {
			return null;
		}
		// 获取class文件
		Class<? extends Object> classInfo = oj.getClass();
		// 获取当前类的属性sql
		Field[] sonFields = classInfo.getDeclaredFields();
		String sonFieldStr = getField(sonFields);

		Field[] parentFields = classInfo.getSuperclass().getDeclaredFields();

		String parentFieldStr = getField(parentFields);

		return sonFieldStr + "," + parentFieldStr;
	}

	/**
	 * 获取属性值
	 * 
	 * @param oj
	 * @return
	 */
	public static String FatherAndSonValue(Object oj) {
		if (oj == null) {
			return null;
		}
		// 获取class文件
		Class<? extends Object> classInfo = oj.getClass();
		// 获取当前类的属性sql
		Field[] sonFields = classInfo.getDeclaredFields();
		String sonFieldStr = getFieldValue(oj, sonFields);

		Field[] parentFields = classInfo.getSuperclass().getDeclaredFields();

		String parentFieldStr = getFieldValue(oj, parentFields);

		return sonFieldStr + "," + parentFieldStr;
	}

	/**
	 * 封装获取属性
	 * 
	 * @param declaredFields
	 * @return
	 */
	public static String getField(Field[] declaredFields) {
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < declaredFields.length; i++) {
			sf.append(declaredFields[i].getName());
			if (i < declaredFields.length - 1) {
				sf.append(",");
			}
		}
		return sf.toString();
	}

	/**
	 * 封装获取属性值
	 * 
	 * @param oj
	 * @param declaredFields
	 * @return
	 */
	public static String getFieldValue(Object oj, Field[] declaredFields) {
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < declaredFields.length; i++) {
			try {
				Field field = declaredFields[i];
				// 允许操作私有属性
				field.setAccessible(true);
				Object value = field.get(oj);
				// 标识是否为string类型
				boolean flag = false;
				if (value != null && (value instanceof String || value instanceof Timestamp)) {
					flag = true;
				}
				if (flag) {
					sf.append("'");
					sf.append(value);
					sf.append("'");
				} else {
					sf.append(value);
				}
				// 获取属性值
				// sf.append(declaredFields[i].get(oj));
				if (i < declaredFields.length - 1) {
					sf.append(",");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return sf.toString();
	}

	public static void main(String[] args) {
		TestEntity testEntity = new TestEntity();
		testEntity.setUserName("tangchengjingwen");
		testEntity.setPhone("18627957159");
		testEntity.setEmail("tangchengjingwen@gmail.com");
		testEntity.setPassword("123456");
		testEntity.setCreated(DateUtils.getTimestamp());
		testEntity.setUpdated(DateUtils.getTimestamp());
		String field = FatherAndSonField(testEntity);
		String value = FatherAndSonValue(testEntity);
		System.out.println(field);
		System.out.println(value);

		SQL sql = new SQL() {
			{
				INSERT_INTO("mb_user");
				VALUES(field, value);
			}
		};

		System.out.println(sql.toString());
	}
}
