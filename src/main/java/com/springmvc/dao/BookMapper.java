package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Book;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);
    
    List<Book> selectAll();

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}