<%
	if(request.getParameter("alterar") != null){
			qi.edu.br.model.Funcionario f = new qi.edu.br.model.Funcionario();
			f.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.FuncionarioBean fbean = new qi.edu.br.bean.FuncionarioBean();
			f = fbean.find(f);
			session.setAttribute("verificaFunc", "alterar");
			session.setAttribute("funcionarioAlt", f);
			response.sendRedirect("cadFuncionario.xhtml");  
			
		}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Funcionário</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
</head>
<body>
	<h2>Localizar Funcionário</h2>
 	<hr/> 
	<form action="../locFuncionario" method="POST">
	<table>
		<tr>
			<td>Código:</td>
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
			qi.edu.br.model.Funcionario f = new qi.edu.br.model.Funcionario();
			f.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.FuncionarioBean fbean = new qi.edu.br.bean.FuncionarioBean();
			f = fbean.find(f);
			f.setAtivo(0);
			fbean.update(f);
			
			if(session.getAttribute("tipoUsuario") == "1"){
				response.sendRedirect("menuFunc.jsp?msg=excluir");
			}else{
				response.sendRedirect("menuCli.jsp?msg=excluir");
			}
		}

		if(session.getAttribute("funcionario") != null){
			qi.edu.br.model.Funcionario f = new qi.edu.br.model.Funcionario();
			f = (qi.edu.br.model.Funcionario)session.getAttribute("funcionario");
			out.println("<br />");
			out.println("<br />");
			out.println("<br />");
			
			out.println("<table class='table' width='300px' height='90px'>");
			
			//out.println("<tr>");
				//out.println("<td>Código:");out.println("<td>");
				//out.println("<td><input type=\'text\' name=\'nome\' value="+f.getId()+" />");out.println("<td>");
			//out.println("</tr>");
			out.println("<tr>");
				out.println("<td>Código:");out.println("</td>");
				out.println("<td>"+f.getId());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Nome:");out.println("</td>");
				out.println("<td>"+f.getNome());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Usuário");out.println("</td>");
				out.println("<td>"+f.getUsuario());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Foto");out.println("</td>");
				out.println("<td>"+f.getFoto());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Status");out.println("</td>");
				if(f.getAtivo() == 1){
					out.println("<td> Ativado");out.println("</td>");	
				}else{
					out.println("<td> Desativado");out.println("</td>");
				}
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td><a href=\'locFuncionario.jsp?alterar=alterar&id="+f.getId()+"\'>Alterar</a>");out.println("</td>");
				out.println("<td><a href=\'locFuncionario.jsp?excluir=excluir&id="+f.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("</tr>");
			
			out.println("</table>");
			
			session.setAttribute("funcionario", null);
			
		}else{
			//out.println("Funcionário não encontrado");				
		}
	%>
	
</body>
</html>