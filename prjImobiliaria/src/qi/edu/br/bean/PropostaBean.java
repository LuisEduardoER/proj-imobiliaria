package qi.edu.br.bean;

import java.util.ArrayList;

import qi.edu.br.dao.PropostaDao;
import qi.edu.br.model.Proposta;

public class PropostaBean {
	public void update(Proposta obj) throws Exception{
		try {
			PropostaDao propDao = new PropostaDao();
			propDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(Proposta obj) throws Exception{
		try {
			PropostaDao propDao = new PropostaDao();
			propDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(Proposta obj) throws Exception{
		try {
			PropostaDao propDao = new PropostaDao();
			propDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Proposta find(Proposta obj) throws Exception{
		try {
			PropostaDao propDao = new PropostaDao();
			Proposta f = propDao.consultar(obj);
			return f;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<Proposta> findAll() throws Exception{
		try {
			PropostaDao propDao = new PropostaDao();
			ArrayList<Proposta> res = (ArrayList<Proposta>) propDao.findAll();
			return res;
		} catch (Exception e) {
			throw e;
		}
	}
}
