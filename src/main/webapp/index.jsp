<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<body>
	<h2>Hello World!</h2>
	
	<a href="<%= basePath%>/commonFile/download?fileName=dailyGoodshop">下载模板</a>

	<form action="user/saveUser" method="post">
		姓名：<input type="text" name="username" id="name"><br>	
		<!--  姓名：<input type="hidden" name="username" id="name"><br>-->
		
		年龄：<input type="text" name="age" id="age"><br>
		密码：<input type="password" name="password" id="password"><br>

		<input type="submit" value="Add">
	</form>
	
	<form action="book/addBook" method="post">
		书名：<input type="text" name="name" id="name"><br>	
		
		价格：<input type="text" name="price" id="price"><br>

		<input type="submit" value="Add">
	</form>
	
	<form action="excel/uploadExcel" method="post">
		<input type="submit" value="导入Excel">
	</form>
	
	<form id="download" action="excel/downloadExcel" method="post">
		<input type="submit"  value="导出"  />
	</form>
</body>
</html>
