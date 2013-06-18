package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import qi.edu.br.bean.TipoImovelBean;
import qi.edu.br.model.TipoImovel;

@ManagedBean
@ViewScoped
public class TipoImovelMB {
	@EJB
	TipoImovelBean tipoImovelBean;
	String id;
	String descricao;
	String msgAviso;
	
	public void save() {
		TipoImovel obj;
		try {
			obj = new TipoImovel();
			obj.setDescricao(descricao);
			tipoImovelBean.save(obj);
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMsgAviso() {
		return msgAviso;
	}
	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}
	
	
}
