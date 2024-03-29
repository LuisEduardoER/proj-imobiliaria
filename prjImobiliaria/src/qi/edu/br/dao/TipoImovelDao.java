package qi.edu.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.TipoImovel;

public class TipoImovelDao {
	EntityManagerFactory emf;
	
	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public TipoImovelDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}
	
	public void salvar(TipoImovel tipoImovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(tipoImovel);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public List<TipoImovel> findAll() throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("select t from TipoImovel t order by descricao");
			return query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void deletar(TipoImovel tipoImovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			TipoImovel novo = em.find(TipoImovel.class, tipoImovel.getId());
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
	
	public TipoImovel consultar(TipoImovel tipoImovel) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			TipoImovel novo = em.find(TipoImovel.class, tipoImovel.getId());
			return novo;
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}
	
	public void atualizar(TipoImovel tipoImovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(tipoImovel);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
