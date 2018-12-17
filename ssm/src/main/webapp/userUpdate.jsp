<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input name="username" value="${ user.name }"/><br/>
		<input name="age" value=""/>
		<input type="submit" value="提交"/>
	</form>
	<a href="/allUser">返回首页</a>
	
</body>
</html>
  