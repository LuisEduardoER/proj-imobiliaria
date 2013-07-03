package qi.edu.br.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.Funcionario;
import qi.edu.br.model.Proposta;

public class PropostaDao {

	EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public PropostaDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}

	public void salvar(Proposta proposta) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(proposta);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void deletar(Proposta proposta) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Proposta novo = em.find(Proposta.class, proposta.getId());
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
	
	public Proposta consultar(Proposta proposta) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Proposta novo = em.find(Proposta.class, proposta.getId());
			return novo;
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void atualizar(Proposta proposta) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(proposta);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public List findAll() throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Query query = em.createQuery("select p from Proposta p ");
			
			List res = query.getResultList();
			
			if (res.isEmpty())
				return res;
			else
				return res;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
	}

}
