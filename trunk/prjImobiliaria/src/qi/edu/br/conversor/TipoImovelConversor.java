package qi.edu.br.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import qi.edu.br.model.TipoImovel;

@FacesConverter(value = "tipoImovelConversor", forClass = TipoImovel.class)
public class TipoImovelConversor implements Converter {

	EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public TipoImovelConversor() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}

	EntityManager em = getEntityManager();

	public void findAll() throws Exception {
		try {
			em.getTransaction().begin();
			em.createQuery("select t from TipoImovel t order by descricao");
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {

		try {
			findAll();

			System.out.println("TipoImovel.getAsObject - value: " + value);
			Integer idTipo;
			if (value == null || "".equals(value)) {
				return null;
			}

			// pega o parametro do valor recebido
			String[] tokens = value.split(":");
			String param = tokens[0];
			// transforma o string do parametro em inteiro
			idTipo = Integer.parseInt(param);

			if (param != null) {
				return em.find(TipoImovel.class, idTipo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) throws ConverterException {
		if (object != null && object instanceof TipoImovel) {
			return ((TipoImovel) object).toString();
		}
		return null;
	}
}
