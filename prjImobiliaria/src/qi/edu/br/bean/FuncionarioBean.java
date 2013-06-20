package qi.edu.br.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qi.edu.br.dao.FuncionarioDao;
import qi.edu.br.model.Funcionario;

@Stateless
@Local
public class FuncionarioBean {
	public void update(Funcionario obj) throws Exception{
		try {
			FuncionarioDao funcDao = new FuncionarioDao();
			funcDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Funcionario obj) throws Exception{
		try {
			FuncionarioDao funcDao = new FuncionarioDao();
			funcDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(Funcionario obj) throws Exception{
		try {
			FuncionarioDao funcDao = new FuncionarioDao();
			funcDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Funcionario find(Funcionario obj) throws Exception{
		try {
			FuncionarioDao funcDao = new FuncionarioDao();
			Funcionario f = funcDao.consultar(obj);
			return f;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean login(Funcionario obj) throws Exception{
		try {
			FuncionarioDao funcDao = new FuncionarioDao();
			boolean verifica = funcDao.verificaLogin(obj);
			
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
