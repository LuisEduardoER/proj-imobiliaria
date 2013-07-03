package qi.edu.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.Cliente;
import qi.edu.br.model.RequisicaoSenha;

public class RequisicaoDao {


	EntityManagerFactory emf;

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public RequisicaoDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}

	public void salvar(RequisicaoSenha requisicao) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(requisicao);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void deletar(RequisicaoSenha requisicao) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			RequisicaoSenha novo = em.find(RequisicaoSenha.class, requisicao.getId());
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
	
	public RequisicaoSenha consultar(RequisicaoSenha requisicao) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			RequisicaoSenha novo = em.find(RequisicaoSenha.class, requisicao.getId());
			return novo;
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void atualizar(RequisicaoSenha requisicao) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(requisicao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public boolean verificaCpf(RequisicaoSenha r) throws Exception {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select cpf from Cliente where cpf = :paramName and id = :paramPass");
			query.setParameter("paramName", r.getCpf());
			query.setParameter("paramPass", r.getIdCliente());
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
	
	public List findAll() throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Query query = em.createQuery("select p from RequisicaoSenha p ");
			
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
