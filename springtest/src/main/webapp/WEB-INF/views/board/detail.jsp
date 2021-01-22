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
	  <h2>게시글 상세</h2>
	  	<c:if test="${board != null}">
	  	<div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
	    </div>
	    <div class="form-group">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">
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
	      <label for="views">조회수</label>
	      <input type="text" class="form-control" id="registerDate" name="views" readonly value="${board.views}">
	    </div>
	    <div class="form-group">
	      <label for="content">내용</label>
	      <textarea class="form-control" id="content" name="content" readonly >${board.content}</textarea>
	    </div>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != 1}">outline-</c:if>primary up">추천</button>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != -1}">outline-</c:if>primary down">비추천</button><br><br>
	    <c:if test="${fileList.size() != 0}">
	      <label for="content">첨부파일</label>
	      <c:forEach items="${fileList}" var="file">
		    <div class="form-group">
		      	<div>
		      		<a href="<%=request.getContextPath()%>/board/download?filename=${file.filename}">${file.oriFilename}</a>
		      	</div> 
		    </div>
		  </c:forEach>
	    </c:if>
		</c:if>
		<c:if test="${board == null}">
			<h1>존재하지 않은 게시물입니다.</h1>
		</c:if>	 
		<a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}">
			<button type="button" class="btn btn-outline-info">목록</button>
		</a>
		<a href="<%=request.getContextPath()%>/board/register">
			<button type="button" class="btn btn-outline-info">글쓰기</button>
		</a>
		<c:if test="${user != null && user.id == board.writer}">
		<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
			<button type="button" class="btn btn-outline-info">수정</button>
		</a>
		<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
			<button type="button" class="btn btn-outline-info">삭제</button>
		</a>
		</c:if>
	</div>
	<script type="text/javascript">
		var up = '${like.up}';
		console.log(up);
		
		$('.btn.up, .btn.down').click(function(){
			// 추천 버튼을 클릭하면
			if($(this).hasClass('up')){
				// 추천상태에서 추천 버튼을 클릭하면
				if(up == 1)
					up = 0;
				// 추천 상태가 아닌 상황에서 추천 버튼을 클릭하면
				else
					up = 1;
			}
			// 비추천 버튼을 클릭하면
			else{
				// 비추천 상태에서 비추천 버튼을 클릭하면
				if(up == -1)
					up = 0;
				// 비추천 상태가 아닌 상황에서 비추천 버튼을 클릭하면
				else
					up = -1;
			}
			// 추천 또는 비추천인 경우
			if( up != 0 ){
				/*
					- 추천/비추천 버튼 모두에 btn-primary클래스 제거, btn-outline-primary클래스 추가 
		  		  	( 일단, 두 버튼 모두에 색상이 안들어 가게 만들어줌 ) 
				*/
				$('.btn.up, .btn.down').removeClass('btn-primary').addClass('btn-outline-primary');
				//- 클릭한 버튼에 btn-primary클래스 추가, btn-outline-primary클래스 제거
				$(this).addClass('btn-primary').removeClass('btn-outline-primary');
			}
			// 추천/비추천을 취소한 경우 ( up이 0인 경우 )
			else{
				//- 클릭한 버튼에 btn-primary클래스 제거, btn-outline-primary클래스 추가
				$(this).removeClass('btn-primary').addClass('btn-outline-primary');
			}
			var id = '${user.id}';
			if( id == ''){
				alert('회원만 추천/비추천이 가능합니다.');
				return;
			}
			var boardNum = $('input[name=num]').val();
			var obj = $(this);
			var sendData = {'id' : id, 'boardNum' : boardNum, 'up' : up};
			$.ajax({
				url : '<%=request.getContextPath()%>/board/like',
				type : 'post',
				data : JSON.stringify(sendData),
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(up == 1){
						alert('추천했습니다.');
					}else if(up == -1){
						alert('비추천 했습니다.');
					}else{
						// 클릭된 버튼이 추천이면 추천이 취소 되었습니다.
						if(obj.hasClass('up'))	// 여기서 $(this)를 쓰면 ajax를 클릭한것이 된다.
							alert('추천이 취소되었습니다.');
						// 아니면 비추천이 취소되었습니다.
						else
							alert('비추천이 취소되었습니다.');
					}
				},
				error : function(){
					console.log('추천/비추천 과정에 문제가 있습니다.');
				}
			})
		})
	</script>
	
</body>
</html>















