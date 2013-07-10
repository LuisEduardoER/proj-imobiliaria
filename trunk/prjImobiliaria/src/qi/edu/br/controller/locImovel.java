package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.ClienteBean;
import qi.edu.br.bean.FuncionarioBean;
import qi.edu.br.bean.ImovelBean;
import qi.edu.br.bean.TipoImovelBean;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.Funcionario;
import qi.edu.br.model.Imovel;
import qi.edu.br.model.TipoImovel;


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
			
			ImovelBean ibean = new ImovelBean();
			i = ibean.find(i);
			request.getSession().setAttribute("Imovel", i); 
			
			//busca o cliente
			Cliente c = new Cliente();
			c.setId(i.getIdCliente());
			
			ClienteBean cbean = new ClienteBean();
			c = cbean.find(c);					
			request.getSession().setAttribute("cliente", c);
			
			//busca o funcionario
			Funcionario f = new Funcionario();
			f.setId(i.getIdFuncionario());
			
			FuncionarioBean fbean = new FuncionarioBean();
			f = fbean.find(f);	
			
			request.getSession().setAttribute("funcionario", f);
			
			//busca o tipo de imovel
			TipoImovel tp = new TipoImovel();
			tp.setId(i.getIdCliente());
			
			TipoImovelBean tpBean = new TipoImovelBean();
			tp = tpBean.find(tp);	
			request.getSession().setAttribute("tipoImovel", tp);
			
			response.sendRedirect("view/locImovel.jsp");
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}

}
