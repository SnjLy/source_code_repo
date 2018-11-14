package com.PattenAdapter;

/**
 * 目标类：--也可直接实现，不用接口
 * Created by yehao on 2016/10/12.
 */
public class Adapter implements Target {
	private Adaptee adaptee;

	public Adapter() {
		this.adaptee = new Adaptee();
		this.adaptee.getPower(1,2);
	}

	@Override
	public long getTime(long exp) {
		return this.adaptee.getPower(2,exp);
	}
}
