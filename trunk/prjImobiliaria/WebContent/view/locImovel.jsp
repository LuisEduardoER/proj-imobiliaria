<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (request.getParameter("alterar") != null) {
		qi.edu.br.model.TipoImovel tp = new qi.edu.br.model.TipoImovel();
		tp.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.TipoImovelBean tpbean = new qi.edu.br.bean.TipoImovelBean();
		tp = tpbean.find(tp);
		session.setAttribute("verificaTipoImovel", "alterar");
		session.setAttribute("tipoImovelAlt", tp);
		response.sendRedirect("cadTipoImovel.xhtml");

	}
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
    	scope="session"/>
</head>
<body>
	<h2>Localizar Imóvel</h2>
	<hr />
	<form action="../locImovel" method="POST">
		<table>
			<tr>
				<td>Código:</td>
				<td><input type="text" name="codigo" /></td>
			</tr>

			<tr>
				<td>Data de Cadastro:</td>
				<td><input type="text" name="data" /></td>
			</tr>

			<tr>
				<td>Faixa de Valor:</td>
				<td><input type="text" name="valor" /></td>
			</tr>

			<tr>
				<td>Tipo de Imóvel:</td>
				<td>
					<sql:query var="qryTipoImovel" dataSource="${ds}">
						select * from tipo_Imovel where ativo = 1 order by descricao
		         	</sql:query> 
		         	
		         	<select name="cbTipoImovel">
						<c:forEach var="tipoImovel" items="${qryTipoImovel.rows}">
							<option Value="-1">Todos os Tipos </option>
							<option value="${tipoImovel.id}">${tipoImovel.descricao}</option>
						</c:forEach>
					</select>
				</td>
			</tr>

			<tr>
				<td>Situação do Imóvel:</td>
				<td><select name="situacao">
					<option value="-1">Todas as Situações</option>
					<option value="0">Planta</option>
					<option value="1">Novo</option>
					<option value="2">Usado</option>
				</select></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" name="enviar"
					value="Consultar" /></td>
				<td><input class="btn btn-primary" type="reset" name="limpar"
					value="Limpar" /></td>
			</tr>
		</table>
	</form>

	<%
		if (request.getParameter("excluir") != null) {
			qi.edu.br.model.TipoImovel tp = new qi.edu.br.model.TipoImovel();
			tp.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.TipoImovelBean tpbean = new qi.edu.br.bean.TipoImovelBean();
			tp = tpbean.find(tp);
			tp.setAtivo(0);
			tpbean.update(tp);

			if (session.getAttribute("tipoUsuario") == "1") {
				response.sendRedirect("menuFunc.jsp?msg=excluir");
			} else {
				response.sendRedirect("menuCli.jsp?msg=excluir");
			}
		}

		if (session.getAttribute("Imovel") != null) {
			List<qi.edu.br.model.Imovel> tp;
			tp = session.getAttribute("Imovel"); //(List<qi.edu.br.model.Imovel>) 
			
			for tp
			
			out.println("<br />");
			out.println("<br />");
			out.println("<br />");

			out.println("<table border='1px' width='300px' height='90px'>");

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

			out.println("<tr>");
			out.println("<td>Tipo:");
			out.println("</td>");
			out.println("<td>" + tp.getIdTipoImovel());
			out.println("</td>");
			out.println("</tr>");

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

			out.println("<tr>");
			out.println("<td><a href=\'locImovel.jsp?alterar=alterar&id="
					+ tp.getId() + "\'>Alterar</a>");
			out.println("</td>");
			out.println("<td><a href=\'locImovel.jsp?excluir=excluir&id="
					+ tp.getId() + "\'>Excluir</a>");
			out.println("</td>");
			out.println("</tr>");
			
			

			out.println("</table>");

			session.setAttribute("Imovel", null);

		} else {
		}
	%>

</body>
</html>