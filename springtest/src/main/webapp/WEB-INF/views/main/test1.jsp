<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${name} <br>
	나이 : ${age} <br>
	이름 : ${testVo.name} <br>
	나이 : ${testVo.age} <br>
	<c:forEach begin="${start}" end="${end}" var="index">${index}<br></c:forEach>
	<c:forEach items="${list}" var="testVo">이름 : ${testVo.name}<br> 나이 : ${testVo.age}<br></c:forEach>
</body>
</html>