package com.FactoryModel;

import com.FactoryModel.entity.ObjectEntity;

/**
 * 实例工厂
 * Created by yehao on 2016/10/11.
 */
public interface EntityFactory {

	public ObjectEntity createEnntity(int type);

}
