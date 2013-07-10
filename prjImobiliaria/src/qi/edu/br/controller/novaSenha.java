package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.RequisicaoBean;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.JavaMailApp;
import qi.edu.br.model.RequisicaoSenha;

/**
 * Servlet implementation class novaSenha
 */
@WebServlet("/novaSenha")
public class novaSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public novaSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			RequisicaoSenha r = new RequisicaoSenha();
			r.setCpf(request.getParameter("cpf"));
			r.setIdCliente(Integer.parseInt(request.getParameter("codigo")));
			RequisicaoBean rbean = new RequisicaoBean();
			boolean verifica = rbean.findPorCpf(r);
			if(verifica == true){
				rbean.save(r);
				request.getSession().setAttribute("requisicao", r);
				
				Cliente c = new Cliente();
				c.setId(r.getIdCliente());
				JavaMailApp j = new JavaMailApp();
				j.enviarSenha(c);
				
				//Aqui colocar sintaxe do tipo, se necessário
				response.sendRedirect("view/novaSenha.jsp?correto=correto");
			}else{
				//Aqui colocar sintaxe do tipo, se necessário
				response.sendRedirect("view/novaSenha.jsp?erro=erro");
			}
			
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
