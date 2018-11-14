package com.springmvc.json_util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class OperateJson {

	public static void main(String[] args) {
		String jsonstr="{'teacher':[{'age':56,'name':'lisi'}],'id':1000,'name':'zhangsan','age':20}";
//		Student s=(Student) getDTO(jsonstr, Student.class);
		Map clazzMap = new HashMap();
		clazzMap.put("teacher", Teacher.class);
		Student s=(Student) getDTO(jsonstr, Student.class, clazzMap);
		System.out.println(s.toString()); 

	}
	
	 public static  Object getDTO(String jsonString, Class clazz){  
		  JSONObject jsonObject = null;  
		  try{  
		   jsonObject = JSONObject.fromObject(jsonString); 
		  }catch(Exception e){  
		   e.printStackTrace();  
		  }  
		  return JSONObject.toBean(jsonObject, clazz);  
		 }  
	 
	 public static Object getDTO(String jsonString, Class clazz, Map map){  
		  JSONObject jsonObject = null;  
		  try{  
		   jsonObject = JSONObject.fromObject(jsonString);  
		  }catch(Exception e){  
		   e.printStackTrace();  
		  }  
		  return JSONObject.toBean(jsonObject, clazz, map);  
		 }
	 
	 
}
