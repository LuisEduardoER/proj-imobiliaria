package qi.edu.br.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import qi.edu.br.dao.RequisicaoDao;
import qi.edu.br.model.RequisicaoSenha;

@Stateless
@Local
public class RequisicaoBean {
	public void update(RequisicaoSenha obj) throws Exception{
		try {
			RequisicaoDao requiDao = new RequisicaoDao();
			requiDao.atualizar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void delete(RequisicaoSenha obj) throws Exception{
		try {
			RequisicaoDao requiDao = new RequisicaoDao();
			requiDao.deletar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	public void save(RequisicaoSenha obj) throws Exception{
		try {
			RequisicaoDao requiDao = new RequisicaoDao();
			requiDao.salvar(obj);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public RequisicaoSenha find(RequisicaoSenha obj) throws Exception{
		try {
			RequisicaoDao requiDao = new RequisicaoDao();
			RequisicaoSenha f = requiDao.consultar(obj);
			return f;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean findPorCpf(RequisicaoSenha obj) throws Exception{
		try {
			RequisicaoDao rDao = new RequisicaoDao();
			boolean verifica = rDao.verificaCpf(obj);
			if(verifica == true){
				return true;	
			}else{
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<RequisicaoSenha> findAll() throws Exception{
		try {
			RequisicaoDao rDao = new RequisicaoDao();
			ArrayList<RequisicaoSenha> res = (ArrayList<RequisicaoSenha>) rDao.findAll();
			return res;
		} catch (Exception e) {
			throw e;
		}
	}
}
