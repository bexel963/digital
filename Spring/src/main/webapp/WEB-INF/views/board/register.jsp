<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2><br>게시글 등록</h2>
	  <form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label><br>제목</label>
	      <input type="text" class="form-control" name="title" value="">
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${user.id}" readonly>	<!-- 세션에 저장된 user의 id를 가져옴 -->
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea style="display:none;"rows="10" class="form-control" name="content"></textarea>	<!-- 쌍태그는 값을 value 말고 쌍태그 사이에 넣는다. -->
	    </div>
	    <div id="summernote"></div>
	    <div class="form-group">
	        <label>파일</label>
	        <input type="file" class="form-control" name="fileList"/>
    	</div>
    	<div class="form-group">
	        <label>파일</label>
	        <input type="file" class="form-control" name="fileList"/>
    	</div>
    	<div class="form-group">
	        <label>파일</label>
	        <input type="file" class="form-control" name="fileList"/>
    	</div>
	    <button type="submit" class="btn btn-outline-dark">등록</button><br>
	  </form>
	</div>
	
	<script>
      $('#summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
      $('form').submit(function(){
    	  var content = $('#summernote').summernote('code');
    	  $('textarea[name=content]').val(content);
      })
    </script>
</body>
</html>







