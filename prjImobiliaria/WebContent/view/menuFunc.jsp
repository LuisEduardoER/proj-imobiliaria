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
 			<td colspan="2"><h2>Funcionário</h2></td>
 		</tr>
 		<tr>
 			<td>
 				<ul>
 					<li><a href="cadCliente.xhtml">Cad.Cliente</a></li>
 					<li><a href="cadFuncionario.xhtml">Cad.Funcionário</a></li>
 					<li><a href="cadImovel.xhtml">Cad.Imóvel</a></li>
 					<li><a href="cadTipoImovel.xhtml">Cad.Tipo de Imóvel</a></li>
 					<li><a href="cadProposta.jsp">Cad.Propostas</a></li>
 				</ul>
 			</td>
 			<td></td>
 			<td style="border-left : 1px solid;">
 				<ul>
 					<li><a href="locImovel.jspl">localizar Imóvel</a></li>
 					<li><a href="locCliente.jsp">localizar Cliente</a></li>
 					<li><a href="locFuncionario.jsp">localizar Funcionário</a></li>
 					<li><a href="locTipoImovel.jsp">localizar Tipo de Imóvel</a></li>
 					<li><a href="locPropostas.jsp">localizar Propostas</a></li>
 					<li><a href="locRequisicao.jsp">localizar Requisições</a></li>
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
				out.println("<h2> Registro Excluído com Sucesso </h2>");	
			}
			if(msg.equals("requisicao")){
				out.println("<h2> Nova senha gerada e enviada ao email do solicitante. </h2>");	
			}
		}
	%>
</body>
</html>