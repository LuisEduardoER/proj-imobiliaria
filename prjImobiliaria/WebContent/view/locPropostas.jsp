<%
	if(request.getParameter("excluir") != null){
		qi.edu.br.model.Proposta p = new qi.edu.br.model.Proposta();
		p.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.PropostaBean pbean = new qi.edu.br.bean.PropostaBean();
		pbean.delete(p);
		
		if(session.getAttribute("tipoUsuario") == "1"){
			response.sendRedirect("menuFunc.jsp?msg=excluir");
		}else{
			response.sendRedirect("menuCli.jsp?msg=excluir");
		}
	}

	if(request.getParameter("email") != null){
		qi.edu.br.model.Proposta p = new qi.edu.br.model.Proposta();
		p.setId(Integer.parseInt(request.getParameter("id")));
		qi.edu.br.bean.PropostaBean pbean = new qi.edu.br.bean.PropostaBean();
		p = pbean.find(p);
		qi.edu.br.model.JavaMailApp javaMail = new qi.edu.br.model.JavaMailApp();
		
		javaMail.enviarEmail(p);
		
		out.println("<h2>E-mail enviado com sucesso</h2>");
		
		/*pbean.delete(p);
		
		if(session.getAttribute("tipoUsuario") == "1"){
			response.sendRedirect("menuFunc.jsp?msg=excluir");
		}else{
			response.sendRedirect("menuCli.jsp?msg=excluir");
		}*/
	}
%>
<%@page import="java.util.ArrayList" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Localizar Propostas</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
<h2>Localizar Propostas</h2>
 <hr/>
 <table class="table">
 	<tr>
 		<td>Cód.Imóvel</td>
 		<td>Valor de Venda</td>
 		<td>Valor Proposto</td>
 		<td>Tipo</td>
 		<td>Cód.Cliente</td>
 		<td>Forma de Pag.</td>
 		<td colspan="3">Ações</td>
 	</tr>
<%
	qi.edu.br.model.Proposta p = new qi.edu.br.model.Proposta();
	qi.edu.br.bean.PropostaBean pbean = new qi.edu.br.bean.PropostaBean();
	ArrayList<qi.edu.br.model.Proposta> lista  = new ArrayList<qi.edu.br.model.Proposta>();
	lista = pbean.findAll();
	for(int i = 0; i < lista.size();i++){
		p = lista.get(i);
		out.println("<tr>");
			out.println("<td>"+p.getIdImovel());out.println("</td>");
			out.println("<td>"+p.getValorVenda());out.println("</td>");
			out.println("<td>"+p.getValorProposto());out.println("</td>");
			out.println("<td>"+p.getTipo());out.println("</td>");
			out.println("<td>"+p.getIdCliente());out.println("</td>");
			String formaPag;
			
			if (p.getFormaPag() == 0){
				formaPag = "Dinheiro a vista";
			} else {
				formaPag = "Cartão de Crédito";
			}
			out.println("<td>"+ formaPag);out.println("</td>");
			out.println("<td><a href=\'locPropostas.jsp?excluir=excluir&id="+p.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("<td><a href=\'locPropostas.jsp?email=email&id="+p.getId()+"\'>Enviar(e-mail)</a>");out.println("</td>");
		out.println("</tr>");
	}
%>
</table>
</body>
</html>