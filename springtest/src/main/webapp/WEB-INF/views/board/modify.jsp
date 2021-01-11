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
	  <h2>게시글 수정</h2>
	  <c:if test="${board != null}">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post">
		  <div class="form-group">
		     <label for="num">번호</label>
		     <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
		  </div>
		  <div class="form-group">
		     <label for="title">제목</label>
		     <input type="text" class="form-control" id="title" name="title"  value="${board.title}">
		  </div>
	      <div class="form-group">
		      <label for="writer">작성자</label>		      
		      <input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">
		  </div>
		  <div class="form-group">
		     <label for="registerDate">작성일</label>
		     <input type="text" class="form-control" id="registerDate" name="registerDate" readonly value="${board.registerDate}">
	      </div>
	      <div class="form-group">		      
	      	 <label for="content">내용</label>
		     <textarea class="form-control" id="content" name="content"  >${board.content}</textarea>
		  </div>
		  <button type="submit" class="btn btn-outline-info">수정</button>
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
		<h1>존재하지 않은 게시물입니다.</h1>
	  </c:if>	 
	  <a href="<%=request.getContextPath()%>/board/list">
		<button type="button" class="btn btn-outline-info">목록</button>
	  </a>
	  <a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-info">글쓰기</button>
	  </a>
	</div>
</body>
</html>