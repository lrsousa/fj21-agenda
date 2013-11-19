package br.com.caelum.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.agenda.modelo.Contato;

@Repository
public class JpaContatoDao implements ContatoDao {

	@PersistenceContext
	EntityManager manager;
	
	public void adiciona(Contato contato) {
		manager.persist(contato);
	}

	@SuppressWarnings("unchecked")
	public List<Contato> lista() {
		System.out.println("Usando JPA");
//		A tabela contatos está mapeada pela Classe Contato
		return manager.createQuery("select c from Contato c").getResultList();
	}

	public void altera(Contato contato) {
		manager.merge(contato);
	}

	public void remove(Contato contato) {
		Contato contatoParaRemover = consultaPorId(contato.getId());
		manager.remove(contatoParaRemover);
	}

	public Contato consultaPorId(Long id) {
		return manager.find(Contato.class, id);
	}

	
}
