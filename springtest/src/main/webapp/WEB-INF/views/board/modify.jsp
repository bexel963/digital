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
	  <h2>�Խñ� ����</h2>
	  <c:if test="${board != null}">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		     <label for="num">��ȣ</label>
		     <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
		  </div>
		  <div class="form-group">
		     <label for="title">����</label>
		     <input type="text" class="form-control" id="title" name="title"  value="${board.title}">
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
	      	 <label for="content">����</label>
		     <textarea class="form-control" id="content" name="content"  >${board.content}</textarea>
		  </div>
		  <div class="form-group">
	        <label>÷������</label>
	        <input type="file" class="form-control" name="fileList"/>
	        <input type="file" class="form-control" name="fileList"/>
	        <input type="file" class="form-control" name="fileList"/>
    	  </div>
		  <c:if test="${fileList.size() != 0}">
		    <div class="form-group">
		      <label for="cotent">���� ÷������</label>
		      <c:forEach items="${fileList}" var="file">
		      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
		      </c:forEach>
		    </div>
	      </c:if>
		  <button type="submit" class="btn btn-outline-info">����</button>
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
		<h1>�������� ���� �Խù��Դϴ�.</h1>
	  </c:if>	 
	  <a href="<%=request.getContextPath()%>/board/list">
		<button type="button" class="btn btn-outline-info">���</button>
	  </a>
	  <a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-info">�۾���</button>
	  </a>
	  <script type="text/javascript">
	  	$(function(){
	  		/* form�±װ� submit�Ǹ� �ش� �Լ��� ���� */
	  		/* 
	  		   - submit()�� return ���� true�̸� submit�� �����ϰ�, false�̸� �������� �ʴ´�.
	  		     ��, return�� true�̸� ������ �����͸� �����ϰ�, false�̸� ������ �����͸� �������� �ʴ´�.
	  		*/
	  		$('form').submit(function(){
	  			// ÷�������� ���ϸ��� �����ͼ� �ֿܼ� ����ϴ� �ڵ� 
	  			/*
	  			var test1 = $('input[name=fileList]').eq(0).val();
	  			var test2 = $('input[name=fileList]').eq(1).val();
	  			var test3 = $('input[name=fileList]').eq(2).val();
	  			console.log('ù��° ���� : ' + test1);
	  			console.log('�ι�° ���� : ' + test2);
	  			console.log('����° ���� : ' + test3);
	  			return false;
	  			*/
	  			
	  			var cnt = 0;
	  			$('input[name=fileList]').each(function(){ // �ݺ��� - ������ �Ӽ��� �ش��ϴ� ��� ������ ��� ����
	  				var fileName = $(this).val()
	  				console.log(fileName);
					// ���ϸ��� �� ���ڿ��� ''�� ���� ������(�߰��� ÷�������� ������) ������ ���� ��Ŵ
	  				if(fileName != ''){
						cnt++;
					}
				})
					console.log(cnt)
					if(cnt == 0){
						return confirm('���õ� ÷�������� �����ϴ�. ���� �Ͻðڽ��ϴ�?');
					}
	  				return true;
	  		});
	  	})
	  </script>
	</div>
	${fileList}
</body>
</html>