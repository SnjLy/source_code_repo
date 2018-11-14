package com.yehao_test.comparator;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yehao on 2016/8/29.
 */
public class TestComparator {


	public static void main(String[] args) {
		System.out.println();
		List<BigDecimal> list = new ArrayList<>();
		list.add(new BigDecimal(25.3));
		list.add(new BigDecimal(-23.3));
		list.add(new BigDecimal(85.3));
		list.add(new BigDecimal(15));
		list.add(new BigDecimal(20));
		list.add(new BigDecimal(-62));
		Collections.sort(list,new MyComparator());
		System.out.println(list);
		List<String> list1 = new ArrayList<>();
		list1.add("25.3");
		list1.add("56.3");
		list1.add(new String("35.2"));
		list1.add(new String("-78"));
		list1.add(new String("aad"));
		list1.add(new String("82"));
		Collections.sort(list1,new MyComparator());
		System.out.println(list1);

	}



}

class MyComparator implements Comparator<Object>{
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof  BigDecimal){
			BigDecimal t1 = (BigDecimal) o1;
			BigDecimal t2 = (BigDecimal) o2;
			int result = t1.compareTo(t2);
			System.out.println(o1+"与"+o2+"的比较结果："+result);
			return result;
		}
		if (o1 instanceof  String){
			String t1 = (String) o1;
			String t2 = (String) o2;
			int result = t1.compareTo(t2);
			System.out.println(t1+"与"+t2+"的比较结果："+result);
			return result;
		}
		return 0;
	}
}
