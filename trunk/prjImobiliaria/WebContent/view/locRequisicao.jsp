<%
	if(request.getParameter("excluir") != null){
		qi.edu.br.model.RequisicaoSenha r = new qi.edu.br.model.RequisicaoSenha();
		r.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.RequisicaoBean rbean = new qi.edu.br.bean.RequisicaoBean();
		rbean.delete(r);
		
		if(session.getAttribute("tipoUsuario") == "1"){
			response.sendRedirect("menuFunc.jsp?msg=excluir");
		}else{
			response.sendRedirect("menuCli.jsp?msg=excluir");
		}
	}

	if(request.getParameter("email") != null){
		
		qi.edu.br.model.JavaMailApp javaMail = new qi.edu.br.model.JavaMailApp();
		
		qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
		c.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.ClienteBean cbean = new qi.edu.br.bean.ClienteBean();
		c = cbean.find(c);
		javaMail.enviarSenha(c);
		
		//Excluir
		qi.edu.br.model.RequisicaoSenha r = new qi.edu.br.model.RequisicaoSenha();
		r.setId(Integer.parseInt(request.getParameter("idRequi")));
		qi.edu.br.bean.RequisicaoBean rbean = new qi.edu.br.bean.RequisicaoBean();
		rbean.delete(r);
		
		if(session.getAttribute("tipoUsuario") == "1"){
			response.sendRedirect("menuFunc.jsp?msg=requisicao");
		}else{
			response.sendRedirect("menuCli.jsp?msg=requisicao");
		}
	}
%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Localizar Requisicoes</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
<h2>Localizar Requisições</h2>
 <hr/>
 <table class="table">
 	<tr>
 		<td>Cód.Cliente</td>
 		<td>Nome</td>
 		<td>Cpf</td>
 		<td colspan="3">Ações</td>
 	</tr>
<%
	qi.edu.br.model.RequisicaoSenha r = new qi.edu.br.model.RequisicaoSenha();
	qi.edu.br.bean.RequisicaoBean rbean = new qi.edu.br.bean.RequisicaoBean();
	qi.edu.br.bean.ClienteBean cbean = new qi.edu.br.bean.ClienteBean();
	ArrayList<qi.edu.br.model.RequisicaoSenha> lista  = new ArrayList<qi.edu.br.model.RequisicaoSenha>();
	lista = rbean.findAll();
	for(int i = 0; i < lista.size();i++){
		r = lista.get(i);
		
		qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
		c.setId(r.getIdCliente());
		c = cbean.find(c);
		
		out.println("<tr>");
			out.println("<td>"+c.getId());out.println("</td>");
			out.println("<td>"+c.getNome());out.println("</td>");
			out.println("<td>"+c.getCpf());out.println("</td>");
			out.println("<td><a href=\'locRequisicao.jsp?excluir=excluir&id="+r.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("<td><a href=\'locRequisicao.jsp?email=email&id="+c.getId()+"&idRequi="+r.getId()+"\'>Enviar(e-mail)</a>");out.println("</td>");
		out.println("</tr>");
	}
%>
</table>
</body>
</html>