package br.com.caelum.agenda.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContato {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Olaola");
		contato.setEmail("olaola@olaola.com.br");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setEndereco("Rua do Ola, 22");
		
		//contato é o nome do persist com no persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		System.out.println("Contato: " + contato.getNome() + "Adicionado com sucesso.");
		
		manager.close();
	}
}
