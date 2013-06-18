package qi.edu.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import qi.edu.br.model.Cliente;
import qi.edu.br.model.Funcionario;

public class ClienteDao {
	EntityManagerFactory emf;
	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public ClienteDao() {
		emf = Persistence.createEntityManagerFactory("prjImobiliaria");
	}
	
	public void salvar(Cliente cliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			em.persist(cliente);// permite fazer insercoes e atualizacoes no bd
			em.getTransaction().commit();// realizo as alteracoes no banco
		} catch (Exception e) {
			em.getTransaction().rollback();// se rolar uma excecao cancelo acao
			e.printStackTrace();// mostro o percurso de onde veio as excecoes
		} finally {
			em.close();
		}
	}
	
	public void deletar(Cliente cliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inicia o processo de transacao
			Cliente novo = em.find(Cliente.class, cliente.getId());
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
	
	public void atualizar(Cliente cliente) {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public boolean verificaLogin(Cliente cliente) throws Exception {
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("select cpf,senha from Cliente where cpf = :paramName and senha = :paramPass");
			query.setParameter("paramName", cliente.getCpf());
			query.setParameter("paramPass", cliente.getSenha());
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
