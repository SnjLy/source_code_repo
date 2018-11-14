package com.yehao_test.Properties.entity;

import com.yehao_test.Properties.BaseEntity;

public class ActivityOptEntity extends BaseEntity<ActivityOptEntity> {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String descript;
    
    
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

    @Override
    public String toString() {
        return "ActivityOptEntity{" +
                "name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                '}';
    }
}
