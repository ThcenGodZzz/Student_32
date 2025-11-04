<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/index.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<script type = "text/javascript" src = "js/jquery-3.6.0.js"></script>
	
	<script type = "text/javascript">
	function check()
	{
		var UID = $("#UID").val();
		var upwd = $("#upwd").val();
		var upwd1 = $("#upwd1").val();
		if(upwd != upwd1){
			alert("两次输入的密码不一致，请重新输入！");
			return false;
		}
		
		return true;
	}
	 $(document).ready(function(){
	 });
	</script>
<title>注册账号</title>
</head>
<body>
	<form action = "AddLoginIDServlet" method = "post" onsubmit = "return check()">
	<div class = "content">
		<div class = "box">
		<div class = "item1">
		<h2>用户注册</h2>
		</div>
		<div class = "item">
		<input type = "text" name = "UID" id = "UID" placeholder="账号"/><br/>
		</div>
		<div class = "item">
		<input type = "password" name = "upwd" id = "upwd" placeholder="密码"/><br/>
		</div>
		<div class = "item">
		<input type = "password" name = "upwd1" id = "upwd1" placeholder="确认密码"/><br/>
		</div>
		<input type = "submit" class = "btn" value = "注册"/><br/>
		<a href = "login.jsp">返回</a>
		<%
		String error4 = (String) request.getAttribute("error4");
		if (error4!= null) {
		if (error4.equals("addError")) {
			out.println("注册失败！账户名已经存在！");
		} 
	}
	%>
	</div>
	</div>
	</form>
	
</body>
</html>