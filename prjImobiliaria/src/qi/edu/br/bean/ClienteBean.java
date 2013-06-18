package qi.edu.br.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qi.edu.br.dao.ClienteDao;
import qi.edu.br.model.Cliente;

@Stateless
@Local
public class ClienteBean {
	public void update(Cliente obj) throws Exception{
		try {
			ClienteDao cliDao = new ClienteDao();
			cliDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Cliente obj) throws Exception{
		try {
			ClienteDao cliDao = new ClienteDao();
			cliDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(Cliente obj) throws Exception{
		try {
			ClienteDao cliDao = new ClienteDao();
			cliDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean login(Cliente obj) throws Exception{
		try {
			ClienteDao cliDao = new ClienteDao();
			boolean verifica = cliDao.verificaLogin(obj);
			if(verifica == true){
				return true;	
			}else{
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
