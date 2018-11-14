package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Book;
import com.springmvc.service.BookService;

@Controller
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/addBook")
	public String addBook(Book book)
	{
		bookService.insert(book);
		System.out.println("add book!"+book.getName());
	//	return "/searchAll";
		return "forward:/book/searchAll"; 
	}
	
	@RequestMapping("/updateBook")
	public String updateBook(Book record){
		bookService.updateByPrimaryKey(record);
		return "user/success";
	}
	
	@RequestMapping("/searchAll")
	public @ResponseBody List<Book> selectBook(HttpServletRequest req)
	{
		List<Book> books=bookService.selectAllBook();
		req.setAttribute("books", books);
		System.out.println(books.size()+"-"+books.toString());
		return books;
		
	}
	

}
