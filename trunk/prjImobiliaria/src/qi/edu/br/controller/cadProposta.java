package qi.edu.br.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qi.edu.br.bean.PropostaBean;
import qi.edu.br.dao.ClienteDao;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.Proposta;

/**
 * Servlet implementation class cadProposta
 */
@WebServlet("/cadProposta")
public class cadProposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadProposta() {
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
			Proposta p = new Proposta();
			p.setIdCliente(Integer.parseInt(request.getParameter("cbNomeCliente")));
			p.setIdImovel(Integer.parseInt(request.getParameter("codImovel")));
			p.setTipo(request.getParameter("tipo"));
			p.setValorProposto(Double.parseDouble(request.getParameter("valorProposta")));
			p.setValorVenda(Double.parseDouble(request.getParameter("valorVenda")));
			p.setFormaPag(Integer.parseInt(request.getParameter("cbFormaPag")));
			PropostaBean pbean = new PropostaBean();
			pbean.save(p);			
			
			if(request.getSession().getAttribute("tipoUsuario") == "1"){
				response.sendRedirect("view/menuFunc.jsp?msg=cadastrar");
			}else{
				response.sendRedirect("view/menuFunc.jsp?msg=cadastrar");
			}
			
		} catch (Exception e) {			
			out.println(e.toString());
		}
	}
	
	public List<Cliente> getListaCliente() throws Exception { //
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> resultado = (List<Cliente>) clienteDao.findAll();

        for (Cliente cliente : resultado) {
            lista.add(cliente);
        }
        
        return lista;
    }

}
