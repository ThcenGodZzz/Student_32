<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/index.css" type="text/css" rel="stylesheet">
<title>上传作业</title>
</head>
<body>
	<form action ="UploadServlet" method = "post" enctype = "multipart/form-data">
	<div class = "content">
	<div class = "box">
	<div class = "item2">
	<h2>上传作业</h2>
	</div>
	<div class = "item">
	<input type = "text" name="sno" placeholder="学号"/><br/>
	</div>
	<div class = "item">
	<input type = "text" name = "name" placeholder="姓名"/><br/>
	</div>
	<input type = "file" name = "spiature"/>
	<br/>
	<br/>
	<input type = "submit" class = "btn" value ="上传"/>
	<a href = "QueryStudentByPageServlet">返回</a>
	</div>
	</div>
	</form>
</body>
</html>