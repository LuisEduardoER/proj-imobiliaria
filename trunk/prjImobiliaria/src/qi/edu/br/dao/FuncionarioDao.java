package qi.edu.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.Funcionario;

public class FuncionarioDao{

	EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public FuncionarioDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}

	public void salvar(Funcionario funcionario) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(funcionario);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void deletar(Funcionario funcionario) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Funcionario novo = em.find(Funcionario.class, funcionario.getId());
			novo = em.merge(novo);
			em.remove(novo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void atualizar(Funcionario funcionario) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public boolean verificaLogin(Funcionario funcionario) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Query query = em.createQuery("select p from Funcionario p " +
					"where p.usuario = :paramName and p.senha = :paramPass");
			query.setParameter("paramName", funcionario.getUsuario());
			query.setParameter("paramPass", funcionario.getSenha());
			
			List res = query.getResultList();
			
			if (res.isEmpty())
				return false;
			else
				return true;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
	}

}
