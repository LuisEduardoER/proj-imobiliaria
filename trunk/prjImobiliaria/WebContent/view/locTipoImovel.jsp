<%
	if(request.getParameter("alterar") != null){
			qi.edu.br.model.TipoImovel tp = new qi.edu.br.model.TipoImovel();
			tp.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.TipoImovelBean tpbean = new qi.edu.br.bean.TipoImovelBean();
			tp = tpbean.find(tp);
			session.setAttribute("verificaTipoImovel", "alterar");
			session.setAttribute("tipoImovelAlt", tp);
			response.sendRedirect("cadTipoImovel.xhtml");  
			
		}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Tipo de Imóvel</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" type="text/css" />
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
	<h2>Localizar Tipo de Imóvel</h2>
 	<hr/> 
	<form name="principal" action="../locTipoImovel" method="POST">
	<table>
		<tr>
			<td><font color="red">Código:</font></td>
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
			qi.edu.br.model.TipoImovel tp = new qi.edu.br.model.TipoImovel();
			tp.setId(Integer.parseInt(request.getParameter("id")));
			qi.edu.br.bean.TipoImovelBean tpbean = new qi.edu.br.bean.TipoImovelBean();
			tp = tpbean.find(tp);
			tp.setAtivo(0);
			tpbean.update(tp);
			
			if(session.getAttribute("tipoUsuario") == "1"){
				response.sendRedirect("menuFunc.jsp?msg=excluir");
			}else{
				response.sendRedirect("menuCli.jsp?msg=excluir");
			}
		}

		if(session.getAttribute("tipoImovel") != null){
			qi.edu.br.model.TipoImovel tp = new qi.edu.br.model.TipoImovel();
			tp = (qi.edu.br.model.TipoImovel)session.getAttribute("tipoImovel");
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
				out.println("<td>"+tp.getId());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Descrição:");out.println("</td>");
				out.println("<td>"+tp.getDescricao());out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td>Status");out.println("</td>");
				if(tp.getAtivo() == 1){
					out.println("<td> Ativado");out.println("</td>");	
				}else{
					out.println("<td> Desativado");out.println("</td>");
				}
				
			out.println("</tr>");
			
			out.println("<tr>");
				out.println("<td><a href=\'locTipoImovel.jsp?alterar=alterar&id="+tp.getId()+"\'>Alterar</a>");out.println("</td>");
				out.println("<td><a href=\'locTipoImovel.jsp?excluir=excluir&id="+tp.getId()+"\'>Excluir</a>");out.println("</td>");
			out.println("</tr>");
			
			out.println("</table>");
			
			session.setAttribute("tipoImovel", null);
			
		}else{
			//out.println("Funcionário não encontrado");				
		}
	%>
	
</body>
</html>