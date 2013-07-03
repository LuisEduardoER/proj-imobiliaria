package qi.edu.br.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import qi.edu.br.bean.TipoImovelBean;
import qi.edu.br.model.TipoImovel;

@ManagedBean
@ViewScoped
public class TipoImovelMB {
	@EJB
	TipoImovelBean tipoImovelBean;
	String id;
	String descricao;
	String status;
	String msgAviso;
	String alterar;
	
	public TipoImovelMB() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if(session.getAttribute("verificaTipoImovel")!= null){
			TipoImovel tpi;
			tpi = new TipoImovel();
			tpi = (TipoImovel) session.getAttribute("tipoImovelAlt");
			this.setDescricao(tpi.getDescricao());
			this.setId(String.valueOf(tpi.getId()));
			this.setStatus(String.valueOf(tpi.getAtivo()));
			this.setAlterar("1");
			session.removeAttribute("verificaTipoImovel");
		}
	}
	
	public void save() {
		TipoImovel obj;
		try {
			validation();
			obj = new TipoImovel();
			obj.setDescricao(descricao);
			obj.setAtivo(Integer.parseInt(status));

			if(alterar != null){
				obj.setId(Integer.parseInt(id));
				tipoImovelBean.update(obj);
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
				tipoImovelBean.save(obj);
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
	
	private void validation() throws Exception {
		if (this.getDescricao() == ""){
			throw new Exception("Informe a Descricao");
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
