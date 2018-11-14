package com.FactoryModel;

import com.FactoryModel.entity.*;

/**
 * Created by admin on 2016/10/11.
 */
public class EntityFactoryImpl implements EntityFactory{

	@Override
	public ObjectEntity createEnntity(int type) {
		switch (type){
			case 1:return new StudentEntity();
			case 2:return new TeacherEntity();
			case 3:return new CarEntity();
			default:return new DefaultEntity();
		}
	}
}
