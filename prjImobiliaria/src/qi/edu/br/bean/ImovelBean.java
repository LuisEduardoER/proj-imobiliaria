package qi.edu.br.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qi.edu.br.dao.ImovelDao;
import qi.edu.br.model.Imovel;

@Stateless
@Local
public class ImovelBean {

	public void update(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(Imovel obj) throws Exception{
		try {
			ImovelDao imovelDao = new ImovelDao();
			imovelDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
}
