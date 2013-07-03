package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import qi.edu.br.bean.ClienteBean;
import qi.edu.br.bean.FuncionarioBean;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.Funcionario;

@ManagedBean
@ViewScoped
public class LoginMB {
	@EJB
	ClienteBean clienteBean;
	@EJB
	FuncionarioBean funcionarioBean;
	
	String usuario;
	String senha;
	String tipo;
	String msgAviso;
	public void logar() {
		try {
			if(Integer.parseInt(tipo) == 1){
				Funcionario f = new Funcionario();
				f.setUsuario(usuario);
				f.setSenha(senha);
				boolean verifica = funcionarioBean.login(f);
				if(verifica == true){
					FacesContext ctx = FacesContext.getCurrentInstance();  
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuFunc.jsp");  
					ctx.getExternalContext().redirect(url);
					HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
					session.setAttribute("tipoUsuario", "1");
				}else{
					this.setMsgAviso("Usuário Inválido!");
				}
			}else{
				Cliente c = new Cliente();
				c.setCpf(usuario);
				c.setSenha(senha);
				boolean verifica = clienteBean.login(c);
				if(verifica == true){
					FacesContext ctx = FacesContext.getCurrentInstance();  
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuCli.jsp");  
					ctx.getExternalContext().redirect(url);
					HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
					session.setAttribute("tipoUsuario", "0");
					session.setAttribute("cliente", c);
				}else{
					this.setMsgAviso("Usuário Inválido!");
				}
			}
			
		} catch (Exception e) {
			
		}
		
	}
	
	private void setMessage(String objMsg, String message){
		  FacesMessage msg = new FacesMessage(message);
		  /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
		  FacesContext.getCurrentInstance().addMessage(objMsg, msg);
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMsgAviso() {
		return msgAviso;
	}
	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}
}
