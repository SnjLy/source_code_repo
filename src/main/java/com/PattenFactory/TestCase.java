package com.PattenFactory;

import com.PattenFactory.AbstractFactory.CattleMilkMother;
import com.PattenFactory.AbstractFactory.MilkAnimalMother;
import com.PattenFactory.AbstractFactory.SheepMilkMother;
import com.PattenFactory.FactoryMethod.AnimalMother;
import com.PattenFactory.FactoryMethod.CatMother;
import com.PattenFactory.FactoryMethod.DogMother;
import com.PattenFactory.StaticFactory.Animal;
import com.PattenFactory.StaticFactory.Cat;
import com.PattenFactory.StaticFactory.Dog;
import com.PattenFactory.StaticFactory.StaticFactory;
import org.junit.Test;

/**
 * 测试类
 *
 * （1）简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
 * （2）工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
 * （3）抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。
 *
 */
public class TestCase {
	/**
	 * 静态工厂类 测试
	 *
	 * Animal : 抽象产品类
	 * Dog,Cat,Sheep,Cattle 具体产品类
	 */
	@Test
	public void staticFactoryTest() {
		Animal ani1=(Animal) StaticFactory.getInstance(Cat.class.getName());
		System.out.println(ani1.getName());
		ani1.eat();
		ani1=(Animal) StaticFactory.getInstance(Dog.class.getName(),"dog");
		System.out.println(ani1.getName());
		ani1.eat();
	}
	/**
	 * 工厂方法模式测试
	 * Animal : 抽象产品类
	 * Dog,Cat,Sheep,Cattle 具体产品类
	 * AnimalMother :抽象工厂角色
	 * CatMother,DogMother :具体工厂角色
	 */
	@Test
	public void methodFactoryTest(){
		AnimalMother mother=new CatMother();
		mother.birthAnimal();
		mother=new DogMother();
		mother.birthAnimal();
	}
	/**
	 * 抽象工厂模式测试
	 * Animal : 抽象产品类
	 * Dog,Cat,Sheep,Cattle 具体产品类
	 * AnimalMother :抽象工厂角色
	 * CatMother,DogMother :具体工厂角色
	 * MilkAnimalMother :抽象工厂类
	 * SheepMilkMother,CattleMilkMother :具体工厂类
	 */
	@Test
	public void abstrFactoryTest(){
		MilkAnimalMother mother=new SheepMilkMother();
		mother.birthAnimal();
		mother.productMilk();
		mother=new CattleMilkMother();
		mother.birthAnimal();
		mother.productMilk();
	}
}