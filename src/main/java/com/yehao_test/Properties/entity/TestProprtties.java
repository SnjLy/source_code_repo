package com.yehao_test.Properties.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by admin on 2016/8/2.
 */
public class TestProprtties {


	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		ActivityOpt activityOpt = new ActivityOpt();
		activityOpt.setName("ceshi");
		activityOpt.setDescript("jiushiyigejiandandeceshi");
		activityOpt.setCreateDate(new Date());

		System.out.println(activityOpt);
		ActivityOptEntity activityOptEntity = new ActivityOptEntity();
		BeanUtils.copyProperties(activityOptEntity,activityOpt);

		System.out.println(activityOptEntity);
	}
}

