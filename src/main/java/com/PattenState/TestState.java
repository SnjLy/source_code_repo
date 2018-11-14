package com.PattenState;

/**
 * (1)
	 State模式定义：
	 不同的状态,不同的行为; 或者说,每个状态有着相应的行为.
	 适用场合：
	 State模式在实际使用中比较多,适合"状态的切换".因为我们经常会使用If elseif else 进行状态切换, 如果针对状态的这样判断切换反复出现,我们就要联想到是否可以采取State模式了.
	 -->适合于内部状态,不断循环变化的.
	 (2)
	 一个state,包括两部分: 对象 + 对象内部的属性(属性接口+具体属性)
	 一个对象,要有其属性,以及其setter,getter.且设置好其初始状态+一个调用显示状态的方法(里面就是状态调用自身的显示方法).
	 一个属性接口,应该有一个执行的方法.
	 一个具体属性,须包含对象进去,实现方法中,须设置对象下一个要显示的属性-->从而在对象下次调用方法时,其属性值会变化.
	 * Created by yehao on 2016/10/12.
 */
public class TestState {

	public static void main(String[] args) {
		Light light=new Light();
		//初始调用为红灯
		light.showColor();
		//再调用为绿灯
		light.showColor();
		//再调用为黄灯
		light.showColor();
		//不断调用,不断循环.


		/*过程*/
		Light lg = new Light();
		lg.setColor(new GreenColor(lg));
		lg.showColor();
		lg.setColor(new YellowColor(lg));
		lg.showColor();
		lg.setColor(new RedColor(lg));
		lg.showColor();
	}
}
