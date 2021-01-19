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
	  <h2><br>게시판</h2>     
	  <div class="container"><br>
		<form class="input-group mb-3" action="<%=request.getContextPath()%>/board/list" method="get"> <!-- method는 생략하면 기본 get으로 들어감 -->
			<div class="input-group-append">
				<select class="form-control" name="type"> <!-- select태그는 option태그와 같이 쓰여야함. -->
					<option value="1" <c:if test="${pm.criteria.type == 1}">selected</c:if>>전체</option>
					<option value="2" <c:if test="${pm.criteria.type == 2}">selected</c:if>>제목</option>
					<option value="3" <c:if test="${pm.criteria.type == 3}">selected</c:if>>내용</option>
					<option value="4" <c:if test="${pm.criteria.type == 4}">selected</c:if>>작성자</option>
				</select>
			</div>
			<input type="text" class="form-control" name="search" value = ${pm.criteria.search}>
			<div class="input-group-append">
      			<button class="btn btn-success" type="submit">검색</button>  
     		</div>
		</form>
	  </div>
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	   	  <c:forEach items="${list}" var="board">
		      <tr>
		        <td>${board.num}</td>	<!-- getNum()을 불러옴 -->
		        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}&page=${pm.criteria.page}&search=${pm.criteria.search}&type=${pm.criteria.type}">${board.title}</a></td>
		        <td>${board.writer}</td>
		        <td>${board.registerDate}</td>
		        <td>${board.views}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}&search=${pm.criteria.search}&type=${pm.criteria.type}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    	<li class="page-item <c:if test="${index == pm.criteria.page}">active</c:if>"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&search=${pm.criteria.search}&type=${pm.criteria.type}">${index}</a></li>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}&search=${pm.criteria.search}&type=${pm.criteria.type}">다음</a></li>
	    </c:if>
  	  </ul>
	  <a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-info">글쓰기</button>
	  </a>
	</div>
	${pm}
	<br>
	${list}
</body>
</html>