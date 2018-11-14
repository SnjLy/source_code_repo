package com.PattenState;

/**
 * Created by admin on 2016/10/12.
 */
public class RedColor implements Color {
	Light light;

	public RedColor(Light light) {
		this.light = light;
	}

	@Override
	public void show() {
		System.out.println("the color is red,the car must stop !");
		System.out.println("write down all logic shoud do this in this state.....");
		light.setColor(new GreenColor(light));
	}
}
