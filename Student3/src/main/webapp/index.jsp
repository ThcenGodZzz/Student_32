<%@page import="student.entity.Student"%>
<%@page import="student.entity.Page"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type = "text/javascript" src = "js/jquery-3.6.0.js"></script>
	
	<script type = "text/javascript">
	 $(document).ready(function(){
	 	$("tr:odd").css("background-color","lightgrey");
	 
	 });
	</script>
	
<link href="css/show.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>

	<div class = "content">
	<div class = "box">
	<div class = "item1">
	<input type = "button" value = "退出登录" onclick = "location = 'login.jsp'"/><br/>
	</div>
	<table  border="2" cellspacing="0">
		<tr>
			<th><h2>学号</h2></th>
			<th><h2>姓名</h2></th>
			<th><h2>年龄</h2></th>
			<th><h2>专业</h2></th>
			<th><h2>操作</h2></th>
		</tr>
		<%
		Page page1 = (Page)request.getAttribute("page1");
		
		for(Student student:page1.getStudents()){
			%>
			<tr>
				<td><a href = "QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno() %></a></td>
				<td><%=student.getName() %></td>
				<td><%=student.getAge() %></td>
				<td><%=student.getDept() %></td>
				<td><a href = "DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
			</tr>
			<%			
		}
		%>
		</table>
		<div class = item>
		<a href = "add.jsp">增加学生</a>
		</div>
	<% 
		if(page1.getCurrentPage()==page1.getTotalPage()-1){
		%>
		<div class = item>
		<a href = "QueryStudentByPageServlet?currentPage=0">首页</a>
		<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()-1%>">上一页</a>
		</div>
		<% 
		}
		else if(page1.getCurrentPage()==0){
			%>
			<div class = item>
			<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()+1%>">下一页</a>
			<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getTotalPage()-1%>">尾页</a>
			</div>
			<%
		}
		else{
			%>
			<div class = item>
			<a href = "QueryStudentByPageServlet?currentPage=0">首页</a>
			<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()-1%>">上一页</a>
			<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getCurrentPage()+1%>">下一页</a>
			<a href = "QueryStudentByPageServlet?currentPage=<%=page1.getTotalPage()-1%>">尾页</a>
			</div>
			<%
		}
		%>
		<input type = "button" value = "上传作业" class = "btn"  onclick = "location = 'UpAndDown.jsp'"/><br/>
			<%
	String error = (String)request.getAttribute("error");
	if(error!=null){
	if(error.equals("addError")){
		out.println("增加失败！");
	}
	else if(error.equals("noaddError")){
		out.println("增加成功！");
	}
	}
	
	String error1 = (String)request.getAttribute("error1");
	if(error1!=null){
	if(error1.equals("deleteError")){
		out.println("删除失败！");
	}
	else if(error1.equals("nodeleteError")){
		out.println("删除成功！");
	}
	}
	String error2 = (String)request.getAttribute("error2");
	if(error2!=null){
	if(error2.equals("updateError")){
		out.println("修改失败！");
	}
	else if(error2.equals("noupdateError")){
		out.println("修改成功！");
	}
	}
	
	
	String error3 = (String)request.getAttribute("error3");
	if(error3!=null){
	if(error3.equals("uploadError")){
		out.println("上传失败！");
	}
	else if(error3.equals("nouploadError")){
		out.println("上传成功！");
	}
	}
	%>
		</div>
		</div>
</body>
</html>