package br.com.caelum.agenda.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.agenda.modelo.Contato;

public class AtualizaContato {
	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setId(58);
		contato.setNome("Pato Donald");
		contato.setEndereco("Rua do Pato Donald, 22");
		contato.setEmail("donald@pato.com");
		contato.setDataNascimento(Calendar.getInstance());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		manager.close();
	}
}
