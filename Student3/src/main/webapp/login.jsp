<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/login.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">

<title>学生信息管理系统-登录界面</title>
</head>
<body>
	<form action="CheckLoginServlet" method="post">
		<div class="content">
			<div class="wrap">
				<div class="login-box">
					<div class="login-frame">
						<h2>
							用户登录 <a href="register.jsp"> 立即注册</a>
						</h2>
						<div class=item>
							<input type="text" name="UID" placeholder="用户名">
						</div>
						<div class=item>
							<input type="password" name="upwd" placeholder="密码">
						</div>
						<input type="submit" class="login-btn" value="登 录">
						<div class=item1>
							<a href="UpdateLoginPwd.jsp"> 修改密码</a> 
							<a	href="DeleteLoginID.jsp"> 注销用户</a>
						</div>
						<%
							String error = (String) request.getAttribute("error");
							String error0 = (String) request.getAttribute("error0");
							String error1 = (String) request.getAttribute("error1");
							String error2 = (String) request.getAttribute("error2");
							String error3 = (String) request.getAttribute("error3");
							String error4 = (String) request.getAttribute("error4");

							if (error != null) {
								if (error.equals("loginError")) {
									out.println("用户名或密码错误！登录失败！");
								} else if (error.equals("nologinError")) {
									response.sendRedirect("QueryStudentByPageServlet");
								}
							}

							if (error0 != null) {
								if (error0.equals("loginError")) {
									out.println("用户名或密码错误！修改失败！");
								} else if (error0.equals("nologinError")) {
									if (error1 != null) {
								if (error1.equals("noupdateError")) {
									out.println("密码修改成功！");
								}
									}
								}
							}
							if (error2 != null) {
								if (error2.equals("loginError")) {
									out.println("用户名或密码错误！注销失败！");
								} else if (error2.equals("nologinError")) {
									if (error3 != null) {
								if (error3.equals("nodeleteError")) {
									out.println("账户注销成功！");
								}
									}
								}
							}
							if (error4 != null) {
								if (error4.equals("noaddError")) {
									out.println("账户注册成功！");
								}
							}
							%>
						</div>
					</div>
				</div>
			</div>
	</form>

</body>



</html>
