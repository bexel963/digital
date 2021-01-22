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
	  <h2>�Խñ� ��</h2>
	  	<c:if test="${board != null}">
	  	<div class="form-group">
	      <label for="num">��ȣ</label>
	      <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
	    </div>
	    <div class="form-group">
	      <label for="title">����</label>
	      <input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">
	    </div>
	    <div class="form-group">
	      <label for="writer">�ۼ���</label>
	      <input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">
	    </div>
	    <div class="form-group">
	      <label for="registerDate">�ۼ���</label>
	      <input type="text" class="form-control" id="registerDate" name="registerDate" readonly value="${board.registerDate}">
	    </div>
	    <div class="form-group">
	      <label for="views">��ȸ��</label>
	      <input type="text" class="form-control" id="registerDate" name="views" readonly value="${board.views}">
	    </div>
	    <div class="form-group">
	      <label for="content">����</label>
	      <textarea class="form-control" id="content" name="content" readonly >${board.content}</textarea>
	    </div>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != 1}">outline-</c:if>primary up">��õ</button>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != -1}">outline-</c:if>primary down">����õ</button><br><br>
	    <c:if test="${fileList.size() != 0}">
	      <label for="content">÷������</label>
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
			<h1>�������� ���� �Խù��Դϴ�.</h1>
		</c:if>	 
		<a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}">
			<button type="button" class="btn btn-outline-info">���</button>
		</a>
		<a href="<%=request.getContextPath()%>/board/register">
			<button type="button" class="btn btn-outline-info">�۾���</button>
		</a>
		<c:if test="${user != null && user.id == board.writer}">
		<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
			<button type="button" class="btn btn-outline-info">����</button>
		</a>
		<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
			<button type="button" class="btn btn-outline-info">����</button>
		</a>
		</c:if>
	</div>
	<script type="text/javascript">
		var up = '${like.up}';
		console.log(up);
		
		$('.btn.up, .btn.down').click(function(){
			// ��õ ��ư�� Ŭ���ϸ�
			if($(this).hasClass('up')){
				// ��õ���¿��� ��õ ��ư�� Ŭ���ϸ�
				if(up == 1)
					up = 0;
				// ��õ ���°� �ƴ� ��Ȳ���� ��õ ��ư�� Ŭ���ϸ�
				else
					up = 1;
			}
			// ����õ ��ư�� Ŭ���ϸ�
			else{
				// ����õ ���¿��� ����õ ��ư�� Ŭ���ϸ�
				if(up == -1)
					up = 0;
				// ����õ ���°� �ƴ� ��Ȳ���� ����õ ��ư�� Ŭ���ϸ�
				else
					up = -1;
			}
			// ��õ �Ǵ� ����õ�� ���
			if( up != 0 ){
				/*
					- ��õ/����õ ��ư ��ο� btn-primaryŬ���� ����, btn-outline-primaryŬ���� �߰� 
		  		  	( �ϴ�, �� ��ư ��ο� ������ �ȵ�� ���� ������� ) 
				*/
				$('.btn.up, .btn.down').removeClass('btn-primary').addClass('btn-outline-primary');
				//- Ŭ���� ��ư�� btn-primaryŬ���� �߰�, btn-outline-primaryŬ���� ����
				$(this).addClass('btn-primary').removeClass('btn-outline-primary');
			}
			// ��õ/����õ�� ����� ��� ( up�� 0�� ��� )
			else{
				//- Ŭ���� ��ư�� btn-primaryŬ���� ����, btn-outline-primaryŬ���� �߰�
				$(this).removeClass('btn-primary').addClass('btn-outline-primary');
			}
			var id = '${user.id}';
			if( id == ''){
				alert('ȸ���� ��õ/����õ�� �����մϴ�.');
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
						alert('��õ�߽��ϴ�.');
					}else if(up == -1){
						alert('����õ �߽��ϴ�.');
					}else{
						// Ŭ���� ��ư�� ��õ�̸� ��õ�� ��� �Ǿ����ϴ�.
						if(obj.hasClass('up'))	// ���⼭ $(this)�� ���� ajax�� Ŭ���Ѱ��� �ȴ�.
							alert('��õ�� ��ҵǾ����ϴ�.');
						// �ƴϸ� ����õ�� ��ҵǾ����ϴ�.
						else
							alert('����õ�� ��ҵǾ����ϴ�.');
					}
				},
				error : function(){
					console.log('��õ/����õ ������ ������ �ֽ��ϴ�.');
				}
			})
		})
	</script>
	
</body>
</html>















