package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import qi.edu.br.bean.ClienteBean;
import qi.edu.br.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteMB {
	@EJB
	ClienteBean clienteBean;
	
	String id; // Chave primária
	String nome;
	String endereco;
	String numero;
	String bairro;
	String cep;
	String complemento;
	String uf;
	String renda;
	String email;
	String telefone;
	String telComercial;
	String cpf;
	String senha;
	String ativo;
	String msgAviso;
	String alterar;
	String status;
	
	public ClienteMB() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if(session.getAttribute("verificaCli")!= null){
			Cliente cli;
			cli = new Cliente();
			cli = (Cliente) session.getAttribute("clienteAlt");
			this.setNome(cli.getNome());
			this.setEndereco(cli.getEndereco());
			this.setNumero(String.valueOf(cli.getNumero()));
			this.setBairro(cli.getBairro());
			this.setCep(cli.getCep());
			this.setComplemento(cli.getComplemento());
			this.setUf(cli.getUf());
			this.setEmail(cli.getEmail());
			this.setRenda(String.valueOf(cli.getRenda()));
			this.setTelefone(cli.getTelefone());
			this.setTelComercial(cli.getTelComercial());
			this.setCpf(cli.getCpf());
			this.setSenha(cli.getSenha());
			this.setAtivo(String.valueOf(cli.getAtivo()));
			this.setStatus(String.valueOf(cli.getAtivo()));
			this.setId(String.valueOf(cli.getId()));
			this.setAlterar("1");
			session.removeAttribute("verificaCli");
		}
		//this.setMsgAviso("id ->!"+fun.getNome());
	}
	public void save() {
		Cliente obj;
		try {
			obj = new Cliente();
			obj.setNome(nome);
			obj.setBairro(bairro);
			obj.setCep(cep);
			obj.setEmail(email);
			obj.setComplemento(complemento);
			obj.setUf(uf);
			obj.setCpf(cpf);
			obj.setEndereco(endereco);
			obj.setNumero(Integer.parseInt(numero));
			obj.setTelComercial(telComercial);
			obj.setRenda(Double.parseDouble(renda));
			obj.setTelefone(telefone);
			obj.setSenha(senha);
			obj.setAtivo(Integer.parseInt(status));
			
			if(alterar != null){
				obj.setId(Integer.parseInt(id));
				clienteBean.update(obj);
				
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
				clienteBean.save(obj);
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getRenda() {
		return renda;
	}
	public void setRenda(String renda) {
		this.renda = renda;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelComercial() {
		return telComercial;
	}
	public void setTelComercial(String telComercial) {
		this.telComercial = telComercial;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
