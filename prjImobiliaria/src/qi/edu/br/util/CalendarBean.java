package qi.edu.br.util;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class CalendarBean {

	private Date date1;  
    
    private Date date2;  
      
    private Date date3;  
    
    public CalendarBean(){
    	setDate2(new Date());
    }
    
    public void testar(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Aviso", "Testado com sucesso!"));
    }
      
    public Date getDate1() {  
        return date1;  
    }  
  
    public void setDate1(Date date1) {  
        this.date1 = date1;  
    }  
  
    public Date getDate2() {  
        return date2;  
    }  
  
    public void setDate2(Date date2) {  
        this.date2 = date2;  
    }  
      
    public Date getDate3() {  
        return date3;  
    }  
  
    public void setDate3(Date date3) {  
        this.date3 = date3;  
    } 
}
