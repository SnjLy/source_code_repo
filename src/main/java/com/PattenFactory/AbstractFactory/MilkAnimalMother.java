package com.PattenFactory.AbstractFactory;

import com.PattenFactory.FactoryMethod.AnimalMother;

/**
 *
 * 抽象工厂模式：前面工厂方法模式是比较具体的，是猫肯定生的是小猫，这是不会有问题的，是具体的，那么抽象工厂它所产生的就不是那么具体，产生的对象可能是没有共同特性的。
 * 譬如说 一只奶羊不仅仅能够生小羊，同时也能生产羊奶，但小羊是动物，羊奶是食物。
 * 能产奶的 动物母亲
 * 这里继承 AnimalMother 实现 生育小动物  产奶在此接口声明 构成抽象工厂总接口
 * Created by yehao on 2016/10/11.
 */
public interface MilkAnimalMother extends AnimalMother{

	/**
	 * 产奶
	 * @return
	 */
	public String productMilk();
}
