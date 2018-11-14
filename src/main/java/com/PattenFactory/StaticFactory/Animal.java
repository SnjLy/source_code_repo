package com.PattenFactory.StaticFactory;

/**
 * 动物类
 * Created by yehao on 2016/10/11.
 */
public abstract class Animal {
	private String name;

	public Animal() {
		super();
	}

	public Animal(String name) {
		this.name = name;
	}

	public abstract String eat();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
