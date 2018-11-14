package com.PattenState;

/**
 * Created by yehao on 2016/10/12.
 */
public class GreenColor implements Color {
	Light light;

	public GreenColor(Light light) {
		this.light = light;
	}

	@Override
	public void show() {
		System.out.println("the color is green,the car can run !");
		System.out.println("write down all logic shoud do this in this state.....");
		light.setColor(new YellowColor(light));
	}
}
