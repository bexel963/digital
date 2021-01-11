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
        <form action="<%=request.getContextPath()%>/signup" method="post">
            <h1 class="text-primary">회원가입</h1>
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" class="form-control" id="usr" name="id" value="${user.id}">	<!-- user클래스의 getId()메소드가 호출된다. -->
            </div>
            <div class="form-group">
                <label for="pw">비밀번호</label>
                <input type="password" class="form-control" id="usr" name="pw" value="${user.pw}">
            </div>
            <div class="form-group">
                <label for="pw2">비밀번호 확인</label>
                <input type="password" class="form-control" id="usr" name="pw2" value="${user.pw2}">
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="usr" name="name" value="${user.email}">
            </div>
            <div class="form-group">
                <label for="age">나이</label>
                <input type="text" class="form-control" id="usr" name="age" value="${user.age}">
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" class="form-control" id="usr" name="email" value="${user.email}">
            </div>
            <div>성별</div>
            <div class="form-check-inline">
                <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="gender" value="남성" checked>남성
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="gender" value="여성">여성
                </label>
            </div>
            <div class="form-group">
                <label for="num">전화번호</label>
                <input type="text" class="form-control" id="usr" name="home" value="${user.num}">
            </div>
            <button type="submit" class="btn btn-outline-primary col-12">회원가입</button>
        </form>
    </div>
</body>
</html>