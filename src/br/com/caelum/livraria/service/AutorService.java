package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	AutorDao dao;
	
	public void adiciona(Autor autor) {
		// poderia ter regras de negocios ou chamas regras de negocio ou validações antes de delegar para o dao persistir
		// como essa classe é um session bean(faz parte do container EJB), quando delegar a chamada para o Dao, será
		// criada uma transação aqui, antes mesmo de chegar até o dao, quem se encarrega de criar a transação é o EJB Container
		// e as configurações do banco no servidor.
		dao.salva(autor);
	}
	
	public List<Autor> todosAutores () {
		return dao.todosAutores();
	}
	
}
