package com.PattenFactory.FactoryMethod;

import com.PattenFactory.StaticFactory.Animal;
import com.PattenFactory.StaticFactory.Cat;
import com.alibaba.fastjson.JSON;

/**
 * CatMother birth a new cat
 * Created by yehao on 2016/10/11.
 */
public class CatMother implements AnimalMother{
	@Override
	public Animal birthAnimal() {
		Animal cat = new Cat("新小猫");
		System.out.println("CatMother 产生一只小猫"+ JSON.toJSONString(cat));
		cat.eat();
		return cat;
	}
}
