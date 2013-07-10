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
	
	public Imovel consultarWS(int codigo) throws Exception{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Imovel novo = em.find(Imovel.class, codigo);
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
		String x = ""; 
		
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			/*x="select i from Imovel i where 1 = 1 ";
			if ((!String.valueOf(imovel.getId()).equals("")) && !String.valueOf(imovel.getId()).equals("0"))
				x= x + " and :id = ";// + imovel.getId(); 
			if ((!String.valueOf(imovel.getValor()).equals("")) && !(imovel.getValor() == 0))
				x= " and :valor = ";// + imovel.getValor(); 
			
			if (imovel.getIdTipoImovel() != -1)
				x= " and :idTipoImovel = ";// + imovel.getIdTipoImovel(); 
			
			if (!imovel.getSituacao().equals("-1"))
				x= " and :situacao = ";// + imovel.getSituacao();
			*/
			x = "select i from Imovel i "; 
			Query query = em.createQuery(x);
			
			/*if ((!String.valueOf(imovel.getId()).equals("")) && !String.valueOf(imovel.getId()).equals("0"))
				query.setParameter("id", imovel.getId()); 
			if ((!String.valueOf(imovel.getValor()).equals("")) && !(imovel.getValor() == 0))
				query.setParameter("valor", imovel.getValor()); 
			
			if (imovel.getIdTipoImovel() != -1)
				query.setParameter("idTipoImovel", imovel.getIdTipoImovel()); 
			
			if (!imovel.getSituacao().equals("-1"))
				query.setParameter("situacao", imovel.getSituacao()); 
			*/
			
			List<Imovel> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
			throw e;
		} finally {
			em.close();
		}		
	}
}
