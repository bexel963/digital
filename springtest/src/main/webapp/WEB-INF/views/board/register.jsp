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
	  <h2>게시글 등록</h2>
	  <form action="<%=request.getContextPath()%>/board/register" method="post">	<!-- 게시글은 보안이 중요하지 않지만 내용이 길어서 POST로 한다. -->
	    <div class="form-group">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="writer">작성자</label>
	      <input type="text" class="form-control" id="writer" name="writer" readonly value="${user.id}">
	    </div>
	    <div class="form-group">
	      <label for="content">내용</label>
	      <textarea class="form-control" id="content" name="content"></textarea>
	    </div>
	    <button type="submit" class="btn btn-outline-info">등록</button>
	  </form>
	  <a href="<%=request.getContextPath()%>/board/list">
		<button type="button" class="btn btn-outline-info">목록</button>
	  </a>
	</div>
</body>
</html>