package com.FactoryModel.entity;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Car实体
 * Created by yehao on 2016/10/11.
 */
public class CarEntity implements ObjectEntity {

	@Override
	public String getObject() {
		Map<String , Object> map = new HashMap<>();
		map.put("id",3);
		map.put("desc","car");
		map.put("name","car1");
		map.put("key","京A0285");
		return JSON.toJSONString(map);
	}
}
