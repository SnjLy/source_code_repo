package com.PattenFactory.AbstractFactory;

import com.PattenFactory.StaticFactory.Animal;
import com.PattenFactory.StaticFactory.Cattle;

/**
 * Created by admin on 2016/10/11.
 */
public class CattleMilkMother implements MilkAnimalMother {
	/**
	 * 产奶
	 *
	 * @return
	 */
	@Override
	public String productMilk() {
		System.out.println("奶牛生产了牛奶");
		return null;
	}

	/**
	 * 母动物产生新动物
	 *
	 * @return
	 */
	@Override
	public Animal birthAnimal() {
		Cattle cattle=new Cattle();
		System.out.println("奶牛生了一只小牛");
		return cattle;
	}
}
