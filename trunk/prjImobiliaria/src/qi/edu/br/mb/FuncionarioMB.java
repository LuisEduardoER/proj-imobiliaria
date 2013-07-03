package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import qi.edu.br.bean.FuncionarioBean;
import qi.edu.br.model.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioMB {
	@EJB
	FuncionarioBean funcionarioBean;
	
	String id;
	String nome;
	String foto;
	String usuario;
	String senha;
	String ativo;
	String msgAviso;
	String alterar;
	String val;
	String status;
	
	public FuncionarioMB() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if(session.getAttribute("verificaFunc")!= null){
			Funcionario fun;
			fun = new Funcionario();
			fun = (Funcionario) session.getAttribute("funcionarioAlt");
			this.setNome(fun.getNome());
			this.setFoto(fun.getFoto());
			this.setUsuario(fun.getUsuario());
			this.setSenha(fun.getSenha());
			this.setId(String.valueOf(fun.getId()));
			this.setAlterar("1");
			this.setStatus(String.valueOf(fun.getAtivo()));
			session.removeAttribute("verificaFunc");
		}
		//this.setMsgAviso("id ->!"+fun.getNome());
	}
	
	public void save() {
		Funcionario obj;
		try {
			validation();
			obj = new Funcionario();
			obj.setFoto(foto);
			obj.setNome(nome);
			obj.setSenha(senha);
			obj.setUsuario(usuario);
			obj.setAtivo(Integer.parseInt(status));
			
			if(alterar != null){
				obj.setId(Integer.parseInt(id));
				funcionarioBean.update(obj);
				
				FacesContext ctx = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
				if(session.getAttribute("tipoUsuario") == "1"){
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuFunc.jsp?msg=alterar");  
					ctx.getExternalContext().redirect(url);
				}else{
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuCli.jsp?msg=alterar");  
					ctx.getExternalContext().redirect(url);
				}
				
			}else{
				funcionarioBean.save(obj);
				FacesContext ctx = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
				if(session.getAttribute("tipoUsuario") == "1"){
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuFunc.jsp?msg=cadastrar");  
					ctx.getExternalContext().redirect(url);
				}else{
					String url = ctx.getExternalContext().encodeResourceURL("http://localhost:8080/prjImobiliaria/view/menuCli.jsp?msg=cadastrar");  
					ctx.getExternalContext().redirect(url);
				}
			}
			
		} catch (Exception e) {
			setMessage("msgErro", e.getMessage());
		}
		
	}
	private void setMessage(String objMsg, String message){
		  FacesMessage msg = new FacesMessage(message);
		  /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
       FacesContext.getCurrentInstance().addMessage(objMsg, msg);
	}
	
	private void validation() throws Exception {
		if (this.getNome() == ""){
			throw new Exception("Informe o Nome");
		}
		if (this.getFoto() == ""){
			throw new Exception("Informe o caminho da foto");
		}
		
		if (this.getSenha() == ""){
			throw new Exception("Informe a Senha");
		}
		
		if (this.getUsuario() == ""){
			throw new Exception("Informe o Usuário");
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getMsgAviso() {
		return msgAviso;
	}
	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}
	public String getAlterar() {
		return alterar;
	}
	public void setAlterar(String alterar) {
		this.alterar = alterar;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
