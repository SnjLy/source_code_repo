package com.FactoryModel.entity;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认实体
 * Created by yehao on 2016/10/11.
 */
public class DefaultEntity implements ObjectEntity {

	@Override
	public String getObject() {
		Map<String , Object> map = new HashMap<>();
		map.put("id",0);
		map.put("desc","defult");
		map.put("name","defult");
		return JSON.toJSONString(map);
	}
}
