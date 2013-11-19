package br.com.caelum.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.agenda.modelo.Usuario;

@Repository
public class UsuarioDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public boolean existeUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		Query query = manager.createQuery("from Usuario u where u.login = :paramLogin and u.senha = :paramSenha");
		query.setParameter("paramLogin", usuario.getLogin());
		query.setParameter("paramSenha", usuario.getSenha());
		
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();
		
		boolean encontrado = !lista.isEmpty();
		
		return encontrado;
	}
}
