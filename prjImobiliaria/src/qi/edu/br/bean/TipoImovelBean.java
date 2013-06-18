package qi.edu.br.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qi.edu.br.dao.TipoImovelDao;
import qi.edu.br.model.TipoImovel;

@Stateless
@Local
public class TipoImovelBean {
	public void save(TipoImovel obj) throws Exception{
		try {
			TipoImovelDao tipoImovelDao = new TipoImovelDao();
			tipoImovelDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
}
