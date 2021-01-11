<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <h2>Hoverable Dark Table</h2>
	  <p>The .table-hover class adds a hover effect (grey background color) on table rows:</p>            
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	      </tr>
	    </thead>
	    <tbody>
	   	  <c:forEach items="${list}" var="board">
		      <tr>
		        <td>${board.num}</td>	<!-- getNum()을 불러옴 -->
		        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
		        <td>${board.writer}</td>
		        <td>${board.registerDate}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  <a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-info">글쓰기</button>
	  </a>
	</div>
</body>
</html>