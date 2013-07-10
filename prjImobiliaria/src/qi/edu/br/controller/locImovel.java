package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
			if (!request.getParameter("codigo").equals(""))
			  i.setId(Integer.parseInt(request.getParameter("codigo")));
			//i.setData_imovel(Date.parse((request.getParameter("data")));
			if (!request.getParameter("valor").equals(""))
				i.setValor(Double.parseDouble(request.getParameter("valor")));
			if (!request.getParameter("cbTipoImovel").equals(""))
				i.setIdTipoImovel(Integer.parseInt(request.getParameter("cbTipoImovel")));
			i.setSituacao(request.getParameter("situacao"));
			
			ImovelBean ibean = new ImovelBean();
			i = ibean.find(i);
			//List<Imovel> lista = ibean.localizaImovel(i);
			request.getSession().setAttribute("Imovel", i); //lista
			response.sendRedirect("view/locImovel.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
