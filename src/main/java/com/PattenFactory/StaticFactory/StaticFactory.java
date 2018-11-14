package com.PattenFactory.StaticFactory;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态工厂创建一个对象  静态工厂类产生的对象一般都有共同的特性，继承某一类，或者引用接口之类，在此
 * 没有看似没有，但不可否认他们都是Object或者Object的一个子类
 * Created by admin on 2016/10/11.
 */
public class StaticFactory {

	public static Object getInstance(String className){
		Object instance = null;
		try {
			Class cls = Class.forName(className);
			instance = cls.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("className:"+className +"实体是："+ JSON.toJSONString(instance));
		return instance;
	}

	public static Object getInstance(String className,Object ...args){
		Class cls = null;

		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
		/*java反射*/
		Constructor[] constructors = cls.getConstructors();
		Object instance = null;
		for (Constructor con:constructors){
			Class<?>[] classes = con.getParameterTypes();
			if (classes.length>0){
				boolean isThisConstructor = true;
				for (int i=0;i<classes.length;i++){
					Class c = classes[i];
					if (!c.isInstance(args[i])){
						isThisConstructor = false;
					}
				}
				if (isThisConstructor){
					try {
						instance = con.newInstance(args);
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}else {
					continue;
				}
			}
		}
		System.out.println("className:"+className +"实体是："+ JSON.toJSONString(instance));
		return instance;
	}
}
