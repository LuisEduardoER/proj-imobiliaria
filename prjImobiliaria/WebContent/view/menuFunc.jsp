<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Funcionario</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
	<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
<table>
	<tr>
 			<td colspan="2"><h2>Funcion�rio</h2></td>
 		</tr>
 		<tr>
 			<td>
 				<ul>
 					<li><a href="cadCliente.xhtml">Cadastrar Cliente</a></li>
 					<li><a href="cadFuncionario.xhtml">Cadastrar Funcion�rio</a></li>
 					<li><a href="cadImovel.xhtml">Cadastrar Im�vel</a></li>
 					<li><a href="cadTipoImovel.xhtml">Cadastrar Tipo de Im�vel</a></li>
 					<li><a href="cadProposta.jsp">Cadastrar Propostas</a></li>
 				</ul>
 			</td>
 			<td></td>
 			<td style="border-left : 1px solid;">
 				<ul>
 					<li><a href="locImovel.jsp">Localizar Im�vel</a></li>
 					<li><a href="locCliente.jsp">Localizar Cliente</a></li>
 					<li><a href="locFuncionario.jsp">Localizar Funcion�rio</a></li>
 					<li><a href="locTipoImovel.jsp">Localizar Tipo de Im�vel</a></li>
 					<li><a href="locPropostas.jsp">Localizar Propostas</a></li>
 					<li><a href="locRequisicao.jsp">Localizar Requisi��es</a></li>
				</ul>
 			</td>
 		</tr>
	</table>
	
	<%
		if(request.getParameter("msg") != null){
			String msg = request.getParameter("msg");
			if(msg.equals("cadastrar")){
				out.println("<h2> Cadastro Realizado com Sucesso </h2>");	
			}
			
			if(msg.equals("alterar")){
				out.println("<h2> Cadastro Alterado com Sucesso </h2>");	
			}
			
			if(msg.equals("excluir")){
				out.println("<h2> Registro Exclu�do com Sucesso </h2>");	
			}
			if(msg.equals("requisicao")){
				out.println("<h2> Nova senha gerada e enviada ao email do solicitante. </h2>");	
			}
		}
	%>
</body>
</html>