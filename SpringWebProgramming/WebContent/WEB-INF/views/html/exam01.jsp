<%@page contentType="text/html;charset=EUC-KR"%>
<!DOCTYPE html>
<html>
	 <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
			<script>
				 function handleBtnNaver() {
							 console.log("handleBtnNaver()...");
							 location.href = "http://www.naver.com";
				 }
				 function handleBtnGoogle() {
							 console.log("handleBtnGoogle()...");
							 location.href = "http://www.google.com";
				 }
			</script>
	 </head>
	 <body>
			<h1>�±� ����</h1>
			<h3>��ũ �±�</h3>
			<A href="http://www.naver.com">���̹�</a><br>
			
			<h3>��ư �±�</h3>
			<button id="btnGoogle" onclick="handleBtnGoogle()">����</button>
			<input type ="button" onclick="handleBtnNaver()" value="���̹�"/>		
			<h3>�̹��� �±�</h3>
			<img src="<%=application.getContextPath()%>/resources/images/penguins.jpg" alt="penguins" height="42" width="42"/>
			<input type="image" src="<%=application.getContextPath()%>/resources/images/penguins.jpg"/>
			
			<h3>�����̳� �±�</h3>
			<div>
				 <img src="<%=application.getContextPath()%>/resources/images/penguins.jpg" alt="penguins" height="42" width="42"/>
				 <button id="btnNaver" onclick="handleBtnNaver()">���̹�</button>
			</div>
			
			<div>
				 <img src="<%=application.getContextPath()%>/resources/images/penguins.jpg" alt="penguins" height="42" width="42"/>
				 <button id="btnNaver" onclick="handleBtnNaver()">���̹�</button>
			</div>
			
			<h3>�� �±�</h3>
			<form>
				 �̸�: <input type="text"/><br/>
				 ����: <input type="number"/><br/>
				 �������: <input type="date"/><br/>
				 ����: <input type="radio" name="sex" />�� <input type="radio" name="sex" /> ��<br/>
				 ���ɺо�:
						<input type="checkbox"/>�ڹ�
						<input type="checkbox"/>�ڹ�FX		
						<input type="checkbox"/>������<br/>	
				 <input type ="button" value="�Ϲݹ�ư"/>
				 <input type ="reset" value="���¹�ư"/>
				 <input type ="submit" value="�����ư"/>
				 
			</form>
	 </body>
</html>
