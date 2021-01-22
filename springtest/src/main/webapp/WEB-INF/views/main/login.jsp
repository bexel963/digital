<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user == null}">
		<form action="<%=request.getContextPath()%>/login" method="post">	<!-- url이 localhost:8080/test/login <-> HomeController의 url과 조금 다름 -->
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
	</c:if>
	<a href="#" class="find-pw">비밀번호 찾기</a>
	<script>
		$('.find-pw').click(function(e){
			e.preventDefault();
			var id = prompt('아이디를 입력하세요');
			var sendData = {'id' : id};
			$.ajax({
				url : '<%=request.getContextPath()%>/find/pw',
				type : 'post',
				data : JSON.stringify(sendData),
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					console.log(data.result);
					if( data.result == "fail" ){
						alert('존재하지 않는 아이디');
					}else if( data.result == "success"){
						alert('비밀번호를 등록한 메일로 전송했습니다.');
					}
				
				},
				error : function(){
					console.log('추천/비추천 과정에 문제가 있습니다.');
				}
			})
		})
	</script>
</body>
</html>