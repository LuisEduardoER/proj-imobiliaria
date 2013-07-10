<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (request.getParameter("alterar") != null) {
		qi.edu.br.model.Imovel tp = new qi.edu.br.model.Imovel();
		tp.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.ImovelBean tpbean = new qi.edu.br.bean.ImovelBean();
		tp = tpbean.find(tp);
		session.setAttribute("verificaImovel", "alterar");
		session.setAttribute("imovelAlt", tp);
		response.sendRedirect("cadImovel.xhtml");

	}

	if (request.getParameter("enviar") != null) {
		qi.edu.br.model.Imovel tp = new qi.edu.br.model.Imovel();
		tp.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.ImovelBean tpbean = new qi.edu.br.bean.ImovelBean();
		tp = tpbean.find(tp);
		session.setAttribute("imovel", tp);

	}
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Imóvel</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css"
	type="text/css" />
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/dbImovel" user="root" password=""
	scope="session" />

<script language="javascript" type="text/javascript">  
function validar() {  
      
    var codigo = principal.codigo.value;  
    
    if (codigo == "") {  
        alert('Campo em vermelho de preenchimento obrigatório.');  
        principal.codigo.focus();  
        return false;  
	} if (isNaN(codigo)){
		alert('Preencha o campo com somente números.');  
        principal.codigo.focus();  
        return false;  
	} else {
		document.forms[0].submit();
	}  
	
} 
</script>

</head>
<body>
	<h2>Localizar Imóvel</h2>
	<hr />
	<form name="principal" action="../locImovel" method="POST">
		<table>
			<tr>
				<td><font color="red">Código:</font></td>
				<td><input type="text" name="codigo" /></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="button" name="enviar"
					value="Consultar" onclick="validar()" /></td>
				<td><input class="btn btn-primary" type="reset" name="limpar"
					value="Limpar" /></td>
			</tr>
		</table>
	</form>

	<%
		if (request.getParameter("excluir") != null) {
			qi.edu.br.model.Imovel tp = new qi.edu.br.model.Imovel();
			tp.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.ImovelBean ibean = new qi.edu.br.bean.ImovelBean();
			tp = ibean.find(tp);
			tp.setAtivo("0");
			ibean.update(tp);

			if (session.getAttribute("tipoUsuario") == "1") {
				response.sendRedirect("menuFunc.jsp?msg=excluir");
			} else {
				response.sendRedirect("menuCli.jsp?msg=excluir");
			}
		}

		if (session.getAttribute("Imovel") != null) {
			//ArrayList<qi.edu.br.model.Imovel> i;

			//i = (ArrayList<qi.edu.br.model.Imovel>) session
					//.getAttribute("Imovel"); //(List<qi.edu.br.model.Imovel>) 

			out.println("<table class='table' width='300px' height='90px'>");

			out.println("<br />");
			out.println("<br />");
			out.println("<br />");
			qi.edu.br.model.Imovel tp = (qi.edu.br.model.Imovel) session.getAttribute("Imovel");

			//for (qi.edu.br.model.Imovel tp : i) {

				out.println("<tr>");
				out.println("<td>Código:");
				out.println("</td>");
				out.println("<td>" + tp.getId());
				out.println("</td>");
				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Nome:");
				out.println("</td>");
				out.println("<td>" + tp.getNome());
				out.println("</td>");
				out.println("</tr>");

				if (session.getAttribute("tipoImovel") != null) {
					qi.edu.br.model.TipoImovel ti = (qi.edu.br.model.TipoImovel) session.getAttribute("tipoImovel");
					
					out.println("<tr>");
					out.println("<td>Tipo:");
					out.println("</td>");
					out.println("<td>" + ti.getDescricao());
					out.println("</td>");
					out.println("</tr>");
				}
				out.println("<tr>");
				out.println("<td>Situação:");
				out.println("</td>");
				switch (Integer.parseInt(tp.getSituacao())) {
				case 0:
					out.println("<td> Planta </td>");
					break;
				case 1:
					out.println("<td> Novo </td>");
					break;
				case 2:
					out.println("<td> Usado </td>");
					break;
				}

				out.println("</tr>");

				out.println("<tr>");
				out.println("<td>Valor:");
				out.println("</td>");
				out.println("<td>" + tp.getValor());
				out.println("</td>");
				out.println("</tr>");
				
				if (session.getAttribute("cliente") != null) {
					qi.edu.br.model.Cliente c = (qi.edu.br.model.Cliente) session.getAttribute("cliente");
					
					out.println("<tr>");
					out.println("<td>Cliente:");
					out.println("</td>");
					out.println("<td>" + c.getNome());
					out.println("</td>");
					out.println("</tr>");
				}
				
				if (session.getAttribute("funcionario") != null) {
					qi.edu.br.model.Funcionario f = (qi.edu.br.model.Funcionario) session.getAttribute("funcionario");
					
					out.println("<tr>");
					out.println("<td>Funcionário:");
					out.println("</td>");
					out.println("<td>" + f.getNome());
					out.println("</td>");
					out.println("</tr>");
				}

				out.println("<tr>");
				out.println("<td><a href=\'locImovel.jsp?alterar=alterar&id="
						+ tp.getId() + "\'>Alterar</a>");
				out.println("</td>");
				out.println("<td><a href=\'locImovel.jsp?excluir=excluir&id="
						+ tp.getId() + "\'>Excluir</a>");
				out.println("</td>");
				out.println("</td>");
				out.println("<td><a href=\'cadProposta.jsp?enviar=enviar&id="
						+ tp.getId() + "\'>Enviar Proposta</a>");
				out.println("</td>");
				out.println("</tr>");
			//}

			out.println("</table>");

			session.setAttribute("Imovel", null);

		} else {
		}
	%>

</body>
</html>