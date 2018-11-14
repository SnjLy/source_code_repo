package com.PattenFactory.StaticFactory;

/**
 *
 * 羊
 * Created by yehao on 2016/10/11.
 */
public class Sheep extends Animal {
	public Sheep() {
		super();
	}

	public Sheep(  String name) {
		super(name);
	}

	@Override
	public String eat() {
		System.out.println("小羊吃饭咩咩咩~~~");
		return null;
	}
}
