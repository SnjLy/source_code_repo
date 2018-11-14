<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<title>上传Excel</title>
<script type="text/javascript" >
	function submitExcel() {
		var excelFile = document.getElementById("excelFile").value;
		if (excelFile == "") {
			alert("请选择需上传的文件!");
			return false;
		}
		if (excelFile.indexOf('.xls') == -1) {
			alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");
			return false;
		}
		$("#fileUpload").submit();
		alert("已提交");
	}
</script>
</head>
<body>
	<p>上传Excel</p>
	<hr>
	<form id="fileUpload" action="readExcel" enctype="multipart/form-data"
		method="post">
		<input id="excelFile" name="file" type="file" /> 
		<input type="button"  value="导入" onclick="submitExcel()" />
	</form>
	
</body>
</html>