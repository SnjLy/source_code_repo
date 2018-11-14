package com.PattenFactory.StaticFactory;

/**
 *
 * dog
 * Created by yehao on 2016/10/11.
 */
public class Dog extends Animal {
	public Dog() {
		super();
	}

	public Dog(String name) {
		super(name);
	}

	@Override
	public String eat() {
		System.out.println("小狗吃饭汪汪汪~~~");
		return null;
	}
}
