package qi.edu.br.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

//@FacesConverter(value = "converter", forClass = TipoImovel.class)
public class Converter implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
        if (value != null) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;  
    }  
	
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
  
        if (value != null  
                && !"".equals(value)) {  
   
            BaseEntity entity = (BaseEntity) value;  
  
            // adiciona item como atributo do componente  
            this.addAttribute(component, entity);  
  
            long codigo = entity.getId();
            
            if (!String.valueOf(codigo).equals("")) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return (String) value;  
    }  
  
    protected void addAttribute(UIComponent component, BaseEntity o) {  
        String key = String.valueOf(o.getId()); // codigo da empresa como chave neste caso  
        this.getAttributesFrom(component).put(key, o);  
    }  
  
    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }  (*/
}
