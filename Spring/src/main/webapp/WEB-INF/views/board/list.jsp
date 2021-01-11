<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container"><br>
		<form class="input-group mb-3">
			<div class="input-group-append">
				<select class="form-control" name="type">
					<option value="1">��ü</option>
					<option value="2">����</option>
					<option value="3">����</option>
					<option value="4">�ۼ���</option>
				</select>
			</div>
			<input type="text" class="form-control" name="search" placeholder="Search">
			<div class="input-group-append">
      			<button class="btn btn-success" type="submit">Go</button>  
     		</div>
		</form>
	</div>
	<div class="container">
	  <h2>�Խ���</h2>            
	  <table class="table table-dark table-hover">
	    <thead>
	      <tr>
	        <th>��ȣ</th>
	        <th>����</th>
	        <th>�ۼ���</th>
	        <th>�ۼ���</th>
	        <th>��ȸ��</th>
	      </tr>
	    </thead>
	    <tbody>
	   	  <c:forEach items="${list}" var="board">		<!-- �������� �Ѱ��� �����͸� item���� �޾Ƽ� ����. -->
		      <tr>
		        <td>${board.num}</td>	<!-- getNum()�� �ҷ��� -->
		        <td><a href="<%=request.getContextPath()%>/board/detail?num=${board.num}">${board.title}</a></td>
		        <td>${board.writer}</td>
		        <td>${board.registerDate}</td>
		        <td>${board.views}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pm.prev}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.startPage-1}">����</a></li>
	  	</c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="index">
	    	<c:if test="${index == pm.criteria.page}">
	    		<li class="page-item active"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
	    	</c:if>
	    	<c:if test="${index != pm.criteria.page}">
	    		<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}">${index}</a></li>
	    	</c:if>
	    </c:forEach>
	    <c:if test="${pm.next}">
	    	<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pm.endPage+1}">����</a></li>
	    </c:if>
	  </ul>
	  <a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-outline-dark">�۾���</button></a>
	</div>
</body>
</html>