package br.com.caelum.agenda.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.agenda.modelo.Contato;

public class BuscaContatos {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
//		A tabela contatos está mapeada pela Classe Contato
		Query query = manager.createQuery("select c from Contato as c where c.nome = :paramNome");
		query.setParameter("paramNome", "Olaola");
		
		@SuppressWarnings("unchecked")
		List<Contato> lista = query.getResultList();
		
		for (Contato contato : lista) {
			System.out.println("Email: " + contato.getEmail());
		}
		manager.close();
	}
}
