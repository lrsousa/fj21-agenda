package br.com.caelum.agenda.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.agenda.modelo.Contato;

public class RemoveContato {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		Contato encontrado = manager.find(Contato.class, 54L);
		
		manager.getTransaction().begin();
		manager.remove(encontrado);
		manager.getTransaction().commit();
		
		System.out.println("Contato removido: " + encontrado.getNome());
		
		manager.close();
	}
}
