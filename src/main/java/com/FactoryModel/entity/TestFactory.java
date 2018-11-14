package com.FactoryModel.entity;

import com.FactoryModel.EntityFactory;
import com.FactoryModel.EntityFactoryImpl;

/**
 * 测试工厂模式生产
 * Created by yehao on 2016/10/11.
 */
public class TestFactory {

	public static void main(String[] args) {
		EntityFactory factory = new EntityFactoryImpl();
		System.out.println("type=1\t"+factory.createEnntity(1).getObject());
		System.out.println("type=2\t"+factory.createEnntity(2).getObject());
		System.out.println("type=3\t"+factory.createEnntity(3).getObject());
		System.out.println("type=4\t"+factory.createEnntity(4).getObject());

	}
}
