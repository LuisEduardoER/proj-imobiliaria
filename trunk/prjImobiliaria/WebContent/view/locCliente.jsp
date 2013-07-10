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
<script language="javascript" type="text/javascript">  
function validar() {  
      
    var codigo = principal.codigo.value;  
  
    if (codigo == "") {  
        alert('Preencha o campo código do Funcionário.');  
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
	<h2>Localizar Cliente</h2>
 	<hr/> 
	<form name="principal" action="../locCliente" method="POST">
	<table>
		<tr>
			<td>Código:</td>
			<td><input type="text" name="codigo"/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" onclick="validar()" type="button" name="enviar" value="Consultar" /></td>
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
			
			if(session.getAttribute("tipoUsuario") == "1"){
				response.sendRedirect("menuFunc.jsp?msg=excluir");
			}else{
				response.sendRedirect("menuCli.jsp?msg=excluir");
			}
		}
	
		if(session.getAttribute("cliente") != null){
			qi.edu.br.model.Cliente c = new qi.edu.br.model.Cliente();
			c = (qi.edu.br.model.Cliente)session.getAttribute("cliente");
			out.println("<br />");
			out.println("<br />");
			out.println("<br />");
			
			out.println("<table class='table'>");
			
			//out.println("<tr>");
				//out.println("<td>Código:");out.println("<td>");
				//out.println("<td><input type=\'text\' name=\'nome\' value="+f.getId()+" />");out.println("<td>");
			//out.println("</tr>");
			out.println("<tr>");
				out.println("<td>Código:");out.println("</td>");
				out.println("<td>"+c.getId());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Nome:");out.println("</td>");
				out.println("<td>"+c.getNome());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Endereço:");out.println("</td>");
				out.println("<td>"+c.getEndereco()+" N°:"+c.getNumero());out.println("</td>");
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
			out.println("<td>Status");out.println("</td>");
				if(c.getAtivo() == 1){
					out.println("<td> Ativado");out.println("</td>");	
				}else{
					out.println("<td> Desativado");out.println("</td>");
				}
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td><a href=\'locCliente.jsp?alterar=alterar&id="+c.getId()+"\'>Alterar</a>");out.println("</td>");
				out.println("<td><a href=\'locCliente.jsp?excluir=excluir&id="+c.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("</tr>");
			
			out.println("</table>");
			
			session.setAttribute("cliente", null);
		}else{
			//out.println("Funcionário não encontrado");				
		}
	%>
	
</body>
</html>