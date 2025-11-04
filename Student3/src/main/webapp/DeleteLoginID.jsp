<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/index.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>注销账号</title>
</head>
<body>
	<form action = "DeleteLoginIDServlet" method = "post">
	<div class = "content">
	<div class = "box">
	<div class = "item1">
	<h2>注销账号</h2>
	</div>
	<div class = "item">
	<input type = "text" name = "UID" id = "UID" placeholder="账号"/><br/>
	</div>
	<div class = "item">
	<input type = "password" name = "upwd" id = "upwd" placeholder="密码"/><br/>
	</div>
	<input type = "submit" class = "btn" value = "注销"/><br/>
	<a href = "login.jsp">返回</a>
	<%
	String error2 = (String) request.getAttribute("error2");
	if (error2!= null) {
	if (error2.equals("loginError")) {
			out.println("用户名或密码错误！注销失败！");
		}
	}
		%>
	</div>
	</div>

	</form>
</body>
</html>