<%@page import="qi.edu.br.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cad.Proposta</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
    
</head>

<%
	qi.edu.br.model.Imovel tp = new qi.edu.br.model.Imovel();
	if (request.getParameter("enviar") != null) {
		tp.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.ImovelBean ibean = new qi.edu.br.bean.ImovelBean();
		tp = ibean.find(tp);  
	}
	
	//Cliente c = (qi.edu.br.model.Cliente) session.getAttribute("cliente");
	//qi.edu.br.bean.ClienteBean cbean = new qi.edu.br.bean.ClienteBean();
	//c = cbean.find(c); 
%>

<body>
	<h2>Cad.Proposta</h2>
 	<hr/> 
	<form action="../cadProposta" method="POST">
	<table>
		<tr>
			<td>Código Imóvel:</td>
			<td><input type="text" name="codImovel" 
				value="<%out.println(tp.getId());%>"/></td>
			<td>Nome do Imóvel:</td>
			<td><input type="text" name="nomeImovel" 
				value="<%out.println(tp.getNome());%>"/></td>
		</tr>
		<tr>
			<td>Nome do Cliente:</td>
			<td><input type="text" name="nomeCliente"
				value="<%//out.println(c.getNome());%>"/></td>
		</tr>
		<tr>
			<td>Valor Proposto:</td>
			<td><input type="text" name="valorProposta"/></td>
		</tr>
		<tr>
			<td>Valor Venda:</td>
			<td><input type="text" name="valorVenda"/></td>
		</tr>
		<tr>
			<td>Tipo:</td>
			<td><input type="text" name="tipo"/></td>
		</tr>
		
		<tr>
			<td>Forma Pamento:</td>
			<td>
				<select name="cbFormaPag">
					<option value="0">Dinheiro a vista</option>
					<option value="1">Cartão de Crédito</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" name="enviar" value="Cadastrar" /></td>
			<td><input class="btn btn-primary" type="reset" name="limpar" value="Limpar" /></td>
		</tr>
	</table>
	</form>
</body>
</html>