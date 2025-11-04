<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/index.css" type="text/css" rel="stylesheet">
<script type = "text/javascript" src = "js/jquery-3.6.0.js"></script>
	
	<script type = "text/javascript">
	function check()
	{
		var sname = $("#sname").val();
		var sno = $("#sno").val();
		var sage = $("#sage").val();
		var sdept = $("#sdept").val();
		if(!(sno>1&&sno<2000)){
			alert("学号有误！必须是1-2000");
			return false;
		}
		if(!(sname.length>1&&sname.length<5)){
			alert("姓名有误！必须是2-4位");
			return false;
		}
		if(!(sage>1&&sage<100)){
			alert("年龄有误！必须是1-100");
			return false;
		}
		return true;
	}
	 $(document).ready(function(){
	 });
	</script>
	
<title>增加学生信息</title>
</head>
<body>
	<form action = "AddStudentServlet" method = "post"  onsubmit = "return check()">
	<div class = "content">
	<div class = "box">
	<div class = "item2">
	<h2>增加学生信息</h2>
	</div>
	<div class = "item">
	<input type = "text" name = "name" id = "sname" placeholder="姓名"/><br/>
	</div>
	<div class = "item">
	<input type = "text" name = "sno" id = "sno" placeholder="学号"/><br/>
	</div>
	<div class = "item">
	<input type = "text" name = "age" id = "sage" placeholder="年龄"/><br/>
	</div>
	<div class = "item">
	<input type = "text" name = "dept" id = "sdept" placeholder="专业"/><br/>
	</div>
	<input type = "submit" class = "btn" value = "增加"/><br/>
	<a href = "QueryStudentByPageServlet">返回</a>
	</div>
	</div>
	</form>
</body>
</html>