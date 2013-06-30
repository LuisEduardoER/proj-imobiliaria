package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.ImovelBean;
import qi.edu.br.model.Imovel;


/**
 * Servlet implementation class consultarFuncionario
 */
@WebServlet("/locImovel")
public class locImovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public locImovel() {
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
			Imovel i = new Imovel();
			i.setId(Integer.parseInt(request.getParameter("codigo")));
			ImovelBean ibean = new ImovelBean();
			List<Imovel> lista = ibean.localizaImovel(i);
			request.getSession().setAttribute("imovel", lista);
			response.sendRedirect("view/locImovel.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
