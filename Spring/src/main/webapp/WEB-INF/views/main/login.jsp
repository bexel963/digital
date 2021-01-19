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
	
	<c:if test="${user != null}">
		<br>
		<button id="btnAjax1">ajax버튼1</button>
		<button id="btnAjax2">ajax버튼2</button>
	
		<div>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>이메일</td>
						<td>나이</td>
						<td>전화번호</td>
						<td>권한</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
					</tr>
					<tr>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
					</tr>		
				</tbody>
			</table>
		</div>
		
		<script>
			$(function(){
				$('#btnAjax1').click(function(){
					var data = { name : 'Hong', age : 21 };	// 객체
					$.ajax({
						url : '<%=request.getContextPath()%>/ajax1',
						type : 'post',
						data : data,	// data를 HomeController의 해당 매개변수로 보냄
						success : function(data){	// 메소드 ajax1Post의 반환값을 서버로부터 받아서 실행
							console.log(data);
						},
						error : function(){
							console.log('실패');
						}
					})
				})
			})
		</script>
		<script type="text/javascript">
			$(function(){
				$('#btnAjax2').click(function(){
					var sendData = { name : 'Hong', age : 21 };	
					$.ajax({
						url : '<%=request.getContextPath()%>/ajax2',
						type : 'post',
						data : JSON.stringify(sendData),	// 객체를 JSON형태로 바꾼 후 보낸다
						dataType:"json",								// 서버로 보낼 데이터 형식 지정
				        contentType:"application/json; charset=UTF-8",	// 서버에서 받을 데이터 형식 지정
						success : function(data){	
							console.log(data);			// json형태
							console.log(data['list']);	// 리스트에 해당하는 것만 가져오기
							console.log(data.list);		// data['list'] 이거랑 같음
							console.log(data['list'][0]);	// 리스트 중 한 요소만
							console.log(data.testVo.name);
							console.log(data['testVo']['name']);
							console.log(data['list'][0]['email']);
							console.log(data.list[0].email);	
							
							var str = '';
							var list = data['list'];
							for(var i=0 ; i<list.length ; i++){
								str += '<tr>'
								str += '<td>' + list[i]['id'] + '</td>'
								str += '<td>' + list[i]['name'] + '</td>'
								str += '<td>' + list[i]['email'] + '</td>'
								str += '<td>' + list[i]['age'] + '</td>'
								str += '<td>' + list[i]['home'] + '</td>'
								str += '<td>' + list[i]['author'] + '</td>'
								str += '</tr>'
							}
							$('tbody').html(str);
						},
						error : function(){
							console.log('실패');
						}
					})
				})
			})	
		</script>
	</c:if>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/test.js"></script>
</body>
</html>