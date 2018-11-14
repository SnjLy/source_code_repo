package com.FactoryModel.entity;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Teacher实体
 * Created by yehao on 2016/10/11.
 */
public class TeacherEntity implements ObjectEntity {

	@Override
	public String getObject() {
		Map<String , Object> map = new HashMap<>();
		map.put("id",2);
		map.put("desc","teacher");
		map.put("name","teacher1");
		map.put("major","math");
		map.put("address","beijing");
		return JSON.toJSONString(map);
	}
}
