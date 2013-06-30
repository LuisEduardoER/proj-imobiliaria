package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.FuncionarioBean;
import qi.edu.br.bean.TipoImovelBean;
import qi.edu.br.model.Funcionario;
import qi.edu.br.model.TipoImovel;

/**
 * Servlet implementation class locTipoImovel
 */
@WebServlet("/locTipoImovel")
public class locTipoImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public locTipoImovel() {
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
			TipoImovel tp = new TipoImovel();
			tp.setId(Integer.parseInt(request.getParameter("codigo")));
			TipoImovelBean tpbean = new TipoImovelBean();
			tp = tpbean.find(tp);
			request.getSession().setAttribute("tipoImovel", tp);
			response.sendRedirect("view/locTipoImovel.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
