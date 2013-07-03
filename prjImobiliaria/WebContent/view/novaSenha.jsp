<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Senha</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
	<h2>Nova Senha</h2>
 	<hr/>
 	<form action="../novaSenha" method="POST">
	<table>
		<tr>
			<td>Cpf Cliente:</td>
			<td><input type="text" name="cpf" /></td>
		</tr>
		<tr>
			<td>Código:</td>
			<td><input type="text" name="codigo"/></td>
		</tr>
		<tr>
			<td colspan='2'><input class="btn btn-primary" type="submit" name="enviar" value="Registrar" /></td>
		</tr>
	</table>
	</form> 
	
	<%
		if(request.getParameter("erro") != null){
			out.println("<h2>Informações não conferem.</h2>");
		}
		if(request.getParameter("correto") != null){
			out.println("<h2>Solicitação enviada com sucesso!.</h2>");
		}
	%>
</body>
</html>