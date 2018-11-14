package com.PattenFactory.StaticFactory;

/**
 *
 * 奶牛
 * Created by yehao on 2016/10/11.
 */
public class Cattle extends Animal {
	public Cattle() {
		super();
	}

	public Cattle(String name) {
		super(name);
	}

	@Override
	public String eat() {
		System.out.println("奶牛吃草萌萌萌~~~");
		return null;
	}
}
