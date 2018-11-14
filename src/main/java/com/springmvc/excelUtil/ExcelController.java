package com.springmvc.excelUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/excel")
public class ExcelController {

	@RequestMapping("/uploadExcel")
	public ModelAndView toExcelUpload(){
		return new ModelAndView("uploadExcel");
	}
	
	@RequestMapping("/readExcel")
	@ResponseBody
	public String readExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ReadExcelServlet readServlet=new ReadExcelServlet();
		return readServlet.doGet(request, response);
	}
	
	@RequestMapping("/downloadExcel")
	public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Excel2007Servlet es=new Excel2007Servlet();
		es.doGet(request, response);
	}
	
	
}
