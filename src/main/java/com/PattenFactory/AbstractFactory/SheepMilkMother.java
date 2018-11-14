package com.PattenFactory.AbstractFactory;

import com.PattenFactory.StaticFactory.Animal;
import com.PattenFactory.StaticFactory.Sheep;

/**
 * Created by admin on 2016/10/11.
 */
public class SheepMilkMother implements MilkAnimalMother {
	/**
	 * 产奶
	 *
	 * @return
	 */
	@Override
	public String productMilk() {
		System.out.println("奶羊生产了羊奶");
		return null;
	}

	/**
	 * 母动物产生新动物
	 *
	 * @return
	 */
	@Override
	public Animal birthAnimal() {
		Animal sheep=new Sheep();
		System.out.println("奶羊生了一只小羊");
		return sheep;
	}
}
