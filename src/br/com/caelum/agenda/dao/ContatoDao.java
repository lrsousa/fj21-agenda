package br.com.caelum.agenda.dao;

import java.util.List;

import br.com.caelum.agenda.modelo.Contato;

public interface ContatoDao {
	void adiciona(Contato contato);
	List<Contato> lista();
	void altera(Contato contato);
	void remove(Contato contato);
	Contato consultaPorId(Long id);
}
