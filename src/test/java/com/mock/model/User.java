package com.mock.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>user entity</p>
 * Created by admin on 2017/9/1.
 */
@Data
public class User extends BaseEntity{
    private Long id;
    private String name;
    private int age;
    private int sex;
    private String address;
    private String mobile;
    private String userId;
    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
