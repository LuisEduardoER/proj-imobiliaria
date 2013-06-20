<%
	if(request.getParameter("alterar") != null){
			qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
			c.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.ClienteBean cbean = new qi.edu.br.bean.ClienteBean();
			c = cbean.find(c);
			session.setAttribute("verificaCli", "alterar");
			session.setAttribute("clienteAlt", c);
			response.sendRedirect("cadCliente.xhtml");  
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Cliente</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
	<h2>Localizar Cliente</h2>
 	<hr/> 
	<form action="../locCliente" method="POST">
	<table>
		<tr>
			<td>C�digo:</td>
			<td><input type="text" name="codigo"/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" name="enviar" value="Consultar" /></td>
			<td><input class="btn btn-primary" type="reset" name="limpar" value="Limpar" /></td>
		</tr>
	</table>
	</form>
	
	<% 
	
		if(request.getParameter("excluir") != null){
			qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
			c.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.ClienteBean cbean = new qi.edu.br.bean.ClienteBean();
			c = cbean.find(c);
			c.setAtivo(0);
			cbean.update(c);
			out.println("Registro exclu�do com sucesso");
		}
	
		if(session.getAttribute("cliente") != null){
			qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
			c = (qi.edu.br.model.Cliente)session.getAttribute("cliente");
			out.println("<br />");
			out.println("<br />");
			out.println("<br />");
			
			out.println("<table border='1px'>");
			
			//out.println("<tr>");
				//out.println("<td>C�digo:");out.println("<td>");
				//out.println("<td><input type=\'text\' name=\'nome\' value="+f.getId()+" />");out.println("<td>");
			//out.println("</tr>");
			out.println("<tr>");
				out.println("<td>C�digo:");out.println("</td>");
				out.println("<td>"+c.getId());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Nome:");out.println("</td>");
				out.println("<td>"+c.getNome());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Endere�o:");out.println("</td>");
				out.println("<td>"+c.getEndereco()+" N�:"+c.getNumero());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Bairro:");out.println("</td>");
				out.println("<td>"+c.getBairro());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Cep:");out.println("</td>");
				out.println("<td>"+c.getCep());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Renda:");out.println("</td>");
				out.println("<td>"+c.getRenda());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Cpf");out.println("</td>");
				out.println("<td>"+c.getCpf());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Email");out.println("</td>");
				out.println("<td>"+c.getEmail());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Telefone");out.println("</td>");
				out.println("<td>"+c.getTelefone());out.println("</td>");
		out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td><a href=\'locCliente.jsp?alterar=alterar&id="+c.getId()+"\'>Alterar</a>");out.println("</td>");
				out.println("<td><a href=\'locCliente.jsp?excluir=excluir&id="+c.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("</tr>");
			
			out.println("</table>");
			
			session.setAttribute("cliente", null);
		}else{
			//out.println("Funcion�rio n�o encontrado");				
		}
	%>
	
</body>
</html>