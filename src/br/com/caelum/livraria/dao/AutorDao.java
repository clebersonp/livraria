package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) // esse já é o padrao para o ejb container, nesse caso é opcional
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado...");
	}
	
//	@TransactionAttribute(TransactionAttributeType.REQUIRED) // esse já é o padrao para o ejb container, nesse caso é opcional
	@TransactionAttribute(TransactionAttributeType.MANDATORY) // o container espera uma transação aberta de quem for chama-lo, caso contrario lançará uma exception
	public void salva(Autor autor) { 
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
		
//		try {
//			Thread.sleep(20000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		manager.persist(autor);
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return manager.find(Autor.class, autorId);
		
	}
	
}
