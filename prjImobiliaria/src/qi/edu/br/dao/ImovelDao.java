package qi.edu.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.Imovel;

public class ImovelDao {
	EntityManagerFactory emf;
	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public ImovelDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}
	
	public void salvar(Imovel imovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(imovel);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void deletar(Imovel imovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Imovel novo = em.find(Imovel.class, imovel.getId());
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
	
	public void atualizar(Imovel imovel) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(imovel);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public Imovel consultar(Imovel imovel) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Imovel novo = em.find(Imovel.class, imovel.getId());
			return novo;
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}
	}
	
	public List<Imovel> localizaImovel(Imovel imovel) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Query query = em.createQuery("select f from Imovel f " + "order by nome");
			return query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}		
	}
}
