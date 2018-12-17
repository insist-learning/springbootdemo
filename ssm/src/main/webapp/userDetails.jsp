<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户详情页</title>
<style>
	table {
		border-collapse:collapse;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td>id</td>
			<td>${ user.id }</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td>${ user.username }</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${ user.age }</td>
		</tr>
	</table>
	<a href="/allUser">返回首页</a>
</body>
</html>