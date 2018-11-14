package com.PattenFactory.FactoryMethod;

import com.PattenFactory.StaticFactory.Animal;
import com.PattenFactory.StaticFactory.Dog;
import com.alibaba.fastjson.JSON;

/**
 * 母狗生狗
 * Created by yehao on 2016/10/11.
 */
public class DogMother implements AnimalMother{
	@Override
	public Animal birthAnimal() {
		Animal dog = new Dog("新小狗");
		System.out.println("DogMother 产生一只小狗"+ JSON.toJSONString(dog));
		dog.eat();
		return dog;
	}
}
