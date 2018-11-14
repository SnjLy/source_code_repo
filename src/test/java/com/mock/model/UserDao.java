package com.mock.model;

/**
 * <p>userDao operate database</p>
 * Created by yehao on 2017/9/1.
 */
public class UserDao {
    public User getUserById(Long id) {
        return new User(id, "testDao");
    }
}
