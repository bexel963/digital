<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- url이 localhost:8080/test/login <-> HomeController의 url과 조금 다름 -->
	<form action="/test/login" method="post">
	    <div class="form-group">
	      <label for="usr">ID:</label>
	      <input type="text" class="form-control" id="usr" name="username">
	    </div>
	    <div class="form-group">
	      <label for="pwd">PW:</label>
	      <input type="password" class="form-control" id="pwd" name="password">
	    </div>
	    <button type="submit" class="btn btn-primary col-12">로그인</button>
	</form>
</body>
</html>