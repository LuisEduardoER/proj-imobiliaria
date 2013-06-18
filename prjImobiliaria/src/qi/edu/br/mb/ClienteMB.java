package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import qi.edu.br.bean.ClienteBean;
import qi.edu.br.model.Cliente;
import qi.edu.br.model.Funcionario;

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
			obj.setAtivo(1);
			clienteBean.save(obj);
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
	
	

}
