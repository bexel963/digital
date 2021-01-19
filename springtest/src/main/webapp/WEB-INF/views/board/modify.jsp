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
	  <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
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
		  <div class="form-group">
	        <label>첨부파일</label>
	        <input type="file" class="form-control" name="fileList"/>
	        <input type="file" class="form-control" name="fileList"/>
	        <input type="file" class="form-control" name="fileList"/>
    	  </div>
		  <c:if test="${fileList.size() != 0}">
		    <div class="form-group">
		      <label for="cotent">기존 첨부파일</label>
		      <c:forEach items="${fileList}" var="file">
		      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
		      </c:forEach>
		    </div>
	      </c:if>
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
	  <script type="text/javascript">
	  	$(function(){
	  		/* form태그가 submit되면 해당 함수를 실행 */
	  		/* 
	  		   - submit()은 return 값이 true이면 submit을 진행하고, false이면 진행하지 않는다.
	  		     즉, return이 true이면 서버로 데이터를 전송하고, false이면 서버로 데이터를 전송하지 않는다.
	  		*/
	  		$('form').submit(function(){
	  			// 첨부파일의 파일명을 가져와서 콘솔에 출력하는 코드 
	  			/*
	  			var test1 = $('input[name=fileList]').eq(0).val();
	  			var test2 = $('input[name=fileList]').eq(1).val();
	  			var test3 = $('input[name=fileList]').eq(2).val();
	  			console.log('첫번째 파일 : ' + test1);
	  			console.log('두번째 파일 : ' + test2);
	  			console.log('세번째 파일 : ' + test3);
	  			return false;
	  			*/
	  			
	  			var cnt = 0;
	  			$('input[name=fileList]').each(function(){ // 반복문 - 선택한 속성에 해당하는 요소 각각에 기능 적용
	  				var fileName = $(this).val()
	  				console.log(fileName);
					// 파일명이 빈 문자열인 ''와 같지 않으면(추가된 첨부파일이 있으면) 갯수를 증가 시킴
	  				if(fileName != ''){
						cnt++;
					}
				})
					console.log(cnt)
					if(cnt == 0){
						return confirm('선택된 첨부파일이 없습니다. 수정 하시겠습니다?');
					}
	  				return true;
	  		});
	  	})
	  </script>
	</div>
	${fileList}
</body>
</html>