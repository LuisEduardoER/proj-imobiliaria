package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import qi.edu.br.bean.ImovelBean;

@ManagedBean
@ViewScoped
public class ImovelMB {

	@EJB
	ImovelBean imovelBean;
	
	private int id;
	private int idCliente;
	private int idFuncionario;
	private int idTipoImovel;
	private String nome;
	private String situacao;
	private String foto_capa;
	private double valor;
	private String descricao;
	private int ativo;
	private String data_imovel;
	String msgAviso;
	
	/*public void save() {
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
		  // Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. 
       FacesContext.getCurrentInstance().addMessage(objMsg, msg);
	}
	
	private void validation() throws Exception {
		if (this.getNome() == ""){
			throw new Exception("Informe o Nome");
		}
	}*/
	
	public ImovelBean getImovelBean() {
		return imovelBean;
	}
	public void setImovelBean(ImovelBean imovelBean) {
		this.imovelBean = imovelBean;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdTipoImovel() {
		return idTipoImovel;
	}
	public void setIdTipoImovel(int idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getFoto_capa() {
		return foto_capa;
	}
	public void setFoto_capa(String foto_capa) {
		this.foto_capa = foto_capa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public String getData_imovel() {
		return data_imovel;
	}
	public void setData_imovel(String data_imovel) {
		this.data_imovel = data_imovel;
	}
	
	
}
