package com.PattenFactory.FactoryMethod;

import com.PattenFactory.StaticFactory.Animal;

/**
 * 母动物类
 * Created by yehao on 2016/10/11.
 */
public interface AnimalMother {
	/**
	 * 母动物产生新动物
	 * @return
	 */
	public Animal birthAnimal();
}
