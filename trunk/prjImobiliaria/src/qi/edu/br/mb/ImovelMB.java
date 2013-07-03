package qi.edu.br.mb;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;

import qi.edu.br.bean.ImovelBean;
import qi.edu.br.model.Imovel;

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
	private Date data_imovel;
	private String alterar;
	private String msgAviso;
	private String status;

	private List<SelectItem> listaCliente;
	private List<SelectItem> listaFuncionario;
	private List<SelectItem> listaTipoImovel;
	
	public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }

	public ImovelMB() throws Exception {
		super(); 
		imovelBean = new ImovelBean();
		this.listaCliente = imovelBean.getListaCliente();
		
		this.listaFuncionario = imovelBean.getListaFuncionario();
		this.listaTipoImovel = imovelBean.getListaTipoImovel();
	}

	public List<SelectItem> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<SelectItem> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public List<SelectItem> getListaTipoImovel() {
		return listaTipoImovel;
	}

	public void setListaTipoImovel(List<SelectItem> listaTipoImovel) {
		this.listaTipoImovel = listaTipoImovel;
	}

	public List<SelectItem> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<SelectItem> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public void save() {
		Imovel obj;
		try {
			validation();
			obj = new Imovel();
			obj.setData_imovel(new Date());
			obj.setDescricao(descricao);
			obj.setFoto_capa("11");
			obj.setIdCliente(idCliente);
			obj.setIdFuncionario(idFuncionario);
			obj.setIdTipoImovel(idTipoImovel);
			obj.setNome(nome);
			obj.setSituacao(situacao);
			obj.setValor(valor);			
			obj.setAtivo(1);//Integer.parseInt(status));
			
			if(alterar != null){
				obj.setId(id);
				imovelBean.update(obj);
				
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
				imovelBean.save(obj);
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
		  // Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. 
       FacesContext.getCurrentInstance().addMessage(objMsg, msg);
	}
	
	private void validation() throws Exception {
		if (this.getNome() == ""){
			throw new Exception("Informe o Nome");
		}
	}
	
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
	public Date getData_imovel() {
		return data_imovel;
	}
	public void setData_imovel(Date data_imovel) {
		this.data_imovel = data_imovel;
	}
	
	public String getMsgAviso() {
		return msgAviso;
	}

	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
