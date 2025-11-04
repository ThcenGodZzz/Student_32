<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/index.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8"><script type = "text/javascript" src = "js/jquery-3.6.0.js"></script>
	
	<script type = "text/javascript">
	function check()
	{
		var upwd = $("#upwd").val();
		var upwd1 = $("#upwd1").val();
		var upwd2 = $("#upwd2").val();
		if(upwd1 != upwd2){
			alert("两次输入的密码不一致，请重新输入！");
			return false;
		}
		
		return true;
	}
	 $(document).ready(function(){
	 });
	</script>

<title>更改账号密码</title>
</head>
<body>
	<form action = "UpdateLoginPwdServlet" method = "post" onsubmit = "return check()">
	<div class = "content">
	<div class = "box">
	<div class= "item1"><h2>修改密码</h2></div>
	<div class = item>
	<input type = "text" name = "UID" id = "UID" placeholder="账号"/><br/>
	</div>
	<div class = item>
	<input type = "password" name = "upwd" id = "upwd" placeholder="旧密码"/><br/>
	</div>
	<div class = item>
	<input type = "password" name = "upwd1" id = "upwd1" placeholder="新密码"/><br/>
	</div>
	<div class = item>
	<input type = "password" name = "upwd2" id = "upwd2" placeholder="确认密码"/><br/>
	</div>
	<input type = "submit" class = "btn" value = "提交"/><br/>
	<a href = "login.jsp">返回</a>
	<%
	String error0 = (String) request.getAttribute("error0");
	if (error0!= null) {
		if (error0.equals("loginError")) {
			out.println("用户名或密码错误，请重新输入！");
		} else if (error0.equals("nologinError")) {
			response.sendRedirect("login.jsp");
		}
	}
	%>
	</div>
	</div>
	</form>
</body>
</html>