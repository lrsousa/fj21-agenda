package br.com.caelum.agenda.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.agenda.modelo.Contato;

public class CarregaContato {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		Contato encontrado = manager.find(Contato.class, 53L);
		System.out.println("Encontrado " + encontrado.getNome());
		
		manager.close();
	}
}
