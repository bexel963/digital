<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <!-- 
 	�̸��� input�±׿� �Է¹޾� ������ �����Ͽ� �������� ���۵� �̸��� �ֿܼ� ����ϼ���. ��, �����͸� ������
    ������ �̸��� name���� �����ϼ���. �����͸� get���� ������, ���� url�� /test2  
 -->
 <form action="<%=request.getContextPath()%>/test2" method="get">
 	<h1>����1</h1>
 	<input type="text" name="name"><button type="submit">����</button>
 </form>
 
 <!-- 
 	�л� �̸��� ���̸� input �±׿� �Է¹޾� ������ �����Ͽ� ������ �ش� �л� ������ ��� �ϼ���.
 	��, ��Ʈ�ѷ����� TestVo�� �̿��Ͽ� ����ϼ���. url�� /test3, mv.setViewName("/main/test2);�� ����
 -->
 <form action="<%=request.getContextPath()%>/test3" method="get">
 	<h1>����2</h1>
 	�̸� : <input type="text" name="name"><br>
 	���� : <input type="text" name="age">
 	<button type="submit">����</button>
 </form>
 
 <!-- 
 	�л� 3���� �̸��� input�±׿� �Է¹޾� ������ �����Ͽ� �������� �ش� �л� �̸����� ����ϼ���.
 	��, ��Ʈ�ѷ������� �л� �̸����� �迭�� ó���ϼ���.
 	url�� /test4��, mv.setViewName("/main/test2");�� ����
 -->
 <form action="<%=request.getContextPath()%>/test4" method="get">
 	<h1>����3</h1>
 	<label>�л�1</label>
 	<input type="text" name="name"><br>
 	<label>�л�2</label>
 	<input type="text" name="name"><br>
 	<label>�л�3</label>
 	<input type="text" name="name">
 	<button type="submit">����</button>
 </form>
 
  <!-- 
 	�л� 3���� �̸��� input�±׿� �Է¹޾� ������ �����Ͽ� �������� �ش� �л� �̸����� ����ϼ���.
 	��, ��Ʈ�ѷ������� �л� �̸����� �ϳ��� ���ڿ��� ó���ϼ���.
 	url�� /test5��, mv.setViewName("/main/test2");�� ����
 -->
 <form action="<%=request.getContextPath()%>/test5" method="get">
 	<h1>����4</h1>
 	<label>�л�1</label>
 	<input type="text" name="name"><br>
 	<label>�л�2</label>
 	<input type="text" name="name"><br>
 	<label>�л�3</label>
 	<input type="text" name="name">
 	<button type="submit">����</button>
 </form>
</body>
</html>