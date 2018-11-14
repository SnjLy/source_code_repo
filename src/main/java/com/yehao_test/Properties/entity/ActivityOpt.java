/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yehao_test.Properties.entity;


import com.yehao_test.Properties.BaseEntity;

import java.util.Date;

/**
 */
public class ActivityOpt extends BaseEntity<ActivityOpt> {

	private static final long serialVersionUID = 8280714256943581317L;
	private String name;		
	private String descript;
	private Date beginCreateDate;
	private Date endCreateDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}

	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	@Override
	public String toString() {
		return "ActivityOpt{" +
				"name='" + name + '\'' +
				", descript='" + descript + '\'' +
				", beginCreateDate=" + beginCreateDate +
				", endCreateDate=" + endCreateDate +
				'}';
	}
}