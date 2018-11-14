package com.PattenFactory.StaticFactory;

/**
 *
 * 猫
 * Created by yehao on 2016/10/11.
 */
public class Cat extends Animal {
	public Cat() {
		super();
	}

	public Cat( String name) {
		super(name);
	}

	@Override
	public String eat() {
		System.out.println("小猫吃饭喵喵喵~~~");
		return null;
	}
}
