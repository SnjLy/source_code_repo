package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.User;
import com.springmvc.service.UserService;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//@RequestMapping(params="method=saveuser")
	@RequestMapping(value="/saveUser")
	public String saveUser(@RequestParam("username") String name, User user){
		
		System.out.println(name + "" +user.getUsername()+"-"+user.getPassword()+"-"+user.getAge());
		userService.insert(user);
		return "user/success";
	}
	
	@RequestMapping("/selectUserById")
	public String queryUser(HttpServletRequest req, @RequestParam("id") Integer id)
	{
		User user= userService.selectByPrimaryKey(id);
		System.out.println("select user!!!:"+id+user.getUsername());
		req.setAttribute("userInfo", user);
		return "user/userInfo";
		
		//return "userInfo";
	}
}
