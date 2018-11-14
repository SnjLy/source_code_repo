package com.PattenState;

/**
 * Created by yehao on 2016/10/12.
 */
public class Light {
	Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Light() {
		color = new RedColor(this);
	}

	public void showColor(){
		color.show();
	}
}
