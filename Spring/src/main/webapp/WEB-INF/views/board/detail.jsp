<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <h2>게시글</h2>
	  <c:if test="${board != null}">
	  <form action="">
	    <div class="form-group">
	      <label>번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성일</label>
	      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label>조회수</label>
	      <input type="text" class="form-control" name="views" value="${board.views}" readonly>
	    </div>
	    <div class="form-group">
	      <button type="button" class="btn btn-<c:if test="${like==null || like.up != 1}">outline-</c:if>success up">추천</button>
	      <button type="button" class="btn btn-<c:if test="${like==null || like.up != -1}">outline-</c:if>success down">비추천</button>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea rows="10" class="form-control" readonly>${board.content}</textarea>	<!-- 쌍태그는 값을 value 말고 쌍태그 사이에 넣는다. -->
	    </div>
	    <c:if test="${fList.size() != 0}">
		    <div class="form-group">
		      <label for="cotent">첨부파일</label>
		      <c:forEach items="${fList}" var="file">
		      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
		      </c:forEach>
		    </div>
	    </c:if>
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
	  	<h1>존재하지 않는 게시글 입니다.</h1>
	  </c:if>
	</div>
	<a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&search=${cri.search}&type=${cri.type}"><button type="button" class="btn btn-outline-dark">목록</button></a>
	<a href="<%=request.getContextPath()%>/board/register"><button type="button" class="btn btn-outline-dark">글쓰기</button></a>
	<c:if test="${user != null && user.id == board.writer}">
	<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn btn-outline-dark">게시글 수정</button></a>
	<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn btn-outline-dark">삭제</button></a>
	</c:if>
	
	<script type="text/javascript">
		// 추천/비추천 버튼 클릭시 ajax로 아이디와 게시글 번호, 추천값을 서버에 전달 url : /board/like
		$('.btn.up, .btn.down').click(function(){
			var id = '${user.id}'; // 세션에있는 유저정보
			if(id == ''){
				alert('회원만 추천/비추천이 가능합니다.')
				return;
			}
			var boardNum = $('input[name=num]').val();	// input 태그 중에서 name이 num인 태그의 값을 불러와서 변수 boardNum에 저장
			var up = 0;		// 1 or 0 or -1
			// 추천 버튼을 클릭하면
			if($(this).hasClass('up')){
				// 이미 추천된 게시글을 다시 추천버튼을 눌렀을 때 ( 추천을 해제하는 경우 )
				if($(this).hasClass('btn-success')){
					up = 0;
				}
				else{
					up = 1;
				}
			}
			// 비추천 버튼을 클릭하면
			else{
				if($(this).hasClass('btn-success')){
					up = 0;
				}
				else{
					up = -1;
				}
			}
			var obj = $(this);	// 현재 눌린 버튼을 obj라는 변수에 저장
			var sendData = {'id' : id, 'boardNum' : boardNum, 'up' : up}	// 가져온 3가지의 데이터를 하나로 묶는다.
			$.ajax({
				url : '<%=request.getContextPath()%>/board/like',
				type : 'post',
				data : JSON.stringify(sendData),
				dataType:"json",
		        contentType:"application/json; charset=UTF-8",
				success : function(data){	
					if(up == 0){
						if(obj.hasClass('up')){
							alert('추천을 취소했습니다.');
						}else{
							alert('추천을 취소했습니다.');
						}
						obj.removeClass('btn-success').addClass('btn-outline-success');
					}
					if(up == 1){
						alert('추천했습니다.')
						$('.btn.up, .btn.down').removeClass('btn-success').addClass('btn-outline-success');
						obj.removeClass('btn-outline-success').addClass('btn-success');
					}else if(up == -1){
						alert('비추천했습니다.');
						$('.btn.up, .btn.down').removeClass('btn-success').addClass('btn-outline-success');
						obj.removeClass('btn-outline-success').addClass('btn-success');
					}
				},
				error : function(){
					console.log('추천/비추천 과정에 문제가 있습니다.')
				}
			})
		})
	</script>
	<br>${like}
</body>
</html>


















