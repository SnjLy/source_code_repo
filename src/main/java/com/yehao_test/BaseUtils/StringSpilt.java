package com.yehao_test.BaseUtils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yehao on 2016/9/18.
 */
public class StringSpilt {


	public static List<String> spiltString(String string){
		List<String> dataist = new ArrayList<>();
		String[] token = string.split("[,，]");
		for (String s : token ){
			System.out.println("分割："+s);
			dataist.add(s);
		}
		return dataist;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("01cd9480910f4d07a92505ceadcf713a");
		list.add("02618fcfdcb14d928de0ac87c9c7e44a");
		list.add("04811d113dc341cda7c53a9b19523470,");
		list.add("05bc4227b7d643b39347129f0ab49ba9，");
		list.add("ca6d0570be3e4ff0ab5451535a615fd4");
		list.add("2a222798af2c44b38603513ffbfaf989");
		String string = JSON.toJSONString(list);
		System.out.println("分割之前："+ string);
		List<String> str = spiltString(string);
		System.out.println("分割之后："+str.toString());


		Map<String,StringBuffer> map = new HashMap<>();
		for(int i = 0;i< list.size();i++){
			String s = i%3+"";
			if (map.get(s)==null){
				StringBuffer stringBuffer =new StringBuffer();
				map.put(s,stringBuffer);
			}
			map.get(s).append(list.get(i)+",");
		}
		for (String s :map.keySet()){

			String scope = map.get(s).toString();
			System.out.println(scope.substring(0,scope.length()-1));
		}


		String replaceString = "05bc4227b7d643b39347129f0ab49ba9," +
				"ca6d0570be3e4ff0ab5451535a615fd4，2a222798af2c44b38603513ffbfaf989 ，01cd9480910f4d07a92505ceadcf713a";
		String ss = replaceString.replace("[\\[,， .\"”“|\\]]"," ").replace("\\s+"," ");
		System.out.println("替换之后"+ss);


		String reg = "[\\[,， .\"”“|\\]]";
		Matcher matcher = Pattern.compile(reg).matcher(replaceString);
		System.out.println();
	}



}
