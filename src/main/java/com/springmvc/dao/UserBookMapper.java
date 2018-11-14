package com.springmvc.dao;

import com.springmvc.model.UserBook;

public interface UserBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBook record);

    int insertSelective(UserBook record);

    UserBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBook record);

    int updateByPrimaryKey(UserBook record);
}