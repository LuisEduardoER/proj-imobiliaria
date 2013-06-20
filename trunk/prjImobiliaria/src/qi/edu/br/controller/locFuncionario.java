package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import qi.edu.br.bean.FuncionarioBean;
import qi.edu.br.model.Funcionario;


/**
 * Servlet implementation class consultarFuncionario
 */
@WebServlet("/locFuncionario")
public class locFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public locFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Funcionario f = new Funcionario();
			f.setId(Integer.parseInt(request.getParameter("codigo")));
			FuncionarioBean fbean = new FuncionarioBean();
			f = fbean.find(f);
			request.getSession().setAttribute("funcionario", f);
			response.sendRedirect("view/locFuncionario.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
