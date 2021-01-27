<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
 
    </style>
</head>
<body>
    <div class="container">
        <form action="<%=request.getContextPath()%>/user/modify" method="post">
            <h1 class="text-primary">회원정보 수정</h1>
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" class="form-control" id="usr" name="id" readonly value="${user.id}">	 
       
            </div>
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input type="password" class="form-control" id="usr" name="pw" value="">
            </div>
            <div class="form-group">
                <label for="pw2">비밀번호 확인</label>
                <input type="password" class="form-control" id="usr" name="pw2" value="">
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="usr" name="name" value="${user.name}">
            </div>
            <div class="form-group">
                <label for="age">나이</label>
                <input type="text" class="form-control" id="usr" name="age" value="${user.age}">
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" class="form-control" id="usr" name="email" value="${user.email}">
            </div>
            <div class="form-group">
                <label for="num">전화번호</label>
                <input type="text" class="form-control" id="usr" name="home" value="${user.home}">
            </div>
            <button type="submit" class="btn btn-outline-primary col-12">수정</button>
        </form>
    </div>
	<script>
        $('form').submit(function(){		// form태그가 submit되면 // click이벤트로 하면 submit을 막을 수 없다.
        	var pw = $('input[name=pw]').val();
        	var pw2 = $('input[name=pw2]').val();
        	if( pw == '' ){
        		alert('비밀번호를 입력하세요');
        		return false;
        	}
        	if( pw != pw2 ){
        		alert('비밀번호가 일치하지 않습니다.')
        		return false;
        	}
        	
        	return true;
        })
	</script>
</body>
</html>






