package com.springmvc.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.BookMapper;
import com.springmvc.model.Book;
import com.springmvc.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper; 

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Book record) {
		return bookMapper.insert(record);
	}

	@Override
	public int insertSelective(Book record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book selectByPrimaryKey(Integer id) {
		return bookMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Book record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Book record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> selectAllBook() {
		List<Book> list=bookMapper.selectAll();
		return list;
	}
	
	

}
