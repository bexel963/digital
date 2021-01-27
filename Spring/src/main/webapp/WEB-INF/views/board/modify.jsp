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
	  <h2><br>게시글 수정</h2>
	  <c:if test="${board != null && board.writer == user.id}">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
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
	      <input type="text" class="form-control" name="title" value="${board.title}">
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${user.id}" readonly>	<!-- 세션에 저장된 user의 id를 가져옴 -->
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea style="display:none"rows="10" class="form-control" name="content"></textarea>	<!-- 쌍태그는 값을 value 말고 쌍태그 사이에 넣는다. -->
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
	    <c:if test="${fList.size() != 0}">
		    <div class="form-group">
		      <label for="cotent">첨부파일</label>
		      <c:forEach items="${fList}" var="file">
		      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
		      </c:forEach>
		    </div>
	    </c:if>
	    <button type="submit" class="btn btn-outline-dark">등록</button><br>
	  </form>
	  </c:if>
	  <c:if test="${board == null || board.writer != user.id}">
	  <h1>존재하지 않는 게시글이거나 작성자가 아닙니다.</h1>
	  </c:if>
	</div>
	<script>
		$(function(){
			$('form').submit(function(){
				var cnt = 0;
				$('input[name=fileList]').each(function(){
					if($(this).val() != ''){
						cnt++;
					}
				})
				
				var content = $('#summernote').summernote('code');
		    	$('textarea[name=content]').val(content);
		    	
				if(cnt == 0){
					var res = confirm('선택된 첨부파일이 없습니다. 이전에 등록된 첨부파일이 삭제 됩니다. 수정 하시겠습니까?');	
					return res;
				}

				return true;
			})
		})
	</script>
	<script>
      $('#summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 100
      });
      $('#summernote').summernote('code', '${board.content}');
    </script>
</body>
</html>