package com.FactoryModel.entity;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 学生实体
 * Created by yehao on 2016/10/11.
 */
public class StudentEntity implements ObjectEntity {

	@Override
	public String getObject() {
		Map<String , Object> map = new HashMap<>();
		map.put("id",1);
		map.put("desc","student");
		map.put("name","student1");
		map.put("age",18);
		map.put("no","1210315211");
		return JSON.toJSONString(map);
	}
}
