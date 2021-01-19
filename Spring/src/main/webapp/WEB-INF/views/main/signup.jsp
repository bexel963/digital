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
            <button type="button" class="btn btn-outline-success col-12" id="dup">아이디 중복검사</button>
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
        <script>
        	var dup = false;	// 전역변수 - 중북검사를 했는지 안 했는지 기억하는 변수
        	
        	$('#dup').click(function(){
        		var id = $('input[name=id]').val();	// name이 id인 input태그 안의 값을 변수 id에 저장.
        		if(id == ''){
        			alert('아이디를 입력하세요');
        			return;
        		}
        		var data = { 'id' : id };	// 'id' - 멤버변수 이름 id - 위에서 만든 변수의 값
        		$.ajax({
					url : '<%=request.getContextPath()%>/dup',
					type : 'post',
					data : data,
					success : function(data){	// 성공하면 서버에서 데이터 받음
						if(data == 'user'){
							alert('이미 가입된 아이디 입니다.');
						}else{
							alert('가입 가능한 아이디 입니다.');
							dup = true;
						}
					},
					error : function(){
						console.log('실패');
					}
				})
        	})
        	
        	$('input[name=id]').change(function(){ // id값이 바뀌면 중복검사 다시 해야한다.
        		dup = false;
        	})
        	$('form').submit(function(){
        		if(!dup){
        			alert('아이디 중복검사를 하세요');
        			return false;
        		}
        	})
        </script>
    </div>
</body>
</html>













