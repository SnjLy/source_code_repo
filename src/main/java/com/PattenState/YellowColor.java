package com.PattenState;

/**
 * Created by yehao on 2016/10/12.
 */
public class YellowColor implements Color {
	Light light;

	public YellowColor(Light light) {
		this.light = light;
	}

	@Override
	public void show() {
		System.out.println("the color is yellow,the car shoud stop !");
		System.out.println("write down all logic shoud do this in this state.....");
		light.setColor(new RedColor(light));
	}
}
