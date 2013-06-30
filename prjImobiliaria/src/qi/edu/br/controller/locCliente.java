package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.ClienteBean;
import qi.edu.br.model.Cliente;

/**
 * Servlet implementation class locCliente
 */
@WebServlet("/locCliente")
public class locCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public locCliente() {
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
			Cliente c = new Cliente();
			c.setId(Integer.parseInt(request.getParameter("codigo")));
			ClienteBean cbean = new ClienteBean();
			c = cbean.find(c);
			request.getSession().setAttribute("cliente", c);
			response.sendRedirect("view/locCliente.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
