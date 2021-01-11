<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <h2><br>게시글 수정</h2>
	  <c:if test="${board != null && board.writer == user.id}">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post">
	  	<div class="form-group">
	      <label><br>번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label><br>작성일</label>
	      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label><br>제목</label>
	      <input type="text" class="form-control" name="title" >
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${user.id}" readonly>	<!-- 세션에 저장된 user의 id를 가져옴 -->
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea rows="10" class="form-control" name="content"></textarea>	<!-- 쌍태그는 값을 value 말고 쌍태그 사이에 넣는다. -->
	    </div>
	    <button type="submit" class="btn btn-outline-dark">등록</button><br>
	  </form>
	  </c:if>
	  <c:if test="${board == null || board.writer != user.id}">
	  <h1>존재하지 않는 게시글이거나 작성자가 아닙니다.</h1>
	  </c:if>
	</div>
</body>
</html>