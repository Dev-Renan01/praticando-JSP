<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto JSP</title>
</head>
<body>
	<h2>Seja bem vindo(a) ao meu projeto JSP</h2>
	<%
	out.print("Trabalhando com java - JSP");
	%>
	
	<form action="receber-nome.jsp">
	
	<input name="nome">
	<input name="idade">
	
	<input type="submit" value="enviar">
	
	</form>

</body>
</html>