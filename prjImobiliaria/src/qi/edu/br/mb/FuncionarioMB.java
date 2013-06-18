package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	
	public void save() {
		Funcionario obj;
		try {
			validation();
			obj = new Funcionario();
			obj.setFoto(foto);
			obj.setNome(nome);
			obj.setSenha(senha);
			obj.setUsuario(usuario);
			obj.setAtivo(1);
			funcionarioBean.save(obj);
			//funcionarioBean.delete(obj);
			this.setMsgAviso("Gravação com sucesso!");
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
	

}
