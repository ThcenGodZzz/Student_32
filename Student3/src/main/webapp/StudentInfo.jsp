<%@page import="student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/index.css" type="text/css" rel="stylesheet">
<title>修改学生信息</title>
</head>
<body>
	<%
		Student student = (Student)request.getAttribute("student");
	%>		
	<form action = "UpdateStudentServlet" method = "post">
	<div class = "content">
	<div class = "box">
	<div class = "item1">
	<h2>修改学生信息</h2>
	</div>
		<div class = "item">
		学号:<input type = "text" name = "sno" value ="<%=student.getSno()%>" readonly = "readonly"/><br/>
		</div>
		<div class = "item">
		姓名:<input type = "text" name = "name" value ="<%=student.getName()%>"/><br/>
		</div>
		<div class = "item">
		年龄:<input type = "text" name = "age" value ="<%=student.getAge()%>"/><br/>
		</div>
		<div class = "item">
		专业:<input type = "text" name = "dept" value ="<%=student.getDept()%>"/><br/>
		</div>
		<input type = "submit" class = "btn" value = "修改"/>
		<a href = "QueryStudentByPageServlet">返回</a>
		</div>
		</div>
	</form>
</body>
</html>