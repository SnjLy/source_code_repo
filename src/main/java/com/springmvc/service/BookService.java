package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Book;

public interface BookService {
	int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);
    
    List<Book> selectAllBook();

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}
