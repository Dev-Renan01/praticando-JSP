<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tela que mostra os erros</title>
</head>
<body>

	<h2>Mensagem de Erro, entre em contato com a equipe de suporde do sistema.</h2>
	
	<%
	out.print(request.getAttribute("msg"));
	%>
	
</body>
</html>