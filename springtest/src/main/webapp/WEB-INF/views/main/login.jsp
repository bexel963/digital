<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- url�� localhost:8080/test/login <-> HomeController�� url�� ���� �ٸ� -->
	<form action="/test/login" method="post">
	    <div class="form-group">
	      <label for="usr">ID:</label>
	      <input type="text" class="form-control" id="usr" name="username">
	    </div>
	    <div class="form-group">
	      <label for="pwd">PW:</label>
	      <input type="password" class="form-control" id="pwd" name="password">
	    </div>
	    <button type="submit" class="btn btn-primary col-12">�α���</button>
	</form>
</body>
</html>